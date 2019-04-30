package com.example.animationapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "myLogs";

    TextView textView, textV_Ch_Act;

    Button changeActBtn;

    final int MENU_ALPHA_ID = 1;
    final int MENU_SCALE_ID = 2;
    final int MENU_TRANS_ID = 3;
    final int MENU_ROTATE_ID = 4;
    final int MENU_COMBO_ID = 5;

    final int MENU_ACT2 = 6;
    final int MENU_ACT3 = 7;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "Finded view in main activity");


        textView = findViewById(R.id.textView);
        textV_Ch_Act = findViewById(R.id.textV_Ch_Act);
        changeActBtn = findViewById(R.id.button1);

        changeActBtn.setOnClickListener(this);

        registerForContextMenu(textView);
        registerForContextMenu(textV_Ch_Act);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        switch (v.getId()) {
            case R.id.textView:
                menu.add(0, MENU_ALPHA_ID, 0, "Alpha");
                menu.add(0, MENU_SCALE_ID, 0, "Scale");
                menu.add(0, MENU_TRANS_ID, 0, "Trans");
                menu.add(0, MENU_ROTATE_ID, 0, "Rotate");
                menu.add(0, MENU_COMBO_ID, 0, "Combo");
                break;
            case R.id.textV_Ch_Act:
                menu.add(0, MENU_ACT2, 1, "Activity 2" );
                menu.add(0, MENU_ACT3,2, "Activity 3");
                break;
        }

        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        Animation anim = null;

        switch (item.getItemId()) {
            case MENU_ALPHA_ID:
                anim = AnimationUtils.loadAnimation(this, R.anim.myalpha);
                break;
            case MENU_SCALE_ID:
                anim = AnimationUtils.loadAnimation(this, R.anim.myscale);
                break;
            case MENU_TRANS_ID:
                anim = AnimationUtils.loadAnimation(this, R.anim.mytrans);
                break;
            case MENU_ROTATE_ID:
                anim = AnimationUtils.loadAnimation(this, R.anim.myrotate);
                break;
            case MENU_COMBO_ID:
                anim = AnimationUtils.loadAnimation(this, R.anim.mycombo);
                Toast toast = Toast.makeText(this, "Starting combo", Toast.LENGTH_LONG);toast.setGravity(Gravity.BOTTOM, 0, 0);
                toast.setGravity(Gravity.BOTTOM, 0 , 0 );
                toast.show();
                break;
            case MENU_ACT2:
                Intent intent = new Intent(this, Activity2.class);
                startActivity(intent);
                break;
            case MENU_ACT3:
                Intent intent5 = new Intent(this, Activity3.class);
                startActivity(intent5);
                break;
        }
        textView.startAnimation(anim);

        return super.onContextItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                Intent intent = new Intent(this, Activity2.class);
                startActivity(intent);
                break;
            default:
                break;

        }
    }
}
