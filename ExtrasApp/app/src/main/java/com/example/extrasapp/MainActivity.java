package com.example.extrasapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editText, editText2;
    Button submitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        editText2 = findViewById(R.id.editText2);
        submitBtn = findViewById(R.id.submitBtn);

        editText.setInputType(InputType.TYPE_TEXT_FLAG_CAP_WORDS);

        submitBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {


        Intent intent = new Intent(this, ViewActivity.class);
        intent.putExtra("name", editText.getText().toString());
        intent.putExtra("id", editText2.getText().toString());
        startActivity(intent);




    }
}
