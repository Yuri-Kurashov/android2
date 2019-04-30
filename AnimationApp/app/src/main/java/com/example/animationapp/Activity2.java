package com.example.animationapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "myLogs";
    private static final String TAG2 = "lifeCicle";

    final int OPT_MENU_A1 = 1;
    final int OPT_MENU_A3 = 3;


    Button chageActbtn2, button5;
    TextView tVact2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG2, "Активити2 создано");


        setContentView(R.layout.activity_2);

        Log.d(TAG, "Finded view in activity 2");

        tVact2 = findViewById(R.id.textView2);
        chageActbtn2 = findViewById(R.id.button2);
        button5 = findViewById(R.id.button5);
        chageActbtn2.setOnClickListener(this);
        button5.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.button2:
                Intent intent2 = new Intent(this, MainActivity.class);
                startActivity(intent2);
                break;
            case R.id.button5:
                Intent intent5 = new Intent(this, Activity3.class);
                startActivity(intent5);
                break;
            default:
                break;
        }



    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG2, "Активити2 запускается");

    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        Log.d(TAG2, "Активити2 получает фокус");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG2, "Активити2 приостановлено");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG2, "Активити2 остановлено");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG2, "Активити2 перезапускается");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG2, "Активити2 уничтожено");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        menu.add(1, OPT_MENU_A1, 1, "Activity 1");
        menu.add(1, OPT_MENU_A3, 1, "Activity 3");

        return super.onCreateOptionsMenu(menu);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case OPT_MENU_A1:
                Intent intent3 = new Intent(this, MainActivity.class);
                startActivity(intent3);
                break;
            case OPT_MENU_A3:
                Intent intent2 = new Intent(this, Activity3.class);
                startActivity(intent2);
                break;
        }


        return super.onOptionsItemSelected(item);

    }
}
