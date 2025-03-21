package com.example.app

import android.os.Build
import android.os.Bundle
import android.view.WindowManager
import com.example.app.plugins.SecurityPlugin
import com.getcapacitor.BridgeActivity
import com.getcapacitor.Plugin

abstract class BaseMainActivity: BridgeActivity() {

  abstract fun doSecurityCheckOnMainActivity()

  override fun onCreate(savedInstanceState: Bundle?) {
    val plugins = mutableListOf<Class<out Plugin>>()
    plugins.add(SecurityPlugin::class.java)
    registerPlugins(plugins)
    super.onCreate(savedInstanceState)
    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU) {
      window.setFlags(
        WindowManager.LayoutParams.FLAG_SECURE,
        WindowManager.LayoutParams.FLAG_SECURE
      )
    } else {
      setRecentsScreenshotEnabled(false)
    }
  }

  override fun onResume() {
    super.onResume()
    doSecurityCheckOnMainActivity()
  }
}
