//
// Created by FCI on 05-03-2025.
//

#include "utils/header/ConfigData.hpp"
#include "utils/header/Detections.h"
#include "utils/header/Emulator.h"
#include "utils/header/util.h"
#include "utils/FileHelper.hpp"

std::vector<std::string> Emulator::detections;

void Emulator::checkHardwareProps() {
    // ro.build.product
    std::vector<int> roBuildProduct = {99, 109, 56, 117, 89, 110, 86, 112, 98, 71, 81, 117, 99, 72,
                                       74, 118, 90, 72, 86, 106, 100, 65, 61, 61};
    std::string product = FileHelper::getSystemProperty(getStringFromAscii(roBuildProduct));

    // ro.product.manufacturer
    std::vector<int> roProductManufacturer = {99, 109, 56, 117, 99, 72, 74, 118, 90, 72, 86, 106,
                                              100, 67, 53, 116, 89, 87, 53, 49, 90, 109, 70, 106,
                                              100, 72, 86, 121, 90, 88, 73, 61};
    std::string manufacturer = FileHelper::getSystemProperty(
            getStringFromAscii(roProductManufacturer));

    // ro.bootloader
    std::vector<int> roBootLoader = {99, 109, 56, 117, 89, 109, 57, 118, 100, 71, 120, 118, 89, 87,
                                     82, 108, 99, 103, 61, 61};
    std::string bootloader = FileHelper::getSystemProperty(getStringFromAscii(roBootLoader));

    // ro.product.device
    std::vector<int> roProductDevice = {99, 109, 56, 117, 99, 72, 74, 118, 90, 72, 86, 106, 100, 67,
                                        53, 107, 90, 88, 90, 112, 89, 50, 85, 61};
    std::string device = FileHelper::getSystemProperty(getStringFromAscii(roProductDevice));

    // ro.hardware
    std::vector<int> roHardware = {99, 109, 56, 117, 97, 71, 70, 121, 90, 72, 100, 104, 99, 109, 85,
                                   61};
    std::string hardware = FileHelper::getSystemProperty(getStringFromAscii(roHardware));

    // Detected
    std::vector<int> detected = {82, 71, 86, 48, 90, 87, 78, 48, 90, 87, 81, 61};

    // Product
    std::vector<int> productString = {85, 72, 74, 118, 90, 72, 86, 106, 100, 65, 61, 61};

    for (const std::string &_product: ConfigData::products) {
        if (product == _product) {
            detections.emplace_back(
                    "- " + getStringFromAscii(detected) + " " + getStringFromAscii(productString) +
                    ": " + _product);
        }
    }

    // Manufacturer
    std::vector<int> manufacturerString = {84, 87, 70, 117, 100, 87, 90, 104, 89, 51, 82, 49, 99,
                                           109, 86, 121};
    for (const std::string &_manufacturer: ConfigData::manufacturers) {
        if (manufacturer == _manufacturer) {
            detections.emplace_back("- " + getStringFromAscii(detected) + " " +
                                 getStringFromAscii(manufacturerString) + ": " + manufacturer);
        }
    }

    // nox
    std::vector<int> noxString = {98, 109, 57, 52};
    if (bootloader == getStringFromAscii(noxString)) {
        // Bootloader
        std::vector<int> bootLoaderString = {81, 109, 57, 118, 100, 71, 120, 118, 89, 87, 82, 108,
                                             99, 103, 61, 61};
        detections.emplace_back(
                "- " + getStringFromAscii(detected) + " " + getStringFromAscii(bootLoaderString) +
                ": " + bootloader);
    }

    // Device
    std::vector<int> deviceString = {82, 71, 86, 50, 97, 87, 78, 108};
    for (const std::string &info: ConfigData::deviceInfo) {
        if (device == info) {
            detections.emplace_back(
                    "- " + getStringFromAscii(detected) + " " + getStringFromAscii(deviceString) +
                    ": " + info);
        }
    }

    // Hardware
    std::vector<int> hardwareString = {83, 71, 70, 121, 90, 72, 100, 104, 99, 109, 85, 61};
    for (const std::string &_hardware: ConfigData::hardwares) {
        if (hardware == _hardware) {
            detections.emplace_back(
                    "- " + getStringFromAscii(detected) + " " + getStringFromAscii(hardwareString) +
                    ": " + hardware);
        }
    }
}

