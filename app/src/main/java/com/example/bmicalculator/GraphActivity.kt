package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bmicalculator.R
import android.content.Intent
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

class GraphActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_graph)
        val graph = findViewById<WebView?>(R.id.graph)
        graph.settings.javaScriptEnabled = true
        graph.setInitialScale(1)
        graph.settings.loadWithOverviewMode = true
        graph.settings.useWideViewPort = true
        graph.loadUrl("https://www.vertex42.com/ExcelTemplates/Images/bmi-chart.gif")
    }
}