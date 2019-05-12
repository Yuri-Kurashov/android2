package com.example.testingintenetapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RecipActivity extends AppCompatActivity {

    TextView tvRecip;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recip);

        tvRecip = findViewById(R.id.tvRecip);

        Intent intent = getIntent();
        String info = intent.getStringExtra("sending");
        tvRecip.setText(info);


//        Intent intent1 = getIntent();
//        String info = intent1.getStringExtra("sending");
//        tvRecip.setText(info);




    }


}
