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
        self.device_stub = pb2_grpc.DeviceStub(self.channel)
        self.light_stub = pb2_grpc.LightStub(self.channel)
        self.advanced_light_stub = pb2_grpc.AdvancedLightStub(self.channel)
        self.monitoring_stub = pb2_grpc.MonitoringStub(self.channel)

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
                    print(" - turnON <id>")
                    print(" - turnOFF <id>")
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

                # DEVICE
                elif cmd == "turnON":
                    req = pb2.DeviceId(id=int(args[0]))
                    res = self.device_stub.turnON(req)
                    print(res.status)

                elif cmd == "turnOFF":
                    req = pb2.DeviceId(id=int(args[0]))
                    res = self.device_stub.turnOFF(req)
                    print(res.status)

                # LIGHT
                elif cmd == "toggle":
                    req = pb2.DeviceId(id=int(args[0]))
                    res = self.light_stub.Toggle(req)
                    print(res.status)

                elif cmd == "setBrightness":
                    req = pb2.BrigthnessRequest(
                        id=int(args[0]),
                        brightness=int(args[1])
                    )
                    res = self.light_stub.setBrightness(req)
                    print(res.status)

                elif cmd == "getPowerUsage":
                    req = pb2.DeviceId(id=int(args[0]))
                    res = self.light_stub.getPowerUsage(req)

                    print("Device:", res.id)
                    for stat in res.stats:
                        t = stat.time
                        print(
                            f"{t.year:04}-{t.month:02}-{t.day:02} "
                            f"{t.hour:02}:{t.minute:02}:{t.second:02} | "
                            f"{stat.consumption} kWh"
                        )

                elif cmd == "scheduleOn":
                    date_part = args[1]
                    time_part = args[2]

                    y, m, d = map(int, date_part.split(":"))
                    hh, mm, ss = map(int, time_part.split(":"))

                    req = pb2.ScheduleRequest(
                        id=int(args[0]),
                        time=pb2.Time(
                            year=y,
                            month=m,
                            day=d,
                            hour=hh,
                            minute=mm,
                            second=ss
                        )
                    )

                    res = self.light_stub.scheduleON(req)
                    print(res.status)

                elif cmd == "scheduleOff":
                    date_part = args[1]
                    time_part = args[2]

                    y, m, d = map(int, date_part.split(":"))
                    hh, mm, ss = map(int, time_part.split(":"))

                    req = pb2.ScheduleRequest(
                        id=int(args[0]),
                        time=pb2.Time(
                            year=y,
                            month=m,
                            day=d,
                            hour=hh,
                            minute=mm,
                            second=ss
                        )
                    )

                    res = self.light_stub.scheduleOFF(req)
                    print(res.status)

                # ADVANCED LIGHT
                elif cmd == "setColor":
                    req = pb2.RGBRequest(
                        id=int(args[0]),
                        red=int(args[1]),
                        green=int(args[2]),
                        blue=int(args[3])
                    )
                    res = self.advanced_light_stub.setRGB(req)
                    print(pb2.StatusEnum.Name(res.status))

                elif cmd == "setHue":
                    req = pb2.HueRequest(
                        id=int(args[0]),
                        hue=int(args[1])
                    )
                    res = self.advanced_light_stub.setHue(req)
                    print(pb2.StatusEnum.Name(res.status))

                elif cmd == "setEffect":
                    req = pb2.EffectRequest(
                        id=int(args[0]),
                        effect=pb2.Effect.Value(args[1])
                    )
                    res = self.advanced_light_stub.setEffect(req)
                    print(pb2.StatusEnum.Name(res.status))

                elif cmd == "setAnimation":
                    req = pb2.AnimationRequest(
                        id=int(args[0]),
                        animation=pb2.Animation.Value(args[1])
                    )
                    res = self.advanced_light_stub.setStripAnimation(req)
                    print(pb2.StatusEnum.Name(res.status))

                elif cmd == "setMotionDetection":
                    req = pb2.MotionRequest(
                        id=int(args[0]),
                        mode=pb2.DetectionMode.Value(args[1])
                    )
                    res = self.advanced_light_stub.setMotionDetecion(req)
                    print(pb2.StatusEnum.Name(res.status))

                elif cmd == "setMotionSensitivity":
                    req = pb2.SensitivityRequest(
                        id=int(args[0]),
                        mode=pb2.SensitivityMode.Value(args[1])
                    )
                    res = self.advanced_light_stub.setMotionSensitivity(req)
                    print(pb2.StatusEnum.Name(res.status))

                elif cmd == "setWeatherMode":
                    req = pb2.WeatherRequest(
                        id=int(args[0]),
                        enabled=bool(int(args[1]))
                    )
                    res = self.advanced_light_stub.setWeatherMode(req)
                    print(pb2.StatusEnum.Name(res.status))

                # MONITORING
                elif cmd == "move":
                    req = pb2.MoveRequest(
                        id=int(args[0]),
                        pan=int(args[1]),
                        tilt=int(args[2]),
                        zoom=int(args[3])
                    )
                    res = self.monitoring_stub.move(req)
                    print(pb2.StatusEnum.Name(res.status))

                elif cmd == "takePhoto":
                    req = pb2.CaptureOneRequest(
                        id=int(args[0]),
                        format=pb2.ImgFormat.Value(args[1])
                    )

                    res = self.monitoring_stub.captureImage(req)

                    print("URL:", res.url)
                    print("Width:", res.width)
                    print("Height:", res.height)
                    print("Size:", res.size)

                elif cmd == "takePhotos":
                    device_id = int(args[0])

                    formats = []

                    for fmt in args[1:]:
                        formats.append(pb2.ImgFormat.Value(fmt))

                    req = pb2.CaptureManyRequest(
                        id=device_id,
                        formats=formats
                    )

                    res = self.monitoring_stub.captureImages(req)

                    for img in res.images:
                        print("URL:", img.url)
                        print("Width:", img.width)
                        print("Height:", img.height)
                        print("Size:", img.size)
                        print()

                elif cmd == "startRecording":
                    req = pb2.DeviceId(id=int(args[0]))
                    res = self.monitoring_stub.startRecording(req)
                    print(pb2.StatusEnum.Name(res.status))

                elif cmd == "stopRecording":
                    req = pb2.DeviceId(id=int(args[0]))
                    res = self.monitoring_stub.endRecording(req)

                    print("URL:", res.url)
                    print("Length:", res.length)
                    print("Size:", res.size)

                elif cmd == "configurePatrol":
                    device_id = int(args[0])

                    # example:
                    # configurePatrol 5 0,0,1,10 30,10,2,5 12:00:00 18:00:00

                    points = []
                    active = []

                    parsing_times = False

                    for token in args[1:]:

                        if ":" in token and token.count(":") == 2:
                            parsing_times = True

                        if not parsing_times:
                            p = token.split(",")

                            points.append(
                                pb2.PatrolPoint(
                                    pan=int(p[0]),
                                    tilt=int(p[1]),
                                    zoom=int(p[2]),
                                    stayTime=int(p[3])
                                )
                            )
                        else:
                            hh, mm, ss = map(int, token.split(":"))

                            active.append(
                                pb2.Time(
                                    hour=hh,
                                    minute=mm,
                                    second=ss
                                )
                            )

                    req = pb2.PatrolRequest(
                        id=device_id,
                        points=points,
                        active=active
                    )

                    res = self.monitoring_stub.configurePatrol(req)
                    print(pb2.StatusEnum.Name(res.status))

                # ADVANCED MONITORING
                

                # OTHER
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
