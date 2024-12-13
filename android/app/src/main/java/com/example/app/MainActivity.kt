package com.example.app

import android.os.Bundle
import com.example.app.plugins.EchoPlugin
import com.getcapacitor.BridgeActivity

class MainActivity : BridgeActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        registerPlugin(EchoPlugin::class.java)
        super.onCreate(savedInstanceState)
    }
}
