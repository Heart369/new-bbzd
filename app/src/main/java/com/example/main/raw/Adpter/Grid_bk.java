package com.example.main.raw.Adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

import com.example.main.R;

public class Grid_bk extends BaseAdapter {
    String[] name;
    int[] image;
    Context context;
    getClick getClick;
    int i=-1;

    public void setI(int i) {
        this.i = i;
    }

    public Grid_bk(String[] name, int[] image, Context context, Grid_bk.getClick getClick) {
        this.name = name;
        this.image = image;
        this.context = context;
        this.getClick = getClick;
    }

    @Override
    public int getCount() {
        return name.length;
    }

    @Override
    public Object getItem(int position) {
        return name[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v=  LayoutInflater.from(context).inflate(R.layout.bk_sx,parent,false);
        TextView textView=v.findViewById(R.id.text_bk);
        ImageView imageView=v.findViewById(R.id.imageView2);
        textView.setText(" "+name[position]+" ");
        imageView.setImageResource(image[position]);
        if (position==i){
            CardView cardView=v.findViewById(R.id.card_bk);
            cardView.setCardBackgroundColor(0xFFF3EC74);
        }
        return v;
    }

    public void setName(String[] name) {
        this.name = name;
    }

    public void setImage(int[] image) {
        this.image = image;
    }

    public interface getClick{
        public void getname(String name);
    }
}
