package com.example.main.raw.Class_Custom;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.main.mvvm.sqlite.Js_SQLite;
import com.example.main.raw.JsonPares.Jszsg;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Th_jszsg extends Thread{
    String url;
    MutableLiveData<Jszsg> jszsg;
    Context context;
    int flag=-1;
    MutableLiveData<Integer> cx;
    public Th_jszsg(String url,MutableLiveData<Jszsg> jszsg,Context context,int flag,  MutableLiveData<Integer> cx) {
        this.url = url;
        this.jszsg=jszsg;
        this.context=context;
        this.flag=flag;
        this.cx=cx;
    }

    @Override
    public void run() {
        super.run();
        OkHttpClient httpClient=new OkHttpClient();
        Request getRequest = new Request.Builder()
                .url(url)
                .get()
                .build();
        Call call = httpClient.newCall(getRequest);
        try {
            Response response = call.execute();
            String data = response.body().string();
            Log.i("TAG", "okHttpGet run: response:"+data);
            Gson gson=new Gson();
            Js_SQLite sqLite = new Js_SQLite(context, "enka.bd", null, 1);
            SQLiteDatabase database = sqLite.getWritableDatabase();
            Log.d("TAG",data);
            if (data.contains("error")){
            cx.postValue(0);
            return;
            }
            Jszsg jszsg=gson.fromJson(data, Jszsg.class);
            if (jszsg.avatarInfoList==null&&flag==0){
                cx.postValue(0);
                return;
            }
            if (flag==0){
                byte[] jsonData = data.getBytes();
                ContentValues values = new ContentValues();
                values.put("json", jsonData);
                values.put("uid", jszsg.uid);
                database.insert("js", null, values);
                database.close();
                Log.d("TAG","插入成功");
            }else {
                Cursor cursor = database.query("js", new String[]{"json"}, "uid=?", new String[]{jszsg.uid}, null, null, null);
                cursor.moveToNext();
                @SuppressLint("Range") byte[] jsonData = cursor.getBlob(cursor.getColumnIndex("json"));
                String jsonString = new String(jsonData, StandardCharsets.UTF_8);
                Jszsg jszsg2=gson.fromJson(jsonString,Jszsg.class);
                Map<Integer,Integer> xb=new HashMap<>();
                for (int a=0;a<jszsg2.avatarInfoList.size();a++){
                    xb.put(jszsg2.avatarInfoList.get(a).getAvatarId(),a);
                    Log.d("TAG",jszsg2.avatarInfoList.get(a).getAvatarId()+"");
                }
                for (int a=0;a<jszsg.avatarInfoList.size();a++){
                    Log.d("TAG",xb.containsKey(jszsg.avatarInfoList.get(a).avatarId)+","+jszsg.avatarInfoList.get(a).avatarId);
                    if (xb.containsKey(jszsg.avatarInfoList.get(a).avatarId)){
                        Log.d("TAG","进入修改");
                                jszsg2.avatarInfoList.set(xb.get(jszsg.avatarInfoList.get(a).avatarId),jszsg.avatarInfoList.get(a));
                    }else {
                        Log.d("TAG","新增");
                        jszsg2.avatarInfoList.add(jszsg.avatarInfoList.get(a));
                    }
                }
                String data2=gson.toJson(jszsg2);
                 jsonData = data2.getBytes();
                ContentValues values = new ContentValues();
                values.put("json", jsonData);
                values.put("uid", jszsg.uid);
                String whereClause = "uid=?";
                /*修改添加参数*/
                String[] whereArgs = { jszsg.uid};
                /*修改*/
                database.update("js", values, whereClause, whereArgs);
                Log.d("TAG","修改成功"+jszsg2.avatarInfoList.size());
                this.jszsg.postValue(jszsg2);
                database.close();
                cursor.close();
                return;
            }
            database.close();
            this.jszsg.postValue(jszsg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
