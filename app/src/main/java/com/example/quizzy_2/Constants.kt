package com.example.quizzy_2

object Constants {

    const val USER_NAME: String = "user_name"
    const val SCORE: String = "score"

    fun getQuestions(): ArrayList<Question>{
        val questionList = ArrayList<Question>()

        val question1 = Question(1, R.drawable.text1, "Sumerian", "Chinese", "Japanese", "Thai", 4)
        questionList.add(question1)

        val question2 = Question(2, R.drawable.text2, "Russian", "Hindi", "Greek", "Arabic", 3)
        questionList.add(question2)

        val question3 = Question(3, R.drawable.text3, "Greek", "Hebrew", "Aramaic", "French", 3)
        questionList.add(question3)

        val question4 = Question(4, R.drawable.text4, "Malayalam", "Kannada", "Chinese", "Malay", 1)
        questionList.add(question4)

        val question5 = Question(5, R.drawable.text5, "Korean", "Chinese", "Japanese", "Mongolian", 3)
        questionList.add(question5)

        val question6 = Question(6, R.drawable.text6, "Japanese", "Chinese", "Korean", "Arabic", 2)
        questionList.add(question6)

        val question7 = Question(7, R.drawable.text7, "Russian", "Mongolian", "Uzbek", "Norwegian", 2)
        questionList.add(question7)

        val question8 = Question(8, R.drawable.text8, "Swedish", "Hindi", "Turkish", "German", 4)
        questionList.add(question8)

        val question9 = Question(9, R.drawable.text9, "German", "Slovak", "Dutch", "Italian", 3)
        questionList.add(question9)

        val question10 = Question(10, R.drawable.text10, "Spanish", "Czech", "Slovenian", "Latvian", 2)
        questionList.add(question10)

        return questionList

    }


    fun getAudioQuestions(): ArrayList<Question>{
        val audioQuestionList = ArrayList<Question>()

        val question1 = Question(1, R.raw.audio1fr, "Spanish", "French", "Occitan", "Sicilian", 2)
        audioQuestionList.add(question1)

        val question2 = Question(2, R.raw.audio2de, "Dutch", "Hindi", "German", "Turkish", 3)
        audioQuestionList.add(question2)

        val question3 = Question(3, R.raw.audio3it, "Italian", "Hebrew", "Corsican", "Swedish", 1)
        audioQuestionList.add(question3)

        val question4 = Question(4, R.raw.audio4ru, "Polish", "Yue", "Malay", "Russian", 4)
        audioQuestionList.add(question4)

        val question5 = Question(5, R.raw.audio5pr, "Uzbek", "Swahili", "Portuguese", "Bulgarian", 3)
        audioQuestionList.add(question5)

        val question6 = Question(6, R.raw.audio6cn, "Japanese", "Chinese", "Korean", "Evenk", 2)
        audioQuestionList.add(question6)

        val question7 = Question(7, R.raw.audio7occ, "French", "Occitan", "Slovenian", "Icelandic", 2)
        audioQuestionList.add(question7)

        val question8 = Question(8, R.raw.audio8cata, "Spanish", "Occitan", "Catalan", "Portuguese", 3)
        audioQuestionList.add(question8)

        val question9 = Question(9, R.raw.audio9cors, "Galician", "Corsican", "French", "Italian", 2)
        audioQuestionList.add(question9)

        val question10 = Question(10, R.raw.audio10arab, "Amharic", "Phoenician", "Hebrew", "Arabic", 4)
        audioQuestionList.add(question10)

        return audioQuestionList

    }
}