package com.example.sqlite_app;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "myDataBase";
    public static final String TABLE_NAME = "contacts";
    public static final String KEY_NAME = "name";
    public static final String KEY_EMAIL = "email";
    public static final String KEY_ID = "_id";




    public DBHelper(@androidx.annotation.Nullable Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME
                        + "("
                        + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                        + KEY_NAME +" TEXT, "
                        + KEY_EMAIL +" TEXT"
                        + ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS cotacts");
        onCreate(db);

    }
}

