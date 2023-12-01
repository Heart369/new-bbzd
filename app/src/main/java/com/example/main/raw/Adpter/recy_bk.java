package com.example.main.raw.Adpter;

import android.content.Context;
import android.content.Intent;
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
import com.example.main.mvvm.ys_bk.Detail_Pages_Activity;
import com.example.main.raw.ys_bk.js_data;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class recy_bk extends RecyclerView.Adapter<recy_bk.viewholde> {
    Context context;
    List<js_data> data;
    static int pos=0;

    public recy_bk(Context context, List<js_data> data) {
        this.context = context;
        this.data = data;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void setData(List<js_data> data) {
        this.data = data;
        List<js_data> dataSorted1;
        dataSorted1 = data.stream()
                .sorted(Comparator.comparing(js_data::getStar).reversed())
                .collect(Collectors.toList());
        this.data=dataSorted1;
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
        recy_bk.viewholde d=new  recy_bk.viewholde(view);
        return d;
    }

    @Override
    public void onBindViewHolder(@NonNull viewholde holder, int position) {
        Glide.with(context)
                .load(data.get(position).getIcon())
                .fitCenter()
                .error(R.drawable.os_kl_cs)
                .placeholder(R.drawable.os_kl_cs)
                .transform(new RoundedCorners(15))
                .into(holder.image_js);

        int back=0;
        if (data.get(position).getStar()==5){
            back=R.drawable.five_back_back;
            holder.xj.setImageResource(R.drawable.icon_5);
        }
        else{
            back=R.drawable.four_back_back;
            holder. xj.setImageResource(R.drawable.icon_4);
        }
        switch (data.get(position).getElement()){
            case "草":
                holder. ys.setImageResource(R.drawable.ys_c);
                break;
            case "水":
                holder. ys.setImageResource(R.drawable.ys_s);
                break;
            case "火":
                holder. ys.setImageResource(R.drawable.ys_h);
                break;
            case "冰":
                holder. ys.setImageResource(R.drawable.ys_b);
                break;
            case "雷":
                holder. ys.setImageResource(R.drawable.ys_l);
                break;
            case "岩":
                holder. ys.setImageResource(R.drawable.ys_y);
                break;
            case "风":
                holder.ys.setImageResource(R.drawable.ys_f);
                break;
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
        holder.lx.setText("武器类型:"+data.get(position).getWq());
        Glide.with(context)
                .load(data.get(position).getImage1())
                .fitCenter()
                .error(R.drawable.ddly_cs)
                .placeholder(R.drawable.ddly_cs)
                .into(  holder.lh);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("TAG",holder.name.getText().toString());
                Intent intent=new Intent(context, Detail_Pages_Activity.class);
                intent.putExtra("name",holder.name.getText().toString());
                context.startActivity(intent);
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
