package com.example.main.raw.Adpter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.example.main.raw.Class_Custom.wh.Name_img;
import com.example.main.R;

import java.util.List;

public class Ck_list_Adpter extends BaseAdapter {
    int s; Context context; List<String> five; List<Integer> list_jsq; int sy,log;
    String img;
    Name_img name_img=new Name_img();

    public Ck_list_Adpter(int s, Context context, List<String> five, List<Integer> list_jsq, int sy,int log) {
        this.s = s;
        this.context = context;
        this.five = five;
        this.list_jsq = list_jsq;
        this.sy = sy;
        this.log=log;
    }

    @Override
    public int getCount() {
        return s+1;
    }

    @Override
    public Object getItem(int position) {
        return five.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view= LayoutInflater.from(context).inflate(R.layout.ck_item,parent,false);
        ProgressBar progressBar=view.findViewById(R.id.progress_ck);
        TextView textView=view.findViewById(R.id.text_ck_item);
        ImageView wai=view.findViewById(R.id.wai);
        wai.setVisibility(View.INVISIBLE);

        if (position==0){
            progressBar.setProgress(sy);
            textView.setText("已垫"+sy+"抽");
            ImageView imageView=view.findViewById(R.id.img_ck_item);
            imageView.setImageResource(R.drawable.os_pm3);
            if (sy>70)
                progressBar.setProgressDrawable(context.getResources().getDrawable(R.drawable.jdt_red));
            else
            if (sy>50)
                progressBar.setProgressDrawable(context.getResources().getDrawable(R.drawable.jdt_yello));

            return view;
        }
        if (position==s){
            progressBar.setProgress(list_jsq.get(log));
            textView.setText(list_jsq.get(log)+"抽");
           img= name_img.zh(five.get(position-1+log));
           String url = getString(position);
            if (five.get(position-1+log).equals("琴")||five.get(position-1+log).equals("迪卢克")||five.get(position-1+log).equals("七七")||five.get(position-1+log).equals("刻晴")||five.get(position-1+log).equals("莫娜")||five.get(position-1+log).equals("提纳里"))
                wai.setVisibility(View.VISIBLE);
            ImageView imageView=view.findViewById(R.id.img_ck_item);
                      Glide.with(context)
                    .load(url)
                    .fitCenter()
                    .error(R.drawable.md_zy_kl)
                    .placeholder(R.drawable.md_zy_kl)
//                .transform(new RoundedCorners(12))
                    .into(imageView);
            Log.d("TAGCSS",url);

            if (list_jsq.get(log)>70)
                progressBar.setProgressDrawable(context.getResources().getDrawable(R.drawable.jdt_red));
            else
            if (list_jsq.get(log)>50)
                progressBar.setProgressDrawable(context.getResources().getDrawable(R.drawable.jdt_yello));
            return view;
        }
        img= name_img.zh(five.get(position-1+log));
        String url = getString(position);
        if (five.get(position-1+log).equals("琴")||five.get(position-1+log).equals("迪卢克")||five.get(position-1+log).equals("七七")||five.get(position-1+log).equals("刻晴")||five.get(position-1+log).equals("莫娜")||five.get(position-1+log).equals("提纳里"))
            wai.setVisibility(View.VISIBLE);
        progressBar.setProgress(list_jsq.get(position+log));
        textView.setText(list_jsq.get(position+log)+"抽");
        if (list_jsq.get(position+log)>70)
            progressBar.setProgressDrawable(context.getResources().getDrawable(R.drawable.jdt_red));
        else
            if (list_jsq.get(position+log)>50)
                progressBar.setProgressDrawable(context.getResources().getDrawable(R.drawable.jdt_yello));
        ImageView imageView=view.findViewById(R.id.img_ck_item);
                 Glide.with(context)
                .load(url)
                .fitCenter()
                .error(R.drawable.md_zy_kl)
                .placeholder(R.drawable.md_zy_kl)
//                .transform(new RoundedCorners(12))
                .into(imageView);

//        imageView.setImageResource();
        return view;
    }

    @NonNull
    private String getString(int position) {
        String url;
        if (img.contains("enka")) {
            img = img.replaceAll("enka_", "");
            url = "https://enka.network/ui/UI_AvatarIcon_" + img + ".png";
        } else
            url = "https://upload-bbs.mihoyo.com/game_record/genshin/character_icon/UI_AvatarIcon_" + img + ".png";
        if (img.equals("xxx")) {
            img = name_img.wq(five.get(position -1+log));
            if (img.contains("UI_"))
                url = "https://enka.network/ui/" + img + ".png";
            else
                url = "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_EquipIcon" + img + ".png";
        }
        return url;
    }
}
