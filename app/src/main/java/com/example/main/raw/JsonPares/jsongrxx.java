package com.example.main.raw.JsonPares;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class jsongrxx {
    String data;
    grxx grxxdata=null;

    public jsongrxx(String data) {
        this.data = data;
    }
    public grxx jx(){
        try {
            Log.d("TAG",data);
            JSONObject jsonObject =new JSONObject(data);
            String message = jsonObject.getString("message");
            if(message.equals("OK")){
                String data = jsonObject.getString("data");
                JSONObject jsonObject1 = new JSONObject(data);
                JSONArray jsonArray = jsonObject1.getJSONArray("list");
                JSONObject jsonObject2 =jsonArray.getJSONObject(0);
                String region = jsonObject2.getString("region");
                String game_uid = jsonObject2.getString("game_uid");
                String nickname = jsonObject2.getString("nickname");
                String region_name = jsonObject2.getString("region_name");
                int level =jsonObject2.getInt("level");
                grxx grxx =new grxx(message,region,game_uid,nickname,region_name,level);
                grxxdata=grxx;
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }


        return grxxdata;
    }
}
