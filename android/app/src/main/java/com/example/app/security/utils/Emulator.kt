package com.example.app.security.utils

import android.content.Context
import android.os.Build
import android.telephony.TelephonyManager
import com.example.app.utils.EncryptedStorage
import com.example.app.utils.SECURITY_LOG_TAG
import com.example.app.utils.decodeToString
import com.example.mtaqewqs.PwdthztvOkc
import java.io.File
import java.io.FileInputStream
import java.io.InputStream

private object EmulatorStorageConstants {
  fun getKeyName(): String {
    // emulator_detected - vcjznfzb_llzjgwge
    return intArrayOf(100, 109, 78, 113, 101, 109, 53, 109, 101, 109, 74, 102, 98, 71, 120, 54, 97, 109, 100, 51, 90, 50, 85, 61).decodeToString()
  }

  fun getTrueValue(): String {
    // detectionhasbeenfoundforemulator - jjxheuinlewnvxwevdiapqyamtaqewqs
    return intArrayOf(97, 109, 112, 52, 97, 71, 86, 49, 97, 87, 53, 115, 90, 88, 100, 117, 100, 110, 104, 51, 90, 88, 90, 107, 97, 87, 70, 119, 99, 88, 108, 104, 98, 88, 82, 104, 99, 87, 86, 51, 99, 88, 77, 61).decodeToString()
  }

  fun getFalseValue(): String {
    // detectionisnotfoundforemulator - hhvfcsgljdmggkvdiapqyamtaqewqs
    return intArrayOf(97, 71, 104, 50, 90, 109, 78, 122, 90, 50, 120, 113, 90, 71, 49, 110, 90, 50, 116, 50, 90, 71, 108, 104, 99, 72, 70, 53, 89, 87, 49, 48, 89, 88, 70, 108, 100, 51, 70, 122).decodeToString()
  }
}

private object Files {

  private object GenyFiles {
    // /dev/socket/genyd
    val DEV_SOCKET_GENYD = intArrayOf(76,50,82,108,100,105,57,122,98,50,78,114,90,88,81,118,90,50,86,117,101,87,81,61)

    // /dev/socket/baseband_genyd
    val DEV_SOCKET_BASEBAND_GENYD = intArrayOf(76,50,82,108,100,105,57,122,98,50,78,114,90,88,81,118,89,109,70,122,90,87,74,104,98,109,82,102,90,50,86,117,101,87,81,61)
  }

  private object Pipes {
    // /dev/socket/qemud
    val DEV_SOCKET_GEMUD = intArrayOf(76,50,82,108,100,105,57,122,98,50,78,114,90,88,81,118,99,87,86,116,100,87,81,61)

    // /dev/qemu_pipe
    val DEV_QEMU_PIPE = intArrayOf(76,50,82,108,100,105,57,120,90,87,49,49,88,51,66,112,99,71,85,61)
  }

  private object X86Files {
    // ueventd.android_x86.rc
    val UEVENTD_ANDROID_X86_RC = intArrayOf(100,87,86,50,90,87,53,48,90,67,53,104,98,109,82,121,98,50,108,107,88,51,103,52,78,105,53,121,89,119,61,61)

    // x86.prop
    val X86_PROP = intArrayOf(101,68,103,50,76,110,66,121,98,51,65,61)

    // ueventd.ttVM_x86.rc
    val UEVENTD_TTVM_X86_RC = intArrayOf(100,87,86,50,90,87,53,48,90,67,53,48,100,70,90,78,88,51,103,52,78,105,53,121,89,119,61,61)

    // init.ttVM_x86.rc
    val INIT_TTVM_X86_RC = intArrayOf(97,87,53,112,100,67,53,48,100,70,90,78,88,51,103,52,78,105,53,121,89,119,61,61)

    // fstab.ttVM_x86
    val FSTAB_TTVM_X86 = intArrayOf(90,110,78,48,89,87,73,117,100,72,82,87,84,86,57,52,79,68,89,61)

    // fstab.vbox86
    val FSTAB_VBOX86 = intArrayOf(90,110,78,48,89,87,73,117,100,109,74,118,101,68,103,50)

    // init.vbox86.rc
    val INIT_VBOX86_RC = intArrayOf(97,87,53,112,100,67,53,50,89,109,57,52,79,68,89,117,99,109,77,61)

    // ueventd.vbox86.rc
    val UEVENTD_VBOX86_RC = intArrayOf(100,87,86,50,90,87,53,48,90,67,53,50,89,109,57,52,79,68,89,117,99,109,77,61)
  }

  private object AndyFiles {
    // fstab.andy
    val FSTAB_ANDY = intArrayOf(90,110,78,48,89,87,73,117,89,87,53,107,101,81,61,61)

