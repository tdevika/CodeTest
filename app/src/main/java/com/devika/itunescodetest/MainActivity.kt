package com.devika.itunescodetest

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lookAndType.setOnClickListener {
            startActivity(Intent(this, LookAndTypeActivity::class.java))
        }
        romanToInt.setOnClickListener {
            startActivity(Intent(this, RomanToIntConverter::class.java))
        }
    }
}