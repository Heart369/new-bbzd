package com.example.main.mvvm.calculator.role;

import android.content.Context;
import android.util.Log;

import com.example.main.mvvm.calculator.tool.Enemy;
import com.example.main.mvvm.calculator.tool.Sh_data;
import com.example.main.mvvm.json.CharacterData;
import com.example.main.raw.Class_Custom.Bl_cl;
import com.example.main.raw.JsonPares.Jszsg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Fischl extends Obj_calculator {
    public Fischl(Jszsg.AvatarInfoListDTO jszsg, List<Bl_cl> bl_cl, CharacterData du, Context context) {
        super(jszsg, bl_cl, du, context);
    }
    int flag_jh=0;
    @Override
    void cshsz() {
        a_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(0).toString());
        q_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(2).toString());
        e_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(1).toString());
        ysbf = getbl(q_level, 2, 1, 2);
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
        flag_jh=0;
        data.add(new Sh_data("奥兹每段伤害",user_e()));
        flag_jh=1;
        data.add(new Sh_data("奥兹每段激化",user_e()));
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

        if (flag_jh !=0)
            getYsfy(Enemy.ELEMENT_L);
        double sh_ysh = (getGj(0) * ( getbl(e_level, 1, 1, 0)) + getJc("30041","10023")) * getZs("41", "10002") * getFy() * getYsKx("41");
        d = getqw("10041", sh_ysh,2);
        return d;
    }

    @Override
    public void user_mz(int mz) {
        switch (mz) {

            case 6:
            case 5:
                if (q_level < 11)
                    q_level += 3;
            case 4:
            case 3:
                if (e_level < 11)
                    e_level += 3;
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
