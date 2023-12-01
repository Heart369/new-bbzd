package com.example.main.raw.Class_Custom;

import android.os.Message;
import android.util.Log;

import com.example.main.raw.DsAlgorithm.DS_main;
import com.example.main.raw.activity.Sy_Activity;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Th_Sy extends Thread{
    String url,uid,server,cookie;
    int schedule_type;
    int from;

    public Th_Sy(String url, String uid, String server, String cookie, int schedule_type,int from) {
        this.url = url;
        this.uid = uid;
        this.server = server;
        this.cookie = cookie;
        this.schedule_type = schedule_type;
        this.from=from;
    }

    @Override
    public void run() {
        super.run();
        OkHttpClient httpClient=new OkHttpClient();
        DS_main ds_main=new DS_main(uid,server,schedule_type);
        Request getRequest = new Request.Builder()
                .url(url)
                .header("X-Requested-With","com.mihoyo.hyperion")
                .header("x-rpc-app_version","2.11.1")
                .header("User-Agent","Mozilla/5.0 (iPhone; CPU iPhone OS 13_2_3 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) miHoYoBBS/2.11.1")
                .header("DS",ds_main.getDS2())
                .header("Host","api-takumi-record.mihoyo.com")
                .header("x-rpc-client_type","5")
                .header("Referer","https://webstatic.mihoyo.com/")
                .header("Cookie",cookie)
                .get()
                .build();
        Call call = httpClient.newCall(getRequest);
        try {
            Response response = call.execute();
            String data = response.body().string();
            Log.i("TAG", "okHttpGet run: response:"+data);
            Message message=new Message();
            message.obj=data;
            message.what=schedule_type;
            Sy_Activity.handler.sendMessage(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
