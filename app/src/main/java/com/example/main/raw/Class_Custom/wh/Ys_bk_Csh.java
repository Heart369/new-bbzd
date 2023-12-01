package com.example.main.raw.Class_Custom.wh;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.main.raw.JsonPares.jsdata;
import com.example.main.raw.SQLite.MidSQLite;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Ys_bk_Csh extends Thread {
    Context context;

    public Ys_bk_Csh(Context context) {
        this.context = context;
    }

    @Override
    public void run() {
        super.run();
        String[] jsname = new String[]{"达达利亚", "神里绫人", "可莉", "迪奥娜", "安柏", "芭芭拉", "砂糖", "迪卢克", "莫娜", "琴", "优菈", "班尼特", "诺艾尔", "雷泽", "阿贝多"
                , "温迪", "菲谢尔", "罗莎莉亚", "凯亚", "丽莎", "刻晴", "七七", "申鹤", "夜兰", "魈", "凝光", "枫原万叶", "甘雨", "胡桃", "重云", "香菱", "云堇", "瑶瑶", "钟离"
                , "行秋", "辛焱", "烟绯", "北斗", "珊瑚宫心海", "宵宫", "托马", "鹿野院平藏", "荒泷一斗", "神里绫华", "埃洛伊", "久岐忍", "九条裟罗", "八重神子", "雷电将军", "早柚"
                , "五郎", "赛诺", "提纳里", "坎蒂丝", "珐露珊", "艾尔海森", "纳西妲", "多莉", "流浪者", "妮露", "柯莱", "迪希雅", "米卡","白术","卡维","莱依拉","绮良良","琳妮特"
                ,"林尼","菲米尼","那维莱特","莱欧斯利","夏洛蒂","芙宁娜"};
        String[] reversedArray = new String[jsname.length];
        for (int i = 0; i < jsname.length; i++) {
            reversedArray[i] = jsname[jsname.length - 1 - i];
        }
        jsname=reversedArray;
        int cz = 0;
        MidSQLite sqLite = new MidSQLite(context, "js.db", null, 1);
        SQLiteDatabase database_js = sqLite.getWritableDatabase();
        Cursor cursor = database_js.query("js", new String[]{"name"}, null, null, null, null, null, null);
        if (cursor.getCount() != jsname.length)
        for (String name:jsname) {
             cursor = database_js.query("js", new String[]{"name"}, "name=?", new String[]{name}, null, null, null, null);
             if (cursor.getCount()!=0)
                 continue;
            String url = "https://api.minigg.cn/characters" + "?query=" + name;
            OkHttpClient httpClient = new OkHttpClient();
            Request getRequest = new Request.Builder()
                    .url(url)
                    .get()
                    .build();
            Call call = httpClient.newCall(getRequest);
            Response response = null;
            try {
                response = call.execute();
                String data = response.body().string();
                ContentValues values = new ContentValues();
                Gson gson = new Gson();
                jsdata date = gson.fromJson(data, jsdata.class);
                values.put("name", date.getName());
                values.put("rarity", date.getRarity());
                values.put("weapontype", date.getWeapontype());
                values.put("cover1", date.getImages().getCover1());
                values.put("icon", date.images.nameicon);
                values.put("element", date.getElement());
                values.put("region", date.getRegion());
                database_js.insert("js", null, values);
                Log.d("TAG", name + "," + date.getElement());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        database_js.close();
    }
}
