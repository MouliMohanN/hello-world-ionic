package com.example.app.plugins

import com.getcapacitor.JSObject
import com.getcapacitor.Plugin
import com.getcapacitor.PluginCall
import com.getcapacitor.PluginMethod
import com.getcapacitor.annotation.CapacitorPlugin


@CapacitorPlugin(name = "Echo")
class EchoPlugin: Plugin() {

  @PluginMethod
  fun echo(call: PluginCall): Unit {
    val value = call.getString("value")
    val ret = JSObject()
    ret.put("value", value)
    call.resolve(ret)
  }
}
