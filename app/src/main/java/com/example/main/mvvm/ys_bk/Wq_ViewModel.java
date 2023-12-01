package com.example.main.mvvm.ys_bk;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.main.mvvm.adapter.detail_wq.Main_recy_adapter;

public class Wq_ViewModel extends AndroidViewModel {
    Context context;
    public Wq_ViewModel(@NonNull Application application) {
        super(application);
        context=application;
    }
    MutableLiveData<Main_recy_adapter> adapter;
    MutableLiveData<String> wqname;

    public MutableLiveData<String> getWqname() {
        if (wqname==null)
            wqname=new MutableLiveData<>();
        return wqname;
    }

    public MutableLiveData<Main_recy_adapter> getAdapter() {
        if (adapter==null){
            adapter=new MutableLiveData<>();
            adapter.setValue(new Main_recy_adapter(context));
        }
        return adapter;
    }
}
