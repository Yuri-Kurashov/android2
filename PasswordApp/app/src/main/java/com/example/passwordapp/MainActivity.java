package com.example.passwordapp;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnOk, btnSubmit;
    EditText etLogin, etPassword, etRegLogin, etRegPassword1, etRegPassword2;
    SharedPreferences shPref;
    final String SAVE_PASSWORD = "save_password";
    final String SAVE_LOGIN = "save_login";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnOk = findViewById(R.id.btnOk);
        btnSubmit = findViewById(R.id.btnSubmit);
        etLogin = findViewById(R.id.etLogin);
        etRegLogin = findViewById(R.id.etRegLogin);
        etPassword = findViewById(R.id.etPassword);
        etRegPassword1 = findViewById(R.id.etRegPassword1);
        etRegPassword2 = findViewById(R.id.etRegPassword2);

        btnOk.setOnClickListener(this);
        btnSubmit.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btnOk:
                loadData();
               break;
            case R.id.btnSubmit:
                saveData();
                break;
        }
    }

    private void saveData() {

        String s1 = etRegPassword1.getText().toString();
        String s2 = etRegPassword2.getText().toString();
        String s3 = etRegLogin.getText().toString();

        if(s3.matches("")) {
            (Toast.makeText(MainActivity.this, "Put new login", Toast.LENGTH_LONG)).show();
            return;
        } else if(s1.matches("")) {
            (Toast.makeText(MainActivity.this, "Put new password", Toast.LENGTH_LONG)).show();
            return;
        } else if(s2.matches("")) {
            (Toast.makeText(MainActivity.this, "Put new password again", Toast.LENGTH_LONG)).show();
            return;
        } else if(s1.matches(s2)) {
            shPref = getPreferences(MODE_PRIVATE);
            SharedPreferences.Editor editor = shPref.edit();
            editor.putString(SAVE_LOGIN, etRegLogin.getText().toString());
            editor.putString(SAVE_PASSWORD, etRegPassword1.getText().toString());
            editor.commit();
        }
        else {
            (Toast.makeText(MainActivity.this, "Passwords do not match", Toast.LENGTH_LONG)).show();
            return;
        }

    }

    private void loadData() {
        shPref = getPreferences(MODE_PRIVATE);
        String loadLogin = shPref.getString(SAVE_LOGIN, "");
        String loadPassword = shPref.getString(SAVE_PASSWORD,"");
        String login = etLogin.getText().toString();
        String password = etPassword.getText().toString();
        if(login.matches(loadLogin) && password.matches(loadPassword)) {
            (Toast.makeText(MainActivity.this, "OK!!", Toast.LENGTH_LONG)).show();
        } else {
            (Toast.makeText(MainActivity.this, "Login or Password - wrong", Toast.LENGTH_LONG)).show();
            return;
        }

    }

}
