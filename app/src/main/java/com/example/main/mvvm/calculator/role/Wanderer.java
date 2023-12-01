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

public class Wanderer extends Obj_calculator {

    public Wanderer(Jszsg.AvatarInfoListDTO jszsg, List<Bl_cl> bl_cl, CharacterData du, Context context) {
        super(jszsg, bl_cl, du, context);
    }

    @Override
    void cshsz() {
        a_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(0).toString());
        q_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(2).toString());
        e_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(1).toString());
        ys_key = "44";
        ysbf = getbl(q_level, 2, 1, 2);
    }

    @Override
    public List<Sh_data> csh() {
        myZy = new HashMap<>();
        zyList = new ArrayList<>();
        a_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(0).toString());
        q_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(2).toString());
        e_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(1).toString());
        user_mz(mz);
        wq_syw_csh(jszsg, context, "44");
        enemy = new Enemy(Enemy.ELEMENT_J, 1000);
        List<Sh_data> data = new ArrayList<>();
//        user_e();
        data.add(new Sh_data("E三段A", user_a(-1)));
        data.add(new Sh_data("Q总伤", user_q()));
        return data;
    }

    @Override
    public double[] user_a(int a) {
        double[] d;
        double sh_ysh = 0;
        sh_ysh = (getGj(0) * getbl(a_level, 0, 1, 0) * getbl(e_level, 1, 1, 1) + getJc("30044", "10023")) * getZs("44", "10001") * getFy() * getYsKx("44");
        sh_ysh += (getGj(0) * getbl(a_level, 0, 1, 1) * getbl(e_level, 1, 1, 1) + getJc("30044", "10023")) * getZs("44", "10001") * getFy() * getYsKx("44");
        sh_ysh += (getGj(0) * getbl(a_level, 0, 1, 2) * getbl(e_level, 1, 1, 1) + getJc("30044", "10023")) * getZs("44", "10001") * getFy() * getYsKx("44");
        sh_ysh += (getGj(0) * getbl(a_level, 0, 3, 2) * getbl(e_level, 1, 1, 1) + getJc("30044", "10023")) * getZs("44", "10001") * getFy() * getYsKx("44");
        if (mz==6)
            sh_ysh+=sh_ysh*0.4;
        d = getqw("10044", sh_ysh, 0);
        return d;
    }

    @Override
    public double[] user_q() {
        double[] d;
        double sh_ysh = 0;
        Log.d("TAGCS", getGj(0) + "," + getbl(q_level, 0, 1, 0) + "," + getZs("44", "10003"));
        sh_ysh = (getGj(0) * getbl(q_level, 2, 1, 0) + getJc("30044", "10023")) * getZs("44", "10003") * getFy() * getYsKx("44") * 5;
        d = getqw("10044", sh_ysh, 2);
        return d;
    }

    @Override
    public double[] user_e() {
        if (!addZy(new Zy(0.3, "E增伤_1", false, false, "6", getTime(), 0))) {
            accumulateValue("6", 0.3);
        }
        if (!addZy(new Zy(0.2, "E增伤_2", false, false, "20", getTime(), 0))) {
            accumulateValue("20", 0.2);
        }
        return new double[0];
    }

    @Override
    public void user_mz(int mz) {
        switch (mz) {
            case 6:
            case 5:
                if (e_level < 11)
                    e_level += 3;
            case 4:

            case 3:
                if (q_level < 11)
                    q_level += 3;
            case 2:
                if (!addZy(new Zy(2, "2命", false, false, "10003", getTime(), 0))) {
                    accumulateValue("10003", 2.0);
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

    }

    @Override
    public void g3() {

    }
}
