package com.example.intent_2_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class InfoActivity extends AppCompatActivity {

    TextView textView2;
    final int MENU_TO_ACT_MAIN = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        textView2 = findViewById(R.id.textView2);

        Intent intent = getIntent();

        String action = intent.getAction();
        String format = "", textInfo = "";

        if (action.equals("info_fandroid_action_time")) {
            format = "hh:mm:ss";
            textInfo = "Time: ";
            Toast toast = Toast.makeText(InfoActivity.this, "Current time", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.BOTTOM, 0, 0 );
            toast.show();
        }
        else if (action.equals("info_fandroid_action_date")) {
            format = "dd.mm.yyyy.";
            textInfo = "Date: ";
            Toast toast = Toast.makeText(InfoActivity.this, "Current date", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.BOTTOM, 0, 0 );
            toast.show();
        }

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        String datatime = simpleDateFormat.format(new Date(System.currentTimeMillis()));

        textView2.setText(textInfo + datatime);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, MENU_TO_ACT_MAIN, 0, "Main Activity");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;

        switch (item.getItemId()) {
            case MENU_TO_ACT_MAIN:
                intent = new Intent(InfoActivity.this, MainActivity.class);
                startActivity(intent);
                break;
        }


        return super.onOptionsItemSelected(item);

    }
}