void Emulator::checkMounts() {
    // /proc/mounts
    std::vector<int> procMounts = {76, 51, 66, 121, 98, 50, 77, 118, 98, 87, 57, 49, 98, 110, 82,
                                   122};
    // vboxsf
    std::vector<int> vboxsf = {100, 109, 74, 118, 101, 72, 78, 109};
    // - Detected VM Module in Mounts
    std::vector<int> detectedVmModuleInMounts = {76, 83, 66, 69, 90, 88, 82, 108, 89, 51, 82, 108,
                                                 90, 67, 66, 87, 84, 83, 66, 78, 98, 50, 82, 49, 98,
                                                 71, 85, 103, 97, 87, 52, 103, 84, 87, 57, 49, 98,
                                                 110, 82, 122};

    std::vector<std::string> file = FileHelper::readFile(getStringFromAscii(procMounts));
    std::string vboxsfString = getStringFromAscii(vboxsf);
    std::string detectedVmModuleInMountsString = getStringFromAscii(detectedVmModuleInMounts);
    for (const std::string &i: file) {
        if (i.find(vboxsfString) != std::string::npos) {
            detections.emplace_back(detectedVmModuleInMountsString);
            return;
        }
    }
}

void Emulator::checkCPUInfo() {
    // /proc/cpuinfo
    std::vector<int> procCpuInfo = {76, 51, 66, 121, 98, 50, 77, 118, 89, 51, 66, 49, 97, 87, 53,
                                    109, 98, 119, 61, 61};
    // hypervisor
    std::vector<int> hypervisor = {97, 72, 108, 119, 90, 88, 74, 50, 97, 88, 78, 118, 99, 103, 61,
                                   61};
    // amd
    std::vector<int> amd = {89, 87, 49, 107};
    // intel
    std::vector<int> intel = {97, 87, 53, 48, 90, 87, 119, 61};
    // - Detected Hypervisor in cpuinfo
    std::vector<int> detectedHypervisorInCpuinfo = {76, 83, 66, 69, 90, 88, 82, 108, 89, 51, 82,
                                                    108, 90, 67, 66, 73, 101, 88, 66, 108, 99, 110,
                                                    90, 112, 99, 50, 57, 121, 73, 71, 108, 117, 73,
                                                    71, 78, 119, 100, 87, 108, 117, 90, 109, 56,
                                                    61};
    // - Detected Host CPU in cpuinfo
    std::vector<int> detectedHostCpuInCpuinfo = {76, 83, 66, 69, 90, 88, 82, 108, 89, 51, 82, 108,
                                                 90, 67, 66, 73, 98, 51, 78, 48, 73, 69, 78, 81, 86,
                                                 83, 66, 112, 98, 105, 66, 106, 99, 72, 86, 112, 98,
                                                 109, 90, 118};

    std::vector<std::string> file = FileHelper::readFile(getStringFromAscii(procCpuInfo));
    std::string hypervisorString = getStringFromAscii(hypervisor);
    std::string amdString = getStringFromAscii(amd);
    std::string intelString = getStringFromAscii(intel);
    std::string detectedHypervisorInCpuinfoString = getStringFromAscii(detectedHypervisorInCpuinfo);
    std::string detectedHostCpuInCpuinfoString = getStringFromAscii(detectedHostCpuInCpuinfo);

    for (const std::string &i: file) {
        if (i.find(hypervisorString) != std::string::npos) {
            detections.emplace_back(detectedHypervisorInCpuinfoString);
            break;
        }
    }

    for (const std::string &i: file) {
        if (i.find(amdString) != std::string::npos || i.find(intelString) != std::string::npos) {
            detections.emplace_back(detectedHostCpuInCpuinfoString);
            break;
        }
    }
}

