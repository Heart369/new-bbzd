package com.example.main.raw.Adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.main.raw.JsonPares.Sy;
import com.example.main.R;

public class Mylist_Sy_Adpter extends BaseAdapter {
    Sy sy;
    Context context;
    Sy.DataDTO dataDTO;

    public Mylist_Sy_Adpter(Sy sy, Context context, Sy.DataDTO dataDTO) {
        this.sy = sy;
        this.context = context;
        this.dataDTO = dataDTO;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view= LayoutInflater.from(context).inflate(R.layout.sy_zdsj,parent,false);
        TextView t1,t2;
        ImageView i1,i2;
        t1=view.findViewById(R.id.yw_zdsj_1);
        t2=view.findViewById(R.id.yw_zdsj_2);
        i1=view.findViewById(R.id.yw_zdsj_3);
        i2=view.findViewById(R.id.yw_zdsj_4);
        if(dataDTO.getDefeat_rank().size()!=0) {
            switch (position) {
                case 0:

                    t1.setText("最多击破数：" + dataDTO.getDefeat_rank().get(0).getValue());
                    t2.setText("最强一击：" + dataDTO.getDamage_rank().get(0).getValue());
                    Glide.with(context)
                            .load(dataDTO.getDefeat_rank().get(0).getAvatar_icon())
                            .fitCenter()
                            .error(R.drawable.ddly)
                            .placeholder(R.drawable.ddly)
                            .into(i1);
                    Glide.with(context)
                            .load(dataDTO.getDamage_rank().get(0).getAvatar_icon())
                            .fitCenter()
                            .error(R.drawable.ddly)
                            .placeholder(R.drawable.ddly)
                            .into(i2);
                    break;
                case 1:
                    t1.setText("承受最多伤害：" + dataDTO.getTake_damage_rank().get(0).getValue());
                    t2.setText("元素爆发次数：" + dataDTO.getEnergy_skill_rank().get(0).getValue());
                    Glide.with(context)
                            .load(dataDTO.getTake_damage_rank().get(0).getAvatar_icon())
                            .fitCenter()
                            .error(R.drawable.ddly)
                            .placeholder(R.drawable.ddly)
                            .into(i1);
                    Glide.with(context)
                            .load(dataDTO.getEnergy_skill_rank().get(0).getAvatar_icon())
                            .fitCenter()
                            .error(R.drawable.ddly)
                            .placeholder(R.drawable.ddly)
                            .into(i2);
                case 2:
                    t1.setText("元素战技释放次数：" + dataDTO.getNormal_skill_rank().get(0).getValue());
                    Glide.with(context)
                            .load(dataDTO.getNormal_skill_rank().get(0).getAvatar_icon())
                            .fitCenter()
                            .error(R.drawable.ddly)
                            .placeholder(R.drawable.ddly)
                            .into(i1);
            }
        }
        else {
            t1.setText("无法查询到此玩家的此信息");
        }
        return view;
    }

}