    // ueventd.andy.rc
    val UEVENTD_ANDY_RC = intArrayOf(100,87,86,50,90,87,53,48,90,67,53,104,98,109,82,53,76,110,74,106)
  }

  private object NoxFiles {
    // fstab.nox
    val FASTAB_NOX = intArrayOf(90,110,78,48,89,87,73,117,98,109,57,52)

    // init.nox.rc
    val INIT_NOX_RC = intArrayOf(97,87,53,112,100,67,53,117,98,51,103,117,99,109,77,61)

    // ueventd.nox.rc
    val UEVENTD_NOX_RC = intArrayOf(100,87,86,50,90,87,53,48,90,67,53,117,98,51,103,117,99,109,77,61)
  }

  private val GENY_FILES = arrayOf(
    GenyFiles.DEV_SOCKET_GENYD.decodeToString(),
    GenyFiles.DEV_SOCKET_BASEBAND_GENYD.decodeToString()
  )
  private val PIPES = arrayOf(
    Pipes.DEV_SOCKET_GEMUD.decodeToString(),
    Pipes.DEV_QEMU_PIPE.decodeToString()
  )
  private val X86_FILES = arrayOf(
    X86Files.UEVENTD_ANDROID_X86_RC.decodeToString(),
    X86Files.X86_PROP.decodeToString(),
    X86Files.UEVENTD_TTVM_X86_RC.decodeToString(),
    X86Files.INIT_TTVM_X86_RC.decodeToString(),
    X86Files.FSTAB_TTVM_X86.decodeToString(),
    X86Files.FSTAB_VBOX86.decodeToString(),
    X86Files.INIT_VBOX86_RC.decodeToString(),
    X86Files.UEVENTD_VBOX86_RC.decodeToString()
  )
  private val ANDY_FILES = arrayOf(
    AndyFiles.FSTAB_ANDY.decodeToString(),
    AndyFiles.UEVENTD_ANDY_RC.decodeToString()
  )
  private val NOX_FILES = arrayOf(
    NoxFiles.FASTAB_NOX.decodeToString(),
    NoxFiles.INIT_NOX_RC.decodeToString(),
    NoxFiles.UEVENTD_NOX_RC.decodeToString()
  )
  fun checkFiles(targets: Array<String>): Boolean {
    try {
      for (pipe in targets) {
        val file = File(pipe)
        if (file.exists()) {
          return true
        }
      }
    } catch (_: Exception){}
    return false
  }

  private fun checkQEmuDrivers(): Boolean {
    // goldfish
    val goldfish = intArrayOf(90,50,57,115,90,71,90,112,99,50,103,61)
    val QEMU_DRIVERS = arrayOf(goldfish.decodeToString())
    // /proc/tty/drivers
    val procTTYDrivers = intArrayOf(76,51,66,121,98,50,77,118,100,72,82,53,76,50,82,121,97,88,90,108,99,110,77,61)
    // /proc/cpuinfo
    val procCpuInfo = intArrayOf(76,51,66,121,98,50,77,118,89,51,66,49,97,87,53,109,98,119,61,61)
    for (drivers_file in arrayOf<File>(File(procTTYDrivers.decodeToString()), File(procCpuInfo.decodeToString()))) {
      if (drivers_file.exists() && drivers_file.canRead()) {
        val data = ByteArray(1024)
        try {
          val `is`: InputStream = FileInputStream(drivers_file)
          `is`.read(data)
          `is`.close()
        } catch (exception: java.lang.Exception) {
          exception.printStackTrace()
        }

        val driver_data = String(data)
        for (known_qemu_driver in QEMU_DRIVERS) {
          if (driver_data.contains(known_qemu_driver)) {
            return true
          }
        }
      }
    }

    return false
  }

  fun checkEmulatorFiles():Boolean {
    return (checkFiles(GENY_FILES)
      || checkFiles(ANDY_FILES)
      || checkFiles(NOX_FILES)
      || checkFiles(X86_FILES)
      || checkFiles(PIPES))
      || checkQEmuDrivers()
  }
}

private object NetworkOperator {
  fun detect(context: Context): Boolean {
    try {
        // android
        val android = intArrayOf(89,87,53,107,99,109,57,112,90,65,61,61)
        val tm = context.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager?
        val networkOperator = tm!!.networkOperatorName
        return android.decodeToString() == networkOperator.lowercase()
    } catch (_: Exception) {}
    return false
  }
}

private object Firebase {
  fun detect(): Boolean {
//    return FirebaseCrashlytics.getInstance().isEmulator()
    return false
  }
}


object Emulator {

