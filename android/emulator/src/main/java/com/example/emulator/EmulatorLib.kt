package com.example.emulator

class EmulatorLib {

    /**
     * A native method that is implemented by the 'emulator' native library,
     * which is packaged with this application.
     */
    external fun isDetected(): Boolean
    external fun getResult(): String

    companion object {
        // Used to load the 'emulator' library on application startup.
        init {
            System.loadLibrary("emulator")
        }
    }
}
