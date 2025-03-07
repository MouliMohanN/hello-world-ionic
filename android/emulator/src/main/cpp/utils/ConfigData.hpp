//
// Created by FCI on 05-03-2025.
//

#include "string"
#include "vector"

namespace ConfigData
{

    // fstab.andy
    std::vector<int> fstabAndy = {90, 110, 78, 48, 89, 87, 73, 117, 89, 87, 53, 107, 101, 81, 61, 61};
    // ueventd.andy.rc
    std::vector<int> ueventdAndyRc = {100, 87, 86, 50, 90, 87, 53, 48, 90, 67, 53, 104, 98, 109, 82, 53, 76, 110, 74, 106};
    // fstab.nox
    std::vector<int> fstabNox = {90, 110, 78, 48, 89, 87, 73, 117, 98, 109, 57, 52};
    // init.nox.rc
    std::vector<int> initNoxRc = {97, 87, 53, 112, 100, 67, 53, 117, 98, 51, 103, 117, 99, 109, 77, 61};
    // ueventd.nox.rc
    std::vector<int> ueventdNoxRc = {100, 87, 86, 50, 90, 87, 53, 48, 90, 67, 53, 117, 98, 51, 103, 117, 99, 109, 77, 61};
    // dev/socket/qemud
    std::vector<int> devSocketGemud = {90, 71, 86, 50, 76, 51, 78, 118, 89, 50, 116, 108, 100, 67, 57, 120, 90, 87, 49, 49, 90, 65, 61, 61};
    // dev/qemu_pipe
    std::vector<int> devQemuPipe = {90, 71, 86, 50, 76, 51, 70, 108, 98, 88, 86, 102, 99, 71, 108, 119, 90, 81, 61, 61};
    // /dev/memufp
    std::vector<int> devMemufp = {76, 50, 82, 108, 100, 105, 57, 116, 90, 87, 49, 49, 90, 110, 65, 61};
    // /dev/memuguest
    std::vector<int> devMemuQuest = {76, 50, 82, 108, 100, 105, 57, 116, 90, 87, 49, 49, 90, 51, 86, 108, 99, 51, 81, 61};
    // /dev/memuuser
    std::vector<int> devMemuuser = {76, 50, 82, 108, 100, 105, 57, 116, 90, 87, 49, 49, 100, 88, 78, 108, 99, 103, 61, 61};
    // /system/lib/memuguest.ko
    std::vector<int> systemLibMemuquestKo = {76, 51, 78, 53, 99, 51, 82, 108, 98, 83, 57, 115, 97, 87, 73, 118, 98, 87, 86, 116, 100, 87, 100, 49, 90, 88, 78, 48, 76, 109, 116, 118};
    // /system/bin/nox-prop
    std::vector<int> systemBinNoxProp = {76, 51, 78, 53, 99, 51, 82, 108, 98, 83, 57, 105, 97, 87, 52, 118, 98, 109, 57, 52, 76, 88, 66, 121, 98, 51, 65, 61};
    // /system/bin/noxd
    std::vector<int> systemBinNoxd = {76, 51, 78, 53, 99, 51, 82, 108, 98, 83, 57, 105, 97, 87, 52, 118, 98, 109, 57, 52, 90, 65, 61, 61};
    // /system/lib/libnoxd.so
    std::vector<int> systemLibLibnoxdSo = {76, 51, 78, 53, 99, 51, 82, 108, 98, 83, 57, 115, 97, 87, 73, 118, 98, 71, 108, 105, 98, 109, 57, 52, 90, 67, 53, 122, 98, 119, 61, 61};
    // /system/priv-app/com.bluestacks.bstfolder.apk
    std::vector<int> systemPrivAppComBluestacksBstfolderApk = {76, 51, 78, 53, 99, 51, 82, 108, 98, 83, 57, 119, 99, 109, 108, 50, 76, 87, 70, 119, 99, 67, 57, 106, 98, 50, 48, 117, 89, 109, 120, 49, 90, 88, 78, 48, 89, 87, 78, 114, 99, 121, 53, 105, 99, 51, 82, 109, 98, 50, 120, 107, 90, 88, 73, 117, 89, 88, 66, 114};
    // /dev/bst_gps
    std::vector<int>
        devBstGps = {76, 50, 82, 108, 100, 105, 57, 105, 99, 51, 82, 102, 90, 51, 66, 122};
    // /dev/bst_ime
    std::vector<int> devBstIme = {76, 50, 82, 108, 100, 105, 57, 105, 99, 51, 82, 102, 97, 87, 49, 108};
    // /dev/bstgyro
    std::vector<int> devBstGyro = {76, 50, 82, 108, 100, 105, 57, 105, 99, 51, 82, 110, 101, 88, 74, 118};
    // /dev/bstmegn
    std::vector<int> devBstmegn = {76, 50, 82, 108, 100, 105, 57, 105, 99, 51, 82, 116, 90, 87, 100, 117};
    // /system/xbin/phoenix_compat
    std::vector<int> systemXbinPhoenixCompat = {76, 51, 78, 53, 99, 51, 82, 108, 98, 83, 57, 52, 89, 109, 108, 117, 76, 51, 66, 111, 98, 50, 86, 117, 97, 88, 104, 102, 89, 50, 57, 116, 99, 71, 70, 48};
    // /data/system/phoenixlog.addr
    std::vector<int> dataSystemPhoenixlogAddr = {76, 50, 82, 104, 100, 71, 69, 118, 99, 51, 108, 122, 100, 71, 86, 116, 76, 51, 66, 111, 98, 50, 86, 117, 97, 88, 104, 115, 98, 50, 99, 117, 89, 87, 82, 107, 99, 103, 61, 61};
    // /system/phoenixos
    std::vector<int> systemPhoenixos = {76, 51, 78, 53, 99, 51, 82, 108, 98, 83, 57, 119, 97, 71, 57, 108, 98, 109, 108, 52, 98, 51, 77, 61};
    // /system/lib/libnoxspeedup.so
    std::vector<int> systemLibLibnoxspeedupSo = {76, 51, 78, 53, 99, 51, 82, 108, 98, 83, 57, 115, 97, 87, 73, 118, 98, 71, 108, 105, 98, 109, 57, 52, 99, 51, 66, 108, 90, 87, 82, 49, 99, 67, 53, 122, 98, 119, 61, 61};
    // /system/etc/init.nox.sh
    std::vector<int> systemEtcInitNoxSh = {76, 51, 78, 53, 99, 51, 82, 108, 98, 83, 57, 108, 100, 71, 77, 118, 97, 87, 53, 112, 100, 67, 53, 117, 98, 51, 103, 117, 99, 50, 103, 61};
    // /system/bin/nox
    std::vector<int> systemBinNox = {76, 51, 78, 53, 99, 51, 82, 108, 98, 83, 57, 105, 97, 87, 52, 118, 98, 109, 57, 52};
    // /system/lib/hw/gps.ld.so
    std::vector<int> systemLibHwGpsLdSo = {76, 51, 78, 53, 99, 51, 82, 108, 98, 83, 57, 115, 97, 87, 73, 118, 97, 72, 99, 118, 90, 51, 66, 122, 76, 109, 120, 107, 76, 110, 78, 118};
    // /system/lib/hw/sensors.ld.so
    std::vector<int> systemLibHwSensorsLdSo = {76, 51, 78, 53, 99, 51, 82, 108, 98, 83, 57, 115, 97, 87, 73, 118, 97, 72, 99, 118, 99, 50, 86, 117, 99, 50, 57, 121, 99, 121, 53, 115, 90, 67, 53, 122, 98, 119, 61, 61};
    // /system/lib/libldutils.so
    std::vector<int> systemLibLibldutilsSo = {76, 51, 78, 53, 99, 51, 82, 108, 98, 83, 57, 115, 97, 87, 73, 118, 98, 71, 108, 105, 98, 71, 82, 49, 100, 71, 108, 115, 99, 121, 53, 122, 98, 119, 61, 61};
    // /system/bin/ldinit
    std::vector<int> systemBinLdinit = {76, 51, 78, 53, 99, 51, 82, 108, 98, 83, 57, 105, 97, 87, 52, 118, 98, 71, 82, 112, 98, 109, 108, 48};
    // /system/app/LDAppStore/LDAppStore.apk
    std::vector<int> systemAppLDAppStoreLDAppStoreApk = {76, 51, 78, 53, 99, 51, 82, 108, 98, 83, 57, 104, 99, 72, 65, 118, 84, 69, 82, 66, 99, 72, 66, 84, 100, 71, 57, 121, 90, 83, 57, 77, 82, 69, 70, 119, 99, 70, 78, 48, 98, 51, 74, 108, 76, 109, 70, 119, 97, 119, 61, 61};
    // /data/data/com.ldmnq.launcher3/files/launcher.preferences
    std::vector<int> dataDataComLdmnqLauncher3FilesLauncherPreferences = {76, 50, 82, 104, 100, 71, 69, 118, 90, 71, 70, 48, 89, 83, 57, 106, 98, 50, 48, 117, 98, 71, 82, 116, 98, 110, 69, 117, 98, 71, 70, 49, 98, 109, 78, 111, 90, 88, 73, 122, 76, 50, 90, 112, 98, 71, 86, 122, 76, 50, 120, 104, 100, 87, 53, 106, 97, 71, 86, 121, 76, 110, 66, 121, 90, 87, 90, 108, 99, 109, 86, 117, 89, 50, 86, 122};
    // /data/.bluestacks.prop
    std::vector<int> dataBluestacksProp = {76, 50, 82, 104, 100, 71, 69, 118, 76, 109, 74, 115, 100, 87, 86, 122, 100, 71, 70, 106, 97, 51, 77, 117, 99, 72, 74, 118, 99, 65, 61, 61};
    // /data/.bstconf.prop
    std::vector<int> dataBstconfProp = {76, 50, 82, 104, 100, 71, 69, 118, 76, 109, 74, 122, 100, 71, 78, 118, 98, 109, 89, 117, 99, 72, 74, 118, 99, 65, 61, 61};
    // /mnt/windows
    std::vector<int> mntWindows = {76, 50, 49, 117, 100, 67, 57, 51, 97, 87, 53, 107, 98, 51, 100, 122};
    // /mnt/windows/BstSharedFolder
    std::vector<int> mntWindowsBstSharedFolder = {76, 50, 49, 117, 100, 67, 57, 51, 97, 87, 53, 107, 98, 51, 100, 122, 76, 48, 74, 122, 100, 70, 78, 111, 89, 88, 74, 108, 90, 69, 90, 118, 98, 71, 82, 108, 99, 103, 61, 61};
    // /lib/vboxguest.ko
    std::vector<int> libVboxguestKo = {76, 50, 120, 112, 89, 105, 57, 50, 89, 109, 57, 52, 90, 51, 86, 108, 99, 51, 81, 117, 97, 50, 56, 61};
    // /lib/vboxsf.ko
    std::vector<int> libVboxsfKo = {76, 50, 120, 112, 89, 105, 57, 50, 89, 109, 57, 52, 99, 50, 89, 117, 97, 50, 56, 61};
    // /data/data/com.bluestacks.bstfolder
    std::vector<int> dataDataComBluestacksBstfolder = {76, 50, 82, 104, 100, 71, 69, 118, 90, 71, 70, 48, 89, 83, 57, 106, 98, 50, 48, 117, 89, 109, 120, 49, 90, 88, 78, 48, 89, 87, 78, 114, 99, 121, 53, 105, 99, 51, 82, 109, 98, 50, 120, 107, 90, 88, 73, 61};
    // /data/data/com.bluestacks.appmart
    std::vector<int> dataDataComBluestacksAppmart = {76, 50, 82, 104, 100, 71, 69, 118, 90, 71, 70, 48, 89, 83, 57, 106, 98, 50, 48, 117, 89, 109, 120, 49, 90, 88, 78, 48, 89, 87, 78, 114, 99, 121, 53, 104, 99, 72, 66, 116, 89, 88, 74, 48};
    // /data/data/com.bluestacks.home
    std::vector<int> dataDataComBluestacksHome = {76, 50, 82, 104, 100, 71, 69, 118, 90, 71, 70, 48, 89, 83, 57, 106, 98, 50, 48, 117, 89, 109, 120, 49, 90, 88, 78, 48, 89, 87, 78, 114, 99, 121, 53, 111, 98, 50, 49, 108};
    // /data/data/com.bluestacks.launcher
    std::vector<int> dataDataComBluestacksLauncher = {76, 50, 82, 104, 100, 71, 69, 118, 90, 71, 70, 48, 89, 83, 57, 106, 98, 50, 48, 117, 89, 109, 120, 49, 90, 88, 78, 48, 89, 87, 78, 114, 99, 121, 53, 115, 89, 88, 86, 117, 89, 50, 104, 108, 99, 103, 61, 61};
    // /system/bin/bstfolder
    std::vector<int> systemBinBstfolder = {76, 51, 78, 53, 99, 51, 82, 108, 98, 83, 57, 105, 97, 87, 52, 118, 89, 110, 78, 48, 90, 109, 57, 115, 90, 71, 86, 121};
    // /system/bin/bstfolderd
    std::vector<int> systemBinBstfolderd = {76, 51, 78, 53, 99, 51, 82, 108, 98, 83, 57, 105, 97, 87, 52, 118, 89, 110, 78, 48, 90, 109, 57, 115, 90, 71, 86, 121, 90, 65, 61, 61};
    // /system/bin/bstsyncfs
    std::vector<int> systemBinBstsyncfs = {76, 51, 78, 53, 99, 51, 82, 108, 98, 83, 57, 105, 97, 87, 52, 118, 89, 110, 78, 48, 99, 51, 108, 117, 89, 50, 90, 122};
    // /sys/module/bstsensor
    std::vector<int> sysModuleBstsensor = {76, 51, 78, 53, 99, 121, 57, 116, 98, 50, 82, 49, 98, 71, 85, 118, 89, 110, 78, 48, 99, 50, 86, 117, 99, 50, 57, 121};
    // /sys/module/bstpgaipc
    std::vector<int> sysModuleBstpgaipc = {76, 51, 78, 53, 99, 121, 57, 116, 98, 50, 82, 49, 98, 71, 85, 118, 89, 110, 78, 48, 99, 71, 100, 104, 97, 88, 66, 106};
    // /system/xbin/bstk/su
    std::vector<int> systemXbinBstkSu = {76, 51, 78, 53, 99, 51, 82, 108, 98, 83, 57, 52, 89, 109, 108, 117, 76, 50, 74, 122, 100, 71, 115, 118, 99, 51, 85, 61};
    // /system/xbin/bstk
    std::vector<int> systemXbinBstk = {76, 51, 78, 53, 99, 51, 82, 108, 98, 83, 57, 52, 89, 109, 108, 117, 76, 50, 74, 122, 100, 71, 115, 61};
    // /sys/module/mg
    std::vector<int> sysModuleMg = {76, 51, 78, 53, 99, 121, 57, 116, 98, 50, 82, 49, 98, 71, 85, 118, 98, 87, 99, 61};
    // /system/bin/nox-vbox-sf
    std::vector<int> systemBinNoxVboxSf = {76, 51, 78, 53, 99, 51, 82, 108, 98, 83, 57, 105, 97, 87, 52, 118, 98, 109, 57, 52, 76, 88, 90, 105, 98, 51, 103, 116, 99, 50, 89, 61};
    // /data/data/com.android.ld.appstore
    std::vector<int> dataDataComAndroidLdAppstore = {76, 50, 82, 104, 100, 71, 69, 118, 90, 71, 70, 48, 89, 83, 57, 106, 98, 50, 48, 117, 89, 87, 53, 107, 99, 109, 57, 112, 90, 67, 53, 115, 90, 67, 53, 104, 99, 72, 66, 122, 100, 71, 57, 121, 90, 81, 61, 61};
    // /data/data/com.koplay.launcher
    std::vector<int> dataDataComKoplayLauncher = {76, 50, 82, 104, 100, 71, 69, 118, 90, 71, 70, 48, 89, 83, 57, 106, 98, 50, 48, 117, 97, 50, 57, 119, 98, 71, 70, 53, 76, 109, 120, 104, 100, 87, 53, 106, 97, 71, 86, 121};
    // /system/bin/KOPLAYER.ini
    std::vector<int> systemBinKOPLAYERIni = {76, 51, 78, 53, 99, 51, 82, 108, 98, 83, 57, 105, 97, 87, 52, 118, 83, 48, 57, 81, 84, 69, 70, 90, 82, 86, 73, 117, 97, 87, 53, 112};
    // /system/bin/androidVM-vbox-sf
    std::vector<int> systemBinAndroidVMVboxSf = {76, 51, 78, 53, 99, 51, 82, 108, 98, 83, 57, 105, 97, 87, 52, 118, 89, 87, 53, 107, 99, 109, 57, 112, 90, 70, 90, 78, 76, 88, 90, 105, 98, 51, 103, 116, 99, 50, 89, 61};
    // /sys/module/vboxpcismv
    std::vector<int> sysModuleVboxpcismv = {76, 51, 78, 53, 99, 121, 57, 116, 98, 50, 82, 49, 98, 71, 85, 118, 100, 109, 74, 118, 101, 72, 66, 106, 97, 88, 78, 116, 100, 103, 61, 61};
    // /sys/module/nemusf
    std::vector<int> sysModuleNemusf = {76, 51, 78, 53, 99, 121, 57, 116, 98, 50, 82, 49, 98, 71, 85, 118, 98, 109, 86, 116, 100, 88, 78, 109};
    // /system/bin/genybaseband
    std::vector<int> systemBinGenybaseband = {76, 51, 78, 53, 99, 51, 82, 108, 98, 83, 57, 105, 97, 87, 52, 118, 90, 50, 86, 117, 101, 87, 74, 104, 99, 50, 86, 105, 89, 87, 53, 107};
    // /system/bin/droid4x-vbox-sf
    std::vector<int> systemBinDroid4xVboxSf = {76, 51, 78, 53, 99, 51, 82, 108, 98, 83, 57, 105, 97, 87, 52, 118, 90, 72, 74, 118, 97, 87, 81, 48, 101, 67, 49, 50, 89, 109, 57, 52, 76, 88, 78, 109};
    // /system/bin/droid4x
    std::vector<int> systemBinDroid4x = {76, 51, 78, 53, 99, 51, 82, 108, 98, 83, 57, 105, 97, 87, 52, 118, 90, 72, 74, 118, 97, 87, 81, 48, 101, 65, 61, 61};
    // /sys/module/vboxsf
    std::vector<int> sysModuleVboxsf = {76, 51, 78, 53, 99, 121, 57, 116, 98, 50, 82, 49, 98, 71, 85, 118, 100, 109, 74, 118, 101, 72, 78, 109};
    // /sys/module/msf
    std::vector<int> sysModuleMsf = {76, 51, 78, 53, 99, 121, 57, 116, 98, 50, 82, 49, 98, 71, 85, 118, 98, 88, 78, 109};

