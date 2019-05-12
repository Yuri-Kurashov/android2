package com.example.testingintenetapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ResponseActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnSendResponse;
    EditText etSetResponse;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_response);

        btnSendResponse = findViewById(R.id.btnSendResponse);
        btnSendResponse.setOnClickListener(this);

        etSetResponse = findViewById(R.id.etSetResponse);




    }

    @Override
    public void onClick(View v) {

        Intent intent = new Intent();
        intent.putExtra("asking", etSetResponse.getText().toString());
        setResult(RESULT_OK, intent);
        finish();


//        Intent intent = new Intent();
//        intent.putExtra("asking", etSetResponse.getText().toString());
//        setResult(RESULT_OK, intent);
//        finish();
    }
}
