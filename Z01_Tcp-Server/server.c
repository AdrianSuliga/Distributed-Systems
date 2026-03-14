#include <stdio.h>
#include <netdb.h>
#include <netinet/in.h> 
#include <stdlib.h> 
#include <string.h> 
#include <sys/socket.h> 
#include <sys/types.h> 
#include <unistd.h>
#include <pthread.h>
#include <signal.h>

#define MAX_CLIENTS_CONNECTED 32
#define MAX_CLIENTS_QUEUED 16
#define MAX_MSG_SIZE 256
#define MAX_NICK_SIZE 16
#define MAX_OVERHEAD_SIZE (MAX_NICK_SIZE + 4)
#define PORT 6060

struct client_t {
    pthread_t client_thread;
    int alive;
    int connection_fd;
};

static struct client_t clients[MAX_CLIENTS_CONNECTED];
static volatile sig_atomic_t server_running = 1;
static volatile int socket_fd = -1;

static int find_dead_client(struct client_t *clients, size_t length)
{
    for (size_t i = 0; i < length; ++i) {
        if (!clients[i].alive) {
            return i;
        }
    }

    return -1;
}

static void print_ipv4(uint32_t address)
{
    uint8_t bytes[4] = {
        (address & (0xFF << 24)) >> 24,
        (address & (0xFF << 16)) >> 16,
        (address & (0xFF << 8)) >> 8,
        address & 0xFF
    };
    printf("%u.%u.%u.%u", bytes[0], bytes[1], bytes[2], bytes[3]);
}

void* client_thread(void *arg)
{
    int client_idx = *((int*)arg);
    free(arg);

    // Prepare buffer for reading client data
    char buffer[MAX_MSG_SIZE + MAX_OVERHEAD_SIZE];

    while (1) {
        // Read n chars
        int n = read(clients[client_idx].connection_fd, buffer, sizeof(buffer));

        // If client disconnected, close the connection
        if (n <= 0) {
            close(clients[client_idx].connection_fd);
            clients[client_idx].alive = 0;
            break;
        }

        // If client wants to exit, disconnect it as well
        if (strncmp(buffer, "EXIT", 4) == 0) {
            close(clients[client_idx].connection_fd);
            clients[client_idx].alive = 0;
            break;
        }

        // Write message to other clients
        for (size_t i = 0; i < MAX_CLIENTS_CONNECTED; i++) {
            if (clients[i].alive && i != client_idx) {
                write(clients[i].connection_fd, buffer, n);
            }
        }

        memset(buffer, 0, sizeof(buffer));
    }

    return NULL;
}

void sigint_handler(int _)
{
    server_running = 0;
    // In main function calling accept() is blocking,
    // closing socket in this handler makes accept 
    // return error.
    close(socket_fd);
}

int main(int argc, char **argv)
{
    int ret;
    struct sockaddr_in server_address, client_address;

    // No connected clients in the beginning
    for (size_t i = 0; i < MAX_CLIENTS_CONNECTED; ++i) {
        clients[i].alive = 0;
    }

    // Handle Ctrl+C signal to safely terminate server
    signal(SIGINT, sigint_handler);

    // Create TCP socket
    socket_fd = socket(AF_INET, SOCK_STREAM, 0);
    if (socket_fd == -1) {
        perror("Socket creation failed\n");
        return 1;
    }

    memset(&server_address, 0, sizeof(server_address));

    // Assign IP and port
    server_address.sin_family = AF_INET;
    server_address.sin_addr.s_addr = htonl(INADDR_LOOPBACK);
    server_address.sin_port = htons(PORT);

    // Bind socket to IP
    ret = bind(socket_fd, (struct sockaddr*)&server_address, sizeof(server_address));
    if (ret != 0) {
        perror("Socket bind failed\n");
        return 1;
    }

    // Listen for clients on server socket
    ret = listen(socket_fd, MAX_CLIENTS_QUEUED);
    if (ret != 0) {
        perror("Listen on socket failed\n");
        return 1;
    }

    printf("Socket listening on ");
    print_ipv4(INADDR_LOOPBACK);
    printf(":%d\n", PORT);

    while (server_running) {
        // Find dead client to use
        int free_client_slot = find_dead_client(clients, MAX_CLIENTS_CONNECTED);

        if (free_client_slot == -1) {
            printf("Max number of clients reached\n");

            while (server_running && find_dead_client(clients, MAX_CLIENTS_CONNECTED) == -1) {
                sleep(1);
            }

            continue;
        }

        socklen_t length = sizeof(client_address);
        
        // Accept connection from new client
        int client_fd = accept(socket_fd, (struct sockaddr*)&client_address, &length);

        if (client_fd == -1) {
            if (!server_running) {
                break;
            }

            perror("Accept failed");
            continue;
        }

        clients[free_client_slot].connection_fd = client_fd;
        clients[free_client_slot].alive = 1;

        int *arg = malloc(sizeof(int));
        *arg = free_client_slot;

        // Start new thread for each client
        ret = pthread_create(&clients[free_client_slot].client_thread, NULL, client_thread, arg);
        if (ret != 0) {
            perror("pthread_create failed");
            close(client_fd);
            clients[free_client_slot].alive = 0;
            free(arg);
        }
    }

    // Cancel every running client thread
    for (size_t i = 0; i < MAX_CLIENTS_CONNECTED; ++i) {
        if (clients[i].alive) {
            pthread_cancel(clients[i].client_thread);
            pthread_join(clients[i].client_thread, NULL);
            close(clients[i].connection_fd);
        }
    }

    if (socket_fd != -1) {
        close(socket_fd);
    }

    return 0;
}
