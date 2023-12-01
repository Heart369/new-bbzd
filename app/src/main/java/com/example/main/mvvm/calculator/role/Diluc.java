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

public class Diluc extends Obj_calculator {
    public Diluc(Jszsg.AvatarInfoListDTO jszsg, List<Bl_cl> bl_cl, CharacterData du, Context context) {
        super(jszsg, bl_cl, du, context);
    }
    int fy=0;
    @Override
    void cshsz() {
        a_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(0).toString());
        q_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(2).toString());
        e_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(1).toString());
        ys_key = "40";
        ysbf = getbl(q_level, 2, 1, 5);
    }

    @Override
    public List<Sh_data> csh() {
        myZy = new HashMap<>();
        zyList = new ArrayList<>();
        if (!addZy(new Zy(0.15, "修正魔女", false, false, "40", 0, 0))) {
            accumulateValue("40", 0.15);
        }
        a_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(0).toString());
        q_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(2).toString());
        e_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(1).toString());
        user_mz(mz);
        wq_syw_csh(jszsg, context, "40");
        enemy = new Enemy(Enemy.ELEMENT_WATER, 1000);
        List<Sh_data> data = new ArrayList<>();
        fy=0;
        data.add(new Sh_data("E首段伤害", user_e()));
        fy=1;
        data.add(new Sh_data("E首段蒸发伤害", user_e()));
        data.add(new Sh_data("Q首段伤害", user_q()));
        return data;
    }

    @Override
    public double[] user_a(int a) {
        return new double[0];
    }

    @Override
    public double[] user_q() {
        g2();
        double[] d;
        double sh_ysh = (getGj(0) * getbl(q_level, 2, 1, 0) * getZs("40", "10003") + getJc("30040", "10023")) * getFy() * getYsKx("40");
        d = getqw("100040", sh_ysh, 2);
        return d;
    }

    @Override
    public double[] user_e() {
        double[] d;

        double sh_ysh = (getGj(0) * getbl(e_level, 1, 1, 0) * getZs("40", "10002") + getJc("30040", "10023")) * getFy() * getYsKx("40");
        if (fy==1)
            sh_ysh=getZf(sh_ysh,0);
        d = getqw("100040", sh_ysh, 1);
        return d;
    }

    @Override
    public void user_mz(int mz) {
        switch (mz) {
            case 6:
                if (!addZy(new Zy(1, "6命", true, false, "20", getTime(), 10)))
                    accumulateValue("20", getSmz(0) * 0.1);
            case 5:
                if (q_level < 11)
                    q_level += 3;

            case 4:
                //        if (!addZy(new Zy(0.33, "固有天赋一", true, false, "40", 0, 0))) {
//            accumulateValue("40", 0.33);
            case 3:
                if (e_level < 11)
                    e_level += 3;
            case 2:
//                if (!addZy(new Zy(0.3, "2命", true, false, "6", 0, 0)))
//                    accumulateValue("6", 0.3);
            case 1:
                if (!addZy(new Zy(0.15, "1命", true, false, "10012", 0, 0)))
                    accumulateValue("10012", 0.15);
        }
    }

    @Override
    public void g1() {

    }

    @Override
    public void g2() {
        if (!addZy(new Zy(0.2, "固有2", false, false, "40", 0, 0))) {
            accumulateValue("40", 0.2);
        }
    }

    @Override
    public void g3() {

    }
}
