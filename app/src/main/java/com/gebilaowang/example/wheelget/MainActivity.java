package com.gebilaowang.example.wheelget;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.bigkoo.pickerview.adapter.ArrayWheelAdapter;
import com.bigkoo.pickerview.adapter.WheelAdapter;
import com.bigkoo.pickerview.lib.WheelView;
import com.bigkoo.pickerview.listener.OnItemSelectedListener;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    ArrayList mStrings =new ArrayList<>();
    ArrayList mStrings2 =new ArrayList<>();
    Context mContext;
    private WheelView mWheelView;
    private WheelView mWheelView2;
    private WheelAdapter mWheelAdapter2;
    private WheelAdapter mWheelAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext=this;
        mStrings=setData(mStrings,120,60);
        mWheelView = (WheelView) findViewById(R.id.wheelview);
        mWheelView2 = (WheelView) findViewById(R.id.wheelview2);
        mWheelView.setCyclic(false);
        mWheelAdapter = new ArrayWheelAdapter(mStrings);
        mWheelView.setAdapter(mWheelAdapter);
        mStrings2=mStrings;
        mWheelView2.setCyclic(false);
        mWheelView.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(int index) {
                Log.e("main",""+index);
                if (mWheelView2.getCurrentItem()<index){
                        mWheelView2.setCurrentItem(index);
                }

            }
        });
        mWheelView2.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(int index) {
                if (mWheelView.getCurrentItem()>index){
                    Toast.makeText(mContext,"最大年龄不能小于最小年龄",Toast.LENGTH_SHORT).show();
                    mWheelView2.setCurrentItem(mWheelView.getCurrentItem());
                }


            }
        });
        mWheelAdapter2 = new ArrayWheelAdapter(mStrings2);
        mWheelView2.setAdapter(mWheelAdapter2);
        Button button = (Button) findViewById(R.id.btn1);
        button.setOnClickListener(this);

    }
    private ArrayList setData(ArrayList arrayList,int base,int size){
        for(int i=0;i<size;i++){
            mStrings.add(base+i);
        }
        return arrayList;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn1:
                Intent intent =new Intent(this,Main2Activity.class);
                startActivity(intent);
                break;
        }


    }
}