    inline std::vector<std::string>
        emulatorFiles{
            getStringFromAscii(fstabAndy),
            getStringFromAscii(ueventdAndyRc),
            getStringFromAscii(fstabNox),
            getStringFromAscii(initNoxRc),
            getStringFromAscii(ueventdNoxRc),
            getStringFromAscii(devSocketGemud),
            getStringFromAscii(devQemuPipe),
            getStringFromAscii(devMemufp),
            getStringFromAscii(devMemuQuest),
            getStringFromAscii(devMemuuser),
            getStringFromAscii(systemLibMemuquestKo),
            getStringFromAscii(systemBinNoxProp),
            getStringFromAscii(systemBinNoxd),
            getStringFromAscii(systemLibLibnoxdSo),
            getStringFromAscii(systemPrivAppComBluestacksBstfolderApk),
            getStringFromAscii(devBstGps),
            getStringFromAscii(devBstIme),
            getStringFromAscii(devBstGyro),
            getStringFromAscii(devBstmegn),
            getStringFromAscii(systemXbinPhoenixCompat),
            getStringFromAscii(dataSystemPhoenixlogAddr),
            getStringFromAscii(systemPhoenixos),
            getStringFromAscii(systemLibLibnoxspeedupSo),
            getStringFromAscii(systemEtcInitNoxSh),
            getStringFromAscii(systemBinNox),
            getStringFromAscii(systemLibHwGpsLdSo),
            getStringFromAscii(systemLibHwSensorsLdSo),
            getStringFromAscii(systemLibLibldutilsSo),
            getStringFromAscii(systemBinLdinit),
            getStringFromAscii(systemAppLDAppStoreLDAppStoreApk),
            getStringFromAscii(dataDataComLdmnqLauncher3FilesLauncherPreferences),
            getStringFromAscii(dataBluestacksProp),
            getStringFromAscii(dataBstconfProp),
            getStringFromAscii(mntWindows),
            getStringFromAscii(mntWindowsBstSharedFolder),
            getStringFromAscii(libVboxguestKo),
            getStringFromAscii(libVboxsfKo),
            getStringFromAscii(dataDataComBluestacksBstfolder),
            getStringFromAscii(dataDataComBluestacksAppmart),
            getStringFromAscii(dataDataComBluestacksHome),
            getStringFromAscii(dataDataComBluestacksLauncher),
            getStringFromAscii(systemBinBstfolder),
            getStringFromAscii(systemBinBstfolderd),
            getStringFromAscii(systemBinBstsyncfs),
            getStringFromAscii(sysModuleBstsensor),
            getStringFromAscii(sysModuleBstpgaipc),
            getStringFromAscii(systemXbinBstkSu),
            getStringFromAscii(systemXbinBstk),
            getStringFromAscii(sysModuleMg),
            getStringFromAscii(systemBinNoxVboxSf),
            getStringFromAscii(dataDataComAndroidLdAppstore),
            getStringFromAscii(dataDataComKoplayLauncher),
            getStringFromAscii(systemBinKOPLAYERIni),
            getStringFromAscii(systemBinAndroidVMVboxSf),
            getStringFromAscii(sysModuleVboxpcismv),
            getStringFromAscii(sysModuleNemusf),
            getStringFromAscii(systemBinGenybaseband),
            getStringFromAscii(systemBinDroid4xVboxSf),
            getStringFromAscii(systemBinDroid4x),
            getStringFromAscii(sysModuleVboxsf),
            getStringFromAscii(sysModuleMsf),
        };

