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

public class Yanfei extends Obj_calculator{
    public Yanfei(Jszsg.AvatarInfoListDTO jszsg, List<Bl_cl> bl_cl, CharacterData du, Context context) {
        super(jszsg, bl_cl, du, context);
    }
int dhy=4,fy=0;
    @Override
    void cshsz() {
        a_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(0).toString());
        q_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(2).toString());
        e_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(1).toString());
        ys_key = "40";
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
        dhy=4;
        user_q();
        fy=0;
        data.add(new Sh_data("开q"+dhy+"层火印重击",user_a(0)));
        fy=1;
        data.add(new Sh_data("开q"+dhy+"层火印重击蒸发",user_a(0)));
        return data;
    }

    @Override
    public double[] user_a(int a) {
        double[] d;
        double sh_ysh = (getGj(0) * (getbl(a_level, 0, 1, 3)+getbl(a_level,0,3,3)*0.1*dhy) * getZs("40", "10015") + getJc("30040", "10021")) * getFy() * getYsKx("40");
        if (fy==1)
            sh_ysh=getZf(sh_ysh,0);
        d = getqw("100040", sh_ysh, 1);
        return d;
    }

    @Override
    public double[] user_q() {
        if (!addZy(new Zy(getbl(q_level,2,1,2), "Q重击伤害加成", false, false, "10015", 0, 0))) {
            accumulateValue("10015", getbl(q_level,2,1,2));
        }
        return new double[0];
    }

    @Override
    public double[] user_e() {
        return new double[0];
    }

    @Override
    public void user_mz(int mz) {
        switch (mz) {
            case 6:
        dhy=5;
            case 5:
                if (q_level < 11)
                    q_level += 3;

            case 4:

            case 3:
                if (e_level < 11)
                    e_level += 3;
            case 2:

            case 1:

        }
    }

    @Override
    public void g1() {
        if (dj>=40)
            if (!addZy(new Zy(0.2, "固有1", false, false, "40", 0, 0))) {
                accumulateValue("40", 0.2);
            }
    }

    @Override
    public void g2() {

    }

    @Override
    public void g3() {

    }
}
