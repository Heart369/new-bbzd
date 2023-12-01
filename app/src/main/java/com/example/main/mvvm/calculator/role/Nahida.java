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

public class Nahida extends Obj_calculator {

    public Nahida(Jszsg.AvatarInfoListDTO jszsg, List<Bl_cl> bl_cl, CharacterData du, Context context) {
        super(jszsg, bl_cl, du, context);
    }

    @Override
    void cshsz() {
        a_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(0).toString());
        q_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(2).toString());
        e_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(1).toString());
        ys_key = "43";
        ysbf = getbl(q_level, 2, 1, 8);
    }

    @Override
    public List<Sh_data> csh() {
        myZy = new HashMap<>();
        zyList = new ArrayList<>();
        a_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(0).toString());
        q_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(2).toString());
        e_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(1).toString());
        user_mz(mz);
        wq_syw_csh(jszsg, context, "43");
        enemy = new Enemy(Enemy.ELEMENT_J, 1000);
        List<Sh_data> data = new ArrayList<>();
        g2();
        g3();
        data.add(new Sh_data("E伤害激化", user_e()));
        user_q();
        data.add(new Sh_data("开Q站场E激化", user_e()));
        return data;
    }

    @Override
    public double[] user_a(int a) {


        return new double[0];
    }

    @Override
    public double[] user_q() {
        g1();
        g2();

        if (!addZy(new Zy(getbl(q_level,2,1,1), "元素爆发", false, false, "10013", getTime(), 10))) {
            accumulateValue("10013",getbl(q_level,2,1,1));
        }
        return new double[]{0, 0};
    }

    @Override
    public double[] user_e() {
        getYsfy(Enemy.ELEMENT_C);
        double[] d;
        Log.d("TAGbl", getbl(e_level, 1, 1, 2) + "" + getbl(e_level, 1, 3, 2));
        tszs="10013";
        double sh_ysh = (getGj(0) * getbl(e_level, 1, 1, 2) + getJc("30046","10023") + getYsjt(0) * getbl(e_level, 1, 3, 2)) * getZs("43", "10002") * getFy() * getYsKx("43");
        d = getqw("10043", sh_ysh, 1);
        tszs=null;
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
                if (!addZy(new Zy(160, "命座4", false, false, "28", getTime(), 10))) {
                    accumulateValue("28", 160.0);
                }
            case 3:
                if (e_level < 11)
                    e_level += 3;
            case 2:
                if (!addZy(new Zy(0.3, "命座2", false, false, "10007", getTime(), 10))) {
                    accumulateValue("10007", 0.3);
                }
                break;
            case 1:

        }
    }

    @Override
    public void g1() {
        double ysjt = getYsjt(1)*0.25;
        if (ysjt>250)
            ysjt=250;
        if (!addZy(new Zy(ysjt, "固有天赋一", false, false, "28", getTime(), 10))) {
            accumulateValue("28", ysjt);
        }
    }

    @Override
    public void g2() {
        if (dj >= 70) {
            double ysjt = getYsjt(1) - 200;
            double tf1=ysjt * 0.0003;
            if (tf1>0.24)
                tf1=0.24;
            if (!addZy(new Zy(tf1, "固有天赋二_1", false, false, "20", getTime(), 10))) {
                accumulateValue("20", tf1);
            }
            double tf2=ysjt * 0.001;
            if (tf2>0.8)
                tf2=0.8;
            if (!addZy(new Zy(tf2, "固有天赋二_2", false, false, "10013", getTime(), 10))) {
                accumulateValue("10013", tf2);
            }
        }

    }

    @Override
    public void g3() {

    }
}
