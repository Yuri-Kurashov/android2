package com.example.sqliteapp;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText etName, etEmail, etId;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        (findViewById(R.id.btnAdd)).setOnClickListener(this);
        (findViewById(R.id.btnRead)).setOnClickListener(this);
        (findViewById(R.id.btnClear)).setOnClickListener(this);
        (findViewById(R.id.btnUpdate)).setOnClickListener(this);
        (findViewById(R.id.btnDelete)).setOnClickListener(this);

        etName = findViewById(R.id.etName);
        etName.setInputType(InputType.TYPE_TEXT_FLAG_CAP_WORDS);
        etEmail = findViewById(R.id.etEmail);
        etId = findViewById(R.id.etId);

        dbHelper = new DBHelper(this);


    }

    @Override
    public void onClick(View v) {


        String name = etName.getText().toString();
        String email = etEmail.getText().toString();
        String id = etId.getText().toString();

        SQLiteDatabase database = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();




        switch (v.getId()) {
            case R.id.btnAdd:
                contentValues.put(dbHelper.KEY_NAME, name);
                contentValues.put(dbHelper.KEY_EMAIL, email);

                database.insert(DBHelper.TABLE_CONTACTS, null, contentValues);
                etName.setText("");
                etEmail.setText("");


                break;
            case R.id.btnRead:
                Cursor cursor = database.query(DBHelper.TABLE_CONTACTS,null, null,
                        null, null, null, null);
                if(cursor.moveToFirst()) {
                    int idIndex = cursor.getColumnIndex(DBHelper.KEY_ID);
                    int nameIndex = cursor.getColumnIndex(DBHelper.KEY_NAME);
                    int emailIndex = cursor.getColumnIndex(DBHelper.KEY_EMAIL);
                    do {
                        Log.d("myLogs", "ID = " + cursor.getInt(idIndex) +
                                " Name = " + cursor.getString(nameIndex) + " Email = " +
                                cursor.getString(emailIndex));
                    } while (cursor.moveToNext());

                } else {
                    Log.d("myLogs", "0 rows");
                }
                cursor.close();
                break;
            case R.id.btnClear:
                database.delete(DBHelper.TABLE_CONTACTS,null, null);
                break;
            case R.id.btnUpdate:
                if(TextUtils.isEmpty(name)){
//                if(name.equalsIgnoreCase(""))
                    break;
                }
                contentValues.put(DBHelper.KEY_NAME, name);
                contentValues.put(DBHelper.KEY_EMAIL, email);
                int countUpdate = database.update(DBHelper.TABLE_CONTACTS, contentValues,
                        DBHelper.KEY_NAME + "= ?", new String[] {name});
                Log.d("myLogs", "Update rows count = " + countUpdate);

                break;
            case R.id.btnDelete:
                if(name.equalsIgnoreCase("")) {
                    break;
                }
                int delCount = database.delete(DBHelper.TABLE_CONTACTS,
                        DBHelper.KEY_NAME + "= ?", new String[] {name});
                Log.d("myLogs", "Delete rows count " + delCount);
                break;
        }
        dbHelper.close();
    }
}
