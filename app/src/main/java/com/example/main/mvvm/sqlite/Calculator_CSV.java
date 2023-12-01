package com.example.main.mvvm.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.main.raw.SQLite.CalSQLite;
import com.example.main.raw.SQLite.GifSQLite;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Calculator_CSV {
    Context context ;

    public Calculator_CSV(Context context) {
        this.context = context;
    }

    public void setsqlite () {
        try {
            InputStream inputStream = context.getAssets().open("cal.csv");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            CalSQLite sywxq=new CalSQLite(context,"cal.bd",null,1);
            SQLiteDatabase database = sywxq.getWritableDatabase();
            Cursor cursor = database.query("cal", new String[]{"id"}, null, null, null, null, null);
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
            if (data[0].length()==0)
                return;
            ContentValues values = new ContentValues();
            values.put("id", data[0]);
            Log.d("BBZD", data[0]);
            values.put("name", data[1]);
            database.insert("cal", null, values);
            Log.d("BBZD", data[0]+data[1]);
        }
        database.close();
    }
}
