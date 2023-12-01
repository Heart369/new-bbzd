package com.example.main.mvvm.calculator.tool;

import android.util.Log;

import com.example.main.mvvm.calculator.role.Obj_calculator;

public class Syw_Class {
    Obj_calculator obj_calculator;
    int j;

    public Syw_Class(Obj_calculator obj_calculator, int j) {
        this.obj_calculator = obj_calculator;
        this.j = j;
    }

    public void setJ(int j) {
        this.j = j;
    }

    public int getJ() {
        return j;
    }

    public void 冰风迷途的勇士(int i) {
        if (j == 0 && i > 1){
            obj_calculator.getJszsg_fb().getFightPropMap().put("46",obj_calculator.getJszsg_fb().getFightPropMap().get("46")-0.15);
        }
        if (!obj_calculator.addZy(new Zy(0.15, "冰风迷途的勇士2件套", false, false, "46", 0, 0)))
            accumulateValue("46",0.15);
        if (j == 1 && i == 4) {
            if (!obj_calculator.addZy(new Zy(0.4, "冰风迷途的勇士4件套", false, false, "20", 0, 0))) {
                accumulateValue("20", 0.4);
            }
        }
    }

    public void 角斗士的终幕礼(int i) {
        if (j == 0 && i > 1){
            obj_calculator.getJszsg_fb().getFightPropMap().put("6",obj_calculator.getJszsg_fb().getFightPropMap().get("6")-0.18);
            Log.d("TAG","减去");
        }

        if (!obj_calculator.addZy(new Zy(0.18, "角斗士的终幕礼2", false, false, "6", 0, 0)))
            accumulateValue("6",0.18);
        if (j == 1 && i == 4) {
            if (obj_calculator.wq_lx.equals("单手剑")||obj_calculator.wq_lx.equals("双手剑")||obj_calculator.wq_lx.equals("长柄武器")){
                if (!obj_calculator.addZy(new Zy(0.35, "角斗士的终幕礼4_1", false, false, "10008", 0, 0))) {
                    accumulateValue("10008", 0.35);
                }
                if (!obj_calculator.addZy(new Zy(0.35, "角斗士的终幕礼4_2", false, false, "10015", 0, 0))) {
                    accumulateValue("10015", 0.35);
                }
                if (!obj_calculator.addZy(new Zy(0.35, "角斗士的终幕礼4_2", false, false, "10004", 0, 0))) {
                    accumulateValue("10004", 0.35);
                }
            }

        }
    }

    public void 绝缘之旗印(int i) {
        if (j == 0 && i > 1)
            obj_calculator.getJszsg_fb().getFightPropMap().put("23",obj_calculator.getJszsg_fb().getFightPropMap().get("23")-0.2);
        if (!obj_calculator.addZy(new Zy(0.2, "绝缘之旗印2", false, false, "23", 0, 0)))
            accumulateValue("23",0.2);
        Log.d("TAGSYW",j+"");
        if (j ==1 && i == 4) {
            double sz=obj_calculator.getYscn(1)*100*0.0025;
            if (sz>0.75)
                sz=0.75;
            if (!obj_calculator.addZy(new Zy(sz, "绝缘之旗印4件套", false, false, "10003", 0, 0))) {
                accumulateValue("10003", sz);
            }
        }
    }

    public void 追忆之注连(int i) {
        if (j == 0 && i > 1)
            obj_calculator.getJszsg_fb().getFightPropMap().put("6",obj_calculator.getJszsg_fb().getFightPropMap().get("6")-0.18);
        if (!obj_calculator.addZy(new Zy(0.18, "追忆之注连2", false, false, "6", 0, 0)))
            accumulateValue("6",0.18);
        if (j == 1 && i == 4) {
            if (!obj_calculator.addZy(new Zy(0.5, "追忆之注连4件套_重击", false, false, "10015", 0, 0))) {
                accumulateValue("10015", 0.5);
            }
            if (!obj_calculator.addZy(new Zy(0.5, "追忆之注连4件套_下落", false, false, "10004", 0, 0))) {
                accumulateValue("10004", 0.5);
            }
            if (!obj_calculator.addZy(new Zy(0.5, "追忆之注连4件套_平A", false, false, "10001", 0, 0))) {
                accumulateValue("10001", 0.5);
            }
        }
    }

