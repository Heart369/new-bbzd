package com.example.main.raw.Adpter;

import android.content.Context;
import android.content.Intent;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.main.raw.Class_Custom.Bq_gson;
import com.example.main.raw.Class_Custom.Recy_item_jj;
import com.example.main.raw.Class_Custom.time;
import com.example.main.raw.DataClass.Bqdata;
import com.example.main.raw.DataClass.CghData;
import com.example.main.raw.DataClass.MyListData;
import com.example.main.raw.DataClass.Userxx;
import com.example.main.raw.DataClass.WordData;
import com.example.main.raw.activity.JsXq_Activity;
import com.example.main.R;
import com.example.main.raw.activity.Sy_Activity;
import com.king.view.arcseekbar.ArcSeekBar;

import java.util.HashMap;
import java.util.List;

public class MyListViewAdpter extends BaseAdapter {
    Context context;
    int[] layout;
    String[] jsxx;
    List<MyListData> data;
    Bq_gson bq;
    Userxx user;
    CghData cgh;
    List<WordData> word;
    String uid;

    public MyListViewAdpter(Context context, int[] layout, List<MyListData> data, Bq_gson bqdata, Userxx user, String[] jsxx,CghData cgh,List<WordData> word,String uid) {
        this.context = context;
        this.layout = layout;
        this.jsxx = jsxx;
        this.data = data;
        this.bq = bqdata;
        this.user = user;
        this.cgh=cgh;
        this.word=word;
        this.uid=uid;
    }

