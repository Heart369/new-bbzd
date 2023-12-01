package com.example.main.mvvm.adapter.calculator.fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.main.R;
import com.example.main.mvvm.calculator.tool.Sh_data;

import java.text.DecimalFormat;
import java.util.List;

public class Sh_grid extends BaseAdapter {
    List<Sh_data> data;
    Context context;

    public void setData(List<Sh_data> data) {
        this.data = data;
    }

    public Sh_grid(List<Sh_data> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view= LayoutInflater.from(context).inflate(R.layout.sh_item,parent,false);
        TextView name,exp,exp_2;
        name=view.findViewById(R.id.sh_name);
        exp=view.findViewById(R.id.sh_exp);
        name.setText(data.get(position).getName());
        DecimalFormat decimalFormat = new DecimalFormat("#.#");
        double[] d=data.get(position).getExp();
        exp.setText(decimalFormat.format(d[0]));
        exp_2=view.findViewById(R.id.sh_qw);
        exp_2.setText("期望:"+decimalFormat.format(d[1]));
        return view;
    }
}
