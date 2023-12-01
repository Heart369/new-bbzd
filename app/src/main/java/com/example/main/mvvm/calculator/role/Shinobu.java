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

public class Shinobu extends Obj_calculator {
    public Shinobu(Jszsg.AvatarInfoListDTO jszsg, List<Bl_cl> bl_cl, CharacterData du, Context context) {
        super(jszsg, bl_cl, du, context);
    }

    @Override
    void cshsz() {
        a_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(0).toString());
        q_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(2).toString());
        e_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(1).toString());
        ysbf = getbl(q_level, 2, 1, 4);
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
        enemy = new Enemy(-1, 1000);
        List<Sh_data> data = new ArrayList<>();
        g1();
        g2();
        g3();
        data.add(new Sh_data("E每段伤害", user_e()));
        data.add(new Sh_data("E每段治疗", new double[]{(getSmz(0) * getbl(e_level, 1, 1, 1) + getbl(e_level, 1, 3, 1) + myZy.get("10051")) * getCure(), 0}));
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
        double sh_ysh = (getGj(0) * getbl(e_level, 1, 1, 2) + getJc("30041", "10023")) * getZs("41", "10002") * getFy() * getYsKx("41");
        d = getqw("10041", sh_ysh, 1);
        return d;
    }

    @Override
    public void user_mz(int mz) {
        switch (mz) {
            case 6:
                if (!addZy(new Zy(150, "6命", true, false, "28", getTime(), 10)))
                    accumulateValue("28", 150.0);
            case 5:
                if (q_level < 11)
                    q_level += 3;
            case 4:

            case 3:
                if (e_level < 11)
                    e_level += 3;
            case 2:

            case 1:

        }
    }

    @Override
    public void g1() {
        if (dj >= 40) {
            if (!addZy(new Zy(0.15, "固有天赋一", false, false, "26", 0, 0))) {
                accumulateValue("26", 0.15);
            }
        }
    }

    @Override
    public void g2() {
        if (dj >= 70) {
            if (!addZy(new Zy(getYsjt(0) * 0.75, "固有天赋二_1", false, false, "10051", 0, 0))) {
                accumulateValue("10051", getYsjt(0) * 0.75);
            }
            if (!addZy(new Zy(getYsjt(0) * 0.25, "固有天赋二_2", false, false, "10023", 0, 0))) {
                accumulateValue("10023", getYsjt(0) * 0.25);
            }
        }
    }

    @Override
    public void g3() {

    }
}
