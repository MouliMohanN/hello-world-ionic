#ifndef EMULATOR_H
#define EMULATOR_H

#include <string>
#include <vector>

class Emulator
{
    static std::vector<std::string> detections;

public:
    static std::string hasDetections();
    static std::string getResult();

private:
    static void checkHardwareProps();
    static void checkMounts();
    static void checkCPUInfo();
    static void checkSystemFiles();
    static void checkCPUArchitecture();
    static void checkArmTranslation();
    static void findEmulatorMemory();
};

#endif // EMULATOR_H