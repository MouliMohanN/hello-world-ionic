package com.example.emulator

import android.util.Base64

class EmulatorLib {

  /**
   * A native method that is implemented by the 'emulator' native library,
   * which is packaged with this application.
   */
  external fun isDetected(): Boolean
  external fun getResult(): String

  companion object {
    // Used to load the 'emulator' library on application startup.

    private fun IntArray.decodeToString(): String {
      val base64String = this.map { it.toChar() }.joinToString("")
      return Base64.decode(base64String, Base64.DEFAULT).decodeToString()
    }

    init {
      // emulator
      val emulatorString = intArrayOf(90, 87, 49, 49, 98, 71, 70, 48, 98, 51, 73, 61).decodeToString()
      System.loadLibrary(emulatorString)
    }
  }
}
