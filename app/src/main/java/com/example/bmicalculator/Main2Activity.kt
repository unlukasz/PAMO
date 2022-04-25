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
import com.example.bmicalculator.Main2Activity
import com.example.bmicalculator.GraphActivity
import com.example.bmicalculator.QuizActivity
import com.example.bmicalculator.Questions
import com.example.bmicalculator.ScoreActivity
import android.webkit.WebView
import android.widget.*

class Main2Activity : AppCompatActivity() {
    var BMIresult: TextView? = null
    var scoreBMIText: TextView? = null
    var scorePPMText: TextView? = null
    var dinnerTittle: TextView? = null
    var dinnerRecipe: TextView? = null
    var defaultValue = 0f
    var normalButton: Button? = null
    var wegeButton: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        BMIresult = findViewById(R.id.BMIresult)
        scoreBMIText = findViewById(R.id.scoreBMIText)
        scorePPMText = findViewById(R.id.scorePPMText)
        dinnerRecipe = findViewById(R.id.dinnerRecipe)
        dinnerTittle = findViewById(R.id.dinnerTittle)
        normalButton = findViewById(R.id.normalButton)
        wegeButton = findViewById(R.id.wegeButton)
        val resultBMIVariable = intent.getStringExtra("resultBMIVariable")
        val scoreBMIVariable = intent.getFloatExtra("scoreBMIVariable", defaultValue)
        val scorePPMVariable = intent.getFloatExtra("scorePPMVariable", defaultValue)
        val textBMI = "BMI wynosi: " + String.format("%.2f", scoreBMIVariable)
        val textPPM = "PPM wynosi: " + String.format("%.2f", scorePPMVariable)
        if (resultBMIVariable == "Niedowaga" || resultBMIVariable == "Nadwaga") {
            BMIresult!!.setTextColor(Color.rgb(255, 127, 80))
        } else if (resultBMIVariable == "Waga prawidłowa") {
            BMIresult!!.setTextColor(Color.rgb(0, 255, 0))
        } else {
            BMIresult!!.setTextColor(Color.rgb(255, 0, 0))
        }
        BMIresult!!.setText(resultBMIVariable)
        scoreBMIText!!.setText(textBMI)
        scorePPMText!!.setText(textPPM)
    }

    fun normalDinner(view: View?) {
        val normal = """
               Mięso z jelenia dokładnie umyj i osusz. Pokrój na kawałki o boku około 2 cm i dopraw solą i pieprzem.
               Do miski włóż mięso. Wsyp rozmaryn i mąkę. Dokładnie wymiesza.
               Cebulę pokrój w piórka. Marchewkę obierz i pokrój w kostkę.
               Na dużej patelni rozgrzej olej i smaż na nim cebulę, aż się zeszkli. Cały czas mieszaj.
               Dodaj marchewkę i mięso. Smaż, aż mięso całkowicie zmieni kolor. Cały czas mieszaj.
               Wlej czerwone wino, passatę pomidorową i bulion warzywny. Dodaj liście laurowe, ziarna pieprzu i ziela angielskiego. Wymieszaj i duś pod przykryciem około godziny, aż mięso będzie miękkie.
               Podawaj na gorąco z makaronem, kaszą lub ulubionym pieczywem.
               """.trimIndent()
        dinnerTittle!!.setVisibility(View.VISIBLE)
        dinnerRecipe!!.setVisibility(View.VISIBLE)
        dinnerTittle!!.setText("Gulasz z jelenia")
        dinnerRecipe!!.setText(normal)
    }

    fun wegeDinner(view: View?) {
        val wege = """
               Piekarnik rozgrzej do 230 stopni. Dużą blachę wyłóż papierem do pieczenia i posmaruj 1 łyżką oleju.
               Obraną dynię i ziemniaki pokrój na kostkę o boku około 1 cm.
               Obrane pieczarki pokrój na połówki. Cebulę pokrój na niezbyt cienkie piórka
               Warzywa rozłóż jedną warstwą na blasze wyłożonej papierem. Spryskaj 2 łyżkami oleju, lekko posól.
               Wstaw do gorącego piekarnika i piecz przez 10-15 minut, aż zmięknie i zacznie się rumienić na brzegach.
               Blachę z warzywami wyjmij z piekarnika, dynię i pieczarki oraz cebulę przełóż do misek.
               Blachę z ziemniakami wstaw do piekarnika i zapiekaj przez następne 15 minut, aż będą miękkie.
               W woku lub dużej patelni rozgrzej 4 łyżki oleju dodaj pastę curry, wymieszaj, smaż chwilę.
               Wlej mleko kokosowe. Gotuj na średnim ogniu przez 5 minut.
               Dodaj wszystkie ziemniaki, pieczarki i cebulę. Wymieszaj, gotuj przez minutę na małym ogniu.
               Dodaj liście szpinaku, wymieszaj, zestaw z ognia. Dodaj upieczoną dynię, dopraw pieprzem i solą. Delikatnie wymieszaj, by kawałki się nie rozpadły.
               Najlepiej smakuje z ryżem ugotowanym (z dodatkiem curry) na sypko i pikantną surówką z ogórków
               """.trimIndent()
        dinnerRecipe!!.setVisibility(View.VISIBLE)
        dinnerTittle!!.setVisibility(View.VISIBLE)
        dinnerTittle!!.setText("Tajskie curry z pieczoną dynią, ziemniakami i szpinakiem")
        dinnerRecipe!!.setText(wege)
    }
}