package com.example.main.raw.JsonPares;

import android.util.Log;

import com.example.main.raw.Class_Custom.wh.Jsdy_t;
import com.example.main.raw.DataClass.CghData;
import com.example.main.raw.DataClass.Userxx;
import com.example.main.raw.DataClass.WordData;
import com.example.main.raw.DataClass.Wordcl;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class  jsongr {
    Userxx userxx=new Userxx();
  String message1;
  List<String> jsbh = new ArrayList<>();

    public Userxx grxx(String data){
        Log.d("TAG","进入解析");
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(data);
            String message = jsonObject.getString("message");
            message1=message;
            if(message.equals("OK")){
                String data1 = jsonObject.getString("data");
                Log.d("TAG","拿到data");
                JSONObject jsonObject1 = new JSONObject(data1);
                String data2=jsonObject1.getString("stats");
                JSONObject jsonObjec2 = new JSONObject(data2);
               int active_day_number=jsonObjec2.getInt("active_day_number");
                int  achievement_number=jsonObjec2.getInt("achievement_number");
                int  anemoculus_number=jsonObjec2.getInt("anemoculus_number");
                int geoculus_number=jsonObjec2.getInt("geoculus_number");
                int avatar_number=jsonObjec2.getInt("avatar_number");
                int way_point_number=jsonObjec2.getInt("way_point_number");
                int domain_number=jsonObjec2.getInt("domain_number");
                String  spiral_abyss=jsonObjec2.getString("spiral_abyss");
                int precious_chest_number=jsonObjec2.getInt("precious_chest_number");
                int luxurious_chest_number=jsonObjec2.getInt("luxurious_chest_number");
                int exquisite_chest_number=jsonObjec2.getInt("exquisite_chest_number");
                int common_chest_number=jsonObjec2.getInt("common_chest_number");
                int electroculus_number=jsonObjec2.getInt("electroculus_number");
                int magic_chest_number=jsonObjec2.getInt("magic_chest_number");
                int dendroculus_number=jsonObjec2.getInt("dendroculus_number");
                Log.d("TAG","解析完成"+data2);
                Userxx userxx1 = new Userxx(
                        active_day_number
                        ,achievement_number
                        ,anemoculus_number
                        ,geoculus_number
                        ,avatar_number
                        ,way_point_number
                        ,domain_number
                        ,precious_chest_number
                        ,luxurious_chest_number
                        ,exquisite_chest_number
                        ,common_chest_number
                        ,electroculus_number
                        ,magic_chest_number
                        ,dendroculus_number
                        ,spiral_abyss
                        );
                userxx=userxx1;

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        userxx.setMessage(message1);
        return userxx;
    }

    public String[] jsxx(String data){
        JSONObject jsonObject = null;
        String[] a=null;
        try {
            jsonObject = new JSONObject(data);
            String message = jsonObject.getString("message");
            message1=message;
            if(message.equals("OK")) {
                String data1 = jsonObject.getString("data");
                Log.d("TAG", "拿到JS信息");
                JSONObject jsonObject1 = new JSONObject(data1);
               String data3 =  jsonObject1.getString("avatars");
                JSONArray jsonArray = new JSONArray(data3);
                for(int i=0;i<jsonArray.length();i++){
                    JSONObject jsonObject2 = jsonArray.getJSONObject(i);
                    String id = jsonObject2.getString("id");
                   jsbh.add(id);
                }
                Jsdy_t js = new Jsdy_t(jsbh);
                 a = js.js();
            }
        }  catch (JSONException e) {
            e.printStackTrace();
        }
        return a;
    }

    public CghData cgh(String data){
        CghData cgh=null;
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(data);
            String message = jsonObject.getString("message");
            message1=message;
            if(message.equals("OK")) {
                String data1 = jsonObject.getString("data");
                Log.d("TAG", "拿到JS信息");
                JSONObject jsonObject1 = new JSONObject(data1);
                String data3 =  jsonObject1.getString("homes");
                JSONArray jsonArray = new JSONArray(data3);
                    JSONObject jsonObject2 = jsonArray.getJSONObject(0);
                    int level = jsonObject2.getInt("level");
                    int visit_num = jsonObject2.getInt("visit_num");
                    int comfort_num = jsonObject2.getInt("comfort_num");
                    int item_num = jsonObject2.getInt("item_num");
                    String name = jsonObject2.getString("comfort_level_name");
                    CghData cgh2 = new CghData(level,visit_num,comfort_num,item_num,name);
                    cgh=cgh2;
            }
        }  catch (JSONException e) {
            e.printStackTrace();
        }
        return cgh;

    }
    public List<WordData> jxword(String data){
        List<WordData> word =new ArrayList<>();
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(data);
            String message = jsonObject.getString("message");
            message1=message;
            if(message.equals("OK")) {
                String data1 = jsonObject.getString("data");
                Log.d("TAG", "拿到JS信息2");
                JSONObject jsonObject1 = new JSONObject(data1);
                String data3 =  jsonObject1.getString("world_explorations");
                JSONArray jsonArray = new JSONArray(data3);
                for(int i=0;i<jsonArray.length();i++){
                    JSONObject jsonObject2 = jsonArray.getJSONObject(i);
                   int exp = jsonObject2.getInt("exploration_percentage");
                   String name = jsonObject2.getString("name");
                   WordData wordData =new WordData(name,exp);
                   word.add(wordData);
                }
                Wordcl wordcl =new Wordcl(word);
                word=wordcl.cl();
            }
        }  catch (JSONException e) {
            e.printStackTrace();
        }
        return word;
    }

}
