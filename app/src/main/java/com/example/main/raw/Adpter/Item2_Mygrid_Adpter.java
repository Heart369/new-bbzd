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

public class Item2_Mygrid_Adpter extends BaseAdapter {
    List<Sy.DataDTO.FloorsDTO.LevelsDTO.BattlesDTO.AvatarsDTO> getAvatars;
    List<Sy.DataDTO.FloorsDTO.LevelsDTO.BattlesDTO.AvatarsDTO> getAvatars2;
    Context context;

    public Item2_Mygrid_Adpter(List<Sy.DataDTO.FloorsDTO.LevelsDTO.BattlesDTO.AvatarsDTO> getAvatars, List<Sy.DataDTO.FloorsDTO.LevelsDTO.BattlesDTO.AvatarsDTO> avatars, Context context) {
        this.getAvatars = getAvatars;
        this.context = context;
        this.getAvatars2=avatars;
    }

    @Override
    public int getCount() {
        return 8;
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
        viewHolder holder;
        if (convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.jsxq_sy,parent,false);
            holder=new viewHolder();
            holder.imageView=convertView.findViewById(R.id.img_jsxq_sy);
            holder.textView=convertView.findViewById(R.id.level_sy);
            convertView.setTag(holder);
        }else holder= (viewHolder) convertView.getTag();
        if (position<4){
            Glide.with(context)
                    .load(getAvatars.get(position).getIcon())
                    .fitCenter()
                    .error(R.drawable.md_zy_kl)
                    .placeholder(R.drawable.md_zy_kl)
                    .into(holder.imageView);
            holder.textView.setText("LV."+getAvatars.get(position).getLevel());
            if (getAvatars.get(position).getRarity()==5)
                holder.imageView.setBackground(context.getDrawable(R.drawable.five_back));
            else   holder.imageView.setBackground(context.getDrawable(R.drawable.fuor_os_back));
            return convertView;
        }
        else {
            Glide.with(context)
                    .load(getAvatars2.get(position-4).getIcon())
                    .fitCenter()
                    .error(R.drawable.md_zy_kl)
                    .placeholder(R.drawable.md_zy_kl)
                    .into(holder.imageView);
            holder.textView.setText("LV."+getAvatars2.get(position-4).getLevel());
            if (getAvatars2.get(position-4).getRarity()==5)
                holder.imageView.setBackground(context.getDrawable(R.drawable.five_back));
            else   holder.imageView.setBackground(context.getDrawable(R.drawable.fuor_os_back));
            return convertView;
        }

    }
    static class viewHolder{
        ImageView imageView;
        TextView textView;
    }
}
