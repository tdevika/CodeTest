package com.devika.itunescodetest

import android.os.Bundle
import android.view.inputmethod.EditorInfo
import android.widget.TextView.OnEditorActionListener
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_look_n_type.*


class LookAndTypeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_look_n_type)
        input.setOnEditorActionListener(
            OnEditorActionListener { _, actionId, _ ->
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    val inputValue = input.text.toString()
                    output.text = getLookAndTypeValue(inputValue)
                    return@OnEditorActionListener true
                }
                false
            })
    }

    private fun getLookAndTypeValue(value: String): String {
        var output = ""
        var i = 0
        while (i < value.length) {
            var count = 1
            while (i + 1 < value.length && value[i] == value[i + 1]) {
                i++
                count++
            }
            output += " $count " + value[i].toString()
            i++
        }
        return output
    }
}


