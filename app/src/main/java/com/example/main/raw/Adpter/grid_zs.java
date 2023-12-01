package com.example.main.raw.Adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.main.raw.DataClass.Jswqdata;
import com.example.main.R;

import java.util.List;

public class grid_zs extends BaseAdapter {
    List<Jswqdata> js;
    Context context;

    //Gridview的适配器
    public grid_zs(List<Jswqdata> js, Context context) {
        this.js = js;
        this.context = context;
    }

    @Override
    public int getCount() {
        return js.size();
    }

    @Override
    public Object getItem(int position) {
        return js.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.zx_item, parent, false);
        TextView textView = view.findViewById(R.id.name);
        ImageView imageView = view.findViewById(R.id.img_js);
        textView.setText(js.get(position).getName());
        if (js.get(position).getImg().contains("enka")) {
            if (js.get(position).getLx() == 1)
                Glide.with(context)
                        .load("https://enka.network/ui/UI_AvatarIcon_" + js.get(position).getImg().replace("enka","") + ".png")
                        .fitCenter()
                        .error(R.drawable.md_zy_kl)
                        .placeholder(R.drawable.md_zy_kl)
//                .transform(new RoundedCorners(12))
                        .into(imageView);
            else Glide.with(context)
                    .load("https://enka.network/ui/UI_EquipIcon" + js.get(position).getImg().replace("enka","") + ".png")
                    .fitCenter()
                    .error(R.drawable.md_zy_kl)
                    .placeholder(R.drawable.md_zy_kl)
//                .transform(new RoundedCorners(12))
                    .into(imageView);
        } else if (js.get(position).getLx() == 1)
            Glide.with(context)
                    .load("https://upload-bbs.mihoyo.com/game_record/genshin/character_icon/UI_AvatarIcon_" + js.get(position).getImg() + ".png")
                    .fitCenter()
                    .error(R.drawable.md_zy_kl)
                    .placeholder(R.drawable.md_zy_kl)
//                .transform(new RoundedCorners(12))
                    .into(imageView);
        else Glide.with(context)
                    .load("https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_EquipIcon" + js.get(position).getImg() + ".png")
                    .fitCenter()
                    .error(R.drawable.md_zy_kl)
                    .placeholder(R.drawable.md_zy_kl)
//                .transform(new RoundedCorners(12))
                    .into(imageView);
        if (js.get(position).getStart() == 5)
            imageView.setBackgroundResource(R.drawable.five_back_back);
        else if (js.get(position).getStart() == 4)
            imageView.setBackgroundResource(R.drawable.four_back_back);
        else if (js.get(position).getStart() == 3)
            imageView.setBackgroundResource(R.drawable.there_back_back);
        else if (js.get(position).getStart() == 2)
            imageView.setBackgroundResource(R.drawable.tow_back_back);
        else
            imageView.setBackgroundResource(R.drawable.one_back_back);
        return view;
    }
}
