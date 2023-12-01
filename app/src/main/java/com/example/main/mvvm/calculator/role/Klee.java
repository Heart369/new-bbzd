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

public class Klee extends Obj_calculator{
    public Klee(Jszsg.AvatarInfoListDTO jszsg, List<Bl_cl> bl_cl, CharacterData du, Context context) {
        super(jszsg, bl_cl, du, context);
    }

    @Override
    void cshsz() {
        a_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(0).toString());
        q_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(2).toString());
        e_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(1).toString());
        ys_key = "40";
        ysbf = getbl(q_level, 2, 1, 3);
    }
    int fy=1;
    @Override
    public List<Sh_data> csh() {
        myZy = new HashMap<>();
        zyList = new ArrayList<>();
        a_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(0).toString());
        q_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(2).toString());
        e_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(1).toString());
        user_mz(mz);
        wq_syw_csh(jszsg, context, "40");
        enemy = new Enemy(Enemy.ELEMENT_WATER, 1000);
        List<Sh_data> data = new ArrayList<>();
        g1();
        user_e();
        fy=1;
        data.add(new Sh_data("E后重击伤害",user_a(3)));
        fy=0;
        data.add(new Sh_data("E后重击蒸发伤害",user_a(3)));
        return data;
    }

    @Override
    public double[] user_a(int a) {
        double[] d;
        double sh_ysh=0;
        if (a==3){
            sh_ysh = (getGj(0) * getbl(a_level, 0, 1, a)+getJc("30040","10025")) * getZs("40", "10015") * getFy() * getYsKx("40") ;
        }
        if (fy==0)
        sh_ysh=getZf(sh_ysh,0);
        d=getqw("10040",sh_ysh, 0);
        return d;
    }

    @Override
    public double[] user_q() {
        return new double[0];
    }

    @Override
    public double[] user_e() {
        if (mz>1)
        if (!addZy(new Zy(0.23, "命座2", false, false, "10007", getTime(), 10))) {
            accumulateValue("10007", 0.23);
        }
        return new double[0];
    }

    @Override
    public void user_mz(int mz) {
        switch (mz) {
            case 6:
                if (!addZy(new Zy(0.1, "命4", false, false, "40", getTime(), 0))) {
                    accumulateValue("40", 0.1);
                }
            case 5:
                if (e_level < 11)
                    e_level += 3;

            case 4:

            case 3:
                if (q_level < 11)
                    q_level += 3;
            case 2:
//                if (!addZy(new Zy(0.24, "命座6", false, false, "20044", getTime(), 0))) {
//                    accumulateValue("20044", 0.24);
//                }
                break;
            case 1:

        }
    }

    @Override
    public void g1() {
        if (dj>=40){
            if (!addZy(new Zy(0.5, "固有天赋1", false, false, "10015", getTime(), 0))) {
                accumulateValue("10015", 0.5);
            }
        }
    }

    @Override
    public void g2() {

    }

    @Override
    public void g3() {

    }
}
