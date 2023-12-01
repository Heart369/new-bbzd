package com.example.main.raw.Adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.main.R;

public class Recy_Bk_main extends RecyclerView.Adapter<Recy_Bk_main.viewholder> {
    Context context;
    int[] image;
    String[] name;
    onclick onclick;

    public Recy_Bk_main(Context context, int[] image, String[] name, Recy_Bk_main.onclick onclick) {
        this.context = context;
        this.image = image;
        this.name = name;
        this.onclick = onclick;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.recy_bk,parent,false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
//       RecyclerView.LayoutParams lp= (RecyclerView.LayoutParams) holder.layout.getLayoutParams();
//        lp.height=200;
        holder.textView.setText(name[position]);
        holder.imageview.setImageResource(image[position]);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onclick.onitemclick(holder.getPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return name.length;
    }

    static class viewholder extends RecyclerView.ViewHolder {
        ImageView imageview;
        TextView textView;
        ConstraintLayout layout;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            layout=itemView.findViewById(R.id.con);
            imageview=itemView.findViewById(R.id.imageView);
            textView=itemView.findViewById(R.id.text_name);
        }
    }
    public interface onclick{
        int onitemclick(int po);
    }
}
