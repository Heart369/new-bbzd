package com.example.main.raw.Class_Custom;

import android.util.Log;

import com.example.main.raw.JsonPares.Json_Jstf;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Th_jstf extends Thread{
    String name;
    getbl getbl;
    int id;

    public Th_jstf(int avatarId, String name, getbl getbl) {
        this.name = name;
        this.getbl = getbl;
        this.id=avatarId;
    }

    @Override
    public void run() {
        super.run();
        OkHttpClient httpClient=new OkHttpClient();
        Request getRequest = new Request.Builder()
                .url("https://api.minigg.cn/talents?query="+name)
                .get()
                .build();
        Call call = httpClient.newCall(getRequest);
        try {
            Response response = call.execute();
            response.body();
            String data = response.body().string();
            Gson gson=new Gson();
            Json_Jstf jszsg=gson.fromJson(data, Json_Jstf.class);
            Bl_cl bl_cl=new Bl_cl(jszsg);
            bl_cl.id=id;
            getbl.nq(bl_cl);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public interface getbl{
        public void nq(Bl_cl bl_cl);
    }
}
