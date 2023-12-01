package com.example.main.raw.Sh_js;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class insertDataFromCSV {
    Context context ;

    public insertDataFromCSV(Context context) {
        this.context = context;
    }

    public void setsqlite () {
        try {
            InputStream inputStream = context.getAssets().open("bbzd1_cs.csv");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            Sywxq sywxq=new Sywxq(context,"sywxc.bd",null,1);
            SQLiteDatabase database = sywxq.getWritableDatabase();
            Cursor cursor=database.query("mytable",new String[]{"id"},null,null,null,null,null,null);
            if (cursor.getCount()==0){
                extracted(bufferedReader, database);
            }else {
                for (int a=0;a<cursor.getCount();a++){
                    line = bufferedReader.readLine();
                }
                extracted(bufferedReader,database);
            }
            cursor.close();
            database.close();
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
            values.put("name", data[1]);
            values.put("two", data[2]);
            values.put("four",data[3]);
            values.put("star",data[4]);
            values.put("TAG",data[6]);
            database.insert("mytable", null, values);
              Log.d("BBZD", data[0]+data[1]+data[2]+data[3]+data[4]+data[5]);
        }
        database.close();
    }
}
