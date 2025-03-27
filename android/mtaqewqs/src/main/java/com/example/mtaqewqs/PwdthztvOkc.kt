package com.example.mtaqewqs

import android.util.Base64

private object EmulatorNativeLibConstants {
  fun getLibraryName(): IntArray {
    // emulator -> mtaqewqs
    return intArrayOf(98, 88, 82, 104, 99, 87, 86, 51, 99, 88, 77, 61)
  }
}

private object EmulatorNativeLibUtils {
  fun decodeToString(values: IntArray): String {
    val base64String = values.map { it.toChar() }.joinToString("")
    return Base64.decode(base64String, Base64.DEFAULT).decodeToString()
  }
}

private object EmulatorNativeLib {
  fun load() {
    // emulator -> mtaqewqs
    System.loadLibrary(EmulatorNativeLibUtils.decodeToString(EmulatorNativeLibConstants.getLibraryName()))
  }
}

// EmulatorLib
class PwdthztvOkc {

  /**
   * A native method that is implemented by the 'emulator' native library,
   * which is packaged with this application.
   */

  // isDetected
  external fun sbLlzjgwge(): String
  // getResult
  external fun pmaXjwxnu(): String

  companion object {
    // Used to load the 'emulator' library on application startup.
    init {
      EmulatorNativeLib.load()
    }
  }
}
