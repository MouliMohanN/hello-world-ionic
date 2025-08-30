package com.example.app.utils

import android.content.Context
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import java.io.IOException
import java.security.GeneralSecurityException

private object FileUtil {
  fun getFileName(): String {
    // encryptedwavestorage - yguioehrphkemzztvdif
    return intArrayOf(101, 87, 100, 49, 97, 87, 57, 108, 97, 72, 74, 119, 97, 71, 116, 108, 98, 88, 112, 54, 100, 72, 90, 107, 97, 87, 89, 61).decodeToString()
  }
}

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

  // masterKey - vizzjvNgz
  fun getEncryptedPreferences(context: Context, vizzjvNgz : MasterKey): SharedPreferences? {
    return try {
      EncryptedSharedPreferences.create(
        context,
        FileUtil.getFileName(), // Name of your shared preferences file
        vizzjvNgz,
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
  // masterKey
  var vizzjvNgz: MasterKey? = null

  private fun getMasterKey(context: Context): MasterKey {
    if (vizzjvNgz == null) {
      vizzjvNgz = Utils.generateMasterKey(context)
    }
    return vizzjvNgz!!
  }

  fun saveSecretData(context: Context, key: String, data: String) {
    PreferencesUtil.saveSecretData(Utils.getEncryptedPreferences(context, getMasterKey(context)), key, data)
  }

  fun getSecretData(context: Context, key: String): String? {
    return PreferencesUtil.getSecretData(Utils.getEncryptedPreferences(context, getMasterKey(context)), key)
  }
}
