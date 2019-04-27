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

    TextView textView;

    Button changeActBtn;

    final int MENU_ALPHA_ID = 1;
    final int MENU_SCALE_ID = 2;
    final int MENU_TRANS_ID = 3;
    final int MENU_ROTATE_ID = 4;
    final int MENU_COMBO_ID = 5;

//    TextView textView;
//
//    final int MENU_ALPHA_ID = 1;
//    final int MENU_SCALE_ID = 2;
//    final int MENU_TRANS_ID = 3;
//    final int MENU_ROTATE_ID = 4;
//    final int MENU_COMBO_ID = 5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "Finded view in main activity");


        textView = findViewById(R.id.textView);
        changeActBtn = findViewById(R.id.button1);

        changeActBtn.setOnClickListener(this);



        registerForContextMenu(textView);

//        textView = findViewById(R.id.textView);
//
//        registerForContextMenu(textView);
//    }
//
//    @Override
//    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
//
//        switch (v.getId()) {
//            case R.id.textView:
//            menu.add(0, MENU_ALPHA_ID, 0, "Alpha");
//            menu.add(0, MENU_SCALE_ID, 0, "Scale");
//            menu.add(0, MENU_TRANS_ID, 0, "Trans");
//            menu.add(0, MENU_ROTATE_ID, 0, "Rotate");
//            menu.add(0, MENU_COMBO_ID, 0, "Combo");
//            break;
//        }
//        super.onCreateContextMenu(menu, v, menuInfo);
//    }
//
//    @Override
//    public boolean onContextItemSelected(MenuItem item) {
//
//        Animation anim = null;
//
//        switch (item.getItemId()) {
//            case MENU_ALPHA_ID:
//                anim = AnimationUtils.loadAnimation(this, R.anim.myalpha);
//                break;
//            case MENU_SCALE_ID:
//                anim = AnimationUtils.loadAnimation(this, R.anim.myscale);
//                break;
//            case MENU_TRANS_ID:
//                anim = AnimationUtils.loadAnimation(this, R.anim.mytrans);
//                break;
//            case MENU_ROTATE_ID:
//                anim = AnimationUtils.loadAnimation(this, R.anim.myrotate);
//                break;
//            case MENU_COMBO_ID:
//                anim = AnimationUtils.loadAnimation(this, R.anim.mycombo);
//                break;
//        }
//
//        textView.startAnimation(anim);
//
//        return super.onContextItemSelected(item);
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
