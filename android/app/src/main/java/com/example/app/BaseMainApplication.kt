package com.example.app

import android.app.Activity
import android.app.Application
import android.os.Bundle

abstract class BaseMainApplication: Application(), Application.ActivityLifecycleCallbacks {

  abstract fun doSecurityCheckOnMainApplication(activity: Activity)

  override fun onCreate() {
    super.onCreate()
    registerActivityLifecycleCallbacks(this)
  }

  override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {}
  override fun onActivityStarted(activity: Activity) {}

  override fun onActivityResumed(activity: Activity) {
    if (activity is SecurityIssueActivity) return
    doSecurityCheckOnMainApplication(activity)
  }

  override fun onActivityPaused(activity: Activity) {}
  override fun onActivityStopped(activity: Activity) {}
  override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {}
  override fun onActivityDestroyed(activity: Activity) {}

}
