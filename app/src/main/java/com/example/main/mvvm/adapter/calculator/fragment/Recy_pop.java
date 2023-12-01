package com.example.main.mvvm.adapter.calculator.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.main.R;
import com.example.main.raw.interface_.OnRecyclerItemClickListener;

import java.util.List;


public class Recy_pop extends RecyclerView.Adapter<Recy_pop.ViewHolder> {
    Context context;
    int hi,i;
    String[] data;
    OnRecyclerItemClickListener onRecyclerItemClickListener;
    List<String> wqname=null;
    public Recy_pop(Context context, int hi, int i, List<String> wqname) {
        this.context = context;
        this.hi=hi;
        this.i=i;
        this.wqname=wqname;
    }

    public List<String> getWqname() {
        return wqname;
    }

    public String[] getData() {
        return data;
    }

    public void setOnRecyclerItemClickListener(OnRecyclerItemClickListener onRecyclerItemClickListener) {
        this.onRecyclerItemClickListener = onRecyclerItemClickListener;
    }

    public Recy_pop(Context context, int hi, int i, String[] data) {
        this.context = context;
        this.hi=hi;
        this.i=i;
        this.data=data;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if (wqname!=null){
            if (viewType==0||viewType==wqname.size()+1){
                view=LayoutInflater.from(context).inflate(R.layout.xzq_item,parent,false);
                RecyclerView.LayoutParams lp= (RecyclerView.LayoutParams) view.getLayoutParams();
                if (viewType==0)
                    lp.height=hi;
                else
                    lp.height=i;
            }
            else
                view= LayoutInflater.from(context).inflate(R.layout.xzq_item,parent,false);
        }else {
            if (viewType==0||viewType==data.length+1){
                view=LayoutInflater.from(context).inflate(R.layout.xzq_item,parent,false);
                RecyclerView.LayoutParams lp= (RecyclerView.LayoutParams) view.getLayoutParams();
                if (viewType==0)
                    lp.height=hi;
                else
                    lp.height=i;
            }
            else
                view= LayoutInflater.from(context).inflate(R.layout.xzq_item,parent,false);
        }


        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder,  int position) {
        if (wqname!=null){
            if (position!=0&&position!=wqname.size()+1)
                holder.textView.setText(wqname.get(position-1));
        }else {
            if (position!=0&&position!=data.length+1)
                holder.textView.setText(data[position-1]);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRecyclerItemClickListener.onItemClick(v,holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        if (wqname!=null)
            return wqname.size()+2;
        return data.length+2;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.name);
        }
    }
}