    public void 翠绿之影(int i) {
        if (j == 0 && i > 1)
            obj_calculator.getJszsg_fb().getFightPropMap().put("44",obj_calculator.getJszsg_fb().getFightPropMap().get("44")-0.15);
        if (!obj_calculator.addZy(new Zy(0.15, "翠绿之影2", false, false, "44", 0, 0)))
            accumulateValue("44",0.15);
    }

    public void 流浪大地的乐团(int i) {
        if (j == 0 && i > 1)
            obj_calculator.getJszsg_fb().getFightPropMap().put("28",obj_calculator.getJszsg_fb().getFightPropMap().get("28")-80);
        if (!obj_calculator.addZy(new Zy(80, "流浪大地的乐团2", false, false, "28", 0, 0)))
            accumulateValue("28",80.0);

        if (j == 1 && i > 3){
            if (obj_calculator.wq_lx.equals("弓")||obj_calculator.wq_lx.equals("法器")){
                if (!obj_calculator.addZy(new Zy(0.35, "流浪大地的乐团4", false, false, "10015", 0, 0))) {
                    accumulateValue("10015", 0.35);
                }
            }
        }
    }
    public void 如雷的盛怒(int i) {
        if (j == 0 && i > 1)
            obj_calculator.getJszsg_fb().getFightPropMap().put("41",obj_calculator.getJszsg_fb().getFightPropMap().get("41")-0.15);
        if (!obj_calculator.addZy(new Zy(0.15, "如雷的盛怒2", false, false, "41", 0, 0)))
            accumulateValue("41",0.15);
             if (j==1&&i>3){
            if (!obj_calculator.addZy(new Zy(0.4, "如雷的盛怒4_剧变", false, false, "10009", 0, 0))) {
                accumulateValue("10009", 0.4);
            }
            if (!obj_calculator.addZy(new Zy(0.2, "如雷的盛怒4_激化", false, false, "10010", 0, 0))) {
                accumulateValue("10010", 0.2);
            }
        }
    }

    public  void  炽烈的炎之魔女(int i){
        if (j == 0 && i > 1)
            obj_calculator.getJszsg_fb().getFightPropMap().put("40",obj_calculator.getJszsg_fb().getFightPropMap().get("40")-0.15);
        if (!obj_calculator.addZy(new Zy(0.15, "炽烈的炎之魔女2", false, false, "40", 0, 0)))
            accumulateValue("40",0.15);

        if (j == 1 && i > 1){
            if (!obj_calculator.addZy(new Zy(0.15, "炽烈的炎之魔女4_1", true, true, "10031", 0, 0))) {
                accumulateValue("10031", 0.15);
            }
            if (!obj_calculator.addZy(new Zy(0.075, "炽烈的炎之魔女4_2", true, true, "40", 0, 0))) {
                accumulateValue("40", 0.075);
            }
        }
    }

    public  void  昔日宗室之仪(int i){
//        if (j == 0 && i > 1)
//            obj_calculator.getJszsg_fb().getFightPropMap().put("10003",obj_calculator.getJszsg_fb().getFightPropMap().get("10003")-0.2);
        if (!obj_calculator.addZy(new Zy(0.2, "昔日宗室之仪2", false, false, "10003", 0, 0)))
            accumulateValue("10003",0.2);
        if (j == 1 && i > 3){
            if (!obj_calculator.addZy(new Zy(0.2, "昔日宗室之仪4", true, true, "6", 0, 0))) {
                accumulateValue("6", 0.2);
            }
        }

    }
    public  void  染血的骑士道(int i){
        if (j == 0 && i > 1)
            obj_calculator.getJszsg_fb().getFightPropMap().put("30",obj_calculator.getJszsg_fb().getFightPropMap().get("30")-0.25);
        if (!obj_calculator.addZy(new Zy(0.25, "染血的骑士道2", false, false, "30", 0, 0)))
            accumulateValue("30",0.25);
        if (j == 1 && i > 3) {
            if (!obj_calculator.addZy(new Zy(0.5, "染血的骑士道4", false, false, "10015", 0, 0))) {
                accumulateValue("10015", 0.5);
            }
        }
    }

