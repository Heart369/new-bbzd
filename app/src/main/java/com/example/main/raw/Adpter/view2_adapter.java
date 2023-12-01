package com.example.main.raw.Adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.main.R;

public class view2_adapter extends BaseAdapter {
    Context context; int i; String[] data;String[] data2;
    int[] image=new int[]{R.drawable.view1_3,R.drawable.view1_1,R.drawable.view1_2,R.drawable.view1_5,R.drawable.view1_4,R.drawable.view1_6};
    public view2_adapter(Context context, int i, String[] data, String[] data2) {
        this.context = context;
        this.i = i;
        this.data = data;
        this.data2 = data2;
    }

    @Override
    public int getCount() {
        return i;
    }

    @Override
    public Object getItem(int position) {
        return data[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view= LayoutInflater.from(context).inflate(R.layout.view2_item,parent,false);
        TextView textView=view.findViewById(R.id.text_view2);
        TextView textView1=view.findViewById(R.id.textview_3);
        textView1.setText(data2[position]);
        textView.setText(data[position]);
        ImageView imageView=view.findViewById(R.id.view2_image);
        imageView.setImageResource(image[position]);
        return view;
    }
}
