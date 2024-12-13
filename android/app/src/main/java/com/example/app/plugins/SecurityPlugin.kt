package com.example.app.plugins

import com.example.app.security.SecurityService
import com.getcapacitor.JSObject
import com.getcapacitor.Plugin
import com.getcapacitor.PluginCall
import com.getcapacitor.PluginMethod
import com.getcapacitor.annotation.CapacitorPlugin

@CapacitorPlugin(name = "Security")
class SecurityPlugin: Plugin() {

  @PluginMethod
  fun isAppSecure(call: PluginCall) {
    var isSecure = true
    SecurityService.checkAndBlockHacker(activity, { title, message ->
      val ret = JSObject()
      if (title.isNotEmpty() && message.isNotEmpty()) {
        isSecure = false
        ret.put("title", title)
        ret.put("message", message)
      }
      ret.put("isSecure", isSecure)
      call.resolve(ret)
    })
  }
}
