package com.example.main.raw.JsonPares;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

public class jsonbq {
    String data;

    public jsonbq(String data) {
        this.data = data;
    }
    public bianqian jx(){
        bianqian bqdata=null;
        Log.d("Day","已进入");
        try {
            JSONObject jsonObject = new JSONObject(data);
            String message = jsonObject.getString("message");

            int retcode = jsonObject.getInt("retcode");

            if(message.equals("OK")){

                String data1 = jsonObject.getString("data");
                JSONObject jsonObject1 = new JSONObject(data1);
                int current_resin=jsonObject1.getInt("current_resin");
                String resin_recovery_time=jsonObject1.getString("resin_recovery_time");
                int finished_task_num=jsonObject1.getInt("finished_task_num");
                int remain_resin_discount_num=jsonObject1.getInt("remain_resin_discount_num");
                int current_expedition_num=jsonObject1.getInt("current_expedition_num");
                int max_expedition_num=jsonObject1.getInt("max_expedition_num");
                int current_home_coin=jsonObject1.getInt("current_home_coin");
                int max_home_coin=jsonObject1.getInt("max_home_coin");
                String data2 =jsonObject1.getString("transformer");
                JSONObject jsonObject2 = new JSONObject(data2);
                String data3 = jsonObject2.getString("recovery_time");
                JSONObject jsonObject3 = new JSONObject(data3);
                int Day = jsonObject3.getInt("Day");

                String home_coin_recovery_time = jsonObject1.getString("home_coin_recovery_time");
                boolean obtained=jsonObject2.getBoolean("obtained");

                bianqian bq  =new bianqian(retcode,current_resin,finished_task_num,remain_resin_discount_num,current_expedition_num,max_expedition_num,current_home_coin,max_home_coin,Day,message,resin_recovery_time,home_coin_recovery_time,obtained);
                bqdata=bq;
            }
            else bqdata=new bianqian(message,retcode);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return bqdata;



    }
}
