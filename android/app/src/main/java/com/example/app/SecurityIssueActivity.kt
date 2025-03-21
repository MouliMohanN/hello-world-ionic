package com.example.app

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import com.example.app.security.SecurityService
import kotlin.system.exitProcess

class SecurityIssueActivity : BaseAppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_security_issue)
    initializeViews()
    val onBackPressedCallback: OnBackPressedCallback = object : OnBackPressedCallback(true) {
      override fun handleOnBackPressed() {
        closeApp()
      }
    }
    onBackPressedDispatcher.addCallback(this, onBackPressedCallback)
  }

  override fun onCreateBase() {
    setContentView(R.layout.activity_security_issue)
    initializeViews()
  }

  override fun closeApp() {
    finishAffinity()
    exitProcess(0)
  }

  private fun initializeViews() {
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
      closeApp()
    }
  }



  companion object {
    // title in the form of HEX
    const val TITLE = "7469746c65"

    // message in the form of HEX
    const val MESSAGE = "6d657373616765"

    // skipButton in the from of HEX
    const val IS_USB_DEBUGGING_ENABLED = "49535f5553425f444542554747494e475f454e41424c4544"
  }
} // close app on back button press..
