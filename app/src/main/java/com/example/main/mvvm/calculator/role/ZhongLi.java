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

public class ZhongLi extends Obj_calculator{
    public ZhongLi(Jszsg.AvatarInfoListDTO jszsg, List<Bl_cl> bl_cl, CharacterData du, Context context) {
        super(jszsg, bl_cl, du, context);
    }

    @Override
    void cshsz() {
        a_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(0).toString());
        q_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(2).toString());
        e_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(1).toString());
        ys_key = "45";
        ysbf = getbl(q_level, 2, 1, 3);
    }
int e=0;
    @Override
    public List<Sh_data> csh() {
        myZy = new HashMap<>();
        zyList = new ArrayList<>();
        a_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(0).toString());
        q_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(2).toString());
        e_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(1).toString());
        user_mz(mz);
        wq_syw_csh(jszsg, context, "45");
        enemy = new Enemy(-1, 1000);
        List<Sh_data> data = new ArrayList<>();
        g1();
        g2();
        g3();
        data.add(new Sh_data("护盾吸收量",user_e()));
        data.add(new Sh_data("开E后Q伤害",user_q()));
        return data;
    }

    @Override
    public double[] user_a(int a) {
        return new double[0];
    }

    @Override
    public double[] user_q() {
        double[] d;
        double sh_ysh= (getGj(0) * getbl(q_level, 2, 1, 0) + getJc("30045","10024")) * getZs(ys_key, "10003") * getFy() * getYsKx(ys_key);
        d=getqw("10045",sh_ysh, 2);
        return d;
    }

    @Override
    public double[] user_e() {
        double[] d;
        double sh_ysh=0;
        if (!addZy(new Zy(0.2, "E减抗", false, false, "10032", getTime(), 0))) {
            accumulateValue("10032", 0.2);
        }
        if (e==0){
            return new double[]{(getbl(e_level,1,1,3)+getbl(e_level,1,1,4)*getSmz(1))*(1+myZy.get("81"))*1.5,0};
        }
        return new double[0];
    }

    @Override
    public void user_mz(int mz) {
        switch (mz){
            case 6:

            case 5:
                if (q_level < 11)
                    q_level += 3;
            case 4:

            case 3:
                if (e_level < 11)
                    e_level += 3;
            case 2:
                break;
            case 1:

        }
    }

    @Override
    public void g1() {
        if (dj>=40){
            if (!addZy(new Zy(0.25, "固有天赋1", false, false, "81", getTime(), 0))) {
                accumulateValue("81", 0.25);
            }
        }
    }

    @Override
    public void g2() {
        if (dj>=70){
            if (!addZy(new Zy(getSmz(1)*0.0139, "固有天赋2_1", false, false, "10022", getTime(), 0))) {
                accumulateValue("10022", getSmz(1)*0.0139);
            }
            if (!addZy(new Zy(getSmz(1)*0.0139, "固有天赋2_2", false, false, "10025", getTime(), 0))) {
                accumulateValue("10025", getSmz(1)*0.0139);
            }
            if (!addZy(new Zy(getSmz(1)*0.0139, "固有天赋2_3", false, false, "10026", getTime(), 0))) {
                accumulateValue("10026", getSmz(1)*0.0139);
            }
            if (!addZy(new Zy(getSmz(1)*0.019, "固有天赋2_4", false, false, "10023", getTime(), 0))) {
                accumulateValue("10023", getSmz(1)*0.019);
            }
            if (!addZy(new Zy(getSmz(1)*0.33, "固有天赋2_5", false, false, "10024", getTime(), 0))) {
                accumulateValue("10024", getSmz(1)*0.33);
            }
        }
    }

    @Override
    public void g3() {

    }
}
