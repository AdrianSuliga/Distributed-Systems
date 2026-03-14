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
#define MAX_MSG_SIZE 256
#define MAX_NICK_SIZE 16
#define MAX_OVERHEAD_SIZE (MAX_NICK_SIZE + 4)
#define PORT 6060

#endif /* COMMON_H */
