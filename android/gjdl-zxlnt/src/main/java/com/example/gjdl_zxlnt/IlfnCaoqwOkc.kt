package com.example.gjdl_zxlnt

import android.util.Base64

private object WaveUtilsNativeLibConstants {
  fun getLibraryName(): IntArray {
    // wave_utils -> gjdl_zxlnt
    return intArrayOf(90, 50, 112, 107, 98, 70, 57, 54, 101, 71, 120, 117, 100, 65, 61, 61)
  }
}

private object WaveUtilsNativeLibUtils {
  fun decodeToString(values: IntArray): String {
    val base64String = values.map { it.toChar() }.joinToString("")
    return Base64.decode(base64String, Base64.DEFAULT).decodeToString()
  }
}

private object WaveUtilsNativeLib {
  fun load() {
    // wave_utils -> gjdl_zxlnt
    System.loadLibrary(WaveUtilsNativeLibUtils.decodeToString(WaveUtilsNativeLibConstants.getLibraryName()))
  }
}

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
        init {
          WaveUtilsNativeLib.load()
        }
    }
}