    // systemBinLdmountsf
    std::vector<int> systemBinLdmountsf = {76, 51, 78, 53, 99, 51, 82, 108, 98, 83, 57, 105, 97, 87, 52, 118, 98, 71, 82, 116, 98, 51, 86, 117, 100, 72, 78, 109};
    // systemBinBstsvcmgrtest
    std::vector<int> systemBinBstsvcmgrtest = {76, 51, 78, 53, 99, 51, 82, 108, 98, 83, 57, 105, 97, 87, 52, 118, 89, 110, 78, 48, 99, 51, 90, 106, 98, 87, 100, 121, 100, 71, 86, 122, 100, 65, 61, 61};
    // systemBinBstshutdown
    std::vector<int> systemBinBstshutdown = {76, 51, 78, 53, 99, 51, 82, 108, 98, 83, 57, 105, 97, 87, 52, 118, 89, 110, 78, 48, 99, 50, 104, 49, 100, 71, 82, 118, 100, 50, 52, 61};
    // systemBinBstime
    std::vector<int> systemBinBstime = {76, 51, 78, 53, 99, 51, 82, 108, 98, 83, 57, 105, 97, 87, 52, 118, 89, 110, 78, 48, 97, 87, 49, 108};
    // systemBinBstshutdownCore
    std::vector<int> systemBinBstshutdownCore = {76, 51, 78, 53, 99, 51, 82, 108, 98, 83, 57, 105, 97, 87, 52, 118, 89, 110, 78, 48, 99, 50, 104, 49, 100, 71, 82, 118, 100, 50, 53, 102, 89, 50, 57, 121, 90, 81, 61, 61};
    // bootBstmodsBstpgaipcKo
    std::vector<int> bootBstmodsBstpgaipcKo = {76, 50, 74, 118, 98, 51, 81, 118, 89, 110, 78, 48, 98, 87, 57, 107, 99, 121, 57, 105, 99, 51, 82, 119, 90, 50, 70, 112, 99, 71, 77, 117, 97, 50, 56, 61};
    // bootBstmodsBstaudioKo
    std::vector<int> bootBstmodsBstaudioKo = {76, 50, 74, 118, 98, 51, 81, 118, 89, 110, 78, 48, 98, 87, 57, 107, 99, 121, 57, 105, 99, 51, 82, 104, 100, 87, 82, 112, 98, 121, 53, 114, 98, 119, 61, 61};
    // bootBstmodsBstcameraKo
    std::vector<int> bootBstmodsBstcameraKo = {76, 50, 74, 118, 98, 51, 81, 118, 89, 110, 78, 48, 98, 87, 57, 107, 99, 121, 57, 105, 99, 51, 82, 106, 89, 87, 49, 108, 99, 109, 69, 117, 97, 50, 56, 61};
    // bootBstmodsBstvmsgKo
    std::vector<int> bootBstmodsBstvmsgKo = {76, 50, 74, 118, 98, 51, 81, 118, 89, 110, 78, 48, 98, 87, 57, 107, 99, 121, 57, 105, 99, 51, 82, 50, 98, 88, 78, 110, 76, 109, 116, 118};
    // bootBstmodsBstinputKo
    std::vector<int> bootBstmodsBstinputKo = {76, 50, 74, 118, 98, 51, 81, 118, 89, 110, 78, 48, 98, 87, 57, 107, 99, 121, 57, 105, 99, 51, 82, 112, 98, 110, 66, 49, 100, 67, 53, 114, 98, 119, 61, 61};
    // bootBstsetupEnv
    std::vector<int> bootBstsetupEnv = {76, 50, 74, 118, 98, 51, 81, 118, 89, 110, 78, 48, 99, 50, 86, 48, 100, 88, 65, 117, 90, 87, 53, 50};
    // bootBinBstreport
    std::vector<int> bootBinBstreport = {76, 50, 74, 118, 98, 51, 81, 118, 89, 109, 108, 117, 76, 50, 74, 122, 100, 72, 74, 108, 99, 71, 57, 121, 100, 65, 61, 61};
    // bootBinBstconf
    std::vector<int> bootBinBstconf = {76, 50, 74, 118, 98, 51, 81, 118, 89, 109, 108, 117, 76, 50, 74, 122, 100, 71, 78, 118, 98, 109, 89, 61};
    // bootBstsetconfSh
    std::vector<int> bootBstsetconfSh = {76, 50, 74, 118, 98, 51, 81, 118, 89, 110, 78, 48, 99, 50, 86, 48, 89, 50, 57, 117, 90, 105, 53, 122, 97, 65, 61, 61};

