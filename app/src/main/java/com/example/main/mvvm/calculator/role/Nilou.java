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

public class Nilou extends Obj_calculator {
    public Nilou(Jszsg.AvatarInfoListDTO jszsg, List<Bl_cl> bl_cl, CharacterData du, Context context) {
        super(jszsg, bl_cl, du, context);
    }

    double a = 1,fr=0;

    @Override
    void cshsz() {
        a_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(0).toString());
        q_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(2).toString());
        e_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(1).toString());
        ys_key = "42";
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
        wq_syw_csh(jszsg, context, "42");
        enemy = new Enemy(Enemy.ELEMENT_FIRE, 1000);
        List<Sh_data> data = new ArrayList<>();
        data.add(new Sh_data("Q两段", user_q()));
        data.add(new Sh_data("E三段", user_e()));

        if (!addZy(new Zy(0.25, "双水", false, false, "3", 0, 0))) {
            accumulateValue("3", 0.25);
        }
        if (!addZy(new Zy(180, "双草+被动", false, false, "28", 0, 0))) {
            accumulateValue("28", 180.0);
        }
        g2();
        data.add(new Sh_data("丰壤之核", new double[]{2892*(1+16*getYsjt(0)/(getYsjt(0)+2000)+fr)*0.9,0}));
        return data;
    }

    @Override
    public double[] user_a(int a) {
        return new double[0];
    }

    @Override
    public double[] user_q() {
        double[] d;
        double sh_ysh = (getSmz(0) * getbl(q_level, 2, 1, 0) + getSmz(0) * getbl(q_level, 2, 1, 1) + getJc("30042", "10024")) * getZs("42", "10003") * getFy() * getYsKx("42");
        d = getqw("100042", sh_ysh, 2);
        return d;
    }

    @Override
    public double[] user_e() {
        double[] d;
        double sh_ysh = ((getGj(0) * getbl(e_level, 1, 1, 3) + getSmz(0) * getbl(e_level, 1, 3, 3) * a) + getSmz(0) * getbl(e_level, 1, 3, 1) + getGj(0) * getbl(e_level, 1, 1, 1) + getSmz(0) * getbl(e_level, 1, 3, 2) + getGj(0) * getbl(e_level, 1, 1, 2) + getJc("30042", "10024")) * getZs("42", "10002") * getFy() * getYsKx("42");
        d = getqw("100042", sh_ysh, 1);
        return d;
    }

    @Override
    public void user_mz(int mz) {
        switch (mz) {

            case 6:
                double bjl=getSmz(1)/1000*0.006;
                double bj=getSmz(1)/1000*0.012;
                if (bjl>0.3)
                    bjl=0.3;
                if (bj>0.6)
                    bj=0.6;
                if (!addZy(new Zy(bjl, "命座6_1", false, false, "20", 0, 0))) {
                    accumulateValue("20", bjl);
                }
                if (!addZy(new Zy(bj, "命座6_2", false, false, "22", 0, 0))) {
                    accumulateValue("22", bj);
                }
            case 5:
                if (e_level < 11)
                    e_level += 3;
            case 4:
                if (!addZy(new Zy(0.5, "命座4", false, false, "10003", 0, 0))) {
                    accumulateValue("10003", 0.5);
                }
            case 3:
                if (q_level < 11)
                    q_level += 3;
            case 2:
                if (!addZy(new Zy(0.35, "命座2", false, false, "52", 0, 0))) {
                    accumulateValue("52", 0.35);
                }
                if (!addZy(new Zy(0.35, "命座1", false, false, "53", 0, 0))) {
                    accumulateValue("53", 0.35);
                }
            case 1:
                a = 1.65;
        }
    }

    @Override
    public void g1() {

    }

    @Override
    public void g2() {
        if (dj>=70)
            fr=((getSmz(0)-30000)/1000*0.09);
        if (fr>4)
            fr=4;
        Log.d("TAGCSCS",fr+"");
    }

    @Override
    public void g3() {

    }
}
