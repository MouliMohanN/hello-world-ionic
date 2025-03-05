package com.example.emulator

class NativeLib {

    /**
     * A native method that is implemented by the 'emulator' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String

    companion object {
        // Used to load the 'emulator' library on application startup.
        init {
            System.loadLibrary("emulator")
        }
    }
}
