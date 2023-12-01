package com.example.main.mvvm.adapter.detail_js;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.main.R;
import com.example.main.mvvm.ys_bk.fragment.Detail_item_4_fragment;
import com.example.main.mvvm.ys_bk.fragment.Detail_item_fragment;
import com.example.main.mvvm.json.Detail_mz;
import com.example.main.mvvm.json.Detail_role;
import com.example.main.raw.Class_Custom.Bl_cl;
import com.example.main.raw.Class_Custom.Dp_Px;
import com.example.main.raw.JsonPares.Json_Jstf;
import com.example.main.raw.Zdyclass.MyListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Detail_recy_adapter extends RecyclerView.Adapter<Detail_recy_adapter.viewholder> implements View.OnClickListener {
    static int po;
    Context context;
    String url_base = "https://enka.network/ui/";
    Detail_item_fragment fragment = null;
    Detail_item_4_fragment fragment_item4 = null;
    int flag_f = 0, height =809, height_old = 809, flag_dh = 1, flag_dh_old = 1,flag4_dh=0,flag4_old=0;
    TextView ts,ts2;
    int flag_item3=0;
    int oldhi=530;
    List<Detail_role.CostsDTO.Ascend1DTO> ascend1;
    FragmentTransaction fragmentTransaction;
    Json_Jstf json_jstf;
    Bl_cl bl_cl;



    public void setJson_jstf(Json_Jstf json_jstf) {
        this.json_jstf = json_jstf;

    }

    public void setBl_cl(Bl_cl bl_cl) {
        this.bl_cl = bl_cl;
    }

    androidx.fragment.app.FragmentManager fragmentManager_x;

    public void setFragmentManager_x(FragmentManager fragmentManager_x) {
        this.fragmentManager_x = fragmentManager_x;
    }

    public Detail_recy_adapter(Context context) {
        this.context = context;
    }

    Detail_role role;
    Detail_mz mz;

    public void setRole(Detail_role role) {
        this.role = role;
    }

    public void setMz(Detail_mz mz) {
        this.mz = mz;
    }

    @Override
    public int getItemViewType(int position) {
        po=position;
        return position;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View convertView=null;
        switch (viewType){
            case 0:
                convertView = LayoutInflater.from(context).inflate(R.layout.detail_item_1, parent, false);
                break;
            case 1:
                convertView = LayoutInflater.from(context).inflate(R.layout.detail_item_2, parent, false);
                break;
            case 2:
                convertView = LayoutInflater.from(context).inflate(R.layout.detail_item_3, parent, false);
                break;
            case 3:
                convertView = LayoutInflater.from(context).inflate(R.layout.detail_item_4, parent, false);
                break;
            case 4:
                convertView = LayoutInflater.from(context).inflate(R.layout.activity_cs, parent, false);
                break;
        }
        return new viewholder(convertView);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        if (position==0&&role!=null){
            setitem_0(holder);

        }else if (position==1&&role!=null){
            setitem_1(holder);
        } else if (position == 2 && mz != null){
            Detail_item3_adapter adapter = new Detail_item3_adapter(mz, context);
            holder.listView_item3.setAdapter(adapter);
        } else if (position==3&&json_jstf!=null){
            setitem_4(holder);
        }

    }

    private void setitem_4(viewholder holder) {
        Detail_item_4_fragment fragment_item4_cs;
        holder.t1.setOnClickListener(this);
        holder.t2.setOnClickListener(this);
        holder.t3.setOnClickListener(this);
        holder.t4.setOnClickListener(this);
        holder.t5.setOnClickListener(this);
        holder.t6.setOnClickListener(this);
        if (fragmentManager_x != null && flag_item3 ==0) {
            holder.t1.setText(json_jstf.combat1.name);
            holder.t2.setText(json_jstf.combat2.name);
            holder.t3.setText(json_jstf.combat3.name);
            holder.t4.setText(json_jstf.passive1.name);
            holder.t5.setText(json_jstf.passive2.name);
            holder.t6.setText(json_jstf.passive3.name);
            fragment_item4_cs = new  Detail_item_4_fragment(context,0,json_jstf,bl_cl);
            fragmentTransaction = fragmentManager_x.beginTransaction();
            fragmentTransaction.add(R.id.item_4_zw, fragment_item4_cs).commit();
            fragment_item4_cs=null;
            flag_item3=1;
            holder.t1.performClick();
        }else Log.d("TAGNM","进入setitem3");
        Log.d("TAG","已经点击");
    }

    private void setitem_1(viewholder holder) {
        Detail_item_fragment fragment_2;
        holder.c1.setOnClickListener(this);
        holder.c2.setOnClickListener(this);
        holder.c3.setOnClickListener(this);
        holder.c4.setOnClickListener(this);
        holder.c5.setOnClickListener(this);
        holder.c6.setOnClickListener(this);
        holder.c7.setOnClickListener(this);
        holder.c1.performLongClick();
        if (fragmentManager_x != null && flag_f ==0) {
            getone(role.costs);
            fragment_2 = new Detail_item_fragment(role, context, ascend1);
            fragmentTransaction = fragmentManager_x.beginTransaction();
            fragmentTransaction.add(R.id.dj_s, fragment_2).commit();
            flag_f += 1;
            fragment_2=null;
            holder.c1.performClick();
        }
        else {
            Dp_Px dp_px=new Dp_Px();
            ValueAnimator valueAnimator = ValueAnimator.ofFloat(height_old,height);
            valueAnimator.setDuration(300);
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    float value = (float) animation.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = holder.itemView.getLayoutParams();
                    layoutParams.height =dp_px.dip2px(context,value);
                    holder.itemView.setLayoutParams(layoutParams);
                }
            });
            valueAnimator.start();
            height_old=height;
        }
    }

    private void setitem_0(viewholder holder) {
        holder.textView.setText(role.name);
        List_detail detail = new List_detail(context, role);
        holder.listView.setAdapter(detail);
        Glide.with(context)
                .load(role.images.cover1)
                .error(R.drawable.ddly)
                .placeholder(R.drawable.os_abd)
                .into(holder.back);

        switch (role.element) {
            case "岩":
                holder.ys.setImageResource(R.drawable.ys_y);
                holder.view_back.setBackground(context.getDrawable(R.drawable.jb_geo));
                break;
            case "水":
                holder.ys.setImageResource(R.drawable.ys_s);
                holder.view_back.setBackground(context.getDrawable(R.drawable.jb_hydro));
                break;
            case "火":
                holder.ys.setImageResource(R.drawable.ys_h);
                holder.view_back.setBackground(context.getDrawable(R.drawable.jb_pyro));
                break;
            case "冰":
                holder.ys.setImageResource(R.drawable.ys_b);
                holder.view_back.setBackground(context.getDrawable(R.drawable.jb_cryo));
                break;
            case "雷":
                holder.ys.setImageResource(R.drawable.ys_l);
                holder.view_back.setBackground(context.getDrawable(R.drawable.jb_electro));
                break;
            case "风":
                holder.ys.setImageResource(R.drawable.ys_f);
                holder.view_back.setBackground(context.getDrawable(R.drawable.jb_anemo));
                break;
            case "草":
                holder.ys.setImageResource(R.drawable.ys_c);
                holder.view_back.setBackground(context.getDrawable(R.drawable.jb_dendro));
                break;
        }
        if (role.rarity.equals("5")) {
            holder.star.setImageResource(R.drawable.icon_5);
        } else {
            holder.star.setImageResource(R.drawable.icon_4);
        }
    }

    @Override
    public int getItemCount() {
        return 5;
    }


    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.c1||v.getId()==R.id.c2||v.getId()==R.id.c3||v.getId()==R.id.c4||v.getId()==R.id.c5||v.getId()==R.id.c6||v.getId()==R.id.c7) {
            if (ts != null) {
                ts.setBackground(context.getDrawable(R.drawable.detail));
                ts.setTextColor(0x8A000000);
            }
            fragmentTransaction = fragmentManager_x.beginTransaction();
            TextView textView = (TextView) v;
            textView.setBackground(context.getDrawable(R.drawable.detail_dj));
            textView.setTextColor(0xFFFFFFFF);
            ts = textView;
            fragment = null;
            switch (v.getId()) {
                case R.id.c1:
                    fragment = new Detail_item_fragment(role, context, ascend1);
                    height = 809;
                    flag_dh = 1;
                    break;
                case R.id.c2:
                    fragment = new Detail_item_fragment(role, 2, context);
                    height = 451;
                    flag_dh = 2;
                    break;
                case R.id.c3:
                    fragment = new Detail_item_fragment(role, 3, context);
                    height = 511;
                    flag_dh = 3;
                    break;
                case R.id.c4:
                    fragment = new Detail_item_fragment(role, 4, context);
                    height = 511;
                    flag_dh = 4;
                    break;
                case R.id.c5:
                    fragment = new Detail_item_fragment(role, 5, context);
                    height = 511;
                    flag_dh = 5;
                    break;
                case R.id.c6:
                    fragment = new Detail_item_fragment(role, 6, context);
                    height = 511;
                    flag_dh = 6;
                    break;
                case R.id.c7:
                    fragment = new Detail_item_fragment(role, 7, context);
                    height = 511;
                    flag_dh = 7;
                    break;
            }

            if (flag_dh_old == flag_dh)
                return;
            if (flag_dh < flag_dh_old) {
                fragmentTransaction.setCustomAnimations(R.anim.left_jr, R.anim.right_exit, R.anim.left_jr, R.anim.left_exit).replace(R.id.dj_s, fragment).commit();
                notifyItemChanged(1);
                flag_dh_old = flag_dh;
            } else {
                fragmentTransaction.setCustomAnimations(R.anim.right_jr, R.anim.left_exit, R.anim.left_jr, R.anim.left_exit).replace(R.id.dj_s, fragment).commit();
                notifyItemChanged(1);
                flag_dh_old = flag_dh;
            }

        }else {
            if (ts2 != null) {
                ts2.setBackground(context.getDrawable(R.drawable.detail));
                ts2.setTextColor(0x8A000000);
            }

            fragmentTransaction = fragmentManager_x.beginTransaction();
            TextView textView = (TextView) v;
            textView.setBackground(context.getDrawable(R.drawable.detail_dj));
            textView.setTextColor(0xFFFFFFFF);
            Log.d("TAGBBB","hello");
            ts2 = textView;
            switch (v.getId()){
                case R.id.t1:
                    fragment_item4=new Detail_item_4_fragment(context,0,json_jstf,bl_cl);
                    flag4_dh=0;

                    break;
                case R.id.t2:
                    fragment_item4=new Detail_item_4_fragment(context,1,json_jstf,bl_cl);

                    flag4_dh=1;
                    break;
                case R.id.t3:
                    fragment_item4=new Detail_item_4_fragment(context,2,json_jstf,bl_cl);

                    flag4_dh=2;
                    break;
                case R.id.t4:
                    fragment_item4=new Detail_item_4_fragment(context,3,json_jstf,bl_cl);

                    flag4_dh=3;
                    break;
                case R.id.t5:
                    fragment_item4=new Detail_item_4_fragment(context,4,json_jstf,bl_cl);

                    flag4_dh=4;
                    break;
                case R.id.t6:
                    fragment_item4=new Detail_item_4_fragment(context,5,json_jstf,bl_cl);

                    flag4_dh=5;
                    break;
            }

            if (flag4_old==flag4_dh)
                return;
            if (flag_dh < flag_dh_old) {
                fragmentTransaction.setCustomAnimations(R.anim.left_jr, R.anim.right_exit, R.anim.left_jr, R.anim.left_exit).replace(R.id.item_4_zw, fragment_item4).commit();
                notifyItemChanged(3);
                flag4_old = flag4_dh;
            } else {
                fragmentTransaction.setCustomAnimations(R.anim.right_jr, R.anim.left_exit, R.anim.left_jr, R.anim.left_exit).replace(R.id.item_4_zw, fragment_item4).commit();

                notifyItemChanged(3);
                flag4_old = flag4_dh;
            }
        }


    }


    static class viewholder extends RecyclerView.ViewHolder {
        TextView textView;
        ListView listView;
        ImageView back,ys,star;
        View view_back;
        //0
        TextView c1, c2, c3, c4, c5, c6, c7;
        //1
        MyListView listView_item3;
        //2
        TextView t1, t2, t3, t4, t5, t6;
        public viewholder(@NonNull View convertView) {
            super(convertView);
            if (po==0){
                textView = convertView.findViewById(R.id.text_detail);
                listView = convertView.findViewById(R.id.detail_list);
                back = convertView.findViewById(R.id.detail_item1_back);
                ys = convertView.findViewById(R.id.ys_detail);
                view_back = convertView.findViewById(R.id.view_back);
                star = convertView.findViewById(R.id.star);
            }else if (po==1){
                c1 = convertView.findViewById(R.id.c1);
                c2 = convertView.findViewById(R.id.c2);
                c3 = convertView.findViewById(R.id.c3);
                c4 = convertView.findViewById(R.id.c4);
                c5 = convertView.findViewById(R.id.c5);
                c6 = convertView.findViewById(R.id.c6);
                c7 = convertView.findViewById(R.id.c7);

            }else if (po==2){
                listView_item3 = convertView.findViewById(R.id.list_mz);
            }else if (po==3){
                t1=convertView.findViewById(R.id.t1);
                t2=convertView.findViewById(R.id.t2);
                t3=convertView.findViewById(R.id.t3);
                t4=convertView.findViewById(R.id.t4);
                t5=convertView.findViewById(R.id.t5);
                t6=convertView.findViewById(R.id.t6);
            }

        }
    }


    public List<Detail_role.CostsDTO.Ascend1DTO> getone(Detail_role.CostsDTO costsDTO) {
        Map<String, Integer> materialCountMap = new HashMap<>();  // 存储每种材料的count
        List<List<Detail_role.CostsDTO.Ascend1DTO>> dtos = new ArrayList<>();
        dtos.add(costsDTO.ascend1);
        dtos.add(costsDTO.ascend2);
        dtos.add(costsDTO.ascend3);
        dtos.add(costsDTO.ascend4);
        dtos.add(costsDTO.ascend5);
        dtos.add(costsDTO.ascend6);

        for (int a = 0; a < dtos.size(); a++) {
            for (int b = 0; b < dtos.get(a).size(); b++) {
                Detail_role.CostsDTO.Ascend1DTO ascend1DTO = dtos.get(a).get(b);
                String materialName = ascend1DTO.name;
                int materialCount = ascend1DTO.count;
                if (materialCountMap.containsKey(materialName)) {
                    materialCountMap.put(materialName, materialCountMap.get(materialName) + materialCount);
                } else {
                    materialCountMap.put(materialName, materialCount);
                }
            }
        }
        System.out.println("汇总每个材料所需的count如下：");
        ascend1 = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : materialCountMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
            ascend1.add(new Detail_role.CostsDTO.Ascend1DTO(entry.getKey(), entry.getValue()));
        }
        return ascend1;
    }
}
