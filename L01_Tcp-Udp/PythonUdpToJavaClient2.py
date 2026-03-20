import socket;

serverIP = "127.0.0.1"
serverPort = 9008
msg = (300).to_bytes(4, byteorder='little')

print('PYTHON UDP TO-JAVA CLIENT')
client = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
client.sendto(msg, (serverIP, serverPort))
buffer, address = client.recvfrom(1024)
print("Received", int.from_bytes(buffer, byteorder='little'))