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
import java.util.*

class QuizActivity : AppCompatActivity(), View.OnClickListener {
    var button1: Button? = null
    var button2: Button? = null
    var button3: Button? = null
    private val question: Questions? = Questions()
    var score_text: TextView? = null
    var question_text: TextView? = null
    private var answer: String? = null
    private val questionlength = question!!.questions!!.size
    var random: Random? = null
    var score = 0
    var count = 0
    var intArray: IntArray? = intArrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)
        random = Random()
        button1 = findViewById<View?>(R.id.button1) as Button
        button1!!.setOnClickListener(this)
        button2 = findViewById<View?>(R.id.button2) as Button
        button2!!.setOnClickListener(this)
        button3 = findViewById<View?>(R.id.button3) as Button
        button3!!.setOnClickListener(this)
        shuffle(intArray)
        count = 0
        score = 0
        intArray = Arrays.copyOf(intArray, intArray!!.size + 1)
        intArray!![intArray!!.size - 1] = 22
        question_text = findViewById<View?>(R.id.questions) as TextView
        NextQuestion(intArray!!.get(count))
        score_text = findViewById<View?>(R.id.score_text) as TextView
    }

    override fun onClick(v: View?) {
        when (v!!.getId()) {
            R.id.button1 -> if (button1!!.getText() === answer) {
                Toast.makeText(this, "Odpowiedź prawidłowa!", Toast.LENGTH_LONG).show()
                ScoreCount()
                NextQuestion(intArray!!.get(count))
            } else {
                Toast.makeText(this, "Odpowiedź błędna!", Toast.LENGTH_LONG).show()
                NextQuestion(intArray!!.get(count))
            }
            R.id.button2 -> if (button2!!.getText() === answer) {
                Toast.makeText(this, "Odpowiedź prawidłowa!", Toast.LENGTH_LONG).show()
                ScoreCount()
                NextQuestion(intArray!!.get(count))
            } else {
                Toast.makeText(this, "Odpowiedź błędna!", Toast.LENGTH_LONG).show()
                NextQuestion(intArray!!.get(count))
            }
            R.id.button3 -> if (button3!!.getText() === answer) {
                Toast.makeText(this, "Odpowiedź prawidłowa!", Toast.LENGTH_LONG).show()
                ScoreCount()
                NextQuestion(intArray!!.get(count))
            } else {
                Toast.makeText(this, "Odpowiedź błędna!", Toast.LENGTH_LONG).show()
                NextQuestion(intArray!!.get(count))
            }
        }
    }

    private fun NextQuestion(x: Int) {
        if (x == 22) {
            QuizEnd()
        }
        question_text!!.setText(question!!.getQuestion(x))
        val r = Random()
        val randomNumber = r.nextInt(3)
        if (randomNumber == 1) {
            button1!!.setText(question.getchoice1(x))
            button2!!.setText(question.getchoice2(x))
            button3!!.setText(question.getchoice3(x))
        } else if (randomNumber == 2) {
            button1!!.setText(question.getchoice2(x))
            button2!!.setText(question.getchoice3(x))
            button3!!.setText(question.getchoice1(x))
        } else {
            button1!!.setText(question.getchoice3(x))
            button2!!.setText(question.getchoice2(x))
            button3!!.setText(question.getchoice1(x))
        }
        answer = question.getCorrectAnswer(x)
        count++
    }

    private fun ScoreCount() {
        score++
        score_text!!.setText("Wynik: $score")
    }

    private fun QuizEnd() {
        val intent = Intent(this@QuizActivity, ScoreActivity::class.java)
        intent.putExtra("scoreQuiz", score)
        startActivity(intent)
    }

    fun shuffle(arr: IntArray?) {
        for (i in arr!!.indices) {
            val index = (Math.random() * arr.size) as Int
            val temp = arr[i]
            arr[i] = arr[index]
            arr[index] = temp
        }
    }
}