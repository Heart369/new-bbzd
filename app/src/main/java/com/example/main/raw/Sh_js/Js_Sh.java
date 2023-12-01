package com.example.main.raw.Sh_js;

import android.content.ContentValues;
import android.util.Log;

import com.example.main.raw.JsonPares.Jszsg;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Js_Sh {
    int uid=114362650;
    public void http_sh(String name ){
        new Thread(new Runnable() {
            @Override
            public void run() {
                {
                    String url ="https://enka.network/api/uid/122271837/";
                    OkHttpClient httpClient = new OkHttpClient();
                    Request request = new Request.Builder()
                            .url(url)
                            .get()
                            .build();
                    Call call = httpClient.newCall(request);
                    try
                    {
                        Response response = null;
                        response = call.execute();
                        String data = response.body().string();
                        System.out.println(data);
                        ContentValues values = new ContentValues();
//                        JsonParser jsonParser = new JsonParser();
//                        JsonArray jsonArray = new JsonParser().parse(str).getAsJsonArray();
                        Gson gson = new Gson();
                        Jszsg date = gson.fromJson(data,Jszsg.class);
//                        date.getPlayerInfo();
//                        date.getAvatarInfoList();
//                        date.getTtl();
//                        date.getUid();
                        Log.d("TAG",name);
                    } catch(
                            IOException e)

                    {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

}

}
