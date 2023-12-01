package com.example.main.mvvm.adapter.detail_wq;

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
import com.example.main.mvvm.json.Detail_Wq;
import com.example.main.raw.SQLite.BasicSQLite;

import java.util.List;

public class Fragment_list_adapter extends BaseAdapter {
    Context context;
    List<Detail_Wq.CostsDTO.Ascend1DTO> data;
    SQLiteDatabase database;
    public Fragment_list_adapter(Context context, List<Detail_Wq.CostsDTO.Ascend1DTO> data) {
        this.context = context;
        this.data = data;
        BasicSQLite basicSQLite = new BasicSQLite(context,"icon.bd",null,1);
        database = basicSQLite.getWritableDatabase();
    }

    @Override
    public int getCount() {
        int a=data.size();
        if (a%2!=0)
            a++;
        return a/2;
    }

    @Override
    public Object getItem(int position) {

        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint("Range")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view= LayoutInflater.from(context).inflate(R.layout.detailwq_item3_item,parent,false);
        ImageView i1,i2;
        i1=view.findViewById(R.id.i1);
        i2=view.findViewById(R.id.i2);
        Cursor cursor= database.query("icon",new String[]{"name","url"},"name=?",new String[]{""+data.get(position*2).name},null,null,null);
        cursor.moveToNext();
        if (cursor.getCount()!=0){
          String url=cursor.getString(cursor.getColumnIndex("url"));
            Glide.with(context)
                    .load(url)
                    .fitCenter()
                    .error(R.drawable.ys_s)
                    .placeholder(R.drawable.ic_launcher_background)
                    .transform(new RoundedCorners(12))
                    .into(i1);
        }
        cursor.close();
        TextView t1,t2,s1,s2;
        t1=view.findViewById(R.id.t1_wq);
        t2=view.findViewById(R.id.t2_wq);
        s1=view.findViewById(R.id.t1_sl);
        s2=view.findViewById(R.id.t2_sl);
        t1.setText(data.get(position*2).name);
        s1.setText("*"+data.get(position*2).count);
        if (position*2+1>=data.size()){
            t2.setVisibility(View.GONE);
            s2.setVisibility(View.GONE);
            i2.setVisibility(View.GONE);
            return view;
        }
         cursor= database.query("icon",new String[]{"name","url"},"name=?",new String[]{""+data.get(position*2+1).name},null,null,null);
        cursor.moveToNext();
        if (cursor.getCount()!=0){
            String url=cursor.getString(cursor.getColumnIndex("url"));
            Glide.with(context)
                    .load(url)
                    .fitCenter()
                    .error(R.drawable.ys_s)
                    .placeholder(R.drawable.ic_launcher_background)
                    .transform(new RoundedCorners(12))
                    .into(i2);
        }
        cursor.close();
        t2.setText(data.get(position*2+1).name);
        s2.setText("*"+data.get(position*2+1).count);
        return view;
    }
    public void del(){
        context=null;
        database.close();
    }
}
