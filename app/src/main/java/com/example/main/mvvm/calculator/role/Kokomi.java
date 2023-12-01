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

public class Kokomi extends Obj_calculator{
    public Kokomi(Jszsg.AvatarInfoListDTO jszsg, List<Bl_cl> bl_cl, CharacterData du, Context context) {
        super(jszsg, bl_cl, du, context);
    }

    @Override
    void cshsz() {
        a_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(0).toString());
        q_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(2).toString());
        e_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(1).toString());
        ys_key = "42";
        ysbf = getbl(q_level, 2, 1, 5);
    }

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
        g3();
        g1();
        g2();
        Log.d("TAGZL",getCure()+","+getbl(e_level,1,1,0)*getSmz(0));
        data.add(new Sh_data("E每跳",new double[]{(getbl(e_level,1,1,0)*getSmz(0)+getbl(e_level,1,3,0)+getJcCure())*getCure(),0}));
        user_q();
        data.add(new Sh_data("开Q后A首段",user_a(0)));
        data.add(new Sh_data("开Q后重击",user_a(3)));
        return data;
    }

    @Override
    public double[] user_a(int a) {
        double[] d;
        double sh_ysh=0;
        if (a==3){
            sh_ysh = (getGj(0) * getbl(a_level, 0, 1, a)+getJc("30040","10025")) * getZs("42", "10015") * getFy() * getYsKx("42") ;
        }else sh_ysh = (getGj(0) * getbl(a_level, 0, 1, a)+getJc("30040","10022")) * getZs("42", "10015") * getFy() * getYsKx("42") ;

        d=getqw("10042",sh_ysh, 0);
        return d;
    }

    @Override
    public double[] user_q() {
        if (!addZy(new Zy((getbl(q_level,2,1,1)+myZy.get("10050"))*getSmz(1), "元素爆发1", false, false, "10022", 0, 0))) {
            accumulateValue("10022", (getbl(q_level,2,1,1)+myZy.get("10050"))*getSmz(1));
        }
        if (!addZy(new Zy((getbl(q_level,2,1,3)+myZy.get("10050"))*getSmz(1), "元素爆发2", false, false, "10023", 0, 0))) {
            accumulateValue("10023", (getbl(q_level,2,1,3)+myZy.get("10050"))*getSmz(1));
        }
        if (!addZy(new Zy((getbl(q_level,2,1,2)+myZy.get("10050"))*getSmz(1), "元素爆发3", false, false, "10025", 0, 0))) {
            accumulateValue("10025", (getbl(q_level,2,1,2)+myZy.get("10050"))*getSmz(1));
        }
        return new double[0];
    }

    @Override
    public double[] user_e() {
        return new double[0];
    }

    @Override
    public void user_mz(int mz) {
        switch (mz) {
            case 6:
                if (!addZy(new Zy(0.4, "命座6", false, false, "42", getTime(), 10))) {
                    accumulateValue("42", 0.4);
                }
            case 5:
                if (e_level < 11)
                    e_level += 3;
            case 4:

            case 3:
                if (q_level < 11)
                    q_level += 3;
            case 2:
                if (!addZy(new Zy(getSmz(0)*0.045, "命座2", false, false, "10051", getTime(), 10))) {
                    accumulateValue("10051", getSmz(0)*0.04555);
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
        if (dj>=70){
            if (!addZy(new Zy((getCure()-1)*0.15, "妙算无遗1", false, false, "10050", 0, 0))) {
                accumulateValue("10050", (getCure()-1)*0.15);
            }
        }
    }

    @Override
    public void g3() {
    }
}
