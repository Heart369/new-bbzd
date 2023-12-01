package com.example.main.raw.Simulator;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.example.main.mvvm.sywmnq.Qh_Activity;
import com.example.main.raw.Class_Custom.Random;
import com.example.main.raw.DataClass.SywData;
import com.example.main.raw.DataClass.SywSxData;
import com.example.main.raw.DataClass.SywSxData2;
import com.example.main.R;
import com.google.gson.Gson;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class SywSx {
    Activity activity;
    Context context;
    List<SywData> sywData;
    List<SywSxData> data=new ArrayList<>();
    List<List<SywSxData2>> data2=new ArrayList<>();

    public SywSx(Activity activity, Context context, List<SywData> sywData) {
        this.activity = activity;
        this.context = context;
        this.sywData = sywData;
        getdata();
    }

    private void getdata() {
        int a=sywData.size();
        Random random=new Random(context);
       data=random.getSx(sywData);
       for (int b=0;b<sywData.size();b++){
           List<SywSxData2> syw;
           for (;;){
               boolean flag=false;
               syw= random.getSx2(sywData.get(b).getId());
               for (int c=0;c<syw.get(0).getCts();c++){
                   if (!(sywData.get(b).getId()==1||sywData.get(b).getId()==2))
                       if (!(syw.get(c).getB()==1))

                           if (syw.get(c).getName().equals(data.get(b).getMainname())){
                               flag=true;
                               Log.d("TAG","重复"+syw.get(c).getName()+data.get(b).getMainname());
                           }
               }

               if (flag)
                   ;
               else
                  break;
           }
          data2.add(syw);
           Log.d("TAG","ok");
       }

    }

    public void sx(int i){
        TextView title=activity.findViewById(R.id.syw_title);
        SywData sywData=this.sywData.get(i);
        SywSxData data=this.data.get(i);
        List<SywSxData2> syw;
        syw=data2.get(i);
        TextView zjname=activity.findViewById(R.id.zjname),zj_1=activity.findViewById(R.id.zj_1),zj_2=activity.findViewById(R.id.zj_2);
        zjname.setText(sywData.getTzname());
        zj_1.setText(sywData.getTz1());
        zj_2.setText(sywData.getTz2());
        ImageView imageView=activity.findViewById(R.id.syw_title_img);
        Glide.with(context)
                .load("https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_"+sywData.getName()+"_"+sywData.getId2()+".png")
                .fitCenter()
                .error(R.drawable.os_kl_cs)
                .placeholder(R.drawable.os_kl_cs)
                .into(imageView);

        TextView sywname=activity.findViewById(R.id.syw_name);
        sywname.setText(sywData.getImage());
        switch (sywData.getId()){
            case 1:
                title.setText("生之花");
                break;
            case 2:
                title.setText("死之羽");
                break;
            case 3:
                title.setText("时之沙");
                break;
            case 4:
                title.setText("空之杯");
                break;
            case 5:
                title.setText("理之冠");
                break;
        }
TextView mainname,exp;
        Button btn_qh=activity.findViewById(R.id.btn_qh);
        btn_qh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, Qh_Activity.class);
                Gson gson=new Gson();
                String datax = gson.toJson(data);
                String datay =gson.toJson(data2);
                String sywdata=gson.toJson(sywData);
                intent.putExtra("age",i);
                intent.putExtra("zct",datax);
                intent.putExtra("fct",datay);
                intent.putExtra("jcdata",sywdata);
                context.startActivity(intent);
            }
        });
        mainname=activity.findViewById(R.id.mainname);
        exp=activity.findViewById(R.id.exp);
        mainname.setText(data.getMainname());
        Double zz=data.getExp();
        if (data.getB()==1){
            String zs=new DecimalFormat("0").format(zz);
            exp.setText(""+zs);
        }

        else {
            String zs=new DecimalFormat("0.0").format(zz);
            exp.setText(""+zs+"%");
        }

        TextView ct1,ct2,ct3,ct4;
        ct1=activity.findViewById(R.id.ct1);
        ct2=activity.findViewById(R.id.ct2);
        ct3=activity.findViewById(R.id.ct3);
        ct4=activity.findViewById(R.id.ct4);
        if (syw.get(0).getCts()==3){
            ct4.setVisibility(View.GONE);
            if (syw.get(0).getB()==1){
                zz=syw.get(0).getExp();
                String zs=new DecimalFormat("0").format(zz);
                ct1.setText(syw.get(0).getName()+"+"+zs);
            }
            else{
                zz=syw.get(0).getExp();
                String zs=new DecimalFormat("0.0").format(zz);
                ct1.setText(syw.get(0).getName()+"+"+zs+"%");
            }
            if (syw.get(1).getB()==1){
                zz=syw.get(1).getExp();
                String zs=new DecimalFormat("0").format(zz);
                ct2.setText(syw.get(1).getName()+"+"+zs);
            }
            else{
                zz=syw.get(1).getExp();
                String zs=new DecimalFormat("0.0").format(zz);
                ct2.setText(syw.get(1).getName()+"+"+zs+"%");
            }
            if (syw.get(2).getB()==1){
                zz=syw.get(2).getExp();
                String zs=new DecimalFormat("0").format(zz);
                ct3.setText(syw.get(2).getName()+"+"+zs);
            }
            else{
                zz=syw.get(2).getExp();
                String zs=new DecimalFormat("0.0").format(zz);
                ct3.setText(syw.get(2).getName()+"+"+zs+"%");
            }
        }else {
            ct4.setVisibility(View.VISIBLE);
            if (syw.get(0).getB()==1){
                zz=syw.get(0).getExp();
                String zs=new DecimalFormat("0").format(zz);
                ct1.setText(syw.get(0).getName()+"+"+zs);
            }
            else{
                zz=syw.get(0).getExp();
                String zs=new DecimalFormat("0.0").format(zz);
                ct1.setText(syw.get(0).getName()+"+"+zs+"%");
            }
            if (syw.get(1).getB()==1){
                zz=syw.get(1).getExp();
                String zs=new DecimalFormat("0").format(zz);
                ct2.setText(syw.get(1).getName()+"+"+zs);
            }
            else{
                zz=syw.get(1).getExp();
                String zs=new DecimalFormat("0.0").format(zz);
                ct2.setText(syw.get(1).getName()+"+"+zs+"%");
            }
            if (syw.get(2).getB()==1){
                zz=syw.get(2).getExp();
                String zs=new DecimalFormat("0").format(zz);
                ct3.setText(syw.get(2).getName()+"+"+zs);
            }
            else{
                zz=syw.get(2).getExp();
                String zs=new DecimalFormat("0.0").format(zz);
                ct3.setText(syw.get(2).getName()+"+"+zs+"%");
            }
            if (syw.get(3).getB()==1){
                zz=syw.get(3).getExp();
                String zs=new DecimalFormat("0").format(zz);
                ct4.setText(syw.get(3).getName()+"+"+zs);
            }
            else{
                zz=syw.get(3).getExp();
                String zs=new DecimalFormat("0.0").format(zz);
                ct4.setText(syw.get(3).getName()+"+"+zs+"%");
            }


        }
    }
}
