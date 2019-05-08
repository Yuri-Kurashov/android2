package com.example.extrasapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ViewActivity extends AppCompatActivity {

    TextView textViewж;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        textViewж = findViewById(R.id.textView);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");

        textViewж.setText(name);

//        Intent intent = getIntent();
//        String name = intent.getStringExtra("name");
//        textViewж.setText(name);
    }
}