    public void 悠古的磐岩(int i){
        if (j == 0 && i > 1)
            obj_calculator.getJszsg_fb().getFightPropMap().put("45",obj_calculator.getJszsg_fb().getFightPropMap().get("45")-0.15);
        if (!obj_calculator.addZy(new Zy(0.15, "悠古的磐岩2", false, false, "45", 0, 0)))
            accumulateValue("45",0.15);
        if (j == 1 && i > 3) {
            if (!obj_calculator.addZy(new Zy(0.35, "悠古的磐岩4", false, false, obj_calculator.ys_key, 0, 0)))
                accumulateValue(obj_calculator.ys_key, 0.35);
        }

    }

    public void 逆飞的流星(int i){
        if (j == 0 && i > 1)
            obj_calculator.getJszsg_fb().getFightPropMap().put("81",obj_calculator.getJszsg_fb().getFightPropMap().get("81")-0.35);
        if (!obj_calculator.addZy(new Zy(0.35, "逆飞的流星2", false, false, "81", 0, 0)))
            accumulateValue("81",0.35);
        if (j == 1 && i > 3) {
            if (!obj_calculator.addZy(new Zy(0.4, "逆飞的流星4_1", false, false,"10015", 0, 0)))
                accumulateValue("10015", 0.4);
            if (!obj_calculator.addZy(new Zy(0.4, "逆飞的流星4_2", false, false,"10001", 0, 0)))
                accumulateValue("10001", 0.4);
        }

    }
    public void 沉沦之心(int i){
        if (j == 0 && i > 1)
            obj_calculator.getJszsg_fb().getFightPropMap().put("42",obj_calculator.getJszsg_fb().getFightPropMap().get("42")-0.15);
        if (!obj_calculator.addZy(new Zy(0.15, "沉沦之心2", false, false, "42", 0, 0)))
            accumulateValue("42",0.15);

        if (j == 1 && i > 3) {
            if (!obj_calculator.addZy(new Zy(0.3, "沉沦之心4_1", false, false,"10015", obj_calculator.getTime(), 15)))
                accumulateValue("10015", 0.3);
            if (!obj_calculator.addZy(new Zy(0.3, "沉沦之心4_2", false, false,"10001", obj_calculator.getTime(), 15)))
                accumulateValue("10001", 0.3);
        }

    }

    public void 千岩牢固(int i){
        if (j == 0 && i > 1)
            obj_calculator.getJszsg_fb().getFightPropMap().put("3",obj_calculator.getJszsg_fb().getFightPropMap().get("3")-0.2);
        if (!obj_calculator.addZy(new Zy(0.2, "千岩牢固2", false, false, "3", 0, 0)))
            accumulateValue("3",0.2);
        if (j == 1 && i > 3) {
            if (!obj_calculator.addZy(new Zy(0.2, "千岩牢固4_1", true, true, "6", obj_calculator.getTime(), 0)))
                accumulateValue("6", 0.2);
            if (!obj_calculator.addZy(new Zy(0.3, "千岩牢固4_2", true, true, "81", obj_calculator.getTime(), 0)))
                accumulateValue("81", 0.3);
        }

    }

    public void 苍白之火(int i){
        if (j == 0 && i > 1)
            obj_calculator.getJszsg_fb().getFightPropMap().put("30",obj_calculator.getJszsg_fb().getFightPropMap().get("30")-0.25);
        if (!obj_calculator.addZy(new Zy(0.25, "苍白之火2", false, false, "30", 0, 0)))
            accumulateValue("30",0.25);
        if (j == 1 && i > 3) {
            if (!obj_calculator.addZy(new Zy(0.18, "苍白之火4_1", false, false, "6", obj_calculator.getTime(), 0)))
                accumulateValue("6", 0.18);
            if (!obj_calculator.addZy(new Zy(0.25, "苍白之火4_2", false, false, "30", obj_calculator.getTime(), 0)))
                accumulateValue("30", 0.25);

        }

    }

