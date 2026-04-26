import sys
import os

sys.path.append(os.path.join(os.path.dirname(__file__), "generated"))

import grpc
import contract_pb2 as pb2
import contract_pb2_grpc as pb2_grpc

class GrpcClient:
    def __init__(self, host, port):
        self.channel = grpc.insecure_channel(f"{host}:{port}")
        self.test_stub = pb2_grpc.TestStub(self.channel)
        self.registry_stub = pb2_grpc.RegistryStub(self.channel)
    
    def shutdown(self):
        self.channel.close()

    def run(self):
        while True:
            line = input("===> ").strip().split(" ")
            cmd, args = line[0], line[1:]

            try:
                # TEST
                if cmd == "echo":
                    req = pb2.Empty()
                    res = self.test_stub.echo(req)
                    print(res.res)
                elif cmd == "add":
                    req = pb2.ArithmeticOpArguments(arg1=44, arg2=55)
                    res = self.test_stub.add(req)
                    print(res.res)

                # REGISTRY
                elif cmd == "list":
                    req = pb2.Empty()
                    res = self.registry_stub.listDevices(req)

                    print("================== LIGHT ==================")
                    for device in res.light_devices:
                        print("[", device.id, "|", device.name, "|", device.type, "]")
                    print("===========================================")
                    print()

                    print("================== CAMERA =================")
                    for device in res.camera_devices:
                        print("[", device.id, "|", device.name, "|", device.type, "]")
                    print("===========================================")
                    print()

                    print("================== FRIDGE =================")
                    for device in res.fridge_devices:
                        print("[", device.id, "|", device.name, "|", device.type, "]")
                    print("===========================================")
                    print()

                elif cmd == "exit":
                    break
                else:
                    print("???")
            except Exception as e:
                print("ERROR:", e)
        
        self.shutdown()

if __name__ == "__main__":
    client = GrpcClient("127.0.0.5", 50051)
    client.run()
