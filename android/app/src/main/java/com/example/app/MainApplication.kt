package com.example.app

import android.app.Activity
import android.app.Application
import android.os.Bundle
import com.example.app.security.SecurityIssueActivity
import com.example.app.security.SecurityService

class MainApplication: Application(), Application.ActivityLifecycleCallbacks {

  override fun onCreate() {
    super.onCreate()
    registerActivityLifecycleCallbacks(this)
  }

  override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {}
  override fun onActivityStarted(activity: Activity) {}

  override fun onActivityResumed(activity: Activity) {
    if (activity is SecurityIssueActivity) return
    SecurityService.checkAndBlockHacker(activity, { _, _ -> })
  }

  override fun onActivityPaused(activity: Activity) {}
  override fun onActivityStopped(activity: Activity) {}
  override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {}
  override fun onActivityDestroyed(activity: Activity) {}
}
