package com.example.gjdl_zxlnt

import android.util.Base64

// WaveUtilsLib
class IlfnCaoqwOkc {

    /**
     * A native method that is implemented by the 'wave_utils' native library,
     * which is packaged with this application.
     */
    // doPathsExist
    external fun pzZjboyJbluu(paths: Array<String>): String

    companion object {
        // Used to load the 'wave_utils' library on application startup.

      private fun IntArray.decodeToString(): String {
        val base64String = this.map { it.toChar() }.joinToString("")
        return Base64.decode(base64String, Base64.DEFAULT).decodeToString()
      }

        init {
            // wave_utils -> gjdl_zxlnt
            val waveUtilsString = intArrayOf(90, 50, 112, 107, 98, 70, 57, 54, 101, 71, 120, 117, 100, 65, 61, 61).decodeToString()
            System.loadLibrary(waveUtilsString)
        }
    }
}
