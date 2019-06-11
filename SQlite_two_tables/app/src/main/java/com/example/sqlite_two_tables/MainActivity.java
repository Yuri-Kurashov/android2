package com.example.sqlite_two_tables;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    final String TAG = "myLogs";
    int[] position_id = {1, 2, 3, 4};
    String[] position_name = {"Директор", "Программист", "Бухгалтер", "HR"};
    int[] position_salary = {100000, 90000, 50000, 70000};

    String[] people_name = {"Сергей", "Петр", "Юлия", "Наталия", "Руслан", "Галина", "Лера", "Василий"};
    int[] people_posid = {2, 3, 2, 2, 3, 1, 2, 4};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    class DbHelper extends SQLiteOpenHelper {
        public DbHelper(@androidx.annotation.Nullable Context context) {
            super(context, "myDb", null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            Log.d(TAG, "----Table onCreate----");
            ContentValues contentValues = new ContentValues();
            db.execSQL("create table position ("
                    + "id integer primary key, "
                    + "name text, "
                    + "salary integer"
                    + ");");
            for(int i = 0; i < position_id.length; i++) {
                contentValues.clear();
                contentValues.put("id", position_id[i]);
                contentValues.put("name", position_name[i]);
                contentValues.put("salary", position_salary[i]);
                db.insert("position", null, contentValues);
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }
}
