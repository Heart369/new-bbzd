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

public class Cyno extends Obj_calculator {
    public Cyno(Jszsg.AvatarInfoListDTO jszsg, List<Bl_cl> bl_cl, CharacterData du, Context context) {
        super(jszsg, bl_cl, du, context);
    }

    int q = 0;

    @Override
    void cshsz() {
        a_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(0).toString());
        q_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(2).toString());
        e_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(1).toString());
        ysbf = getbl(q_level, 2, 1, 12);
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
        user_q();
        double[] d = user_e();
        data.add(new Sh_data("E超激化", d));
        double[] d2 = user_a(-1);
        d2[0] = d2[0] + d[0];
        d2[1] = d2[1] + d[1];
        data.add(new Sh_data("Q后一轮伤害", d2));
        return data;
    }

    @Override
    public double[] user_a(int a) {
        double[] d;
        double sh_ysh = 0;
        if (a == -1 && q == 1) {
            getYsfy(Enemy.ELEMENT_L);
            sh_ysh = (getGj(0) * getbl(q_level, 2, 1, 0) + getJc("30041", "10022")) * getZs("41", "10001") * getFy() * getYsKx("41");
            sh_ysh += (getGj(0) * getbl(q_level, 2, 1, 1) + getJc("30041", "10022")) * getZs("41", "10001") * getFy() * getYsKx("41");
            sh_ysh += (getGj(0) * getbl(q_level, 2, 1, 2) + getJc("30041", "10022")) * getZs("41", "10001") * getFy() * getYsKx("41");
            getYsfy(Enemy.ELEMENT_L);
            sh_ysh += (getGj(0) * getbl(q_level, 2, 1, 3) + getJc("30041", "10022")) * getZs("41", "10001") * getFy() * getYsKx("41");
            sh_ysh += (getGj(0) * getbl(q_level, 2, 3, 3) + getJc("30041", "10022")) * getZs("41", "10001") * getFy() * getYsKx("41");
            sh_ysh += (getGj(0) * getbl(q_level, 2, 1, 4) + getJc("30041", "10022")) * getZs("41", "10001") * getFy() * getYsKx("41");
            if (mz==6){
                getYsfy(Enemy.ELEMENT_L);
                sh_ysh += (getGj(0) + getJc("30041", "10050")) * getZs("41", "-1") * getFy() * getYsKx("41");
                sh_ysh += (getGj(0) + getJc("30041", "10050")) * getZs("41", "-1") * getFy() * getYsKx("41") * 3;
            }
        }
        d = getqw("100041", sh_ysh, 0);
        return d;
    }

    @Override
    public double[] user_q() {
        q = 1;
        accumulateValue("28", 100.0);
        return new double[0];
    }

    @Override
    public double[] user_e() {
        double[] d;
        double sh_ysh = 0;
        if (q == 1) {
            g1();
            g2();
            getYsfy(Enemy.ELEMENT_L);
            sh_ysh = (getGj(0) * getbl(e_level, 1, 1, 1) + getJc("30041", "10023")) * getZs("41", "10002") * getFy() * getYsKx("41");
            sh_ysh += (getGj(0) + getJc("30041", "10050")) * getZs("41", "-1") * getFy() * getYsKx("41") * 2;
            getYsfy(Enemy.ELEMENT_L);
            sh_ysh += (getGj(0) + getJc("30041", "10050")) * getZs("41", "-1") * getFy() * getYsKx("41");
        }
        d = getqw("100041", sh_ysh, 1);
        return d;
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
                if (!addZy(new Zy(0.5, "命座2", false, false, "41", 0, 0))) {
                    accumulateValue("41", 0.5);
                }
            case 1:

        }
    }

    @Override
    public void g1() {
        if (dj >= 40) {
            if (!addZy(new Zy(0.35, "固有天赋1", false, false, "10002", 0, 0))) {
                accumulateValue("10002", 0.35);
            }
        }
    }

    @Override
    public void g2() {
        if (dj >= 70) {
            if (!addZy(new Zy(getYsjt(1) * 1.5, "固有天赋2_1", false, false, "10022", 0, 0))) {
                accumulateValue("10022", getYsjt(1) * 1.5);
            }
            if (!addZy(new Zy(getYsjt(1) * 2.5, "固有天赋2_2", false, false, "10050", 0, 0))) {
                accumulateValue("10050", getYsjt(1) * 2.5);
            }
        }
    }

    @Override
    public void g3() {

    }
}
