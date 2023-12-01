package com.example.main.mvvm.adapter.detail_wq;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.example.main.R;
import com.example.main.mvvm.ys_bk.fragment.Detailwq_item_3_fragment;
import com.example.main.mvvm.json.Detail_Wq;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main_recy_adapter extends RecyclerView.Adapter<Main_recy_adapter.viewhodler> implements View.OnClickListener {
    Context context;
    Detail_Wq wqdata;
    String title;
    static int po;
    int flag_csh=0,flag_dh = 1,flag_dh_old = 1;

    TextView ts;
    List<Detail_Wq.CostsDTO.Ascend1DTO> ascend1;
    Detailwq_item_3_fragment fragment = null;
    FragmentTransaction fragmentTransaction;
    androidx.fragment.app.FragmentManager fragmentManager_x;
    Map<Integer,Detail_Wq> mb;

    public void setMb(Map<Integer, Detail_Wq> mb) {
        this.mb = mb;

        Log.d("SHUAX","刷新123");
    }

    public void setFragmentManager(FragmentManager fragmentManager) {
        fragmentManager_x=fragmentManager;
    }

    public void setWqdata(Detail_Wq wqdata) {
        this.wqdata = wqdata;
    }

    public Main_recy_adapter(Context context) {
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        po = position;
        return position;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @NonNull
    @Override
    public viewhodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = null;
        switch (po) {
            case 0:
                view = LayoutInflater.from(context).inflate(R.layout.detail_wq_title, parent, false);
                break;
            case 1:
                view = LayoutInflater.from(context).inflate(R.layout.detail_wq_item1, parent, false);
                break;
            case 3:
                view = LayoutInflater.from(context).inflate(R.layout.detail_wq_item2, parent, false);
                break;
            case 2:
                view = LayoutInflater.from(context).inflate(R.layout.detail_wq_item3, parent, false);
                break;
            case 4:
                view = LayoutInflater.from(context).inflate(R.layout.detail_wq_item4, parent, false);
                break;
        }
        return new viewhodler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewhodler holder, int position) {
        if (position == 0&&title!=null) {
            holder.title.setText(title);

        } else if (position == 1 && wqdata != null) {
            holder.name.setText(wqdata.name);
            holder.wqlx.setText(wqdata.weapontype);
            Glide.with(context).load("https://enka.network/ui/"+wqdata.images.nameawakenicon+".png").into(holder.wqicon);
            int back = R.drawable.five_back_back;
            switch (wqdata.rarity) {
                case "5":
                    holder.xjicon.setImageResource(R.drawable.icon_5);
                    break;
                case "4":
                    holder.xjicon.setImageResource(R.drawable.icon_4);
                    back = R.drawable.four_back_back;
                    break;
                case "3":
                    holder.xjicon.setImageResource(R.drawable.icon_3);
                    back = R.drawable.there_back_back;
                    break;
                case "2":
                    holder.xjicon.setImageResource(R.drawable.icon_2);
                    back = R.drawable.tow_back_back;
                    break;
                case "1":
                    holder.xjicon.setImageResource(R.drawable.xx);
                    back = R.drawable.one_back_back;
                    break;
            }
            Glide.with(context).load(back).apply(RequestOptions.bitmapTransform(new RoundedCorners(20))).into(new SimpleTarget<Drawable>() {
                @Override
                public void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
                    holder.wqicon.setBackground(resource);
                }
            });

        } else if (position == 3 && wqdata != null) {
            holder.his.setText(wqdata.description);
            StringBuffer buffer = new StringBuffer(wqdata.effect);
            for (int a = 0; a < wqdata.r1.size(); a++) {
                String data = wqdata.r1.get(a) + "," + wqdata.r2.get(a) + "," + wqdata.r3.get(a) + "," + wqdata.r4.get(a) + "," + wqdata.r5.get(a);
                int star = buffer.indexOf("{");
                buffer.replace(star, star + 3, "(" + data + ")");
            }
            holder.zw.setText(wqdata.effectname + ":\n" + "       " + buffer);
        } else if (position==2&& wqdata != null&&mb!=null){
            Detailwq_item_3_fragment fragments;
            Log.d("SHUAX","刷新");
            if (flag_csh==0){
                holder.c1.setOnClickListener(this);
                holder.c2.setOnClickListener(this);
                holder.c3.setOnClickListener(this);
                holder.c4.setOnClickListener(this);
                holder.c5.setOnClickListener(this);
                holder.c6.setOnClickListener(this);
                holder.c7.setOnClickListener(this);
                holder.c8.setOnClickListener(this);
                holder.c1.performClick();
                 ascend1=gethz();
                flag_csh=1;
                fragments=new Detailwq_item_3_fragment(context,wqdata,0,ascend1,mb);
                fragmentTransaction = fragmentManager_x.beginTransaction();
                fragmentTransaction.add(R.id.wq_s, fragments).commit();
            }else {
                flag_dh_old=flag_dh;
            }



        } else if (position == 4 && wqdata != null) {
            holder.story.setText(wqdata.story);
        }


    }

    @Override
    public int getItemCount() {
        return 5;
    }

    @Override
    public void onClick(View v) {
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
        switch (v.getId()){
            case R.id.c1:
                fragment=new Detailwq_item_3_fragment(context,wqdata,0,ascend1,mb);
                flag_dh=1;
                break;
            case R.id.c2:
                fragment=new Detailwq_item_3_fragment(context,wqdata,1,wqdata.costs.ascend1,mb);
                flag_dh=2;
                break;
            case R.id.c3:
                fragment=new Detailwq_item_3_fragment(context,wqdata,2,wqdata.costs.ascend2,mb);
                flag_dh=3;
                break;
            case R.id.c4:
                fragment=new Detailwq_item_3_fragment(context,wqdata,3,wqdata.costs.ascend3,mb);
                flag_dh=4;
                break;
            case R.id.c5:
                fragment=new Detailwq_item_3_fragment(context,wqdata,4,wqdata.costs.ascend4,mb);
                flag_dh=5;
                break;
            case R.id.c6:
                fragment=new Detailwq_item_3_fragment(context,wqdata,5,wqdata.costs.ascend5,mb);
                flag_dh=6;
                break;
            case R.id.c7:
                fragment=new Detailwq_item_3_fragment(context,wqdata,6,wqdata.costs.ascend6,mb);
                flag_dh=7;
                break;
            case R.id.c8:
                fragment=new Detailwq_item_3_fragment(context,wqdata,7,null,mb);
                flag_dh=8;
                break;
        }
        if (flag_dh_old == flag_dh)
            return;
        if (flag_dh < flag_dh_old) {
            fragmentTransaction.setCustomAnimations(R.anim.left_jr, R.anim.right_exit, R.anim.left_jr, R.anim.left_exit).replace(R.id.wq_s, fragment).commit();
            notifyItemChanged(2);
            flag_dh_old = flag_dh;
        } else {
            fragmentTransaction.setCustomAnimations(R.anim.right_jr, R.anim.left_exit, R.anim.left_jr, R.anim.left_exit).replace(R.id.wq_s, fragment).commit();
            notifyItemChanged(2);
            flag_dh_old = flag_dh;
        }
    }

    static class viewhodler extends RecyclerView.ViewHolder {
        TextView name, wqlx, title;
        ImageView wqicon, xjicon;
        //item1
        TextView zw, his, story;
        TextView c1,c2,c3,c4,c5,c6,c7,c8;
        public viewhodler(@NonNull View itemView) {
            super(itemView);
            switch (po) {
                case 0:
                    title = itemView.findViewById(R.id.text_title);
                    break;
                case 1:
                    name = itemView.findViewById(R.id.name_wq);
                    wqlx = itemView.findViewById(R.id.lx_Wq);
                    wqicon = itemView.findViewById(R.id.wqicon);
                    xjicon = itemView.findViewById(R.id.xjicon);
                    break;
                case 3:
                    zw = itemView.findViewById(R.id.textView4);
                    his = itemView.findViewById(R.id.textView5);
                    break;
                case 2:
                    c1=itemView.findViewById(R.id.c1);
                    c2=itemView.findViewById(R.id.c2);
                    c3=itemView.findViewById(R.id.c3);
                    c4=itemView.findViewById(R.id.c4);
                    c5=itemView.findViewById(R.id.c5);
                    c6=itemView.findViewById(R.id.c6);
                    c7=itemView.findViewById(R.id.c7);
                    c8=itemView.findViewById(R.id.c8);
                    break;
                case 4:
                    story = itemView.findViewById(R.id.story);
            }
        }
    }

    public List<Detail_Wq.CostsDTO.Ascend1DTO> gethz(){
        Map<String, Integer> materialCountMap = new HashMap<>();  // 存储每种材料的count
        List<List<Detail_Wq.CostsDTO.Ascend1DTO>> dtos = new ArrayList<>();
        List<Detail_Wq.CostsDTO.Ascend1DTO> ascend1;
        dtos.add(wqdata.costs.ascend1);
        dtos.add(wqdata.costs.ascend2);
        dtos.add(wqdata.costs.ascend3);
        dtos.add(wqdata.costs.ascend4);
        dtos.add(wqdata.costs.ascend5);
        dtos.add(wqdata.costs.ascend6);
        for (int a = 0; a < dtos.size(); a++) {
            for (int b = 0; b < dtos.get(a).size(); b++) {
                Detail_Wq.CostsDTO.Ascend1DTO ascend1DTO = dtos.get(a).get(b);
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
            ascend1.add(new Detail_Wq.CostsDTO.Ascend1DTO(entry.getKey(), entry.getValue()));
        }
        return ascend1;
    }
}
