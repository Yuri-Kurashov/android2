package com.example.transactionsqlite;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView textView;
    Button button;

    public static final String DATABASE_NAME = "myDatabase";
    public static final String TABLE_NAME = "myTable";
    SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        button.setOnClickListener(this);

        textView = findViewById(R.id.textView);
        initDB();

    }

    private void initDB() {
        sqLiteDatabase = this.openOrCreateDatabase(DATABASE_NAME, MODE_PRIVATE, null);
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS  "
                + TABLE_NAME + "(FirstNumber INT, SecondNumber INT, Result INT);");
        sqLiteDatabase.delete(TABLE_NAME, null, null);
    }

    @Override
    public void onClick(View v) {
        sqLiteDatabase.delete(TABLE_NAME, null, null);
        Long startTime = System.currentTimeMillis();
        insertRecords();
        Long diff = System.currentTimeMillis() - startTime;


    }

    private void insertRecords() {

        sqLiteDatabase.beginTransaction();
        try {
            for(int i = 0; i < 1000; i++) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("FirstNumber", i);
                contentValues.put("SecondNumber", i);
                contentValues.put("Result", i*i);
                sqLiteDatabase.insert(TABLE_NAME, null, contentValues);
            }
            sqLiteDatabase.setTransactionSuccessful();
        } finally {
            sqLiteDatabase.endTransaction();
        }
    }

    protected void onDestroy() {
        sqLiteDatabase.close();
        super.onDestroy();
    }
}
