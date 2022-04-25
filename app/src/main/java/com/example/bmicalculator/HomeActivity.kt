package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bmicalculator.R
import android.content.Intent
import android.os.Handler
import com.example.bmicalculator.MainActivity
import android.widget.EditText
import android.widget.TextView
import android.widget.CompoundButton
import android.text.TextWatcher
import android.text.Editable
import com.example.bmicalculator.Main2Activity
import com.example.bmicalculator.GraphActivity
import com.example.bmicalculator.QuizActivity
import com.example.bmicalculator.Questions
import android.widget.Toast
import com.example.bmicalculator.ScoreActivity
import android.webkit.WebView

class HomeActivity : AppCompatActivity() {
    var handler: Handler? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        handler = Handler()
        handler!!.postDelayed(Runnable {
            val intent = Intent(this@HomeActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 2000)
    }
}