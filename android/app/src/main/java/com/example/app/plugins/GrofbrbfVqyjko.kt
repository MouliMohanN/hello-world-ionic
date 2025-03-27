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
    // type -> xbrf
    val TYPE = intArrayOf(101, 71, 74, 121, 90, 103, 61, 61)
    // title -> ymwnf
    val TITLE = intArrayOf(101, 87, 49, 51, 98, 109, 89, 61)
    // message -> tkxwdif
    val MESSAGE = intArrayOf(100, 71, 116, 52, 100, 50, 82, 112, 90, 103, 61, 61)
    SecurityService.checkAndBlockHacker(activity, { xbrf, ymwnf, tkxwdif ->
      val ret = JSObject()
      ret.put(TYPE.decodeToString(), xbrf)
      ret.put(TITLE.decodeToString(), ymwnf)
      ret.put(MESSAGE.decodeToString(), tkxwdif)
      call.resolve(ret)
    })
  }
}
