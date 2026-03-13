CC = gcc
CFLAGS = 

.PHONY: all clean

all:
	make server
	make client

server: server.c
	${CC} $^ -o $@

client: client.c
	${CC} $^ -o $@

clean:
	rm server client
