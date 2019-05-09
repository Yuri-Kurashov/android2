package com.example.extrasapp;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editText, editText2;
    Button submitBtn, getResBtn;
    TextView textView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        editText2 = findViewById(R.id.editText2);
        submitBtn = findViewById(R.id.submitBtn);
        getResBtn = findViewById(R.id.getResBtn);
        textView3 = findViewById(R.id.textView3);

        editText.setInputType(InputType.TYPE_TEXT_FLAG_CAP_WORDS);

        submitBtn.setOnClickListener(this);
        getResBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.submitBtn:

                String s1 = editText.getText().toString();
                String s2 = editText2.getText().toString();


                if(s1.matches("") && s2.matches("")) {
                    Toast toast = Toast.makeText(MainActivity.this, "Put your name and id", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.BOTTOM, 0, 0);
                    toast.show();
                    return;
                }
                else if(s1.matches("")) {
                    Toast toast = Toast.makeText(MainActivity.this, "Put your name", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.BOTTOM, 0, 0);
                    toast.show();
                    return;
                }
                else if(s2.matches("")){
                    Toast toast = Toast.makeText(MainActivity.this, "Put your id", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.BOTTOM, 0, 0);
                    toast.show();
                    return;
                }
                else {
                   Intent intent = new Intent(this, ViewActivity.class);
                   intent.putExtra("name", editText.getText().toString());
                   intent.putExtra("id", editText2.getText().toString());
                   startActivity(intent);
                }
                break;
            case R.id.getResBtn:
                Intent intent2 = new Intent(this, ResultActivity.class);
                startActivityForResult(intent2, 1);
                break;
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(data == null) {
            return;
        } String result = data.getStringExtra("result");
        textView3.setText("Your result is " + result);
    }
}
