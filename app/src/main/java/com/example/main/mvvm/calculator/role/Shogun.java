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

public class Shogun extends Obj_calculator {
    public Shogun(Jszsg.AvatarInfoListDTO jszsg, List<Bl_cl> bl_cl, CharacterData du, Context context) {
        super(jszsg, bl_cl, du, context);
    }

    @Override
    void cshsz() {
        double cn= getYscn(0)*100;
        jszsg_fb.getFightPropMap().put("41",jszsg_fb.getFightPropMap().get("41")-(cn-1)*0.004);
        a_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(0).toString());
        q_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(2).toString());
        e_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(1).toString());
        ysbf = getbl(q_level, 2, 1, 15);
        ys_key="41";
    }

    int yl = 60;

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
        user_e();
        data.add(new Sh_data("满愿力首刀伤害", user_q()));
        if (!addZy(new Zy(0.4, "风套", false, false, "20041", 0, 0))) {
            accumulateValue("20041", 0.4);
        }
        if (!addZy(new Zy(1950, "班尼特+九条攻击力", false, false, "5", 0, 0))) {
            accumulateValue("5", 1950.0);
        }
        if (!addZy(new Zy(0.6, "九条6命", false, false, "10041", 0, 0))) {
            accumulateValue("10041", 0.6);
        }
        if (!addZy(new Zy(0.4, "万叶天赋二", false, false, "41", 0, 0))) {
            accumulateValue("41", 0.4);
        }
        if (!addZy(new Zy(0.40, "宗室+苍古", false, false, "6", 0, 0))) {
            accumulateValue("6", 0.40);
        }
        data.add(new Sh_data("雷九万班满愿力首刀", user_q()));

        return data;
    }

    @Override
    public double[] user_a(int a) {
        return new double[0];
    }

    @Override
    public double[] user_q() {
        if (mz >= 2) {
            if (!addZy(new Zy(0.6, "命座二", false, false, "10006", getTime(), 8))) {
                accumulateValue("10006", 0.6);
            }
        }
        double bl_1 = yl * getbl(q_level, 2, 0, 1), bl_2 = yl * getbl(q_level, 2, 3, 1);
        double[] d;
        double sh_ysh = (getGj(0) * (bl_1 + getbl(q_level, 2, 1, 0)) + getJc("30041","10024")) * getZs("41", "10003") * getFy() * getYsKx("41");

        d = getqw("10041", sh_ysh,2);
        return d;
    }

    @Override
    public double[] user_e() {
        if (!addZy(new Zy(getbl(e_level, 1, 1, 3) * ysbf, "E技能-元素爆发增伤", true, true, "10003", getTime(), 5))) {
            accumulateValue("10003", getbl(e_level, 1, 1, 3) * ysbf);
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
        }

    }

    @Override
    public void g1() {

    }

    @Override
    public void g2() {
        if (dj >= 70) {
           double cn= getYscn(0)*100;
            if (!addZy(new Zy((cn-100)*0.004, "固有天赋二", false, false, "41", 0, 0))) {
                accumulateValue("41", (cn-1)*0.004);
            }
        }
    }

    @Override
    public void g3() {

    }


}
