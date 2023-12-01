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

public class Xinyan extends Obj_calculator {
    public Xinyan(Jszsg.AvatarInfoListDTO jszsg, List<Bl_cl> bl_cl, CharacterData du, Context context) {
        super(jszsg, bl_cl, du, context);
    }

    @Override
    void cshsz() {
        a_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(0).toString());
        q_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(2).toString());
        e_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(1).toString());
        ys_key = "40";
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
        wq_syw_csh(jszsg, context, "40");
        enemy = new Enemy(Enemy.ELEMENT_WATER, 1000);
        List<Sh_data> data = new ArrayList<>();
        data.add(new Sh_data("满层护盾",new double[]{(getFyl(0)*getbl(e_level,1,1,3)+getbl(e_level,1,3,3))*getHD(),0}));
        data.add(new Sh_data("重击伤害",user_a(0)));
        return data;
    }

    @Override
    public double[] user_a(int a) {
        double[] d;
        double sh_ysh = (getGj(0) * getbl(a_level, 0, 1, 4) * getZs("30", "10015") + getJc("30040", "10021")) * getFy() * getYsKx("30");
        d = getqw("100040", sh_ysh, 2);
        return d;
    }

    @Override
    public double[] user_q() {
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
                if (!addZy(new Zy(getFyl(0)*0.5, "命座6", true, false, "5", 0, 0)))
                    accumulateValue("5", getFyl(0)*0.5);
            case 5:
                if (q_level < 11)
                    q_level += 3;

            case 4:
                if (!addZy(new Zy(0.15, "命座4", true, false, "20030", 0, 0)))
                    accumulateValue("20030", 0.15);
            case 3:
                if (e_level < 11)
                    e_level += 3;
            case 2:

            case 1:
        }

    }

    @Override
    public void g1() {

    }

    @Override
    public void g2() {

    }

    @Override
    public void g3() {

    }
}
