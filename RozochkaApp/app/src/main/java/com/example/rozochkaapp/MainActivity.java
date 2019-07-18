package com.example.rozochkaapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button button, button2;
    ImageView imageView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        button.setOnClickListener(this);
        button2.setOnClickListener(this);

        imageView = findViewById(R.id.imageView2);
        imageView.setImageResource(R.drawable.ic_launcher_foreground);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.button:
                Toast toast = Toast.makeText(this, "Привет! Я - Розочка", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.TOP, 0, 200);
                toast.show();
                imageView.setImageResource(R.drawable.rozochka);
                break;
            case R.id.button2:
                imageView.setImageResource(R.drawable.ic_launcher_foreground);
                break;
        }





    }
}
