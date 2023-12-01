package com.example.main.raw.ys_bk;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.example.main.R;

import java.util.List;

public class list_adapter extends BaseAdapter {
    Context context;
    List<js_data> data;
    View view;
    int po=0;

    public list_adapter(Context context, List<js_data> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (position==0){
            view= LayoutInflater.from(context).inflate(R.layout.toobar,parent,false);
            return view;
        }
          position=position-1;
        view= LayoutInflater.from(context).inflate(R.layout.js_wq_item,parent,false);
        po=position;
        ImageView image_js=view.findViewById(R.id.image_js);
        Glide.with(context)
                .load(data.get(position).getIcon())
                .fitCenter()
                .error(R.drawable.os_kl_cs)
                .placeholder(R.drawable.os_kl_cs)
                .transform(new RoundedCorners(15))
                .into(image_js);
        int back=0;
        ImageView xj,ys;
        xj=view.findViewById(R.id.icon_xj);
        ys=view.findViewById(R.id.ys);
        if (data.get(position).getStar()==5){
            back=R.drawable.five_back_back;
            xj.setImageResource(R.drawable.icon_5);
        }
        else{
            back=R.drawable.four_back_back;
            xj.setImageResource(R.drawable.icon_4);
        }
        switch (data.get(position).getElement()){
            case "草":
                ys.setImageResource(R.drawable.ys_c);
                break;
            case "水":
                ys.setImageResource(R.drawable.ys_s);
                break;
            case "火":
                ys.setImageResource(R.drawable.ys_h);
                break;
            case "冰":
                ys.setImageResource(R.drawable.ys_b);
                break;
            case "雷":
                ys.setImageResource(R.drawable.ys_l);
                break;
            case "岩":
                ys.setImageResource(R.drawable.ys_y);
                break;
            case "风":
                ys.setImageResource(R.drawable.ys_f);
                break;
        }
        Glide.with(context)
                .load(back)
                .transform(new RoundedCorners(15))
                .into(new SimpleTarget<Drawable>() {
                    @Override
                    public void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
                        image_js.setBackground(resource);
                    }
                });
        TextView name=view.findViewById(R.id.js_name),lx=view.findViewById(R.id.lx);
        name.setText(data.get(position).getName());
        lx.setText("武器类型:"+data.get(position).getWq());
        ImageView lh=view.findViewById(R.id.lh);
        Glide.with(context)
                .load(data.get(position).getImage1())
                .fitCenter()
                .error(R.drawable.ddly_cs)
                .placeholder(R.drawable.ddly_cs)
                .into(lh);
        return view;
    }
    public int gettop(){
        return view.getTop();
    }
}
