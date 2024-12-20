package com.example.app

import android.os.Build
import android.os.Bundle
import android.view.WindowManager
import com.example.app.plugins.SecurityPlugin
import com.example.app.security.SecurityService
import com.getcapacitor.BridgeActivity
import com.getcapacitor.Plugin

class MainActivity : BridgeActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    val plugins = mutableListOf<Class<out Plugin>>()
    plugins.add(SecurityPlugin::class.java)
    registerPlugins(plugins)
    super.onCreate(savedInstanceState)
  }

  override fun onWindowFocusChanged(hasFocus: Boolean) {
    super.onWindowFocusChanged(hasFocus)
    try {
      if (Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU) {
        if (hasFocus) {
          window.clearFlags(WindowManager.LayoutParams.FLAG_SECURE);
        } else {
          window.setFlags(
            WindowManager.LayoutParams.FLAG_SECURE,
            WindowManager.LayoutParams.FLAG_SECURE
          )
        }
      }
    } catch (error: Exception) { }
  }

  override fun onResume() {
    super.onResume()
    SecurityService.checkAndBlockHacker(this, { _, _ -> })
  }
}
