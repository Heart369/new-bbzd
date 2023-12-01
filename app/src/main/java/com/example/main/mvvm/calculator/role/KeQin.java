package com.example.main.mvvm.calculator.role;

import android.content.Context;

import com.example.main.mvvm.calculator.tool.Enemy;
import com.example.main.mvvm.calculator.tool.Fm;
import com.example.main.mvvm.calculator.tool.Sh_data;
import com.example.main.mvvm.calculator.tool.Zy;
import com.example.main.mvvm.json.CharacterData;
import com.example.main.raw.Class_Custom.Bl_cl;
import com.example.main.raw.JsonPares.Jszsg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class KeQin extends Obj_calculator {
    public KeQin(Jszsg.AvatarInfoListDTO jszsg, List<Bl_cl> bl_cl, CharacterData du, Context context) {
        super(jszsg, bl_cl, du, context);
    }
    int jh=0;
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
        enemy = new Enemy(Enemy.ELEMENT_J, 1000);
        List<Sh_data> data = new ArrayList<>();
        g1();
        g2();
        data.add(new Sh_data("附魔重击",user_a(5)));
        jh=0;
        data.add(new Sh_data("Q伤害",user_q()));
        jh=1;
        data.add(new Sh_data("Q超激化",user_q()));

        return data;
    }

    @Override
    public double[] user_a(int a) {
        double[] d;
        double sh_ysh = 0;
        String key = "29";
        if (fm != null) {
            key = fm.getKey();
        }
        if (a == 5)
            sh_ysh = (getGj(0) * getbl(a_level, 0, 2, a)+getJc("300"+key,"10025")) * getZs(key, "10015") * getFy() * getYsKx(key) ;
        d = getqw("100"+key, sh_ysh, 0);
        return d;
    }

    @Override
    public double[] user_q() {

        double[] d;
        double sh_ysh =0;
        if (jh==1){
            getYsfy(Enemy.ELEMENT_L);
            sh_ysh=(getGj(0) * getbl(q_level, 2,1 , 0)+getJc("30041","10025")) * getZs("41", "10003") * getFy() * getYsKx("41") ;
            sh_ysh+=(getGj(0) * getbl(q_level, 2,1 , 1)+getJc("30041","10025")) * getZs("41", "10003") * getFy() * getYsKx("41")*6 ;
            getYsfy(Enemy.ELEMENT_L);
            sh_ysh+=(getGj(0) * getbl(q_level, 2,1 , 1)+getJc("30041","10025")) * getZs("41", "110003") * getFy() * getYsKx("41") ;
            getYsfy(Enemy.ELEMENT_L);
            sh_ysh+=(getGj(0) * getbl(q_level, 2,1 , 1)+getJc("30041","10025")) * getZs("41", "10003") * getFy() * getYsKx("41") ;
            getYsfy(Enemy.ELEMENT_L);
            sh_ysh+=(getGj(0) * getbl(q_level, 2,1 , 2)+getJc("30041","10025")) * getZs("41", "10003") * getFy() * getYsKx("41") ;
        }else {
            sh_ysh=(getGj(0) * getbl(q_level, 2,1 , 0)+getJc("30041","10025")) * getZs("41", "10003") * getFy() * getYsKx("41") ;
            sh_ysh+=(getGj(0) * getbl(q_level, 2,1 , 1)+getJc("30041","10025")) * getZs("41", "10003") * getFy() * getYsKx("41")*8 ;
            sh_ysh+=(getGj(0) * getbl(q_level, 2,1 , 2)+getJc("30041","10025")) * getZs("41", "10003") * getFy() * getYsKx("41") ;
        }
        d=getqw("10041",sh_ysh, 2);
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
                if (!addZy(new Zy(0.06*4, "命座6", false, false, "41", getTime(), 10))) {
                    accumulateValue("41", 0.06*4);
                }
            case 5:
                if (e_level < 11)
                    e_level += 3;
            case 4:
                if (!addZy(new Zy(0.25, "命座4", false, false, "6", getTime(), 10))) {
                    accumulateValue("6", 0.25);
                }
            case 3:
                if (q_level < 11)
                    q_level += 3;
            case 2:

                break;
            case 1:

        }

    }

    @Override
    public void g1() {
        if (dj >= 40) {
            fm = new Fm(5, 0, "41");
        }
    }

    @Override
    public void g2() {
        if (dj >= 70) {
            if (!addZy(new Zy(0.15, "固有天赋二", false, false, "20", getTime(), 10))) {
                accumulateValue("20", 0.15);
            }
        }
    }

    @Override
    public void g3() {

    }
}
