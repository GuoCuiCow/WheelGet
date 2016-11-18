package com.gebilaowang.example.wheelget;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Main2Activity extends AppCompatActivity {
    DoubleWheelPicker mDoubleWheelPicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mDoubleWheelPicker= (DoubleWheelPicker) findViewById(R.id.double_wheel);
        mDoubleWheelPicker.setData(30,10);

    }
}
