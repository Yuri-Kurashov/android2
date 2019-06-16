package com.example.sqlite_app;

import android.content.ContentValues;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnAdd, btnRead, btnClean;
    EditText etName, etEmail;
    DBHelper dbHelper;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAdd = findViewById(R.id.btnAdd);
        btnRead = findViewById(R.id.btnRead);
        btnClean = findViewById(R.id.btnClean);
        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);

        btnAdd.setOnClickListener(this);
        btnRead.setOnClickListener(this);
        btnClean.setOnClickListener(this);

        dbHelper = new DBHelper(this);
    }

    @Override
    public void onClick(View v) {
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        String name = etName.getText().toString();
        String email = etEmail.getText().toString();


        switch (v.getId()) {
            case R.id.btnAdd:
                contentValues.put(DBHelper.KEY_NAME, name);
                contentValues.put(DBHelper.KEY_EMAIL, email);
                sqLiteDatabase.insert(DBHelper.TABLE_NAME, null, contentValues);
                break;

            case R.id.btnRead:
                Cursor cursor = sqLiteDatabase.query(DBHelper.TABLE_NAME, null, null,
                        null, null, null, null);
                if(cursor.moveToNext()) {
                    int idIndex = cursor.getColumnIndex(DBHelper.KEY_ID);
                    int nameIndex = cursor.getColumnIndex(DBHelper.KEY_NAME);
                    int emailIndex = cursor.getColumnIndex(DBHelper.KEY_EMAIL);
                     do {
                         Log.d("myLogs", "ID = " + cursor.getInt(idIndex)
                                              + " Name = " + cursor.getString(nameIndex)
                                              + " Email = " + cursor.getString(emailIndex));

                     } while (cursor.moveToNext());

                } else Log.d("myLogs", "0 rows");
                cursor.close();
                break;

            case R.id.btnClean:
                sqLiteDatabase.delete(DBHelper.TABLE_NAME, null, null);
                break;
        }
        dbHelper.close();
    }
}
