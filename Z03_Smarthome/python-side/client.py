import sys
import os

sys.path.append(os.path.join(os.path.dirname(__file__), "generated"))

import grpc
import test_pb2 as pb2
import test_pb2_grpc as pb2_grpc

class GrpcClient:
    def __init__(self, host, port):
        self.channel = grpc.insecure_channel(f"{host}:{port}")
        self.calc_stub = pb2_grpc.TestStub(self.channel)
    
    def shutdown(self):
        self.channel.close()

    def run(self):
        while True:
            line = input("===> ").strip()

            try:
                if line == "echo":
                    req = pb2.Empty()
                    res = self.calc_stub.Echo(req)
                    print(res.res)
                elif line == "add":
                    req = pb2.ArithmeticOpArguments(arg1=44, arg2=55)
                    res = self.calc_stub.Add(req)
                    print(res.res)
                elif line == "exit":
                    break
                else:
                    print("???")
            except Exception as e:
                print("ERROR:", e)
        
        self.shutdown()

if __name__ == "__main__":
    client = GrpcClient("127.0.0.5", 50051)
    client.run()
