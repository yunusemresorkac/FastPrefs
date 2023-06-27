package com.yeslab.fastprefs

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import com.google.gson.Gson

class FastPrefs constructor(private val context: Context,
                            private val preferencesName: String = "FastPrefs"
) {

    val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(preferencesName, Context.MODE_PRIVATE)


    fun getInt(key: String, defaultValue: Int): Int {
        return sharedPreferences.getInt(key, defaultValue)
    }

    fun setInt(key: String, value: Int) {
        sharedPreferences.edit {
            putInt(key, value)
        }
    }

    fun getLong(key: String, defaultValue: Long): Long {
        return sharedPreferences.getLong(key, defaultValue)
    }

    fun setLong(key: String, value: Long) {
        sharedPreferences.edit {
            putLong(key, value)
        }
    }

    fun getFloat(key: String, defaultValue: Float): Float {
        return sharedPreferences.getFloat(key, defaultValue)
    }

    fun setFloat(key: String, value: Float) {
        sharedPreferences.edit {
            putFloat(key, value)
        }
    }

    fun getBoolean(key: String, defaultValue: Boolean): Boolean {
        return sharedPreferences.getBoolean(key, defaultValue)
    }

    fun setBoolean(key: String, value: Boolean) {
        sharedPreferences.edit {
            putBoolean(key, value)
        }
    }

    fun getString(key: String, defaultValue: String?): String? {
        return sharedPreferences.getString(key, defaultValue)
    }

    fun setString(key: String, value: String?) {
        sharedPreferences.edit {
            putString(key, value)
        }
    }

    fun getStringSet(key: String, defaultValue: Set<String>): Set<String>? {
        return sharedPreferences.getStringSet(key, defaultValue)
    }

    fun setStringSet(key: String, value: Set<String>) {
        sharedPreferences.edit {
            putStringSet(key, value)
        }
    }
    inline fun <reified T> get(key: String, defaultValue: T?): T? {
        val jsonString = sharedPreferences.getString(key, null)
        return if (jsonString != null) {
            Gson().fromJson(jsonString, T::class.java)
        } else {
            defaultValue
        }
    }

    inline fun <reified T> set(key: String, value: T) {
        val jsonString = Gson().toJson(value)
        sharedPreferences.edit {
            putString(key, jsonString)
        }
    }

    fun remove(key: String) {
        sharedPreferences.edit {
            remove(key)
        }
    }

    fun clear() {
        sharedPreferences.edit {
            clear()
        }
    }
}