package com.example.main.raw.ys_bk;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

public class viewpager_adapter extends FragmentPagerAdapter {
    List<Fragment> data;


    public viewpager_adapter(@NonNull FragmentManager fm, List<Fragment> data) {
        super(fm);
        this.data = data;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return data.get(position);
    }

    @Override
    public int getCount() {
        return 1;
    }
}