    inline std::vector<std::string> newEmulatorFiles{
        getStringFromAscii(systemBinLdinit),
        getStringFromAscii(systemBinLdmountsf),
        getStringFromAscii(systemBinBstsvcmgrtest),
        getStringFromAscii(systemBinBstshutdown),
        getStringFromAscii(systemBinBstsyncfs),
        getStringFromAscii(systemBinBstime),
        getStringFromAscii(systemBinBstfolder),
        getStringFromAscii(systemBinBstshutdownCore),
        getStringFromAscii(bootBstmodsBstpgaipcKo),
        getStringFromAscii(bootBstmodsBstaudioKo),
        getStringFromAscii(bootBstmodsBstcameraKo),
        getStringFromAscii(bootBstmodsBstvmsgKo),
        getStringFromAscii(bootBstmodsBstinputKo),
        getStringFromAscii(bootBstsetupEnv),
        getStringFromAscii(bootBinBstreport),
        getStringFromAscii(bootBinBstconf),
        getStringFromAscii(bootBstsetconfSh),
        getStringFromAscii(systemBinNoxProp),
        getStringFromAscii(systemBinNoxVboxSf),
        getStringFromAscii(systemBinNoxd),
        getStringFromAscii(systemLibLibnoxdSo),
        getStringFromAscii(systemLibLibnoxspeedupSo),
    };

