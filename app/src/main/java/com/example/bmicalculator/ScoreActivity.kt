package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bmicalculator.R
import android.content.Intent
import com.example.bmicalculator.MainActivity
import android.text.TextWatcher
import android.text.Editable
import android.view.View
import com.example.bmicalculator.Main2Activity
import com.example.bmicalculator.GraphActivity
import com.example.bmicalculator.QuizActivity
import com.example.bmicalculator.Questions
import com.example.bmicalculator.ScoreActivity
import android.webkit.WebView
import android.widget.*

class ScoreActivity : AppCompatActivity() {
    var final_score: TextView? = null
    var QuizButton: Button? = null
    var MainButton: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)
        final_score = findViewById(R.id.final_score)
        QuizButton = findViewById(R.id.QuizButton)
        MainButton = findViewById(R.id.MainButton)
        val score = intent.getIntExtra("scoreQuiz", 0)
        final_score!!.setText("Wynik to $score na 9.")
    }

    fun quizGame(view: View?) {
        val intent = Intent(this@ScoreActivity, QuizActivity::class.java)
        startActivity(intent)
    }

    fun BackToMain(view: View?) {
        val intent = Intent(this@ScoreActivity, MainActivity::class.java)
        startActivity(intent)
    }
}