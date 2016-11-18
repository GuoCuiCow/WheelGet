package com.gebilaowang.example.wheelget;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class Main2Activity extends AppCompatActivity {
    DoubleWheelPicker mDoubleWheelPicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mDoubleWheelPicker= (DoubleWheelPicker) findViewById(R.id.double_wheel);
        mDoubleWheelPicker.setData(30,50);
        mDoubleWheelPicker.setOnDoubleWheelItemSelectedListener(new OnDoubleWheelItemSelectedListener() {
            @Override
            public void onLeftItemSelected(int index) {
                Log.e("onLeftItemSelected",""+index);
            }

            @Override
            public void onRightItemSelected(int index) {
                Log.e("onRightItemSelected",""+index);

            }
        });

    }
}