    public void 华馆梦醒形骸记(int i){
        if (j == 0 && i > 1)
            obj_calculator.getJszsg_fb().getFightPropMap().put("30",obj_calculator.getJszsg_fb().getFightPropMap().get("30")-0.25);
        if (!obj_calculator.addZy(new Zy(0.25, "华馆梦醒形骸记2", false, false, "30", 0, 0)))
            accumulateValue("30",0.25);
        if (j == 1 && i > 3&&obj_calculator.ys_key.equals("45")) {
            if (!obj_calculator.addZy(new Zy(0.24, "华馆梦醒形骸记4_1", false, false, "9", obj_calculator.getTime(), 0)))
                accumulateValue("9", 0.24);
            if (!obj_calculator.addZy(new Zy(0.24, "华馆梦醒形骸记4_2", false, false, "45", obj_calculator.getTime(), 0)))
                accumulateValue("45", 0.24);

        }

    }

    public void 海染砗磲 (int i){
        if (j == 0 && i > 1)
            obj_calculator.getJszsg_fb().getFightPropMap().put("26",obj_calculator.getJszsg_fb().getFightPropMap().get("26")-0.15);
        if (!obj_calculator.addZy(new Zy(0.15, "海染砗磲2", false, false, "26", 0, 0)))
            accumulateValue("26",0.15);
    }

    public void 辰砂往生录(int i){
        if (j == 0 && i > 1)
            obj_calculator.getJszsg_fb().getFightPropMap().put("6",obj_calculator.getJszsg_fb().getFightPropMap().get("6")-0.18);
        if (!obj_calculator.addZy(new Zy(0.18, "辰砂往生录2", false, false, "6", 0, 0)))
            accumulateValue("6",0.18);
        if (j == 1 && i > 3) {
            if (!obj_calculator.addZy(new Zy(0.48, "辰砂往生录4", false, false, "6", obj_calculator.getTime(), 0)))
                accumulateValue("6", 0.48);


        }

    }

    public void 来歆余响 (int i){
        if (j == 0 && i > 1)
            obj_calculator.getJszsg_fb().getFightPropMap().put("6",obj_calculator.getJszsg_fb().getFightPropMap().get("6")-0.18);
        if (!obj_calculator.addZy(new Zy(0.18, "来歆余响2", false, false, "6", 0, 0)))
            accumulateValue("6",0.18);
        if (j == 1 && i > 3) {
            if (!obj_calculator.addZy(new Zy(obj_calculator.getGj(0)*0.35, "来歆余响4期望提升", false, false, "10022", obj_calculator.getTime(), 0)))
                accumulateValue("10022", obj_calculator.getGj(0)*0.35);
        }

    }


    public void 深林的记忆 (int i){
        if (j == 0 && i > 1)
            obj_calculator.getJszsg_fb().getFightPropMap().put("43",obj_calculator.getJszsg_fb().getFightPropMap().get("43")-0.15);
        if (!obj_calculator.addZy(new Zy(0.15, "深林的记忆2", false, false, "43", 0, 0)))
            accumulateValue("43",0.15);
        if (j == 1 && i > 3) {
            if (!obj_calculator.addZy(new Zy(0.3, "深林的记忆4", false, false, "20043", obj_calculator.getTime(), 0)))
                accumulateValue("20043", 0.3);
        }

    }

    public void 饰金之梦 (int i){

        if (j == 0 && i > 1)
            obj_calculator.getJszsg_fb().getFightPropMap().put("28",obj_calculator.getJszsg_fb().getFightPropMap().get("28")-80);
        if (!obj_calculator.addZy(new Zy(80, "饰金之梦2", false, false, "28", 0, 0)))
            accumulateValue("28",80.0);

        if (j == 1 && i > 3) {
            if (!obj_calculator.addZy(new Zy(150, "饰金之梦4", false, false, "28", obj_calculator.getTime(), 0)))
                accumulateValue("28", 150.0);
        }

    }

    public void 沙上楼阁史话 (int i){
        if (j == 0 && i > 1)
            obj_calculator.getJszsg_fb().getFightPropMap().put("44",obj_calculator.getJszsg_fb().getFightPropMap().get("44")-0.15);
        if (!obj_calculator.addZy(new Zy(0.15, "沙上楼阁史话2", false, false, "44", 0, 0)))
            accumulateValue("44",0.15);
        if (j == 1 && i > 3) {
            if (!obj_calculator.addZy(new Zy(0.4, "沙上楼阁史话4_1", false, false, "10001", obj_calculator.getTime(), 0)))
                accumulateValue("10001", 0.4);
            if (!obj_calculator.addZy(new Zy(0.4, "沙上楼阁史话4_2", false, false, "10015", obj_calculator.getTime(), 0)))
                accumulateValue("10015", 0.4);
            if (!obj_calculator.addZy(new Zy(0.4, "沙上楼阁史话4_3", false, false, "10004", obj_calculator.getTime(), 0)))
                accumulateValue("10004", 0.4);
        }

    }



