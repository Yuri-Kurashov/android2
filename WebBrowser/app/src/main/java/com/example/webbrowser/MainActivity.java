package com.example.webbrowser;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    EditText etWeb;
    Button btnWeb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etWeb = findViewById(R.id.etWeb);

        (findViewById(R.id.btnWeb)).setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
//        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://"+etWeb.getText().toString()));
//        startActivity(intent);

        String s = etWeb.getText().toString();
        if(s.matches("")) {
            Toast toast = Toast.makeText(MainActivity.this, "Put URL address", Toast.LENGTH_LONG);
            toast.show();
        } else {

            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://" + etWeb.getText().toString())));
        }



        }


    }
