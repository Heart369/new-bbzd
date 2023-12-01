package com.example.main.raw.ScZs;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import com.example.main.raw.Class_Custom.time;
import com.example.main.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class ClmainActivity extends AppCompatActivity implements View.OnClickListener{
    ViewPager viewpager;
    Toolbar toolbar;
    private ArrayList<View> pageview;
    View1_Activity view1_activity1 = new View1_Activity();
    View1_Activity view1_activity2 = new View1_Activity();
    View1_Activity view1_activity3 = new View1_Activity();
    View1_Activity view1_activity4 = new View1_Activity();
    TabLayout tabLayout;
    String[] data = new String[]{"周一/周四","周二/周五","周三/周六","周日"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clmain);
        LayoutInflater inflater =getLayoutInflater();//拿取当前页面所有布局
        View view1 = inflater.inflate(R.layout.activity_view4, null);
        View view2 = inflater.inflate(R.layout.activity_view4, null);
        View view3 = inflater.inflate(R.layout.activity_view4, null);
        View view4 = inflater.inflate(R.layout.activity_view4, null);
        toolbar=findViewById(R.id.toolbar_cmain);
        setSupportActionBar(toolbar);
        setTitle(null);
        tabLayout=findViewById(R.id.tab_1);
        pageview =new ArrayList<View>();
        pageview.add(view1);
        pageview.add(view2);
        pageview.add(view3);
        pageview.add(view4);
        tabLayout.addTab(tabLayout.newTab().setText(data[0]));
        tabLayout.addTab(tabLayout.newTab().setText(data[1]));
        tabLayout.addTab(tabLayout.newTab().setText(data[2]));
        viewpager=findViewById(R.id.viewPager_cl);
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }


        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(R.anim.back,R.anim.closs);
            }
        });


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
        time time = new time();
       int a=0;
        String week=time.getWeek();

        switch (week){
            case "周一" : case  "周四" :
                break;
            case "周二" : case  "周五" :
                a=1;
                break;
            case "周三" : case  "周六" :
                a=2;
                break;
            case "周日" :
                a=3;
                break;
        }
        viewpager.setAdapter(adapter);
        //设置viewPager的初始界面为第一个界面
        viewpager.setCurrentItem(a);
        tabLayout.setupWithViewPager(viewpager,false);
        //添加切换界面的监听器
        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        view1_activity1.csh(view1,ClmainActivity.this,getLayoutInflater(),1);
                        break;
                    case 1:
                        view1_activity2.csh(view2,ClmainActivity.this,getLayoutInflater(),2);
                        break;
                    case 2:
                        view1_activity3.csh(view3,ClmainActivity.this,getLayoutInflater(),3);
                        break;
                    case 3:
                        view1_activity4.csh(view4,ClmainActivity.this,getLayoutInflater(),4);
                        break;
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        DisplayMetrics displayMetrics = new DisplayMetrics();
        //将当前窗口的一些信息放在DisplayMetrics类中
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        //得到屏幕的宽度
        time time1 = new time();
        switch(time1.getWeek()){
            case  "周一": case "周四":
                view1_activity1.csh(view1,this,getLayoutInflater(),1);
                break;
            case  "周二": case "周五":
                view1_activity2.csh(view2,this,getLayoutInflater(),2);
                break;
            case  "周三": case "周六":
                view1_activity3.csh(view3,this,getLayoutInflater(),3);
                Log.d("TAG","已初始化");
                break;
            case "周日":
                view1_activity4.csh(view4,this,getLayoutInflater(),4);
                break;

        }




    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        view1_activity1=null;
        view1_activity2=null;
        view1_activity3=null;
        view1_activity4=null;
        viewpager=null;
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.back,R.anim.closs);
    }
}