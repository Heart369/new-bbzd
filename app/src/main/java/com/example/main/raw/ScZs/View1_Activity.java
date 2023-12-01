package com.example.main.raw.ScZs;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.example.main.raw.Adpter.recy_Adpter_zs;
import com.example.main.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class View1_Activity extends AppCompatActivity {
    ViewPager viewPager;
    private ArrayList<View> pageview;
    RecyclerView recyclerView1;
    RecyclerView recyclerView2;
    LinearLayoutManager layoutManager;
    TabLayout tabLayout;
    String[] data =new String[]{"角色","武器"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view4);
    }

    public void csh(View view, Context context, LayoutInflater layoutInflater,int i){
        viewPager=view.findViewById(R.id.viewPager_zs);
        View view1=layoutInflater.inflate(R.layout.activity_zs,null);
        View view2=layoutInflater.inflate(R.layout.activity_zs,null);
        recyclerView1=view1.findViewById(R.id.recy_zs);
        recyclerView2=view2.findViewById(R.id.recy_zs);
        tabLayout=view.findViewById(R.id.tab_2);



        switch (i){
            case 1:
                layoutManager =new LinearLayoutManager(this);
                layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                recyclerView1.setLayoutManager(layoutManager);
                recy_Adpter_zs adpter = new recy_Adpter_zs(5,context,1);
                recyclerView1.setAdapter(adpter);

                layoutManager =new LinearLayoutManager(context);
                layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                recyclerView2.setLayoutManager(layoutManager);
                recy_Adpter_zs adpter_wq = new recy_Adpter_zs(5,context,4);
                recyclerView2.setAdapter(adpter_wq);

                break;
            case 2:
                 layoutManager =new LinearLayoutManager(this);
                layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                recyclerView1.setLayoutManager(layoutManager);
                recy_Adpter_zs adpter1 = new recy_Adpter_zs(5,context,2);
                recyclerView1.setAdapter(adpter1);


                layoutManager =new LinearLayoutManager(context);
                layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                recyclerView2.setLayoutManager(layoutManager);
                recy_Adpter_zs adpter_wq1 = new recy_Adpter_zs(5,context,5);
                recyclerView2.setAdapter(adpter_wq1);
                break;
            case 3:
                layoutManager =new LinearLayoutManager(this);
                layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                recyclerView1.setLayoutManager(layoutManager);
                recy_Adpter_zs adpter2 = new recy_Adpter_zs(5,context,3);
                recyclerView1.setAdapter(adpter2);

                layoutManager =new LinearLayoutManager(context);
                layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                recyclerView2.setLayoutManager(layoutManager);
                recy_Adpter_zs adpter_wq2 = new recy_Adpter_zs(5,context,6);
                recyclerView2.setAdapter(adpter_wq2);
                break;
            case 4:
                layoutManager =new LinearLayoutManager(this);
                layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                recyclerView1.setLayoutManager(layoutManager);
                recy_Adpter_zs adpter3 = new recy_Adpter_zs(15,context,7);
                recyclerView1.setAdapter(adpter3);

                layoutManager =new LinearLayoutManager(context);
                layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                recyclerView2.setLayoutManager(layoutManager);
                recy_Adpter_zs adpter_wq3 = new recy_Adpter_zs(15,context,8);
                recyclerView2.setAdapter(adpter_wq3);
                break;
        }

        pageview =new ArrayList<View>();
        pageview.add(view1);
        pageview.add(view2);


        PagerAdapter adapter =new PagerAdapter() {
            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return data[position];
            }

            @Override
            public int getCount() {
                return pageview.size();
            }

            @Override
            public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
                return view==object;
            }
            //使从ViewGroup中移出当前View
            public void destroyItem(View arg0, int arg1, Object arg2) {
                ((ViewPager) arg0).removeView(pageview.get(arg1));
            }

            //返回一个对象，这个对象表明了PagerAdapter适配器选择哪个对象放在当前的ViewPager中
            public Object instantiateItem(View arg0, int arg1){
                ((ViewPager)arg0).addView(pageview.get(arg1));
                return pageview.get(arg1);
            }
        };

        viewPager.setAdapter(adapter);
        //设置viewPager的初始界面为第一个界面
        tabLayout.setupWithViewPager(viewPager,false);
        viewPager.setCurrentItem(0);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        recyclerView1=null;
        recyclerView2=null;
        viewPager=null;
    }
}