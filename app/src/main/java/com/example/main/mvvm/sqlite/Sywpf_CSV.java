package com.example.main.mvvm.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.main.raw.SQLite.Sywpf_SQLite;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Sywpf_CSV {
    Context context ;

    public Sywpf_CSV(Context context) {
        this.context = context;
    }

    public void setsqlite () {
        try {
            InputStream inputStream = context.getAssets().open("js_pf.csv");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            Sywpf_SQLite sywxq=new  Sywpf_SQLite(context,"js_pf.bd",null,1);
            SQLiteDatabase database = sywxq.getWritableDatabase();
            Cursor cursor = database.query("pf", new String[]{"uid"}, null, null, null, null, null);
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
            values.put("uid", data[0]);
            values.put("FIGHT_PROP_CRITICAL", data[1]);
            values.put("FIGHT_PROP_CRITICAL_HURT", data[2]);
            values.put("FIGHT_PROP_ATTACK_PERCENT", data[3]);
            values.put("FIGHT_PROP_ATTACK", data[4]);
            values.put("FIGHT_PROP_DEFENSE_PERCENT", data[5]);
            values.put("FIGHT_PROP_DEFENSE", data[6]);
            values.put("FIGHT_PROP_HP_PERCENT", data[7]);
            values.put("FIGHT_PROP_HP", data[8]);
            values.put("FIGHT_PROP_ELEMENT_MASTERY", data[9]);
            values.put("FIGHT_PROP_CHARGE_EFFICIENCY", data[10]);
            database.insert("pf", null, values);
            Log.d("BBZD", data[0]);
        }
        database.close();
    }
}
