package com.example.intentactapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DubleActivity extends AppCompatActivity {

    Button btnToMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_duble);

        btnToMain = findViewById(R.id.btnToMain);

        btnToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               Intent intent1;

               intent1 = new Intent(DubleActivity.this, MainActivity.class);
               startActivity(intent1);
               }


        });
    }
}
