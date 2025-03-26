package com.example.app.security.utils

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.annotation.RequiresPermission
import java.net.Inet4Address
import java.net.NetworkInterface
import java.util.Collections

object NetworkUtils {
  private const val TAG = "NetworkUtils"

  @SuppressLint("NewApi")
  fun getIpAddress(context: Context): String? {
    val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val network = connectivityManager.activeNetwork
    val networkCapabilities = connectivityManager.getNetworkCapabilities(network)

    if (networkCapabilities == null) {
      Log.e(TAG, "Network capabilities are null.")
      return null
    }

    if (!networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)) {
      Log.e(TAG, "No internet capability.")
      return null
    }
    try {
      val interfaces = Collections.list(NetworkInterface.getNetworkInterfaces())
      for (networkInterface in interfaces) {
        val addresses = Collections.list(networkInterface.inetAddresses)
        for (address in addresses) {
          if (!address.isLoopbackAddress && address is Inet4Address) {
            return address.hostAddress
          }
        }
      }
    } catch (e: Exception) {
      Log.e(TAG, "Error getting IP address", e)
    }

    return null
  }
}
