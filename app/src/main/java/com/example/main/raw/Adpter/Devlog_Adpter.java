package com.example.main.raw.Adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.main.R;

import java.util.List;

public class Devlog_Adpter extends BaseAdapter {
    List<String> time, data;
    Context context;

    public Devlog_Adpter(List<String> time, List<String> data, Context context) {
        this.time = time;
        this.data = data;
        this.context = context;
    }

    @Override
    public int getCount() {
        return time.size();
    }

    @Override
    public Object getItem(int position) {
        return time.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.devlog, parent,false);
        TextView textView1 = view.findViewById(R.id.text_rq);
        TextView textView2 = view.findViewById(R.id.text_log);
        textView1.setText(time.get(position));
        textView2.setText(data.get(position));
        return view;
    }
}
