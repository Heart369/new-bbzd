package com.example.main.mvvm.adapter.detail_js;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.example.main.R;
import com.example.main.mvvm.json.Detail_role;
import com.example.main.mvvm.sqlite.Get_Icon;
import com.example.main.raw.SQLite.BasicSQLite;

import java.util.List;

public class Fragmet_adapter extends BaseAdapter {
    List<Detail_role.CostsDTO.Ascend1DTO> role;
    Context context;

    SQLiteDatabase database;

    public Fragmet_adapter(List<Detail_role.CostsDTO.Ascend1DTO> role, Context context) {
        this.role = role;
        this.context = context;

        BasicSQLite basicSQLite = new BasicSQLite(context,"icon.bd",null,1);
        database = basicSQLite.getWritableDatabase();
    }

    @Override
    public int getCount() {
        return role.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    @SuppressLint("Range")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view=LayoutInflater.from(context).inflate(R.layout.fragmet_adapter_item,parent,false);
        ImageView back=view.findViewById(R.id.image_cl);
        Cursor cursor= database.query("icon",new String[]{"name","url"},"name=?",new String[]{""+role.get(position).name},null,null,null);
        cursor.moveToNext();
        if (cursor.getCount()!=0){
           String url=cursor.getString(cursor.getColumnIndex("url"));
            Glide.with(context)
                    .load(url)
                    .fitCenter()
                    .error(R.drawable.ys_s)
                    .placeholder(R.drawable.ic_launcher_background)
                    .transform(new RoundedCorners(12))
                    .into(back);
        }
        cursor.close();
        TextView name,age;
        name=view.findViewById(R.id.name_de);
        age=view.findViewById(R.id.age_de);
        name.setText(role.get(position).name);
        age.setText("*"+role.get(position).count);
        return view;
    }
    public void setnull(){
        database.close();
    }
}
