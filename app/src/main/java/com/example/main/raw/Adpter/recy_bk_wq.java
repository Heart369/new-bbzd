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
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.example.main.R;
import com.example.main.mvvm.ys_bk.Detail_Wq_Activity;
import com.example.main.raw.ys_bk.wq_data;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class recy_bk_wq extends RecyclerView.Adapter<recy_bk_wq.viewholde> {
    Context context;
    List<wq_data> data;
    static int pos = 0;

    public recy_bk_wq(Context context, List<wq_data> data) {
        this.context = context;
        this.data = data;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void setData(List<wq_data> data) {
        List<wq_data> dataSorted;
        dataSorted = data.stream()
                .sorted(Comparator.comparing(wq_data::getStar).reversed())
                .collect(Collectors.toList());
        this.data = dataSorted;

    }

    @Override
    public int getItemViewType(int position) {
        pos = position;
        return position;
    }

    @NonNull
    @Override
    public viewholde onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(context).inflate(R.layout.js_wq_item, parent, false);
        recy_bk_wq.viewholde d = new recy_bk_wq.viewholde(view);
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

        int back = 0;
        if (data.get(position).getStar() == 5) {
            back = R.drawable.five_back_back;
            holder.xj.setImageResource(R.drawable.icon_5);
        } else if (data.get(position).getStar() == 4) {
            back = R.drawable.four_back_back;
            holder.xj.setImageResource(R.drawable.icon_4);
        } else if (data.get(position).getStar() == 3) {
            back = R.drawable.there_back_back;
            holder.xj.setImageResource(R.drawable.icon_3);
        } else if (data.get(position).getStar() == 2) {
            back = R.drawable.tow_back_back;
            holder.xj.setImageResource(R.drawable.icon_2);
        } else {
            back = R.drawable.one_back_back;
            holder.xj.setImageResource(R.drawable.xx);
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
        holder.lx.setText("武器类型:" + data.get(position).getWq());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (data.get(holder.getAdapterPosition()).getStar()<=2){
                    Toast.makeText(context, "低于2星暂无法查询", Toast.LENGTH_SHORT).show();
                    return;
                }
                Log.d("TAG", holder.name.getText().toString());
                Intent intent = new Intent(context, Detail_Wq_Activity.class);
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
        ImageView xj, ys, lh;
        TextView name, lx;

        public viewholde(@NonNull View itemView) {
            super(itemView);
//            if (pos==0||pos==1)
//                return;
            image_js = itemView.findViewById(R.id.image_js);
            xj = itemView.findViewById(R.id.icon_xj);
            ys = itemView.findViewById(R.id.ys);
            name = itemView.findViewById(R.id.js_name);
            lx = itemView.findViewById(R.id.lx);
            lh = itemView.findViewById(R.id.lh);

        }
    }

}
