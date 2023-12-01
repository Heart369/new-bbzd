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

public class Ganyu  extends  Obj_calculator{
    public Ganyu(Jszsg.AvatarInfoListDTO jszsg, List<Bl_cl> bl_cl, CharacterData du, Context context) {
        super(jszsg, bl_cl, du, context);
    }

    @Override
    void cshsz() {
        a_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(0).toString());
        q_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(2).toString());
        e_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(1).toString());
        ys_key="46";
        ysbf = getbl(q_level, 2, 1, 3);
    }
    int fy=0;
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
        List<Sh_data> data = new ArrayList<>();
        g1();
        data.add(new Sh_data("霜华矢伤害",user_a(7)));
        fy=1;
        if (myZy.get("20")!=null){
            accumulateValue("20",-0.4);
        }
        data.add(new Sh_data("霜华矢融化伤害",user_a(7)));
        if (!addZy(new Zy(1816, "融甘buff", false, false, "5", 0, 0))) {
            accumulateValue("5", 1816.0);
        }
        if (!addZy(new Zy(0.2, "融甘buff2", false, false, "20046", 0, 0))) {
            accumulateValue("20046", 0.2);
        }
        data.add(new Sh_data("融甘霜华矢伤害",user_a(7)));
        return data;
    }

    @Override
    public double[] user_a(int a) {
        double[] d;
        double sh_ysh = 0;
        String key="46";
        if (a==7){
            sh_ysh = (getGj(0) * (getbl(a_level, 0, 0, a+1)+getbl(a_level, 0, 0, a+2)) + getJc("300" + key,"10025")) * getZs(key, "10015") * getFy() * getYsKx(key);
        }
        if (fy!=0){
            sh_ysh = getZf(sh_ysh, 0);
        }
        d = getqw("100" + key, sh_ysh, 0);
        return d;
    }

    @Override
    public double[] user_q() {
        return new double[0];
    }

    @Override
    public double[] user_e() {
        return new double[0];
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

            case 3:
                if (q_level < 11)
                    q_level += 3;
            case 2:

            case 1:
                if (!addZy(new Zy(0.15, "1命", true, false, "20046", 0, 0)))
                    accumulateValue("20046", 0.15);
        }
    }

    @Override
    public void g1() {
        if (!addZy(new Zy(0.2, "固有天赋1", false, false, "20", 0, 0))) {
            accumulateValue("20", 0.2);
        }
    }

    @Override
    public void g2() {

    }

    @Override
    public void g3() {

    }
}
