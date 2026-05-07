#!/bin/bash

g++ client.cpp -std=c++11 -lIce -lpthread -o bin/client

./bin/client
