package com.example.sharedpref;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnSave, btnLoad;
    EditText editText;
    SharedPreferences sharedPreferences;

    final String SAVE_TEXT = "Save text";
    final String TAG = "myLogs";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSave = findViewById(R.id.btnSave);
        btnLoad = findViewById(R.id.btnLoad);
        editText = findViewById(R.id.editText);

        btnSave.setOnClickListener(this);
        btnLoad.setOnClickListener(this);




    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btnSave:
                saveText();
                editText.setText("");
                break;
            case R.id.btnLoad:
                loadText();
                break;
        }

    }

    private void loadText() {
        sharedPreferences = getPreferences(MODE_PRIVATE);
        String savedText = sharedPreferences.getString(SAVE_TEXT, "");
        editText.setText(savedText);
        Toast toast = Toast.makeText(MainActivity.this, "Text is loaded", Toast.LENGTH_LONG);
        toast.show();


    }

    private void saveText() {
        sharedPreferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(SAVE_TEXT, editText.getText().toString());
        editor.commit();
        Log.d(TAG, "Text is saved");
        Toast toast = Toast.makeText(MainActivity.this, "Text is saved", Toast.LENGTH_LONG);
        toast.setGravity(Gravity.BOTTOM, 0, 0);
        toast.show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        saveText();
    }
}
