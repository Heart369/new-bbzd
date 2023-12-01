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

public class Yae extends Obj_calculator {
    public Yae(Jszsg.AvatarInfoListDTO jszsg, List<Bl_cl> bl_cl, CharacterData du, Context context) {
        super(jszsg, bl_cl, du, context);
    }

    int e = 3, jh = 0;

    @Override
    void cshsz() {
        a_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(0).toString());
        q_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(2).toString());
        e_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(1).toString());
        ysbf = getbl(q_level, 2, 1, 3);
        ys_key = "41";
    }

    @Override
    public List<Sh_data> csh() {
        myZy = new HashMap<>();
        zyList = new ArrayList<>();
        a_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(0).toString());
        q_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(2).toString());
        e_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(1).toString());
        user_mz(mz);
        wq_syw_csh(jszsg, context, "41");
        enemy = new Enemy(Enemy.ELEMENT_J, 1000);
        List<Sh_data> data = new ArrayList<>();
        g1();
        g2();
        g3();
        jh = 0;
        data.add(new Sh_data(e + "阶杀生樱", user_e()));
        jh = 1;
        data.add(new Sh_data(e + "阶杀生樱激化", user_e()));
        data.add(new Sh_data("Q伤害总和", user_q()));
        return data;
    }

    @Override
    public double[] user_a(int a) {
        return new double[0];
    }

    @Override
    public double[] user_q() {
        double[] d;
        double sh_ysh = (getGj(0) * (getbl(q_level, 2, 1, 0) + getbl(q_level, 2, 1, 1) * e) + getJc("30041", "10024")) * getZs("41", "10003") * getFy() * getYsKx("41");
        d = getqw("10041", sh_ysh, 2);
        return d;
    }

    @Override
    public double[] user_e() {
        double[] d;
        if (jh == 1) {
            getYsfy(Enemy.ELEMENT_L);
        }
        if (mz==6)
            accumulateValue("10052", 0.6);
        if (mz>=4)
            accumulateValue("41", 0.2);
        double sh_ysh = (getGj(0) * getbl(e_level, 1, 1, e - 1) + getJc("30041", "10023")) * getZs("41", "10002") * getFy() * getYsKx("41");
        d = getqw("100041", sh_ysh, 1);
        if (mz==6)
            accumulateValue("10052", -0.6);
        if (mz>=4)
            accumulateValue("41", -0.2);
        return d;
    }

    @Override
    public void user_mz(int mz) {
        e=3;
        switch (mz) {

            case 6:
                if (!addZy(new Zy(0.6, "6命", false, false, "10052", 0, 0))) {

                }
            case 5:
                if (q_level < 11)
                    q_level += 3;

            case 4:
                if (!addZy(new Zy(0.2, "4命", false, false, "41", 0, 0))) {

                }
            case 3:
                if (e_level < 11)
                    e_level += 3;
            case 2:
                e = 4;
            case 1:

        }
    }

    @Override
    public void g1() {

    }

    @Override
    public void g2() {
        if (dj >= 70) {
            if (!addZy(new Zy(getYsjt(1) * 0.0015, "固有天赋2", false, false, "10002", 0, 0))) {
                accumulateValue("10002", getYsjt(1) * 0.0015);
            }
        }
    }

    @Override
    public void g3() {

    }
}
