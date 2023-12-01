package com.example.main.raw.Adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.main.raw.Class_Custom.wh.Name_img;
import com.example.main.R;

import java.util.List;

public class Ck_grid extends BaseAdapter {
    Context context;
    List<String> name;
    List<Integer> cs;

    public Ck_grid(Context context, List<String> name, List<Integer> cs) {
        this.context = context;
        this.name = name;
        this.cs = cs;
    }

    @Override
    public int getCount() {
        return name.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.jsxq_sy, parent, false);
        ImageView imageView = view.findViewById(R.id.img_jsxq_sy);
        TextView textView = view.findViewById(R.id.level_sy);
        textView.setText("" + cs.get(position));
        Name_img name_img = new Name_img();
        String url = null;
        String image = name_img.zh(name.get(position));
        if (image.contains("enka")) {
            image = image.replaceAll("enka_", "");
            url = "https://enka.network/ui/UI_AvatarIcon_" + image + ".png";
        } else
            url = "https://upload-bbs.mihoyo.com/game_record/genshin/character_icon/UI_AvatarIcon_" + image + ".png";
        if (image.equals("xxx")) {
            image = name_img.wq(name.get(position));
            if (image.contains("UI_"))
                url = "https://enka.network/ui/" + image + ".png";
            else
                url = "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_EquipIcon" + image + ".png";
        }
        Glide.with(context)
                .load(url)
                .fitCenter()
                .error(R.drawable.md_zy_kl)
                .placeholder(R.drawable.md_zy_kl)
//                .transform(new RoundedCorners(12))
                .into(imageView);

        return view;
    }
}
