package com.example.main.raw.Adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.main.raw.JsonPares.Sy;
import com.example.main.R;
import com.example.main.raw.activity.Sy_Activity;
import com.example.main.raw.Zdyclass.MyGridView;
import com.example.main.raw.Zdyclass.MyListView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Sy_recy_Adpter extends RecyclerView.Adapter<Sy_recy_Adpter.viewHolder>{
    Sy sy;
    Context context;
    Sy.DataDTO dataDTO;
    static int position;
    int flag;
    int a;
    int cont;

    public Sy_recy_Adpter(Sy sy, Context context, int flag) {
        this.sy = sy;
        this.context = context;
        this.flag = flag;

        dataDTO= sy.getData();
    }

    @Override
    public int getItemViewType(int position) {
       Sy_recy_Adpter.position=position;
        return position;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Sy_recy_Adpter.viewHolder d;
        View view;
        if (viewType==0){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sy_xz, parent, false);
        }else
        if (viewType==1){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sy_item1, parent, false);
        }
        else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recy_item1, parent, false);
        }
        d = new  viewHolder(view);
        return d;
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        a=dataDTO.getFloors().size();
        if (position==0){
            if(flag==1){
                holder.l1.setBackgroundColor(0xFFA37038);
                holder.l2.setBackgroundColor(0xFFE1B88B);
            }else {
                holder.l2.setBackgroundColor(0xFFA37038);
                holder.l1.setBackgroundColor(0xFFE1B88B);
            }
            holder.l1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Sy_Activity.sx(0);
                }
            });
            holder.l2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Sy_Activity.sx(1);
                }
            });
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
            String date1 = sdf.format(new Date(Long.parseLong(sy.getData().getStart_time())* 1000L));
            String date2 = sdf.format(new Date(Long.parseLong(sy.getData().getEnd_time())* 1000L));
            holder.i1.setText("统计时间："+date1+"至"+date2);
        }else
        if (position==1){
            holder.max_floor.setText("最深抵达："+dataDTO.getMax_floor());
            holder.total_battle_times.setText("战斗次数："+dataDTO.getTotal_battle_times());
            if (a>=4)
            holder.xj.setText(""+(dataDTO.getFloors().get(a-4).getStar()+dataDTO.getFloors().get(a-3).getStar()+dataDTO.getFloors().get(a-2).getStar()+dataDTO.getFloors().get(a-1).getStar()));
            else {
                holder.xj.setText(""+sy.getData().getTotal_star());
            }
            MyGrid_Sy_Adpter gridadpter=new MyGrid_Sy_Adpter(dataDTO.getReveal_rank(),context);
            Mylist_Sy_Adpter list_adpter=new Mylist_Sy_Adpter(sy,context,dataDTO);
            holder.myListView.setAdapter(list_adpter);
        }else  {
            LinearLayoutManager layoutManager = new LinearLayoutManager(context){
                @Override
                public boolean canScrollVertically() {
                    return false;
                }
            };
            layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
//            while (dataDTO.getFloors().get(a).getIndex()<9){
//                a++;
//            }
//            dataDTO.getFloors().size();
//            if (a!=position-2)
//                a+=position-2;
            recy_item1_adpter adpter;
            if (a>=4)
            adpter=new recy_item1_adpter(dataDTO.getFloors().get(a-4+position-2),context,dataDTO);
            else
                adpter=new recy_item1_adpter(dataDTO.getFloors().get(position-2),context,dataDTO );
            holder.recyclerView.setLayoutManager(layoutManager);
            holder.recyclerView.setAdapter(adpter);
        }
    }

    @Override
    public int getItemCount() {
        return 2+sy.getData().getFloors().size();
    }

    static class viewHolder extends RecyclerView.ViewHolder {
        TextView max_floor,total_battle_times,xj;
        MyListView myListView;
        MyGridView myGridView;
        RecyclerView recyclerView;
        TextView i1;
        LinearLayout  l1,l2;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            if (position==0){
                i1=itemView.findViewById(R.id.sy_time);
                l1=itemView.findViewById(R.id.sy_s1);
                l2=itemView.findViewById(R.id.sy_s2);
            }else
            if (position==1){
                max_floor=itemView.findViewById(R.id.max_floor);
                total_battle_times=itemView.findViewById(R.id.total_battle_times);
                myGridView=itemView.findViewById(R.id.sy_mygrid);
                myListView=itemView.findViewById(R.id.sy_mylist);
                xj=itemView.findViewById(R.id.total_star);
            }else {
                recyclerView=itemView.findViewById(R.id.recy_sy);
            }
        }
    }
}