    @Override
    public int getCount() {
        return layout.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(layout[position], parent,false);
        switch (layout[position]){
            case R.layout.mylist_jb:
                if (user!=null){
                    TextView itextView1=view.findViewById(R.id.text_sj1);
                    TextView itextView2=view.findViewById(R.id.text_sj2);
                    TextView itextView3=view.findViewById(R.id.text_sj3);
                    TextView itextView4=view.findViewById(R.id.text_sj4);
                    TextView itextView5=view.findViewById(R.id.text_sj5);
                    TextView itextView6=view.findViewById(R.id.text_sj6);
                    TextView itextView7=view.findViewById(R.id.text_sj7);
                    TextView itextView8=view.findViewById(R.id.text_sj8);
                    TextView itextView9=view.findViewById(R.id.text_sj9);
                    TextView itextView10=view.findViewById(R.id.text_sj10);
                    TextView itextView11=view.findViewById(R.id.text_sj11);
                    TextView itextView12=view.findViewById(R.id.text_sj12);
                    TextView itextView13=view.findViewById(R.id.text_sj13);
                    TextView itextView14=view.findViewById(R.id.text_sj14);
                    TextView itextView15=view.findViewById(R.id.text_sj15);
                    itextView1.setText(""+user.getActive_day_number());
                    itextView2.setText(""+user.getAchievement_number());
                    itextView3.setText(""+user.getAvatar_number());
                    itextView4.setText(""+user.getWay_point_number());
                    itextView5.setText(""+user.getAnemoculus_number());
                    itextView6.setText(""+user.getGeoculus_number());
                    itextView7.setText(""+user.getElectroculus_number());
                    itextView8.setText(""+user.getDendroculus_number());
                    itextView9.setText(""+user.getDomain_number());
                    itextView10.setText(user.getSpiral_abyss());
                    itextView11.setText(""+user.getLuxurious_chest_number());
                    itextView12.setText(""+user.getPrecious_chest_number());
                    itextView13.setText(""+user.getExquisite_chest_number());
                    itextView14.setText(""+user.getCommon_chest_number());
                    itextView15.setText(""+user.getMagic_chest_number());

                }
                break;
            case R.layout.mylist_myjs:
                if (jsxx!=null){
                    RecyclerView recyclerView =view.findViewById(R.id.recy_js);
                    LinearLayout l1=view.findViewById(R.id.list_l1);
                    LinearLayoutManager layoutManager =new LinearLayoutManager(context);
                    layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                    recyclerView.setLayoutManager(layoutManager);
                    recy_Adpter_h_js adpter = new recy_Adpter_h_js(jsxx,context,uid);
                    recyclerView.setAdapter(adpter);
                    l1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent=new Intent(context, JsXq_Activity.class);
                            intent.putExtra("cuid",uid);
                            context.startActivity(intent);
                        }
                    });
                    if (layout[2]!=R.layout.bq_ltem){
                        LinearLayout lin=view.findViewById(R.id.lin_1);
                        lin.setVisibility(View.GONE);
                    }
                }
                break;
            case R.layout.new_bq:
                if(bq!=null&&bq.message.equals("OK")){
                    ArcSeekBar arcSeekBar1 = view.findViewById(R.id.arcSeekBar1);
//                    arcSeekBar1.setProgress();
                    arcSeekBar1.showAnimation(bq.data.current_resin, 3000);
                    TextView ywtime=view.findViewById(R.id.sytime);
                    time times=new time();
                    int b= Integer.parseInt(times.getHour());
                    int c=Integer.parseInt(times.getmini());
                    String i="";
                    if (bq.data.current_resin==160)
                        ywtime.setText("树脂溢出啦快上线吧");
                    else {
                        int hz=(160-bq.data.current_resin)*7;
                        c+=hz%60;
                        if (c>60){
                            b++;
                            c-=60;
                        }
                        b+=hz/60;
                        if (b>24){
                            b-=24;
                            i="次日";
                        }
                        String h= String.valueOf(hz/60);
                        String m= String.valueOf(hz%60);
                        if (h.length()==1)
                            h="0"+h;
                        if (m.length()==1)
                            m="0"+m;

                        String data="需要"+h+"小时"+m+"分钟"+"预计"+i+b+"点"+c+"分恢复完毕";
                        SpannableString spannableString = new SpannableString(data);
                        spannableString.setSpan(new ForegroundColorSpan(0xFFFB9D11), 2, 4, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                        spannableString.setSpan(new ForegroundColorSpan(0xFFFB9D11), 6, 8, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                        spannableString.setSpan(new ForegroundColorSpan(0xFFFB9D11), 12, 14, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                        spannableString.setSpan(new ForegroundColorSpan(0xFFFB9D11), 15, 17, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                        ywtime.setText(spannableString);
                    }
                    TextView shuzhi = view.findViewById(R.id.shuzhi);
                    String text=bq.data.current_resin + "/" + bq.data.max_resin;
                    SpannableString spannableString = new SpannableString(text);
                    ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(0xFFFB9D11);
                    AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(25, true);
                    spannableString.setSpan(foregroundColorSpan, 0,  String.valueOf(bq.data.current_resin).length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                    spannableString.setSpan(absoluteSizeSpan, 0, String.valueOf(bq.data.current_resin).length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                    shuzhi.setText(spannableString);
                    if (bq.data.current_resin == 160)
                        shuzhi.setTextColor(0xFFE6113C);
                    TextView btbq = view.findViewById(R.id.dtbq);
                    ArcSeekBar arcSeekBar2 = view.findViewById(R.id.arcSeekBar2);
                    arcSeekBar2.setMax(bq.data.max_home_coin);
                    arcSeekBar2.showAnimation(bq.data.current_home_coin, 3000);
                    TextView dt_time=view.findViewById(R.id.dtbq_time);
                    dt_time.setText("还需"+Integer.parseInt(bq.data.home_coin_recovery_time)/3600+"小时"+Integer.parseInt(bq.data.home_coin_recovery_time)%3600/60+"分钟");
                    btbq.setText(bq.data.current_home_coin + "/" + bq.data.max_home_coin);
                    ArcSeekBar arcSeekBar3 = view.findViewById(R.id.arcSeekBar3);
                    arcSeekBar3.showAnimation(bq.data.finished_task_num * 100, 3000);
                    TextView mr=view.findViewById(R.id.wt);
                    mr.setText(bq.data.finished_task_num+"/"+4);
                    TextView wtqk=view.findViewById(R.id.wtqk);
                    if (bq.data.finished_task_num<4)
                        wtqk.setText("还有任务未完成");
                    else wtqk.setText("委托已经完成");
                    ArcSeekBar arcSeekBar4 = view.findViewById(R.id.arcSeekBar4);
                    arcSeekBar4.showAnimation(bq.data.remain_resin_discount_num * 100, 3000);
                    TextView zb=view.findViewById(R.id.zb);
                    zb.setText(bq.data.remain_resin_discount_num+"/"+3);
                    TextView sy1=view.findViewById(R.id.sy);
                    if (bq.data.remain_resin_discount_num==3)
                        sy1.setText("本周已完成");
                    else sy1.setText("剩余"+(3-bq.data.remain_resin_discount_num)+'次');
                    TextView clzby=view.findViewById(R.id.clzby);
                    TextView clzby_time=view.findViewById(R.id.clzby_time);
                    if (bq.data.transformer.obtained){
                        ArcSeekBar arcSeekBar5 = view.findViewById(R.id.arcSeekBar5);
                        int time = bq.data.transformer.recovery_time.Day * 86400 + bq.data.transformer.recovery_time.Hour * 360 + bq.data.transformer.recovery_time.Minute * 60;
                        time = 518400 - time;
                        arcSeekBar5.showAnimation(time, 3000);
                        if (bq.data.transformer.recovery_time.reached){
                            clzby.setText("已就绪");
                            clzby_time.setText("已经冷却完毕");
                        }else {
                            clzby.setText("未就绪");
                            clzby_time.setText("剩余"+bq.data.transformer.recovery_time.Day+"天"+bq.data.transformer.recovery_time.Minute+"分钟");
                        }
                    }else clzby.setText("未获得");
                    int sy=0,flag=0;
                    TextView wt=view.findViewById(R.id.text_wt);
                    switch (bq.data.expeditions.size()) {
                        case 5:
                            ArcSeekBar arcSeekBar10 = view.findViewById(R.id.arcSeekBar10);
                            sy=Integer.parseInt(bq.data.expeditions.get(4).remained_time);
                            arcSeekBar10.showAnimation(72000 - sy, 3000);
                            ImageView i5=view.findViewById(R.id.imageView_5);
                            Glide.with(context).load(bq.data.expeditions.get(4).avatar_side_icon).into(i5);
                            TextView t5=view.findViewById(R.id.t5);
                            if (sy==0){
                                t5.setText("已探索完毕");
                                flag++;
                            }else {
                                t5.setText(sy/3600+"小时"+sy%3600/60+"分钟");
                            }

                        case 4:
                            ArcSeekBar arcSeekBar9 = view.findViewById(R.id.arcSeekBar9);
                            sy=Integer.parseInt(bq.data.expeditions.get(3).remained_time);
                            arcSeekBar9.showAnimation(72000 - sy, 3000);
                            ImageView i4=view.findViewById(R.id.imageView_4);
                            Glide.with(context).load(bq.data.expeditions.get(3).avatar_side_icon).into(i4);
                            TextView t4=view.findViewById(R.id.t4);
                            if (sy==0){
                                t4.setText("已探索完毕");
                                flag++;
                            }else {
                                t4.setText(sy/3600+"小时"+sy%3600/60+"分钟");
                            }
                        case 3:
                            ArcSeekBar arcSeekBar8 = view.findViewById(R.id.arcSeekBar8);
                            sy=Integer.parseInt(bq.data.expeditions.get(2).remained_time);
                            arcSeekBar8.showAnimation(72000 - sy, 3000);
                            ImageView i3=view.findViewById(R.id.imageView_3);
                            Glide.with(context).load(bq.data.expeditions.get(2).avatar_side_icon).into(i3);
                            TextView t3=view.findViewById(R.id.t3);
                            if (sy==0){
                                t3.setText("已探索完毕");
                                flag++;
                            }else {
                                t3.setText(sy/3600+"小时"+sy%3600/60+"分钟");
                            }
                        case 2:
                            ArcSeekBar arcSeekBar7 = view.findViewById(R.id.arcSeekBar7);
                            sy=Integer.parseInt(bq.data.expeditions.get(1).remained_time);
                            arcSeekBar7.showAnimation(72000 - sy, 3000);
                            ImageView i2=view.findViewById(R.id.imageView_2);
                            Glide.with(context).load(bq.data.expeditions.get(1).avatar_side_icon).into(i2);
                            TextView t2=view.findViewById(R.id.t2);
                            if (sy==0){
                                t2.setText("已探索完毕");
                                flag++;
                            }else {
                                t2.setText(sy/3600+"小时"+sy%3600/60+"分钟");
                            }
                        case 1:
                            ArcSeekBar arcSeekBar6 = view.findViewById(R.id.arcSeekBar6);
                            sy=Integer.parseInt(bq.data.expeditions.get(0).remained_time);
                            arcSeekBar6.showAnimation(72000 -sy, 3000);
                            ImageView i1=view.findViewById(R.id.imageView_1);
                            Glide.with(context).load(bq.data.expeditions.get(0).avatar_side_icon).into(i1);
                            TextView t1=view.findViewById(R.id.t1);
                            if (sy==0){
                                t1.setText("已探索完毕");
                                flag++;
                            }else {
                                t1.setText(sy/3600+"小时"+sy%3600/60+"分钟");
                            }
                    }
                    wt.setText("委托派遣"+flag+"/"+bq.data.expeditions.size());
                }
                break;
            case R.layout.mylist_cgh:
                if(cgh!=null){
                    TextView ctextView1=view.findViewById(R.id.name_cgh);
                    TextView ctextView2=view.findViewById(R.id.level);
                    TextView ctextView3=view.findViewById(R.id.l2);
                    TextView ctextView4=view.findViewById(R.id.l3);
                    TextView ctextView5=view.findViewById(R.id.l4);
                    ctextView1.setText(cgh.getL5());
                    ctextView2.setText(""+cgh.getLevel());
                    ctextView3.setText(""+cgh.getL3());
                    ctextView4.setText(""+cgh.getL4());
                    ctextView5.setText(""+cgh.getL2());
                }
                else
                {
                    TextView btextView1=view.findViewById(R.id.name_cgh);
                    btextView1.setText("未获得尘歌壶");
                }
                break;
            case R.layout.word:{
                if(word!=null){
                    RecyclerView recyclerView1 =view.findViewById(R.id.recy_word);
                    LinearLayoutManager layoutManager =new LinearLayoutManager(context);
                    layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                    recyclerView1.setLayoutManager(layoutManager);
                    WordAdpter wordAdpter=new WordAdpter(word,context);
                    HashMap<String, Integer> stringIntegerHashMap = new HashMap<>();
                    stringIntegerHashMap.put(Recy_item_jj.LEFT_DECORATION,15);
                    recyclerView1.addItemDecoration(new Recy_item_jj(stringIntegerHashMap));
                    recyclerView1.setAdapter(wordAdpter);
                }

            }
            break;
            case R.layout.sy:{
                if (user!=null){


                TextView textView=view.findViewById(R.id.sysysy);
                textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(context, Sy_Activity.class);
                                context.startActivity(intent);
                    }
                });
            }
            }

        }
        return view;
    }
}
