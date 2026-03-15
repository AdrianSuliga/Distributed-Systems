#ifndef COMMON_H
#define COMMON_H

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
#include <arpa/inet.h>
#include <strings.h>

#define MAX_CLIENTS_CONNECTED 16
#define MAX_TCP_MSG_SIZE 256
#define MAX_NICK_SIZE 16
#define MAX_OVERHEAD_SIZE (MAX_NICK_SIZE + 4)

#define MAX_UDP_MSG_SIZE 2560

#define MULTICAST_ADDR "239.0.0.1"

#define MULTICAST_PORT 6061
#define PORT 6060

struct udp_message {
    int client_id;
    char message[MAX_UDP_MSG_SIZE];
};

#endif /* COMMON_H */
