package com.example.main.raw.Sh_js;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.main.raw.SQLite.MjSQLite;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class insertDataFromCSV1 {
    Context context ;

    public insertDataFromCSV1(Context context) {
        this.context = context;
    }

    public void setsqlite () {
        try {
            InputStream inputStream = context.getAssets().open("bbzd2.csv");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
           MjSQLite sywxq=new MjSQLite(context,"mj.bd",null,1);

            SQLiteDatabase database = sywxq.getWritableDatabase();
            Cursor cursor=database.query("mj",new String[]{"name"},null,null,null,null,null,null);
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
            values.put("name",data[0]);
            values.put("xz",data[1]);
            values.put("cc1",data[2]);
            values.put("cc2",data[3]);
            values.put("cc3",data[4]);
            values.put("lx",data[5]);
            values.put("sm",data[6]);
            values.put("gj",data[7]);
            database.insert("mj", null, values);
            Log.d("BBZD", data[0]+data[1]+data[2]+data[3]+data[4]);
        }
        database.close();
    }
}
