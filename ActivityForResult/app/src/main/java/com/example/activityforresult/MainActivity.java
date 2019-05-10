package com.example.activityforresult;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "myLogs";

    final int REQUEST_CODE_COLOR = 1;
    final int REQUEST_CODE_ALIGNMENT = 2;


    TextView tvHelloWord;
    Button btnColor, btnAlignment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvHelloWord = findViewById(R.id.tvHelloWord);
        btnColor = findViewById(R.id.btnColor);
        btnAlignment = findViewById(R.id.btnAlignment);

        btnColor.setOnClickListener(this);
        btnAlignment.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent;

        switch (v.getId()) {
            case R.id.btnColor:
                intent = new Intent(this, ColorActivity.class);
                startActivityForResult(intent, REQUEST_CODE_COLOR);
                break;
            case R.id.btnAlignment:
                intent = new Intent(this, AlignmentActivity.class);
                startActivityForResult(intent, REQUEST_CODE_ALIGNMENT);
                break;
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Log.d(TAG, "requestCode = " + requestCode + ", resultCode = " + resultCode);

        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case REQUEST_CODE_COLOR:
                    int color = data.getIntExtra("Color", Color.WHITE);
                    tvHelloWord.setTextColor(color);
                    Log.d(TAG, "Set Color");
                    break;
                case REQUEST_CODE_ALIGNMENT:
                    int gravity = data.getIntExtra("Gravity", Gravity.LEFT);
                    tvHelloWord.setGravity(gravity);
                    Log.d(TAG, "Set Gravity");
                    break;
            }
        } else {
            Toast toast = Toast.makeText(MainActivity.this, "Wrong result", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.BOTTOM, 0, 0 );
            toast.show();
        }
    }
}
