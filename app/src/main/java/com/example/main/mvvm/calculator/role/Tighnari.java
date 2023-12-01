package com.example.main.mvvm.calculator.role;

import android.content.Context;
import android.util.Log;

import com.example.main.mvvm.calculator.tool.Enemy;
import com.example.main.mvvm.calculator.tool.Sh_data;
import com.example.main.mvvm.calculator.tool.Zy;
import com.example.main.mvvm.json.CharacterData;
import com.example.main.raw.Class_Custom.Bl_cl;
import com.example.main.raw.JsonPares.Jszsg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Tighnari extends Obj_calculator{
    public Tighnari(Jszsg.AvatarInfoListDTO jszsg, List<Bl_cl> bl_cl, CharacterData du, Context context) {
        super(jszsg, bl_cl, du, context);
    }

    @Override
    void cshsz() {
        a_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(0).toString());
        q_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(2).toString());
        e_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(1).toString());
        ys_key = "43";
        ysbf = getbl(q_level, 2, 1, 3);
    }

    @Override
    public List<Sh_data> csh() {
        myZy = new HashMap<>();
        zyList = new ArrayList<>();
        a_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(0).toString());
        q_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(2).toString());
        e_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(1).toString());
        user_mz(mz);
        wq_syw_csh(jszsg, context, "43");
        enemy = new Enemy(Enemy.ELEMENT_J, 1000);
        List<Sh_data> data = new ArrayList<>();
        g1();
        g2();
        g3();
        data.add(new Sh_data("重击激化",user_a(6)));
        data.add(new Sh_data("12箭激化",user_q()));
        return data;
    }

    @Override
    public double[] user_a(int a) {
        double[] d;
        double sh_ysh=0;
        String key="43";
        if (a==6){
            getYsfy(Enemy.ELEMENT_C);
            sh_ysh = (getGj(0) * getbl(a_level, 0, 0, a) + getJc("300" + key,"10025")) * getZs(key, "10015") * getFy() * getYsKx(key);
            getYsfy(Enemy.ELEMENT_C);
            sh_ysh+=(getGj(0) * getbl(a_level, 0, 0, a+1) + getJc("300" + key,"10025")) * getZs(key, "10015") * getFy() * getYsKx(key);
            sh_ysh+=(getGj(0) * getbl(a_level, 0, 0, a+1) + getJc("300" + key,"10025")) * getZs(key, "10015") * getFy() * getYsKx(key)*2;
            if (mz==6){
                getYsfy(Enemy.ELEMENT_C);
                sh_ysh+=(getGj(0)*1.5 * getbl(a_level, 0, 0, a+1) + getJc("300" + key,"10025")) * getZs(key, "10015") * getFy() * getYsKx(key);
            }

        }
        d = getqw("100" + key, sh_ysh, 0);
        return d;
    }

    @Override
    public double[] user_q() {
        double[] d;
        double sh_ysh=0;
        getYsfy(Enemy.ELEMENT_C);
        sh_ysh = (getGj(0) * (getbl(q_level, 2, 1, 0)*6+getbl(q_level,2,1,1)*6) + getJc("30043","10024") ) * getZs("43", "10003") * getFy() * getYsKx("43");
        Log.d("TAgBL",(getbl(q_level, 2, 1, 0)*6+getbl(q_level,2,1,1)*6)+","+getZs("43", "10003") +","+ getYsKx("43"));
        d = getqw("10043", sh_ysh, 2);
        return d;
    }

    @Override
    public double[] user_e() {
        return new double[0];
    }

    @Override
    public void user_mz(int mz) {
        switch (mz){
            case 6:
            case 5:
                if (e_level < 11)
                    e_level += 3;
            case 4:
                if (!addZy(new Zy(120, "2命", true, false, "28", 0, 0)))
                    accumulateValue("28", 120.0);
            case 3:
                if (q_level < 11)
                    q_level += 3;
            case 2:
                if (!addZy(new Zy(0.2, "2命", true, false, "43", 0, 0)))
                    accumulateValue("43", 0.2);
            case 1:
                if (!addZy(new Zy(0.15, "1命", true, false, "20", 0, 0)))
                    accumulateValue("20", 0.15);
        }
    }

    @Override
    public void g1() {
        if (!addZy(new Zy(50, "固有天赋1", false, false, "28", getTime(), 6))) {
            accumulateValue("28", 50.0);
        }
    }

    @Override
    public void g2() {
        if (dj>=70){
            double sz=getYsjt(1)*0.0006;
            if (sz>0.6)
                sz=0.6;
            if (!addZy(new Zy(sz, "固有天赋2_1", false, false, "10015", getTime(), 6))) {
                accumulateValue("10015", sz);
            }
            if (!addZy(new Zy(sz, "固有天赋2_2", false, false, "10003", getTime(), 6))) {
                accumulateValue("10003", sz);
            }
        }
    }

    @Override
    public void g3() {

    }
}
