package com.example.wave_utils

class WaveUtilsLib {

    /**
     * A native method that is implemented by the 'wave_utils' native library,
     * which is packaged with this application.
     */
    external fun doPathsExist(paths: Array<String>): Boolean

    companion object {
        // Used to load the 'wave_utils' library on application startup.
        init {
            System.loadLibrary("wave_utils")
        }
    }
}
