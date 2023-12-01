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

public class Layla extends Obj_calculator {
    public Layla(Jszsg.AvatarInfoListDTO jszsg, List<Bl_cl> bl_cl, CharacterData du, Context context) {
        super(jszsg, bl_cl, du, context);
    }

    @Override
    void cshsz() {
        a_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(0).toString());
        q_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(2).toString());
        e_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(1).toString());
        ys_key = "46";
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
        wq_syw_csh(jszsg, context, "46");
        enemy = new Enemy(Enemy.ELEMENT_WATER, 1000);
        List<Sh_data> data = new ArrayList<>();
        user_e();
        g1();
        g2();
        data.add(new Sh_data("满层护盾", new double[]{(getSmz(0) * getbl(e_level, 1, 1, 2) + getbl(e_level, 1, 3, 2)) * getHD(), 0}));
        data.add(new Sh_data("飞星单段伤害", user_e()));

        return data;
    }

    @Override
    public double[] user_a(int a) {
        return new double[0];
    }

    @Override
    public double[] user_q() {
        return new double[0];
    }

    @Override
    public double[] user_e() {
        double[] d;
        double sh_ysh = (getGj(0) * (getbl(e_level, 1, 1, 1))+ getJc("30030","10023")) * getZs("30", "10002") * getFy() * getYsKx("30");
        d = getqw("100030", sh_ysh, 1);
        return d;
    }

    @Override
    public void user_mz(int mz) {
        switch (mz) {
            case 6:
                if (!addZy(new Zy(0.4, "6命", true, false, "10002", 0, 0)))
                    accumulateValue("10002", 0.4);
            case 5:
                if (q_level < 11)
                    q_level += 3;
            case 4:

            case 3:
                if (e_level < 11)
                    e_level += 3;
            case 2:

            case 1:
                if (!addZy(new Zy(0.2, "命座1", false, false, "81", 0, 0))) {
                    accumulateValue("81", 0.2);
                }
        }
    }

    @Override
    public void g1() {
        if (dj >= 40)
            if (!addZy(new Zy(0.24, "天赋1", false, false, "81", 0, 0))) {
                accumulateValue("81", 0.24);
            }
    }

    @Override
    public void g2() {
        if (dj >= 70)
            if (!addZy(new Zy(getSmz(0) * 0.015, "天赋2", false, false, "10023", 0, 0))) {
                accumulateValue("10023", getSmz(0) * 0.015);
            }
    }

    @Override
    public void g3() {

    }
}
