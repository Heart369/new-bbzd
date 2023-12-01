package com.example.main.mvvm.network;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiManager {

    public final String BASE_URL= "https://wanandroid.com/";

    private static ApiManager apiManager;
    private Retrofit retrofit;
    private OkHttpClient client;
    private HttpbinServer apiServer;
//123
    public static ApiManager getInstance() {
        if (apiManager == null) {
            synchronized (Object.class) {
                if (apiManager == null) {
                    apiManager = new ApiManager();
                }
            }
        }
        return apiManager;
    }

    public ApiManager() {
        client = new OkHttpClient.Builder()
                //添加log拦截器
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .build();

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                //支持RxJava
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .client(client)
                .build();

        apiServer = retrofit.create(HttpbinServer.class);
    }

    public HttpbinServer getApiService() {
        return apiServer;
    }

}

