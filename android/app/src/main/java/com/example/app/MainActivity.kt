package com.example.app

import com.example.app.security.SecurityService

class MainActivity : BaseMainActivity() {
  override fun doSecurityCheckOnMainActivity() {
    SecurityService.checkAndBlockHacker(this, { _, _ -> })
  }
}
