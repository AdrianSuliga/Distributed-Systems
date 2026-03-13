#include <stdio.h>
#include <netdb.h> 
#include <netinet/in.h> 
#include <stdlib.h> 
#include <string.h> 
#include <sys/socket.h> 
#include <sys/types.h> 
#include <unistd.h>

#define PORT 6060
#define MAX_MSG_SIZE 256

int main(int argc, char **argv)
{
    int ret, socket_fd, connection_fd, length;
    struct sockaddr_in server_address;

    // Create TCP socket
    socket_fd = socket(AF_INET, SOCK_STREAM, 0);
    if (socket_fd == -1) {
        perror("Socket creation failed\n");
        return 1;
    }

    bzero(&server_address, sizeof(server_address));

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

    while (1) {
        //ret = listen(socket_fd, )
    }

    return 0;
}