package com.example.animationapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Activity3 extends AppCompatActivity implements View.OnClickListener {

    Button button3, button4;
    private static final String TAG2 = "lifeCicle";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
        Log.d(TAG2, "Активити3 создано");
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);

        button3.setOnClickListener(this);
        button4.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button3:
                Intent intent3 = new Intent(this, MainActivity.class);
                startActivity(intent3);
                break;
            case R.id.button4:
                Intent intent4 = new Intent(this, Activity2.class);
                startActivity(intent4);
                break;
            default:
                break;
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG2, "Активити3 запускается");

    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        Log.d(TAG2, "Активити3 получает фокус");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG2, "Активити3 приостановлено");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG2, "Активити3 остановлено");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG2, "Активити3 перезапускается");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG2, "Активити3 уничтожено");
    }
}
