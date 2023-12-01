package com.example.main.mvvm.ys_bk.fragment;


import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.main.R;
import com.example.main.mvvm.adapter.detail_wq.Fragment_list_adapter;
import com.example.main.mvvm.json.Detail_Wq;
import com.example.main.raw.Zdyclass.MyListView;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

public class Detailwq_item_3_fragment extends Fragment {
    public Detailwq_item_3_fragment() {
    }

    Context context;
    Detail_Wq wqdata;
    int c;
    Fragment_list_adapter adapter;

    List<Detail_Wq.CostsDTO.Ascend1DTO> data;
    Map<Integer, Detail_Wq> mb;

    public Detailwq_item_3_fragment(Context context, Detail_Wq wqdata, int c, List<Detail_Wq.CostsDTO.Ascend1DTO> data, Map<Integer, Detail_Wq> mb) {
        this.context = context;
        this.wqdata = wqdata;
        this.c = c;
        this.data = data;
        this.mb = mb;

    }

    @SuppressLint("Range")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detailwq, container, false);
        MyListView listView = view.findViewById(R.id.grid_framget);
        LinearLayout layout = view.findViewById(R.id.lin_wq);
        if (data != null) {
            adapter = new Fragment_list_adapter(context, data);
            listView.setAdapter(adapter);
        } else layout.setVisibility(View.GONE);
        if (mb != null) {
            TextView bz, lz, mjbz, mjlz;
            bz = view.findViewById(R.id.bz);
            lz = view.findViewById(R.id.lz);
            mjbz = view.findViewById(R.id.mjbz);
            mjlz = view.findViewById(R.id.mjlz);
            switch (c) {
                case 0:
                    extracted(bz, lz,1);
                    ave(mjbz, mjlz,1,20,20);
                    break;
                case 1:
                    extracted(bz, lz,21);
                    ave(mjbz, mjlz,21,40,20);
                    break;
                case 2:
                    extracted(bz, lz,41);
                    ave(mjbz, mjlz,41,50,10);
                    break;
                case 3:
                    extracted(bz, lz,51);
                    ave(mjbz, mjlz,51,60,10);
                    break;
                case 4:
                    extracted(bz, lz,61);
                    ave(mjbz, mjlz,61,70,10);
                    break;
                case 5:
                    extracted(bz, lz,71);
                    ave(mjbz, mjlz,71,80,10);
                    break;
                case 6:
                    extracted(bz, lz,81);
                    ave(mjbz, mjlz,81,90,10);
                    break;
                case 7:
                    extracted(bz, lz,90);
                    mjbz.setText("已经没有提升啦");
                    mjlz.setText("已经没有提升啦");
                    break;
            }
        }
        return view;
    }

    private void ave(TextView mjbz, TextView mjlz,int a,int b,int c) {
        double fct = mb.get(a).specialized;
        double fct2 = mb.get(b).specialized;
        fct=(fct2-fct)/10;
        String  result= String.valueOf(fct);
        if (fct < 1) {
            DecimalFormat df = new DecimalFormat("#0.0%");
           result = df.format(fct);
        }
        mjlz.setText("平均每级提升:"+result);
        fct=mb.get(a).attack;
        fct2=mb.get(b).attack;
        DecimalFormat zcts = new DecimalFormat("###.#");
        mjbz.setText("平均每级提升:"+zcts.format((fct2-fct)/10));
    }

    private void extracted(TextView bz, TextView lz,int a) {
        DecimalFormat zcts = new DecimalFormat("###.#");
        bz.setText("基础攻击力:" + zcts.format(mb.get(a).attack));
        double fct = mb.get(a).specialized;
        String result = String.valueOf(mb.get(a).specialized);
        if (fct < 1) {
            DecimalFormat df = new DecimalFormat("#0.0%");
            result = df.format(fct);
        }
        lz.setText(wqdata.substat+"："+result);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        adapter = null;
        context = null;
        wqdata = null;
    }


}
