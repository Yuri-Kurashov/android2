package com.example.myapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


    }
    public static final String TAG = "myLogs";

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            Log.d(TAG, "Pushed menu setting");
//            Toast toast = Toast.makeText(MainActivity.this, R.string.action_settings, Toast.LENGTH_LONG);
//            toast.setGravity(Gravity.TOP, 0, 0);
//            toast.show();
//        }
//        else if (id == R.id.action_item1) {
//            Log.d(TAG, "Pushed menu item1");
//            Toast toast = Toast.makeText(MainActivity.this, R.string.item1, Toast.LENGTH_LONG);
//            toast.setGravity(Gravity.TOP, 0, 0);
//            toast.show();
//        }
//        else if (id == R.id.action_item2) {
//            Log.d(TAG, "Pushed menu item2");
//            Toast toast = Toast.makeText(MainActivity.this, R.string.item2, Toast.LENGTH_LONG);
//            toast.setGravity(Gravity.TOP, 0, 0);
//            toast.show();
//        }
//        else if (id == R.id.action_item3) {
//            Log.d(TAG, "Pushed menu item3");
//            Toast toast = Toast.makeText(MainActivity.this, R.string.item3, Toast.LENGTH_LONG);
//            toast.setGravity(Gravity.TOP, 0, 0);
//            toast.show();
//        }

        switch (id) {
            case R.id.action_settings:
                Log.d(TAG, "Pushed menu setting");
                Toast toast = Toast.makeText(MainActivity.this, R.string.action_settings, Toast.LENGTH_LONG);
                toast.setGravity(Gravity.BOTTOM, 0, 0);
                toast.show();
                break;
            case R.id.action_item1:
                Log.d(TAG, "Pushed menu item1");
                Toast toast2 = Toast.makeText(MainActivity.this, R.string.item1, Toast.LENGTH_LONG);
                toast2.setGravity(Gravity.BOTTOM, 0, 0);
                toast2.show();
                break;
            case R.id.action_item2:
                Log.d(TAG, "Pushed menu item2");
                Toast toast3 = Toast.makeText(MainActivity.this, R.string.item2, Toast.LENGTH_LONG);
                toast3.setGravity(Gravity.BOTTOM, 0, 0);
                toast3.show();
                break;
            case R.id.action_item3:
                Log.d(TAG, "Pushed menu item3");
                Toast toast4 = Toast.makeText(MainActivity.this, R.string.item3, Toast.LENGTH_LONG);
                toast4.setGravity(Gravity.BOTTOM, 0, 0);
                toast4.show();
                break;
        }


        return super.onOptionsItemSelected(item);
    }
}
