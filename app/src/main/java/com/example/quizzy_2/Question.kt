package com.example.quizzy_2

data class Question (
    val id: Int,
    val file: Int,
    val optionOne: String,
    val optionTwo: String,
    val optionThree: String,
    val optionFour: String,
    val correctAnswer: Int
)