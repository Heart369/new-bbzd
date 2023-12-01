package com.example.main.raw.ys_bk;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.main.raw.Adpter.recy_bk;
import com.example.main.raw.Adpter.recy_bk_syw;
import com.example.main.raw.Adpter.recy_bk_wq;
import com.example.main.raw.Class_Custom.Dp_Px;
import com.example.main.R;
import com.example.main.raw.Sh_js.Sywxq;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
@SuppressLint("Range")
public class frmt_recy extends Fragment {
    Context context;
    SQLiteDatabase database,database_wq,database_syw;
    List<js_data> data;
    List<wq_data> Wq_data;
    List<syw_data> syw_data;
   RecyclerView listView,recy;
    Handler handler;
    Scroll scroll;
    recy_bk adapter1;
    recy_bk_wq adapter;
    recy_bk_syw syw_adapter;
    ScrollView scro;
    int top=0;

    public frmt_recy() {
    }

    public frmt_recy(int top, Context context, SQLiteDatabase database, SQLiteDatabase database_wq, Handler handler, Scroll scroll) {
        this.context = context;
        this.database = database;
        this.handler=handler;
        this.scroll=scroll;
        this.top=top;
        this.database_wq=database_wq;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Nullable
    @Override
    @SuppressLint("Range")
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.listview_fragment,container,false);
        listView=view.findViewById(R.id.list);
        recy=view.findViewById(R.id.list_2);
        recy.setVisibility(View.GONE);
        View view1=view.findViewById(R.id.yjview);
        Dp_Px dp_px=new Dp_Px();
        RelativeLayout.LayoutParams lp= (RelativeLayout.LayoutParams) view1.getLayoutParams();
        lp.setMargins(0,top,0,0);
         lp= (RelativeLayout.LayoutParams)listView.getLayoutParams();
        lp.setMargins(0,dp_px.dip2px(context,40)+top,0,0);
        lp= (RelativeLayout.LayoutParams)recy.getLayoutParams();
        lp.setMargins(0,dp_px.dip2px(context,40)+top,0,0);
         Cursor cursor=database.query("js",new String[]{"name","weapontype","cover1","icon","rarity","region","element"},null,null,null,null,null,null);
        Js_get(cursor);
        cursor=database_wq.query("js",new String[]{"name","weapontype","icon","rarity"},null,null,null,null,null,null);
        Wq_get(cursor);

        Sywxq sywxq=new Sywxq(context,"sywxc.bd",null,1);
        database_syw = sywxq.getWritableDatabase();
        cursor=database_syw.query("mytable",new String[]{"id","name","star","TAG"},null,null,null,null,null,null);
        Syw_get(cursor);
        syw_adapter=new recy_bk_syw(context,syw_data);
        List<wq_data> dataSorted;
        dataSorted = Wq_data.stream()
                .sorted(Comparator.comparing(wq_data::getStar).reversed())
                .collect(Collectors.toList());
      adapter=new recy_bk_wq(context,dataSorted);

        List<js_data> dataSorted1;
        dataSorted1 = data.stream()
                .sorted(Comparator.comparing(js_data::getStar).reversed())
                .collect(Collectors.toList());
       adapter1=new recy_bk(context,dataSorted1);
        LinearLayoutManager layoutManager1=new  LinearLayoutManager(context){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };

        recy.setLayoutManager(layoutManager1);
        recy.setAdapter(adapter);
        extracted();

