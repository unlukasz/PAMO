package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bmicalculator.R
import android.content.Intent
import android.graphics.Color
import com.example.bmicalculator.MainActivity
import android.text.TextWatcher
import android.text.Editable
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.example.bmicalculator.Main2Activity
import com.example.bmicalculator.GraphActivity
import com.example.bmicalculator.QuizActivity
import com.example.bmicalculator.Questions
import com.example.bmicalculator.ScoreActivity
import android.webkit.WebView
import android.widget.*

class MainActivity : AppCompatActivity() {
    var weight: EditText? = null
    var height: EditText? = null
    var age: EditText? = null
    var resultText: TextView? = null
    var gender: TextView? = null
    var calculation: String? = null
    var BMIresult: String? = null
    var PPMresult: String? = null
    var calculateBMIButton: Button? = null
    var GraphButton: Button? = null
    var QuizButton: Button? = null
    var genderSwitch: Switch? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        weight = findViewById(R.id.weight)
        height = findViewById(R.id.height)
        age = findViewById(R.id.age)
        resultText = findViewById(R.id.resultText)
        gender = findViewById(R.id.gender)
        calculateBMIButton = findViewById(R.id.calculateBMIButton)
        calculateBMIButton!!.setEnabled(false)
        GraphButton = findViewById(R.id.GraphButton)
        QuizButton = findViewById(R.id.QuizButton)
        weight!!.addTextChangedListener(textwatcher)
        height!!.addTextChangedListener(textwatcher)
        age!!.addTextChangedListener(textwatcher)
        genderSwitch = findViewById(R.id.genderSwitch)
        genderSwitch!!.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { compoundButton, isChecked ->
            if (genderSwitch!!.isChecked()) {
                gender!!.setText("Kobieta")
            } else {
                gender!!.setText("Mężczyzna")
            }
        })
    }

    private val textwatcher: TextWatcher? = object : TextWatcher {
        override fun beforeTextChanged(charSequence: CharSequence?, i: Int, i1: Int, i2: Int) {}
        override fun onTextChanged(charSequence: CharSequence?, i: Int, i1: Int, i2: Int) {
            val x = weight!!.getText().toString()
            val y = height!!.getText().toString()
            val z = age!!.getText().toString()
            if (!x.isEmpty() && !y.isEmpty() && !z.isEmpty()) {
                calculateBMIButton!!.setEnabled(true)
            } else {
                calculateBMIButton!!.setEnabled(false)
            }
        }

        override fun afterTextChanged(editable: Editable?) {}
    }

    fun calculateBMI(view: View?) {
        if (genderSwitch!!.isChecked()) {
            gender!!.setText("Kobieta")
        } else {
            gender!!.setText("Mężczyzna")
        }
        val x = weight!!.getText().toString()
        val y = height!!.getText().toString()
        val z = age!!.getText().toString()
        closeKeyboard()
        val weightValue = x.toFloat()
        val heightValue = y.toFloat()
        val heightValueBMI = y.toFloat() / 100
        val ageValue = z.toFloat()
        val bmi = weightValue / (heightValueBMI * heightValueBMI)
        if (bmi < 16) {
            BMIresult = "Wygłodzenie"
            resultText!!.setTextColor(Color.RED)
        } else if (bmi < 17) {
            BMIresult = "Wychudzenie"
            resultText!!.setTextColor(Color.RED)
        } else if (bmi < 18.5) {
            BMIresult = "Niedowaga"
            resultText!!.setTextColor(Color.rgb(255, 127, 80))
        } else if (bmi < 25) {
            BMIresult = "Waga prawidłowa"
            resultText!!.setTextColor(Color.GREEN)
        } else if (bmi < 29) {
            BMIresult = "Nadwaga"
            resultText!!.setTextColor(Color.rgb(255, 127, 80))
        } else if (bmi < 35) {
            BMIresult = "1 stopień otyłości"
            resultText!!.setTextColor(Color.RED)
        } else if (bmi < 40) {
            BMIresult = "2 stopień otyłości"
            resultText!!.setTextColor(Color.RED)
        } else {
            BMIresult = "Otyłość skrajna"
            resultText!!.setTextColor(Color.RED)
        }
        val intent = Intent(this@MainActivity, Main2Activity::class.java)
        intent.putExtra("resultBMIVariable", BMIresult)
        intent.putExtra("scoreBMIVariable", bmi)
        if (genderSwitch!!.isChecked()) {
            //Female
            val ppm = 655.1f + 9.563f * weightValue + 1.85f * heightValue - 4.676f * ageValue
            intent.putExtra("scorePPMVariable", ppm)
        } else {
            //Male
            val ppm = 65.5f + 13.75f * weightValue + 5.003f * heightValue - 6.775f * ageValue
            intent.putExtra("scorePPMVariable", ppm)
        }
        startActivity(intent)
        calculation = "Wynik:\t$bmi\n$BMIresult"
        //resultText.setVisibility(View.VISIBLE);
        resultText!!.setText(calculation)
    }

    fun graphShow(view: View?) {
        closeKeyboard()
        val intent = Intent(this@MainActivity, GraphActivity::class.java)
        startActivity(intent)
    }

    fun quizGame(view: View?) {
        closeKeyboard()
        val intent = Intent(this@MainActivity, QuizActivity::class.java)
        startActivity(intent)
    }

    private fun closeKeyboard() {
        val view = this.currentFocus
        if (view != null) {
            val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }
}