package com.example.app

import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity

// BaseAppCompatActivity
abstract class WulwRfeQbyakcIjznzlvz: AppCompatActivity() {
  // onCreateBase
  abstract fun ayMamhzjFduf()
  // closeApp
  abstract fun ksuxiDrq()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    ayMamhzjFduf()
    val onBackPressedCallback: OnBackPressedCallback = object : OnBackPressedCallback(true) {
      override fun handleOnBackPressed() {
        ksuxiDrq()
      }
    }
    onBackPressedDispatcher.addCallback(this, onBackPressedCallback)
  }

  override fun onStop() {
    super.onStop()
    finish()
  }
}
