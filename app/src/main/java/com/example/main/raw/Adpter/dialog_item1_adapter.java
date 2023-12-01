package com.example.main.raw.Adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.main.R;

public class dialog_item1_adapter extends BaseAdapter {
    Context context;
   public int item;

    public dialog_item1_adapter(Context context, int item) {
        this.context = context;
        this.item = item;
    }

    @Override
    public int getCount() {
        return 7;
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
        View view= LayoutInflater.from(context).inflate(R.layout.dialog_item1,parent,false);
        ImageView imageView=view.findViewById(R.id.image_dialog_item1);
        imageView.setVisibility(View.GONE);
        TextView textView=view.findViewById(R.id.textView);
        int po=position+1;
        switch (position){
            case 0: case 1: case 2: case 3: case 4:
                textView.setText(po+"分钟");
                break;
            case 5:
                textView.setText("7分钟");
                break;
            case 6:
                textView.setText("10分钟");
                break;
        }
        if (position==item)
            imageView.setVisibility(View.VISIBLE);

        return view;
    }

}
