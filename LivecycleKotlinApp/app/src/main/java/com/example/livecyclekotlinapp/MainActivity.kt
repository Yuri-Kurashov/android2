package com.example.livecyclekotlinapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toastMeState("ON_CREATE")
        Log.d("myLogs", "ON_CREATE")
    }

    fun toastMeState (massege: String) {
        Toast.makeText(this, "${lifecycle.currentState}, $massege", Toast.LENGTH_SHORT).show()
    }

    override fun onStart() {
        super.onStart()
        toastMeState("ON_START")
    }

    override fun onResume() {
        super.onResume()
        toastMeState("ON_RESUME")
    }

    override fun onPostResume() {
        super.onPostResume()
        toastMeState("ON_POST_RESUME")
    }

    override fun onPause() {
        super.onPause()
        toastMeState("ON_PAUSE")
    }

    override fun onStop() {
        super.onStop()
        toastMeState("ON_STOP")
    }

    override fun onRestart() {
        super.onRestart()
        toastMeState("ON_RESTART")
    }

    override fun onDestroy() {
        super.onDestroy()
        toastMeState("ON_DESTROY")
    }

}
