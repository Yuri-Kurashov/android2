package com.example.myapplication6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "myLogs";

    Button plusBtn, minPtn, multBtn, divBtn;
    EditText editText1, editText2;
    TextView textView;


    final int MENU_RESET_ID = 1;
    final int MENU_QUIT_ID = 2;



//    Button plusBtn;
//    Button minBtn;
//    Button multBtn;
//    Button divBtn;
//
//    EditText editText1;
//    EditText editText2;
//
//    TextView textView;
//
//    String oper = "";
//
//    final int MENU_RESET_ID = 1;
//    final int MENU_QUIT_ID = 2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "Найдены элементы");

        plusBtn = findViewById(R.id.button1);
        minPtn= findViewById(R.id.button2);
        multBtn = findViewById(R.id.button3);
        divBtn = findViewById(R.id.button4);

        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);

        textView = findViewById(R.id.textView);

        plusBtn.setOnClickListener(this);
        minPtn.setOnClickListener(this);
        multBtn.setOnClickListener(this);
        divBtn.setOnClickListener(this);




//        plusBtn = findViewById(R.id.button1);
//        minBtn = findViewById(R.id.button2);
//        multBtn = findViewById(R.id.button3);
//        divBtn = findViewById(R.id.button4);
//
//        editText1 = findViewById(R.id.editText1);
//        editText2 = findViewById(R.id.editText2);
//
//        textView = findViewById(R.id.textView);
//
//
//        plusBtn.setOnClickListener(this);
//        minBtn.setOnClickListener(this);
//        multBtn.setOnClickListener(this);
//        divBtn.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        float num1 = 0;
        float num2 = 0;
        float result = 0;
        String oper = "";

        if (TextUtils.isEmpty(editText1.getText().toString())
            || (TextUtils.isEmpty(editText2.getText().toString()))) {
            return;
        }
        num1 = Float.parseFloat(editText1.getText().toString());
        num2 = Float.parseFloat(editText2.getText().toString());

        switch (v.getId()) {
            case R.id.button1:
                result = num1 + num2;
                oper = "+";
                break;
            case R.id.button2:
                result = num1 - num2;
                oper = "-";
                break;
            case R.id.button3:
                result = num1 * num2;
                oper = "*";
                break;
            case R.id.button4:
                if (num2 == 0) {
                    Toast toast = Toast.makeText(MainActivity.this, "На ноль делить нельзя", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                    textView.setText("");
                    return;
                }
                else {
                    result = num1 / num2;
                    oper = "/";
                    break;
                }
        }

        textView.setText(num1+""+oper+""+num2+"="+result);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        menu.add(0,MENU_RESET_ID,0,"Reset");
        menu.add(0,MENU_QUIT_ID,0,"Quit");


        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case MENU_RESET_ID:
                textView.setText("");
                editText1.setText("");
                editText2.setText("");
                break;
            case MENU_QUIT_ID:
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    //    @Override
//    public void onClick(View view) {
//
//        float num1 = 0;
//        float num2 = 0;
//        float result = 0;
//
//        if (TextUtils.isEmpty(editText1.getText().toString())
//                       || (TextUtils.isEmpty(editText2.getText().toString()))) {
//            return;
//        }
//
//        num1 = Float.parseFloat(editText1.getText().toString());
//        num2 = Float.parseFloat(editText2.getText().toString());
//
//
//
//        switch (view.getId()){
//            case R.id.button1:
//                oper = "+";
//                result = num1 + num2;
//                break;
//            case R.id.button2:
//                oper = "-";
//                result = num1 - num2;
//                break;
//            case R.id.button3:
//                oper = "*";
//                result = num1 * num2;
//                break;
//            case R.id.button4:
//                oper = "/";
//                if (num2 == 0 || num2 == 0.0) {
//                    Toast toast = Toast.makeText(MainActivity.this, "Делить на ноль нельзя", Toast.LENGTH_SHORT);
//                    toast.setGravity(Gravity.CENTER, 0, 0 );
//                    toast.show();
//                    break;
//                }
//                else {
//                    result = num1 / num2;
//                    break;
//                }
//
//
//        }
//        textView.setText(num1 + "" + oper + "" + num2 + "=" + result);
//
//
//    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//
//        menu.add(0, MENU_RESET_ID, 0, "Reset");
//        menu.add(0, MENU_QUIT_ID, 0, "Quit");
//
//        return super.onCreateOptionsMenu(menu);
//
//
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//
//        switch (item.getItemId()) {
//            case MENU_RESET_ID :
//                editText1.setText("");
//                editText2.setText("");
//                textView.setText("");
//                break;
//            case MENU_QUIT_ID:
//                finish();
//                break;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
}
