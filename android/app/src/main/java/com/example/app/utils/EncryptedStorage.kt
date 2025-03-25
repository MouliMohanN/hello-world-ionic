package com.example.app.utils

import android.content.Context
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import java.io.IOException
import java.security.GeneralSecurityException

private object Utils {
  fun generateMasterKey(context: Context): MasterKey? {
    return try {
      MasterKey.Builder(context)
        .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
        .build()
    } catch (e: GeneralSecurityException) {
      null
    } catch (e: IOException) {
      null
    }
  }

  fun getEncryptedPreferences(context: Context, masterKey : MasterKey): SharedPreferences? {
    return try {
      EncryptedSharedPreferences.create(
        context,
        "secret_shared_prefs", // Name of your shared preferences file
        masterKey,
        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
      )
    } catch (e: GeneralSecurityException) {
      null
    } catch (e: IOException) {
      null
    }
  }
}

private object PreferencesUtil {
  fun saveSecretData(sharedPreferences: SharedPreferences?, key: String, data: String) {
    sharedPreferences?.edit()?.putString(key, data)?.apply()
  }

  fun getSecretData(sharedPreferences: SharedPreferences?, key: String): String? {
    return sharedPreferences?.getString(key, null)
  }
}

object EncryptedStorage {
  var masterKey: MasterKey? = null

  private fun getMasterKey(context: Context): MasterKey {
    if (masterKey == null) {
      masterKey = Utils.generateMasterKey(context)
    }
    return masterKey!!
  }

  fun saveSecretData(context: Context, key: String, data: String) {
    PreferencesUtil.saveSecretData(Utils.getEncryptedPreferences(context, getMasterKey(context)), key, data)
  }

  fun getSecretData(context: Context, key: String): String? {
    return PreferencesUtil.getSecretData(Utils.getEncryptedPreferences(context, getMasterKey(context)), key)
  }
}
