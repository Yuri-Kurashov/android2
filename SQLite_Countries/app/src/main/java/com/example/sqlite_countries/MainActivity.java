package com.example.sqlite_countries;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnAll, btnFunction, btnPopUp, btnPopByReg, btnByRegUp, btnSort;
    EditText etFunction, etPopUp, etByRegUp;
    RadioGroup radioGroup;
    RadioButton rbtnName, rbtnPop, rbtnReg;

    final String TAG = "myLogs";

    String[] name = { "Китай", "США", "Бразилия", "Россия", "Япония", "Германия", "Египед",
            "Италия", "Франция", "Канада" };
    int[] people = { 1400, 311, 195, 142, 128, 82, 80, 60, 66, 35};
    String[] region = { "Азия", "Америка", "Америка", "Европа", "Азия", "Европа", "Африка",
            "Европа", "Европа", "Америка" };

    DBHelper dbHelper;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAll = findViewById(R.id.btnAll);
        btnFunction = findViewById(R.id.btnFunction);
        btnPopUp = findViewById(R.id.btnPopUp);
        btnPopByReg = findViewById(R.id.btnPopByReg);
        btnByRegUp = findViewById(R.id.btnByRegUp);
        btnSort = findViewById(R.id.btnSort);

        etFunction = findViewById(R.id.etFunction);
        etPopUp = findViewById(R.id.etPopUp);
        etByRegUp = findViewById(R.id.etByRegUp);

        radioGroup = findViewById(R.id.radioGroup);

        rbtnName = findViewById(R.id.rbtnName);
        rbtnPop = findViewById(R.id.rbtnPop);
        rbtnReg = findViewById(R.id.rbtnReg);

        btnAll.setOnClickListener(this);
        btnFunction.setOnClickListener(this);
        btnPopUp.setOnClickListener(this);
        btnPopByReg.setOnClickListener(this);
        btnByRegUp.setOnClickListener(this);
        btnSort.setOnClickListener(this);

        dbHelper = new DBHelper(this);
        db = dbHelper.getWritableDatabase();

        Cursor cursor = db.query("myTable", null, null,
                null, null,null, null);
        // проверка наличия данных в таблице
        if(cursor.getCount() == 0) {
            // если данных нет, то их заносим
            ContentValues contentValues = new ContentValues();
            for(int i = 0; i <10; i++) {
             contentValues.put("name", name[i]);
             contentValues.put("people", people[i]);
             contentValues.put("region", region[i]);
             Log.d(TAG, "id = " + db.insert("myTable", null, contentValues));
            }
            Log.d(TAG, "данные занесены в таблицу");
        } else {
            Log.d(TAG, "Данные есть в таблице");
        }
        cursor.close();
        dbHelper.close();
        onClick(btnAll);
    }

    @Override
    public void onClick(View v) {
        db = dbHelper.getWritableDatabase();

        String sFunction = etFunction.getText().toString();
        String sPopUp = etPopUp.getText().toString();
        String sByRegUp = etByRegUp.getText().toString();

        String[] columns = null;
        String selection = null;
        String[] selectionArgs = null;
        String groupBy = null;
        String having = null;
        String orderBy = null;

        Cursor cursor = null;

        switch (v.getId()) {
            case R.id.btnAll:
                Log.d(TAG, "----Все записи----");
                cursor = db.query("myTable", null, null, null, null,
                        null, null);
                break;
            case R.id.btnFunction:
                Log.d(TAG, "----Функция " + sFunction+"----");
                columns = new String[] {sFunction};
                cursor = db.query("myTable", columns, null, null, null,
                        null, null);
                break;
            case R.id.btnPopUp:
                Log.d(TAG, "----Население больше "+ sPopUp+"----");
                selection = "people > ?";
                selectionArgs = new String[] {sPopUp};
                cursor = db.query("myTable", null, selection, selectionArgs, null,
                        null, null, null);
            case R.id.btnPopByReg:
                Log.d(TAG, "----Население по региону----");
                columns = new String[]{"region", "SUM(people) as people"};
                groupBy = "region";
                cursor = db.query("myTable",columns, null, null, groupBy,
                        null, null, null);
                break;
            case R.id.btnByRegUp:
                Log.d(TAG, "---- Регионы с населением больше " + sByRegUp);
                columns = new String[] {"region", "SUM(people) as people"};
                groupBy = "region";
                having = "SUM(people) > " + sByRegUp;
                cursor = db.query("myTable", columns, null, null, groupBy,
                        having, null);
                break;
            case R.id.btnSort:
                switch (radioGroup.getCheckedRadioButtonId()) {
                    case R.id.rbtnName:
                        Log.d(TAG, "----Сортировка по наименованию----");
                        orderBy = "name";
                        break;
                    case R.id.rbtnPop:
                        Log.d(TAG, "----Сортировка по населению----");
                        orderBy = "people";
                        break;
                    case R.id.rbtnReg:
                        Log.d(TAG, "----Сортировка по регионам----");
                        orderBy = "region";
                        break;
                }
                cursor = db.query("myTable", null, null, null,null,
                        null, orderBy);
                break;
        }
        if(cursor != null) {
            Log.d(TAG, "Cursor != null");
            if(cursor.moveToFirst()) {
                String str;
                do {
                    str = "";
                    for(String cn : cursor.getColumnNames()) {
                        str = str.concat(cn + " = "
                                + cursor.getString(cursor.getColumnIndex(cn)) + "; ");
                    }
                    Log.d(TAG, str);
                } while (cursor.moveToNext());
            } else {
                Log.d(TAG, "Cursor does not move to first");
            }
            cursor.close();
        } else
            Log.d(TAG, "Cursor is null");

        dbHelper.close();
    }


    class DBHelper extends SQLiteOpenHelper {
        public DBHelper(@androidx.annotation.Nullable Context context) {
            super(context, "myDB", null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("create table myTable(" + "id integer primary key autoincrement," + "name text," + "people integer," +
                    "region text" +");");

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }
}
