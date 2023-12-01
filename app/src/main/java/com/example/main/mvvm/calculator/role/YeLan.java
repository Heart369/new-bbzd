package com.example.main.mvvm.calculator.role;

import android.content.Context;

import com.example.main.mvvm.calculator.tool.Enemy;
import com.example.main.mvvm.calculator.tool.Sh_data;
import com.example.main.mvvm.calculator.tool.Zy;
import com.example.main.mvvm.json.CharacterData;
import com.example.main.raw.Class_Custom.Bl_cl;
import com.example.main.raw.JsonPares.Jszsg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class YeLan extends Obj_calculator {
    public YeLan(Jszsg.AvatarInfoListDTO jszsg, List<Bl_cl> bl_cl, CharacterData du, Context context) {
        super(jszsg, bl_cl, du, context);
    }

    @Override
    void cshsz() {
        a_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(0).toString());
        q_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(2).toString());
        e_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(1).toString());
        ys_key = "42";
        ysbf = getbl(q_level, 2, 1, 4);
    }
    int b=-1;
    @Override
    public List<Sh_data> csh() {
        myZy = new HashMap<>();
        zyList = new ArrayList<>();
        a_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(0).toString());
        q_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(2).toString());
        e_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(1).toString());
        user_mz(mz);
        wq_syw_csh(jszsg, context, "42");
        enemy = new Enemy(Enemy.ELEMENT_FIRE, 1000);
        List<Sh_data> data = new ArrayList<>();
        g1();
        g2();
        data.add(new Sh_data("E伤害", user_e()));
        data.add(new Sh_data("Q单段伤害", user_q()));
        data.add(new Sh_data("A一轮伤害", user_a(b)));
        return data;
    }

    @Override
    public double[] user_a(int a) {
        String key="30";
        double[] d;
        double sh_ysh=0;
        if (a==-1&&mz>=2){
            sh_ysh+= (getSmz(0) *0.144  + getJc("30042", "10024")) * getZs("42", "10003") * getFy() * getYsKx("42");
        }
        if (a==-1&&mz<6){
            sh_ysh += (getGj(0) *
                    (getbl(a_level, 0, 1, 0)) + getJc("300"+key, "10022"))
                    * getZs(key, "10001") * getFy() * getYsKx(key);
            accumulateValue("10012",0.035);
            sh_ysh+= (getSmz(0) * getbl(q_level, 2, 1, 1)  + getJc("30042", "10024")) * getZs("42", "10003") * getFy() * getYsKx("42")*3;
            sh_ysh += (getGj(0) *
                    (getbl(a_level, 0, 1, 1)) + getJc("300"+key, "10022"))
                    * getZs(key, "10001") * getFy() * getYsKx(key);
            accumulateValue("10012",0.035);
            sh_ysh+=(getSmz(0) * getbl(q_level, 2, 1, 1) + getJc("30042", "10024")) * getZs("42", "10003") * getFy() * getYsKx("42")*3;
            sh_ysh += (getGj(0) *
                    (getbl(a_level, 0, 1, 2)) + getJc("300"+key, "10022"))
                    * getZs(key, "10001") * getFy() * getYsKx(key);
            sh_ysh+=(getSmz(0) * getbl(q_level, 2, 1, 1) + getJc("30042", "10024")) * getZs("42", "10003") * getFy() * getYsKx("42")*3;
            sh_ysh += (getGj(0) *
                    (getbl(a_level, 0, 1, 3)) + getJc("300"+key, "10022"))
                    * getZs(key, "10001") * getFy() * getYsKx(key);
            sh_ysh += (getGj(0) *
                    (getbl(a_level, 0, 3, 3)) + getJc("300"+key, "10022"))
                    * getZs(key, "10001") * getFy() * getYsKx(key);
        }else if (mz==6){
            sh_ysh += (getSmz(0) * getbl(a_level, 0, 1, 6)  + getJc("30042", "10024")) * getZs("42", "10005") * getFy() * getYsKx("42")*1.56;
            accumulateValue("10012",0.035);
            sh_ysh+= (getSmz(0) * getbl(q_level, 2, 1, 1)  + getJc("30042", "10024")) * getZs("42", "10003") * getFy() * getYsKx("42")*3;
            sh_ysh += (getSmz(0) * getbl(a_level, 0, 1, 6)  + getJc("30042", "10024")) * getZs("42", "10005") * getFy() * getYsKx("42")*1.56;
            accumulateValue("10012",0.035);
            sh_ysh+=(getSmz(0) * getbl(q_level, 2, 1, 1) + getJc("30042", "10024")) * getZs("42", "10003") * getFy() * getYsKx("42")*3;
            sh_ysh += (getSmz(0) * getbl(a_level, 0, 1, 6)  + getJc("30042", "10024")) * getZs("42", "10005") * getFy() * getYsKx("42")*1.56;
            sh_ysh+=(getSmz(0) * getbl(q_level, 2, 1, 1) + getJc("30042", "10024")) * getZs("42", "10003") * getFy() * getYsKx("42")*3;
            sh_ysh += (getSmz(0) * getbl(a_level, 0, 1, 6)  + getJc("30042", "10024")) * getZs("42", "10005") * getFy() * getYsKx("42")*1.56;

            sh_ysh += (getSmz(0) * getbl(a_level, 0, 1, 6)  + getJc("30042", "10024")) * getZs("42", "10005") * getFy() * getYsKx("42")*1.56;

        }

        d = getqw("100042", sh_ysh, 0);
        return d;
    }

    @Override
    public double[] user_q() {
        double[] d;
        double sh_ysh = (getSmz(0) * getbl(q_level, 2, 1, 1)  + getJc("30042", "10024")) * getZs("42", "10003") * getFy() * getYsKx("42");
        d = getqw("100042", sh_ysh, 2);
        return d;
    }

    @Override
    public double[] user_e() {
        double[] d;
        double sh_ysh = (getSmz(0) * getbl(e_level, 1, 1, 0) + getJc("30042", "10024")) * getZs("42", "10002") * getFy() * getYsKx("42");
        d = getqw("100042", sh_ysh, 1);
        return d;
    }

    @Override
    public void user_mz(int mz) {
        switch (mz){
            case 6:
            case 5:
                if (e_level < 11)
                    e_level += 3;
            case 4:
                if (!addZy(new Zy(0.4, "4命", false, false, "3", 0, 0))) {
                    accumulateValue("3", 0.4);
                }
            case 3:
                if (q_level < 11)
                    q_level += 3;

            case 2:

                break;
            case 1:

        }
    }

    @Override
    public void g1() {
        if (dj >= 40)
            if (!addZy(new Zy(0.3, "4色队固有1", false, false, "3", 0, 0))) {
                accumulateValue("3", 0.3);
            }
    }

    @Override
    public void g2() {
        if (dj >= 70)
            if (!addZy(new Zy(0.01, "固有2", false, false, "10012", 0, 0))) {
                accumulateValue("10012", 0.01);
            }
    }

    @Override
    public void g3() {

    }
}
