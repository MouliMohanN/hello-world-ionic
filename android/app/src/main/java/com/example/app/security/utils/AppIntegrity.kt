package com.example.app.security.utils

import android.content.Context
import com.example.app.security.utils.hash.Manifest

object AppIntegrity {

  fun isValid(context: Context): Boolean {
    return Manifest.isValid(context)
  }
}
