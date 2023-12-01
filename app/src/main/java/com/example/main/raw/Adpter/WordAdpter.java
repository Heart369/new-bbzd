package com.example.main.raw.Adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.main.raw.DataClass.WordData;
import com.example.main.R;

import java.util.List;

public class WordAdpter extends RecyclerView.Adapter<WordAdpter.ViewHodler> {
    List<WordData> word;
    Context context;
    public WordAdpter(List<WordData> word, Context context) {
        this.word=word;
        this.context=context;
    }

    @NonNull
    @Override
    public ViewHodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tsd_item,parent,false);
        WordAdpter.ViewHodler d = new WordAdpter.ViewHodler(view);
        return d;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHodler holder, int position) {
        holder.gjname.setText(word.get(position).getName());
        holder.jd.setText(word.get(position).getTsd()/10+"%");
        holder.bj.setBackgroundResource(word.get(position).getImg_bd());
        holder.gj.setImageResource(word.get(position).getImg_tb());
        holder.jdt.setProgress(word.get(position).getTsd());

    }

    @Override
    public int getItemCount() {
        return word.size();
    }

    static class ViewHodler extends RecyclerView.ViewHolder {
        TextView gjname,jd;
        ImageView bj,gj;
        ProgressBar jdt;
        public ViewHodler(@NonNull View itemView) {
            super(itemView);
            gjname=itemView.findViewById(R.id.text_gjname);
            jd=itemView.findViewById(R.id.text_jd);
            bj=itemView.findViewById(R.id.img_bj);
            gj=itemView.findViewById(R.id.img_gj);
            jdt=itemView.findViewById(R.id.jdt);
        }
    }
}
