package com.example.app.security.utils

import android.content.Context
import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import android.os.Build
import com.example.app.utils.EncryptedStorage
import com.example.app.utils.SECURITY_LOG_TAG
import com.example.app.utils.decodeToString
import com.example.app.utils.isNull
import com.example.gjdl_zxlnt.IlfnCaoqwOkc
import java.io.File
import java.io.IOException
import java.util.Scanner

private object RootStorageConstants {
  fun getKeyName(): String {
    // deviceroot_detected -> wwmyrseazd_llzjgwge
    return intArrayOf(100, 51, 100, 116, 101, 88, 74, 122, 90, 87, 70, 54, 90, 70, 57, 115, 98, 72, 112, 113, 90, 51, 100, 110, 90, 81, 61, 61).decodeToString()
  }

  fun getTrueValue(): String {
    // detectionhasbeenfoundforrrot -> fftdaqejhasjrtsarzewlmuwvuqu
    return intArrayOf(90, 109, 90, 48, 90, 71, 70, 120, 90, 87, 112, 111, 89, 88, 78, 113, 99, 110, 82, 122, 89, 88, 74, 54, 90, 88, 100, 115, 98, 88, 86, 51, 100, 110, 86, 120, 100, 81, 61, 61).decodeToString()
  }

  fun getFalseValue(): String {
    // detectionnotfoundforrrot -> bbpzwmafdccgrzewlmuwvuqu
    return intArrayOf(89, 109, 74, 119, 101, 110, 100, 116, 89, 87, 90, 107, 89, 50, 78, 110, 99, 110, 112, 108, 100, 50, 120, 116, 100, 88, 100, 50, 100, 88, 70, 49).decodeToString()
  }
}

