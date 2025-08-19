package com.example.recyclerviewcompose

import android.content.Context

object Prefs {
    private const val PREFS_NAME = "app_prefs"
    private const val KEY_USERNAME = "username"
    private const val KEY_DARK_THEME = "dark_theme"

    private fun prefs(ctx: Context) =
        ctx.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    fun saveUsername(ctx: Context, username: String) {
        prefs(ctx).edit().putString(KEY_USERNAME, username).apply()
    }
    fun getUsername(ctx: Context): String? =
        prefs(ctx).getString(KEY_USERNAME, null)

    fun setDarkTheme(ctx: Context, enabled: Boolean) {
        prefs(ctx).edit().putBoolean(KEY_DARK_THEME, enabled).apply()
    }
    fun isDarkTheme(ctx: Context): Boolean =
        prefs(ctx).getBoolean(KEY_DARK_THEME, false)

}
