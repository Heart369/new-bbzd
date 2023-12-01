package com.example.main.raw.Adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.main.raw.JsonPares.Sy;
import com.example.main.R;

import java.util.List;

public class MyGrid_Sy_Adpter extends BaseAdapter {
    List<Sy.DataDTO.RevealRankDTO> reveal_rank;
    Context context;

    public MyGrid_Sy_Adpter(List<Sy.DataDTO.RevealRankDTO> reveal_rank, Context context) {
        this.reveal_rank = reveal_rank;
        this.context = context;
    }

    @Override
    public int getCount() {
        return reveal_rank.size();
    }

    @Override
    public Object getItem(int position) {
        return reveal_rank.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        viewHolder holder;
        if (convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.jsxq_sy,parent,false);
            holder=new viewHolder();
            holder.imageView=convertView.findViewById(R.id.img_jsxq_sy);
            holder.textView=convertView.findViewById(R.id.level_sy);
            convertView.setTag(holder);
        }else holder= (viewHolder) convertView.getTag();
        Glide.with(context)
                .load(reveal_rank.get(position).getAvatar_icon())
                .fitCenter()
                .error(R.drawable.md_zy_kl)
                .placeholder(R.drawable.md_zy_kl)
                .into(holder.imageView);
        holder.textView.setText(reveal_rank.get(position).getValue()+"次");
        if (reveal_rank.get(position).getRarity()==5)
            holder.imageView.setBackground(context.getDrawable(R.drawable.five_back));
        else   holder.imageView.setBackground(context.getDrawable(R.drawable.fuor_os_back));
        return convertView;
    }
    static class viewHolder{
        ImageView imageView;
        TextView textView;
    }
}
