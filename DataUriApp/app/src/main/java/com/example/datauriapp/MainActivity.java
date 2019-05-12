package com.example.datauriapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnMap, btnWeb, btnCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMap = findViewById(R.id.btnMap);
        btnWeb = findViewById(R.id.btnWeb);
        btnCall = findViewById(R.id.btnCall);

        btnMap.setOnClickListener(this);
        btnWeb.setOnClickListener(this);
        btnCall.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;

        switch (v.getId()) {
            case R.id.btnWeb:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://yandex.ru"));
                startActivity(intent);
                break;
            case R.id.btnMap:
                intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo: -0,45609946, -90,26607513"));
                startActivity(intent);
                break;
            case R.id.btnCall:
                intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:89117907243"));
                startActivity(intent);
                break;

        }

    }
}