private object Constants {
  fun getSuPaths(): List<String> {
    // /system/app/Superuser.apk
    val superUser = intArrayOf(76,51,78,53,99,51,82,108,98,83,57,104,99,72,65,118,85,51,86,119,90,88,74,49,99,50,86,121,76,109,70,119,97,119,61,61)
    // /sbin/su
    val sbinSu = intArrayOf(76,51,78,105,97,87,52,118,99,51,85,61)
    // /system/bin/su
    val systemBinSu = intArrayOf(76,51,78,53,99,51,82,108,98,83,57,105,97,87,52,118,99,51,85,61)
    // /system/xbin/su
    val systemXbinSu = intArrayOf(76,51,78,53,99,51,82,108,98,83,57,52,89,109,108,117,76,51,78,49)
    // /data/local/xbin/su
    val dataLocalXbinSu = intArrayOf(76,50,82,104,100,71,69,118,98,71,57,106,89,87,119,118,101,71,74,112,98,105,57,122,100,81,61,61)
    // /data/local/bin/su
    val dataLocalBinSu = intArrayOf(76,50,82,104,100,71,69,118,98,71,57,106,89,87,119,118,89,109,108,117,76,51,78,49)
    // /system/sd/xbin/su
    val systemSdXbinSu = intArrayOf(76,51,78,53,99,51,82,108,98,83,57,122,90,67,57,52,89,109,108,117,76,51,78,49)
    // /system/bin/failsafe/su
    val systemBinFailsafeSu = intArrayOf(76,51,78,53,99,51,82,108,98,83,57,105,97,87,52,118,90,109,70,112,98,72,78,104,90,109,85,118,99,51,85,61)
    // /data/local/su
    val dataLocalSu = intArrayOf(76,50,82,104,100,71,69,118,98,71,57,106,89,87,119,118,99,51,85,61)
    // /su/bin/su
    val suBinSu = intArrayOf(76,51,78,49,76,50,74,112,98,105,57,122,100,81,61,61)
    // /system/bin/.ext/su
    val systemBinExtSu = intArrayOf(76, 51, 78, 53, 99, 51, 82, 108, 98, 83, 57, 105, 97, 87, 52, 118, 76, 109, 86, 52, 100, 67, 57, 122, 100, 81, 61, 61)
    // /system/usr/we-need-root/su
    val systemUsrWeNeedRootSu = intArrayOf(76, 51, 78, 53, 99, 51, 82, 108, 98, 83, 57, 49, 99, 51, 73, 118, 100, 50, 85, 116, 98, 109, 86, 108, 90, 67, 49, 121, 98, 50, 57, 48, 76, 51, 78, 49)
    // /cache/su
    val cacheSu = intArrayOf(76, 50, 78, 104, 89, 50, 104, 108, 76, 51, 78, 49)
    // /data/su
    val dataSu = intArrayOf(76, 50, 82, 104, 100, 71, 69, 118, 99, 51, 85, 61)
    // /dev/su
    val devSu = intArrayOf(76, 50, 82, 108, 100, 105, 57, 122, 100, 81, 61, 61)

    /** *********************Additional su paths************************* */

    // /system/xbin/daemonsu
    val systemXbinDaemonsu = intArrayOf(76, 51, 78, 53, 99, 51, 82, 108, 98, 83, 57, 52, 89, 109, 108, 117, 76, 50, 82, 104, 90, 87, 49, 118, 98, 110, 78, 49)
    // /system/bin/.ext/daemonsu
    val systemBinExtDaemonsu = intArrayOf(76, 51, 78, 53, 99, 51, 82, 108, 98, 83, 57, 105, 97, 87, 52, 118, 76, 109, 86, 52, 100, 67, 57, 107, 89, 87, 86, 116, 98, 50, 53, 122, 100, 81, 61, 61)
    // /system/etc/.has_su_daemon
    val systemEtcHasSuDaemon = intArrayOf(76, 51, 78, 53, 99, 51, 82, 108, 98, 83, 57, 108, 100, 71, 77, 118, 76, 109, 104, 104, 99, 49, 57, 122, 100, 86, 57, 107, 89, 87, 86, 116, 98, 50, 52, 61)
    // /system/etc/.installed_su_daemon
    val systemEtcInstalledSuDaemon = intArrayOf(76, 51, 78, 53, 99, 51, 82, 108, 98, 83, 57, 108, 100, 71, 77, 118, 76, 109, 108, 117, 99, 51, 82, 104, 98, 71, 120, 108, 90, 70, 57, 122, 100, 86, 57, 107, 89, 87, 86, 116, 98, 50, 52, 61)
    // /system/etc/init.d/99SuperSUDaemon
    val systemEtcInitD99SuperSUDaemon = intArrayOf(76, 51, 78, 53, 99, 51, 82, 108, 98, 83, 57, 108, 100, 71, 77, 118, 97, 87, 53, 112, 100, 67, 53, 107, 76, 122, 107, 53, 85, 51, 86, 119, 90, 88, 74, 84, 86, 85, 82, 104, 90, 87, 49, 118, 98, 103, 61, 61)
    // /system/etc/init.d/99su
    val systemEtcInitD99su = intArrayOf(76, 51, 78, 53, 99, 51, 82, 108, 98, 83, 57, 108, 100, 71, 77, 118, 97, 87, 53, 112, 100, 67, 53, 107, 76, 122, 107, 53, 99, 51, 85, 61)
    // /system/etc/init.d/su
    val systemEtcInitDSu = intArrayOf(76, 51, 78, 53, 99, 51, 82, 108, 98, 83, 57, 108, 100, 71, 77, 118, 97, 87, 53, 112, 100, 67, 53, 107, 76, 51, 78, 49)
    // /system/etc/su.conf
    val systemEtcSuConf = intArrayOf(76, 51, 78, 53, 99, 51, 82, 108, 98, 83, 57, 108, 100, 71, 77, 118, 99, 51, 85, 117, 89, 50, 57, 117, 90, 103, 61, 61)
    // /system/etc/.installed_su
    val systemEtcInstalledSu = intArrayOf(76, 51, 78, 53, 99, 51, 82, 108, 98, 83, 57, 108, 100, 71, 77, 118, 76, 109, 108, 117, 99, 51, 82, 104, 98, 71, 120, 108, 90, 70, 57, 122, 100, 81, 61, 61)
    // /system/etc/.has_su
    val systemEtcHasSu = intArrayOf(76, 51, 78, 53, 99, 51, 82, 108, 98, 83, 57, 108, 100, 71, 77, 118, 76, 109, 104, 104, 99, 49, 57, 122, 100, 81, 61, 61)
    // /system/xbin/supersu
    val systemXbinSupersu = intArrayOf(76, 51, 78, 53, 99, 51, 82, 108, 98, 83, 57, 52, 89, 109, 108, 117, 76, 51, 78, 49, 99, 71, 86, 121, 99, 51, 85, 61)
    // /system/bin/.ext/supersu
    val systemBinExtSupersu = intArrayOf(76, 51, 78, 53, 99, 51, 82, 108, 98, 83, 57, 105, 97, 87, 52, 118, 76, 109, 86, 52, 100, 67, 57, 122, 100, 88, 66, 108, 99, 110, 78, 49)
    // /system/etc/.has_supersu_daemon
    val systemEtcHasSupersuDaemon = intArrayOf(76, 51, 78, 53, 99, 51, 82, 108, 98, 83, 57, 108, 100, 71, 77, 118, 76, 109, 104, 104, 99, 49, 57, 122, 100, 88, 66, 108, 99, 110, 78, 49, 88, 50, 82, 104, 90, 87, 49, 118, 98, 103, 61, 61)
    // /system/etc/.installed_supersu_daemon
    val systemEtcInstalledSupersuDaemon = intArrayOf(76, 51, 78, 53, 99, 51, 82, 108, 98, 83, 57, 108, 100, 71, 77, 118, 76, 109, 108, 117, 99, 51, 82, 104, 98, 71, 120, 108, 90, 70, 57, 122, 100, 88, 66, 108, 99, 110, 78, 49, 88, 50, 82, 104, 90, 87, 49, 118, 98, 103, 61, 61)
    // /system/etc/init.d/99supersu
    val systemEtcInitD99supersu = intArrayOf(76, 51, 78, 53, 99, 51, 82, 108, 98, 83, 57, 108, 100, 71, 77, 118, 97, 87, 53, 112, 100, 67, 53, 107, 76, 122, 107, 53, 99, 51, 86, 119, 90, 88, 74, 122, 100, 81, 61, 61)
    // /system/etc/init.d/supersu
    val systemEtcInitDSupersu = intArrayOf(76, 51, 78, 53, 99, 51, 82, 108, 98, 83, 57, 108, 100, 71, 77, 118, 97, 87, 53, 112, 100, 67, 53, 107, 76, 51, 78, 49, 99, 71, 86, 121, 99, 51, 85, 61)
    // /system/etc/supersu.conf
    val systemEtcSupersuConf = intArrayOf(76, 51, 78, 53, 99, 51, 82, 108, 98, 83, 57, 108, 100, 71, 77, 118, 99, 51, 86, 119, 90, 88, 74, 122, 100, 83, 53, 106, 98, 50, 53, 109)
    // /system/etc/.installed_supersu
    val systemEtcInstalledSupersu = intArrayOf(76, 51, 78, 53, 99, 51, 82, 108, 98, 83, 57, 108, 100, 71, 77, 118, 76, 109, 108, 117, 99, 51, 82, 104, 98, 71, 120, 108, 90, 70, 57, 122, 100, 88, 66, 108, 99, 110, 78, 49)
    // /system/etc/.has_supersu
    val systemEtcHasSupersu = intArrayOf(76, 51, 78, 53, 99, 51, 82, 108, 98, 83, 57, 108, 100, 71, 77, 118, 76, 109, 104, 104, 99, 49, 57, 122, 100, 88, 66, 108, 99, 110, 78, 49)
    // /system/xbin/magisk
    val systemXbinMagisk = intArrayOf(76, 51, 78, 53, 99, 51, 82, 108, 98, 83, 57, 52, 89, 109, 108, 117, 76, 50, 49, 104, 90, 50, 108, 122, 97, 119, 61, 61)
    // /system/bin/.ext/magisk
    val systemBinExtMagisk = intArrayOf(76, 51, 78, 53, 99, 51, 82, 108, 98, 83, 57, 105, 97, 87, 52, 118, 76, 109, 86, 52, 100, 67, 57, 116, 89, 87, 100, 112, 99, 50, 115, 61)
    // /system/etc/.has_magisk_daemon
    val systemEtcHasMagiskDaemon = intArrayOf(76, 51, 78, 53, 99, 51, 82, 108, 98, 83, 57, 108, 100, 71, 77, 118, 76, 109, 104, 104, 99, 49, 57, 116, 89, 87, 100, 112, 99, 50, 116, 102, 90, 71, 70, 108, 98, 87, 57, 117)
    // /system/etc/.installed_magisk_daemon
    val systemEtcInstalledMagiskDaemon = intArrayOf(76, 51, 78, 53, 99, 51, 82, 108, 98, 83, 57, 108, 100, 71, 77, 118, 76, 109, 108, 117, 99, 51, 82, 104, 98, 71, 120, 108, 90, 70, 57, 116, 89, 87, 100, 112, 99, 50, 116, 102, 90, 71, 70, 108, 98, 87, 57, 117)
    // /system/etc/init.d/99MagiskDaemon
    val systemEtcInitD99MagiskDaemon = intArrayOf(76, 51, 78, 53, 99, 51, 82, 108, 98, 83, 57, 108, 100, 71, 77, 118, 97, 87, 53, 112, 100, 67, 53, 107, 76, 122, 107, 53, 84, 87, 70, 110, 97, 88, 78, 114, 82, 71, 70, 108, 98, 87, 57, 117)
    // /system/etc/init.d/99magisk
    val systemEtcInitD99magisk = intArrayOf(76, 51, 78, 53, 99, 51, 82, 108, 98, 83, 57, 108, 100, 71, 77, 118, 97, 87, 53, 112, 100, 67, 53, 107, 76, 122, 107, 53, 98, 87, 70, 110, 97, 88, 78, 114)
    // /system/etc/init.d/magisk
    val systemEtcInitDMagisk = intArrayOf(76, 51, 78, 53, 99, 51, 82, 108, 98, 83, 57, 108, 100, 71, 77, 118, 97, 87, 53, 112, 100, 67, 53, 107, 76, 50, 49, 104, 90, 50, 108, 122, 97, 119, 61, 61)
    // /system/etc/magisk.conf
    val systemEtcMagiskConf = intArrayOf(76, 51, 78, 53, 99, 51, 82, 108, 98, 83, 57, 108, 100, 71, 77, 118, 98, 87, 70, 110, 97, 88, 78, 114, 76, 109, 78, 118, 98, 109, 89, 61)
    // /system/etc/.installed_magisk
    val systemEtcInstalledMagisk = intArrayOf(76, 51, 78, 53, 99, 51, 82, 108, 98, 83, 57, 108, 100, 71, 77, 118, 76, 109, 108, 117, 99, 51, 82, 104, 98, 71, 120, 108, 90, 70, 57, 116, 89, 87, 100, 112, 99, 50, 115, 61)
    // /system/etc/.has_magisk
    val systemEtcHasMagisk = intArrayOf(76, 51, 78, 53, 99, 51, 82, 108, 98, 83, 57, 108, 100, 71, 77, 118, 76, 109, 104, 104, 99, 49, 57, 116, 89, 87, 100, 112, 99, 50, 115, 61)


    return mutableListOf(
      superUser.decodeToString(),
      sbinSu.decodeToString(),
      systemBinSu.decodeToString(),
      systemXbinSu.decodeToString(),
      dataLocalXbinSu.decodeToString(),
      dataLocalBinSu.decodeToString(),
      systemSdXbinSu.decodeToString(),
      systemBinFailsafeSu.decodeToString(),
      dataLocalSu.decodeToString(),
      suBinSu.decodeToString(),
      systemBinExtSu.decodeToString(),
      systemUsrWeNeedRootSu.decodeToString(),
      cacheSu.decodeToString(),
      dataSu.decodeToString(),
      devSu.decodeToString(),
      // Additional su paths
      systemXbinDaemonsu.decodeToString(),
      systemBinExtDaemonsu.decodeToString(),
      systemEtcHasSuDaemon.decodeToString(),
      systemEtcInstalledSuDaemon.decodeToString(),
      systemEtcInitD99SuperSUDaemon.decodeToString(),
      systemEtcInitD99su.decodeToString(),
      systemEtcInitDSu.decodeToString(),
      systemEtcSuConf.decodeToString(),
      systemEtcInstalledSu.decodeToString(),
      systemEtcHasSu.decodeToString(),
      systemXbinSupersu.decodeToString(),
      systemBinExtSupersu.decodeToString(),
      systemEtcHasSupersuDaemon.decodeToString(),
      systemEtcInstalledSupersuDaemon.decodeToString(),
      systemEtcInitD99SuperSUDaemon.decodeToString(),
      systemEtcInitD99supersu.decodeToString(),
      systemEtcInitDSupersu.decodeToString(),
      systemEtcSupersuConf.decodeToString(),
      systemEtcInstalledSupersu.decodeToString(),
      systemEtcHasSupersu.decodeToString(),
      systemXbinMagisk.decodeToString(),
      systemBinExtMagisk.decodeToString(),
      systemEtcHasMagiskDaemon.decodeToString(),
      systemEtcInstalledMagiskDaemon.decodeToString(),
      systemEtcInitD99MagiskDaemon.decodeToString(),
      systemEtcInitD99magisk.decodeToString(),
      systemEtcInitDMagisk.decodeToString(),
      systemEtcMagiskConf.decodeToString(),
      systemEtcInstalledMagisk.decodeToString(),
      systemEtcHasMagisk.decodeToString()
    )
  }

