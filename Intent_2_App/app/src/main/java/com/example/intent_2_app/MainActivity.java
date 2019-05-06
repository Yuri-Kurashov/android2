package com.example.intent_2_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnTime, btnDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnTime = findViewById(R.id.btnTime);
        btnDate = findViewById(R.id.btnDate);

        btnTime.setOnClickListener(this);
        btnDate.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        Intent intent;

        switch (v.getId()) {
            case R.id.btnTime:
                intent = new Intent("info_fandroid_action_time");
                startActivity(intent);
                break;
            case R.id.btnDate:
                intent = new Intent("info_fandroid_action_date");
                startActivity(intent);
                break;
        }

    }
}
