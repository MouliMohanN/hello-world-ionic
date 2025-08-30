package com.example.app

import android.os.Build
import android.os.Bundle
import android.view.WindowManager
import com.example.app.plugins.GrofbrbfVqyjko
import com.getcapacitor.BridgeActivity
import com.getcapacitor.Plugin

// BaseMainActivity
abstract class RpgrYlswIjznzlvz: BridgeActivity() {

  // doSecurityCheckOnMainActivity
  abstract fun gqTebsoeosVzvszCaYlswIjznzlvz()

  override fun onCreate(savedInstanceState: Bundle?) {
    val plugins = mutableListOf<Class<out Plugin>>()
    plugins.add(GrofbrbfVqyjko::class.java)
    registerPlugins(plugins)
    super.onCreate(savedInstanceState)
  }

  override fun onResume() {
    super.onResume()
    gqTebsoeosVzvszCaYlswIjznzlvz()
    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU) {
      window.clearFlags(WindowManager.LayoutParams.FLAG_SECURE)
    } else {
      setRecentsScreenshotEnabled(true)
    }
  }

  override fun onPause() {
    super.onPause()
    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU) {
      window.setFlags(
        WindowManager.LayoutParams.FLAG_SECURE,
        WindowManager.LayoutParams.FLAG_SECURE
      )
    } else {
      setRecentsScreenshotEnabled(false)
    }
  }
}