  fun getBusyBoxPaths(): List<String> {
    // /sbin/busybox
    val sbinBusybox = intArrayOf(76, 51, 78, 105, 97, 87, 52, 118, 89, 110, 86, 122, 101, 87, 74, 118, 101, 65, 61, 61)
    // /system/bin/busybox
    val systemBinBusyboc = intArrayOf(76, 51, 78, 53, 99, 51, 82, 108, 98, 83, 57, 105, 97, 87, 52, 118, 89, 110, 86, 122, 101, 87, 74, 118, 101, 65, 61, 61)
    // /system/xbin/busybox
    val systemXbinBusybox = intArrayOf(76, 51, 78, 53, 99, 51, 82, 108, 98, 83, 57, 52, 89, 109, 108, 117, 76, 50, 74, 49, 99, 51, 108, 105, 98, 51, 103, 61)
    // /data/local/xbin/busybox
    val dataLocalXbinBusybox = intArrayOf(76, 50, 82, 104, 100, 71, 69, 118, 98, 71, 57, 106, 89, 87, 119, 118, 101, 71, 74, 112, 98, 105, 57, 105, 100, 88, 78, 53, 89, 109, 57, 52)
    // /data/local/bin/busybox
    val dataLocalBinBusybox = intArrayOf(76, 50, 82, 104, 100, 71, 69, 118, 98, 71, 57, 106, 89, 87, 119, 118, 89, 109, 108, 117, 76, 50, 74, 49, 99, 51, 108, 105, 98, 51, 103, 61)
    // /system/sd/xbin/busybox
    val systemSdXbinBusybox = intArrayOf(76, 51, 78, 53, 99, 51, 82, 108, 98, 83, 57, 122, 90, 67, 57, 52, 89, 109, 108, 117, 76, 50, 74, 49, 99, 51, 108, 105, 98, 51, 103, 61)
    // /system/bin/failsafe/busybox
    val systemBinFailsafeBusybox = intArrayOf(76, 51, 78, 53, 99, 51, 82, 108, 98, 83, 57, 105, 97, 87, 52, 118, 90, 109, 70, 112, 98, 72, 78, 104, 90, 109, 85, 118, 89, 110, 86, 122, 101, 87, 74, 118, 101, 65, 61, 61)
    // /data/local/busybox
    val dataLocalBusybox = intArrayOf(76, 50, 82, 104, 100, 71, 69, 118, 98, 71, 57, 106, 89, 87, 119, 118, 89, 110, 86, 122, 101, 87, 74, 118, 101, 65, 61, 61)
    // /su/bin/busybox
    val suBinBusybox = intArrayOf(76, 51, 78, 49, 76, 50, 74, 112, 98, 105, 57, 105, 100, 88, 78, 53, 89, 109, 57, 52)
    // /system/bin/.ext/busybox
    val systemBinExtBusybox = intArrayOf(76, 51, 78, 53, 99, 51, 82, 108, 98, 83, 57, 105, 97, 87, 52, 118, 76, 109, 86, 52, 100, 67, 57, 105, 100, 88, 78, 53, 89, 109, 57, 52)
    // /system/usr/we-need-root/busybox
    val systemUsrWeNeedRootBusybox = intArrayOf(76, 51, 78, 53, 99, 51, 82, 108, 98, 83, 57, 49, 99, 51, 73, 118, 100, 50, 85, 116, 98, 109, 86, 108, 90, 67, 49, 121, 98, 50, 57, 48, 76, 50, 74, 49, 99, 51, 108, 105, 98, 51, 103, 61)
    // /cache/busybox
    val cacheBusybox = intArrayOf(76, 50, 78, 104, 89, 50, 104, 108, 76, 50, 74, 49, 99, 51, 108, 105, 98, 51, 103, 61)
    // /data/busybox
    val dataBusybox = intArrayOf(76, 50, 82, 104, 100, 71, 69, 118, 89, 110, 86, 122, 101, 87, 74, 118, 101, 65, 61, 61)
    // /dev/busybox
    val devBusybox = intArrayOf(76, 50, 82, 108, 100, 105, 57, 105, 100, 88, 78, 53, 89, 109, 57, 52)

    return mutableListOf(
      sbinBusybox.decodeToString(),
      systemBinBusyboc.decodeToString(),
      systemXbinBusybox.decodeToString(),
      dataLocalXbinBusybox.decodeToString(),
      dataLocalBinBusybox.decodeToString(),
      systemSdXbinBusybox.decodeToString(),
      systemBinFailsafeBusybox.decodeToString(),
      dataLocalBusybox.decodeToString(),
      suBinBusybox.decodeToString(),
      systemBinExtBusybox.decodeToString(),
      systemUsrWeNeedRootBusybox.decodeToString(),
      cacheBusybox.decodeToString(),
      dataBusybox.decodeToString(),
      devBusybox.decodeToString()
    )
  }

