package com.devika.itunescodetest

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_roman_to_int_converter.*
import java.util.*


class RomanToIntConverter : AppCompatActivity() {

    private val map = hashMapOf<Char, Int>().apply {
        put('I', 1)
        put('V', 5)
        put('X', 10)
        put('L', 50)
        put('C', 100)
        put('D', 500)
        put('M', 1000)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_roman_to_int_converter)

        romanValue.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {}
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                val romanNumeral = romanValue.text.toString().toUpperCase(Locale.ROOT)
                val integerValue = romanToInt(romanNumeral)
                integerValueTextView.text = integerValue.toString()
            }
        })
    }

    fun romanToInt(romanNumeral: String): Int {
        var results = 0
        var prev = 0
        for (i in romanNumeral.length - 1 downTo 0) {
            map[romanNumeral[i]]?.let {
                val temp: Int = it
                if (temp < prev)
                    results -= temp
                else
                    results += temp
                prev = temp
            }
        }
        return results
    }
}
