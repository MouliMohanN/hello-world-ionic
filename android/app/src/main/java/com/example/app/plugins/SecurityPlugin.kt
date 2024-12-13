package com.example.app.plugins

import com.getcapacitor.JSObject
import com.getcapacitor.Plugin
import com.getcapacitor.PluginCall
import com.getcapacitor.PluginMethod
import com.getcapacitor.annotation.CapacitorPlugin

@CapacitorPlugin(name = "Security")
class SecurityPlugin: Plugin() {

  @PluginMethod
  fun isAppSecure(call: PluginCall) {
    val isSecure = true
    val ret = JSObject()
    ret.put("isSecure", isSecure)
    call.resolve(ret)
  }
}
