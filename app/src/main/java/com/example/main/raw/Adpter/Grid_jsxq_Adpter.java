package com.example.main.raw.Adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.main.raw.JsonPares.JxJs;
import com.example.main.R;

import java.util.List;

public class Grid_jsxq_Adpter extends BaseAdapter {
    JxJs jxJs;
    Context context;
    JxJs.DataDTO dataDTO;
    List<JxJs.DataDTO.AvatarsDTO> data;

    public Grid_jsxq_Adpter(JxJs jxJs, Context context) {
        this.jxJs = jxJs;
        this.context = context;
        dataDTO= jxJs.getData();
        data=dataDTO.getAvatars();
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
        viewHolder holder;
        if (convertView==null)
        {
            convertView= LayoutInflater.from(context).inflate(R.layout.jsxq_item,parent,false);
            holder=new viewHolder();
            holder.jsxq=convertView.findViewById(R.id.img_jsxq);
            holder.ys=convertView.findViewById(R.id.ys);
            holder.name=convertView.findViewById(R.id.jsname);
            holder.dj=convertView.findViewById(R.id.level);
            holder.mz=convertView.findViewById(R.id.mz);
            convertView.setTag(holder);
        }
        else holder= (viewHolder) convertView.getTag();
        Glide.with(context)
                .load(data.get(position).getImage())
                .fitCenter()
                .error(R.drawable.md_zy_kl)
                .placeholder(R.drawable.md_zy_kl)
                .into(holder.jsxq);
        if (data.get(position).getRarity()==5)
        holder.jsxq.setBackground(context.getDrawable(R.drawable.five_back));
        else   holder.jsxq.setBackground(context.getDrawable(R.drawable.fuor_os_back));
        holder.dj.setText("LV."+data.get(position).getLevel());
        holder.mz.setText(""+data.get(position).getActived_constellation_num());
        holder.name.setText(data.get(position).getName());
        switch (data.get(position).getElement()){
            case "Geo":
                holder.ys.setImageResource(R.drawable.ys_y);
                break;
            case "Hydro":
                holder.ys.setImageResource(R.drawable.ys_s);
                break;
            case "Pyro":
                holder.ys.setImageResource(R.drawable.ys_h);
                break;
            case "Cryo":
                holder.ys.setImageResource(R.drawable.ys_b);
                break;
            case "Electro":
                holder.ys.setImageResource(R.drawable.ys_l);
                break;
            case "Anemo":
                holder.ys.setImageResource(R.drawable.ys_f);
                break;
            case "Dendro":
                holder.ys.setImageResource(R.drawable.ys_c);
                break;
        }
        return convertView;
    }
    static class viewHolder{
        ImageView jsxq,ys;
        TextView name,dj,mz;
    }

}
