package com.example.main.raw.Class_Custom;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.example.main.raw.activity.JsXq_Activity;
import com.example.main.raw.JsonPares.JxJs;
import com.google.gson.Gson;

import java.io.IOException;

public class Th extends Thread{
    String data="NO";
    Handler handler;
    String cookie;
    String url;
    String uid;
    String server;
    int flag,a=0;
    requestdata re;

    public Th(Handler handler, String cookie, String url, String uid, String server, int flag) {
        this.handler = handler;
        this.cookie = cookie;
        this.url = url;
        this.uid = uid;
        this.server = server;
        this.flag = flag;
    }
    public  void qq(){
        for(;data.equals("NO");a++){
            try {
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Log.d("TAG",""+a);
            data = re.getdata();
            if (a==15)
                break;
        }
    }

    @Override

    public void run() {

        super.run();
         re = new requestdata();
        try {
            Log.d("TAG","调用reque");
            re.run1(url,cookie,uid,server);
        } catch (IOException e) {
            e.printStackTrace();
        }
           qq();

        if(flag==1){
            Message message= new Message();
            message.what = 1;
            message.obj=data;
            handler.sendMessage(message);
            Log.d("CG","已发送");
        }
        else
            if(flag==2){
                Message message = new Message();
                message.what=2;
                message.obj=data;
                handler.sendMessage(message);
                Log.d("CG","已发送2"+data);
                if (!data.equals("NO")){
                    Gson gson=new Gson();
                    JxJs jxJs=gson.fromJson(data, JxJs.class);
                    message=new Message();
                    message.obj=jxJs;
                    JsXq_Activity.handler.sendMessage(message);
                }
            }
    }


}
