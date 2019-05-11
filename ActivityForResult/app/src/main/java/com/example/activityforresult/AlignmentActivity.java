package com.example.activityforresult;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AlignmentActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "myLogs";

    final int MENU_ITEM_TO_MAIN = 1;

    Button btnLeft, btnCenter, btnRight;
    TextView tvHoldMe;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alignment);

       tvHoldMe = findViewById(R.id.tvHoldMe);

        btnLeft = findViewById(R.id.btnLeft);
        btnCenter = findViewById(R.id.btnCenter);
        btnRight = findViewById(R.id.btnRight);

        btnLeft.setOnClickListener(this);
        btnCenter.setOnClickListener(this);
        btnRight.setOnClickListener(this);

        registerForContextMenu(tvHoldMe);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();

        switch (v.getId()) {
            case R.id.btnLeft:
                intent.putExtra("Gravity", Gravity.LEFT);
                Log.d(TAG, "Set Gravity left");
                break;
            case R.id.btnCenter:
                intent.putExtra("Gravity", Gravity.CENTER);
                Log.d(TAG, "Set Gravity center");
                break;
            case R.id.btnRight:
                intent.putExtra("Gravity", Gravity.RIGHT);
                Log.d(TAG, "Set Gravity right");
                break;
        }
        setResult(RESULT_OK, intent);
        finish();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(0, MENU_ITEM_TO_MAIN, 0, "Main");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        Intent intent;

        switch (item.getItemId()){
            case MENU_ITEM_TO_MAIN:
                intent = new Intent(AlignmentActivity.this, MainActivity.class);
                startActivity(intent);
                break;
        }
        return super.onContextItemSelected(item);
    }
}
