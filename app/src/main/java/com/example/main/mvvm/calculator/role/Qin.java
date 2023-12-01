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

public class Qin extends Obj_calculator{
    public Qin(Jszsg.AvatarInfoListDTO jszsg, List<Bl_cl> bl_cl, CharacterData du, Context context) {
        super(jszsg, bl_cl, du, context);
    }

    @Override
    void cshsz() {
        a_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(0).toString());
        q_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(2).toString());
        e_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(1).toString());
        ys_key = "44";
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
        wq_syw_csh(jszsg, context, "44");
        enemy = new Enemy(Enemy.ELEMENT_J, 1000);
        List<Sh_data> data = new ArrayList<>();

        data.add(new Sh_data("Q顺发奶",new double[]{(getGj(1)*getbl(q_level,2,1,2)+getbl(q_level,2,3,2))*getCure(),0}));
        data.add(new Sh_data("Q顺发伤害",user_q()));

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
                if (!addZy(new Zy(0.4, "命4", false, false, "20044", getTime(), 0))) {
                    accumulateValue("20044", 0.4);
                }
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

    }

    @Override
    public void g2() {

    }

    @Override
    public void g3() {

    }
}
