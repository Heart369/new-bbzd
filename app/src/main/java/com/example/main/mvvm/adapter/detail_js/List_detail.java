package com.example.main.mvvm.adapter.detail_js;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.main.R;
import com.example.main.mvvm.json.Detail_role;

public class List_detail extends BaseAdapter {
    Context context;
    Detail_role role;

    public List_detail(Context context, Detail_role role) {
        this.context = context;
        this.role = role;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public Object getItem(int position) {
        return role.name;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view= LayoutInflater.from(context).inflate(R.layout.detail_grid_item,parent,false);
        TextView t1,t2,d1,d2;
        t1=view.findViewById(R.id.t1);
        t2=view.findViewById(R.id.t2);
        d1=view.findViewById(R.id.d1);
        d2=view.findViewById(R.id.d2);
        if (position==0){
            t1.setText("生日");
            t2.setText("所属");
            d1.setText(role.birthday);
            d2.setText(role.affiliation);
        }else if (position==1){
            t1.setText("神之眼");
            t2.setText("武器类型");
            d1.setText(role.element);
            d2.setText(role.weapontype);
        }else {
            t1.setText("命之座");
            t2.setText("称号");
            d1.setText(role.constellation);
            d2.setText(role.title);
        }
        return view;
    }
}
