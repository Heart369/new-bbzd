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

public class Mona extends Obj_calculator{
    public Mona(Jszsg.AvatarInfoListDTO jszsg, List<Bl_cl> bl_cl, CharacterData du, Context context) {
        super(jszsg, bl_cl, du, context);
    }
int fy=0;
    @Override
    void cshsz() {
        a_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(0).toString());
        q_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(2).toString());
        e_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(1).toString());
        ys_key = "42";
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
        wq_syw_csh(jszsg, context, "42");
        enemy = new Enemy(Enemy.ELEMENT_FIRE, 1000);
        List<Sh_data> data = new ArrayList<>();
        g2();
        data.add(new Sh_data("Q伤害",user_q()));
        fy=1;
        data.add(new Sh_data("Q蒸发伤害",user_q()));
        return data;
    }

    @Override
    public double[] user_a(int a) {
        return new double[0];
    }

    @Override
    public double[] user_q() {
        if (!addZy(new Zy(getbl(q_level, 2, 1, 2), "Q增伤", false, false, "10012", 0, 0))) {
            accumulateValue("10012", getbl(q_level, 2, 1, 2));
        }
        double[] d;
        double sh_ysh = (getGj(0) * getbl(q_level, 2, 1, 1) + getJc("30042", "10024")) * getZs("42", "10003") * getFy() * getYsKx("42");
        if (fy==1)
        sh_ysh = getZf(sh_ysh, 1);
        d = getqw("100042", sh_ysh, 2);
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
                if (!addZy(new Zy(0.15, "命座4", false, false, "20", getTime(), 10))) {
                    accumulateValue("20", 0.15);
                }
            case 3:
                if (q_level < 11)
                    q_level += 3;
            case 2:

                break;
            case 1:
                if (!addZy(new Zy(0.15, "命座1", false, false, "10031", getTime(), 10))) {
                    accumulateValue("10031", 0.15);
                }

        }
    }

    @Override
    public void g1() {

    }

    @Override
    public void g2() {
    if (dj>=70
    ){
        if (!addZy(new Zy(getYscn(1)*0.2, "固有天赋2", false, false, "42", 0, 0))) {
            accumulateValue("42", getYscn(1)*0.2);
        }
    }
    }

    @Override
    public void g3() {

    }
}
