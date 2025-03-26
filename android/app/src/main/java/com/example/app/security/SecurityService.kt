package com.example.app.security

import android.app.Activity
import android.content.Context
import android.content.Intent
import com.example.app.NyvmiyimVedenIjznzlvz
import com.example.app.security.utils.AdbConnectionChecker
import com.example.app.security.utils.AppIntegrity
import com.example.app.security.utils.DeveloperOptions
import com.example.app.security.utils.Emulator
import com.example.app.security.utils.Frida
import com.example.app.security.utils.Root
import com.example.app.security.utils.SystemCalls
import com.example.app.utils.SECURITY_LOG_TAG
import com.example.app.utils.decodeToString
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.LinkedList
import java.util.Queue

object SecurityType {
  // STD_01
  val DEVELOPER_OPTIONS = intArrayOf(85, 49, 82, 69, 88, 122, 65, 120).decodeToString()

  // STD_02
  val APP_INTEGRITY = intArrayOf(85, 49, 82, 69, 88, 122, 65, 121).decodeToString()

  // STD_03
  val ROOT = intArrayOf(85, 49, 82, 69, 88, 122, 65, 122).decodeToString()

  // STD_04
  val FRIDA = intArrayOf(85, 49, 82, 69, 88, 122, 65, 48).decodeToString()

  // STD_05
  val SYSTEM_CALLS = intArrayOf(85, 49, 82, 69, 88, 122, 65, 49).decodeToString()

  // STD_06
  val EMULATOR = intArrayOf(85, 49, 82, 69, 88, 122, 65, 50).decodeToString()

  // STD_07
  val NONE = intArrayOf(85, 49, 82, 69, 88, 122, 65, 51).decodeToString()

  // STD_08
  val ADB_DETECTED = intArrayOf(85, 49, 82, 69, 88, 122, 65, 52).decodeToString()
}

object Obfuscation {
  object DeveloperOptions {
    // USB Debugger/developer Option is ON
    val title = intArrayOf(86,86,78,67,73,69,82,108,89,110,86,110,90,50,86,121,76,50,82,108,100,109,86,115,98,51,66,108,99,105,66,80,99,72,82,112,98,50,52,103,97,88,77,103,84,48,52,61).decodeToString()
    // This application is not supported on USB debugging enabled device.
    val message = intArrayOf(86,71,104,112,99,121,66,104,99,72,66,115,97,87,78,104,100,71,108,118,98,105,66,112,99,121,66,117,98,51,81,103,99,51,86,119,99,71,57,121,100,71,86,107,73,71,57,117,73,70,86,84,81,105,66,107,90,87,74,49,90,50,100,112,98,109,99,103,90,87,53,104,89,109,120,108,90,67,66,107,90,88,90,112,89,50,85,117).decodeToString()
   }

  object GenericErrorInfo {
    // App or device not supported
    val title = intArrayOf(81, 88, 66, 119, 73, 71, 57, 121, 73, 71, 82, 108, 100, 109, 108, 106, 90, 83, 66, 117, 98, 51, 81, 103, 99, 51, 86, 119, 99, 71, 57, 121, 100, 71, 86, 107).decodeToString()

    // Error Code -
    val message = intArrayOf(82, 88, 74, 121, 98, 51, 73, 103, 81, 50, 57, 107, 90, 83, 65, 116, 73, 65, 61, 61).decodeToString()
  }

  object None {
    // No security issues detected
    val title = intArrayOf(84,109,56,103,99,50,86,106,100,88,74,112,100,72,107,103,97,88,78,122,100,87,86,122,73,71,82,108,100,71,86,106,100,71,86,107).decodeToString()
    // This application is safe to use.
    val message = intArrayOf(86,71,104,112,99,121,66,104,99,72,66,115,97,87,78,104,100,71,108,118,98,105,66,112,99,121,66,122,89,87,90,108,73,72,82,118,73,72,86,122,90,83,52,61).decodeToString()
   }
}


object SecurityService {

  var securityJob: Job? = null
  var fifoQueue: Queue<(title: String, message: String) -> Unit>? = null
  var result: String? = null

