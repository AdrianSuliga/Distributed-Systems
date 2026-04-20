#include <Ice/Ice.h>
#include <iostream>
#include <string>
#include <vector>

int main(int argc, char *argv[])
{
    int status = 0;
    Ice::CommunicatorPtr communicator;

    try {
        communicator = Ice::initialize(argc, argv);

        Ice::ObjectPrx base = communicator->stringToProxy("contract/registry:tcp -h 127.0.0.1 -p 10000");

        std::cout << "Connection established, enter command:\n";

        std::string cmd;

        while (true) {
            std::cout << "==> ";
            std::getline(std::cin, cmd);

            std::vector<Ice::Byte> inParams, outParams;

            if (cmd == "echo") {

                try {

                    if (base->ice_invoke(cmd, Ice::Idempotent, inParams, outParams)) {
                        Ice::InputStream in(base->ice_getCommunicator(), outParams);
                        std::string result = "";

                        in.startEncapsulation();
                        in.read(result);
                        in.endEncapsulation();

                        std::cout << result << '\n';
                    } else {
                        std::cerr << "echo invocation failed\n";
                    }

                } catch (const Ice::LocalException &ex) {
                    std::cout << "Local exception: " << ex << std::endl;
                }

            } else if (cmd == "net") {

                try {

                    Ice::OutputStream out(base->ice_getCommunicator());

                    out.startEncapsulation();
                    out.write(8000);
                    out.write(23);
                    out.endEncapsulation();

                    std::pair<const Ice::Byte*, const Ice::Byte*> data = out.finished();
                    std::vector<Ice::Byte> inParams(data.first, data.second);

                    if (base->ice_invoke(cmd, Ice::Idempotent, inParams, outParams)) {
                        Ice::InputStream in(base->ice_getCommunicator(), outParams);

                        double result = 0.0;

                        in.startEncapsulation();
                        in.read(result);
                        in.endEncapsulation();

                        std::cout << result << '\n';
                    } else {
                        std::cerr << "add invocation failed\n";
                    }

                } catch (const Ice::LocalException &ex) {
                    std::cout << "Local exception: " << ex << std::endl;
                }

            } else if (cmd == "describe") {

                std::vector<int> salaryList = {4000, 5000, 5600, 6800};

                try {

                    Ice::OutputStream out(base->ice_getCommunicator());

                    out.startEncapsulation();
                    out.write("Jan");
                    out.write("Kowalski");
                    out.write("Kawiory 23, 123-01 Kraków");
                    out.write(40);
                    out.write(7500);
                    out.write(salaryList);
                    out.endEncapsulation();

                    std::pair<const Ice::Byte*, const Ice::Byte*> data = out.finished();
                    std::vector<Ice::Byte> inParams(data.first, data.second);

                    if (base->ice_invoke(cmd, Ice::Idempotent, inParams, outParams)) {
                        Ice::InputStream in(base->ice_getCommunicator(), outParams);

                        std::string description = "";
                        double avg_salary = 0.0;

                        in.startEncapsulation();
                        in.read(description);
                        in.read(avg_salary);
                        in.endEncapsulation();

                        std::cout << description << '\n';
                        std::cout << "AVG SALARY: " << avg_salary << '\n';
                    } else {
                        std::cout << "desc invocation failed\n";
                    }

                } catch (const Ice::LocalException &ex) {
                    std::cout << "Local exception: " << ex << std::endl;
                }

            } else if (cmd == "stream") {



            } else if (cmd == "x") {

                break;
            
            } else {
            
                std::cout << "???\n";
            
            }
        }

        std::cout << "Client shuts down\n";

    } catch (const std::exception &ex) {
        std::cerr << ex.what() << std::endl;
        status = 1;
    }

    if (communicator) {

        try {
            communicator->destroy();
        } catch (const std::exception &ex) {
            std::cerr << ex.what() << std::endl;
        }

    }

    return status;
}