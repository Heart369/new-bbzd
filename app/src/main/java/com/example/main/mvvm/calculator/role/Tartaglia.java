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

public class Tartaglia extends Obj_calculator {

    public Tartaglia(Jszsg.AvatarInfoListDTO jszsg, List<Bl_cl> bl_cl, CharacterData du, Context context) {
        super(jszsg, bl_cl, du, context);
    }

    @Override
    void cshsz() {
        a_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(0).toString());
        q_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(2).toString());
        e_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(1).toString());
        ys_key = "42";
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
        wq_syw_csh(jszsg, context, "42");
        enemy = new Enemy(Enemy.ELEMENT_FIRE, 1000);
        List<Sh_data> data = new ArrayList<>();
        g1();
        g2();
        g3();
        data.add(new Sh_data("近战Q蒸发", user_q()));
        if (!addZy(new Zy(0.4, "万叶天赋二", false, false, "42", 0, 0))) {
            accumulateValue("42", 0.4);
        }
        if (!addZy(new Zy(0.4, "风套", false, false, "20042", 0, 0))) {
            accumulateValue("20042", 0.4);
        }
        if (!addZy(new Zy(1202, "班尼特攻击力", false, false, "5", 0, 0))) {
            accumulateValue("5", 1202.0);
        }
        if (!addZy(new Zy(0.65, "宗室+双火+苍古", false, false, "6", 0, 0))) {
            accumulateValue("6", 0.65);
        }
        data.add(new Sh_data("万达近战Q蒸发", user_q()));
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
        sh_ysh = getZf(sh_ysh, 1);
        d = getqw("100042", sh_ysh, 2);
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
