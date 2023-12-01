package com.example.main.raw.DsAlgorithm;

import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.github.mikephil.charting.formatter.IFillFormatter;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Sign {
    String cookie;
    String uid;
    Handler handler;

    public Sign(String cookie, String uid, Handler handler) {
        this.cookie = cookie;
        this.uid = uid;
        this.handler = handler;
    }
    public void sign(){
        MiHoYoAbstractSign sign=new MiHoYoAbstractSign(cookie,uid);
        Log.d("TAGSS",sign.getDS());
        String url = "https://api-takumi.mihoyo.com/event/bbs_sign_reward/sign";
        OkHttpClient client = new OkHttpClient();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\"region\":\"cn_gf01\",\"act_id\":\"e202009291139501\",\"uid\":"+uid+"}");
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .addHeader("Connection", "keep-alive")
                .addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/85.0.4183.121 Safari/537.36 Edg/85.0.564.70")
                .addHeader("Host", "api-takumi.mihoyo.com")
                .addHeader("Cookie", cookie)
                .addHeader("Origin", "https://webstatic.mihoyo.com")
                .addHeader("X-Requested-With", "com.mihoyo.hyperion")
                .addHeader("x-rpc-device_id", "453b2895-7394-4437-9bc8-7c6507e9221d")
                .addHeader("x-rpc-app_version", "2.34.1")
                .addHeader("Referer", "https://webstatic.mihoyo.com/bbs/event/signin-ys/index.html?bbs_auth_required=true&act_id=e202009291139501&utm_source=bbs&utm_medium=mys&utm_campaign=icon")
                .addHeader("x-rpc-client_type", "5")
                .addHeader("DS", sign.getDS())
                .addHeader("Accept-Language", "zh-cn,zh;q=0.5")
                .addHeader("Accept-Charset", "UTF-8")
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept-Encoding", "gzip")
                .build();


        new Thread(new Runnable() {
            @Override
            public void run() {
                Response response = null;
                try {
                    response = client.newCall(request).execute();
                    String data=response.body().string();
                    Log.d("TAGQD",data);
                    if (data.contains("OK")){
                        Message message=new Message();
                        message.what=3;
                        handler.sendMessage(message);
                    }else if (data.contains("旅行者,你已经签到过了")){
                        Message message=new Message();
                        message.what=4;
                        handler.sendMessage(message);
                    }else {
                        Message message=new Message();
                        message.what=5;
                        handler.sendMessage(message);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
