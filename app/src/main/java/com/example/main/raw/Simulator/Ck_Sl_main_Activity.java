package com.example.main.raw.Simulator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.main.raw.Class_Custom.Lucency;
import com.example.main.raw.Class_Custom.Random;
import com.example.main.raw.DataClass.SywData;
import com.example.main.R;
import com.example.main.raw.Zdyclass.Csh;

import java.util.ArrayList;
import java.util.List;

public class Ck_Sl_main_Activity extends AppCompatActivity implements View.OnClickListener {
Toolbar toolbar;
ImageView lq;
LinearLayout layout1,layout2,layout3,layout4;
RelativeLayout relativeLayout,re3;
Button fh,fh_2;
    SywSx sywSx;
int size;
int s=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ck_sl_main);
        Csh csh=new Csh(this);
//        csh.csh();
//        toolbar=findViewById(R.id.toolbar_ck_sl);
//        layout2=findViewById(R.id.layout_2);
//        layout1=findViewById(R.id.layout_1);
//        layout3=findViewById(R.id.layout_3);
//        layout4=findViewById(R.id.layout_4);
//        layout1.setOnClickListener(this);
//        layout2.setOnClickListener(this);
//        layout3.setOnClickListener(this);
//        layout4.setOnClickListener(this);
        fh=findViewById(R.id.btn_fh);
        fh_2=findViewById(R.id.btn_fh_2);
        re3=findViewById(R.id.re3);
//        relativeLayout=findViewById(R.id.re_hd);
//        setSupportActionBar(toolbar);
//        setTitle(null);
//        Lucency lucency=new Lucency();
//        lucency.light(this);
//        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                finish();
//                overridePendingTransition(R.anim.back,R.anim.closs);
//                s=1;
//            }
//        });
//        lq=findViewById(R.id.img_lq);
//        relativeLayout.setVisibility(View.GONE);
//        re3.setVisibility(View.GONE);
//        layout4.setVisibility(View.GONE);
//        layout3.setVisibility(View.GONE);
//        lq.setOnClickListener(this);
//        fh.setOnClickListener(this);
//        fh_2.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
//        Random random=new Random(this);
//        List<SywData> sywData=new ArrayList<>();
//        TextView text1,text2,text3,text4;
//        ImageView image1,image2,image3,image4;
//        text1=findViewById(R.id.syw_text_1);
//        text2=findViewById(R.id.syw_text_2);
//        text3=findViewById(R.id.syw_text_3);
//        text4=findViewById(R.id.syw_text_4);
//        image1=findViewById(R.id.syw_img_1);
//        image2=findViewById(R.id.syw_img_2);
//        image3=findViewById(R.id.syw_img_3);
//        image4=findViewById(R.id.syw_img_4);
//
//        switch (v.getId()){
//            case R.id.img_lq:
//                relativeLayout.setVisibility(View.VISIBLE);
//                size=random.getCont();
//                lq.setClickable(false);
//                sywData=random.getsywdata(size);
//                 sywSx=new SywSx(this,this,sywData);
//                text1.setText(sywData.get(0).getName());
//                image1.setImageResource(sywData.get(0).getImage());
//                text2.setText(sywData.get(1).getName());
//                image2.setImageResource(sywData.get(1).getImage());
//                if (size==2){
//                    layout4.setVisibility(View.GONE);
//                    layout3.setVisibility(View.GONE);
//                }
//                if (size==3){
//                    layout3.setVisibility(View.VISIBLE);
//                    text3.setText(sywData.get(2).getName());
//                    image3.setImageResource(sywData.get(2).getImage());
//                }
//                if (size==4){
//                    layout4.setVisibility(View.VISIBLE);
//                    layout3.setVisibility(View.VISIBLE);
//                    text4.setText(sywData.get(3).getName());
//                    image4.setImageResource(sywData.get(3).getImage());
//                }
//                break;
//            case R.id.btn_fh:
//                relativeLayout.setVisibility(View.GONE);
//                lq.setClickable(true);
//                break;
//            case R.id.layout_1:
//               sywSx.sx(0);
//                re3.setVisibility(View.VISIBLE);
//               xg();
//                break;
//            case R.id.layout_2:
//                sywSx.sx(1);
//                re3.setVisibility(View.VISIBLE);
//                xg();
//                break;
//            case R.id.layout_3:
//                sywSx.sx(2);
//                re3.setVisibility(View.VISIBLE);
//                xg();
//                break;
//            case R.id.layout_4:
//                sywSx.sx(3);
//                re3.setVisibility(View.VISIBLE);
//                xg();
//                break;
//            case R.id.btn_fh_2:
//                re3.setVisibility(View.GONE);
//                layout1.setClickable(true);
//                layout1.setClickable(true);
//                layout1.setClickable(true);
//                layout1.setClickable(true);
//                fh.setClickable(true);
//                break;
//
//        }
    }
    public  void xg(){
        layout1.setClickable(false);
        layout2.setClickable(false);
        layout3.setClickable(false);
        layout4.setClickable(false);
        fh.setClickable(false);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (s==0){
            overridePendingTransition(R.anim.start,R.anim.back);
        }
        s=0;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        s=1;
        overridePendingTransition(R.anim.back,R.anim.closs);
    }
}