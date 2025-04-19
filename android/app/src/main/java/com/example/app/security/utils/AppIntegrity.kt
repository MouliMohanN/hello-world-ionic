package com.example.app.security.utils

import android.content.Context
import com.example.app.security.utils.hash.Manifest
import com.example.app.utils.SECURITY_LOG_TAG
import com.example.app.utils.decodeToString

object AppIntegrity {

  fun isDetected(context: Context): Boolean {
    val isManifestValid = Manifest.isValid(context)
    val isRootValid = Root.isEncryptedStorageValid(context)
    val isEmulatorValid = Emulator.isEncryptedStorageValid(context)
    val isRootNativeLibValid = Root.isNativeLibValid()
    val isEmulatorNativeLibValid = Emulator.isNaitveLibValid()
    println("${SECURITY_LOG_TAG.decodeToString()} - AppIntegrity - isValid -\n" +
      "isManifestValid - $isManifestValid\n" +
      "isRootValid - $isRootValid\n" +
      "isEmulatorValid - $isEmulatorValid\n" +
      "isRootNativeLibValid - $isRootNativeLibValid\n" +
      "isEmulatorNativeLibValid - $isEmulatorNativeLibValid")
    return (isManifestValid && isRootValid && isEmulatorValid && isRootNativeLibValid && isEmulatorNativeLibValid).not()
  }
}
