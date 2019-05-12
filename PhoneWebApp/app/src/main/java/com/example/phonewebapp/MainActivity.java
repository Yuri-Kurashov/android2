package com.example.phonewebapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnWep, btnPhone;
    EditText etWeb, etPhone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPhone = findViewById(R.id.btnPhone);
        btnWep = findViewById(R.id.btnWeb);
        etPhone = findViewById(R.id.etPhone);
        etWeb = findViewById(R.id.etWeb);

        btnWep.setOnClickListener(this);
        btnPhone.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;

        String s1 = etWeb.getText().toString();
        String s2 = etPhone.getText().toString();

        switch (v.getId()) {
            case R.id.btnPhone:
                if (s2.matches("")) {
                    Toast toast = Toast.makeText(MainActivity.this, "Put phone number", Toast.LENGTH_LONG);
                    toast.show();
                    return;
                } else {
                    intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + etPhone.getText().toString()));
                    startActivity(intent);
                    break;
                }
            case R.id.btnWeb:
                if(s1.matches("")) {
                    Toast toast = Toast.makeText(MainActivity.this, "Put web", Toast.LENGTH_LONG);
                    toast.show();
                    break;
                } else {
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://" + etWeb.getText().toString()));
                    startActivity(intent);
                    break;
                }

        }


    }
}
