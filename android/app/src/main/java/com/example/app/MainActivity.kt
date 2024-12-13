package com.example.app

import android.os.Bundle
import com.example.app.plugins.EchoPlugin
import com.example.app.plugins.SecurityPlugin
import com.getcapacitor.BridgeActivity
import com.getcapacitor.Plugin

class MainActivity : BridgeActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val plugins = mutableListOf<Class<out Plugin>>()
        plugins.add(EchoPlugin::class.java)
        plugins.add(SecurityPlugin::class.java)
        registerPlugins(plugins)
        super.onCreate(savedInstanceState)
    }
}
