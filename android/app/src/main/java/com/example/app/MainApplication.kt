package com.example.app

import android.app.Activity
import com.example.app.security.SecurityService

class MainApplication: BaseMainApplication() {

  override fun doSecurityCheckOnMainApplication(activity: Activity) {
    SecurityService.checkAndBlockHacker(activity, { _, _ -> })
  }
}
