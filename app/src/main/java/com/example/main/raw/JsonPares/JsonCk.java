package com.example.main.raw.JsonPares;

import com.example.main.raw.DataClass.CkData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonCk {
    String data;

    public JsonCk(String data) {
        this.data = data;
    }
    public List<CkData> jx(){
        List<CkData> ckData=new ArrayList<>();
        try {
            JSONObject jsonObject=new JSONObject(data);
            String data2=jsonObject.getString("data");
            JSONObject jsonObject1=new JSONObject(data2);
            JSONArray jsonArray=jsonObject1.getJSONArray("list");
            for (int a=0;a<jsonArray.length();a++){
                JSONObject jsonObject2=jsonArray.getJSONObject(a);
                String name=jsonObject2.getString("name");
                String item_type=jsonObject2.getString("item_type");
                String rank_type=jsonObject2.getString("rank_type");
                String id=jsonObject2.getString("id");
                CkData ckData1=new CkData(name,rank_type,item_type,id);
                ckData.add(ckData1);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return ckData;
    }
}
