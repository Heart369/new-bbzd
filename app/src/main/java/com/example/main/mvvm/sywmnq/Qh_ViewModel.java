package com.example.main.mvvm.sywmnq;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.main.raw.Class_Custom.Random;
import com.example.main.raw.DataClass.SywData;
import com.example.main.raw.DataClass.SywSxData;
import com.example.main.raw.DataClass.SywSxData2;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Qh_ViewModel extends AndroidViewModel {
    Context context;
    SywSxData syw_data;
    SywData sywData;

    int flag_getmain=-1;
    List<SywSxData2> sywfct=new ArrayList<>();
    MutableLiveData<String> main_Sx=new MutableLiveData<>();
    MutableLiveData<String> main_newSx=new MutableLiveData<>();
    MutableLiveData<String> main_name=new MutableLiveData<>();
    MutableLiveData<List<SywSxData2>> ob_syw_fct=new MutableLiveData<>();
    MutableLiveData<String> image=new MutableLiveData<>();
    MutableLiveData<String> name=new MutableLiveData<>();
    MutableLiveData<Integer> dj;
    MutableLiveData<Integer> xdj;
    MutableLiveData<String> dj_s;
    MutableLiveData<String> xdj_s;
    MutableLiveData<List<SywSxData2>> ob_syw=new MutableLiveData<>();

    public MutableLiveData<List<SywSxData2>> getOb_syw() {
        return ob_syw;
    }

    public MutableLiveData<String> getDj_s() {
        if (dj_s==null){
            dj_s=new MutableLiveData<>();
            dj_s.setValue("+0");
        }
        return dj_s;
    }

    public MutableLiveData<String> getXdj_s() {
        if (xdj_s==null){
            xdj_s=new MutableLiveData<>();
            xdj_s.setValue("+0");
        }
        return xdj_s;
    }

    public MutableLiveData<Integer> getXdj() {
        if (xdj==null){
            xdj=new MutableLiveData<>();
            xdj.setValue(0);
        }
        return xdj;
    }

    public MutableLiveData<Integer> getDj() {
        if (dj==null){
            dj=new MutableLiveData<>();
            dj.setValue(0);
        }
        return dj;
    }

    public MutableLiveData<String> getName() {
        return name;
    }

    public MutableLiveData<String> getImage() {
        return image;
    }

    public MutableLiveData<String> getMain_newSx() {
        return main_newSx;
    }

    public MutableLiveData<String> getMain_Sx() {
        return main_Sx;
    }

    public MutableLiveData<String> getMain_name() {
        return main_name;
    }

    public MutableLiveData<List<SywSxData2>> getOb_syw_fct() {
        return ob_syw_fct;
    }

    public Qh_ViewModel(@NonNull Application application) {
        super(application);
        context = application;
    }



    public int csh(int i, String zct, String fct, String data) {
        Gson gson = new Gson();
        syw_data = gson.fromJson(zct, SywSxData.class);
        main_name.setValue(syw_data.getMainname());
        if (syw_data.getB()==1){
            main_Sx.setValue(String.valueOf(syw_data.getExp()));
            main_newSx.setValue(String.valueOf(syw_data.getExp()));
        }

        else {
            String result = String.format(Locale.US,"%.1f%%", syw_data.getExp());
            main_Sx.setValue(result);
            main_newSx.setValue(result);
        }
        JSONArray jsonArray = null;
        try {
            jsonArray = new JSONArray(fct);
            Log.d("TAG", "" + jsonArray.length());
            Log.d("TAG", fct);
            JSONArray jsonArray1 = jsonArray.getJSONArray(i);
            Log.d("TAG", "" + jsonArray1.length());
            for (int s = 0; s < jsonArray1.length(); s++) {
                JSONObject jsonObject = jsonArray1.getJSONObject(s);
                int b = jsonObject.getInt("b");
                int cts = jsonObject.getInt("cts");
                Double exp = jsonObject.getDouble("exp");
                String name = jsonObject.getString("name");
                SywSxData2 sxData2 = new SywSxData2(name, exp, cts, b);
                sywfct.add(sxData2);
            }
            ob_syw_fct.setValue(sywfct);
            ob_syw.setValue(sywfct);
        } catch (JSONException e) {
            e.printStackTrace();
        }
      sywData=gson.fromJson(data,SywData.class);
        name.setValue(sywData.getImage());
        image.setValue("https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_" + sywData.getName() + "_"+sywData.getId2()+".png");
        return sywfct.get(0).getCts();
    }


    public void getMain_data(int b) {
        int i=0;
        if (b==0){
            i=1;
            getXdj().setValue(4);
        }
        else {
            i= (20-getDj().getValue())/4;
            getXdj().setValue(i*4);
        }
        getXdj_s().setValue("+"+getXdj().getValue());
        double exp=0.0;
        if (syw_data.getB()==1){
            switch (syw_data.getMainname()) {
                case "攻击力":
                    exp =13.2*4*i;
                    break;
                case "生命值":
                    exp = 203.15*4*i;
                    break;
                case "元素精通":
                    exp = 7.95*4*i;
                    break;
            }
        }else{
            switch (syw_data.getMainname()){
                case "攻击力":
                    exp = 1.98*4*i;
                    break;
                case "防御力":
                    exp = 2.48*4*i;
                    break;
                case "生命值":
                    exp = 1.95*4*i;
                    break;
                case "暴击率":
                    exp = 1.32*4*i;
                    break;
                case "暴击伤害":
                    exp = 2.64*4*i;
                    break;
                case "元素充能效率":
                    exp = 2.155*4*i;
                    break;
                case "治疗加成":
                    exp = 1.525*4*i;
                    break;
                case "物理伤害":
                    exp = 2.48*4*i;
                    break;
                default:
                    exp = 1.98*4*i;
                    break;
            }
        }
        String str=getMain_Sx().getValue();
        if (str.contains("%"))
            str=str.replace("%","");
        double d= Double.parseDouble(str);
        d=d+exp;
        if (syw_data.getB()==1){
            DecimalFormat decimalFormat=new DecimalFormat("#");
            main_newSx.setValue(decimalFormat.format(d));
        }
        else {
            String result = String.format(Locale.US,"%.1f%%",d);
            main_newSx.setValue(result);
        }
    }
    public int qh() {
        if (xdj.getValue()==0)
            return 0;
        int i=getXdj().getValue()/4;
        getDj().setValue(getDj().getValue()+getXdj().getValue());
        getXdj().setValue(0);
        getDj_s().setValue("+"+getDj().getValue());

        if (sywfct.get(0).getCts()==3){
            sywfct.get(0).setCts(4);
            if (i==1)
                return 1;
            else i-=1;
        }
        Random random=new Random(context);
        java.util.Random r=new java.util.Random();
        List<SywSxData2> ls=null;
        for (int a=0;a<i;a++){
        int num = r.nextInt(4);
        ls=getOb_syw_fct().getValue();
        int b=ls.get(num).getB();
        double exp=0.0;
        String name=ls.get(num).getName();
        if (b == 1) {
            switch (name) {
                case "攻击力":
                    exp = random.getxgj();
                    break;
                case "防御力":
                    exp = random.getxfy();
                    break;
                case "生命值":
                    exp = random.getxsm();
                    break;
                case "元素精通":
                    exp = random.getysjt();
                    break;
            }
        } else {
            switch (name) {
                case "攻击力":
                    exp = random.getdgj();
                    break;
                case "防御力":
                    exp = random.getdfy();
                    break;
                case "生命值":
                    exp = random.getdsm();
                    break;
                case "暴击率":
                    exp = random.getbjl();
                    break;
                case "暴击伤害":
                    exp = random.getbj();
                    break;
                case "元素充能效率":
                    exp = random.getcnxl();
                    break;
            }
        }
        ls.get(num).setExp(ls.get(num).getExp()+exp);
        }

        getOb_syw_fct().setValue(ls);
        return 1;
    }
}