  fun getMagiskPaths(): List<String> {
    // /data/local/magisk
    val dataLocalMagisk = intArrayOf(76, 50, 82, 104, 100, 71, 69, 118, 98, 71, 57, 106, 89, 87, 119, 118, 98, 87, 70, 110, 97, 88, 78, 114)
    // /data/local/bin/magisk
    val dataLocalBinMagisk = intArrayOf(76, 50, 82, 104, 100, 71, 69, 118, 98, 71, 57, 106, 89, 87, 119, 118, 89, 109, 108, 117, 76, 50, 49, 104, 90, 50, 108, 122, 97, 119, 61, 61)
    // /data/local/xbin/magisk
    val dataLocalXbinMagisk = intArrayOf(76, 50, 82, 104, 100, 71, 69, 118, 98, 71, 57, 106, 89, 87, 119, 118, 101, 71, 74, 112, 98, 105, 57, 116, 89, 87, 100, 112, 99, 50, 115, 61)
    // /sbin/magisk
    val sbinMagisk = intArrayOf(76, 51, 78, 105, 97, 87, 52, 118, 98, 87, 70, 110, 97, 88, 78, 114)
    // su/bin/magisk
    val suBinMagisk = intArrayOf(76, 51, 78, 49, 76, 50, 74, 112, 98, 105, 57, 116, 89, 87, 100, 112, 99, 50, 115, 61)
    // /system/bin/magisk
    val systemBinMagisk = intArrayOf(76, 51, 78, 53, 99, 51, 82, 108, 98, 83, 57, 105, 97, 87, 52, 118, 98, 87, 70, 110, 97, 88, 78, 114)
    // /system/bin/.ext/magisk
    val systemBinExtMagisk = intArrayOf(76, 51, 78, 53, 99, 51, 82, 108, 98, 83, 57, 105, 97, 87, 52, 118, 76, 109, 86, 52, 100, 67, 57, 116, 89, 87, 100, 112, 99, 50, 115, 61)
    // /system/bin/failsafe/magisk
    val systemBinFailsafeMagisk = intArrayOf(76, 51, 78, 53, 99, 51, 82, 108, 98, 83, 57, 105, 97, 87, 52, 118, 90, 109, 70, 112, 98, 72, 78, 104, 90, 109, 85, 118, 98, 87, 70, 110, 97, 88, 78, 114)
    // /system/sd/xbin/magisk
    val systemSdXbinMagisk = intArrayOf(76, 51, 78, 53, 99, 51, 82, 108, 98, 83, 57, 122, 90, 67, 57, 52, 89, 109, 108, 117, 76, 50, 49, 104, 90, 50, 108, 122, 97, 119, 61, 61)
    // /system/usr/we-need-root/magisk
    val systemUsrWeNeedRootMagisk = intArrayOf(76, 51, 78, 53, 99, 51, 82, 108, 98, 83, 57, 49, 99, 51, 73, 118, 100, 50, 85, 116, 98, 109, 86, 108, 90, 67, 49, 121, 98, 50, 57, 48, 76, 50, 49, 104, 90, 50, 108, 122, 97, 119, 61, 61)
    // /system/xbin/magisk
    val systemXbinMagisk = intArrayOf(76, 51, 78, 53, 99, 51, 82, 108, 98, 83, 57, 52, 89, 109, 108, 117, 76, 50, 49, 104, 90, 50, 108, 122, 97, 119, 61, 61)
    // /cache/magisk
    val cacheMagisk = intArrayOf(76, 50, 78, 104, 89, 50, 104, 108, 76, 50, 49, 104, 90, 50, 108, 122, 97, 119, 61, 61)
    // /data/magisk
    val dataMagisk = intArrayOf(76, 50, 82, 104, 100, 71, 69, 118, 98, 87, 70, 110, 97, 88, 78, 114)
    // /dev/magisk
    val devMagisk = intArrayOf(76, 50, 82, 108, 100, 105, 57, 116, 89, 87, 100, 112, 99, 50, 115, 61)

    return mutableListOf(
      dataLocalMagisk.decodeToString(),
      dataLocalBinMagisk.decodeToString(),
      dataLocalXbinMagisk.decodeToString(),
      sbinMagisk.decodeToString(),
      suBinMagisk.decodeToString(),
      systemBinMagisk.decodeToString(),
      systemBinExtMagisk.decodeToString(),
      systemBinFailsafeMagisk.decodeToString(),
      systemSdXbinMagisk.decodeToString(),
      systemUsrWeNeedRootMagisk.decodeToString(),
      systemXbinMagisk.decodeToString(),
      cacheMagisk.decodeToString(),
      dataMagisk.decodeToString(),
      devMagisk.decodeToString()
    )
  }
}






private object PrivateUtils {
  fun isProcessRunning(value: IntArray): Boolean {
    var process: Process? = null
    try {
      process = Runtime.getRuntime().exec(arrayOf(value.decodeToString()))
      return process.inputStream.bufferedReader().useLines { lines ->
        lines.any()
      }
    } catch (t: Throwable) {
      return false
    } finally {
      process?.destroy()
    }
  }

  private fun getInstalledApplications(context: Context): List<ApplicationInfo> {
    try {
      val packageManager = context.packageManager
      val flags = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        PackageManager.ApplicationInfoFlags.of(PackageManager.GET_META_DATA.toLong())
      } else {
        @Suppress("DEPRECATION")
        PackageManager.GET_META_DATA
      }
      return packageManager.getInstalledApplications(flags as Int)
    } catch (e: Exception) {

    }
    return  listOf()
  }

  private fun isAnyPackageFromListInstalled(context: Context, packages: List<String>): Boolean {
    var result = false

    val pm: PackageManager = context.packageManager

    for (packageName in packages) {
      try {
        // Root app detected
        pm.getPackageInfo(packageName, 0)
        result = true
      } catch (e: PackageManager.NameNotFoundException) {
        // Exception thrown, package is not installed into the system
      }
    }
    return result
  }

  fun hasRootManagementApps(context: Context, rootManagementApps: List<String>): Boolean {
    val installedPackages: MutableList<String> = ArrayList()
    val apps = getInstalledApplications(context)
    if (apps.isNotEmpty()) {
      for (app in apps) {
        installedPackages.add(app.packageName)
      }

      for (app in rootManagementApps) {
        if (installedPackages.contains(app)) {
          return true
        }
      }
    }
    return isAnyPackageFromListInstalled(context, rootManagementApps)
  }

  fun propsReader(): Array<String>? {
    try {
      val inputstream = Runtime.getRuntime().exec("getprop").inputStream ?: return null
      val propVal = Scanner(inputstream).useDelimiter("\\A").next()
      return propVal.split("\n".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
    } catch (e: IOException) {
      return null
    } catch (e: NoSuchElementException) {
      return null
    }
  }
}





private object Utils {
  fun isSuBinaryRunning(): Boolean {
    // /system/xbin/which
    val which = intArrayOf(76,51,78,53,99,51,82,108,98,83,57,52,89,109,108,117,76,51,100,111,97,87,78,111)
    // su
    val su = intArrayOf(99,51,85,61)
    // /system/bin/which su
    val systemBinWhichSu = intArrayOf(76, 51, 78, 53, 99, 51, 82, 108, 98, 83, 57, 105, 97, 87, 52, 118, 100, 50, 104, 112, 89, 50, 103, 103, 99, 51, 85, 61)
    // which su
    val whichSu = intArrayOf(100, 50, 104, 112, 89, 50, 103, 103, 99, 51, 85, 61)
    println("${SECURITY_LOG_TAG.decodeToString()} - checkSuBinary - ${arrayOf(which.decodeToString(), su.decodeToString()).joinToString(", ")}")
    return PrivateUtils.isProcessRunning(which) || PrivateUtils.isProcessRunning(su) || PrivateUtils.isProcessRunning(systemBinWhichSu) || PrivateUtils.isProcessRunning(whichSu)
  }

  fun doPathExists(paths: List<String>): Boolean {
    println("${SECURITY_LOG_TAG.decodeToString()} - checkSuperUserPaths - paths: ${paths.joinToString(", ")}")
    for (path in paths) {
      if (File(path).exists()) return true
    }
    return false
  }

