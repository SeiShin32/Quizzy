package com.example.quizzy_2

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import org.w3c.dom.Text

class AudioTestInstance : AppCompatActivity(), View.OnClickListener {

    private lateinit var player : MediaPlayer
    private var currentPosition = 1
    private var questionList: ArrayList<Question>? = null
    private var selectedOptionPosition: Int = 0
    private var checkIfSelected: Boolean = false
    private var checkIfAnswered: Boolean = false
    var currentscore: Int = 0

    private lateinit var prgBar: ProgressBar
    private lateinit var questionCounter: TextView
    private lateinit var option_one: TextView
    private lateinit var option_two: TextView
    private lateinit var option_three: TextView
    private lateinit var option_four: TextView
    private lateinit var playerButton: ImageButton
    private lateinit var submit_btn: AppCompatButton
    private var userName: String? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_audio_test_instance)
        userName = intent.getStringExtra(Constants.USER_NAME)

        prgBar = findViewById(R.id.progressBar)
        option_one = findViewById(R.id.textView_optionOne)
        option_two = findViewById(R.id.textView_optionTwo)
        option_three = findViewById(R.id.textView_optionThree)
        option_four = findViewById(R.id.textView_optionFour)
        questionCounter = findViewById(R.id.questionCounter)
        submit_btn = findViewById(R.id.submit_button)
        playerButton = findViewById(R.id.playerButton)

        questionList = Constants.getAudioQuestions()
        player = MediaPlayer.create(this, R.raw.audio1fr)
        player.setVolume(1.0f,1.0f)

        setQuestion()


        option_one.setOnClickListener(this)
        option_two.setOnClickListener(this)
        option_three.setOnClickListener(this)
        option_four.setOnClickListener(this)
        submit_btn.setOnClickListener(this)
        playerButton.setOnClickListener(this)
    }

    private fun setQuestion(){

        val question = questionList!![currentPosition-1]
        defaultOption()
        checkIfSelected=false
        checkIfAnswered=false
        submit_btn.getBackground().setAlpha(64)
        player.release()

        if(currentPosition == questionList!!.size){
            submit_btn.setText("FINISH")
        }else{
            submit_btn.setText("SUBMIT")
        }

        prgBar.progress = currentPosition
        questionCounter.text = "Question: $currentPosition" + "/" + prgBar.getMax()
        option_one.text = question.optionOne
        option_two.text = question.optionTwo
        option_three.text = question.optionThree
        option_four.text = question.optionFour
        playerButton.setBackgroundResource(R.drawable.playbutton)
        player = MediaPlayer.create(this, question!!.file)

    }

    private fun defaultOption(){
        val options = ArrayList<TextView>()
        options.add(0, option_one)
        options.add(1, option_two)
        options.add(2, option_three)
        options.add(3, option_four)

        for (option in options)
        {
            option.setTextColor(Color.GRAY)
            option.background = ContextCompat.getDrawable(this, R.drawable.default_option_border_bg)
        }
    }
    private fun selectedOption(option: TextView, selectedOption: Int){
        checkIfSelected = true
        submit_btn.getBackground().setAlpha(255)
        defaultOption()
        selectedOptionPosition = selectedOption
        option.setTextColor(Color.BLACK)
        option.background = ContextCompat.getDrawable(this, R.drawable.selected_option_border_bg)
    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.submit_button) {
            return onSubmit()
        }
        if (v?.id == R.id.playerButton)
        {
            return audioPlayer()
        }
        if (checkIfAnswered) {
            return
        }
        when (v?.id) {
            R.id.textView_optionOne -> {
                selectedOption(option_one, 1)
            }
            R.id.textView_optionTwo -> {
                selectedOption(option_two, 2)
            }
            R.id.textView_optionThree -> {
                selectedOption(option_three, 3)
            }
            R.id.textView_optionFour -> {
                selectedOption(option_four, 4)
            }

        }
    }

    private fun answerView(answer: Int, drawableView: Int){
        when(answer){
            1 ->{
                option_one.background = ContextCompat.getDrawable(this, drawableView)
            }
            2 ->{
                option_two.background = ContextCompat.getDrawable(this, drawableView)
            }
            3 ->{
                option_three.background = ContextCompat.getDrawable(this, drawableView)
            }
            4 ->{
                option_four.background = ContextCompat.getDrawable(this, drawableView)
            }
        }
    }

    private fun onSubmit(){
        if (checkIfSelected) {
            if (selectedOptionPosition == 0) {
                currentPosition++

                when {
                    currentPosition <= questionList!!.size -> {
                        setQuestion()
                    }
                    else -> {
                        val intent = Intent(this, ResultScreen::class.java)
                        intent.putExtra(Constants.SCORE, currentscore)
                        intent.putExtra(Constants.USER_NAME, userName)
                        startActivity(intent)
                        finish()
                    }
                }
            } else {
                if (checkIfAnswered == false) {
                    val question = questionList?.get(currentPosition - 1)
                    if (question!!.correctAnswer != selectedOptionPosition) {
                        answerView(selectedOptionPosition, R.drawable.incorrect_option_border_bg)
                    }else{
                        currentscore += 10
                    }
                    answerView(question.correctAnswer, R.drawable.correct_option_border_bg)
                    checkIfAnswered = true
                    if (currentPosition == questionList!!.size) {
                        submit_btn.setText("FINISH")
                        player.release()
                    } else {
                        submit_btn.setText("NEXT ->")
                    }
                }
                selectedOptionPosition = 0
            }
        }
    }
    private fun audioPlayer(){
        if(player.isPlaying){
            player.pause()
            playerButton.setBackgroundResource(R.drawable.playbutton)
        }else{
        playerButton.setBackgroundResource(R.drawable.pausebutton)
        player.start()
        }
        player.setOnCompletionListener{
            playerButton.setBackgroundResource(R.drawable.playbutton)
        }
    }
}