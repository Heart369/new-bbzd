package com.example.main.mvvm.adapter.calculator.fragment;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.main.mvvm.calculator.Fragment_Calculator;

import java.util.List;

public class viewpager_adapter extends FragmentStatePagerAdapter {
    List<Fragment_Calculator> fragments;



    public viewpager_adapter(FragmentManager supportFragmentManager, List<Fragment_Calculator> calculators) {
        super(supportFragmentManager);
        this.fragments=calculators;
    }

    public void setFragments(List<Fragment_Calculator> fragments) {
        this.fragments = fragments;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        super.destroyItem(container, position, object);
    }

}
