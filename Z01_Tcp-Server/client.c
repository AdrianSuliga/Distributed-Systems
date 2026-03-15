#include "common.h"

static volatile int tcp_socket_fd = -1, udp_socket_fd = -1, 
                    multicast_socket_fd = -1, client_id = -1,
                    client_running = 1;

static char udp_init[] = "INIT";
static char ascii_art[] = 
"                                          \n"
"                                       ^`'.\n"
"                                       ^   `'.\n"
"             (                         ^      `'.\n"
"           )  )        \\/              ^         `'.\n"
"         (   ) @       /^              ^            `'.\n"
"       )  )) @@  )    /  ^             ^               `'.\n"
"      ( ( ) )@@      /    ^            ^                  `'.\n"
"    ))  ( @@ @ )    /      ^           ^                     `'.\n"
"   ( ( @@@@@(@     /       |\\_/|,      ^                        `'.\n"
"  )  )@@@(@@@     /      _/~/~/~|C     ^                           `'.\n"
"((@@@(@@@@@(     /     _(@)~(@)~/\\C    ^                              `'.\n"
"  ))@@@(@@)@@   /     /~/~/~/~/`\\~`C   ^             __.__               `'.\n"
"   )@@@@(@@)@@@(     (o~/~o)^,) \\~ \\C  ^          .' -_'-'\"...             `.\n"
"    ( (@@@)@@@(@@@@@@_~^~^~,-/\\~ \\~ \\C/^        /`-~^,-~-`_~-^`;_           `.\n"
"      @ )@@@(@@@@@@@   \\^^^/  (`^\\.~^ C^.,  /~^~^~^/_^-_`~-`~-~^\\- /`'-./`'-. ;\n"
"       (@ (@@@@(@@      `''  (( ~  .` .,~^~^-`-^~`/'^`-~ _`~-`_^-~\\         ^^\n"
"           @jgs@             (((` ~ .-~-\\ ~`-_~`-/_-`~ `- ~-_- `~`;\n"
"          /                 /~((((` . ~-~\\` `  ~ |:`-_-~_~`  ~ _`-`;\n"
"         /                 /~-((((((`.\\-~-\\ ~`-`~^\\- ^_-~ ~` -_~-_`~`;\n"
"        /                 /-~-/(((((((`\\~-~\\~`^-`~`\\ -~`~\\-^ -_~-_`~-`;\n"
"       /                 /~-~/  `((((((|-~-|((`.-~.`Y`_,~`\\ `,- ~-_`~-`;\n"
"      /              ___/-~-/     `""""|~-~|\"''    /~-^ .'    `:~`-_`~-~`;\n"
"     /         _____/  /~-~/           |-~-|      /-~-~.`      `:~^`-_`^-:\n"
"    /    _____/        ((((            ((((      (((((`           `:~^-_~-`;\n"
"    \\___/                                                          `:_^-~`;\n"
"                                                                    `:~-^`:\n"
"                                                                  ,`~-~`,`\n"
"                                                                 ,\"`~.,'\n"
"                                                               ,\"-`,\"`\n"
"                                                             ,\"_`,\"\n"
"                                                            ,\",\"`\n"
"                                                         ;~-~_~~;\n"
"                                                          '. ~.'\n";

void* tcp_receive(void *_)
{
    char buffer[MAX_TCP_MSG_SIZE + MAX_OVERHEAD_SIZE];

    while (1) {
        memset(buffer, 0, sizeof(buffer));

        int n = read(tcp_socket_fd, buffer, sizeof(buffer));

        if (n <= 0) {
            close(tcp_socket_fd);
            break;
        }

        if (!strncmp(buffer, "ID", 2)) {
            client_id = buffer[2];
            continue;
        }

        printf("%s", buffer);
    }

    return NULL;
}

void* udp_receive(void *_)
{
    char buffer[MAX_UDP_MSG_SIZE];

    while (1) {
        memset(buffer, 0, sizeof(buffer));

        int n = recv(udp_socket_fd, buffer, sizeof(buffer), 0);

        if (n == -1) {
            close(udp_socket_fd);
            break;
        }

        printf("%s", buffer);
    }

    return NULL;
}

void* multicast_receive(void *_)
{
    char buffer[sizeof(struct udp_message)];

    while (1) {
        memset(buffer, 0, sizeof(buffer));

        int n = recv(multicast_socket_fd, buffer, sizeof(buffer), 0);

        if (n == -1) {
            close(multicast_socket_fd);
            break;
        }

        struct udp_message msg;
        memcpy(&msg, buffer, sizeof(msg));

        if (msg.client_id != client_id) {
            printf("%s", msg.message);
        }
    }

    return NULL;
}

void sigint_handler(int _)
{
    client_running = 0;
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
    int ret;
    struct sockaddr_in server_address, multicast_address;
    pthread_t tcp_receive_thread, udp_receive_thread, multicast_receive_thread;

    // Handle Ctrl+C signal to safely terminate client
    signal(SIGINT, sigint_handler);

    // Create TCP socket
    tcp_socket_fd = socket(AF_INET, SOCK_STREAM, 0);
    if (tcp_socket_fd == -1) {
        perror("Socket creation failed");
        return 1;
    }

    // Create UDP socket
    udp_socket_fd = socket(AF_INET, SOCK_DGRAM, 0);
    if (udp_socket_fd == -1) {
        perror("Socket creation failed");
        return 1;
    }

    // Create UDP multicast socket
    multicast_socket_fd = socket(AF_INET, SOCK_DGRAM, 0);
    if (multicast_socket_fd == -1) {
        perror("Socket creation failed");
        return 1;
    }

    memset(&server_address, 0, sizeof(server_address));
    memset(&multicast_address, 0, sizeof(multicast_address));

    // Assign IP and port
    server_address.sin_family = AF_INET;
    server_address.sin_addr.s_addr = htonl(INADDR_LOOPBACK);
    server_address.sin_port = htons(PORT);

    multicast_address.sin_family = AF_INET;
    multicast_address.sin_addr.s_addr = inet_addr(MULTICAST_ADDR);
    multicast_address.sin_port = htons(MULTICAST_PORT);

    // Connect client TCP socket to the server socket
    ret = connect(tcp_socket_fd, (struct sockaddr*)&server_address, sizeof(server_address));
    if (ret != 0) {
        perror("Connecting to the server failed");
        return 1;
    }

    // Connect client UDP socket to the server socket
    ret = connect(udp_socket_fd, (struct sockaddr*)&server_address, sizeof(server_address));
    if (ret != 0) {
        perror("Connecting to the server failed");
        return 1;
    }

    // Setup multicast
    int reuse = 1;
    setsockopt(multicast_socket_fd, SOL_SOCKET, SO_REUSEADDR, &reuse, sizeof(reuse));

    struct sockaddr_in local;
    memset(&local, 0, sizeof(local));
    local.sin_family = AF_INET;
    local.sin_addr.s_addr = htonl(INADDR_ANY);
    local.sin_port = htons(MULTICAST_PORT);

    ret = bind(multicast_socket_fd, (struct sockaddr*)&local, sizeof(local));
    if (ret != 0) {
        perror("Binding failed");
        return 1;
    }

    struct ip_mreq mreq;
    mreq.imr_multiaddr.s_addr = inet_addr(MULTICAST_ADDR);
    mreq.imr_interface.s_addr = htonl(INADDR_ANY);
    setsockopt(multicast_socket_fd, IPPROTO_IP, IP_ADD_MEMBERSHIP, &mreq, sizeof(mreq));

    // Start receiver thread to read messages from other clients
    ret = pthread_create(&tcp_receive_thread, NULL, tcp_receive, NULL);
    if (ret != 0) {
        perror("pthread_create failed");
        close(tcp_socket_fd);
    }

    // Wait for assigning proper ID
    while (client_id == -1);

    // Start UDP receive thread
    ret = pthread_create(&udp_receive_thread, NULL, udp_receive, NULL);
    if (ret != 0) {
        perror("pthread_create failed");
        close(udp_socket_fd);
    }

    // Start multicast receive thread
    ret = pthread_create(&multicast_receive_thread, NULL, multicast_receive, NULL);
    if (ret != 0) {
        perror("pthread_create failed");
        close(multicast_socket_fd);
    }

    // Send UDP init message
    struct udp_message msg;
    msg.client_id = client_id;
    memcpy(msg.message, udp_init, sizeof(udp_init));
    send(udp_socket_fd, &msg, sizeof(msg.client_id) + sizeof(udp_init), 0);

    // Prepare buffers for user data
    char msg_buffer[MAX_TCP_MSG_SIZE + MAX_OVERHEAD_SIZE];
    char text_buffer[MAX_TCP_MSG_SIZE];

    while (client_running) {
        // Zero all buffers
        memset(text_buffer, 0, sizeof(text_buffer));
        memset(msg_buffer, 0, sizeof(msg_buffer));

        int c, n = 0;

        // Read user data until \n or EOF appears
        while (n < MAX_TCP_MSG_SIZE) {
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

        // Let the server know when client wants to exit
        if (!strncmp(text_buffer, "EXIT", 4)) {
            write(tcp_socket_fd, text_buffer, strlen(text_buffer));
            printf("Disconnecting...\n");
            break;
        }

        // Ignore when only newline typed
        if (strlen(text_buffer) == 1) {
            continue;
        }

        // Send UDP data to server when U is pressed
        if (strlen(text_buffer) == 2 && text_buffer[0] == 'U') {
            struct udp_message msg;
            msg.client_id = client_id;
            memcpy(msg.message, ascii_art, sizeof(ascii_art));
            send(udp_socket_fd, &msg, sizeof(msg.client_id) + sizeof(ascii_art), 0);
            continue;
        }

        // Send UDP data to multicast when M is pressed
        if (strlen(text_buffer) == 2 && text_buffer[0] == 'M') {
            struct udp_message msg;
            msg.client_id = client_id;
            memcpy(msg.message, ascii_art, sizeof(ascii_art));
            sendto(multicast_socket_fd, &msg, sizeof(msg.client_id) + sizeof(ascii_art), 0, 
                   (struct sockaddr*)&multicast_address, sizeof(multicast_address));
            continue;
        }

        // Prepare final message for sending in the form of [NICK]: TEXT
        snprintf(msg_buffer, sizeof(msg_buffer), "[%s]: %s", client_nick, text_buffer);

        // Write to server
        ret = write(tcp_socket_fd, msg_buffer, strlen(msg_buffer));
        if (ret <= 0) {
            perror("Server disconnected");
            break;
        }
    }

    // End receiver threads
    pthread_cancel(tcp_receive_thread);
    pthread_cancel(udp_receive_thread);
    pthread_cancel(multicast_receive_thread);

    pthread_join(tcp_receive_thread, NULL);
    pthread_join(udp_receive_thread, NULL);
    pthread_join(multicast_receive_thread, NULL);

    close(tcp_socket_fd);
    close(udp_socket_fd);
    close(multicast_socket_fd);

    return 0;
}