void Emulator::checkSystemFiles() {
    // /data/property/
    std::vector<int> dataProperty = {76, 50, 82, 104, 100, 71, 69, 118, 99, 72, 74, 118, 99, 71, 86,
                                     121, 100, 72, 107, 118};
    // nox
    std::vector<int> nox = {98, 109, 57, 52};
    // - Detected Emulator File
    std::vector<int> detectedEmulatorFile = {76, 83, 66, 69, 90, 88, 82, 108, 89, 51, 82, 108, 90,
                                             67, 66, 70, 98, 88, 86, 115, 89, 88, 82, 118, 99, 105,
                                             66, 71, 97, 87, 120, 108};
    // - Detected Emulator File (2)
    std::vector<int> detectedEmulatorFile2 = {76, 83, 66, 69, 90, 88, 82, 108, 89, 51, 82, 108, 90,
                                              67, 66, 70, 98, 88, 86, 115, 89, 88, 82, 118, 99, 105,
                                              66, 71, 97, 87, 120, 108, 73, 67, 103, 121, 75, 81,
                                              61, 61};
    // - Detected Nox Property File
    std::vector<int> detectedNoxPropertyFile = {76, 83, 66, 69, 90, 88, 82, 108, 89, 51, 82, 108,
                                                90, 67, 66, 79, 98, 51, 103, 103, 85, 72, 74, 118,
                                                99, 71, 86, 121, 100, 72, 107, 103, 82, 109, 108,
                                                115, 90, 81, 61, 61};

    for (const std::string &emulatorFile: ConfigData::emulatorFiles) {
        if (FileHelper::fileExists(emulatorFile)) {
            detections.emplace_back(getStringFromAscii(detectedEmulatorFile) + emulatorFile);
            break;
        }
    }

    for (const std::string &emulatorFile: ConfigData::newEmulatorFiles) {
        if (FileHelper::fileExists(emulatorFile)) {
            detections.emplace_back(getStringFromAscii(detectedEmulatorFile2) + emulatorFile);
            break;
        }
    }

    std::vector<std::string> out = FileHelper::listFilesInDirectory(
            getStringFromAscii(dataProperty));
    std::string noxString = getStringFromAscii(nox);
    for (const std::string &i: out) {
        if (i.find(noxString) != std::string::npos) {
            detections.emplace_back(getStringFromAscii(detectedNoxPropertyFile));
            break;
        }
    }
}

void Emulator::checkCPUArchitecture() {
    // ro.product.cpu.abilist
    std::vector<int> roProductCpuAbilist = {99, 109, 56, 117, 99, 72, 74, 118, 90, 72, 86, 106, 100,
                                            67, 53, 106, 99, 72, 85, 117, 89, 87, 74, 112, 98, 71,
                                            108, 122, 100, 65, 61, 61};
    // x86
    std::vector<int> x86 = {101, 68, 103, 50};
    // - Detected x86 Architecture
    std::vector<int> detectedX86Architecture = {76, 83, 66, 69, 90, 88, 82, 108, 89, 51, 82, 108,
                                                90, 67, 66, 52, 79, 68, 89, 103, 81, 88, 74, 106,
                                                97, 71, 108, 48, 90, 87, 78, 48, 100, 88, 74, 108};
    std::string x86String = getStringFromAscii(x86);

    std::string abi = FileHelper::getSystemProperty(getStringFromAscii(roProductCpuAbilist));

    if (abi.find(x86String) != std::string::npos) {
        detections.emplace_back(getStringFromAscii(detectedX86Architecture));
    }
}

