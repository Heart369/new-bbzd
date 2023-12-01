package com.example.main.raw.Adpter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.main.raw.activity.BottomArcActivity;
import com.example.main.R;

public class recy_Adpter_h_js extends RecyclerView.Adapter<recy_Adpter_h_js.ViewHolder> {
    String[] jsxx;
    Context context;
    String uid;
    public recy_Adpter_h_js(String[] jsxx, Context context,String uid) {
        this.jsxx = jsxx;
        this.context = context;
        this.uid=uid;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.js_item,parent,false);
        recy_Adpter_h_js.ViewHolder d = new recy_Adpter_h_js.ViewHolder(view);
        return d;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Glide.with(context)
                .load("https://upload-bbs.mihoyo.com/game_record/genshin/character_card_icon/UI_AvatarIcon_"+jsxx[position]+"_Card.png")
                .fitCenter()
                .error(R.drawable.os_kkl)
                .placeholder(R.drawable.os_kkl)
//                .transform(new RoundedCorners(12))
                .into(holder.imageView);
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, BottomArcActivity.class);
                intent.putExtra("page",holder.getAdapterPosition());
                if (uid.equals("0"))
                    intent.putExtra("cuid","ss");
                else
                intent.putExtra("cuid",uid);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return jsxx.length;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.jsxx);
        }
    }
}
