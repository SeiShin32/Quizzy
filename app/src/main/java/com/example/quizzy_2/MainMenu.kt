package com.example.quizzy_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast


class MainMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)
        var userName = intent.getStringExtra(Constants.USER_NAME)

        val audioTest = findViewById<ImageButton>(R.id.imageButton)
        val Profile = findViewById<ImageButton>(R.id.imageButton2)
        val textTest = findViewById<ImageButton>(R.id.imageButton3)


        textTest.setOnClickListener{
            val intent = Intent(this, TestInstance::class.java)
            intent.putExtra(Constants.USER_NAME, userName)
            startActivity(intent)
        }

        Profile.setOnClickListener{
            val intent = Intent(this, Profile::class.java)
            startActivity(intent)
        }

        audioTest.setOnClickListener{
            val intent = Intent(this, AudioTestInstance::class.java)
            intent.putExtra(Constants.USER_NAME, userName)
            startActivity(intent)
        }
    }
}