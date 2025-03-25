//
// Created by FCI on 07-03-2025.
//

#ifndef ANDROID_CONFIGDATA_HPP
#define ANDROID_CONFIGDATA_HPP

#include "util.h"
#include <string>
#include <vector>

namespace ConfigData
{
    extern std::vector<int> fstabAndy;
    extern std::vector<int> ueventdAndyRc;
    extern std::vector<int> fstabNox;
    extern std::vector<int> initNoxRc;
    extern std::vector<int> ueventdNoxRc;
    extern std::vector<int> devSocketGemud;
    extern std::vector<int> devQemuPipe;
    extern std::vector<int> devMemufp;
    extern std::vector<int> devMemuQuest;
    extern std::vector<int> devMemuuser;
    extern std::vector<int> systemLibMemuquestKo;
    extern std::vector<int> systemBinNoxProp;
    extern std::vector<int> systemBinNoxd;
    extern std::vector<int> systemLibLibnoxdSo;
    extern std::vector<int> systemPrivAppComBluestacksBstfolderApk;
    extern std::vector<int> devBstGps;
    extern std::vector<int> devBstIme;
    extern std::vector<int> devBstGyro;
    extern std::vector<int> devBstmegn;
    extern std::vector<int> systemXbinPhoenixCompat;
    extern std::vector<int> dataSystemPhoenixlogAddr;
    extern std::vector<int> systemPhoenixos;
    extern std::vector<int> systemLibLibnoxspeedupSo;
    extern std::vector<int> systemEtcInitNoxSh;
    extern std::vector<int> systemBinNox;
    extern std::vector<int> systemLibHwGpsLdSo;
    extern std::vector<int> systemLibHwSensorsLdSo;
    extern std::vector<int> systemLibLibldutilsSo;
    extern std::vector<int> systemBinLdinit;
    extern std::vector<int> systemAppLDAppStoreLDAppStoreApk;
    extern std::vector<int> dataDataComLdmnqLauncher3FilesLauncherPreferences;
    extern std::vector<int> dataBluestacksProp;
    extern std::vector<int> dataBstconfProp;
    extern std::vector<int> mntWindows;
    extern std::vector<int> mntWindowsBstSharedFolder;
    extern std::vector<int> libVboxguestKo;
    extern std::vector<int> libVboxsfKo;
    extern std::vector<int> dataDataComBluestacksBstfolder;
    extern std::vector<int> dataDataComBluestacksAppmart;
    extern std::vector<int> dataDataComBluestacksHome;
    extern std::vector<int> dataDataComBluestacksLauncher;
    extern std::vector<int> systemBinBstfolder;
    extern std::vector<int> systemBinBstfolderd;
    extern std::vector<int> systemBinBstsyncfs;
    extern std::vector<int> sysModuleBstsensor;
    extern std::vector<int> sysModuleBstpgaipc;
    extern std::vector<int> systemXbinBstkSu;
    extern std::vector<int> systemXbinBstk;
    extern std::vector<int> sysModuleMg;
    extern std::vector<int> systemBinNoxVboxSf;
    extern std::vector<int> dataDataComAndroidLdAppstore;
    extern std::vector<int> dataDataComKoplayLauncher;
    extern std::vector<int> systemBinKOPLAYERIni;
    extern std::vector<int> systemBinAndroidVMVboxSf;
    extern std::vector<int> sysModuleVboxpcismv;
    extern std::vector<int> sysModuleNemusf;
    extern std::vector<int> systemBinGenybaseband;
    extern std::vector<int> systemBinDroid4xVboxSf;
    extern std::vector<int> systemBinDroid4x;
    extern std::vector<int> sysModuleVboxsf;
    extern std::vector<int> sysModuleMsf;

    extern std::vector<std::string> emulatorFiles;
    extern std::vector<std::string> newEmulatorFiles;
    extern std::vector<std::string> products;
    extern std::vector<std::string> manufacturers;
    extern std::vector<std::string> deviceInfo;
    extern std::vector<std::string> hardwares;
}

#endif // ANDROID_CONFIGDATA_H
