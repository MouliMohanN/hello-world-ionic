//
// Created by FCI on 05-03-2025.
//

#include "utils/header/Detections.h"
#include "utils/header/util.h"
#include "utils/FileHelper.hpp"
#include "utils/ConfigData.hpp"

class Emulator {
    static std::vector<std::string> detections;
    public:bool isDetected();
};

void checkHardwareProps() {
    // ro.build.product
    std::vector<int> roBuildProduct = {99,109,56,117,89,110,86,112,98,71,81,117,99,72,74,118,90,72,86,106,100,65,61,61};
    std::string product = FileHelper::getSystemProperty(getStringFromAscii(roBuildProduct));

    // ro.product.manufacturer
    std::vector<int> roProductManufacturer = {99,109,56,117,99,72,74,118,90,72,86,106,100,67,53,116,89,87,53,49,90,109,70,106,100,72,86,121,90,88,73,61};
    std::string manufacturer = FileHelper::getSystemProperty(getStringFromAscii(roProductManufacturer));

    // ro.bootloader
    std::vector<int> roBootLoader = {99,109,56,117,89,109,57,118,100,71,120,118,89,87,82,108,99,103,61,61};
    std::string bootloader = FileHelper::getSystemProperty(getStringFromAscii(roBootLoader));

    // ro.product.device
    std::vector<int> roProductDevice = {99,109,56,117,99,72,74,118,90,72,86,106,100,67,53,107,90,88,90,112,89,50,85,61};
    std::string device = FileHelper::getSystemProperty(getStringFromAscii(roProductDevice));

    // ro.hardware
    std::vector<int> roHardware = {99,109,56,117,97,71,70,121,90,72,100,104,99,109,85,61};
    std::string hardware = FileHelper::getSystemProperty(getStringFromAscii(roHardware));

    // Detected
    std::vector<int> detected = {82,71,86,48,90,87,78,48,90,87,81,61};

    // Product
    std::vector<int> productString = {85,72,74,118,90,72,86,106,100,65,61,61};

    for (const std::string& _product : ConfigData::products) {
        if (product == _product) {
            detections.push_back("- " + getStringFromAscii(detected) + " " + getStringFromAscii(productString) + ": " + _product);
        }
    }

    // Manufacturer
    std::vector<int> manufacturerString = {84,87,70,117,100,87,90,104,89,51,82,49,99,109,86,121};
    for (const std::string& _manufacturer : ConfigData::manufacturers) {
        if (manufacturer == _manufacturer) {
            detections.push_back("- " + getStringFromAscii(detected) + " " + getStringFromAscii(manufacturerString) + ": " + manufacturer);
        }
    }

    // nox
    std::vector<int> noxString = {98,109,57,52};
    if (bootloader == getStringFromAscii(noxString)) {
        // Bootloader
        std::vector<int> bootLoaderString = {81,109,57,118,100,71,120,118,89,87,82,108,99,103,61,61};
        detections.push_back("- " + getStringFromAscii(detected) + " " + getStringFromAscii(bootLoaderString) + ": " + bootloader);
    }

    // Device
    std::vector<int> deviceString = {82,71,86,50,97,87,78,108};
    for (const std::string& info : ConfigData::deviceInfo) {
        if (device == info) {
            detections.push_back("- " + getStringFromAscii(detected) + " " + getStringFromAscii(deviceString) + ": " + info);
        }
    }

    // Hardware
    std::vector<int> hardwareString = {83,71,70,121,90,72,100,104,99,109,85,61};
    for (const std::string& _hardware : ConfigData::hardwares) {
        if (hardware == _hardware) {
            detections.push_back("- " + getStringFromAscii(detected) + " " + getStringFromAscii(hardwareString) + ": " + hardware);
        }
    }
}

bool Emulator::isDetected() {
    if (!detections.empty()) {
        return true;
    }
    checkHardwareProps();
    return false;
}

