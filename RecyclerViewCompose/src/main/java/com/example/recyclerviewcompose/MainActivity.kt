package com.example.recyclerviewcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val nav = rememberNavController()

            var isDark by remember { mutableStateOf(Prefs.isDarkTheme(this)) }

            AppTheme(darkTheme = isDark) {
                NavHost(navController = nav, startDestination = "login") {

                    composable("login") {
                        LoginScreen(
                            onLoginSuccess = {
                                nav.navigate("list") {
                                    popUpTo("login") { inclusive = true }
                                }
                            }
                        )
                    }

                    composable("list") {
                        MovieListScreen(
                            onOpenSettings = { nav.navigate("settings") }
                        )
                    }

                    composable("settings") {
                        SettingsScreen(
                            isDark = isDark,
                            onToggleDark = { enabled ->
                                Prefs.setDarkTheme(this@MainActivity, enabled)
                                isDark = enabled     // schimbare tema
                            },
                            onBack = { nav.popBackStack() }
                        )
                    }
                }
            }
        }
    }
}
