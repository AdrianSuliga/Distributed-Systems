#include <stdio.h>
#include <arpa/inet.h>
#include <netdb.h>
#include <stdlib.h>
#include <string.h>
#include <strings.h>
#include <sys/socket.h>
#include <unistd.h>
#include <pthread.h>

#define MAX_MSG_SIZE 256
#define MAX_NICK_SIZE 16
#define MAX_OVERHEAD_SIZE (MAX_NICK_SIZE + 4)
#define PORT 6060

void* client_receive(void *arg)
{
    int socket_fd = *((int*)arg);

    return NULL;
}

int main(int argc, char **argv)
{
    if (argc != 2) {
        printf("Unexpected number of arguments\n");
        printf("Got %d, expected 2\n", argc);
        printf("./client <CLIENT_NICK>\n");
        return 1;
    }

    if (strlen(argv[1]) > MAX_NICK_SIZE) {
        printf("Your nick cannot be longer than %d\n", MAX_NICK_SIZE);
        return 1;
    }

    char* client_nick = argv[1];
    int ret, socket_fd;
    struct sockaddr_in server_address;
    pthread_t receive_thread;

    int *arg = malloc(sizeof(int));
    if (arg == NULL) {
        perror("malloc failed\n");
        return 1;
    }

    // Create TCP socket
    socket_fd = socket(AF_INET, SOCK_STREAM, 0);
    if (socket_fd == -1) {
        perror("Socket cretion failed\n");
        free(arg);
        return 1;
    }

    memset(&server_address, 0, sizeof(server_address));

    // Assign IP and port
    server_address.sin_family = AF_INET;
    server_address.sin_addr.s_addr = htonl(INADDR_LOOPBACK);
    server_address.sin_port = htons(PORT);

    // Connect client socket to the server socket
    ret = connect(socket_fd, (struct sockaddr*)&server_address, sizeof(server_address));
    if (ret != 0) {
        perror("Connecting to the server failed");
        free(arg);
        return 1;
    }

    ret = pthread_create(&receive_thread, NULL, client_receive, arg);

    // Prepare buffers for user data
    char msg_buffer[MAX_MSG_SIZE + MAX_OVERHEAD_SIZE];
    char text_buffer[MAX_MSG_SIZE];

    while (1) {
        // Zero all buffers
        memset(text_buffer, 0, sizeof(text_buffer));
        memset(msg_buffer, 0, sizeof(msg_buffer));

        printf("[%s]: ", client_nick);

        char c;
        int n = 0;

        // Read user data until \n or EOF appears
        while (n < MAX_MSG_SIZE) {
            c = getchar();
            
            if (c == EOF) {
                printf("Input closed\n");
                break;
            }

            text_buffer[n++] = c;
            
            if (c == '\n') {
                break;
            }
        }

        if (strncmp(text_buffer, "EXIT", 4) == 0) {
            write(socket_fd, text_buffer, strlen(text_buffer));
            printf("Disconnecting...\n");
            break;
        }

        // Prepare final message for sending in the form of [NICK]: TEXT
        snprintf(msg_buffer, sizeof(msg_buffer), "[%s]: %s", client_nick, text_buffer);

        // Write to server
        ret = write(socket_fd, msg_buffer, sizeof(msg_buffer));
        if (ret <= 0) {
            perror("Server disconnected\n");
            break;
        }
    }

    close(socket_fd);
    if (arg != NULL) {
        free(arg);
    }

    return 0;
}
