package com.example.test

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class EvenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_even)
        val editNumber = findViewById<EditText>(R.id.editNumber)
        val checkButton = findViewById<Button>(R.id.checkButton)
        val resultText = findViewById<TextView>(R.id.resultText)


        checkButton.setOnClickListener {
            val numberText = editNumber.text.toString()
            val number = numberText.toIntOrNull()
            if (number != null) {
                resultText.text = if (number % 2 == 0) "numarul este par" else "numarul este impar"
            } else {
                resultText.text = "te rog introdu un numar valid"
            }
        }
    }
}
