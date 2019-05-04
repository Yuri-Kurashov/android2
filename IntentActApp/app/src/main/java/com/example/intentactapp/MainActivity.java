package com.example.intentactapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "myLogs";

    Button buttonTime, buttonDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        buttonTime = findViewById(R.id.buttonTime);
        buttonDate = findViewById(R.id.buttonDate);
        Log.d(TAG, "Buttons were found");

        buttonTime.setOnClickListener(this);
        buttonDate.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        Intent intent;

        switch (v.getId()) {
            case R.id.buttonTime:
                intent = new Intent("info.fandroid.action.time");
                startActivity(intent);

                Log.d(TAG, "Time button was pussed");
                Toast toast1 = Toast.makeText(this, "Current time", Toast.LENGTH_LONG);
                toast1.setGravity(Gravity.BOTTOM, 0, 0);
                toast1.show();
                break;
            case (R.id.buttonDate):
                intent = new Intent("info.fandriod.action.date");
                startActivity(intent);

                Log.d(TAG, "Date button was pussed");
                Toast toast2 = Toast.makeText(this, "Current Date", Toast.LENGTH_LONG);
                toast2.setGravity(Gravity.BOTTOM, 0, 0);
                toast2.show();
            break;
        }

    }
}
