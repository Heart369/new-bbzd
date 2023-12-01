package com.example.main.mvvm.adapter.calculator;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.example.main.R;
import com.example.main.mvvm.calculator.role.Obj_calculator;
import com.example.main.raw.Class_Custom.wh.Jsdy_t;
import com.example.main.raw.interface_.OnRecyclerItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class Calculator_adapter extends RecyclerView.Adapter<Calculator_adapter.ViewHolder> {
    Context context;
    List<Obj_calculator> obj;
    int flag=0;
    OnRecyclerItemClickListener onRecyclerItemClickListener;
    public Calculator_adapter(Context context, List<Obj_calculator> obj, OnRecyclerItemClickListener onRecyclerItemClickListener) {
        this.context = context;
        this.obj = obj;
        this.onRecyclerItemClickListener=onRecyclerItemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.calculator_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        List<String> sb=new ArrayList<>();
        sb.add(String.valueOf(obj.get(position).getJszsg_fb().avatarId));
        Jsdy_t jsdy_t=new Jsdy_t(sb);
        String[] sb2=jsdy_t.js();
        String sb3=sb2[0];
        if (sb3.contains("enka"))
            sb3=sb3.replaceAll("enka","");
        Glide.with(context)
                .load("https://enka.network/ui/UI_AvatarIcon_"+sb3+".png")
                .fitCenter()
                .error(R.drawable.ic_launcher_background)
                .transform(new RoundedCorners(100))
                .into(holder.i1);
        if (position==flag){
            holder.i1.setBackground(context.getDrawable(R.drawable.jsmzdj));
        }else  holder.i1.setBackground(context.getDrawable(R.drawable.jsmz));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position!=flag){
                    flag=position;
                    notifyDataSetChanged();
                    onRecyclerItemClickListener.onItemClick(v,position);
                }


            }
        });
    }

    public void setFlag(int flag) {
        this.flag = flag;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return obj.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView i1 ;
    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        i1= itemView.findViewById(R.id.image_tx);

    }
}
}
