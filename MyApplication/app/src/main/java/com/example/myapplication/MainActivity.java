package com.example.myapplication;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "myLogs";


    EditText etInfo;
    Button btnSaved, btnLoad;

    final String SAVED_TEXT = "saved_text";
    SharedPreferences sPref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSaved = findViewById(R.id.btnSave);
        btnLoad = findViewById(R.id.btnLoad);
        etInfo = findViewById(R.id.etInfo);

        Log.d(TAG, "find views - ok");

        btnSaved.setOnClickListener(this);
        btnLoad.setOnClickListener(this);

        Log.d(TAG, "Set listener - ok");

        loadText();

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btnSave:
                saveText();
                break;
            case R.id.btnLoad:
                loadText();
                break;
            default:
                break;
        }

    }

    private void loadText() {

        sPref = getPreferences(MODE_PRIVATE);
        String saved_text = sPref.getString(SAVED_TEXT, "");
        if (saved_text.matches("")) {
            (Toast.makeText(MainActivity.this, "No information for loading", Toast.LENGTH_LONG)).show();
            return;
        } else {
            etInfo.setText(saved_text);
            (Toast.makeText(MainActivity.this, "Information was loaded", Toast.LENGTH_LONG)).show();
        }

    }

    private void saveText() {
        String s = etInfo.getText().toString();
        if(s.matches("")) {
            (Toast.makeText(MainActivity.this, "Put information", Toast.LENGTH_LONG)).show();
            return;
        } else {
            sPref = getPreferences(MODE_PRIVATE);
            SharedPreferences.Editor shPrefEd = sPref.edit();
            shPrefEd.putString(SAVED_TEXT, etInfo.getText().toString());
            shPrefEd.commit();
            (Toast.makeText(MainActivity.this, "Information was saved", Toast.LENGTH_LONG)).show();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        sPref = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor shPrefEd = sPref.edit();
        shPrefEd.putString(SAVED_TEXT, etInfo.getText().toString());
        shPrefEd.commit();


    }
}
