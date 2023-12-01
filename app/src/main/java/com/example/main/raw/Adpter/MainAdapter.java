package com.example.main.raw.Adpter;

import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;

import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

public class MainAdapter extends PagerAdapter {
    private List<View> pageViews;

    public MainAdapter(List<View> pageViews) {
        this.pageViews = pageViews;
    }

    @Override
    public int getCount() {
        return pageViews.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = pageViews.get(position);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View view = (View) object;
        container.removeView(view);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        // 不做任何操作，防止调用父类的实现
    }

    @Override
    public void finishUpdate(ViewGroup container) {
        // 不做任何操作，防止调用父类的实现
    }

    @Override
    public Parcelable saveState() {
        // 不保存页面状态
        return null;
    }

    @Override
    public void restoreState(Parcelable state, ClassLoader loader) {
        // 不恢复页面状态
    }

    @Override
    public int getItemPosition(Object object) {
        // 不更新页面位置
        return POSITION_UNCHANGED;
    }
}