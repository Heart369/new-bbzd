package com.example.main.mvvm.calculator.role;

import android.content.Context;

import com.example.main.mvvm.calculator.tool.Enemy;
import com.example.main.mvvm.calculator.tool.Sh_data;
import com.example.main.mvvm.json.CharacterData;
import com.example.main.raw.Class_Custom.Bl_cl;
import com.example.main.raw.JsonPares.Jszsg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Kaeya extends Obj_calculator{
    public Kaeya(Jszsg.AvatarInfoListDTO jszsg, List<Bl_cl> bl_cl, CharacterData du, Context context) {
        super(jszsg, bl_cl, du, context);
    }

    @Override
    void cshsz() {
        a_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(0).toString());
        q_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(2).toString());
        e_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(1).toString());
        ys_key = "46";
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
        wq_syw_csh(jszsg, context, "46");
        enemy = new Enemy(Enemy.ELEMENT_WATER, 1000);
        List<Sh_data> data = new ArrayList<>();
        data.add(new Sh_data("E伤害", user_e()));
        return data;
    }

    @Override
    public double[] user_a(int a) {
        return new double[0];
    }

    @Override
    public double[] user_q() {
        return new double[0];
    }

    @Override
    public double[] user_e() {
        double[] d;
        double sh_ysh = (getGj(0) * ((getbl(e_level, 1, 1, 0)))+ getJc("30030","10023")) * getZs("46", "10002") * getFy() * getYsKx("46");
        d = getqw("100046", sh_ysh, 2);
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

            case 3:
                if (e_level < 11)
                    e_level += 3;
            case 2:

            case 1:

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
