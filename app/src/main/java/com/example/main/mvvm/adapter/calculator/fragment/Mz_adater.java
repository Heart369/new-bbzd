package com.example.main.mvvm.adapter.calculator.fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.example.main.R;
import com.example.main.mvvm.calculator.role.Obj_calculator;

public class Mz_adater extends BaseAdapter {
    Obj_calculator obj_calculator;
    Context context;
    int mz=0;

    public void setObj_calculator(Obj_calculator obj_calculator) {
        this.obj_calculator = obj_calculator;
    }

    public Mz_adater(Obj_calculator obj_calculator, Context context) {
        this.obj_calculator = obj_calculator;
        this.context = context;
        if (obj_calculator.getJszsg_fb().getTalentIdList()!=null)
            mz=obj_calculator.getJszsg_fb().getTalentIdList().size();
    }

    @Override
    public int getCount() {
        return 6;
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
        View view = LayoutInflater.from(context).inflate(R.layout.calculator_item_2, parent, false);
        ImageView i1 =view.findViewById(R.id.image_tx);
        ImageView i2=view.findViewById(R.id.wjs);
        Glide.with(context)
                .load("https://enka.network/ui/"+obj_calculator.getDu().getConsts().get(position)+".png")
                .fitCenter()
                .placeholder(R.drawable.ic_launcher_background)
                .transform(new RoundedCorners(100))
                .into(i1);
        if (position<mz)
            i2.setVisibility(View.GONE);
        return view;
    }

    public void setMz(int mz) {
        this.mz = mz;
        notifyDataSetChanged();
    }
}
