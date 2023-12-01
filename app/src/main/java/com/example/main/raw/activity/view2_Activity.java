package com.example.main.raw.activity;

import static android.view.animation.Animation.RELATIVE_TO_SELF;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LayoutAnimationController;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.main.R;
import com.example.main.mvvm.calculator.Calculator_Activity;
import com.example.main.mvvm.calculator.Main_Activity;
import com.example.main.mvvm.sywmnq.SywMain_Activity;
import com.example.main.raw.Adpter.view2_adapter;
import com.example.main.raw.Ck.Ck_main_Activity;
import com.example.main.raw.Simulator.Ck_Sl_main_Activity;
import com.example.main.raw.ck_mnq.Ck_Activity;
import com.example.main.raw.ys_bk.Js_xq_Activity;

public class view2_Activity extends AppCompatActivity  {
    ListView listView;
    String[] data=new String[]{"抽卡分析","圣遗物强化模拟","查询玩家信息","抽卡模拟器","原神百科查询","角色综合评测"};
    String[] data2=new String[]{"分析抽卡记录(6个月内)(👉ﾟヮﾟ)👉","模拟圣遗物抽取强化(愿风神忽悠你)","查询某位玩家的基础信息哦(看看是不是大佬ovo)(需先登录)","没原石了?来这玩玩吧<(￣︶￣)↗[GO!]","查询武器和角色的详细信息(更多信息查询待开发)(￣(工)￣)","角色面板查询,圣遗物评分,角色伤害计算,算算替换武器圣遗物后的伤害吧(ﾉ*･ω･)ﾉ"};
    Context context;
    ImageView imageView;
    SwipeRefreshLayout swipeRefreshLayout;
    public void csh(View view, Context context) {
        this.context=context;
        listView=view.findViewById(R.id.list_view2);
        view2_adapter adapter=new view2_adapter(context,6,data,data2);
        imageView=view.findViewById(R.id.view2_cs);
        imageView.setVisibility(View.GONE);
//        Glide.with(context)
//                .load("https://patchwiki.biligame.com/images/ys/thumb/c/cd/aahxj1sb98abj3p92anz1q459y8mz82.png/60px-%E5%A5%87%E5%BC%82%E7%9A%84%E3%80%8C%E7%89%99%E9%BD%BF%E3%80%8D.png")
//                .fitCenter()
//                .error(R.drawable.there_back_back)
//                .placeholder(R.drawable.ic_launcher_background)
//                .transform(new RoundedCorners(12))
//                .into(imageView);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=null;
            switch (position){
                case 0:
                     intent=new Intent(context, Ck_main_Activity.class);
                    context.startActivity(intent);
                    break;
                case 1:
                    intent=new Intent(context, SywMain_Activity.class);
                    context.startActivity(intent);
                    break;
                case 2:
                    intent=new Intent(context,UserCx_Activity.class);
                    context.startActivity(intent);
                    break;
                case 3:
                    intent=new Intent(context, Ck_Activity.class);
                    context.startActivity(intent);
                    break;
                case 4 :
                    intent=new Intent(context, Js_xq_Activity.class);
                    context.startActivity(intent);
                    break;
                case 5 :
                    intent=new Intent(context, Main_Activity.class);
                    context.startActivity(intent);
        }
            }
        });
    }
    public void setanim(){
        Animation animation;
        LayoutAnimationController controller;
        animation = new TranslateAnimation(2000f, 0f, 0f, 0f);
        animation.setDuration(200);
        controller = new LayoutAnimationController(getAnimationSetFromLeft(), 0.5f);
        controller.setOrder( LayoutAnimationController.ORDER_NORMAL);
        listView.setLayoutAnimation(controller);
        listView.startLayoutAnimation();
    }

    public static AnimationSet getAnimationSetFromLeft() {
        AnimationSet animationSet = new AnimationSet(true);
        TranslateAnimation translateX1 = new TranslateAnimation(RELATIVE_TO_SELF, -1.0f, RELATIVE_TO_SELF, 0.1f,
                RELATIVE_TO_SELF, 0, RELATIVE_TO_SELF, 0);
        translateX1.setDuration(300);
        translateX1.setInterpolator(new DecelerateInterpolator());
        translateX1.setStartOffset(0);

        TranslateAnimation translateX2 = new TranslateAnimation(RELATIVE_TO_SELF, 0.1f, RELATIVE_TO_SELF, -0.1f,
                RELATIVE_TO_SELF, 0, RELATIVE_TO_SELF, 0);
        translateX2.setStartOffset(300);
        translateX2.setInterpolator(new DecelerateInterpolator());
        translateX2.setDuration(50);

        TranslateAnimation translateX3 = new TranslateAnimation(RELATIVE_TO_SELF, -0.1f, RELATIVE_TO_SELF, 0f,
                RELATIVE_TO_SELF, 0, RELATIVE_TO_SELF, 0);
        translateX3.setStartOffset(350);
        translateX3.setInterpolator(new DecelerateInterpolator());
        translateX3.setDuration(50);

        animationSet.addAnimation(translateX1);
        animationSet.addAnimation(translateX2);
        animationSet.addAnimation(translateX3);
        animationSet.setDuration(400);

        return animationSet;
    }

}