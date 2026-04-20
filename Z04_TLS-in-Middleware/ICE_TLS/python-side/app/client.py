import sys
import os

sys.path.append(os.path.abspath(os.path.join(os.path.dirname(__file__), "../generated")))

import Ice

import Contract

with Ice.initialize(sys.argv) as communicator:
    base = communicator.stringToProxy("contract/contract:tcp -h 127.0.0.2 -p 10000")
    obj = Contract.CalculatorPrx.checkedCast(base)

    if (obj == None):
        print("Obj is none")
        raise Exception("ICE object is None")

    print("Connection established, enter command:")

    while True:
        cmd = input("==> ")
        if cmd == "add":
            r = obj.add(6, 7)
            print(r)
        elif cmd == "addAsyn":
            pass
        elif cmd == "x":
            break
    
    print("Client shuts down")
