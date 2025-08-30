package com.example.app.plugins

import com.example.app.security.SecurityService
import com.example.app.utils.decodeToString
import com.getcapacitor.JSObject
import com.getcapacitor.Plugin
import com.getcapacitor.PluginCall
import com.getcapacitor.PluginMethod
import com.getcapacitor.annotation.CapacitorPlugin

// Security
@CapacitorPlugin(name = "Alizvlvz")
// SecurityPlugin
class GrofbrbfVqyjko: Plugin() {

  @PluginMethod
  // isAppSecure
  fun tcJxwYjgxtf(call: PluginCall) {
    // title -> ymwnf
    val TITLE = intArrayOf(101, 87, 49, 51, 98, 109, 89, 61)
    // message -> tkxwdif
    val MESSAGE = intArrayOf(100, 71, 116, 52, 100, 50, 82, 112, 90, 103, 61, 61)
    // isSecure -> qzYjgxtf
    val IS_SECURE = intArrayOf(99, 88, 112, 90, 97, 109, 100, 52, 100, 71, 89, 61)
    var isSecure = true
    SecurityService.checkAndBlockHacker(activity, { ymwnf, tkxwdif ->
      val ret = JSObject()
      if (ymwnf.isNotEmpty() && tkxwdif.isNotEmpty()) {
        isSecure = false
        ret.put(TITLE.decodeToString(), ymwnf)
        ret.put(MESSAGE.decodeToString(), tkxwdif)
      }
      ret.put(IS_SECURE.decodeToString(), isSecure)
      call.resolve(ret)
    })
  }
}