  fun hasKnownRootAppPackages (context: Context): Boolean {
    // com.noshufou.android.su
    val comNoshufouAndroidSu = intArrayOf(89, 50, 57, 116, 76, 109, 53, 118, 99, 50, 104, 49, 90, 109, 57, 49, 76, 109, 70, 117, 90, 72, 74, 118, 97, 87, 81, 117, 99, 51, 85, 61)
    // com.thirdparty.superuser
    val comThirdpartySuperuser = intArrayOf(89, 50, 57, 116, 76, 110, 82, 111, 97, 88, 74, 107, 99, 71, 70, 121, 100, 72, 107, 117, 99, 51, 86, 119, 90, 88, 74, 49, 99, 50, 86, 121)
    // eu.chainfire.supersu
    val euChainfireSupersu = intArrayOf(90, 88, 85, 117, 89, 50, 104, 104, 97, 87, 53, 109, 97, 88, 74, 108, 76, 110, 78, 49, 99, 71, 86, 121, 99, 51, 85, 61)
    // com.koushikdutta.superuser
    val comKoushikduttaSuperuser = intArrayOf(89, 50, 57, 116, 76, 109, 116, 118, 100, 88, 78, 111, 97, 87, 116, 107, 100, 88, 82, 48, 89, 83, 53, 122, 100, 88, 66, 108, 99, 110, 86, 122, 90, 88, 73, 61)
    // com.zachspong.temprootremovejb
    val comZachspongTemprootremovejb = intArrayOf(89, 50, 57, 116, 76, 110, 112, 104, 89, 50, 104, 122, 99, 71, 57, 117, 90, 121, 53, 48, 90, 87, 49, 119, 99, 109, 57, 118, 100, 72, 74, 108, 98, 87, 57, 50, 90, 87, 112, 105)
    // com.ramdroid.appquarantine
    val comRamdroidAppquarantine = intArrayOf(89, 50, 57, 116, 76, 110, 74, 104, 98, 87, 82, 121, 98, 50, 108, 107, 76, 109, 70, 119, 99, 72, 70, 49, 89, 88, 74, 104, 98, 110, 82, 112, 98, 109, 85, 61)
    // com.noshufou.android.su.elite
    val comNoshufouAndroidSuElite = intArrayOf(89, 50, 57, 116, 76, 109, 53, 118, 99, 50, 104, 49, 90, 109, 57, 49, 76, 109, 70, 117, 90, 72, 74, 118, 97, 87, 81, 117, 99, 51, 85, 117, 90, 87, 120, 112, 100, 71, 85, 61)
    // com.yellowes.su
    val comYellowesSu = intArrayOf(89, 50, 57, 116, 76, 110, 108, 108, 98, 71, 120, 118, 100, 50, 86, 122, 76, 110, 78, 49)
    // com.topjohnwu.magisk
    val comTopjohnwuMagisk = intArrayOf(89, 50, 57, 116, 76, 110, 82, 118, 99, 71, 112, 118, 97, 71, 53, 51, 100, 83, 53, 116, 89, 87, 100, 112, 99, 50, 115, 61)
    // com.kingroot.kinguser
    val comKingrootKinfuser = intArrayOf(89, 50, 57, 116, 76, 109, 116, 112, 98, 109, 100, 121, 98, 50, 57, 48, 76, 109, 116, 112, 98, 109, 100, 49, 99, 50, 86, 121)
    // com.kingo.root
    val comKingoRoot = intArrayOf(89, 50, 57, 116, 76, 109, 116, 112, 98, 109, 100, 118, 76, 110, 74, 118, 98, 51, 81, 61)
    // com.smedialink.oneclickroot
    val comSmedialinkOneclickroot = intArrayOf(89, 50, 57, 116, 76, 110, 78, 116, 90, 87, 82, 112, 89, 87, 120, 112, 98, 109, 115, 117, 98, 50, 53, 108, 89, 50, 120, 112, 89, 50, 116, 121, 98, 50, 57, 48)
    // com.zhiqupk.root.global
    val comZhiqupkRootGlobal = intArrayOf(89, 50, 57, 116, 76, 110, 112, 111, 97, 88, 70, 49, 99, 71, 115, 117, 99, 109, 57, 118, 100, 67, 53, 110, 98, 71, 57, 105, 89, 87, 119, 61)
    // com.alephzain.framaroot
    val comAlephzainFramaroot = intArrayOf(89, 50, 57, 116, 76, 109, 70, 115, 90, 88, 66, 111, 101, 109, 70, 112, 98, 105, 53, 109, 99, 109, 70, 116, 89, 88, 74, 118, 98, 51, 81, 61)

    /**  **************Additional knownRootAppPackages****************** */
    // com.roottools.rootchecker
    val comRoottoolsRootchecker = intArrayOf(89, 50, 57, 116, 76, 110, 74, 118, 98, 51, 82, 48, 98, 50, 57, 115, 99, 121, 53, 121, 98, 50, 57, 48, 89, 50, 104, 108, 89, 50, 116, 108, 99, 103, 61, 61)
    // com.joeykrim.rootcheck
    val comJoeykrimRootcheck = intArrayOf(89, 50, 57, 116, 76, 109, 112, 118, 90, 88, 108, 114, 99, 109, 108, 116, 76, 110, 74, 118, 98, 51, 82, 106, 97, 71, 86, 106, 97, 119, 61, 61)
    // com.rootuninstaller.free
    val comRootuninstallerFree = intArrayOf(89, 50, 57, 116, 76, 110, 74, 118, 98, 51, 82, 49, 98, 109, 108, 117, 99, 51, 82, 104, 98, 71, 120, 108, 99, 105, 53, 109, 99, 109, 86, 108)
    // com.rootuninstaller.pro
    val comRootuninstallerPro = intArrayOf(89, 50, 57, 116, 76, 110, 74, 118, 98, 51, 82, 49, 98, 109, 108, 117, 99, 51, 82, 104, 98, 71, 120, 108, 99, 105, 53, 119, 99, 109, 56, 61)
    // com.keramidas.TitaniumBackup
    val comKeramidasTitaniumBackup = intArrayOf(89, 50, 57, 116, 76, 109, 116, 108, 99, 109, 70, 116, 97, 87, 82, 104, 99, 121, 53, 85, 97, 88, 82, 104, 98, 109, 108, 49, 98, 85, 74, 104, 89, 50, 116, 49, 99, 65, 61, 61)
    // com.keramidas.TitaniumBackupPro
    val comKeramidasTitaniumBackupPro = intArrayOf(89, 50, 57, 116, 76, 109, 116, 108, 99, 109, 70, 116, 97, 87, 82, 104, 99, 121, 53, 85, 97, 88, 82, 104, 98, 109, 108, 49, 98, 85, 74, 104, 89, 50, 116, 49, 99, 70, 66, 121, 98, 119, 61, 61)
    // com.kingroot.kinguser
    val comKingrootKinguser = intArrayOf(89, 50, 57, 116, 76, 109, 116, 112, 98, 109, 100, 121, 98, 50, 57, 48, 76, 109, 116, 112, 98, 109, 100, 49, 99, 50, 86, 121)

    val knownRootAppPackages: List<String> = mutableListOf(
      comNoshufouAndroidSu.decodeToString(),
      comThirdpartySuperuser.decodeToString(),
      euChainfireSupersu.decodeToString(),
      comKoushikduttaSuperuser.decodeToString(),
      comZachspongTemprootremovejb.decodeToString(),
      comRamdroidAppquarantine.decodeToString(),
      comNoshufouAndroidSuElite.decodeToString(),
      comYellowesSu.decodeToString(),
      comTopjohnwuMagisk.decodeToString(),
      comKingrootKinfuser.decodeToString(),
      comKingoRoot.decodeToString(),
      comSmedialinkOneclickroot.decodeToString(),
      comZhiqupkRootGlobal.decodeToString(),
      comAlephzainFramaroot.decodeToString(),
      comRoottoolsRootchecker.decodeToString(),
      comJoeykrimRootcheck.decodeToString(),
      comRootuninstallerFree.decodeToString(),
      comRootuninstallerPro.decodeToString(),
      comKeramidasTitaniumBackup.decodeToString(),
      comKeramidasTitaniumBackupPro.decodeToString(),
      comKingrootKinguser.decodeToString()
    )
    return PrivateUtils.hasRootManagementApps(context, knownRootAppPackages)
  }

