package com.example.app.utils

import android.util.Base64

fun IntArray.decodeToString(): String {
  val base64String = this.map { it.toChar() }.joinToString("")
  return Base64.decode(base64String, Base64.DEFAULT).decodeToString()
}

fun <T> T?.orDefault(defaultValue: T): T {
  if (this == null) {
    return defaultValue
  }
  return this
}

fun Boolean?.isTrue(): Boolean {
  return this == true
}

fun <T> T?.isNull(): Boolean {
  if (this == null) {
    return true
  }
  return false
}

// SecurityLog
val SECURITY_LOG_TAG = intArrayOf(85,50,86,106,100,88,74,112,100,72,108,77,98,50,99,61)
