package com.example.main.raw.Adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.main.R;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class List_History_Adpter extends BaseAdapter {
    List<String> uid_list=new ArrayList<>();
    List<String> size_list=new ArrayList<>();
    Context context;
    int hzz=0;
    int[] size=new int[13];

    public List_History_Adpter(List<String> uid_list, List<String> size_list, Context context) {
        this.uid_list = uid_list;
        this.size_list = size_list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return uid_list.size();
    }

    @Override
    public Object getItem(int position) {
        return uid_list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        hzz=0;
        View view= LayoutInflater.from(context).inflate(R.layout.history_item,parent,false);
        TextView uid=view.findViewById(R.id.uid);
        uid.setText("UID："+uid_list.get(position));
        TextView hz=view.findViewById(R.id.hz);
        String data=size_list.get(position);
        try {
            JSONArray jsonArray=new JSONArray(data);
            for(int a=0;a<jsonArray.length();a++){
                size[a]=(int) jsonArray.get(a);
                hzz+=size[a];
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


        hz.setText("共计："+hzz+"抽");
        return view;
    }
}