  fun hasKnownDangerousAppPackages(context: Context): Boolean {
    // com.koushikdutta.rommanager
    val comKoushikduttaRommanager = intArrayOf(89, 50, 57, 116, 76, 109, 116, 118, 100, 88, 78, 111, 97, 87, 116, 107, 100, 88, 82, 48, 89, 83, 53, 121, 98, 50, 49, 116, 89, 87, 53, 104, 90, 50, 86, 121)
    // com.koushikdutta.rommanager.license
    val comKoushikduttaRommanagerLicense = intArrayOf(89, 50, 57, 116, 76, 109, 116, 118, 100, 88, 78, 111, 97, 87, 116, 107, 100, 88, 82, 48, 89, 83, 53, 121, 98, 50, 49, 116, 89, 87, 53, 104, 90, 50, 86, 121, 76, 109, 120, 112, 89, 50, 86, 117, 99, 50, 85, 61)
    // com.dimonvideo.luckypatcher
    val comDimonvideoLuckypatcher = intArrayOf(89, 50, 57, 116, 76, 109, 82, 112, 98, 87, 57, 117, 100, 109, 108, 107, 90, 87, 56, 117, 98, 72, 86, 106, 97, 51, 108, 119, 89, 88, 82, 106, 97, 71, 86, 121)
    // com.chelpus.lackypatch
    val comChelpusLackypatch = intArrayOf(89, 50, 57, 116, 76, 109, 78, 111, 90, 87, 120, 119, 100, 88, 77, 117, 98, 71, 70, 106, 97, 51, 108, 119, 89, 88, 82, 106, 97, 65, 61, 61)
    // com.ramdroid.appquarantine
    val comRamdroidAppquarantine = intArrayOf(89, 50, 57, 116, 76, 110, 74, 104, 98, 87, 82, 121, 98, 50, 108, 107, 76, 109, 70, 119, 99, 72, 70, 49, 89, 88, 74, 104, 98, 110, 82, 112, 98, 109, 85, 61)
    // com.ramdroid.appquarantinepro
    val comRamdroidAppquarantinepro = intArrayOf(89, 50, 57, 116, 76, 110, 74, 104, 98, 87, 82, 121, 98, 50, 108, 107, 76, 109, 70, 119, 99, 72, 70, 49, 89, 88, 74, 104, 98, 110, 82, 112, 98, 109, 86, 119, 99, 109, 56, 61)
    // com.android.vending.billing.InAppBillingService.COIN
    val comAndroidVendingBillingInAppBillingServiceCoin = intArrayOf(89, 50, 57, 116, 76, 109, 70, 117, 90, 72, 74, 118, 97, 87, 81, 117, 100, 109, 86, 117, 90, 71, 108, 117, 90, 121, 53, 105, 97, 87, 120, 115, 97, 87, 53, 110, 76, 107, 108, 117, 81, 88, 66, 119, 81, 109, 108, 115, 98, 71, 108, 117, 90, 49, 78, 108, 99, 110, 90, 112, 89, 50, 85, 117, 81, 48, 57, 74, 84, 103, 61, 61)
    //com.android.vending.billing.InAppBillingService.LUCK
    val comAndroidVendingBillingInAppBillingServiceLuck = intArrayOf(89, 50, 57, 116, 76, 109, 70, 117, 90, 72, 74, 118, 97, 87, 81, 117, 100, 109, 86, 117, 90, 71, 108, 117, 90, 121, 53, 105, 97, 87, 120, 115, 97, 87, 53, 110, 76, 107, 108, 117, 81, 88, 66, 119, 81, 109, 108, 115, 98, 71, 108, 117, 90, 49, 78, 108, 99, 110, 90, 112, 89, 50, 85, 117, 84, 70, 86, 68, 83, 119, 61, 61)
    // com.chelpus.luckypatcher
    val comChelpusLuckypatcher = intArrayOf(89, 50, 57, 116, 76, 109, 78, 111, 90, 87, 120, 119, 100, 88, 77, 117, 98, 72, 86, 106, 97, 51, 108, 119, 89, 88, 82, 106, 97, 71, 86, 121)
    // com.blackmartalpha
    val comBlackmartalpha = intArrayOf(89, 50, 57, 116, 76, 109, 74, 115, 89, 87, 78, 114, 98, 87, 70, 121, 100, 71, 70, 115, 99, 71, 104, 104)
    // org.blackmart.market
    val orgBlackmartMarket = intArrayOf(98, 51, 74, 110, 76, 109, 74, 115, 89, 87, 78, 114, 98, 87, 70, 121, 100, 67, 53, 116, 89, 88, 74, 114, 90, 88, 81, 61)
    // com.allinone.free
    val comAllinoneFree = intArrayOf(89, 50, 57, 116, 76, 109, 70, 115, 98, 71, 108, 117, 98, 50, 53, 108, 76, 109, 90, 121, 90, 87, 85, 61)
    // com.repodroid.app
    val comRepodroidApp = intArrayOf(89, 50, 57, 116, 76, 110, 74, 108, 99, 71, 57, 107, 99, 109, 57, 112, 90, 67, 53, 104, 99, 72, 65, 61)
    // org.creeplays.hack
    val orgCreeplaysHack = intArrayOf(98, 51, 74, 110, 76, 109, 78, 121, 90, 87, 86, 119, 98, 71, 70, 53, 99, 121, 53, 111, 89, 87, 78, 114)
    // com.baseappfull.fwd
    val comBaseappfullFwd = intArrayOf(89, 50, 57, 116, 76, 109, 74, 104, 99, 50, 86, 104, 99, 72, 66, 109, 100, 87, 120, 115, 76, 109, 90, 51, 90, 65, 61, 61)
    // com.zmapp
    val comZmapp = intArrayOf(89, 50, 57, 116, 76, 110, 112, 116, 89, 88, 66, 119)
    // com.dv.marketmod.installer
    val comDvMarketmodInstaller = intArrayOf(89, 50, 57, 116, 76, 109, 82, 50, 76, 109, 49, 104, 99, 109, 116, 108, 100, 71, 49, 118, 90, 67, 53, 112, 98, 110, 78, 48, 89, 87, 120, 115, 90, 88, 73, 61)
    // org.mobilism.android
    val orgMobilismAndroid = intArrayOf(98, 51, 74, 110, 76, 109, 49, 118, 89, 109, 108, 115, 97, 88, 78, 116, 76, 109, 70, 117, 90, 72, 74, 118, 97, 87, 81, 61)
    // com.android.wp.net.log
    val comAndroidWpNetLog = intArrayOf(89, 50, 57, 116, 76, 109, 70, 117, 90, 72, 74, 118, 97, 87, 81, 117, 100, 51, 65, 117, 98, 109, 86, 48, 76, 109, 120, 118, 90, 119, 61, 61)
    // com.android.camera.update
    val comAndroidCameraUpdate = intArrayOf(89, 50, 57, 116, 76, 109, 70, 117, 90, 72, 74, 118, 97, 87, 81, 117, 89, 50, 70, 116, 90, 88, 74, 104, 76, 110, 86, 119, 90, 71, 70, 48, 90, 81, 61, 61)
    // cc.madkite.freedom
    val ccMadkiteFreedom = intArrayOf(89, 50, 77, 117, 98, 87, 70, 107, 97, 50, 108, 48, 90, 83, 53, 109, 99, 109, 86, 108, 90, 71, 57, 116)
    // com.solohsu.android.edxp.manager
    val comSolohsuAndroidEdxpManager = intArrayOf(89, 50, 57, 116, 76, 110, 78, 118, 98, 71, 57, 111, 99, 51, 85, 117, 89, 87, 53, 107, 99, 109, 57, 112, 90, 67, 53, 108, 90, 72, 104, 119, 76, 109, 49, 104, 98, 109, 70, 110, 90, 88, 73, 61)
    // org.meowcat.edxposed.manager
    val orgMeowcatEdxposedManager = intArrayOf(98, 51, 74, 110, 76, 109, 49, 108, 98, 51, 100, 106, 89, 88, 81, 117, 90, 87, 82, 52, 99, 71, 57, 122, 90, 87, 81, 117, 98, 87, 70, 117, 89, 87, 100, 108, 99, 103, 61, 61)
    // com.xmodgame
    val comXmodgame = intArrayOf(89, 50, 57, 116, 76, 110, 104, 116, 98, 50, 82, 110, 89, 87, 49, 108)
    // com.cih.game_cih
    val comCihGameCih = intArrayOf(89, 50, 57, 116, 76, 109, 78, 112, 97, 67, 53, 110, 89, 87, 49, 108, 88, 50, 78, 112, 97, 65, 61, 61)
    // com.charles.lpoqasert
    val comCharlesLpoqasert = intArrayOf(89, 50, 57, 116, 76, 109, 78, 111, 89, 88, 74, 115, 90, 88, 77, 117, 98, 72, 66, 118, 99, 87, 70, 122, 90, 88, 74, 48)
    // catch_.me_.if_.you_.can_
    val catchMeIfYouCan = intArrayOf(89, 50, 70, 48, 89, 50, 104, 102, 76, 109, 49, 108, 88, 121, 53, 112, 90, 108, 56, 117, 101, 87, 57, 49, 88, 121, 53, 106, 89, 87, 53, 102)

    /**  **************Additional knownDangerousAppPackages****************** */

    // com.luckypatchers.luckypatcherinstaller
    val comLuckypatchersLuckypatcherinstaller = intArrayOf(89, 50, 57, 116, 76, 109, 120, 49, 89, 50, 116, 53, 99, 71, 70, 48, 89, 50, 104, 108, 99, 110, 77, 117, 98, 72, 86, 106, 97, 51, 108, 119, 89, 88, 82, 106, 97, 71, 86, 121, 97, 87, 53, 122, 100, 71, 70, 115, 98, 71, 86, 121)

    val knowDangerousAppPackages: List<String> = mutableListOf(
      comKoushikduttaRommanager.decodeToString(),
      comKoushikduttaRommanagerLicense.decodeToString(),
      comDimonvideoLuckypatcher.decodeToString(),
      comChelpusLackypatch.decodeToString(),
      comRamdroidAppquarantinepro.decodeToString(),
      comAndroidVendingBillingInAppBillingServiceCoin.decodeToString(),
      comAndroidVendingBillingInAppBillingServiceLuck.decodeToString(),
      comChelpusLuckypatcher.decodeToString(),
      comBlackmartalpha.decodeToString(),
      orgBlackmartMarket.decodeToString(),
      comAllinoneFree.decodeToString(),
      comRepodroidApp.decodeToString(),
      orgCreeplaysHack.decodeToString(),
      comBaseappfullFwd.decodeToString(),
      comZmapp.decodeToString(),
      comDvMarketmodInstaller.decodeToString(),
      orgMobilismAndroid.decodeToString(),
      comAndroidWpNetLog.decodeToString(),
      comAndroidCameraUpdate.decodeToString(),
      ccMadkiteFreedom.decodeToString(),
      comSolohsuAndroidEdxpManager.decodeToString(),
      orgMeowcatEdxposedManager.decodeToString(),
      comXmodgame.decodeToString(),
      comCihGameCih.decodeToString(),
      comCharlesLpoqasert.decodeToString(),
      catchMeIfYouCan.decodeToString(),
      // additional knownDangerousAppPackages
      comLuckypatchersLuckypatcherinstaller.decodeToString()
    )
    return PrivateUtils.hasRootManagementApps(context, knowDangerousAppPackages)
  }

