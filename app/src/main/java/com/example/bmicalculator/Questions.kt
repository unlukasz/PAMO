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

class Questions {
    var questions: Array<String?>? = arrayOf(
        "Ile posiłków dziennie powinno się spożywać?",
        "Ile litrów wody powinno się pić w ciągu dnia?",
        "Który z posiłków jest najważniejszy?",
        "Co ile godzin powinno się spożywać posiłki?",
        "Ile godzin snu potrzebuje przecietny człowiek?",
        "Kiedy najlepiej spożyć ostatni posiłek przed snem?",
        "W jakim wieku szczególnie powinno się przestrzegać zasad zdrowego odżywiania się?",
        "Czym najlepiej ugasić pragnienie po wysiłku fizycznym?",
        "Jak należy jeść prawidłowo?"
    )
    var choices: Array<Array<String?>?>? = arrayOf(
        arrayOf("Dwa", "Cztery", "Pięć"),
        arrayOf("1 Litr", "1,5 Litrów", "2 Litry"),
        arrayOf("Śniadanie", "Obiad", "Kolacja"),
        arrayOf("1-2", "2-3", "3-4"),
        arrayOf("4-6", "7-8", "9-10"),
        arrayOf(
            "Dwie godziny przed snem.",
            "Kiedy ma się na to ochotę.",
            "Cztery godziny przed snem."
        ),
        arrayOf("W wieku dziecięcym.", "W wieku młodzieńczym.", "W dorosłości i w wieku starszym."),
        arrayOf("Niegazowaną wodą mineralną", "Sokiem.", "Kawą."),
        arrayOf(
            "Szybko przeżuwać.",
            "Dokładnie przeżuwać i rozdrabniać pokarm.",
            "Popijać bez gryzienia."
        )
    )
    var correctAnswer: Array<String?>? = arrayOf(
        "Pięć",
        "1,5 Litrów",
        "Śniadanie",
        "3-4",
        "7-8",
        "Dwie godziny przed snem.",
        "W wieku młodzieńczym.",
        "Niegazowaną wodą mineralną",
        "Dokładnie przeżuwać i rozdrabniać pokarm."
    )

    fun getQuestion(x: Int): String? {
        return questions!!.get(x)
    }

    fun getchoice1(x: Int): String? {
        return choices!!.get(x)!!.get(0)
    }

    fun getchoice2(x: Int): String? {
        return choices!!.get(x)!!.get(1)
    }

    fun getchoice3(x: Int): String? {
        return choices!!.get(x)!!.get(2)
    }

    fun getCorrectAnswer(x: Int): String? {
        return correctAnswer!!.get(x)
    }
}