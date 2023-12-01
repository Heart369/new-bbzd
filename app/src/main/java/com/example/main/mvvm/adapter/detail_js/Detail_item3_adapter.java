package com.example.main.mvvm.adapter.detail_js;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.example.main.R;
import com.example.main.mvvm.json.Detail_mz;

public class Detail_item3_adapter extends BaseAdapter {
    Detail_mz mz;
    Context context;

    public Detail_item3_adapter(Detail_mz mz, Context context) {
        this.mz = mz;
        this.context = context;
    }

    @Override
    public int getCount() {
        return 6;
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
//        if (convertView==null){
//            convertView= LayoutInflater.from(context).inflate(R.layout.detail_item3_item,parent,false);
//        }
        View convertView1= LayoutInflater.from(context).inflate(R.layout.detail_item3_item,parent,false);
        Detail_mz.C1DTO cz = null;
        String image=null;
        TextView name=convertView1.findViewById(R.id.mz_name);
        TextView mz_ms=convertView1.findViewById(R.id.mz_ms);
        ImageView tb=convertView1.findViewById(R.id.mz_tb);
        switch (position){
            case 0:
                cz= mz.c1;
                image=mz.images.c1;
                break;
            case 1:
                cz= mz.c2;
                image=mz.images.c2;
                break;
            case 2:
                cz= mz.c3;
                image=mz.images.c3;
                break;
            case 3:
                cz= mz.c4;
                image=mz.images.c4;
                break;
            case 4:
                cz= mz.c5;
                image=mz.images.c5;
                break;
            case 5:
                cz= mz.c6;
                image=mz.images.c6;
                break;
        }
        name.setText(cz.name);
        mz_ms.setText(cz.effect);
        image=image.replace("-os","");
        Glide.with(context)
                .load(image)
                .fitCenter()
                .error(R.drawable.ys_s)
                .placeholder(R.drawable.ic_launcher_background)
                .transform(new RoundedCorners(12))
                .into(tb);

        return convertView1;
    }
}
