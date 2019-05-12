package com.example.testingintenetapp;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    final int REQUEST_CODE = 1;

    Button btnSend, btnAsk, btnCall, btnWeb;
    TextView tvGetInfo;
    EditText etSendInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSend = findViewById(R.id.btnSend);
        btnAsk = findViewById(R.id.btnAsk);
        btnCall = findViewById(R.id.btnCall);
        btnWeb = findViewById(R.id.btnWeb);
        tvGetInfo = findViewById(R.id.tvGetInfo);
        etSendInfo = findViewById(R.id.etSendInfo);
        etSendInfo.setInputType(InputType.TYPE_TEXT_FLAG_CAP_WORDS);

        btnAsk.setOnClickListener(this);
        btnSend.setOnClickListener(this);
        btnCall.setOnClickListener(this);
        btnWeb.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        String s = etSendInfo.getText().toString();


        switch (v.getId()) {
            case R.id.btnSend:
                if(s.matches("")) {
                    Toast toast = Toast.makeText(MainActivity.this, "Put information", Toast.LENGTH_LONG);
                    toast.show();
                    return;
                } else {
                    Intent intent1 = new Intent(MainActivity.this, RecipActivity.class);
                    intent1.putExtra("sending", etSendInfo.getText().toString());
                    startActivity(intent1);
                    break;
                }
            case R.id.btnAsk:
                Intent intent2 = new Intent(MainActivity.this, ResponseActivity.class);
                startActivityForResult(intent2, REQUEST_CODE);
                break;
            case R.id.btnCall:
                Intent intent3 = new Intent(Intent.ACTION_DIAL);
                intent3.setData(Uri.parse("tel: 89117907243"));
                startActivity(intent3);
            case R.id.btnWeb:
                Intent intent4 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://yandex.ru"));
                startActivity(intent4);

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(data == null) {
            return;
        }
        String info = data.getStringExtra("asking");
        tvGetInfo.setText(info);

    }



}
