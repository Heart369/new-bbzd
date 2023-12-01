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

public class Sllh extends Obj_calculator {

    public Sllh(Jszsg.AvatarInfoListDTO jszsg, List<Bl_cl> bl_cls, CharacterData du, Context context) {
        super(jszsg, bl_cls, du, context);


    }

    @Override
    void cshsz() {
        a_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(0).toString());
        q_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(2).toString());
        e_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(1).toString());
        ys_key="46";
        ysbf=getbl(q_level,2,1,4);

    }

    @Override
    public List<Sh_data> csh() {
        myZy = new HashMap<>();
        zyList = new ArrayList<>();
        a_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(0).toString());
        q_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(2).toString());
        e_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(1).toString());
        user_mz(mz);
        wq_syw_csh(jszsg, context,"46");
        enemy = new Enemy(Enemy.ELEMENT_WATER, 1000);
        List<Sh_data> data = new ArrayList<>();
        g1();
        g2();
        g3();
        data.add(new Sh_data("E伤害", user_e()));
        data.add(new Sh_data("冲刺开E后重击", user_a(5)));
        data.add(new Sh_data("Q切割伤害", user_q()));
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
//        Log.d("攻击力",getGj(0)+"");
//        Log.d("倍率",  getbl(a_level, 0, 1, a)*3+"");
//        Log.d("增伤",getZs("46", "10015")+"");
//        Log.d("防御", getFy()+"");
//        Log.d("抗性",getYsKx(key)+"");
        if (a == 5)
            sh_ysh = (getGj(0) * getbl(a_level, 0, 1, a)+getJc("300"+key,"10025"))*3 * getZs(key, "10015") * getFy() * getYsKx(key) ;
        d = getqw("100"+key, sh_ysh, 0);
        return d;
    }

    @Override
    public double[] user_q() {
        double[] d;
            if (mz>=4)
            if (!addZy(new Zy(0.3, "命座-4", false, false, "10007", getTime(), 5))) {
                accumulateValue("10007", 0.3);
            }

        double sh_ysh = (getGj(0) * getbl(q_level, 2, 1, 0) +getJc("30046","10024"))* getZs("46", "10003") * getFy() * getYsKx("46");
        d = getqw("100046", sh_ysh, 2);
        return d;
    }

    @Override
    public double[] user_e() {
        double[] d;
        if (dj >= 40) {
            if (!addZy(new Zy(0.3, "E技能-固有天赋一_1", false, false, "10001", getTime(), 5))) {
                accumulateValue("10001", 0.3);
            }
            if (!addZy(new Zy(0.3, "E技能-固有天赋_2", false, false, "10015", getTime(), 5))) {
                accumulateValue("10015", 0.3);
            }
        }

        double sh_ysh = (getGj(0) * getbl(e_level, 1, 1, 0)+getJc("30046","10023")) * getZs("46", "10002") * getFy() * getYsKx("46");
        d = getqw("100046", sh_ysh, 1);
        return d;

    }


    @Override
    public void user_mz(int mz) {
        switch (mz) {
            case 6:
                if (!addZy(new Zy(2.98, "命座-6", false, false, "10015", getTime(), -10))) {
                    accumulateValue("10015", 2.98);
                }
            case 5:
                if (e_level < 11)
                    e_level += 3;
            case 4:
            case 3:
                if (q_level < 11)
                    q_level += 3;
        }
    }

    @Override
    public void g1() {
        tf[0] = false;
    }

    @Override
    public void g2() {
        tf[1] = false;
    }

    @Override
    public void g3() {
        if (dj >= 70)
            if (!addZy(new Zy(0.18, "冲刺-固有天赋二", false, false, "46", getTime(), 10))) {
                accumulateValue("46", 0.18);
            }

        fm = new Fm(5, 0, "46");
    }


}
