package com.example.main.raw.server;

import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

import androidx.annotation.NonNull;

import com.example.main.raw.Class_Custom.Th;
import com.example.main.raw.Class_Custom.Th_Sy;

import java.util.Timer;
import java.util.TimerTask;

public class MyService extends Service {
    static Handler mhandler=null;
    static Timer timer;
    static int time;
    static String cookie,server,uid;
    public  static Handler handler=new Handler(Looper.myLooper()){
    @Override
    public void handleMessage(@NonNull Message msg) {
        super.handleMessage(msg);
        switch (msg.what){
            case 0:
                mhandler= (Handler) msg.obj;
                break;
        }

    }
};

    private static void getdata() {
         timer=new Timer();
        TimerTask timerTask=new TimerTask() {
            @Override
            public void run() {
                Log.d("TAG","刷新请求");
                Th t = new Th(mhandler,cookie,"https://api-takumi-record.mihoyo.com/game_record/app/genshin/api/dailyNote?role_id="+uid+"&server="+server,uid,server,1);
                t.start();
                Log.d("TAG","已经刷新");
            }
        };
        timer.schedule(timerTask,0,time);
        Th t = new Th(mhandler,cookie,"https://api-takumi-record.mihoyo.com/game_record/app/genshin/api/dailyNote?role_id="+uid+"&server="+server,uid,server,1);
        t.start();
        Th gr = new Th(mhandler,cookie,"https://api-takumi-record.mihoyo.com/game_record/app/genshin/api/index?role_id="+uid+"&server="+server,uid,server,2);
        gr.start();
        Th_Sy sy=new Th_Sy("https://api-takumi-record.mihoyo.com/game_record/app/genshin/api/spiralAbyss?role_id="+uid+"&schedule_type="+2+"&server="+server,uid,server,cookie,2,1);
        sy.start();
        Th_Sy sy1=new Th_Sy("https://api-takumi-record.mihoyo.com/game_record/app/genshin/api/spiralAbyss?role_id="+uid+"&schedule_type="+1+"&server="+server,uid,server,cookie,1,1);
        sy1.start();
        Log.d("TAG","刷新请求");
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        SharedPreferences preferences=getSharedPreferences("data",MODE_PRIVATE);
        uid=preferences.getString("uid","");
        server =preferences.getString("server","");
        cookie =preferences.getString("cookie","");
        Log.d("COOKIE",cookie);
        SharedPreferences preferences2=getSharedPreferences("userset",MODE_PRIVATE);
    //    cookie="stuid=202839522;stoken=MlzDbDyBToIveTIZlui2v5u7GS0hImwXELR0uBFd;ltoken=CFExGUkCrUNHhK7nM2Aue4qOyfEg3pNvCAdnicQq;_MHYUUID=2e92816c-0459-4409-80ea-eaec381b222c; DEVICEFP_SEED_ID=d97e86df2d215951; DEVICEFP_SEED_TIME=1672829020819; DEVICEFP=38d7ecb3c4b05; login_uid=202839522; login_ticket=x0FEz4BbgehxDLeKKrW6QlngHFvBpcJVPuJxEjvW";
        time=preferences2.getInt("sxtime",6);
        if (time<5){
            time+=1;
            time=time*60000;
        }else if (time==5){
            time=7*60000;
        }else time=600000;
        Log.d("TAGss","已经执行初始化任务2222"+uid+server);
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (;;){
                    if (mhandler!=null){
                        getdata();
                        break;
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        return super.onStartCommand(intent, flags, startId);
    }


    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //        timer.cancel();
    }
}