package com.example.main.mvvm.ys_bk.fragment;


import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.main.R;
import com.example.main.mvvm.adapter.detail_js.Fragmet_adapter;
import com.example.main.mvvm.adapter.detail_js.List_f4_adapter;
import com.example.main.mvvm.adapter.detail_js.Recy_f4_adapter;
import com.example.main.raw.Class_Custom.Bl_cl;
import com.example.main.raw.JsonPares.Json_Jstf;
import com.example.main.raw.SQLite.GifSQLite;
import com.example.main.raw.Zdyclass.MyListView;

import java.util.List;

public class Detail_item_4_fragment extends Fragment {
    public Detail_item_4_fragment() {
    }
    Context context;
    int flag=0;
    String url="https://enka.network/ui/";
    Fragmet_adapter adapter = null;
    Json_Jstf json_jstf;
    Bl_cl bl_cl;
    View view;
    RecyclerView recyclerView;
    SQLiteDatabase database;

    public Detail_item_4_fragment(Context context, int flag, Json_Jstf json_jstf, Bl_cl bl_cl) {
        this.context = context;
        this.flag = flag;
        this.json_jstf = json_jstf;
        this.bl_cl = bl_cl;
    }
    @SuppressLint("Range")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_item_4,container,false);
        TextView name,zw;
        ImageView tb=view.findViewById(R.id.tf_tb);
        name=view.findViewById(R.id.tf_name);
        zw=view.findViewById(R.id.zw);
        ImageView gif=view.findViewById(R.id.gif_item);
        GifSQLite sywxq=new GifSQLite(getContext(),"gif.bd",null,1);
        database = sywxq.getWritableDatabase();
        Cursor cursor = database.query("gif", new String[]{"name","gif1","gif2","gif3"}, "name=?",
                new String[]{json_jstf.name}, null, null, null);
        cursor.moveToNext();
        String gif1 =cursor.getString(cursor.getColumnIndex("gif1"));
        String gif2 =cursor.getString(cursor.getColumnIndex("gif2"));
        String gif3 =cursor.getString(cursor.getColumnIndex("gif3"));
        cursor.close();
        gif.setVisibility(View.VISIBLE);
        recyclerView=view.findViewById(R.id.recy_f4);
        MyListView listView=view.findViewById(R.id.list_f4);
        recyclerView.setOverScrollMode(View.OVER_SCROLL_NEVER);

//        LinearLayoutManager manager=new LinearLayoutManager(context);
//        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
//        recyclerView.setLayoutManager(manager);
        GridLayoutManager manager=new GridLayoutManager(context,1);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        Recy_f4_adapter adapter;
        switch (flag){
            case 0:
               adapter=new Recy_f4_adapter(context, json_jstf, bl_cl.getc1(), new Recy_f4_adapter.gethi() {
                   @Override
                   public void get_hi(List<Recy_f4_adapter.Hi_text> hi_texts) {
                       List_f4_adapter adapter=new List_f4_adapter(context,hi_texts);
                       listView.setAdapter(adapter);

                   }

               });
                recyclerView.setAdapter(adapter);
                zw.setText(json_jstf.combat1.info);
                name.setText(json_jstf.combat1.name);
                Glide.with(context).load(url+json_jstf.images.combat1+".png").into(tb);
                    Glide.with(context)
                            .asGif()
                    .load(gif1)
                            .fitCenter()
                    .into(gif);
                break;
            case 1:
                adapter=new Recy_f4_adapter(context, json_jstf, bl_cl.getc2(), new Recy_f4_adapter.gethi() {
                    @Override
                    public void get_hi(List<Recy_f4_adapter.Hi_text> hi_texts) {
                        List_f4_adapter adapter=new List_f4_adapter(context,hi_texts);
                        listView.setAdapter(adapter);
                    }
                });
                recyclerView.setAdapter(adapter);
                zw.setText(json_jstf.combat2.info);
                name.setText(json_jstf.combat2.name);
                Glide.with(context).load(url+json_jstf.images.combat2+".png").into(tb);
                Glide.with(context).asGif()
                        .load(gif2)
                        .fitCenter()
                        .into(gif);
                break;
            case 2:
                adapter=new Recy_f4_adapter(context, json_jstf, bl_cl.getc3(), new Recy_f4_adapter.gethi() {
                    @Override
                    public void get_hi(List<Recy_f4_adapter.Hi_text> hi_texts) {
                        List_f4_adapter adapter=new List_f4_adapter(context,hi_texts);
                        listView.setAdapter(adapter);
                    }
                });
                recyclerView.setAdapter(adapter);
                zw.setText(json_jstf.combat3.info);
                name.setText(json_jstf.combat3.name);
                Glide.with(context).load(url+json_jstf.images.combat3+".png").into(tb);
                Glide.with(context).asGif()
                        .load(gif3)
                        .fitCenter()
                        .into(gif);
                break;
            case 3:
                zw.setText(json_jstf.passive1.info);
                name.setText(json_jstf.passive1.name);
                Glide.with(context).load(url+json_jstf.images.passive1+".png").into(tb);
                gif.setVisibility(View.GONE);
                break;
            case 4:
                zw.setText(json_jstf.passive2.info);
                name.setText(json_jstf.passive2.name);
                Glide.with(context).load(url+json_jstf.images.passive2+".png").into(tb);
                gif.setVisibility(View.GONE);
                break;
            case 5:
                zw.setText(json_jstf.passive3.info);
                name.setText(json_jstf.passive3.name);
                Glide.with(context).load(url+json_jstf.images.passive3+".png").into(tb);
                gif.setVisibility(View.GONE);
                break;
        }
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        adapter=null;
        database.close();

    }


}
