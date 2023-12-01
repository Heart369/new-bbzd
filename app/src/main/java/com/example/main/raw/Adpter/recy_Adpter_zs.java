package com.example.main.raw.Adpter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.main.mvvm.ys_bk.Detail_Pages_Activity;
import com.example.main.mvvm.ys_bk.Detail_Wq_Activity;
import com.example.main.raw.DataClass.Jswqdata;
import com.example.main.raw.DataClass.Scdata;
import com.example.main.raw.Class_Custom.wh.Zsdata;
import com.example.main.R;
import com.example.main.raw.Zdyclass.MyGridView;

import java.util.List;

public class recy_Adpter_zs extends RecyclerView.Adapter<recy_Adpter_zs.viewHolder> {
    int size;
    Context context;
    int zj;

    public recy_Adpter_zs(int size, Context context, int zj) {
        this.size = size;
        this.context = context;
        this.zj = zj;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.jszs_item,parent,false);
        recy_Adpter_zs.viewHolder d = new recy_Adpter_zs.viewHolder(view);
        return d;
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        List<Jswqdata> js =null;
        List<Scdata> sc =null;
        Zsdata zsdata =new Zsdata();
        switch (zj){
            case 1:
                switch (position){
                    case 0:
                        js=zsdata.mdzy();
                        break;
                    case 1:
                        js=zsdata.lyzy();
                        break;
                    case 2:
                        js=zsdata.dqzy();
                        break;
                    case 3:
                        js=zsdata.xmzy();
                        break;
                    case 4:
                        js=zsdata.fdzy();
                        break;
                }
                break;
            case 2:
                switch (position){
                    case 0:
                        js=zsdata.mdze();
                        break;
                    case 1:
                        js=zsdata.lyze();
                        break;
                    case 2:
                        js=zsdata.dqze();
                        break;
                    case 3:
                        js=zsdata.xmze();
                        break;
                    case 4:
                        js=zsdata.fdze();
                        break;
                }
                break;
            case 3:
                switch (position){
                    case 0:
                        js=zsdata.mdzs();
                        break;
                    case 1:
                        js=zsdata.lyzs();
                        break;
                    case 2:
                        js=zsdata.dqzs();
                        break;
                    case 3:
                        js=zsdata.xmzs();
                        break;
                    case 4:
                        js=zsdata.fdzs();
                        break;
                }
                break;
            case 4:
                switch (position){
                    case 0:
                        js=zsdata.wqmdzy();
                        break;
                    case 1:
                        js=zsdata.wqlyzy();
                        break;
                    case 2:
                        js=zsdata.wqdqzy();
                        break;
                    case 3:
                        js=zsdata.wqxmzy();
                        break;
                    case 4:
                        js=zsdata.wqfdzy();
                        break;
                }
                break;
            case 5:
                switch (position){
                    case 0:
                        js=zsdata.wqmdze();
                        break;
                    case 1:
                        js=zsdata.wqlyze();
                        break;
                    case 2:
                        js=zsdata.wqdqze();
                        break;
                    case 3:
                        js=zsdata.wqxmze();
                        break;
                    case 4:
                        js=zsdata.wqfdze();
                        break;
                }
                break;
            case 6:
                switch (position){
                    case 0:
                        js=zsdata.wqmdzs();
                        break;
                    case 1:
                        js=zsdata.wqlyzs();
                        break;
                    case 2:
                        js=zsdata.wqdqzs();
                        break;
                    case 3:
                        js=zsdata.wqxmzs();
                        break;
                    case 4:
                        js=zsdata.wqfdzs();
                        break;
                }
                break;
            case 7:
                switch (position){
                    case 0:
                        js=zsdata.mdzy();
                        break;
                    case 1:
                        js=zsdata.mdze();
                        break;
                    case 2:
                        js=zsdata.mdzs();
                        break;
                    case 3:
                        js=zsdata.lyzy();
                        break;
                    case 4:
                        js=zsdata.lyze();
                        break;
                    case 5:
                        js=zsdata.lyzs();
                        break;
                    case 6:
                        js=zsdata.dqzy();
                        break;
                    case 7:
                        js=zsdata.dqze();
                        break;
                    case 8:
                        js=zsdata.dqzs();
                        break;
                    case 9:
                        js=zsdata.xmzy();
                        break;
                    case 10:
                        js=zsdata.xmze();
                        break;
                    case 11:
                        js=zsdata.xmzs();
                        break;
                    case 12:
                        js=zsdata.fdzy();
                        break;
                    case 13:
                        js=zsdata.fdze();
                        break;
                    case 14:
                        js=zsdata.fdzs();
                        break;
                }
                break;
                case 8:
                switch (position){
                    case 0:
                        js=zsdata.wqmdzy();
                        break;
                    case 1:
                        js=zsdata.wqmdze();
                        break;
                    case 2:
                        js=zsdata.wqmdzs();
                        break;
                    case 3:
                        js=zsdata.wqlyzy();
                        break;
                    case 4:
                        js=zsdata.wqlyze();
                        break;
                    case 5:
                        js=zsdata.wqlyzs();
                        break;
                    case 6:
                        js=zsdata.wqdqzy();
                        break;
                    case 7:
                        js=zsdata.wqdqze();
                        break;
                    case 8:
                        js=zsdata.wqdqzs();
                        break;
                    case 9:
                        js=zsdata.wqxmzy();
                        break;
                    case 10:
                        js=zsdata.wqxmze();
                        break;
                    case 11:
                        js=zsdata.wqxmzs();
                        break;
                    case 12:
                        js=zsdata.wqfdzy();
                        break;
                    case 13:
                        js=zsdata.wqfdze();
                        break;
                    case 14:
                        js=zsdata.wqfdzs();
                        break;
                }

        }
        switch (zj){
            case 1:
                sc=zsdata.zysc();
                break;
            case 2:
                sc=zsdata.zesc();
                break;
            case 3:
                sc=zsdata.zssc();
                break;
            case 4:
                sc=zsdata.wqzysc();
                break;
            case 5:
                sc=zsdata.wqzesc();
                break;
            case 6:
                sc=zsdata.wqzssc();
                break;
            case  7:
                sc =zsdata.zmsc();
                break;
            case 8:
                sc=zsdata.wqzmsc();
        }