    // sdk
    std::vector<int> sdk = {99, 50, 82, 114};
    // andy
    std::vector<int> andy = {89, 87, 53, 107, 101, 81, 61, 61};
    // google_sdk
    std::vector<int> google_sdk = {90, 50, 57, 118, 90, 50, 120, 108, 88, 51, 78, 107, 97, 119, 61, 61};
    // droid4x
    std::vector<int> droid4x = {90, 72, 74, 118, 97, 87, 81, 48, 101, 65, 61, 61};
    // nox
    std::vector<int> nox = {98, 109, 57, 52};
    // sdk_x86
    std::vector<int> sdk_x86 = {99, 50, 82, 114, 88, 51, 103, 52, 78, 103, 61, 61};
    // vbox86p
    std::vector<int> vbox86p = {100, 109, 74, 118, 101, 68, 103, 50, 99, 65, 61, 61};
    // emu64x
    std::vector<int> emu64x = {90, 87, 49, 49, 78, 106, 82, 52};
    // generic
    std::vector<int> generic = {90, 50, 86, 117, 90, 88, 74, 112, 89, 119, 61, 61};
    // generic_x86_64
    std::vector<int> generic_x86_64 = {90, 50, 86, 117, 90, 88, 74, 112, 89, 49, 57, 52, 79, 68, 90, 102, 78, 106, 81, 61};
    // goldfish
    std::vector<int> goldfish = {90, 50, 57, 115, 90, 71, 90, 112, 99, 50, 103, 61};
    // vbox86
    std::vector<int> vbox86 = {100, 109, 74, 118, 101, 68, 103, 50};
    // vmX86
    std::vector<int> vmX86 = {86, 107, 49, 102, 101, 68, 103, 50};
    // intel
    std::vector<int> intel = {97, 87, 53, 48, 90, 87, 119, 61};
    // amd
    std::vector<int> amd = {89, 87, 49, 107};
    // x86
    std::vector<int> x86 = {101, 68, 103, 50};

