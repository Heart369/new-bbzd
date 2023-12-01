package com.example.main.raw.Ck;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.main.raw.Adpter.Ck_list_Adpter;
import com.example.main.raw.Class_Custom.PieChartUtil;
import com.example.main.R;
import com.example.main.raw.Zdyclass.MyListView;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

import java.util.HashMap;
import java.util.List;

public class Frament_ck extends Fragment {
    int sy;
    List<String> five;
    List<Integer> list_jsq;
    int[] size;
    Context context;
    int flag;
    private PieChart pieChart;
    private HashMap dataMap;

    public Frament_ck(int sy, List<String> five, List<Integer> list_jsq, int[] size, Context context, int flag) {
        this.sy = sy;
        this.five = five;
        this.list_jsq = list_jsq;
        this.size = size;
        this.context = context;
        this.flag = flag;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.frament_ck,container,false);
        MyListView listView=view.findViewById(R.id.list_ck);

        for (int f=0;f<list_jsq.size();f++)
        {
            Log.d("TAG555",""+list_jsq.get(f));
        }
        Log.d("TAG555",""+size[3]+","+size[7]);
        for (int f=0;f<five.size();f++){
            Log.d("TAG555",""+five.get(f));
        }
        int s;
        int a=0;
        int f,zz;
        float b=0;
        TextView zj=view.findViewById(R.id.text_zj);
        TextView ave=view.findViewById(R.id.text_ave);
        TextView tfive=view.findViewById(R.id.text_five);
        TextView ss=view.findViewById(R.id.text_ss);
        TextView there=view.findViewById(R.id.text_there);
        pieChart=(PieChart)view.findViewById(R.id.pie_chart);
        pieChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry e, Highlight h) {
                PieEntry pieEntry=(PieEntry)e;
                pieChart.setCenterText(pieEntry.getLabel());
            }

            @Override
            public void onNothingSelected() {

            }
        });
        switch (flag){
            case 1:
                dataMap=new HashMap();
                dataMap.put("五星人物",size[3]);
                dataMap.put("四星武器",size[2]);
                dataMap.put("四星人物",size[1]);
                PieChartUtil.getPitChart().setPieChart(pieChart,dataMap,"角色祈愿",true);
                 s=size[3];
                Ck_list_Adpter adpter=new Ck_list_Adpter(s,context,five,list_jsq,sy,0);
                listView.setAdapter(adpter);
                 f=size[0]+size[1]+size[2]+size[3];
                zj.setText("总计："+f+"抽");
                if (size[3]!=0){
                    a=(f)/size[3];
                    b=(float) size[3]/f;

                    b*=100;
                }
                Log.d("JY",""+b);
                zz=(int) (b*100);
                Log.d("JY",""+zz);
                b= (float) ((float) zz/100.0);
                a=a*160;
                ave.setText("平均每金花费："+a+"原石");
                tfive.setText("五星占比："+b+"%");
                s=size[1]+size[2];
                if (s!=0){
                    b=(float) s/f;
                    b*=100;
                    zz=(int) (b*100);
                    b= (float) ((float) zz/100.0);
                }
                ss.setText("四星占比："+b+"%");
                s=size[0];
                if (s!=0){
                    b=(float) s/f;
                    b*=100;
                    zz=(int) (b*100);
                    b= (float) ((float) zz/100.0);
                }
                there.setText("三星占比："+b+"%");
                    break;
            case 2:
                dataMap=new HashMap();
                dataMap.put("五星人物",size[7]);
                dataMap.put("四星武器",size[6]);
                dataMap.put("四星人物",size[5]);
                PieChartUtil.getPitChart().setPieChart(pieChart,dataMap,"武器祈愿",true);
                s=size[7];
                Log.d("TAG66",""+s);
                Ck_list_Adpter adpter1=new Ck_list_Adpter(s,context,five,list_jsq,sy,size[3]);
                listView.setAdapter(adpter1);
                 f=size[4]+size[5]+size[6]+size[7];
                zj.setText("总计："+f+"抽");
                if (size[7]!=0){
                    a=(f-sy)/size[3];
                    b=(float) size[3]/f;
                    b*=100;
                }
                zz=(int) (b*100);
                b= (float) ((float) zz/100.0);
                a=a*160;
                ave.setText("平均每金花费："+a+"原石");
                tfive.setText("五星占比："+b+"%");
                s=size[5]+size[6];
                if (s!=0){
                    b=(float) s/f;
                    b*=100;
                    zz=(int) (b*100);
                    b= (float) ((float) zz/100.0);
                }
                ss.setText("四星占比："+b+"%");
                s=size[4];
                if (s!=0){
                    b=(float) s/f;
                    b*=100;
                    zz=(int) (b*100);
                    b= (float) ((float) zz/100.0);
                }
                there.setText("三星占比："+b+"%");
                break;
            case 3:
                dataMap=new HashMap();
                dataMap.put("五星人物",size[11]);
                dataMap.put("五星武器",size[12]);
                dataMap.put("四星武器",size[10]);
                dataMap.put("四星人物",size[9]);
                PieChartUtil.getPitChart().setPieChart(pieChart,dataMap,"常驻祈愿",true);
                s=size[11]+size[12];
                Log.d("TAG66",""+s);
                Ck_list_Adpter adpter2=new Ck_list_Adpter(s,context,five,list_jsq,sy,size[3]+size[7]);
                listView.setAdapter(adpter2);
                f=size[8]+size[9]+size[10]+size[11]+size[12];
                if (s!=0){
                    a=(f-sy)/s;
                    b=(float) s/f;
                    b*=100;
                }
                zz=(int) (b*100);
                b= (float) ((float) zz/100.0);
                a=a*160;
                ave.setText("平均每金花费："+a+"原石");
                zj.setText("总计："+f+"抽");
                tfive.setText("五星占比："+b+"%");
                s=size[10]+size[9];
                if (s!=0){
                    b=(float) s/f;
                    b*=100;
                    zz=(int) (b*100);
                    b= (float) ((float) zz/100.0);
                }
                ss.setText("四星占比："+b+"%");
                s=size[8];
                if (s!=0){
                    b=(float) s/f;
                    b*=100;
                    zz=(int) (b*100);
                    b= (float) ((float) zz/100.0);
                }
                there.setText("三星占比："+b+"%");
                break;
        }
        return view;
    }
}
