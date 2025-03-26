package com.example.app.security.utils

import android.content.Context
import android.hardware.usb.UsbDevice
import android.hardware.usb.UsbManager
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.net.InetSocketAddress
import java.net.Socket

object AdbConnectionChecker {

  fun isAdbServerReachable(ip: String, port: Int = 5555): Boolean {
    return try {
      Socket().use { socket ->
        socket.connect(InetSocketAddress(ip, port), 2000)
        true
      }
    } catch (e: IOException) {
      false
    }
  }

  fun isDeviceConnected(context: Context): Boolean {
    var isConnected = try {
      // Execute the adb devices command
      val process = Runtime.getRuntime().exec("adb devices")
      val reader = BufferedReader(InputStreamReader(process.inputStream))

      var line: String?
      var deviceConnected = false
      while (reader.readLine().also { line = it } != null) {
        if (line!!.contains("device")) {
          deviceConnected = true
          break
        }
      }
      reader.close()
      deviceConnected
    } catch (e: Exception) {
      e.printStackTrace()
      false
    }
    if (isConnected.not()) {
      val usbManager = context.getSystemService(Context.USB_SERVICE) as UsbManager
      val deviceList: HashMap<String, UsbDevice> = usbManager.deviceList
      isConnected = deviceList.isNotEmpty()
    }
    if (isConnected.not()) {
      // val ip = NetworkUtils.getIpAddress(context)
      val ip = "192.168.1.96"
      if (ip != null) {
        isConnected = isAdbServerReachable(ip)
      }
    }
    return isConnected
  }
}
