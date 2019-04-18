package com.example.myapplication6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button plusBtn;
    Button minBtn;
    Button multBtn;
    Button divBtn;

    EditText editText1;
    EditText editText2;

    TextView textView;

    String oper = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        plusBtn = findViewById(R.id.button1);
        minBtn = findViewById(R.id.button2);
        multBtn = findViewById(R.id.button3);
        divBtn = findViewById(R.id.button4);

        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);

        textView = findViewById(R.id.textView);

        plusBtn.setOnClickListener(this);
        minBtn.setOnClickListener(this);
        multBtn.setOnClickListener(this);
        divBtn.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {

        float num1 = 0;
        float num2 = 0;
        float result = 0;

        if (TextUtils.isEmpty(editText1.getText().toString())
                       || (TextUtils.isEmpty(editText2.getText().toString()))) {
            return;
        }

        num1 = Float.parseFloat(editText1.getText().toString());
        num2 = Float.parseFloat(editText2.getText().toString());



        switch (view.getId()){
            case R.id.button1:
                oper = "+";
                result = num1 + num2;
                break;
            case R.id.button2:
                oper = "-";
                result = num1 - num2;
                break;
            case R.id.button3:
                oper = "*";
                result = num1 * num2;
                break;
            case R.id.button4:
                oper = "/";
                result = num1 / num2;
                break;

        }

    }
}
