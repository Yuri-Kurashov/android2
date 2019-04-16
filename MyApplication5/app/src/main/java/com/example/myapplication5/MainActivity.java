package com.example.myapplication5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    SeekBar seekBar;
    Button btn1;
    Button btn2;

    LinearLayout.LayoutParams lbarams1;
    LinearLayout.LayoutParams lbarams2;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar.findViewById(R.id.seekBar);
        btn1.findViewById(R.id.btn1);
        btn2.findViewById(R.id.btn2);

        lbarams1 = (LinearLayout.LayoutParams) btn1.getLayoutParams();
        lbarams2 = (LinearLayout.LayoutParams) btn2.getLayoutParams();

        seekBar.setOnSeekBarChangeListener(this);

//        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
//            @Override
//            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
//                int leftValue = progress;
//                int rightValue = seekBar.getMax() - progress;
//
//                lbarams1.weight = leftValue;
//                lbarams2.weight = rightValue;
//
//                btn1.setText(String.valueOf(leftValue));
//                btn2.setText(String.valueOf(rightValue));
//
//
//
//            }
//
//            @Override
//            public void onStartTrackingTouch(SeekBar seekBar) {
//
//            }
//
//            @Override
//            public void onStopTrackingTouch(SeekBar seekBar) {
//
//            }
//        });





    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

        int leftValue = i;
        int rightValue = seekBar.getMax() - i;

        lbarams1.weight = leftValue;
        lbarams2.weight = rightValue;

        btn1.setText(String.valueOf(leftValue));
        btn2.setText(String.valueOf(rightValue));


    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
