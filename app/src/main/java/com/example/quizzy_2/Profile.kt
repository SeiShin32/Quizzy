package com.example.quizzy_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class Profile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val btn = findViewById<Button>(R.id.button)

        btn.setOnClickListener{
            val intent = Intent(this, MainMenu::class.java)
            startActivity(intent)
        }
    }
}