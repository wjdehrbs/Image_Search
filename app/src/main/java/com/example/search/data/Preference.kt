package com.example.search.data

import android.content.Context
import android.content.SharedPreferences
import com.example.search.data.Constants.Companion.PREFS_NAME
import com.example.search.data.Constants.Companion.PREF_KEY

object Preference {
    fun saveLastSearch(context: Context, query: String) {
        val prefs: SharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = prefs.edit()
        editor.putString(PREF_KEY, query)
        editor.apply()
    }

    fun getLastSearch(context: Context): String? {
        val prefs: SharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        return prefs.getString(PREF_KEY, null)
    }
}