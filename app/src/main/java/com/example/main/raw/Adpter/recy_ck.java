package com.example.main.raw.Adpter;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.example.main.raw.DataClass.Ck_server_class;
import com.example.main.R;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class recy_ck extends RecyclerView.Adapter<recy_ck.ViewHolder> {
    Context context;
    List<Ck_server_class> data;
    List<Ck_server_class> dataSorted;

    @RequiresApi(api = Build.VERSION_CODES.N)
    public recy_ck(Context context, List<Ck_server_class> data) {
        this.context = context;
        this.data = data;
        px();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void px() {
         dataSorted = data.stream()
                .sorted(Comparator.comparing(Ck_server_class::getStar).reversed())
                .collect(Collectors.toList());
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(context).inflate(R.layout.ck_rect_item,parent,false);
        recy_ck.ViewHolder d=new recy_ck.ViewHolder(view);
        return d;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (dataSorted.get(position).getDt()==0)
        holder.imageView.setImageResource(dataSorted.get(position).getImage());
        else
            holder.imageView.setImageResource(dataSorted.get(position).getDt());
        holder.wq.setImageResource(dataSorted.get(position).getlx());
        if (dataSorted.get(position).getStar()==5){
            holder.xx.setImageResource(R.drawable.icon_5);
        }else if (dataSorted.get(position).getStar()==4){
            holder.xx.setImageResource(R.drawable.icon_4);
        }else {
            holder.xx.setImageResource(R.drawable.icon_3);
        }
    }


    @Override
    public int getItemCount() {
        return 10;
    }


    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView,wq,xx;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.wuqi);
            wq=itemView.findViewById(R.id.wq_tb);
            xx=itemView.findViewById(R.id.xx);
        }
    }

}
