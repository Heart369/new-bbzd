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

public class Ht extends Obj_calculator {
    public Ht(Jszsg.AvatarInfoListDTO jszsg, List<Bl_cl> bl_cl, CharacterData du, Context context) {
        super(jszsg, bl_cl, du, context);
    }

    @Override
    void cshsz() {
        a_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(0).toString());
        q_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(2).toString());
        e_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(1).toString());
        ys_key="40";
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
        wq_syw_csh(jszsg, context, "40");
        enemy = new Enemy(Enemy.ELEMENT_WATER, 1000);
        List<Sh_data> data = new ArrayList<>();
        g1();
        g2();
        g3();
        data.add(new Sh_data("血梅香伤害", user_e()));
        data.add(new Sh_data("重击蒸发伤害", user_a(6)));
        data.add(new Sh_data("Q蒸发伤害", user_q()));

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
        if (a == 6)
            sh_ysh = (getGj(0) * getbl(a_level, 0, 0, a) + getJc("30030","10025")) * getZs(key, "10015") * getFy() * getYsKx(key);
        sh_ysh = getZf(sh_ysh, 0);
        d = getqw("100" + key, sh_ysh, 0);
        return d;
    }

    @Override
    public double[] user_q() {
        double[] d;
        double sh_ysh = (getGj(0) * getbl(q_level, 2, 1, 1) + getJc("30040","10024")) * getZs("40", "10003") * getFy() * getYsKx("40");
        sh_ysh = getZf(sh_ysh, 0);
        d = getqw("100040", sh_ysh, 2);
        return d;
    }

    @Override
    public double[] user_e() {
        double[] d;
        if (!addZy(new Zy(getSmz(1) * 0.066, "胡桃e攻击力", false, false, "5", 0, 0))) {
            accumulateValue("5", getSmz(1) * getbl(e_level, 1, 1, 1));
        }

        double sh_ysh = (getGj(0) * getbl(e_level, 1, 1, 2)  + getJc("30040","10023"))* getZs("40", "10002") * getFy() * getYsKx("40");
        d = getqw("100040", sh_ysh, 1);
        fm = new Fm(9, 0, "40");
        return d;
    }

    @Override
    public void user_mz(int mz) {
        switch (mz){
            case 6:
                if (!addZy(new Zy(1, "6命", true, false, "20", getTime(), 10)))
                    accumulateValue("20", getSmz(0)*0.1);
            case 5:
                if (e_level < 11)
                    e_level += 3;
            case 4:
                //        if (!addZy(new Zy(0.33, "固有天赋一", true, false, "40", 0, 0))) {
//            accumulateValue("40", 0.33);
            case 3:
                if (q_level < 11)
                    q_level += 3;
            case 2:
                if (!addZy(new Zy((getSmz(0)*0.01)/100, "2命", true, false, "10002", 0, 0)))
                    accumulateValue("10002", (getSmz(0)*0.01)/100);
            case 1:

        }

    }

    @Override
    public void g1() {
//        if (!addZy(new Zy(0.33, "固有天赋一", true, false, "40", 0, 0))) {
//            accumulateValue("40", 0.33);
//        }
    }

    @Override
    public void g2() {
        if (!addZy(new Zy(0.33, "固有天赋二", false, false, "40", 0, 0))) {
            accumulateValue("40", 0.33);
        }
    }

    @Override
    public void g3() {

    }
}
