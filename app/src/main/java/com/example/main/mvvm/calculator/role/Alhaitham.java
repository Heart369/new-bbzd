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

public class Alhaitham extends Obj_calculator {
    public Alhaitham(Jszsg.AvatarInfoListDTO jszsg, List<Bl_cl> bl_cl, CharacterData du, Context context) {
        super(jszsg, bl_cl, du, context);
    }

    int zgj = 3;

    @Override
    void cshsz() {
        a_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(0).toString());
        q_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(2).toString());
        e_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(1).toString());
        ys_key = "43";
        ysbf = getbl(q_level, 2, 1, 6);
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
        data.add(new Sh_data("剑雨3段激化",user_e()));
        data.add(new Sh_data("大招10段总伤",user_q()));
        return data;
    }

    @Override
    public double[] user_a(int a) {
        return new double[0];
    }

    @Override
    public double[] user_q() {
        double[] d;
        double sh_ysh=0;
        if (zgj==3){
            getYsfy(Enemy.ELEMENT_C);
            sh_ysh = (getGj(0) * getbl(q_level, 2, 1, 0) + getJc("30043","10024") + getYsjt(0) * getbl(q_level, 2, 3, 0)) * getZs("43", "10003") * getFy() * getYsKx("43")*4;
            sh_ysh+=(getGj(0) * getbl(q_level, 2, 1, 0) + getJc("30043","10024") + getYsjt(0) * getbl(q_level, 2, 3, 0)) * getZs("43", "10003") * getFy() * getYsKx("43")*6;

        }
        d = getqw("10043", sh_ysh, 2);
        return d;
    }

    @Override
    public double[] user_e() {
        double[] d;
           double sh_ysh=0;
        if (zgj==3){
            getYsfy(Enemy.ELEMENT_C);
            sh_ysh = (getGj(0) * getbl(e_level, 1, 1, 2) + getJc("30046","10023") + getYsjt(0) * getbl(e_level, 1, 3, 2)) * getZs("43", "10002") * getFy() * getYsKx("43");
            sh_ysh+=(getGj(0) * getbl(e_level, 1, 1, 2) + getJc("30046","10023") + getYsjt(0) * getbl(e_level, 1, 3, 2)) * getZs("43", "10002") * getFy() * getYsKx("43")*2;
        }
        d = getqw("10043", sh_ysh, 1);

        return d;
    }

    @Override
    public void user_mz(int mz) {
    switch (mz){
        case 6:
            if (!addZy(new Zy(0.1, "命座6_1", false, false, "20", getTime(), 6))) {
                accumulateValue("20", 0.1);
            }
            if (!addZy(new Zy(0.7, "命座6_2", false, false, "22", getTime(), 6))) {
                accumulateValue("22", 0.7);
            }
        case 5:
            if (q_level < 11)
                q_level += 3;
        case 4:
            if (!addZy(new Zy(0.3, "命座4", false, false, "43", getTime(), 15))) {
                accumulateValue("43", 0.3);
            }
        case 3:
            if (e_level < 11)
                e_level += 3;
        case 2:
            if (!addZy(new Zy(200, "命座2", false, false, "28", getTime(), 8))) {
                accumulateValue("28", 200.0);
            }
            break;
        case 1:

    }
    }

    @Override
    public void g1() {

    }

    @Override
    public void g2() {
        if (dj >= 70) {
            double ts=getYsjt(1)*0.001;
            Log.d("TAGJS",ts+"");
            if (!addZy(new Zy(ts, "固有天赋2_1", false, false, "10002", getTime(), 10))) {
                accumulateValue("10002",ts);
            }
            if (!addZy(new Zy(ts, "固有天赋2_2", false, false, "10003", getTime(), 10))) {
                accumulateValue("10003", ts);
            }

        }
    }

    @Override
    public void g3() {

    }
}
