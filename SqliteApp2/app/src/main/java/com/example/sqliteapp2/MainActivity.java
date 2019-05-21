package com.example.sqliteapp2;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.function.ObjDoubleConsumer;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etName, etEmail;
    DBHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        (findViewById(R.id.btnAdd)).setOnClickListener(this);
        (findViewById(R.id.btnRead)).setOnClickListener(this);
        (findViewById(R.id.btnDelete)).setOnClickListener(this);
        Log.d("myLogs", "find btn & set onclick");

        etName = findViewById(R.id.etName);

        Log.d("myLogs", "find etName");
        etName.setInputType(InputType.TYPE_TEXT_FLAG_CAP_WORDS);
        Log.d("myLogs", "set inputType");
        etEmail = findViewById(R.id.etEmail);
        Log.d("myLogs", "find etEmail");

        dbHelper = new DBHelper(this);
        Log.d("myLogs", "find dbHelper");

    }


    @Override
    public void onClick(View v) {

        String name = etName.getText().toString();
        String email = etEmail.getText().toString();

        SQLiteDatabase database = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();


        switch (v.getId()) {
            case R.id.btnAdd:
                if (name.matches("") || email.matches("")) {
                    Toast toast = Toast.makeText(MainActivity.this, "Put name & email", Toast.LENGTH_LONG);
                    toast.show();
                    return;
                } else {

                    contentValues.put(DBHelper.KEY_NAME, name);
                    contentValues.put(DBHelper.KEY_EMAIL, email);

                    database.insert(DBHelper.TABLE_NAME, null, contentValues);

                    etName.setText("");
                    etEmail.setText("");
                }
                break;
            case R.id.btnRead:
                Cursor cursor = database.query(DBHelper.TABLE_NAME, null, null, null,
                        null, null, null);
                if(cursor.moveToFirst()) {
                    int idIndex = cursor.getColumnIndex(DBHelper.KEY_ID);
                    int nameIndex = cursor.getColumnIndex(DBHelper.KEY_NAME);
                    int emailIndex = cursor.getColumnIndex(DBHelper.KEY_EMAIL);

                    do {
                        Log.d("myLogs", "id = " + cursor.getInt(idIndex) + " name = " + cursor.getString(nameIndex) +
                                " email = " + cursor.getString(emailIndex));

                    } while (cursor.moveToNext());

                } else {
                    Log.d("myLogs", "row = 0");
                }
                cursor.close();
                break;
            case R.id.btnDelete:
                database.delete(DBHelper.TABLE_NAME, null, null);
                break;
        }
        dbHelper.close();
    }
}