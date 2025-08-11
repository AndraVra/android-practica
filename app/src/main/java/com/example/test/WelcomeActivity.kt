package com.example.test


import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment

class WelcomeActivity : ComponentActivity(){
    override fun onCreate (savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)

        val username = intent.getStringExtra("username") ?: "necunoscut"

        setContent {
            MaterialTheme {
                WelcomeScreen(username)
            }
        }
    }
}

@Composable
fun WelcomeScreen(username: String) {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Salut, $username!!!",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.padding(16.dp))

        Button(onClick = {
            val intent = Intent(context, EvenActivity::class.java)
            context.startActivity(intent)
        }) {
            Text("Deschide verificare par/impar")
        }
    }
}