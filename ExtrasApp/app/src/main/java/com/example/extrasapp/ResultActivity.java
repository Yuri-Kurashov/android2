package com.example.extrasapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ResultActivity extends AppCompatActivity implements View.OnClickListener {

    Button okBtn;
    EditText edtexResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        okBtn = findViewById(R.id.okBtn);
        edtexResult = findViewById(R.id.edtexResult);

        okBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        Intent intent2 = new Intent();
        intent2.putExtra("result", edtexResult.getText().toString());
        setResult(RESULT_OK, intent2);
        finish();

    }
}
