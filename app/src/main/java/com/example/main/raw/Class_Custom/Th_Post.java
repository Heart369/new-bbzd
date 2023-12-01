package com.example.main.raw.Class_Custom;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.example.main.raw.DsAlgorithm.DS_main;
import com.example.main.raw.JsonPares.Js_Wq;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Th_Post extends Thread{
String url;
String uid;
String server;
Handler handler;
String cookie;

    public Th_Post(String url, String uid, String server, String cookie,Handler handler) {
        this.url = url;
        this.uid = uid;
        this.server = server;
        this.cookie = cookie;
        this.handler=handler;
    }

    @Override
    public void run() {
        super.run();
        OkHttpClient httpClient=new OkHttpClient();
        DS_main ds_main=new DS_main(uid,server);
        RequestBody formBody = new FormBody.Builder()
                .build();
        Request getRequest = new Request.Builder()
                .url(url)
                .header("X-Requested-With","com.mihoyo.hyperion")
                .header("x-rpc-app_version","2.11.1")
                .header("User-Agent","Mozilla/5.0 (iPhone; CPU iPhone OS 13_2_3 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) miHoYoBBS/2.11.1")
                .header("DS",ds_main.getDS())
                .header("Host","api-takumi-record.mihoyo.com")
                .header("x-rpc-client_type","5")
                .header("Referer","https://webstatic.mihoyo.com/")
                .header("Cookie",cookie)
                .post(formBody)
                .build();
        Call call = httpClient.newCall(getRequest);
        try {
            Response response = call.execute();
            String data = response.body().string();
            Log.i("TAG12345", "okHttpGet run: response:"+data);
            Gson gson=new Gson();
          Js_Wq js_wq=  gson.fromJson(data, Js_Wq.class);
            Message message=new Message();
            message.obj=js_wq;
            message.what=1;
            handler.sendMessage(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
