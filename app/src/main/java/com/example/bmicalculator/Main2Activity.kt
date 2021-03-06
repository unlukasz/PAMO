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
        } else if (resultBMIVariable == "Waga prawid??owa") {
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
               Mi??so z jelenia dok??adnie umyj i osusz. Pokr??j na kawa??ki o boku oko??o 2 cm i dopraw sol?? i pieprzem.
               Do miski w?????? mi??so. Wsyp rozmaryn i m??k??. Dok??adnie wymiesza.
               Cebul?? pokr??j w pi??rka. Marchewk?? obierz i pokr??j w kostk??.
               Na du??ej patelni rozgrzej olej i sma?? na nim cebul??, a?? si?? zeszkli. Ca??y czas mieszaj.
               Dodaj marchewk?? i mi??so. Sma??, a?? mi??so ca??kowicie zmieni kolor. Ca??y czas mieszaj.
               Wlej czerwone wino, passat?? pomidorow?? i bulion warzywny. Dodaj li??cie laurowe, ziarna pieprzu i ziela angielskiego. Wymieszaj i du?? pod przykryciem oko??o godziny, a?? mi??so b??dzie mi??kkie.
               Podawaj na gor??co z makaronem, kasz?? lub ulubionym pieczywem.
               """.trimIndent()
        dinnerTittle!!.setVisibility(View.VISIBLE)
        dinnerRecipe!!.setVisibility(View.VISIBLE)
        dinnerTittle!!.setText("Gulasz z jelenia")
        dinnerRecipe!!.setText(normal)
    }

    fun wegeDinner(view: View?) {
        val wege = """
               Piekarnik rozgrzej do 230 stopni. Du???? blach?? wy?????? papierem do pieczenia i posmaruj 1 ??y??k?? oleju.
               Obran?? dyni?? i ziemniaki pokr??j na kostk?? o boku oko??o 1 cm.
               Obrane pieczarki pokr??j na po????wki. Cebul?? pokr??j na niezbyt cienkie pi??rka
               Warzywa roz?????? jedn?? warstw?? na blasze wy??o??onej papierem. Spryskaj 2 ??y??kami oleju, lekko pos??l.
               Wstaw do gor??cego piekarnika i piecz przez 10-15 minut, a?? zmi??knie i zacznie si?? rumieni?? na brzegach.
               Blach?? z warzywami wyjmij z piekarnika, dyni?? i pieczarki oraz cebul?? prze?????? do misek.
               Blach?? z ziemniakami wstaw do piekarnika i zapiekaj przez nast??pne 15 minut, a?? b??d?? mi??kkie.
               W woku lub du??ej patelni rozgrzej 4 ??y??ki oleju dodaj past?? curry, wymieszaj, sma?? chwil??.
               Wlej mleko kokosowe. Gotuj na ??rednim ogniu przez 5 minut.
               Dodaj wszystkie ziemniaki, pieczarki i cebul??. Wymieszaj, gotuj przez minut?? na ma??ym ogniu.
               Dodaj li??cie szpinaku, wymieszaj, zestaw z ognia. Dodaj upieczon?? dyni??, dopraw pieprzem i sol??. Delikatnie wymieszaj, by kawa??ki si?? nie rozpad??y.
               Najlepiej smakuje z ry??em ugotowanym (z dodatkiem curry) na sypko i pikantn?? sur??wk?? z og??rk??w
               """.trimIndent()
        dinnerRecipe!!.setVisibility(View.VISIBLE)
        dinnerTittle!!.setVisibility(View.VISIBLE)
        dinnerTittle!!.setText("Tajskie curry z pieczon?? dyni??, ziemniakami i szpinakiem")
        dinnerRecipe!!.setText(wege)
    }
}