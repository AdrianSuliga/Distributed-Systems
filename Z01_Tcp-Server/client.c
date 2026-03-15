#include "common.h"

static volatile int tcp_socket_fd = -1, udp_socket_fd = -1;

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

        printf("%s", buffer);
    }

    return NULL;
}

void* udp_receive(void *arg)
{
    struct sockaddr_in address = *((struct sockaddr_in*)arg);
    free(arg);

    socklen_t length = sizeof(address);
    char buffer[MAX_UDP_MSG_SIZE];

    while (1) {
        memset(buffer, 0, sizeof(buffer));

        int n = recvfrom(udp_socket_fd, buffer, sizeof(buffer), 0, (struct sockaddr*)&address, &length);

        if (n == -1) {
            close(udp_socket_fd);
            break;
        }

        printf("%s", buffer);
    }

    return NULL;
}

int main(int argc, char **argv)
{
    if (argc != 3) {
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
    struct sockaddr_in server_address;
    pthread_t tcp_receive_thread, udp_receive_thread;

    int *arg = malloc(sizeof(int));
    if (arg == NULL) {
        perror("malloc failed");
        return 1;
    }

    struct sockaddr_in *address = malloc(sizeof(struct sockaddr_in));
    if (address == NULL) {
        perror("malloc failed");
        return 1;
    }

    // Create TCP socket
    tcp_socket_fd = socket(AF_INET, SOCK_STREAM, 0);
    if (tcp_socket_fd == -1) {
        perror("Socket creation failed");
        free(arg);
        return 1;
    }

    // Create UDP socket
    udp_socket_fd = socket(AF_INET, SOCK_DGRAM, 0);
    if (udp_socket_fd == -1) {
        perror("Socket creation failed");
        free(arg);
        return 1;
    }

    memset(&server_address, 0, sizeof(server_address));

    // Assign IP and port
    server_address.sin_family = AF_INET;
    server_address.sin_addr.s_addr = htonl(INADDR_LOOPBACK);
    server_address.sin_port = htons(PORT);

    // Connect client TCP socket to the server socket
    ret = connect(tcp_socket_fd, (struct sockaddr*)&server_address, sizeof(server_address));
    if (ret != 0) {
        perror("Connecting to the server failed");
        free(arg);
        return 1;
    }

    // Connect client UDP socket to the server socket
    ret = connect(udp_socket_fd, (struct sockaddr*)&server_address, sizeof(server_address));
    if (ret != 0) {
        perror("Connecting to the server failed");
        free(arg);
        return 1;
    }

    // Start receiver thread to read messages from other clients
    *arg = tcp_socket_fd;
    ret = pthread_create(&tcp_receive_thread, NULL, tcp_receive, arg);
    if (ret != 0) {
        perror("pthread_create failed");
        free(arg);
        close(tcp_socket_fd);
    }

    ret = pthread_create(&udp_receive_thread, NULL, udp_receive, address);
    if (ret != 0) {
        perror("pthread_create failed");
        free(address);
        close(udp_socket_fd);
    }

    // Prepare buffers for user data
    char msg_buffer[MAX_TCP_MSG_SIZE + MAX_OVERHEAD_SIZE];
    char text_buffer[MAX_TCP_MSG_SIZE];

    while (1) {
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

        if (strlen(text_buffer) == 1) { // Only newline typed
            continue;
        }

        if (strlen(text_buffer) == 2 && text_buffer[0] == 'U') {
            sendto(udp_socket_fd, ascii_art, sizeof(ascii_art), 0, (struct sockaddr*)&server_address, sizeof(server_address));
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

    // End receiver thread
    pthread_cancel(tcp_receive_thread);
    pthread_cancel(udp_receive_thread);
    pthread_join(tcp_receive_thread, NULL);
    pthread_join(udp_receive_thread, NULL);
    close(tcp_socket_fd);
    close(udp_socket_fd);

    return 0;
}
