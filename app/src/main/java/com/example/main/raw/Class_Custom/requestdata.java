package com.example.main.raw.Class_Custom;

import android.util.Log;

import com.example.main.raw.DsAlgorithm.DS_main;
import com.example.main.raw.activity.MainActivity;
import com.example.main.raw.utils.DeviceIdUtils;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class requestdata extends Thread {
    String data = null;
    boolean flag=false;
    String uid;
    String server;



    public void run1(String url,String cookie, String uid,String server) throws IOException {
        OkHttpClient httpClient = new OkHttpClient();
        DS_main ds_main = new DS_main(uid,server);

        Request getRequest = new Request.Builder()
                .url(url)
                .header("X-Requested-With", "com.mihoyo.hyperion")
                .header("x-rpc-app_version", "2.11.1")
                .header("User-Agent", "Mozilla/5.0 (Linux; Android 13; V2055A Build/TKQ1.220829.002; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/108.0.5359.128 Mobile Safari/537.36 miHoYoBBS/2.51.1")
                .header("DS", ds_main.getDS())
                .header("Host", "api-takumi-record.mihoyo.com")
                .header("x-rpc-client_type", "5")
                .header("Origin","https://api-takumi-record.mihoyo.com")
                .addHeader("x-rpc-device_id", MainActivity.DeviceId)
                .header("Referer", "https://webstatic.mihoyo.com/")
                .header("x-rpc-device_fp","38d7f15afb3b0")
                .header("Cookie", cookie)
                .get()
                .build();
        Call call = httpClient.newCall(getRequest);
        data = call.toString();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //同步请求，要放到子线程执行
                    Log.d("TAG","进入子线程"+MainActivity.DeviceId);
                    Response response = call.execute();
                     data = response.body().string();
                    Log.i("TAG1111", "okHttpGet run: response:"+data);
                    flag=true;

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

}
    public String getdata(){

        if (flag)
        return data;
        else  return "NO";
    }

}
