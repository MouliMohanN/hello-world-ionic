package com.example.app

import android.content.Intent
import android.provider.Settings
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.app.security.SecurityService
import com.example.app.utils.decodeToString

// SecurityIssueActivity
class NyvmiyimVedenIjznzlvz : WulwRfeQbyakcIjznzlvz() {

  override fun ayMamhzjFduf() {
    // activity_security_issue
    setContentView(R.layout.xyocoako_grofbrbf_nwvwf)
    xbvftkuqgkAmhyt()
  }

  override fun ksuxiDrq() {
    finishAffinity()
    System.exit(0)
  }

  // initializeViews
  private fun xbvftkuqgkAmhyt() {
    lfsogqDdjbpiYiavt()
    val extras = intent.extras
    if (extras != null) {
      val issueTitle = findViewById<TextView>(R.id.tv_issue_title)
      issueTitle.text = extras.getString(TITLE)
      val issueDescription = findViewById<TextView>(R.id.tv_issue_description)
      issueDescription.text = extras.getString(MESSAGE)
      val skipButton = findViewById<Button>(R.id.btn_skip)
      skipButton.setOnClickListener { view: View? ->
        SecurityService.onSkipButtonClicked()
        finish()
      }
      val openDevOptionSettingsButton = findViewById<Button>(R.id.btn_open_dev_option_settings)
      openDevOptionSettingsButton.setOnClickListener { view: View? ->
        startActivity(Intent(Settings.ACTION_APPLICATION_DEVELOPMENT_SETTINGS))
      }
      if (extras.getBoolean(IS_USB_DEBUGGING_ENABLED)) {
        skipButton.visibility = View.VISIBLE
        openDevOptionSettingsButton.visibility = View.VISIBLE
      } else {
        skipButton.visibility = View.GONE
        openDevOptionSettingsButton.visibility = View.GONE
      }
    }
    val closeAppButton = findViewById<Button>(R.id.btn_close_app)
    closeAppButton.setOnClickListener { view: View? ->
      ksuxiDrq()
    }
  }

  // updateStaticTexts
  private fun lfsogqDdjbpiYiavt() {
    val alertTitle = findViewById<TextView>(R.id.tv_issue_title)
    // Security Alert !
    val alertTitleString = intArrayOf(85, 50, 86, 106, 100, 88, 74, 112, 100, 72, 107, 103, 81, 87, 120, 108, 99, 110, 81, 103, 73, 81, 61, 61).decodeToString()
    alertTitle.text = alertTitleString

    val skipButton = findViewById<Button>(R.id.btn_skip)
    // Skip
    val skipButtonString = intArrayOf(85, 50, 116, 112, 99, 65, 61, 61)
    skipButton.text = skipButtonString.decodeToString()

    val closeAppButton = findViewById<Button>(R.id.btn_close_app)
    // Close App
    val closeAppButtonString = intArrayOf(81, 50, 120, 118, 99, 50, 85, 103, 81, 88, 66, 119)
    closeAppButton.text = closeAppButtonString.decodeToString()

    val openDevOptionSettingsButton = findViewById<Button>(R.id.btn_open_dev_option_settings)
    // Open Developer Options
    val openDevOptionSettingsButtonString = intArrayOf(84, 51, 66, 108, 98, 105, 66, 69, 90, 88, 90, 108, 98, 71, 57, 119, 90, 88, 73, 103, 84, 51, 66, 48, 97, 87, 57, 117, 99, 119, 61, 61)
    openDevOptionSettingsButton.text = openDevOptionSettingsButtonString.decodeToString()
  }



  companion object {
    // title
    const val TITLE = "ymwnf"

    // message
    const val MESSAGE = "tkxwdif"

    // isUsbDebuggingEnabled
    const val IS_USB_DEBUGGING_ENABLED = "dmNksTtphsrswoLtffoge"
  }
} // close app on back button press..
