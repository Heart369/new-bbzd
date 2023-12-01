package com.example.main.raw.ys_bk;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.main.raw.SQLite.BasicSQLite;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class IcondataFormCSV {
    Context context ;

    public IcondataFormCSV(Context context) {
        this.context = context;
    }

    public void insertDataFromCSV () {
        try {
            InputStream inputStream = context.getAssets().open("icon.csv");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            BasicSQLite basicSQLite = new BasicSQLite(context,"icon.bd",null,1);
            SQLiteDatabase database = basicSQLite.getWritableDatabase();
            Cursor cursor= database.query("icon",new String[]{"name"},null,null,null,null,null);
            if (cursor.getCount()==0){
                extracted(bufferedReader, database);
            }else {
                for (int a=0;a<cursor.getCount();a++){
                    line = bufferedReader.readLine();
                }
                extracted(bufferedReader,database);
            }
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
            if (data.length<1){
                Log.d("TAG",line);
                continue;
            }
            values.put("name", data[0]);
            values.put("url", data[1]);
            database.insert("icon", null, values);
//            Log.d("Icon", data[0]+data[1]/*+data[6]*/);
        }
        database.close();
    }
}
