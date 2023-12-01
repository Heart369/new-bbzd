package com.example.main.raw.Adpter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.example.main.R;
import com.example.main.raw.ys_bk.syw_data;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class recy_bk_syw extends RecyclerView.Adapter<recy_bk_syw.viewholde> {
    Context context;
    List<syw_data> data;
    static int pos=0;
    public recy_bk_syw(Context context, List<syw_data> data) {
        this.context = context;
        this.data = data;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void setData(List<syw_data> data) {
        List<syw_data> dataSorted;
        dataSorted = data.stream()
                .sorted(Comparator.comparing(syw_data::getStart).reversed())
                .collect(Collectors.toList());
        this.data=dataSorted;
    }

    @Override
    public int getItemViewType(int position) {
        pos =position;
        return position;
    }

    @NonNull
    @Override
    public viewholde onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view= LayoutInflater.from(context).inflate(R.layout.js_wq_item,parent,false);
        recy_bk_syw.viewholde d=new  recy_bk_syw.viewholde(view);
        return d;
    }

    @Override
    public void onBindViewHolder(@NonNull viewholde holder, int position) {
        Glide.with(context)
                .load("https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_"+data.get(position).getId()+"_4.png")
                .fitCenter()
                .error(R.drawable.os_kl_cs)
                .placeholder(R.drawable.os_kl_cs)
                .transform(new RoundedCorners(15))
                .into(holder.image_js);

        int back=0;
        if (data.get(position).getStart()==5){
            back=R.drawable.five_back_back;
            holder.xj.setImageResource(R.drawable.icon_5);
        }
        else if (data.get(position).getStart()==4){
            back=R.drawable.four_back_back;
            holder. xj.setImageResource(R.drawable.icon_4);
        }else if (data.get(position).getStart()==3){
            back=R.drawable.there_back_back;
            holder. xj.setImageResource(R.drawable.icon_3);
        }else  if (data.get(position).getStart()==2){
            back=R.drawable.tow_back_back;
            holder. xj.setImageResource(R.drawable.icon_3);
        }else {
            back=R.drawable.one_back_back;
            holder. xj.setImageResource(R.drawable.icon_3);
        }
        Glide.with(context)
                .load(back)
                .transform(new RoundedCorners(15))
                .into(new SimpleTarget<Drawable>() {
                    @Override
                    public void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
                        holder.image_js.setBackground(resource);
                    }
                });
        holder.name.setText(data.get(position).getName());
        holder.lx.setText(data.get(position).getTAG());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("TAG",holder.name.getText().toString());
//                Intent intent=new Intent(context, Detail_Pages_Activity.class);
//                context.startActivity(intent);
            }
        });
    }
    
    @Override
    public int getItemCount() {
        return data.size();
    }

    static class viewholde extends RecyclerView.ViewHolder {
        ImageView image_js;
        ImageView xj,ys,lh;
        TextView name,lx;
        public viewholde(@NonNull View itemView) {
            super(itemView);
          image_js=itemView.findViewById(R.id.image_js);
          xj=itemView.findViewById(R.id.icon_xj);
          ys=itemView.findViewById(R.id.ys);
          name=itemView.findViewById(R.id.js_name);
          lx=itemView.findViewById(R.id.lx);
           lh=itemView.findViewById(R.id.lh);

        }
    }

}
