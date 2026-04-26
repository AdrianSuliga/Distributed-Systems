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

                    if len(args) != 2:
                        print("Correct Usage: add <n1> <n2>")
                        continue

                    req = pb2.ArithmeticOpArguments(arg1=int(args[0]), arg2=int(args[1]))
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

                elif cmd == "help":
                    print("================== DEVICE =================")
                    print(" - turnOn <id>")
                    print(" - turnOff <id>")
                    print("===========================================")
                    print()

                    print("============== COMMON LIGHT ===============")
                    print(" - toggle <id>")
                    print(" - setBrightness <id> <brightness>")
                    print(" - getPowerUsage <id>")
                    print(" - scheduleOn <id> <yyyy:mm:dd hh:mm:ss>")
                    print(" - scheduleOff <id> <yyyy:mm:dd hh:mm:ss>")
                    print("===========================================")
                    print()

                    print("=============== RGB LIGHT =================")
                    print(" - setColor <id> <red> <green> <blue>")
                    print(" - setHue <id> <hue>")
                    print(" - setEffect <id> <0|1|2>")
                    print("===========================================")
                    print()

                    print("=============== LED LIGHT =================")
                    print(" - setAnimation <id> <0|1|2|3>")
                    print("===========================================")
                    print()

                    print("============= OUTDOOR LIGHT ===============")
                    print(" - setMotionDetection <id> <0|1|2>")
                    print(" - setMotionSensitivity <id> <0|1|2>")
                    print(" - setWeatherMode <id> <0|1>")
                    print("===========================================")
                    print()

                    print("============ COMMON MONITORING ============")
                    print(" - move <id> <pan> <tilt> <zoom>")
                    print(" - takePhoto <id> <0|1|2>")
                    print(" - takePhotos <id> [<0|1|2>, ...]")
                    print(" - startRecording <id>")
                    print(" - stopRecording <id>")
                    print(" - configurePatrol <id> [(pan, tilt, zoom, stayTime), ...] [hh:mm:ss, ...]")
                    print("===========================================")
                    print()

                    print("============ INDOOR MONITORING ============")
                    print(" - setPrivacyMode <id> <0|1|2|3>")
                    print(" - playAudio <id> <url> <repeat>")
                    print("===========================================")
                    print()

                    print("=========== OUTDOOR MONITORING ============")
                    print(" - setWeatherMode <id> <0|1>")
                    print("===========================================")
                    print()

                    print("=========== THERMAL MONITORING ============")
                    print(" - disableTempAlarm <id>")
                    print(" - enableTempAlarm <id> <threshold>")
                    print(" - setTempRange <id> <min> <max>")
                    print("===========================================")

                # LIGHT
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