    public void 乐园遗落之花 (int i){
        if (j == 0 && i > 1)
            obj_calculator.getJszsg_fb().getFightPropMap().put("28",obj_calculator.getJszsg_fb().getFightPropMap().get("44")-80);
        if (!obj_calculator.addZy(new Zy(80, "乐园遗落之花2", false, false, "28", 0, 0)))
            accumulateValue("28",80.0);
        if (j == 1 && i > 3) {
            if (!obj_calculator.addZy(new Zy(0.8, "乐园遗落之花4", false, false, "10011", obj_calculator.getTime(), 0)))
                accumulateValue("10011", 0.8);

        }
    }


    public void 平息鸣雷的尊者 (int i){

        if (j == 0 && i > 3) {
            if (!obj_calculator.addZy(new Zy(0.35, "平息鸣雷的尊者4", false, false, "10012", obj_calculator.getTime(), 0)))
                accumulateValue("10012", 0.35);
        }
    }



    public void  渡过烈火的贤人 (int i){
        if (j == 0 && i > 3) {
            if (!obj_calculator.addZy(new Zy(0.35, "渡过烈火的贤人4", false, false, "40", obj_calculator.getTime(), 0)))
                accumulateValue("40", 0.35);

        }
    }
    public void 被怜爱的少女 (int i){
        if (j == 0 && i > 1)
            obj_calculator.getJszsg_fb().getFightPropMap().put("26",obj_calculator.getJszsg_fb().getFightPropMap().get("26")-0.15);
        if (!obj_calculator.addZy(new Zy(0.15, "被怜爱的少女2", false, false, "26", 0, 0)))
            accumulateValue("26",0.15);
        if (j == 1 && i > 3) {
            if (!obj_calculator.addZy(new Zy(0.2, "被怜爱的少女4", false, false, "26", obj_calculator.getTime(), 0)))
                accumulateValue("26", 0.2);
        }
    }


    public void 水仙之梦 (int i){
        if (j == 0 && i > 1)
            obj_calculator.getJszsg_fb().getFightPropMap().put("42",obj_calculator.getJszsg_fb().getFightPropMap().get("42")-0.15);
        if (!obj_calculator.addZy(new Zy(0.15, "水仙之梦2", false, false, "42", 0, 0)))
            accumulateValue("42",0.15);
        if (j == 1 && i > 3) {
            if (!obj_calculator.addZy(new Zy(0.15, "水仙之梦4_1", false, false, "42", obj_calculator.getTime(), 0)))
                accumulateValue("42", 0.15);
            if (!obj_calculator.addZy(new Zy(0.25, "水仙之梦4_2", false, false, "6", obj_calculator.getTime(), 0)))
                accumulateValue("6", 0.25);
        }
    }

    public void 花海甘露之光 (int i){
        if (j == 0 && i > 1)
            obj_calculator.getJszsg_fb().getFightPropMap().put("3",obj_calculator.getJszsg_fb().getFightPropMap().get("3")-0.2);
        if (!obj_calculator.addZy(new Zy(0.2, "花海甘露之光2", false, false, "3", 0, 0)))
            accumulateValue("3",0.2);
        if (j == 1 && i > 3) {
            if (!obj_calculator.addZy(new Zy(0.5, "花海甘露之光4_1", false, false, "10002", obj_calculator.getTime(), 0)))
                accumulateValue("10002", 0.5);
            if (!obj_calculator.addZy(new Zy(0.5, "花海甘露之光4_2", false, false, "10003", obj_calculator.getTime(), 0)))
                accumulateValue("10003", 0.5);
        }
    }





    public void accumulateValue(String key, Double valueToAdd) {
        if (obj_calculator.getMyZy().containsKey(key)) {
            obj_calculator.getMyZy().put(key, obj_calculator.getMyZy().get(key) + valueToAdd);
        } else {
            obj_calculator.getMyZy().put(key, valueToAdd);
        }
        Log.d("TAG", "添加增益" + key);
    }
}
