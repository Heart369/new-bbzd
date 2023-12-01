package com.example.main.mvvm.calculator;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.main.mvvm.adapter.calculator.Calculator_adapter;
import com.example.main.mvvm.calculator.role.Obj_calculator;
import com.example.main.mvvm.sqlite.Js_SQLite;
import com.example.main.raw.Class_Custom.Bl_cl;
import com.example.main.raw.Class_Custom.Th_jszsg;
import com.example.main.raw.JsonPares.Jszsg;
import com.google.gson.Gson;

import java.nio.charset.StandardCharsets;
import java.util.List;

public class Calculator_ViewModel extends AndroidViewModel {
    Context context;

    public Calculator_ViewModel(@NonNull Application application) {
        super(application);
        context = application;
    }

    MutableLiveData<Jszsg> jszsg;
    MutableLiveData<List<Bl_cl>> bl_cl;
    MutableLiveData<List<Obj_calculator>> js_one;
    MutableLiveData<Integer> cx;

    public MutableLiveData<Integer> getCx() {
        if (cx==null)
            cx=new MutableLiveData<>();
        return cx;
    }

    MutableLiveData<Calculator_adapter> adapter;
    public MutableLiveData<Calculator_adapter> getAdapter() {
        if (adapter==null)
            adapter=new MutableLiveData<>();
        return adapter;
    }

    public MutableLiveData<List<Obj_calculator>> getJs_one() {
        if (js_one==null)
            js_one=new MutableLiveData<>();
        return js_one;
    }

    public MutableLiveData<List<Bl_cl>> getBl_cl() {
        if (bl_cl == null) {
            bl_cl = new MutableLiveData<>();
        }
        return bl_cl;
    }

    public MutableLiveData<Jszsg> getJszsg() {
        if (jszsg == null)
            jszsg = new MutableLiveData<>();
        return jszsg;
    }

    @SuppressLint("Range")
    public void csh(String uid) {
        Js_SQLite sqLite = new Js_SQLite(context, "enka.bd", null, 1);
        SQLiteDatabase database = sqLite.getWritableDatabase();
        Cursor cursor = database.query("js", new String[]{"json"}, "uid=?", new String[]{uid}, null, null, null);
        cursor.moveToNext();
        Gson gson=new Gson();
        if (cursor.getCount() != 0) {
            byte[] jsonData = cursor.getBlob(cursor.getColumnIndex("json"));
            String jsonString = new String(jsonData, StandardCharsets.UTF_8);
            Jszsg jszsg=gson.fromJson(jsonString,Jszsg.class);
            getJszsg().setValue(jszsg);
            database.close();
        } else {
            database.close();
            Th_jszsg jszsg = new Th_jszsg("https://enka.network/api/uid/"+uid, getJszsg(),context,0,getCx());
            jszsg.start();
        }
        cursor.close();
        database.close();


    }


    public void gxData(){
        Th_jszsg jszsg = new Th_jszsg("https://enka.network/api/uid/"+getJszsg().getValue().uid, getJszsg(),context,1,getCx());
        cx.setValue(1);
        jszsg.start();
    }
}
