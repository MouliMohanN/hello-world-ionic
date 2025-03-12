package com.example.app.security.utils

import android.content.Context
import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import android.os.Build
import com.example.app.utils.SECURITY_LOG_TAG
import com.example.app.utils.decodeToString
import java.io.File
import java.lang.Runtime


private object Utils {
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

  fun getInstalledApplications(context: Context): List<ApplicationInfo> {
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
}


object Root {

    fun isDetected(context: Context): Boolean {
        return hasBuildTags() || hasSuperUserPaths() || isSuBinaryRunning() || hasRootManagementApps(context)
    }

    private fun hasBuildTags(): Boolean {
        // test-keys
        val testKeys = intArrayOf(100,71,86,122,100,67,49,114,90,88,108,122)
        println("${SECURITY_LOG_TAG.decodeToString()} - checkBuildTags - testKeys: ${testKeys.decodeToString()}")
        val buildTags = Build.TAGS
        return buildTags != null && buildTags.contains(testKeys.decodeToString())
    }

    private fun hasSuperUserPaths(): Boolean {
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

        val paths = arrayOf(
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
            devSu.decodeToString()
        )
        println("${SECURITY_LOG_TAG.decodeToString()} - checkSuperUserPaths - paths: ${paths.joinToString(", ")}")
        for (path in paths) {
            if (File(path).exists()) return true
        }
        return false
    }

    private fun isSuBinaryRunning(): Boolean {
      // /system/xbin/which
      val which = intArrayOf(76,51,78,53,99,51,82,108,98,83,57,52,89,109,108,117,76,51,100,111,97,87,78,111)
      // su
      val su = intArrayOf(99,51,85,61)
      // /system/bin/which su
      val systemBinWhichSu = intArrayOf(76, 51, 78, 53, 99, 51, 82, 108, 98, 83, 57, 105, 97, 87, 52, 118, 100, 50, 104, 112, 89, 50, 103, 103, 99, 51, 85, 61)
      // which su
      val whichSu = intArrayOf(100, 50, 104, 112, 89, 50, 103, 103, 99, 51, 85, 61)
      println("${SECURITY_LOG_TAG.decodeToString()} - checkSuBinary - ${arrayOf(which.decodeToString(), su.decodeToString()).joinToString(", ")}")
      return Utils.isProcessRunning(which) || Utils.isProcessRunning(su) || Utils.isProcessRunning(systemBinWhichSu) || Utils.isProcessRunning(whichSu)
    }

  private fun hasRootManagementApps(context: Context): Boolean {
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

    val rootManagementApps: List<String> = mutableListOf(
      comNoshufouAndroidSu.decodeToString(),
      comThirdpartySuperuser.decodeToString(),
      euChainfireSupersu.decodeToString(),
      comKoushikduttaSuperuser.decodeToString(),
      comZachspongTemprootremovejb.decodeToString(),
      comRamdroidAppquarantine.decodeToString()
    )

    val installedPackages: MutableList<String> = ArrayList()
    val apps = Utils.getInstalledApplications(context)
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
    return false
  }
}
