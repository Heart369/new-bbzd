package com.example.main.mvvm.adapter.sywadapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.example.main.R;
import com.example.main.mvvm.sywmnq.Syw_Viewmodel;
import com.example.main.raw.Sh_js.Sywxq;

import java.util.List;
@SuppressLint("Range")
public class Grid_syw_adapter extends BaseAdapter {
    Context context;
    List<Syw_Viewmodel.Fb> fb;
    int[] image=new int[]{R.drawable.zxty,R.drawable.mjzg,R.drawable.fnezd,R.drawable.gynxc,R.drawable.wwyjms,R.drawable.hcyy,R.drawable.mjzg,R.drawable.yzyg,R.drawable.jycm,R.drawable.jycm,R.drawable.jyt,R.drawable.cjdcx};
    SQLiteDatabase database_syw;
    public Grid_syw_adapter(Context context, List<Syw_Viewmodel.Fb> fb) {
        this.context = context;
        this.fb = fb;
        Sywxq sywxq=new Sywxq(context,"sywxc.bd",null,1);
        database_syw = sywxq.getWritableDatabase();
    }

    @Override
    public int getCount() {
        return fb.size();
    }

    @Override
    public Object getItem(int position) {
        return fb.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view= LayoutInflater.from(context).inflate(R.layout.grid_syw,parent,false);
        TextView title=view.findViewById(R.id.mj_title);
        title.setText(fb.get(position).getName()+" "+fb.get(position).getCc1().substring(0,2)+"/"+fb.get(position).getCc2().substring(0,2));
        ImageView back=view.findViewById(R.id.mjback);
        back.setImageResource(image[position]);
        Cursor cursor=database_syw.query("mytable",new String[]{"id"},"name=?",new String[]{fb.get(position).getCc1()},null,null,null,null);
        cursor.moveToNext();
        String id=cursor.getString(cursor.getColumnIndex("id"));
        ImageView cc1=view.findViewById(R.id.cc1),cc2=view.findViewById(R.id.cc2);
        Glide.with(context)
                .load("https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_"+id+"_4.png")
                .fitCenter()
                .error(R.drawable.os_kl_cs)
                .placeholder(R.drawable.os_kl_cs)
                .transform(new RoundedCorners(15))
                .into(cc1);
        cursor.close();
        cursor=database_syw.query("mytable",new String[]{"id"},"name=?",new String[]{fb.get(position).getCc2()},null,null,null,null);
        cursor.moveToNext();
        id=cursor.getString(cursor.getColumnIndex("id"));
        Glide.with(context)
                .load("https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_"+id+"_4.png")
                .fitCenter()
                .error(R.drawable.os_kl_cs)
                .placeholder(R.drawable.os_kl_cs)
                .transform(new RoundedCorners(15))
                .into(cc2);
        cursor.close();
        return view;
    }
}
