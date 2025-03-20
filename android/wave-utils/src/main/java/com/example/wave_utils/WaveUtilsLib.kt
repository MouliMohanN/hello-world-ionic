package com.example.wave_utils

import android.util.Base64

class WaveUtilsLib {

    /**
     * A native method that is implemented by the 'wave_utils' native library,
     * which is packaged with this application.
     */
    external fun doPathsExist(paths: Array<String>): Boolean

    companion object {
        // Used to load the 'wave_utils' library on application startup.

      private fun IntArray.decodeToString(): String {
        val base64String = this.map { it.toChar() }.joinToString("")
        return Base64.decode(base64String, Base64.DEFAULT).decodeToString()
      }

        init {
            // wave_utils
            val waveUtilsString = intArrayOf(100, 50, 70, 50, 90, 86, 57, 49, 100, 71, 108, 115, 99, 119, 61, 61).decodeToString()
            System.loadLibrary(waveUtilsString)
        }
    }
}