    inline std::vector<std::string> products{
        getStringFromAscii(sdk),
        getStringFromAscii(andy),
        getStringFromAscii(google_sdk),
        getStringFromAscii(droid4x),
        getStringFromAscii(nox),
        getStringFromAscii(sdk_x86),
        getStringFromAscii(vbox86p),
        getStringFromAscii(emu64x),
    };

    inline std::vector<std::string> manufacturers{
        getStringFromAscii(sdk),
        getStringFromAscii(andy),
        getStringFromAscii(google_sdk),
        getStringFromAscii(droid4x),
        getStringFromAscii(nox),
        getStringFromAscii(sdk_x86),
        getStringFromAscii(vbox86p),
    };

    inline std::vector<std::string> deviceInfo{
        getStringFromAscii(generic),
        getStringFromAscii(andy),
        getStringFromAscii(droid4x),
        getStringFromAscii(nox),
        getStringFromAscii(generic_x86_64),
        getStringFromAscii(vbox86p),
        getStringFromAscii(emu64x),
    };

    inline std::vector<std::string> hardwares{
        getStringFromAscii(goldfish),
        getStringFromAscii(vbox86),
        getStringFromAscii(nox),
        getStringFromAscii(vmX86),
        getStringFromAscii(intel),
        getStringFromAscii(amd),
        getStringFromAscii(x86),
    };
}
