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

public class Itto extends Obj_calculator{
    public Itto(Jszsg.AvatarInfoListDTO jszsg, List<Bl_cl> bl_cl, CharacterData du, Context context) {
        super(jszsg, bl_cl, du, context);
    }

    @Override
    void cshsz() {
        a_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(0).toString());
        q_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(2).toString());
        e_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(1).toString());
        ys_key = "45";
        ysbf = getbl(q_level, 2, 1, 4);
    }

    @Override
    public List<Sh_data> csh() {
        myZy = new HashMap<>();
        zyList = new ArrayList<>();
        a_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(0).toString());
        q_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(2).toString());
        e_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(1).toString());
        user_mz(mz);
        wq_syw_csh(jszsg, context, "45");
        enemy = new Enemy(-1, 1000);
        List<Sh_data> data = new ArrayList<>();
        user_q();
        g2();
        data.add(new Sh_data("重击伤害",user_a(4)));
        data.add(new Sh_data("E牛牛伤害",user_e()));
        return data;
    }

    @Override
    public double[] user_a(int a) {
        double[] d;
        double sh_ysh=0;
        if (a==4){
            if (mz==6)
                accumulateValue("22",0.6);
            sh_ysh=(getGj(0) * getbl(a_level, 0, 1, a) + getJc("30045","10025")) * getZs(ys_key, "10015") * getFy() * getYsKx(ys_key);

        }
        d=getqw("10045",sh_ysh, 0);
        if (mz==6)
            accumulateValue("22",-0.6);
        return d;
    }

    @Override
    public double[] user_q() {
        if (!addZy(new Zy(getFyl(1)*getbl(q_level,2,1,0), "Q攻击力加成", false, false, "5", getTime(), 0))) {
            accumulateValue("5", getFyl(1)*getbl(q_level,2,1,0));
        }
        return new double[0];
    }

    @Override
    public double[] user_e() {
        double[] d;
        double sh_ysh= (getGj(0) * getbl(e_level, 1, 1, 0) + getJc("30045","10024")) * getZs(ys_key, "10002") * getFy() * getYsKx(ys_key);
        d=getqw("10045",sh_ysh, 1);
        return d;

    }

    @Override
    public void user_mz(int mz) {
        switch (mz){
            case 6:

            case 5:
                if (q_level < 11)
                    q_level += 3;
            case 4:
                if (!addZy(new Zy(0.2,"命座4_1", false, false, "6", getTime(), 0))) {
                    accumulateValue("6", 0.2);
                }
                if (!addZy(new Zy(0.2, "命座4_2", false, false, "9", getTime(), 0))) {
                    accumulateValue("9", 0.2);
                }
            case 3:
                if (e_level < 11)
                    e_level += 3;
            case 2:
                break;
            case 1:

        }
    }

    @Override
    public void g1() {

    }

    @Override
    public void g2() {
        if (dj>=70)
        if (!addZy(new Zy(getFyl(1)*0.35, "固有天赋1", false, false, "10025", getTime(), 0))) {
            accumulateValue("10025", getFyl(1)*0.35);
        }
    }

    @Override
    public void g3() {

    }
}
