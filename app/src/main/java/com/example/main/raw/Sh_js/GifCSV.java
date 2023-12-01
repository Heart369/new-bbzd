package com.example.main.raw.Sh_js;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.main.raw.SQLite.GifSQLite;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class GifCSV {
    Context context ;

    public GifCSV(Context context) {
        this.context = context;
    }

    public void setsqlite () {
        try {
            InputStream inputStream = context.getAssets().open("gif.csv");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
           GifSQLite sywxq=new GifSQLite(context,"gif.bd",null,1);
            SQLiteDatabase database = sywxq.getWritableDatabase();
            Cursor cursor = database.query("gif", new String[]{"name"}, null, null, null, null, null);
            if (cursor.getCount()==0){
                extracted(bufferedReader, database);
            }else {
                for (int a=0;a<cursor.getCount();a++){
                    line = bufferedReader.readLine();
                    String[] data = line.split(",");
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
            values.put("name", data[0]);
            values.put("gif1", data[1]);
            values.put("gif2", data[2]);
            values.put("gif3", data[3]);
            database.insert("gif", null, values);
            Log.d("BBZD", data[0]+data[1]+data[2]+data[3]);
        }
    }
}
