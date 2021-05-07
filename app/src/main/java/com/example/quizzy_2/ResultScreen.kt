package com.example.quizzy_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView


class ResultScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_screen)
        val score = intent.getIntExtra(Constants.SCORE, 0)
        val userName = intent.getStringExtra(Constants.USER_NAME)

        val btn = findViewById<Button>(R.id.button)
        val grats = findViewById<TextView>(R.id.grats)
        val userScore = findViewById<TextView>(R.id.userScore)

        grats.text = "Congratulations, $userName!"
        userScore.text = "Your score is $score out of 100!"

        btn.setOnClickListener{
            val intent = Intent(this, MainMenu::class.java)
            startActivity(intent)
            finish()
        }
    }
}