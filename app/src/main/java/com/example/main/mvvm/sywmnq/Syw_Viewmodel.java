package com.example.main.mvvm.sywmnq;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.main.R;
import com.example.main.mvvm.adapter.sywadapter.Grid_syw_adapter;
import com.example.main.raw.Class_Custom.Random;
import com.example.main.raw.DataClass.SywData;
import com.example.main.raw.SQLite.MjSQLite;

import java.util.ArrayList;
import java.util.List;

@SuppressLint("Range")
public class Syw_Viewmodel extends AndroidViewModel {
    Context context;
    List<Fb> fb;
    Random random;
    int[] back=new int[]{R.drawable.syw_fb_1,R.drawable.syw_fb_1,R.drawable.syw_fb_2,R.drawable.syw_fb_1,R.drawable.syw_fb_1,R.drawable.syw_fb_1,R.drawable.syw_fb_1,R.drawable.syw_fb_3,R.drawable.syw_fb_4,R.drawable.syw_fb_4,R.drawable.syw_fb_5,R.drawable.hy_syw};
    public Random getRandom() {
        if (random==null)
            random=new Random(context);
        return random;
    }
    MutableLiveData<List<SywData>> sywData;

    public MutableLiveData<List<SywData>> getSywData() {
        if (sywData==null){
            sywData=new MutableLiveData<>();
        }

        return sywData;
    }

    public List<Fb> getFb() {
        return fb;
    }
    public Syw_Viewmodel(@NonNull Application application) {
        super(application);
        context=application;
    }
    MutableLiveData<Grid_syw_adapter> adapter;


    public MutableLiveData<Grid_syw_adapter> getAdapter() {
        if (adapter==null){
            adapter=new MutableLiveData<>();
        }
        return adapter;
    }

    public Drawable getdraw(int a) {
        return context.getDrawable(back[a]);
    }

    public static class Fb{
        String name,cc1,cc2;

        public Fb(String name, String cc1, String cc2) {
            this.name = name;
            this.cc1 = cc1;
            this.cc2 = cc2;
        }

        public String getName() {
            return name;
        }

        public String getCc1() {
            return cc1;
        }

        public String getCc2() {
            return cc2;
        }
    }
    public void csh() {
        MjSQLite sywxq=new MjSQLite(context,"mj.bd",null,1);
        SQLiteDatabase database = sywxq.getWritableDatabase();
        Cursor cursor=database.query("mj",new String[]{"name","cc1","cc2"},"lx=?",new String[]{"圣遗物秘境"},null,null,null,null);
        fb=new ArrayList<>();
        while (cursor.moveToNext()){
            String name=cursor.getString(cursor.getColumnIndex("name"));
            String cc1=cursor.getString(cursor.getColumnIndex("cc1"));
            String cc2=cursor.getString(cursor.getColumnIndex("cc2"));
           fb.add(new Fb(name, cc1, cc2));
        }
        database.close();
       getAdapter().setValue(new Grid_syw_adapter(context,fb));
    }
    public void lqsyw(){
        int size=random.getCont();
        sywData.setValue( random.getsywdata(size));
    }
}