  fun hasKnownClockingPackages(context: Context): Boolean {
    // com.devadvance.rootcloak
    val comDevadvanceRootcloak = intArrayOf(89, 50, 57, 116, 76, 109, 82, 108, 100, 109, 70, 107, 100, 109, 70, 117, 89, 50, 85, 117, 99, 109, 57, 118, 100, 71, 78, 115, 98, 50, 70, 114)
    // com.devadvance.rootcloakplus
    val comDevadvanceRootcloakplus = intArrayOf(89, 50, 57, 116, 76, 109, 82, 108, 100, 109, 70, 107, 100, 109, 70, 117, 89, 50, 85, 117, 99, 109, 57, 118, 100, 71, 78, 115, 98, 50, 70, 114, 99, 71, 120, 49, 99, 119, 61, 61)
    // de.robv.android.xposed.installer
    val deRobvAndroidXposedInstaller = intArrayOf(90, 71, 85, 117, 99, 109, 57, 105, 100, 105, 53, 104, 98, 109, 82, 121, 98, 50, 108, 107, 76, 110, 104, 119, 98, 51, 78, 108, 90, 67, 53, 112, 98, 110, 78, 48, 89, 87, 120, 115, 90, 88, 73, 61)
    // com.saurik.substrate
    val comSaurikSubstrate = intArrayOf(89, 50, 57, 116, 76, 110, 78, 104, 100, 88, 74, 112, 97, 121, 53, 122, 100, 87, 74, 122, 100, 72, 74, 104, 100, 71, 85, 61)
    // com.zachspong.temprootremovejb
    val comZachspongTemprootremovejb = intArrayOf(89, 50, 57, 116, 76, 110, 112, 104, 89, 50, 104, 122, 99, 71, 57, 117, 90, 121, 53, 48, 90, 87, 49, 119, 99, 109, 57, 118, 100, 72, 74, 108, 98, 87, 57, 50, 90, 87, 112, 105)
    // com.amphoras.hidemyroot
    val comAmphorasHidemyroot = intArrayOf(89, 50, 57, 116, 76, 109, 70, 116, 99, 71, 104, 118, 99, 109, 70, 122, 76, 109, 104, 112, 90, 71, 86, 116, 101, 88, 74, 118, 98, 51, 81, 61)
    // com.amphoras.hidemyrootadfree
    val comAmphorasHidemyrootadfree = intArrayOf(89, 50, 57, 116, 76, 109, 70, 116, 99, 71, 104, 118, 99, 109, 70, 122, 76, 109, 104, 112, 90, 71, 86, 116, 101, 88, 74, 118, 98, 51, 82, 104, 90, 71, 90, 121, 90, 87, 85, 61)
    // com.formyhm.hiderootPremium
    val comFormyhmHiderootPremium = intArrayOf(89, 50, 57, 116, 76, 109, 90, 118, 99, 109, 49, 53, 97, 71, 48, 117, 97, 71, 108, 107, 90, 88, 74, 118, 98, 51, 82, 81, 99, 109, 86, 116, 97, 88, 86, 116)
    // com.formyhm.hideroot
    val comFormyhmHideroot = intArrayOf(89, 50, 57, 116, 76, 109, 90, 118, 99, 109, 49, 53, 97, 71, 48, 117, 97, 71, 108, 107, 90, 88, 74, 118, 98, 51, 81, 61)

    /**  **************Additional knownClockingPackages****************** */
    // com.topjohnwu.magisk
    val comTopjohnwuMagisk = intArrayOf(89, 50, 57, 116, 76, 110, 82, 118, 99, 71, 112, 118, 97, 71, 53, 51, 100, 83, 53, 116, 89, 87, 100, 112, 99, 50, 115, 61)
    // com.topjohnwu.magisk.manager
    val comTopjohnwuMagiskManager = intArrayOf(89, 50, 57, 116, 76, 110, 82, 118, 99, 71, 112, 118, 97, 71, 53, 51, 100, 83, 53, 116, 89, 87, 100, 112, 99, 50, 115, 117, 98, 87, 70, 117, 89, 87, 100, 108, 99, 103, 61, 61)
    // com.devadvance.rootcloak2
    val comDevadvanceRootcloak2 = intArrayOf(89, 50, 57, 116, 76, 109, 82, 108, 100, 109, 70, 107, 100, 109, 70, 117, 89, 50, 85, 117, 99, 109, 57, 118, 100, 71, 78, 115, 98, 50, 70, 114, 77, 103, 61, 61)
    // com.formyhm.hideroot2
    val comFormyhmHideroot2 = intArrayOf(89, 50, 57, 116, 76, 109, 90, 118, 99, 109, 49, 53, 97, 71, 48, 117, 97, 71, 108, 107, 90, 88, 74, 118, 98, 51, 81, 121)

    val knownClockingPackages: List<String> = mutableListOf(
      comDevadvanceRootcloak.decodeToString(),
      comDevadvanceRootcloakplus.decodeToString(),
      deRobvAndroidXposedInstaller.decodeToString(),
      comSaurikSubstrate.decodeToString(),
      comZachspongTemprootremovejb.decodeToString(),
      comAmphorasHidemyroot.decodeToString(),
      comAmphorasHidemyrootadfree.decodeToString(),
      comFormyhmHiderootPremium.decodeToString(),
      comFormyhmHideroot.decodeToString(),
      // additional knownClockingPackages
      comTopjohnwuMagisk.decodeToString(),
      comTopjohnwuMagiskManager.decodeToString(),
      comDevadvanceRootcloak2.decodeToString(),
      comFormyhmHideroot2.decodeToString()
    )
    return PrivateUtils.hasRootManagementApps(context, knownClockingPackages)
  }

