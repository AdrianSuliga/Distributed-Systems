#!/bin/bash

g++ cpp-side/client.cpp -std=c++11 -lIce -lpthread -o cpp-side/bin/client

./cpp-side/bin/client
