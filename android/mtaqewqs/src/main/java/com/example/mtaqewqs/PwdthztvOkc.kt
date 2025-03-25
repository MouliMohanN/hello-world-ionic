package com.example.mtaqewqs

import android.util.Base64

// EmulatorLib
class PwdthztvOkc {

  /**
   * A native method that is implemented by the 'emulator' native library,
   * which is packaged with this application.
   */

  // isDetected
  external fun sbLlzjgwge(): Boolean
  // getResult
  external fun pmaXjwxnu(): String

  companion object {
    // Used to load the 'emulator' library on application startup.

    private fun IntArray.decodeToString(): String {
      val base64String = this.map { it.toChar() }.joinToString("")
      return Base64.decode(base64String, Base64.DEFAULT).decodeToString()
    }

    init {
      // emulator -> mtaqewqs
      val emulatorString = intArrayOf(98, 88, 82, 104, 99, 87, 86, 51, 99, 88, 77, 61).decodeToString()
      System.loadLibrary(emulatorString)
    }
  }
}