  fun hasDangerousProps(): Boolean {
    val dangerousProps: MutableMap<String, String> = HashMap()
    // ro.debuggable
    val roDebuggable = intArrayOf(99, 109, 56, 117, 90, 71, 86, 105, 100, 87, 100, 110, 89, 87, 74, 115, 90, 81, 61, 61)
    // ro.secure
    val roSecure = intArrayOf(99, 109, 56, 117, 99, 50, 86, 106, 100, 88, 74, 108)
    // 1
    val one = intArrayOf(77, 81, 61, 61)
    // 0
    val zero = intArrayOf(77, 65, 61, 61)
    dangerousProps[roDebuggable.decodeToString()] = one.decodeToString()
    dangerousProps[roSecure.decodeToString()] = zero.decodeToString()

    var result = false

    val lines: Array<String> = PrivateUtils.propsReader()
      ?: // Could not read, assume false;
      return false

    for (line in lines) {
      for (key in dangerousProps.keys) {
        if (line.contains(key)) {
          var badValue = dangerousProps[key]
          badValue = "[$badValue]"
          if (line.contains(badValue)) {
            result = true
          }
        }
      }
    }
    return result
  }
}





private object RootLibNativeContants {
  fun getTrueValueString(): String {
    // pathsexist - zjboyjbluu
    return intArrayOf(101, 109, 112, 105, 98, 51, 108, 113, 89, 109, 120, 49, 100, 81, 61, 61).decodeToString()
  }

  fun getFalseValueString(): String {
    // pathsdoesnotexist - gqivfpzobvvzjbluu
    return intArrayOf(90, 51, 70, 112, 100, 109, 90, 119, 101, 109, 57, 105, 100, 110, 90, 54, 97, 109, 74, 115, 100, 88, 85, 61).decodeToString()
  }
}

private object RootLibNative {
  fun isCodeNotMockedByFrida(): Boolean {
    // /system/app/Superuser.apk
    val superUserSamplePath = intArrayOf(76,51,78,53,99,51,82,108,98,83,57,104,99,72,65,118,85,51,86,119,90,88,74,49,99,50,86,121,76,109,70,119,97,119,61,61)

    val waveUtilsLib = IlfnCaoqwOkc()
    val pathValueString = waveUtilsLib.pzZjboyJbluu(mutableListOf<String>(superUserSamplePath.decodeToString()).toTypedArray())
    return pathValueString == RootLibNativeContants.getTrueValueString() || pathValueString == RootLibNativeContants.getFalseValueString()
  }
}






object Root {

  private fun hasBuildTags(): Boolean {
    // test-keys
    val testKeys = intArrayOf(100,71,86,122,100,67,49,114,90,88,108,122)
    println("${SECURITY_LOG_TAG.decodeToString()} - checkBuildTags - testKeys: ${testKeys.decodeToString()}")
    val buildTags = Build.TAGS
    return buildTags != null && buildTags.contains(testKeys.decodeToString())
  }

  private fun hasSuperUserPaths(): Boolean {
    return Utils.doPathExists(Constants.getSuPaths())
      || Utils.doPathExists(Constants.getBusyBoxPaths())
      || Utils.doPathExists(Constants.getMagiskPaths())
  }

  private fun isSuBinaryRunning(): Boolean {
    return Utils.isSuBinaryRunning()
  }

  private fun hasRootManagementApps(context: Context): Boolean {
    return Utils.hasKnownRootAppPackages(context)
      || Utils.hasKnownDangerousAppPackages(context)
      || Utils.hasKnownClockingPackages(context)
  }

  private fun hasDangerousProps(): Boolean {
    return Utils.hasDangerousProps()
  }

  private fun hasSuperUserPathsNative(): Boolean {
    val waveUtilsLib = IlfnCaoqwOkc()
    return waveUtilsLib.pzZjboyJbluu(Constants.getSuPaths().toTypedArray()) == RootLibNativeContants.getTrueValueString()
      || waveUtilsLib.pzZjboyJbluu(Constants.getBusyBoxPaths().toTypedArray()) == RootLibNativeContants.getTrueValueString()
      || waveUtilsLib.pzZjboyJbluu(Constants.getMagiskPaths().toTypedArray()) == RootLibNativeContants.getTrueValueString()
  }

  fun isNativeLibValid(): Boolean {
    return RootLibNative.isCodeNotMockedByFrida()
  }

  fun isEncryptedStorageValid(context: Context): Boolean {
    val secretData = EncryptedStorage.getSecretData(context, RootStorageConstants.getKeyName())
    if (secretData.isNull()) {
      EncryptedStorage.saveSecretData(context, RootStorageConstants.getKeyName(), RootStorageConstants.getFalseValue())
    }
    return secretData == RootStorageConstants.getFalseValue() || secretData == RootStorageConstants.getTrueValue()
  }

  fun isDetected(context: Context): Boolean {
    val isDetected = hasBuildTags()
      || hasSuperUserPaths()
      || isSuBinaryRunning()
      || hasRootManagementApps(context)
      || hasDangerousProps()
      || hasSuperUserPathsNative()
    if (isDetected) {
      EncryptedStorage.saveSecretData(context, RootStorageConstants.getKeyName(), RootStorageConstants.getTrueValue())
    }
    return isDetected || EncryptedStorage.getSecretData(context, RootStorageConstants.getKeyName()) == RootStorageConstants.getTrueValue()
  }
}
