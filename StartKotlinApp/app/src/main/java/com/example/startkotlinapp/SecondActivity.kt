package com.example.startkotlinapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_second.*
import kotlin.random.Random
import java.util.*

class SecondActivity : AppCompatActivity() {

    companion object {
        const val TOTAL_COUNT = "total_count"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        randomNumber()
    }

    fun randomNumber() {
        val count = intent.getIntExtra(TOTAL_COUNT, 0)
        val random = java.util.Random()
        var randomInt = 0
        if(count > 0) {
            randomInt = random.nextInt(count + 1)
        }
        tvRandom.text = Integer.toString(randomInt)
        tvLabel.text = getString(R.string.random_heading, count);




    }
}
