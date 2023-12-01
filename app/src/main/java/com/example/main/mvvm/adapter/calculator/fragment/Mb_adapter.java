package com.example.main.mvvm.adapter.calculator.fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.main.R;
import com.example.main.mvvm.calculator.role.Obj_calculator;

import java.text.DecimalFormat;

public class Mb_adapter extends BaseAdapter {
    Context context;
    Obj_calculator obj_calculator;
    String[] data=new String[]{"生命值","攻击力","元素精通","防御力","暴击率","暴击伤害","元素充能效率","属性伤害加成:"};
    String[] exp=new String[8];
    String data2;

    public void setObj_calculator(Obj_calculator obj_calculator) {
        this.obj_calculator = obj_calculator;
    }

    public Mb_adapter(Context context, Obj_calculator obj_calculator) {
        this.context = context;
        this.obj_calculator = obj_calculator;
        DecimalFormat decimalFormat = new DecimalFormat("#");
        DecimalFormat decimalFormat2 = new DecimalFormat("0.#%");
        exp[0]=decimalFormat.format(obj_calculator.getSmz(0));
        exp[1]=decimalFormat.format(obj_calculator.getGj(0));
        exp[2]=decimalFormat.format(obj_calculator.getYsjt(0));
        exp[3]=decimalFormat.format(obj_calculator.getFyl(1));
        exp[4]=decimalFormat2.format(obj_calculator.getBjl("-1", 0));
        exp[5]=decimalFormat2.format(obj_calculator.getBj("0")-1);
        exp[6]=decimalFormat2.format(obj_calculator.getYscn(0));
        exp[7]=decimalFormat2.format(obj_calculator.getSx());
    }

    @Override
    public int getCount() {
        return 8;
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
        View view = LayoutInflater.from(context).inflate(R.layout.mb_item, parent, false);
        if (position == 0)
            view.setBackground(context.getDrawable(R.drawable.shape_cal_b_yi));
        else if (position == 7)
            view.setBackground(context.getDrawable(R.drawable.shape_cal_h_yj));
        else if (position % 2 == 0)
            view.setBackground(context.getDrawable(R.drawable.shape_cal_b));
        else
            view.setBackground(context.getDrawable(R.drawable.shape_cal_h));
        TextView name,exp;
        name=view.findViewById(R.id.mb_name);
        exp=view.findViewById(R.id.mb_exp);
        name.setText(data[position]);
        exp.setText(this.exp[position]);
        return view;
    }
}
