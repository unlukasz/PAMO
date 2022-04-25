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
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see [Testing documentation](http://d.android.com/tools/testing)
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        Assert.assertEquals("com.example.bmicalculator", appContext.packageName)
    }
}