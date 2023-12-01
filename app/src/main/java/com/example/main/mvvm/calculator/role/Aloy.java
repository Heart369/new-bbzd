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

public class Aloy extends Obj_calculator{
    public Aloy(Jszsg.AvatarInfoListDTO jszsg, List<Bl_cl> bl_cl, CharacterData du, Context context) {
        super(jszsg, bl_cl, du, context);
    }

    @Override
    void cshsz() {
        a_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(0).toString());
        q_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(2).toString());
        e_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(1).toString());
        ys_key="46";
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
        wq_syw_csh(jszsg, context, "46");
        enemy = new Enemy(Enemy.ELEMENT_WATER, 1000);
        g1();
        g2();
        g3();
        List<Sh_data> data = new ArrayList<>();
        data.add(new Sh_data("满被动Q伤害",user_q()));
        return data;
    }

    @Override
    public double[] user_a(int a) {
        return new double[0];
    }

    @Override
    public double[] user_q() {
        double[] d;
        double sh_ysh = (getGj(0) * getbl(q_level, 2, 1, 0)+ getJc("30030","10024")) * getZs("46", "10003") * getFy() * getYsKx("46");
        d = getqw("100030", sh_ysh, 2);
        return d;
    }

    @Override
    public double[] user_e() {

        return new double[0];
    }

    @Override
    public void user_mz(int mz) {

    }

    @Override
    public void g1() {
        if (dj>=40){
            if (!addZy(new Zy(0.15, "固有天赋1", false, false, "6", 0, 0))) {
                accumulateValue("6", 0.15);
            }
        }
    }

    @Override
    public void g2() {
    if (dj>=70){
        if (!addZy(new Zy(0.35, "固有天赋2", false, false, "46", 0, 0))) {
            accumulateValue("46", 0.35);
        }
    }
    }

    @Override
    public void g3() {

    }
}