    scro=view.findViewById(R.id.scro);
    scro.setOnScrollChangeListener(new View.OnScrollChangeListener() {
        @Override
        public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
            scroll.scroll(scrollY);
            if (scrollY<top)
            view1.animate().translationY(-1*scrollY).setDuration(0);
            else {
                view1.animate().translationY(-1*top).setDuration(0);
            }
        }
    });
        return view;
    }

    private void Syw_get(Cursor cursor) {
        syw_data=new ArrayList<>();
        for (int f = cursor.getCount(); f>0; f--){
            cursor.moveToNext();
            String name= cursor.getString(cursor.getColumnIndex("name"));
            String id= cursor.getString(cursor.getColumnIndex("id"));
            int star= cursor.getInt(cursor.getColumnIndex("star"));
            String TAG= cursor.getString(cursor.getColumnIndex("TAG"));
            syw_data date=new syw_data(id,name,TAG,star);
            syw_data.add(date);
        }
    }

    private void Wq_get(Cursor cursor) {
        Wq_data=new ArrayList<>();
        for (int f = cursor.getCount(); f>0; f--){
            cursor.moveToNext();
            String name= cursor.getString(cursor.getColumnIndex("name"));
            String icon="https://enka.network/ui/"+cursor.getString(cursor.getColumnIndex("icon"))+".png";
            String weapontype=cursor.getString(cursor.getColumnIndex("weapontype"));
            int star= cursor.getInt(cursor.getColumnIndex("rarity"));
            wq_data wq_data1=new wq_data(name,icon,weapontype,star);
            Wq_data.add(wq_data1);
        }
    }

    private void Js_get(Cursor cursor) {
        data=new ArrayList<>();
        for (int f = cursor.getCount(); f>0; f--){
            cursor.moveToNext();
           String name= cursor.getString(cursor.getColumnIndex("name"));
           String weapontype= cursor.getString(cursor.getColumnIndex("weapontype"));
           String cover1= cursor.getString(cursor.getColumnIndex("cover1"));
           String icon= "https://enka.network/ui/"+cursor.getString( cursor.getColumnIndex("icon"))+".png";
           int star= cursor.getInt(cursor.getColumnIndex("rarity"));
            String element= cursor.getString(cursor.getColumnIndex("element"));
            String region= cursor.getString(cursor.getColumnIndex("region"));
           js_data js_data=new js_data(name,cover1,icon,weapontype,element,region,star);
           data.add(js_data);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void extracted() {
        LinearLayoutManager layoutManager1=new  LinearLayoutManager(context){
              @Override
              public boolean canScrollVertically() {
                  return false;
              }
          };
        recy.animate().alpha(0f).setDuration(500);
        recy.setVisibility(View.GONE);
        listView.setVisibility(View.VISIBLE);
        listView.setAlpha(0f);
        listView.animate().alpha(1).setDuration(500);
        listView.setLayoutManager(layoutManager1);
        listView.setAdapter(adapter1);
    }

    interface Scroll{
        public int scroll(int y);
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void gxwq(){
        LinearLayoutManager layoutManager1=new  LinearLayoutManager(context){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        listView.animate().alpha(0f).setDuration(500);
        listView.setVisibility(View.GONE);
        recy.setVisibility(View.VISIBLE);
        recy.setAlpha(0f);
        recy.animate().alpha(1).setDuration(500);
         recy.setLayoutManager(layoutManager1);
        recy.setAdapter(adapter);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void gxsyw(){
        LinearLayoutManager layoutManager1=new  LinearLayoutManager(context){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        listView.animate().alpha(0f).setDuration(500);
        recy.setVisibility(View.VISIBLE);
        listView.setVisibility(View.GONE);
        recy.setAlpha(0f);
        recy.animate().alpha(1).setDuration(500);
        recy.setLayoutManager(layoutManager1);
        recy.setAdapter(syw_adapter);
    }
//
//    String query = "SELECT * FROM js WHERE name LIKE '%雷%';";
//    Cursor cursor = database.rawQuery(query, null);

     @RequiresApi(api = Build.VERSION_CODES.N)
     public void Query(int who, String goal){
         String query = "SELECT * FROM js WHERE name LIKE '%"+goal+"%';";

         //  String query = "SELECT * FROM js WHERE (name LIKE '%"+goal+"%' AND rarity LIKE '%4%');";

        switch (who){
            case 0:
                Cursor cursor = database.rawQuery(query, null);
                Js_get(cursor);
                adapter1.setData(data);
                adapter1.notifyDataSetChanged();
                break;
            case 1:
                 cursor = database_wq.rawQuery(query, null);
                 Wq_get(cursor);
                adapter.setData(Wq_data);
                adapter.notifyDataSetChanged();
                break;
            case 2:
                 query = "SELECT * FROM mytable WHERE name LIKE '%"+goal+"%';";
                cursor = database_syw.rawQuery(query, null);
                Syw_get(cursor);
                syw_adapter.setData(syw_data);
                syw_adapter.notifyDataSetChanged();
                break;
            case 3:
                break;
        }
     }
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void Query_sx(String query,int who){
        //  String query = "SELECT * FROM js WHERE (name LIKE '%"+goal+"%' AND rarity LIKE '%4%');";
        switch (who){
            case 0:
                Cursor cursor = database.rawQuery(query, null);
                Js_get(cursor);
                adapter1.setData(data);
                adapter1.notifyDataSetChanged();
                break;
            case 1:
                cursor = database_wq.rawQuery(query, null);
                Wq_get(cursor);
                adapter.setData(Wq_data);
                adapter.notifyDataSetChanged();
                break;
            case 2:
                cursor = database_syw.rawQuery(query, null);
                Syw_get(cursor);
                syw_adapter.setData(syw_data);
                syw_adapter.notifyDataSetChanged();
                break;
            case 3:
                break;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        database.close();
        database_wq.close();
        database_syw.close();
    }
}
