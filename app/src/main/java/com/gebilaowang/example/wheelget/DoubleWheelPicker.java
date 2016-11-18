package com.gebilaowang.example.wheelget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bigkoo.pickerview.adapter.ArrayWheelAdapter;
import com.bigkoo.pickerview.adapter.WheelAdapter;
import com.bigkoo.pickerview.lib.WheelView;
import com.bigkoo.pickerview.listener.OnItemSelectedListener;

import java.util.ArrayList;

/**
 * Created by cuiguo on 2016/11/18.
 */

public class DoubleWheelPicker extends LinearLayout {
    private ArrayList leftNumber =new ArrayList<>();
    private ArrayList rightNumber =new ArrayList<>();
    private Context mContext;
    private WheelView mWheelView1;
    private WheelView mWheelView2;
    private WheelAdapter mWheelAdapter2;
    private WheelAdapter mWheelAdapter1;

    public DoubleWheelPicker(Context context) {
        super(context);
        initView(context);
    }

    public DoubleWheelPicker(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public DoubleWheelPicker(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
       initView(context);

    }
    private void initView(Context context){
        mContext=context;
        View.inflate(mContext,R.layout.double_wheel_picker,this);
        mWheelView1 = (WheelView) findViewById(R.id.wheelview1);
        mWheelView2 = (WheelView) findViewById(R.id.wheelview2);
        mWheelView1.setCyclic(false);
        mWheelAdapter1 = new ArrayWheelAdapter(leftNumber);
        mWheelView1.setAdapter(mWheelAdapter1);
        rightNumber= leftNumber;
        mWheelView2.setCyclic(false);
        mWheelView1.setOnItemSelectedListener(new OnItemSelectedListener() {
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
                if (mWheelView1.getCurrentItem()>index){
                    Toast.makeText(mContext,"最大年龄不能小于最小年龄",Toast.LENGTH_SHORT).show();
                    mWheelView2.setCurrentItem(mWheelView1.getCurrentItem());
                }


            }
        });
        mWheelAdapter2 = new ArrayWheelAdapter(rightNumber);
        mWheelView2.setAdapter(mWheelAdapter2);

    }

    public ArrayList setData(int min, int max){
        if (min>max){
            max=min;
        }
        for(int i=min;i<max+1;i++){
            leftNumber.add(i);
        }
        return leftNumber;
    }

}
