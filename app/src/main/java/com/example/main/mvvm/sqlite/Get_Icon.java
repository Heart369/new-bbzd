package com.example.main.mvvm.sqlite;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.main.raw.SQLite.BasicSQLite;

@SuppressLint("Range")
public class Get_Icon {
    Context context;
    SQLiteDatabase database;
   static Get_Icon get_icon;
   int a=0;
  static public Get_Icon get_icon(Context context){
       if (get_icon==null)
          return get_icon=new Get_Icon(context.getApplicationContext());
       else return get_icon;
   }
     private Get_Icon(Context context) {
        this.context = context;
        BasicSQLite basicSQLite = new BasicSQLite(context,"icon.bd",null,1);
        database = basicSQLite.getWritableDatabase();
    }

    public String geticon(String name){
        Log.d("TAG",a+"");
        a++;
        Cursor cursor= database.query("icon",new String[]{"name","url"},"name=?",new String[]{""+name},null,null,null);
        cursor.moveToNext();
        if (cursor.getCount()!=0){
            String url=cursor.getString(cursor.getColumnIndex("url"));
            return url;
        }
           return "https://patchwiki.biligame.com/images/ys/thumb/c/c1/6thsa0oxlbm2m4jefbrmt647xi0ynex.png/90px-%E5%8F%A3%E8%A2%8B%E9%94%9A%E7%82%B9.png.jpeg";

    }
}