        holder.textView.setText(sc.get(position).getName());
        holder.imageView.setImageResource(sc.get(position).getImg());
        grid_zs grid_zs =new grid_zs(js,context);
        holder.gridView.setAdapter(grid_zs);
        holder.gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               TextView textView=view.findViewById(R.id.name);
               if (zj==1||zj==2||zj==3||zj==7){
                   Intent intent=new Intent(context, Detail_Pages_Activity.class);
                   intent.putExtra("name",textView.getText().toString());
                   context.startActivity(intent);
               }else {
                   Intent intent=new Intent(context, Detail_Wq_Activity.class);
                   intent.putExtra("name",textView.getText().toString());
                   context.startActivity(intent);
               }

            }
        });
        //计算高度并且设置
//        ViewGroup.LayoutParams params = holder.gridView.getLayoutParams();
//        int a =js.size();
//        Double b=(double)a;
//        if(b>3&&b%3!=0)
//            b=b/3;
//        else b=(b-3)/3;
//        b=b-0.3;
//         a=(int)Math.round(b);
//        a=150+a*185;
//        params.height = a;
//        holder.gridView.setLayoutParams(params);

    }

    @Override
    public int getItemCount() {
        return size;
    }


    static class  viewHolder extends  RecyclerView.ViewHolder{
    MyGridView gridView;
    TextView textView;
    ImageView imageView;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            gridView=itemView.findViewById(R.id.grid_zs);
            textView=itemView.findViewById(R.id.text_zs);
            imageView=itemView.findViewById(R.id.img_zs);
        }
    }
}
