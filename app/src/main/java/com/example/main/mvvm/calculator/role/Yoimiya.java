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

public class Yoimiya extends Obj_calculator {
    public Yoimiya(Jszsg.AvatarInfoListDTO jszsg, List<Bl_cl> bl_cl, CharacterData du, Context context) {
        super(jszsg, bl_cl, du, context);
    }

    @Override
    protected void cshsz() {
        a_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(0).toString());
        q_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(2).toString());
        e_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(1).toString());
        ys_key="40";
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
        wq_syw_csh(jszsg, context, "40");
        enemy = new Enemy(Enemy.ELEMENT_WATER, 1000);
        List<Sh_data> data = new ArrayList<>();
        g1();
        g2();
        g3();
        user_e();
        data.add(new Sh_data("平A一轮伤害",user_a(-1)));
        data.add(new Sh_data("平A一轮蒸发",user_a(-2)));
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
        if (a==-1){
            sh_ysh = (getGj(0) *
                    (getbl(a_level, 0, 1, 0)+getbl(a_level, 0, 1, 1)+getbl(a_level, 0, 1, 2)+getbl(a_level, 0, 1, 3)+getbl(a_level, 0, 1, 4)+getbl(a_level, 0, 1, 0)+getbl(a_level, 0, 1, 3))*myZy.get("10050") + getJc("30040", "10024"))
                    * getZs(key, "10001") * getFy() * getYsKx(key);
        }else if (a==-2){
            sh_ysh = (getGj(0) *
                    (getbl(a_level, 0, 1, 0))*myZy.get("10050") + getJc("30040", "10024"))
                    * getZs(key, "10001") * getFy() * getYsKx(key);
            sh_ysh=getZf(sh_ysh,0);
            sh_ysh+=(getGj(0) *
                    (getbl(a_level, 0, 1, 0))*myZy.get("10050") + getJc("30040", "10024"))
                    * getZs(key, "10001") * getFy() * getYsKx(key);
            sh_ysh+=(getGj(0) *
                    (getbl(a_level, 0, 1, 1))*myZy.get("10050") + getJc("30040", "10024"))
                    * getZs(key, "10001") * getFy() * getYsKx(key);
            double ls=(getGj(0) *
                    (getbl(a_level, 0, 1, 2))*myZy.get("10050") + getJc("30040", "10024"))
                    * getZs(key, "10001") * getFy() * getYsKx(key);
            sh_ysh+=getZf(ls,0);
            sh_ysh+=(getGj(0) *
                    (getbl(a_level, 0, 1, 3))*myZy.get("10050") + getJc("30040", "10024"))
                    * getZs(key, "10001") * getFy() * getYsKx(key)*2;
             ls=(getGj(0) *
                    (getbl(a_level, 0, 1, 4))*myZy.get("10050") + getJc("30040", "10024"))
                    * getZs(key, "10001") * getFy() * getYsKx(key);
            sh_ysh+=getZf(ls,0);
        }
        d = getqw("1000"+key, sh_ysh, 0);
        return d;
    }

    @Override
    public double[] user_q() {
        return new double[0];
    }

    @Override
    public double[] user_e() {
        fm = new Fm(9, 0, "40");
        myZy.put("10050",getbl(e_level,1,1,0));
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
                if (!addZy(new Zy(0.25, "2命", true, false, "22", 0, 0)))
                    accumulateValue("22", 0.25);
            case 1:

        }
    }

    @Override
    public void g1() {
        if (dj>=40){
            if (!addZy(new Zy(0.2, "固有天赋1", false, false, "40", 0, 0))) {
                accumulateValue("40", 0.2);
            }
        }
    }

    @Override
    public void g2() {

    }

    @Override
    public void g3() {

    }
}
