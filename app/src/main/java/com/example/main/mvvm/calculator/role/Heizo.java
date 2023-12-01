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

public class Heizo extends Obj_calculator {
    public Heizo(Jszsg.AvatarInfoListDTO jszsg, List<Bl_cl> bl_cl, CharacterData du, Context context) {
        super(jszsg, bl_cl, du, context);
    }

    @Override
    void cshsz() {
        a_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(0).toString());
        q_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(2).toString());
        e_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(1).toString());
        ys_key = "45";
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
        wq_syw_csh(jszsg, context, "45");
        enemy = new Enemy(-1, 1000);
        List<Sh_data> data = new ArrayList<>();
        data.add(new Sh_data("满层E", user_e()));
        data.add(new Sh_data("Q首段", user_q()));
        return data;
    }

    @Override
    public double[] user_a(int a) {
        return new double[0];
    }

    @Override
    public double[] user_q() {
        double[] d;
        double sh_ysh = 0;
        sh_ysh = (getGj(0) * getbl(q_level, 2, 1, 0) + getJc("30044", "10023")) * getZs("44", "10003") * getFy() * getYsKx("44");
        d = getqw("10044", sh_ysh, 2);
        return d;
    }

    @Override
    public double[] user_e() {
        double[] d;
        double sh_ysh = 0;
        sh_ysh = (getGj(0) * (getbl(e_level, 1, 1, 0) + getbl(e_level, 1, 1, 1) * 4 + getbl(e_level, 1, 1, 2)) + getJc("30044", "10023")) * getZs("44", "10002") * getFy() * getYsKx("44");
        d = getqw("10044", sh_ysh, 1);
        return d;
    }

    @Override
    public void user_mz(int mz) {
        switch (mz) {
            case 6:
                if (!addZy(new Zy(0.32, "命座6_1", false, false, "22", getTime(), 0))) {
                    accumulateValue("22", 0.32);
                }
                if (!addZy(new Zy(0.16, "命座6_2", false, false, "20", getTime(), 0))) {
                    accumulateValue("20", 0.16);
                }
            case 5:
                if (q_level < 11)
                    q_level += 3;


            case 4:

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

    }

    @Override
    public void g3() {

    }
}
