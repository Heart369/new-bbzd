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

public class Xiao extends Obj_calculator{
    public Xiao(Jszsg.AvatarInfoListDTO jszsg, List<Bl_cl> bl_cl, CharacterData du, Context context) {
        super(jszsg, bl_cl, du, context);
    }

    @Override
    void cshsz() {
        a_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(0).toString());
        q_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(2).toString());
        e_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(1).toString());
        ys_key = "44";
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
        wq_syw_csh(jszsg, context, "44");
        enemy = new Enemy(Enemy.ELEMENT_J, 1000);
        List<Sh_data> data = new ArrayList<>();
        g3();
        data.add(new Sh_data("首次E",user_e()));
        user_q();
        data.add(new Sh_data("开Q后首插",user_a(9)));
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
        if (a == 9)
            sh_ysh = (getGj(0) * getbl(a_level, 0, 3, a)+getJc("300"+key,"10025")) * getZs("44", "10004") * getFy() * getYsKx(key) ;
        d = getqw("100"+key, sh_ysh, 0);
        return d;
    }

    @Override
    public double[] user_q() {
        Fm fm=new Fm(15,0,"44");
        if (!addZy(new Zy(getbl(q_level,2,1,0), "Q增伤_1", false, false, "10015", getTime(), 0))) {
            accumulateValue("10015", getbl(q_level,2,1,0));
        }
        if (!addZy(new Zy(getbl(q_level,2,1,0), "Q增伤_2", false, false, "10004", getTime(), 0))) {
            accumulateValue("10004", getbl(q_level,2,1,0));
        }
        if (!addZy(new Zy(getbl(q_level,2,1,0), "Q增伤_3", false, false, "10001", getTime(), 0))) {
            accumulateValue("10001", getbl(q_level,2,1,0));
        }
        g1();
        return new double[0];
    }

    @Override
    public double[] user_e() {
        double[] d;
        double sh_ysh = 0;
        sh_ysh = (getGj(0) * getbl(e_level, 1, 1, 0)+getJc("30044","10023")) * getZs("44", "10002") * getFy() * getYsKx("44") ;
        d = getqw("10044", sh_ysh, 1);
        g2();
        return d;
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
        if (dj>=40)
        addZy(new Zy(0.15, "固有1", false, false, "10002", getTime(), 6));
        accumulateValue("10002", 0.15);

    }

    @Override
    public void g2() {
        if (!addZy(new Zy(0.05, "固有2", false, false, "10012", getTime(), 0))) {
            accumulateValue("10012", 0.05);
        }
    }

    @Override
    public void g3() {

    }
}
