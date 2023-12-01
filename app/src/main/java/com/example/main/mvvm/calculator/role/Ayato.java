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

public class Ayato extends Obj_calculator{
    int ls=4;
    public Ayato(Jszsg.AvatarInfoListDTO jszsg, List<Bl_cl> bl_cl, CharacterData du, Context context) {
        super(jszsg, bl_cl, du, context);
    }

    @Override
    void cshsz() {
        a_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(0).toString());
        q_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(2).toString());
        e_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(1).toString());
        ys_key = "42";
        ysbf = getbl(q_level, 2, 1, 4);
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
        g1();
        g2();
        g3();
        data.add(new Sh_data("满浪闪3刀",user_e()));
        data.add(new Sh_data("Q单段",user_q()));
        return data;
    }

    @Override
    public double[] user_a(int a) {

        return new double[0];
    }

    @Override
    public double[] user_q() {
        if (!addZy(new Zy(getbl(q_level,2,1,1), "普通攻击增伤", false, false, "10001", 0, 0))) {
            accumulateValue("10001", getbl(q_level,2,1,1));
        }
        double[] d;
        double sh_ysh = (getGj(0) * getbl(q_level, 2, 1, 0) + getJc("30042", "10024")) * getZs("42", "10003") * getFy() * getYsKx("42");
        d = getqw("100042", sh_ysh, 2);
        Log.d("YAG",getZs("42", "10003")+"" );
        return d;
    }

    @Override
    public double[] user_e() {
        if (!addZy(new Zy(getbl(e_level,1,1,4)*getSmz(1)*ls, "4浪闪伤害提高", false, false, "10050", 0, 0))) {
            accumulateValue("10050", getbl(e_level,1,1,4)*getSmz(1)*ls);
        }
        double[] d;
        double sh_ysh=0;
        sh_ysh = (getGj(0) * getbl(e_level, 1, 1, 0) + getJc("30043","10022") +myZy.get("10050")) * getZs("42", "10001") * getFy() * getYsKx("42");
        sh_ysh += (getGj(0) * getbl(e_level, 1, 1, 1) + getJc("30043","10022") +myZy.get("10050")) * getZs("42", "10001") * getFy() * getYsKx("42");
        sh_ysh += (getGj(0) * getbl(e_level, 1, 1, 2) + getJc("30043","10022") +myZy.get("10050")) * getZs("42", "10001") * getFy() * getYsKx("42");
        d = getqw("10043", sh_ysh, 1);
        return d;
    }

    @Override
    public void user_mz(int mz) {

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
