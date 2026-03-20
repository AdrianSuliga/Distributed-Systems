import socket;

serverIP = "127.0.0.1"
serverPort = 9008
msg = "Ping Java Udp"

print('PYTHON UDP CLIENT')
client = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
client.bind(('localhost', 9010))
client.sendto(bytes(msg, 'cp1250'), (serverIP, serverPort))
buffer, _ = client.recvfrom(1024)
print("Received:", buffer)