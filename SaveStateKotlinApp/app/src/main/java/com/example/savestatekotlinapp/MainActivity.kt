package com.example.savestatekotlinapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            textView.text = editText.text
        }
    }

    override fun onSaveInstanceState(outState: Bundle?) {

        outState?.run { putString("KEY", textView.text.toString()) }
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        textView.text = savedInstanceState?.getString("KEY")
    }
}
