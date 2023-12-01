package com.example.main.mvvm.adapter.detail_js;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.main.R;

import java.util.List;

public class List_f4_adapter extends BaseAdapter {
    Context context;
    List<Recy_f4_adapter.Hi_text> hi_texts;

    public List_f4_adapter(Context context, List<Recy_f4_adapter.Hi_text> hi_texts) {
        this.context = context;
        this.hi_texts = hi_texts;
    }

    @Override
    public int getCount() {
        return hi_texts.size();
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
        View view= LayoutInflater.from(context).inflate(R.layout.f4_item_dg,parent,false);
        TextView textView=view.findViewById(R.id.tt);
        textView.setText(hi_texts.get(position).getText());
        LinearLayout.LayoutParams params= (LinearLayout.LayoutParams) textView.getLayoutParams();
        params.height=hi_texts.get(position).hi;
        return view;
    }
}
