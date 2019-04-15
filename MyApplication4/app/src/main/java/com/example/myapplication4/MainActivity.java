package com.example.myapplication4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    RadioGroup radioGroup;
    RadioButton leftRbtn;
    RadioButton centerRbtn;
    RadioButton rightRbtn;
    Button creatBtn;
    Button cleanBtn;
    EditText editText;
    LinearLayout llmain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        radioGroup = findViewById(R.id.radioGroup);
        leftRbtn = findViewById(R.id.leftRbtn);
        centerRbtn = findViewById(R.id.centerRbtn);
        rightRbtn = findViewById(R.id.rightRbtn);
        editText = findViewById(R.id.editText);
        creatBtn = findViewById(R.id.button1);
        cleanBtn = findViewById(R.id.button2);
        llmain = findViewById(R.id.linearLayout);

        creatBtn.setOnClickListener(this);
        cleanBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button1:
                LinearLayout.LayoutParams lparams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                int btnGravity = Gravity.LEFT;
                switch (radioGroup.getCheckedRadioButtonId()) {
                    case R.id.leftRbtn:
                        btnGravity = Gravity.LEFT;
                        break;
                    case R.id.centerRbtn:
                        btnGravity = Gravity.CENTER_HORIZONTAL;
                        break;
                    case R.id.rightRbtn:
                        btnGravity = Gravity.RIGHT;
                        break;
                }
                lparams.gravity = btnGravity;
                Button btnNew = new Button(this);
                btnNew.setText(editText.getText().toString());
                llmain.addView(btnNew, lparams);
                break;

            case R.id.button2:
                llmain.removeAllViews();
                Toast.makeText(MainActivity.this, "Deleted", Toast.LENGTH_SHORT).show();
                break;

        }

    }
}
