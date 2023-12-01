package com.example.main.raw.activity;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import com.example.main.R;

public class CircleRelativeLayout extends RelativeLayout {
    private int color;
    private int[] colors;
    private int alpha;
    public CircleRelativeLayout(Context context) {
        super(context);
    }
    public CircleRelativeLayout(Context context, AttributeSet attrs) {
        super(context,attrs);
        init(context,attrs);
        setWillNotDraw(false);
    }
    private void init(Context context, AttributeSet attrs) {
        TypedArray array = context.obtainStyledAttributes(attrs,
                R.styleable.CircleRelativeLayoutLayout);
        color = array.getColor(R.styleable.CircleRelativeLayoutLayout_background_color,0X0000000);
        alpha = array.getInteger(R.styleable.CircleRelativeLayoutLayout_background_alpha,100);
        setColors();
        array.recycle();
    }

 
    public void setColor(int color) { //设置背景色
        this.color = color;
        setColors();
        invalidate();
    }
 
    public void setAlhpa(int alhpa) { //设置透明度
        this.alpha = alhpa;
        invalidate();
    }
 
 
    public void setColors() {
        int red = (color & 0xff0000) >> 16;
        int green = (color & 0x00ff00) >> 8;
        int blue = (color & 0x0000ff);
        this.colors = new int[]{red,green,blue};
    }
 
}
