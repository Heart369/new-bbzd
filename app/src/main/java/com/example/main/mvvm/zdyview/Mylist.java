package com.example.main.mvvm.zdyview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

    public class Mylist extends ListView {
        public Mylist(Context context) {
            super(context);
        }

        public Mylist(Context context, AttributeSet attrs) {
            super(context, attrs);
        }

        public Mylist(Context context, AttributeSet attrs, int defStyleAttr) {
            super(context, attrs, defStyleAttr);
        }

        public Mylist(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
            super(context, attrs, defStyleAttr, defStyleRes);
        }

        @Override
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            //将ListView扩展开
            heightMeasureSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

