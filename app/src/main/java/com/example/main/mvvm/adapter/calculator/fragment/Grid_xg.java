package com.example.main.mvvm.adapter.calculator.fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.main.R;

public class Grid_xg extends BaseAdapter {
    Context context;
    String[] data2=new String[]{"换把称手的武器吧","逆天改命","换套圣遗物"};
    int[] data=new int[]{R.drawable.wq,R.drawable.ys_1,R.drawable.syw_title_ft_1};
    public Grid_xg(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view= LayoutInflater.from(context).inflate(R.layout.xg_item,parent,false);
        TextView t1=view.findViewById(R.id.sy_name);
        t1.setText(data2[position]);
        ImageView i1=view.findViewById(R.id.imageView18);
        i1.setImageResource(data[position]);
        return view;
    }
}
