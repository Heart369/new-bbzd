package com.example.main.raw.Zdyclass;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.main.R;
import com.example.main.raw.SQLite.BasicSQLite;
import com.example.main.raw.SQLite.SywSQLite;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Csh {
    Context context;

    public Csh(Context context) {
        this.context = context;
    }

//    public void csh(){
//        int s=1;
//        SywSQLite sqLite = new SywSQLite(context,"ck2.db",null,1);
//        SQLiteDatabase database = sqLite.getWritableDatabase();
//        Cursor cursor=database.query("ck",new String[]{"id"},null,null,null,null,null,null);
//        if (cursor.getCount() !=0)
//            database.delete("ck",null,null);
//        ContentValues values = new ContentValues();
//        String[] name=new String[]{"野花记忆的绿野","猎人青翠的箭雨","翠绿猎人的笃定","翠绿猎人的容器","翠绿的猎人之冠"};
//        int[] imga=new int[]{R.drawable.syw_title_ft_1,R.drawable.syw_title_ft_2,R.drawable.syw_title_ft_3,R.drawable.syw_title_ft_4,R.drawable.syw_title_ft_5};
//        for(int a=0;a< name.length;a++){
//            values.put("uid",imga[a]);
//            values.put("size",name[a]);
//            values.put("id",s);
//            values.put("syw",1);
//            s++;
//            database.insert("ck", null, values);
//        }
//        database.close();
//
//
//    }


    public void insertDataFromCSV () {
        try {
            InputStream inputStream = context.getAssets().open("sywname.csv");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            SywSQLite sqLite = new SywSQLite(context,"ck2.db",null,1);
            SQLiteDatabase database = sqLite.getWritableDatabase();
            Cursor cursor=database.query("ck",new String[]{"id"},null,null,null,null,null,null);
            if (cursor.getCount()==0){
                extracted(bufferedReader, database);
            }else {
                for (int a=0;a<cursor.getCount();a++){
                    line = bufferedReader.readLine();
                }
                extracted(bufferedReader,database);
            }
            database.close();
            cursor.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void extracted(BufferedReader bufferedReader, SQLiteDatabase database) throws IOException {
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] data = line.split(",");
            ContentValues values = new ContentValues();
            values.put("id", data[0]);
            values.put("c1", data[1]);
            values.put("c2",data[2]);
            values.put("c3",data[3]);
             values.put("c4",data[4]);
            values.put("c5",data[5]);
            database.insert("ck", null, values);
            Log.d("Icon", data[0]+data[1]/*+data[6]*/);
        }
        database.close();
    }
}
