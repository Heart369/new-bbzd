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

public class XinQiu extends Obj_calculator {
    public XinQiu(Jszsg.AvatarInfoListDTO jszsg, List<Bl_cl> bl_cl, CharacterData du, Context context) {
        super(jszsg, bl_cl, du, context);
    }
double mz_4=1;
    int flag=0;
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
        data.add(new Sh_data("Q-A后E两段伤害",user_e()));
        flag=0;
        data.add(new Sh_data("Q单段",user_q()));
        flag=1;
        data.add(new Sh_data("Q单段蒸发",user_q()));
        g2();
        return data;
    }

    @Override
    public double[] user_a(int a) {
        return new double[0];
    }

    @Override
    public double[] user_q() {
        double[] d;
        double sh_ysh = (getGj(0) * getbl(q_level, 2, 1, 0) + getJc("30042", "10024")) * getZs("42", "10003") * getFy() * getYsKx("42");
        if (flag==1)
        sh_ysh = getZf(sh_ysh, 1);
        d = getqw("100042", sh_ysh, 2);
        return d;
    }

    @Override
    public double[] user_e() {
        double[] d;
        double sh_ysh = (getGj(0) * (getbl(e_level, 1, 1, 0) +getbl(e_level,1,3,0))+ getJc("30042", "10023")) * getZs("42", "10002") * getFy() * getYsKx("42")*mz_4;
        d = getqw("100042", sh_ysh, 2);
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
                mz_4=1.5;
            case 3:
                if (q_level < 11)
                    q_level += 3;
            case 2:
                if (!addZy(new Zy(0.15, "命座2", false, false, "20042", 0, 0))) {
                    accumulateValue("20042", 0.15);
                }
        }
    }

    @Override
    public void g1() {

    }

    @Override
    public void g2() {
        if (dj >= 70)
            if (!addZy(new Zy(0.2, "天赋", false, false, "42", 0, 0))) {
                accumulateValue("42", 0.2);
            }
    }

    @Override
    public void g3() {

    }
}
