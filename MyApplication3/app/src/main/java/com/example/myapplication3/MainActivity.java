package com.example.myapplication3;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout linearLayout;
        linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        setContentView(linearLayout, layoutParams);

        ViewGroup.LayoutParams lpView = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        TextView textView1 = new TextView(this);
        textView1.setText("TextView");
        textView1.setLayoutParams(lpView);
        linearLayout.addView(textView1);

        Button button1 = new Button(this);
        button1.setText("BUTTON1");
        linearLayout.addView(button1, lpView);

        LinearLayout.LayoutParams leftmarginParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        leftmarginParams.leftMargin = 50;
        Button button2 = new Button(this);
        button2.setText("BUTTON2");
        linearLayout.addView(button2, leftmarginParams);

        LinearLayout.LayoutParams rightgravityParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        rightgravityParams.gravity = Gravity.RIGHT;
        Button button3 = new Button(this);
        button3.setText("BUTTON3");
        linearLayout.addView(button3, rightgravityParams);




    }



}