void Emulator::checkArmTranslation() {
    // libhoudini.so
    std::vector<int> libHoudiniSo = {98, 71, 108, 105, 97, 71, 57, 49, 90, 71, 108, 117, 97, 83, 53,
                                     122, 98, 119, 61, 61};
    // ro.dalvik.vm.native.bridge
    std::vector<int> roDalvikVmNativeBridge = {99, 109, 56, 117, 90, 71, 70, 115, 100, 109, 108,
                                               114, 76, 110, 90, 116, 76, 109, 53, 104, 100, 71,
                                               108, 50, 90, 83, 53, 105, 99, 109, 108, 107, 90, 50,
                                               85, 61};
    // /system/lib/libhoudini.so
    std::vector<int> systemLibLibHoudiniSo = {76, 51, 78, 53, 99, 51, 82, 108, 98, 83, 57, 115, 97,
                                              87, 73, 118, 98, 71, 108, 105, 97, 71, 57, 49, 90, 71,
                                              108, 117, 97, 83, 53, 122, 98, 119, 61, 61};
    // /system/lib64/libhoudini.so
    std::vector<int> systemLib64LibHoudiniSo = {76, 51, 78, 53, 99, 51, 82, 108, 98, 83, 57, 115,
                                                97, 87, 73, 50, 78, 67, 57, 115, 97, 87, 74, 111,
                                                98, 51, 86, 107, 97, 87, 53, 112, 76, 110, 78, 118};
    // ro.dalvik.vm.isa.arm
    std::vector<int> roDalvikVmIsaArm = {99, 109, 56, 117, 90, 71, 70, 115, 100, 109, 108, 114, 76,
                                         110, 90, 116, 76, 109, 108, 122, 89, 83, 53, 104, 99, 109,
                                         48, 61};
    // ro.dalvik.vm.isa.arm64
    std::vector<int> roDalvikVmIsaArm64 = {99, 109, 56, 117, 90, 71, 70, 115, 100, 109, 108, 114,
                                           76, 110, 90, 116, 76, 109, 108, 122, 89, 83, 53, 104, 99,
                                           109, 48, 50, 78, 65, 61, 61};
    // x86
    std::vector<int> x86 = {101, 68, 103, 50};
    // x86_64
    std::vector<int> x86_64 = {101, 68, 103, 50, 88, 122, 89, 48};

    // - Detected ARM Translation
    std::vector<int> detectedArmTranslation = {76, 83, 66, 69, 90, 88, 82, 108, 89, 51, 82, 108, 90,
                                               67, 66, 66, 85, 107, 48, 103, 86, 72, 74, 104, 98,
                                               110, 78, 115, 89, 88, 82, 112, 98, 50, 52, 61};
    // - Detected ARM Translation Property
    std::vector<int> detectedArmTranslationProperty = {76, 83, 66, 69, 90, 88, 82, 108, 89, 51, 82,
                                                       108, 90, 67, 66, 66, 85, 107, 48, 103, 86,
                                                       72, 74, 104, 98, 110, 78, 115, 89, 88, 82,
                                                       112, 98, 50, 52, 103, 85, 72, 74, 118, 99,
                                                       71, 86, 121, 100, 72, 107, 61};
    // - Detected ARM Translation Library
    std::vector<int> detectedArmTranslationLibrary = {76, 83, 66, 69, 90, 88, 82, 108, 89, 51, 82,
                                                      108, 90, 67, 66, 66, 85, 107, 48, 103, 86, 72,
                                                      74, 104, 98, 110, 78, 115, 89, 88, 82, 112,
                                                      98, 50, 52, 103, 84, 71, 108, 105, 99, 109,
                                                      70, 121, 101, 81, 61, 61};
    // - Detected ARM Translation Property (2)
    std::vector<int> detectedArmTranslationProperty2 = {76, 83, 66, 69, 90, 88, 82, 108, 89, 51, 82,
                                                        108, 90, 67, 66, 66, 85, 107, 48, 103, 86,
                                                        72, 74, 104, 98, 110, 78, 115, 89, 88, 82,
                                                        112, 98, 50, 52, 103, 85, 72, 74, 118, 99,
                                                        71, 86, 121, 100, 72, 107, 103, 75, 68, 73,
                                                        112};

    std::string libHoudiniSoString = getStringFromAscii(libHoudiniSo);
    std::vector<dl_phdr_info> info = FileHelper::getLoadedLibraries();
    for (const dl_phdr_info &i: info) {
        if (strstr(i.dlpi_name, libHoudiniSoString.c_str())) {
            detections.emplace_back(getStringFromAscii(detectedArmTranslation));
            break;
        }
    }

    std::string prop = FileHelper::getSystemProperty(getStringFromAscii(roDalvikVmNativeBridge));
    if (prop != "0" && !prop.empty()) {
        detections.emplace_back(getStringFromAscii(detectedArmTranslationProperty));
    }

    if (FileHelper::fileExists(getStringFromAscii(systemLibLibHoudiniSo)) ||
        FileHelper::fileExists(getStringFromAscii(systemLib64LibHoudiniSo))) {
        detections.emplace_back(getStringFromAscii(detectedArmTranslationLibrary));
    }

    std::string arm = FileHelper::getSystemProperty(getStringFromAscii(roDalvikVmIsaArm));
    std::string arm64 = FileHelper::getSystemProperty(getStringFromAscii(roDalvikVmIsaArm64));
    if (arm == getStringFromAscii(x86) || arm64 == getStringFromAscii(x86_64)) {
        detections.emplace_back(getStringFromAscii(detectedArmTranslationProperty2));
    }
}