  private fun getSecurityType(context: Context): String {
    val isDeveloperOptionsDetected = DeveloperOptions.isDetected(context)
    val isAdbConnected = AdbConnectionChecker.isDeviceConnected(context)
    val isAppIntegrityNotValid = AppIntegrity.isValid(context).not()
    val isRootDetected = Root.isDetected(context)
    val isFridaDetected = Frida.isDetected()
    val isSystemCallsDetected = SystemCalls.isDetected()
    val isEmulatorDetected = Emulator.isDetected(context)

    if (isDeveloperOptionsDetected) {
      return SecurityType.DEVELOPER_OPTIONS
    }
    if (isAdbConnected) {
      return SecurityType.ADB_DETECTED
    }
    if (isAppIntegrityNotValid) {
      return SecurityType.APP_INTEGRITY
    }
    if (isRootDetected) {
      return SecurityType.ROOT
    }
    if (isFridaDetected) {
      return SecurityType.FRIDA
    }
    if (isSystemCallsDetected) {
      return SecurityType.SYSTEM_CALLS
    }
    if (isEmulatorDetected) {
      return SecurityType.EMULATOR
    }
    return SecurityType.NONE
  }

  private fun getTitleAndMessageForSecurityType(type: String): Triple<String, String, Boolean> {
    println(
      "${SECURITY_LOG_TAG.decodeToString()} - getTitleAndMessageForSecurityType - type: $type"
    )
    return when (type) {
      SecurityType.DEVELOPER_OPTIONS -> Triple(
        Obfuscation.DeveloperOptions.title,
        Obfuscation.DeveloperOptions.message,
        true
      )

      SecurityType.ADB_DETECTED,
      SecurityType.APP_INTEGRITY,
      SecurityType.FRIDA,
      SecurityType.ROOT,
      SecurityType.SYSTEM_CALLS,
      SecurityType.EMULATOR -> Triple(
        Obfuscation.GenericErrorInfo.title,
        "${Obfuscation.GenericErrorInfo.message} $type",
        false
      )

      else -> {
        Triple(
          Obfuscation.None.title,
          Obfuscation.None.message,
          false
        )
      }
    }
  }

  private fun launchSecurityActivity(activityContext: Activity, type: String) {
    val (title, message, isUsbDebuggingEnabled) = getTitleAndMessageForSecurityType(type)
    CoroutineScope(Dispatchers.Main).launch {
      val intent: Intent = Intent(activityContext, NyvmiyimVedenIjznzlvz::class.java)
      intent.putExtra(NyvmiyimVedenIjznzlvz.TITLE, title)
      intent.putExtra(NyvmiyimVedenIjznzlvz.MESSAGE, message)
      intent.putExtra(NyvmiyimVedenIjznzlvz.IS_USB_DEBUGGING_ENABLED, isUsbDebuggingEnabled)
      intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
      activityContext.startActivity(intent)
    }
  }

  private fun notifyQueue() {
    if (fifoQueue.isNullOrEmpty()) {
      return
    }
    fifoQueue?.forEach {
      dispatchResult(it)
    }
    fifoQueue?.clear()
  }

  private fun dispatchResult(callback: (title: String, message: String) -> Unit) {
    result?.let {
      if (it == SecurityType.NONE) {
        callback("", "")
        return
      }
      val (title, message) = getTitleAndMessageForSecurityType(it)
      callback(title, message)
    }
  }

  private fun isSecurityJobRunning(callback: (title: String, message: String) -> Unit): Boolean {
    if (securityJob != null) {
      if (result.isNullOrEmpty()) {
        // result is not computed yet
        if (fifoQueue == null) {
          fifoQueue = LinkedList()
        }
        fifoQueue?.offer(callback)
      } else {
        // result is computed
        dispatchResult(callback)
        notifyQueue()
      }
      return true
    }
    return false
  }

  private fun cleanUp() {
    notifyQueue()
    securityJob?.cancel()
    securityJob = null
    fifoQueue = null
    result = null
  }

  fun onSkipButtonClicked() {
    DeveloperOptions.setSkipUsbDeveloperOptionDetection(true)
    cleanUp()
  }

  // title -> ymwnf
  // message -> tkxwdif
  fun checkAndBlockHacker(
    activityContext: Activity,
    callback: (ymwnf: String, tkxwdif: String) -> Unit
  ) {
    if (isSecurityJobRunning(callback)) {
      return
    }
    securityJob = CoroutineScope(Dispatchers.IO).launch {
      val type = getSecurityType(activityContext)
      result = type
      dispatchResult(callback)
      notifyQueue()
      if (type != SecurityType.NONE) {
        launchSecurityActivity(activityContext, type)
      }
      delay(3000)
      cleanUp()
    }
  }

}
