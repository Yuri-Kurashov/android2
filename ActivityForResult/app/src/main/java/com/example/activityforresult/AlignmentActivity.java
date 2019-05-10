package com.example.activityforresult;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;

public class AlignmentActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "myLogs";

    Button btnLeft, btnCenter, btnRight;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alignment);

        btnLeft = findViewById(R.id.btnLeft);
        btnCenter = findViewById(R.id.btnCenter);
        btnRight = findViewById(R.id.btnRight);

        btnLeft.setOnClickListener(this);
        btnCenter.setOnClickListener(this);
        btnRight.setOnClickListener(this);
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
}