void Emulator::findEmulatorMemory() {
    // libc.so
    std::vector<int> libcSo = {98, 71, 108, 105, 89, 121, 53, 122, 98, 119, 61, 61};
    // libandroid_runtime.so
    std::vector<int> libAndroidRuntimeSo = {98, 71, 108, 105, 89, 87, 53, 107, 99, 109, 57, 112, 90,
                                            70, 57, 121, 100, 87, 53, 48, 97, 87, 49, 108, 76, 110,
                                            78, 118};
    // libart.so
    std::vector<int> libArtSo = {98, 71, 108, 105, 89, 88, 74, 48, 76, 110, 78, 118};
    // bluestacks
    std::vector<int> bluestacks = {89, 109, 120, 49, 90, 88, 78, 48, 89, 87, 78, 114, 99, 119, 61,
                                   61};
    std::string bluestacksString = getStringFromAscii(bluestacks);

    // - Detected Bluestacks Memory
    std::vector<int> detectedBluestacksMemory = {76, 83, 66, 69, 90, 88, 82, 108, 89, 51, 82, 108,
                                                 90, 67, 66, 67, 98, 72, 86, 108, 99, 51, 82, 104,
                                                 89, 50, 116, 122, 73, 69, 49, 108, 98, 87, 57, 121,
                                                 101, 81, 61, 61};
    std::vector<std::string> libraries{
            getStringFromAscii(libcSo),
            getStringFromAscii(libAndroidRuntimeSo),
            getStringFromAscii(libArtSo)};

    for (const std::string &library: libraries) {
        bool result = FileHelper::findStringInMaps(library, bluestacksString);
        if (result) {
            detections.emplace_back(getStringFromAscii(detectedBluestacksMemory));
            return;
        }
    }
}

std::string Emulator::hasDetections() {
    // detectionhasbeenfoundforemulator - jjxheuinlewnvxwevdiapqyamtaqewqs
    std::vector<int> trueValue = {97, 109, 112, 52, 97, 71, 86, 49, 97, 87, 53, 115, 90, 88, 100, 117, 100, 110, 104, 51, 90, 88, 90, 107, 97, 87, 70, 119, 99, 88, 108, 104, 98, 88, 82, 104, 99, 87, 86, 51, 99, 88, 77, 61};
    std::string trueValueString = getStringFromAscii(trueValue);

    // detectionhasnotbeenfoundforemulator - mmakhxlqohzqkkovxwevdiapqyamtaqewqs
    std::vector<int> falseValue = {98, 87, 49, 104, 97, 50, 104, 52, 98, 72, 70, 118, 97, 72, 112, 120, 97, 50, 116, 118, 100, 110, 104, 51, 90, 88, 90, 107, 97, 87, 70, 119, 99, 88, 108, 104, 98, 88, 82, 104, 99, 87, 86, 51, 99, 88, 77, 61};
    std::string falseValueString = getStringFromAscii(falseValue);

    if (!detections.empty()) {
        return trueValueString;
    }
    checkHardwareProps();
    checkMounts();
    checkCPUInfo();
    checkSystemFiles();
    checkCPUArchitecture();
    checkArmTranslation();
    findEmulatorMemory();
    if (detections.empty()) {
        return falseValueString;
    }
    return trueValueString;
}

std::string Emulator::getResult() {
    if (detections.empty()) {
        return "";
    }

    std::string result;
    for (const std::string &detection: detections) {
        result += detection + "\n";
    }

    return result;
}
