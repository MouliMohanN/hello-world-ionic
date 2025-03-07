//
// Created by FCI on 05-03-2025.
//

#include "string"
#include "vector"

namespace ConfigData {

    // fstab.andy
    std::vector<int> fstabAndy = {90,110,78,48,89,87,73,117,89,87,53,107,101,81,61,61};
    // ueventd.andy.rc
    std::vector<int> ueventdAndyRc = {100,87,86,50,90,87,53,48,90,67,53,104,98,109,82,53,76,110,74,106};
    // fstab.nox
    std::vector<int> fstabNox = {90,110,78,48,89,87,73,117,98,109,57,52};
    // init.nox.rc
    std::vector<int> initNoxRc = {97,87,53,112,100,67,53,117,98,51,103,117,99,109,77,61};
    // ueventd.nox.rc
    std::vector<int> ueventdNoxRc = {100,87,86,50,90,87,53,48,90,67,53,117,98,51,103,117,99,109,77,61};
    // dev/socket/qemud
    std::vector<int> devSocketGemud = {90,71,86,50,76,51,78,118,89,50,116,108,100,67,57,120,90,87,49,49,90,65,61,61};
    // dev/qemu_pipe
    std::vector<int> devQemuPipe = {90,71,86,50,76,51,70,108,98,88,86,102,99,71,108,119,90,81,61,61};
    // /dev/memufp
    std::vector<int> devMemufp = {76,50,82,108,100,105,57,116,90,87,49,49,90,110,65,61};
    // /dev/memuguest
    std::vector<int> devMemuQuest = {76,50,82,108,100,105,57,116,90,87,49,49,90,51,86,108,99,51,81,61};
    // /dev/memuuser
    std::vector<int> devMemuuser = {76,50,82,108,100,105,57,116,90,87,49,49,100,88,78,108,99,103,61,61};
    // /system/lib/memuguest.ko
    std::vector<int> systemLibMemuquestKo = {76,51,78,53,99,51,82,108,98,83,57,115,97,87,73,118,98,87,86,116,100,87,100,49,90,88,78,48,76,109,116,118};
    // /system/bin/nox-prop
    std::vector<int> systemBinNoxProp = {76,51,78,53,99,51,82,108,98,83,57,105,97,87,52,118,98,109,57,52,76,88,66,121,98,51,65,61};
    // /system/bin/noxd
    std::vector<int> systemBinNoxd = {76,51,78,53,99,51,82,108,98,83,57,105,97,87,52,118,98,109,57,52,90,65,61,61};

    inline std::vector<std::string> emulatorFiles {
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
            "/system/bin/noxd",
            "/system/lib/libnoxd.so",
            "/system/priv-app/com.bluestacks.bstfolder.apk",
            "/dev/bst_gps",
            "/dev/bst_ime",
            "/dev/bstgyro",
            "/dev/bstmegn",
            "/system/xbin/phoenix_compat",
            "/data/system/phoenixlog.addr",
            "/system/phoenixos",
            "/system/lib/libnoxspeedup.so",
            "/system/etc/init.nox.sh",
            "/system/bin/nox",
            "/system/lib/hw/gps.ld.so",
            "/system/lib/hw/sensors.ld.so",
            "/system/lib/libldutils.so",
            "/system/bin/ldinit",
            "/system/app/LDAppStore/LDAppStore.apk",
            "/data/data/com.ldmnq.launcher3/files/launcher.preferences",
            "/data/.bluestacks.prop",
            "/data/.bstconf.prop",
            "/mnt/windows",
            "/mnt/windows/BstSharedFolder",
            "/lib/vboxguest.ko",
            "/lib/vboxsf.ko",
            "/data/data/com.bluestacks.bstfolder",
            "/data/data/com.bluestacks.appmart",
            "/data/data/com.bluestacks.home",
            "/data/data/com.bluestacks.launcher",
            "/system/bin/bstfolder",
            "/system/bin/bstfolderd",
            "/system/bin/bstsyncfs",
            "/sys/module/bstsensor",
            "/sys/module/bstpgaipc",
            "/system/xbin/bstk/su",
            "/system/xbin/bstk",
            "/sys/module/mg",
            "/system/bin/nox-vbox-sf",
            "/system/bin/ldinit",
            "/system/app/LDAppStore/LDAppStore.apk",
            "/data/data/com.android.ld.appstore",
            "/data/data/com.koplay.launcher",
            "/system/bin/KOPLAYER.ini",
            "/system/bin/androidVM-vbox-sf",
            "/sys/module/vboxpcismv",
            "/sys/module/nemusf",
            "/system/bin/genybaseband",
            "/system/bin/droid4x-vbox-sf",
            "/system/bin/droid4x",
            "/sys/module/vboxsf",
            "/sys/module/bstpgaipc",
            "/system/xbin/bstk/su",
            "/system/xbin/bstk",
            "/sys/module/msf",
    };

    inline std::vector<std::string> newEmulatorFiles {
            "/system/bin/ldinit",
            "/system/bin/ldmountsf",
            "/system/bin/bstsvcmgrtest",
            "/system/bin/bstshutdown",
            "/system/bin/bstsyncfs",
            "/system/bin/bstime",
            "/system/bin/bstfolder",
            "/system/bin/bstshutdown_core",
            "/boot/bstmods/bstpgaipc.ko",
            "/boot/bstmods/bstaudio.ko",
            "/boot/bstmods/bstcamera.ko",
            "/boot/bstmods/bstvmsg.ko",
            "/boot/bstmods/bstinput.ko",
            "/boot/bstsetup.env",
            "/boot/bin/bstreport",
            "/boot/bin/bstconf",
            "/boot/bstsetconf.sh",
            "/system/bin/nox-prop",
            "/system/bin/nox-vbox-sf",
            "/system/bin/noxd",
            "/system/lib/libnoxd.so",
            "/system/lib/libnoxspeedup.so",
    };

    inline std::vector<std::string> products {
            "sdk",
            "andy",
            "google_sdk",
            "droid4x",
            "nox",
            "sdk_x86",
            "vbox86p",
            "emu64x",
    };

    inline std::vector<std::string> manufacturers {
            "sdk",
            "andy",
            "google_sdk",
            "droid4x",
            "nox",
            "sdk_x86",
            "vbox86p",
    };

    inline std::vector<std::string> deviceInfo {
            "generic",
            "andy",
            "droid4x",
            "nox",
            "generic_x86_64",
            "vbox86p",
            "emu64x",
    };

    inline std::vector<std::string> hardwares {
            "goldfish",
            "vbox86",
            "nox",
            "VM_x86",
            "intel",
            "amd",
            "x86",
    };
}
