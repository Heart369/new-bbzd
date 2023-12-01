package com.example.main.raw.Zdyclass;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

public class MyRecyclerview extends RecyclerView {


    public MyRecyclerview(@NonNull Context context) {
        super(context);
    }

    public MyRecyclerview(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyRecyclerview(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    //return false 不拦截，继续分发下去
    @Override
    public boolean onInterceptTouchEvent(MotionEvent e) {
        return false;
    }

}
