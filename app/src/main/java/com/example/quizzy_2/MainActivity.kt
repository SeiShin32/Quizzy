package com.example.quizzy_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.widget.AppCompatEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startButton = findViewById<Button>(R.id.start_btn)
        val namebox = findViewById<AppCompatEditText>(R.id.name_box)

        startButton.setOnClickListener{
            if(namebox.text.toString().isEmpty())
            {
                Toast.makeText(this, "Please enter your name", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, MainMenu::class.java)
                intent.putExtra(Constants.USER_NAME, namebox.text.toString())
                startActivity(intent)
                finish()
            }
        }

    }
}