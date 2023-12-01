package com.example.main.mvvm.request;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.main.mvvm.json.Detail_Wq;
import com.example.main.mvvm.json.Detail_mz;
import com.example.main.mvvm.json.Detail_role;

import com.example.main.mvvm.network.HttpbinServer;
import com.example.main.raw.JsonPares.Json_Jstf;
import com.github.mikephil.charting.formatter.IFillFormatter;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
;

public class RequestVM extends AndroidViewModel {
    public RequestVM(@NonNull Application application) {
        super(application);
    }

    private MutableLiveData<Detail_role> data;
    Retrofit retrofit;
    HttpbinServer httpbinServer;
    private MutableLiveData<Detail_mz> mz;
    private MutableLiveData<Json_Jstf> jstf;

    public MutableLiveData<Json_Jstf> getJstf() {
        if (jstf==null)
            jstf=new MutableLiveData<>();
        return jstf;
    }

    public MutableLiveData<Detail_role> getData() {
        if (data == null)
            data = new MutableLiveData<>();
        return data;
    }

    public MutableLiveData<Detail_mz> getMz() {
        if (mz==null)
            mz=new MutableLiveData<>();
        return mz;
    }

    MutableLiveData<Detail_Wq> getwq;
    MutableLiveData<Detail_Wq> wq;
    public MutableLiveData<Detail_Wq> Getwq() {
        if (wq==null)
            wq=new MutableLiveData<>();
        return wq;
    }

    public MutableLiveData<Detail_Wq> getGetwq() {
        if (getwq==null)
            getwq=new MutableLiveData<>();
        return getwq;
    }

    public void request(String url, String name, MutableLiveData<Detail_role> data) {
        retrofit = new Retrofit.Builder()
                //设置网络请求BaseUrl地址
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        httpbinServer = retrofit.create(HttpbinServer.class);
        Call<Detail_role> cs = httpbinServer.getjs_base(name,null,null);
        cs.enqueue(new Callback<Detail_role>() {
            @Override
            public void onResponse(Call<Detail_role> call, Response<Detail_role> response) {
                data.setValue(response.body());
            }
            @Override
            public void onFailure(Call<Detail_role> call, Throwable t) {
                request(url,name,data);
            }
        });
    }
    public void request_mz(String url,String name,MutableLiveData<Detail_mz> mz){
        retrofit = new Retrofit.Builder()
                //设置网络请求BaseUrl地址
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        httpbinServer = retrofit.create(HttpbinServer.class);
        Call<Detail_mz> cs = httpbinServer.getmz_base(name,null);
        cs.enqueue(new Callback<Detail_mz>() {
            @Override
            public void onResponse(Call<Detail_mz> call, Response<Detail_mz> response) {
                mz.postValue(response.body());
            }

            @Override
            public void onFailure(Call<Detail_mz> call, Throwable t) {

            }
        });
    }

    public void request_jstf(String url, String name, MutableLiveData<Json_Jstf> data) {
        retrofit = new Retrofit.Builder()
                //设置网络请求BaseUrl地址
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        httpbinServer = retrofit.create(HttpbinServer.class);
        Call<Json_Jstf> cs = httpbinServer.gettf_base(name);
        Log.d("TAGBB","开始请求");
        cs.enqueue(new Callback<Json_Jstf>() {
            @Override
            public void onResponse(Call<Json_Jstf> call, Response<Json_Jstf> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<Json_Jstf> call, Throwable t) {
            Log.d("TAGBB","请求失败");
            request_jstf(url,name,data);

            }
        });
    }



    public void request_wq(String url, String name, MutableLiveData<Detail_Wq> data,String dj) {
        retrofit = new Retrofit.Builder()
                //设置网络请求BaseUrl地址
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        httpbinServer = retrofit.create(HttpbinServer.class);
        Call<Detail_Wq> cs = httpbinServer.getwq_base(name,null,dj);

        cs.enqueue(new Callback<Detail_Wq>() {
            @Override
            public void onResponse(Call<Detail_Wq> call, Response<Detail_Wq> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<Detail_Wq> call, Throwable t) {
                request_wq(url,name,data,dj);
            }
        });
        Log.d("TAGBB","开始请求");

    }



}
