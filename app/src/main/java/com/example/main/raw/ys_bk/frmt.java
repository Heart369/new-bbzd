package com.example.main.raw.ys_bk;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import com.example.main.R;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class frmt extends Fragment {
    Context context;
    SQLiteDatabase database;
    List<js_data> data;
    ListView listView;
    Handler handler;
    int flag=0,top=0;
    public frmt(Context context, SQLiteDatabase database,Handler handler) {
        this.context = context;
        this.database = database;
        this.handler=handler;
    }
    int a=1;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Nullable
    @Override
    @SuppressLint("Range")
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.listview_fragment,container,false);
        listView=view.findViewById(R.id.list);
        Cursor cursor=database.query("js",new String[]{"name","weapontype","cover1","icon","rarity","region","element"},null,null,null,null,null,null);
        data=new ArrayList<>();
        for (int f=cursor.getCount();f>0;f--){
            cursor.moveToNext();
           String name=cursor.getString(cursor.getColumnIndex("name"));
           String weapontype=cursor.getString(cursor.getColumnIndex("weapontype"));
           String cover1=cursor.getString(cursor.getColumnIndex("cover1"));
           String icon=cursor.getString(cursor.getColumnIndex("icon"));
           int star=cursor.getInt(cursor.getColumnIndex("rarity"));
            String element=cursor.getString(cursor.getColumnIndex("element"));
            String region=cursor.getString(cursor.getColumnIndex("region"));
           js_data js_data=new js_data(name,cover1,icon,weapontype,element,region,star);
           data.add(js_data);
        }
        List<js_data> dataSorted;
        dataSorted = data.stream()
                .sorted(Comparator.comparing(js_data::getStar).reversed())
                .collect(Collectors.toList());
        list_adapter adapter=new list_adapter(context,dataSorted);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(context, ""+position, Toast.LENGTH_SHORT).show();
            }
        });
        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
               if (firstVisibleItem==1){
                   Message message=new Message();
                   message.what=1;
                   handler.sendMessage(message);
               }if (firstVisibleItem==0){
                    Message message=new Message();
                    message.what=2;
                    handler.sendMessage(message);
                }
            }
        });


        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        database.close();
        data=null;
        context=null;
    }
}
