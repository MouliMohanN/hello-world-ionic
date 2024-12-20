package com.example.app.plugins

import com.example.app.security.SecurityService
import com.example.app.utils.SECURITY_LOG_TAG
import com.example.app.utils.decodeToString
import com.getcapacitor.JSObject
import com.getcapacitor.Plugin
import com.getcapacitor.PluginCall
import com.getcapacitor.PluginMethod
import com.getcapacitor.annotation.CapacitorPlugin

@CapacitorPlugin(name = "Security")
class SecurityPlugin: Plugin() {

  @PluginMethod
  fun isAppSecure(call: PluginCall) {
    // title
    val TITLE = intArrayOf(100,71,108,48,98,71,85,61)
    // message
    val MESSAGE = intArrayOf(98,87,86,122,99,50,70,110,90,81,61,61)
    // isSecure
    val IS_SECURE = intArrayOf(97,88,78,84,90,87,78,49,99,109,85,61)
    var isSecure = true
    SecurityService.checkAndBlockHacker(activity, { title, message ->
      val ret = JSObject()
      if (title.isNotEmpty() && message.isNotEmpty()) {
        isSecure = false
        ret.put(TITLE.decodeToString(), title)
        ret.put(MESSAGE.decodeToString(), message)
      }
      ret.put(IS_SECURE.decodeToString(), isSecure)
      call.resolve(ret)
    })
  }
}
