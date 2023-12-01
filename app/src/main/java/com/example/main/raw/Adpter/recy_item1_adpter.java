package com.example.main.raw.Adpter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.main.raw.JsonPares.Sy;
import com.example.main.R;
import com.example.main.raw.Zdyclass.MyGridView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class recy_item1_adpter extends RecyclerView.Adapter<recy_item1_adpter.ViewHolder> {
    Sy.DataDTO.FloorsDTO floorsDTO;
    Context context;
    static int position;
    Sy.DataDTO dataDTO;
    public recy_item1_adpter(Sy.DataDTO.FloorsDTO floorsDTO, Context context,Sy.DataDTO dataDTO) {
        this.floorsDTO = floorsDTO;
        this.context = context;
        this.dataDTO=dataDTO;
    }

    @Override
    public int getItemViewType(int position) {
        recy_item1_adpter.position =position;
        return position;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        recy_item1_adpter.ViewHolder d;
        if (viewType==0){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mylist_item2_item1,parent,false);
          d = new recy_item1_adpter.ViewHolder(view);
        }
        else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mylist_item2_item2,parent,false);
             d = new recy_item1_adpter.ViewHolder(view);
        }
        return d;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (position==0){
            holder.cs.setText("" + floorsDTO.getIndex());
            holder.xj.setText(floorsDTO.getStar() + "/" + floorsDTO.getMax_star());
            switch (floorsDTO.getIndex()) {
                case 9:
                    holder.textcs.setText("深境螺旋第九层");
                    break;
                case 10:
                    holder.textcs.setText("深境螺旋第十层");
                    break;
                case 11:
                    holder.textcs.setText("深境螺旋第十一层");
                    break;
                case 12:
                    holder.textcs.setText("深境螺旋第十二层");
                    break;
            }
        }else {
            Sy.DataDTO.FloorsDTO.LevelsDTO levelsDTO = floorsDTO.getLevels().get(position - 1);
            holder. js.setText("第" + levelsDTO.getIndex() + "间");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
            if(levelsDTO.getBattles().size()==0){
               ;
            }else{
                String date1 = sdf.format(new Date(Long.parseLong(levelsDTO.getBattles().get(0).getTimestamp())* 1000L));
                holder. time.setText(date1);
                Log.d("TAG","创建间级");
                Item2_Mygrid_Adpter adpter = new Item2_Mygrid_Adpter(levelsDTO.getBattles().get(0).getAvatars(), levelsDTO.getBattles().get(1).getAvatars(),context);
                holder.gridView.setAdapter(adpter);
            }
            holder. i1.setImageResource(R.drawable.syxx_g);
            holder. i2.setImageResource(R.drawable.syxx_g);
            holder. i3.setImageResource(R.drawable.syxx_g);
            switch (levelsDTO.getStar()) {
                case 3:
                    holder. i1.setImageResource(R.drawable.syxx);
                case 2:
                    holder. i2.setImageResource(R.drawable.syxx);
                case 1:
                    holder. i3.setImageResource(R.drawable.syxx);
            }

        }
    }

    @Override
    public int getItemCount() {
      //       Log.d("TAGsss",""+floorsDTO.getLevels().size());
        return 1+floorsDTO.getLevels().size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView cs,xj,textcs,js,time;
        MyGridView gridView;
        ImageView i1,i2,i3;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            if (position==0){
                cs =itemView.findViewById(R.id.cs);
               xj = itemView.findViewById(R.id.xj);
               textcs = itemView.findViewById(R.id.text_cs);
            }else {
                gridView = itemView.findViewById(R.id.item2_mygrid);
               js = itemView.findViewById(R.id.js_sy);
               time = itemView.findViewById(R.id.mylist_time);
                i1 = itemView.findViewById(R.id.xj_imag_1);
                i2 = itemView.findViewById(R.id.xj_imag_2);
               i3 = itemView.findViewById(R.id.xj_imag_3);
            }
        }
    }
}
