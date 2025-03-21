package com.example.app

import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity

abstract class BaseAppCompatActivity: AppCompatActivity() {
  abstract fun onCreateBase()
  abstract fun closeApp()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    onCreateBase()
    val onBackPressedCallback: OnBackPressedCallback = object : OnBackPressedCallback(true) {
      override fun handleOnBackPressed() {
        closeApp()
      }
    }
    onBackPressedDispatcher.addCallback(this, onBackPressedCallback)
  }

  override fun onStop() {
    super.onStop()
    finish()
  }
}