  fun isDetected(context: Context): Boolean {
    val isDetected = checkViaBuild() || Files.checkEmulatorFiles() || NetworkOperator.detect(context) || Firebase.detect() || PwdthztvOkc().sbLlzjgwge()
    if (isDetected) {
      EncryptedStorage.saveSecretData(context, EmulatorStorageConstants.getKeyName(), EmulatorStorageConstants.getTrueValue())
    }
    return isDetected || EncryptedStorage.getSecretData(context, EmulatorStorageConstants.getKeyName()) == EmulatorStorageConstants.getTrueValue()
  }

  private fun checkViaBuild(): Boolean {
    // genymotion
    val genyMotion = intArrayOf(90,50,86,117,101,87,49,118,100,71,108,118,98,103,61,61)
    // unknown
    val unknown = intArrayOf(100,87,53,114,98,109,57,51,98,103,61,61)
    // google_sdk
    val googleSdk = intArrayOf(90,50,57,118,90,50,120,108,88,51,78,107,97,119,61,61)
    // droid4x
    val droid4x = intArrayOf(90,72,74,118,97,87,81,48,101,65,61,61)
    // emulator
    val emulator = intArrayOf(90,87,49,49,98,71,70,48,98,51,73,61)
    // Android SDK built for x86
    val androidSdkBuiltForX86 = intArrayOf(81,87,53,107,99,109,57,112,90,67,66,84,82,69,115,103,89,110,86,112,98,72,81,103,90,109,57,121,73,72,103,52,78,103,61,61)
    // goldfish
    val goldfish = intArrayOf(90,50,57,115,90,71,90,112,99,50,103,61)
    // ranchu
    val ranchu = intArrayOf(99,109,70,117,89,50,104,49)
    // vbox86
    val vbox86 = intArrayOf(100,109,74,118,101,68,103,50)
    // nox
    val nox = intArrayOf(98,109,57,52)
    // generic
    val generic = intArrayOf(90,50,86,117,90,88,74,112,89,119,61,61)
    // sdk
    val sdk = intArrayOf(99,50,82,114)
    // sdk_x86
    val sdkX86 = intArrayOf(99,50,82,114,88,51,103,52,78,103,61,61)
    // vbox86p
    val vbox86p = intArrayOf(100,109,74,118,101,68,103,50,99,65,61,61)

    println("${SECURITY_LOG_TAG.decodeToString()} - Emulator - checkValidBuild - \n" +
            "genyMotion - ${genyMotion.decodeToString()}\n" +
            "unknowm - ${unknown.decodeToString()}\n" +
            "googleSdk - ${googleSdk.decodeToString()}\n" +
            "droid4x - ${droid4x.decodeToString()}\n" +
            "emulator - ${emulator.decodeToString()}\n" +
            "androidSdkBuiltForX86 - ${androidSdkBuiltForX86.decodeToString()}\n" +
            "goldfish - ${goldfish.decodeToString()}\n" +
            "ranchu - ${ranchu.decodeToString()}\n" +
            "vbox86 - ${vbox86.decodeToString()}\n" +
            "nox - ${nox.decodeToString()}\n" +
            "generic - ${generic.decodeToString()}\n" +
            "sdk - ${sdk.decodeToString()}\n" +
            "sdkX86 - ${sdkX86.decodeToString()}\n" +
            "vbox86p - ${vbox86p.decodeToString()}")

    return (Build.MANUFACTURER.lowercase().contains(genyMotion.decodeToString())
      || Build.MANUFACTURER.lowercase().contains(unknown.decodeToString())
      || Build.MODEL.lowercase().contains(googleSdk.decodeToString())
      || Build.MODEL.lowercase().contains(droid4x.decodeToString())
      || Build.MODEL.lowercase().contains(emulator.decodeToString())
      || Build.MODEL.contains(androidSdkBuiltForX86.decodeToString())
      || Build.HARDWARE == goldfish.decodeToString()
      || Build.HARDWARE == ranchu.decodeToString()
      || Build.HARDWARE == vbox86.decodeToString()
      || Build.HARDWARE.lowercase().contains(nox.decodeToString())
      || Build.FINGERPRINT.contains(generic.decodeToString())
      || Build.PRODUCT == sdk.decodeToString()
      || Build.PRODUCT == googleSdk.decodeToString()
      || Build.PRODUCT == sdkX86.decodeToString()
      || Build.PRODUCT == vbox86p.decodeToString()
      || Build.PRODUCT.lowercase().contains(nox.decodeToString())
      || Build.BOARD.lowercase().contains(nox.decodeToString())
      || Build.BOOTLOADER.lowercase().contains(nox.decodeToString())
      || Build.HARDWARE.lowercase().contains(nox.decodeToString())
      || Build.PRODUCT.lowercase().contains(nox.decodeToString())
      || Build.SERIAL.lowercase().contains(nox.decodeToString())
      || (Build.BRAND.lowercase().contains(generic.decodeToString()) && Build.DEVICE.lowercase().contains(generic.decodeToString())))
  }
}
