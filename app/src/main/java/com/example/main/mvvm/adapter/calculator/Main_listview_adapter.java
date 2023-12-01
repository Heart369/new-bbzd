package com.example.main.mvvm.adapter.calculator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.main.R;
import com.example.main.raw.JsonPares.Jszsg;

import java.util.List;


public class Main_listview_adapter extends BaseAdapter {
    List<Jszsg> jszsg;
    Context context;
    List<String> uids;
    Del del;
    public Main_listview_adapter(List<Jszsg> uid, Context context, List<String> uids,Del del) {
        this.jszsg = uid;
        this.context = context;
        this.uids=uids;
        this.del=del;
    }

    @Override
    public int getCount() {
        return uids.size();
    }

    @Override
    public Object getItem(int position) {
        return jszsg.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view= LayoutInflater.from(context).inflate(R.layout.main_list_item,parent,false);
        TextView name,uid;
        name=view.findViewById(R.id.textView_name);
        uid=view.findViewById(R.id.text_uid);
        name.setText(jszsg.get(position).playerInfo.nickname);
        uid.setText(jszsg.get(position).uid);
        ImageView ls=view.findViewById(R.id.del);
        ls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                del.del(position);
            }
        });
        return view;
    }
    public interface Del{
        public void del(int po);
    }
}
