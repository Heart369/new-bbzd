package com.example.main.mvvm.calculator.tool;

import android.util.Log;

import com.example.main.mvvm.calculator.role.Obj_calculator;

import java.util.List;
import java.util.Map;

public class Wq_class {
    List<Zy> zyList;
    Map<String, Double> myZy;
    int flag,flag2=1;

    public void setFlag2(int flag2) {
        this.flag2 = flag2;
        Log.d("TAGCs",flag2+"");
    }

    Obj_calculator obj_calculator;

    public Wq_class(List<Zy> zyList, Map<String, Double> myZy, int flag, Obj_calculator obj_calculator) {
        this.zyList = zyList;
        this.myZy = myZy;
        this.flag = flag;
        this.obj_calculator = obj_calculator;
    }

    public void 雾切之回光(int jl) {
        double[] d = new double[]{0.28, 0.35, 0.42, 0.49, 0.56};
        double[] d2 = new double[]{0.12, 0.15, 0.18, 0.21, 0.24};
        if (flag2==0){
            accumulateValue("46", d2[jl]);
        }
        else
        if (!obj_calculator.addZy(new Zy(d2[jl], "雾切之回光1", false, false, "46", -1, -1))){
            obj_calculator.getJszsg_fb().getFightPropMap().put("46",  obj_calculator.getJszsg_fb().getFightPropMap().get("46")-d2[jl]);
            accumulateValue("46", d2[jl]);
        }

        if (flag == 0) {
            if (!obj_calculator.addZy(new Zy(d[jl], "雾切满层被动", false, false, obj_calculator.ys_key, -1, -1)))
                accumulateValue(obj_calculator.ys_key, d[jl]);
        }

    }

    public void accumulateValue(String key, Double valueToAdd) {
        if (myZy.containsKey(key)) {
            myZy.put(key, myZy.get(key) + valueToAdd);
        } else {
            myZy.put(key, valueToAdd);
        }
    }

    public void 薙草之稻光(int jl) {
        double[] d = new double[]{0.28, 0.35, 0.42, 0.49, 0.56};
        double[] d1 = new double[]{0.3, 0.35, 0.40, 0.45, 0.50};
        double[] d2 = new double[]{0.8, 0.9, 1, 1.1, 1.2};
        if (flag == 0) {
            if (!obj_calculator.addZy(new Zy(d1[jl], "薙草之稻光被动1", false, false, "23", -1, -1)))
                accumulateValue("23", d1[jl]);
            double gj = d[jl] * (obj_calculator.getYscn(1) - 1);
            if (gj > d2[jl])
                gj = d2[jl];
            zyList.add(new Zy(gj, "薙草之稻光被动2", false, false, "6", -1, -1));
            accumulateValue("6", gj);
        }
    }

    public void 护摩之杖(int jl) {
        double[] d1 = new double[]{0.018, 0.022, 0.026, 0.03, 0.034};
        double[] d2 = new double[]{0.2, 0.25, 0.3, 0.35, 0.4};
        if (flag2==0){
            accumulateValue("3", d2[jl]);
        }
        else
        if (!obj_calculator.addZy(new Zy(d2[jl], "护摩之杖1", false, false, "3", -1, -1))){
            obj_calculator.getJszsg_fb().getFightPropMap().put("3",  obj_calculator.getJszsg_fb().getFightPropMap().get("3")-d2[jl]);
            accumulateValue("3", d2[jl]);
        }

        if (flag == 0) {
            double gj = d1[jl] * obj_calculator.getSmz(0);
            if (!obj_calculator.addZy(new Zy(gj, "护摩之杖2", false, false, "5", -1, -1)))
            accumulateValue("5", gj);
        }
    }

    public void 风鹰剑(int jl) {
        //p用没有
        double[] d2 = new double[]{0.2, 0.25, 0.3, 0.35, 0.4};
        if (flag2==0){
            accumulateValue("6", d2[jl]);
        }
        else
        if (!obj_calculator.addZy(new Zy(d2[jl], "风鹰剑", false, false, "6", -1, -1))){
            obj_calculator.getJszsg_fb().getFightPropMap().put("6",  obj_calculator.getJszsg_fb().getFightPropMap().get("6")-d2[jl]);
            Log.d("TAGCS","我一回家的");
            accumulateValue("6", d2[jl]);
        }
    }

    public void 飞雷之弦振(int jl) {
        double[] d1 = new double[]{0.4, 0.5, 0.6, 0.7, 0.8};
        double[] d = new double[]{0.2, 0.25, 0.30, 0.35, 0.40};
        if (flag2==0){
            accumulateValue("6", d[jl]);
        }
        else
        if (!obj_calculator.addZy(new Zy(d[jl], "飞雷之弦振1", false, false, "6", -1, -1))){
            obj_calculator.getJszsg_fb().getFightPropMap().put("6",  obj_calculator.getJszsg_fb().getFightPropMap().get("6")-d[jl]);
            accumulateValue("6", d[jl]);
        }
        if (flag == 0) {
            zyList.add(new Zy(d1[jl], "飞雷之弦振2", false, false, "10001", -1, -1));
            accumulateValue("10001", d1[jl]);
        }
    }

    public void 千夜浮梦(int jl) {
        double[] d1 = new double[]{0.1, 0.14, 0.18, 0.22, 0.26};
        if (flag == 0) {
            zyList.add(new Zy(d1[jl] * 3, "千夜浮梦", false, false, obj_calculator.ys_key, -1, -1));
            accumulateValue(obj_calculator.ys_key, d1[jl] * 3);
        }
    }

    public void 松籁响起之时(int jl) {
        double[] d1 = new double[]{0.16, 0.2, 0.24, 0.28, 0.32};
        double[] d2 = new double[]{0.20, 0.25, 0.30, 0.35, 0.40};
        if (flag == 0) {
            if (flag2==0){
                accumulateValue("6", d1[jl]);
            }
            else
            if (!obj_calculator.addZy(new Zy(d1[jl], "松籁响起之时_1", false, false, "6", -1, -1))){
                obj_calculator.getJszsg_fb().getFightPropMap().put("6",  obj_calculator.getJszsg_fb().getFightPropMap().get("6")-d1[jl]);
                accumulateValue("6", d1[jl]);
            }
            if (!obj_calculator.addZy(new Zy(d2[jl], "松籁响起之时_1", false, false, "6", -1, -1)))
                accumulateValue("6", d2[jl]);
        }
    }

    public void 天空之刃(int jl) {
        double[] d1 = new double[]{0.4, 0.5, 0.6, 0.7, 0.8};
        if (flag == 0) {
            obj_calculator.addZy(new Zy(d1[jl], "天空之刃_1", false, false, "20", -1, -1));
        }
    }

    public void 天空之傲(int jl) {
        double[] d1 = new double[]{0.8, 0.10, 0.12, 0.14, 0.16};
        if (flag == 0) {
            obj_calculator.addZy(new Zy(d1[jl], "天空之傲_1", false, false, "10012", -1, -1));
        }
    }

    public void 天空之卷(int jl) {
        double[] d1 = new double[]{0.12, 0.15, 0.18, 0.21, 0.24};

        if (flag == 0) {
            obj_calculator.addZy(new Zy(d1[jl], "天空之卷_1", false, false, "10033", -1, -1));
        }
    }

    public void 天空之翼(int jl) {
        double[] d1 = new double[]{0.2, 0.25, 0.30, 0.35, 0.40};
        if (flag == 0) {
            obj_calculator.addZy(new Zy(d1[jl], "天空之翼_1", false, false, "22", -1, -1));
        }
    }

    public void 终末嗟叹之诗(int jl) {
        double[] d1 = new double[]{60, 75, 90, 105, 120};
        double[] d2 = new double[]{100, 125, 150, 175, 200};
        double[] d3 = new double[]{0.20, 0.25, 0.30, 0.35, 0.40};
        if (flag == 0) {
            if (flag2==0){
                accumulateValue("28", d1[jl]);
            }
            else
            if (!obj_calculator.addZy(new Zy(d1[jl], "终末嗟叹之诗1", false, false, "28", -1, -1))){
                obj_calculator.getJszsg_fb().getFightPropMap().put("28",  obj_calculator.getJszsg_fb().getFightPropMap().get("28")-d1[jl]);
                accumulateValue("28", d1[jl]);
            }
            if (!obj_calculator.addZy(new Zy(d2[jl], "终末嗟叹之诗_2", false, false, "28", -1, -1)))
                accumulateValue("28", d2[jl]);
            if (!obj_calculator.addZy(new Zy(d3[jl], "终末嗟叹之诗_3", false, false, "6", -1, -1)))
                accumulateValue("6", d3[jl]);
        }
    }

    public void 苍古自由之誓(int jl) {
        double[] d1 = new double[]{0.1, 0.125, 0.15, 0.175, 0.2};
        double[] d2 = new double[]{0.16, 0.2, 0.24, 0.28, 0.32};
        double[] d3 = new double[]{0.20, 0.25, 0.30, 0.35, 0.40};
        if (flag == 0) {
            if (flag2==0){
                accumulateValue("10012", d1[jl]);
            }
            else
            if (!obj_calculator.addZy(new Zy(d1[jl], "苍古自由之誓1", false, false, "10012", -1, -1))){
                accumulateValue("10012", d1[jl]);
            }
            if (!obj_calculator.addZy(new Zy(d2[jl], "苍古自由之誓_2", false, false, "10001", -1, -1)))
                accumulateValue("10001", d2[jl]);
            if (!obj_calculator.addZy(new Zy(d3[jl], "苍古自由之誓_3", false, false, "10004", -1, -1)))
                accumulateValue("10004", d3[jl]);
            if (!obj_calculator.addZy(new Zy(d3[jl], "苍古自由之誓_4", false, false, "10015", -1, -1)))
                accumulateValue("10015", d3[jl]);
            if (!obj_calculator.addZy(new Zy(d3[jl], "苍古自由之誓_5", false, false, "6", -1, -1)))
                accumulateValue("6", d3[jl]);
        }
    }


    public void 冬极白星(int jl) {
        double[] d1 = new double[]{0.12, 0.15, 0.18, 0.21, 0.24};
        double[] d2 = new double[]{0.3, 0.375, 0.45, 0.525, 0.6};
        if (flag == 0) {
            if (!obj_calculator.addZy(new Zy(d1[jl], "冬极白星_1", false, false, "10002", -1, -1)))
                accumulateValue("10002", d1[jl]);
            if (!obj_calculator.addZy(new Zy(d1[jl], "冬极白星_2", false, false, "10003", -1, -1)))
                accumulateValue("10003", d1[jl]);
            if (!obj_calculator.addZy(new Zy(d2[jl], "冬极白星_3", false, false, "6", -1, -1)))
                accumulateValue("6", d2[jl]);
        }
    }

    public void 狼的末路(int jl) {
        double[] d1 = new double[]{0.2, 0.25, 0.3, 0.35, 0.4};
        double[] d2 = new double[]{0.4, 0.5, 0.6, 0.7, 0.8};
        if (flag == 0) {
            obj_calculator.addZy(new Zy(d1[jl], "狼的末路_1", false, false, "6", -1, -1));
            if (!obj_calculator.addZy(new Zy(d2[jl], "狼的末路_2", false, false, "6", -1, -1)))
                accumulateValue("6", d2[jl]);
        }
    }

    public void 四风原典(int jl) {
        double[] d1 = new double[]{0.08, 0.1, 0.12, 0.14, 0.16};
        if (flag == 0) {
            if (!obj_calculator.addZy(new Zy(d1[jl] * 4, "四风原典_2", false, false, "10033", -1, -1)))
                accumulateValue("10033",d1[jl] * 4);
        }
    }

    public void 阿莫斯之弓(int jl) {
        double[] d1 = new double[]{0.12, 0.15, 0.18, 0.21, 0.24};
        double[] d2 = new double[]{0.08, 0.10, 0.12, 0.14, 0.16};
        if (flag == 0) {
            double dex = d1[jl] + d2[jl] * 5;
            if (!obj_calculator.addZy(new Zy(dex, "阿莫斯之弓_1", false, false, "10001", -1, -1)))
                accumulateValue("10001", dex);
            if (!obj_calculator.addZy(new Zy(dex, "阿莫斯之弓_2", false, false, "10015", -1, -1)))
                accumulateValue("10015", dex);
        }
    }

    public void 天空之脊(int jl) {
        double[] d1 = new double[]{0.08, 0.1, 0.12, 0.14, 0.16};
        double[] d2 = new double[]{0.4, 0.5, 0.6, 0.7, 0.8};
        if (flag == 0) {
            obj_calculator.addZy(new Zy(d1[jl], " 天空之脊_1", false, false, "20", -1, -1));
        }
    }

    public void 斫峰之刃(int jl) {
        double[] d1 = new double[]{0.2, 0.25, 0.3, 0.35, 0.4};
        double[] d2 = new double[]{0.4, 0.5, 0.6, 0.7, 0.8};
        if (flag == 0) {
            if (flag2==0){
                accumulateValue("81", d1[jl]);
            }
            else
            if (!obj_calculator.addZy(new Zy(d1[jl], "斫峰之刃1", false, false, "81", -1, -1))){
                obj_calculator.getJszsg_fb().getFightPropMap().put("81",  obj_calculator.getJszsg_fb().getFightPropMap().get("81")-d1[jl]);
                accumulateValue("81", d1[jl]);
            }
            if (!obj_calculator.addZy(new Zy(d2[jl] , "斫峰之刃_2", false, false, "6", -1, -1)))
                accumulateValue("6", d2[jl] );
        }
    }


    public void 若水(int jl) {
        double[] d1 = new double[]{0.16, 0.2, 0.14, 0.28, 0.36};
        double[] d2 = new double[]{0.2, 0.25, 0.3, 0.35, 0.40};
        if (flag == 0) {
            if (flag2==0){
                accumulateValue("3", d1[jl]);
            }
            else
            if (!obj_calculator.addZy(new Zy(d1[jl], "若水_1", false, false, "3", -1, -1))){
                obj_calculator.getJszsg_fb().getFightPropMap().put("3",  obj_calculator.getJszsg_fb().getFightPropMap().get("3")-d1[jl]);
                accumulateValue("3", d1[jl]);
            }
            if (!obj_calculator.addZy(new Zy(d2[jl], "若水_2", false, false, "10012", -1, -1)))
                accumulateValue("10012", d2[jl]);
        }
    }

    public void 和璞鸢(int jl) {
        double[] d1 = new double[]{0.032, 0.039, 0.046, 0.053, 0.06};
        double[] d2 = new double[]{0.12, 0.15, 0.18, 0.21, 0.24};
        if (flag == 0) {
            if (!obj_calculator.addZy(new Zy(d1[jl] * 7, "和璞鸢_1", false, false, "6", -1, -1))) {
                accumulateValue("6", d1[jl] * 7);
            }
            if (!obj_calculator.addZy(new Zy(d2[jl], "和璞鸢_2", false, false, "10012", -1, -1)))
                accumulateValue("10012", d2[jl]);
        }
    }


    public void 磐岩结绿(int jl) {
        double[] d1 = new double[]{0.2, 0.25, 0.30, 0.35, 0.4};
        double[] d2 = new double[]{0.012, 0.015, 0.018, 0.021, 0.024};
        if (flag == 0) {
            if (!obj_calculator.addZy(new Zy(d1[jl], "磐岩结绿_1", false, false, "3", -1, -1))) {
                accumulateValue("3", d1[jl]);
            }
            if (!obj_calculator.addZy(new Zy(obj_calculator.getSmz(1) * d2[jl], "磐岩结绿_2", false, false, "10021", -1, -1)))
                accumulateValue("10021", obj_calculator.getSmz(1) * d2[jl]);
        }
    }

    public void 无工之剑(int jl) {
        double[] d1 = new double[]{0.2, 0.25, 0.3, 0.35, 0.4};
        double[] d2 = new double[]{0.4, 0.5, 0.6, 0.7, 0.8};
        if (flag == 0) {
            if (flag2==0){
                accumulateValue("81", d1[jl]);
            }
            else
            if (!obj_calculator.addZy(new Zy(d1[jl], "无工之剑_1", false, false, "81", -1, -1))){
                obj_calculator.getJszsg_fb().getFightPropMap().put("81",  obj_calculator.getJszsg_fb().getFightPropMap().get("81")-d1[jl]);
                accumulateValue("81", d1[jl]);
            }
            if (!obj_calculator.addZy(new Zy(d2[jl] , "无工之剑_2", false, false, "6", -1, -1)))
                accumulateValue("6", d2[jl] );
        }
    }

    public void 尘世之锁(int jl) {
        double[] d1 = new double[]{0.2, 0.25, 0.3, 0.35, 0.4};
        double[] d2 = new double[]{0.4, 0.5, 0.6, 0.7, 0.8};
        if (flag == 0) {
            if (flag2==0){
                accumulateValue("81", d1[jl]);
            }
            else
            if (!obj_calculator.addZy(new Zy(d1[jl], "尘世之锁_1", false, false, "81", -1, -1))){
                obj_calculator.getJszsg_fb().getFightPropMap().put("81",  obj_calculator.getJszsg_fb().getFightPropMap().get("81")-d1[jl]);
                accumulateValue("81", d1[jl]);
            }
            if (!obj_calculator.addZy(new Zy(d2[jl] , "尘世之锁_2", false, false, "6", -1, -1)))
                accumulateValue("6", d2[jl] );
        }
    }

    public void 贯虹之槊(int jl) {
        double[] d1 = new double[]{0.2, 0.25, 0.3, 0.35, 0.4};
        double[] d2 = new double[]{0.04, 0.05, 0.06, 0.07, 0.08};
        if (flag == 0) {
            if (flag2==0){
                accumulateValue("81", d1[jl]);
            }
            else
            if (!obj_calculator.addZy(new Zy(d1[jl], "贯虹之槊_1", false, false, "81", -1, -1))){
                obj_calculator.getJszsg_fb().getFightPropMap().put("81",  obj_calculator.getJszsg_fb().getFightPropMap().get("81")-d1[jl]);
                accumulateValue("81", d1[jl]);
            }
              if (!obj_calculator.addZy(new Zy(d2[jl] , "贯虹之槊_2", false, false, "6", -1, -1)))
                accumulateValue("6", d2[jl] );
        }
    }

    public void 息灾(int jl) {
        double[] d1 = new double[]{0.12, 0.15, 0.18, 0.21, 0.24};
        double[] d2 = new double[]{0.032, 0.04, 0.048, 0.056, 0.064};
        if (flag == 0) {
            if (!obj_calculator.addZy(new Zy(d1[jl], "息灾_1", false, false, "10033", -1, -1)))
                accumulateValue("10033", d1[jl]);
            if (!obj_calculator.addZy(new Zy(d2[jl] * 6*2, "息灾_2", false, false, "6", -1, -1)))
                accumulateValue("6", d2[jl] * 6*2);
        }
    }

    public void 图莱杜拉的回忆(int jl) {
        double[] d1 = new double[]{0.48, 0.60, 0.72, 0.84, 0.96};
        if (flag == 0) {
            if (!obj_calculator.addZy(new Zy(d1[jl], "图莱杜拉的回忆", false, false, "10001", -1, -1)))
                accumulateValue("10001", d1[jl]);
        }
    }


    public void 猎人之径(int jl) {
        double[] d1 = new double[]{0.12, 0.15, 0.18, 0.21, 0.24};
        double[] d2 = new double[]{1.6, 2, 2.4, 2.8, 3.2};
        if (flag == 0) {
            if (!obj_calculator.addZy(new Zy(d1[jl], "猎人之径_1", false, false, "10033", -1, -1))) {
                accumulateValue("10033", d1[jl]);
            }
            if (!obj_calculator.addZy(new Zy(obj_calculator.getYsjt(1) * d2[jl], "猎人之径_2", false, false, "10025", -1, -1)))
                accumulateValue("10025", obj_calculator.getYsjt(1) * d2[jl]);
        }
    }

    public void 赤沙之杖(int jl) {
        double[] d1 = new double[]{0.52, 0.65, 0.78, 0.91, 1.04};
        double[] d2 = new double[]{0.28, 0.35, 0.42, 0.49, 0.56};
        if (flag == 0) {
            if (!obj_calculator.addZy(new Zy(obj_calculator.getYsjt(1) * d1[jl], "赤沙之杖_1", false, false, "5", -1, -1))) {
                accumulateValue("6", obj_calculator.getYsjt(1) * d1[jl]);
            }
            if (!obj_calculator.addZy(new Zy(obj_calculator.getYsjt(1) * d2[jl], "赤沙之杖_2", false, false, "5", -1, -1)))
                accumulateValue("6", obj_calculator.getYsjt(1) * d2[jl]);
        }
    }

    public void 裁叶萃光(int jl) {
        double[] d1 = new double[]{0.04, 0.05, 0.06, 0.07, 0.08};
        double[] d2 = new double[]{1.2, 1.5, 1.8, 2.1, 2.4};
        if (flag == 0) {
            if (flag2==0){
                accumulateValue("20", d1[jl]);
            }
            else
            if (!obj_calculator.addZy(new Zy(d1[jl], " 裁叶萃光1", false, false, "20", -1, -1))){
                obj_calculator.getJszsg_fb().getFightPropMap().put("20",  obj_calculator.getJszsg_fb().getFightPropMap().get("20")-d1[jl]);
                accumulateValue("20", d1[jl]);
            }
               if (!obj_calculator.addZy(new Zy(obj_calculator.getYsjt(1)*d2[jl], "裁叶萃光_2", false, false, "10022", -1, -1)))
                accumulateValue("10022", obj_calculator.getYsjt(1)*d2[jl]);
            if (!obj_calculator.addZy(new Zy(obj_calculator.getYsjt(1)*d2[jl], "裁叶萃光_3", false, false, "10023", -1, -1)))
                accumulateValue("10023", obj_calculator.getYsjt(1)*d2[jl]);
        }
    }

    public void 圣显之钥(int jl) {
        double[] d1 = new double[]{0.2, 0.25, 0.3, 0.35, 0.4};
        double[] d2 = new double[]{0.0012, 0.0015, 0.0018, 0.0021, 0.0024};
        double[] d3 = new double[]{0.002, 0.0025, 0.003, 0.0035, 0.004};
        if (flag == 0) {
            if (flag2==0){
                accumulateValue("3", d1[jl]);
            }
            else
            if (!obj_calculator.addZy(new Zy(d1[jl], "圣显之钥_1", false, false, "3", -1, -1))){
                obj_calculator.getJszsg_fb().getFightPropMap().put("3",  obj_calculator.getJszsg_fb().getFightPropMap().get("3")-d1[jl]);
                accumulateValue("3", d1[jl]);
            }
            if (!obj_calculator.addZy(new Zy(obj_calculator.getSmz(1) * d2[jl]*3 , "圣显之钥_2", false, false, "28", -1, -1)))
                accumulateValue("28", obj_calculator.getSmz(1) * d2[jl]*3);
            if (!obj_calculator.addZy(new Zy(obj_calculator.getSmz(1) * d3[jl], "圣显之钥_3", false, false, "10016", -1, -1)))
                accumulateValue("10016", obj_calculator.getSmz(1) * d3[jl]);
        }
    }

    public void 神乐之真意(int jl) {
        double[] d1 = new double[]{0.12, 0.15, 0.18, 0.21, 0.24};
        double[] d2 = new double[]{0.12, 0.15, 0.18, 0.21, 0.24};
        if (flag == 0) {
            if (!obj_calculator.addZy(new Zy(d1[jl]*3, "神乐之真意_1", false, false, "10002", -1, -1)))
                accumulateValue("10002", d1[jl]*3);
            if (!obj_calculator.addZy(new Zy(d2[jl], "满层神乐之真意", false, false, "10033", -1, -1)))
                accumulateValue("10033", d2[jl]);
        }
    }

    public void 赤角石溃杵(int jl) {
        double[] d1 = new double[]{0.28, 0.35, 0.42, 0.49, 0.56};
        double[] d2 = new double[]{0.4, 0.5, 0.6, 0.7, 0.8};
        if (flag == 0) {
            if (flag2==0){
                accumulateValue("9", d1[jl]);
            }
            else
            if (!obj_calculator.addZy(new Zy(d1[jl], "赤角石溃杵_1", false, false, "9", -1, -1))){
                obj_calculator.getJszsg_fb().getFightPropMap().put("9",  obj_calculator.getJszsg_fb().getFightPropMap().get("9")-d1[jl]);
                accumulateValue("9", d1[jl]);
            }
            if (!obj_calculator.addZy(new Zy(obj_calculator.getFyl(0)*d2[jl], "赤角石溃杵_2", false, false, "10025", -1, -1)))
                accumulateValue("10025",obj_calculator.getFyl(0)*d2[jl]);
        }
    }

    public void 波乱月白经津(int jl) {
        double[] d1 = new double[]{0.12, 0.15, 0.18, 0.21, 0.24};
        double[] d2 = new double[]{0.2, 0.25, 0.3, 0.35, 0.4};
        if (flag == 0) {
            if (!obj_calculator.addZy(new Zy(d1[jl], "波乱月白经津_1", false, false, "10033", -1, -1))){
                accumulateValue("10033",d1[jl]);
            }

            if (!obj_calculator.addZy(new Zy(d2[jl]*2, "波乱月白经津_2", false, false, "10001", -1, -1)))
                accumulateValue("10001",d2[jl]*2);
        }
    }
    public void 不灭月华(int jl) {
        double[] d1 = new double[]{0.1, 0.125, 0.15, 0.175, 0.2};
        double[] d2 = new double[]{0.01, 0.015, 0.02, 0.025, 0.03};
        if (flag == 0) {
            if (flag2==0){
                accumulateValue("26", d1[jl]);
            }
            else
            if (!obj_calculator.addZy(new Zy(d1[jl], "不灭月华_1", false, false, "26", -1, -1))){
                obj_calculator.getJszsg_fb().getFightPropMap().put("26",  obj_calculator.getJszsg_fb().getFightPropMap().get("26")-d1[jl]);

            }
                accumulateValue("26",d1[jl]);
            if (!obj_calculator.addZy(new Zy(obj_calculator.getSmz(1)*d2[jl], "不灭月华_2", false, false, "10022", -1, -1)))
                accumulateValue("10022",obj_calculator.getSmz(1)*d2[jl]);
        }
    }

    public void 西风剑(int jl) {

    }
    public void 宗室长剑(int jl) {
        double[] d1 = new double[]{0.08, 0.1, 0.12, 0.14, 0.16};
        if (flag == 0) {
            if (!obj_calculator.addZy(new Zy(d1[jl], "宗室长剑", false, false, "20", -1, -1)))
                accumulateValue("20",d1[jl]);
        }
    }
    public void 暗巷闪光(int jl) {
        double[] d1 = new double[]{0.12, 0.15, 0.18, 0.21, 0.24};
        if (flag == 0) {
            if (!obj_calculator.addZy(new Zy(d1[jl], "暗巷闪光", false, false, "10012", -1, -1)))
                accumulateValue("10012",d1[jl]);
        }
    }
    public void 辰砂之纺锤(int jl) {
        double[] d1 = new double[]{0.4, 0.50, 0.6, 0.7, 0.8};
        if (flag == 0) {
            if (!obj_calculator.addZy(new Zy(obj_calculator.getFyl(0)*d1[jl], "辰砂之纺锤", false, false, "10023", -1, -1)))
                accumulateValue("10023",obj_calculator.getFyl(0)*d1[jl]);
        }
    }
    public void 西风秘典(int jl) {

    }
    public void 西风大剑(int jl) {

    }
    public void 西风猎弓(int jl) {

    }
    public void 西风长枪(int jl) {

    }
    public void 宗室秘法录(int jl) {
        double[] d1 = new double[]{0.08, 0.1, 0.12, 0.14, 0.16};
        if (flag == 0) {
            if (!obj_calculator.addZy(new Zy(d1[jl], "宗室秘法录", false, false, "20", -1, -1)))
                accumulateValue("20",d1[jl]);
        }
    }
    public void 宗室大剑(int jl) {
        double[] d1 = new double[]{0.08, 0.1, 0.12, 0.14, 0.16};
        if (flag == 0) {
            if (!obj_calculator.addZy(new Zy(d1[jl], "宗室大剑", false, false, "20", -1, -1)))
                accumulateValue("20",d1[jl]);
        }
    }
    public void 宗室长弓(int jl) {
        double[] d1 = new double[]{0.08, 0.1, 0.12, 0.14, 0.16};
        if (flag == 0) {
            if (!obj_calculator.addZy(new Zy(d1[jl], "宗室长弓", false, false, "20", -1, -1)))
                accumulateValue("20",d1[jl]);
        }
    }
    public void 宗室猎枪(int jl) {
        double[] d1 = new double[]{0.08, 0.1, 0.12, 0.14, 0.16};
        if (flag == 0) {
            if (!obj_calculator.addZy(new Zy(d1[jl], "宗室猎枪", false, false, "20", -1, -1)))
                accumulateValue("20",d1[jl]);
        }
    }
    public void 祭礼剑(int jl) {

    }
    public void 祭礼大剑(int jl) {

    }
    public void 祭礼弓(int jl) {

    }
    public void 祭礼残章(int jl) {

    }
    public void 黑岩刺枪(int jl) {
        double[] d1 = new double[]{0.12, 0.15, 0.18, 0.21, 0.24};
        if (flag == 0) {
            if (!obj_calculator.addZy(new Zy(d1[jl]*3, "黑岩刺枪", false, false, "6", -1, -1)))
                accumulateValue("6",d1[jl]*3);
        }
    }
    public void 黑岩绯玉(int jl) {
        double[] d1 = new double[]{0.12, 0.15, 0.18, 0.21, 0.24};
        if (flag == 0) {
            if (!obj_calculator.addZy(new Zy(d1[jl]*3, "黑岩绯玉", false, false, "6", -1, -1)))
                accumulateValue("6",d1[jl]*3);
        }
    }

    public void 黑岩战弓(int jl) {
        double[] d1 = new double[]{0.12, 0.15, 0.18, 0.21, 0.24};
        if (flag == 0) {
            if (!obj_calculator.addZy(new Zy(d1[jl]*3, "黑岩战弓", false, false, "6", -1, -1)))
                accumulateValue("6",d1[jl]*3);
        }
    }

    public void 黑岩斩刀(int jl) {
        double[] d1 = new double[]{0.12, 0.15, 0.18, 0.21, 0.24};
        if (flag == 0) {
            if (!obj_calculator.addZy(new Zy(d1[jl]*3, "黑岩斩刀", false, false, "6", -1, -1)))
                accumulateValue("6",d1[jl]*3);
        }
    }
    public void 试作斩岩(int jl) {
        double[] d1 = new double[]{0.04, 0.05, 0.06, 0.07, 0.08};
        if (flag == 0) {
            if (!obj_calculator.addZy(new Zy(d1[jl]*4, "试作斩岩_1", false, false, "6", -1, -1)))
                accumulateValue("6",d1[jl]*4);
            if (!obj_calculator.addZy(new Zy(d1[jl]*4, "试作斩岩_2", false, false, "9", -1, -1)))
                accumulateValue("9",d1[jl]*4);
        }
    }
    public void 试作星镰(int jl) {
        double[] d1 = new double[]{0.04, 0.05, 0.06, 0.07, 0.08};
        if (flag == 0) {
            if (!obj_calculator.addZy(new Zy(d1[jl]*4, "试作斩岩_1", false, false, "6", -1, -1)))
                accumulateValue("6",d1[jl]*4);
            if (!obj_calculator.addZy(new Zy(d1[jl]*4, "试作斩岩_2", false, false, "9", -1, -1)))
                accumulateValue("9",d1[jl]*4);
        }
    }
    public void 试作金珀(int jl) {
        double[] d1 = new double[]{0.04, 0.05, 0.06, 0.07, 0.08};
        if (flag == 0) {
            if (!obj_calculator.addZy(new Zy(d1[jl]*4, "试作金珀_1", false, false, "6", -1, -1)))
                accumulateValue("6",d1[jl]*4);
            if (!obj_calculator.addZy(new Zy(d1[jl]*4, "试作金珀_2", false, false, "9", -1, -1)))
                accumulateValue("9",d1[jl]*4);
        }
    }
    public void 试作澹月(int jl) {
        double[] d1 = new double[]{0.04, 0.05, 0.06, 0.07, 0.08};
        if (flag == 0) {
            if (!obj_calculator.addZy(new Zy(d1[jl]*4, "试作斩岩_1", false, false, "6", -1, -1)))
                accumulateValue("6",d1[jl]*4);
            if (!obj_calculator.addZy(new Zy(d1[jl]*4, "试作斩岩_2", false, false, "9", -1, -1)))
                accumulateValue("9",d1[jl]*4);
        }
    }
    public void 试作古华(int jl) {

    }

    public void 钟剑(int jl) {
        double[] d1 = new double[]{0.12, 0.15, 0.18, 0.21, 0.24};
        if (flag == 0) {
            if (!obj_calculator.addZy(new Zy(d1[jl], "钟剑", false, false, "10012", -1, -1)))
                accumulateValue("10012",d1[jl]);
        }
    }
    public void 雪葬的星银(int jl) {

    }

    public void 绝弦(int jl) {
        double[] d1 = new double[]{0.24, 0.30, 0.36, 0.42, 0.48};
        if (flag == 0) {
            if (!obj_calculator.addZy(new Zy(d1[jl], "绝弦_1", false, false, "10003", -1, -1)))
                accumulateValue("10003",d1[jl]);
            if (!obj_calculator.addZy(new Zy(d1[jl], "绝弦_2", false, false, "10002", -1, -1)))
                accumulateValue("10002",d1[jl]);
        }
    }
    public void 苍翠猎弓(int jl) {

    }
    public void 幽夜华尔兹(int jl) {
        double[] d1 = new double[]{0.2, 0.25, 0.3, 0.35, 0.4};
        if (flag == 0) {
            if (!obj_calculator.addZy(new Zy(d1[jl], "幽夜华尔兹_1", false, false, "10001", -1, -1)))
                accumulateValue("10001",d1[jl]);
            if (!obj_calculator.addZy(new Zy(d1[jl], "幽夜华尔兹_2", false, false, "10002", -1, -1)))
                accumulateValue("10002",d1[jl]);
        }
    }
    public void 笛剑(int jl) {

    }

    public void 黑剑(int jl) {
        double[] d1 = new double[]{0.2, 0.25, 0.3, 0.35, 0.4};
        if (flag == 0) {
            if (!obj_calculator.addZy(new Zy(d1[jl], "黑剑_1", false, false, "10001", -1, -1)))
                accumulateValue("10001",d1[jl]);
            if (!obj_calculator.addZy(new Zy(d1[jl], "黑剑_2", false, false, "10015", -1, -1)))
                accumulateValue("10015",d1[jl]);
        }
    }

    public void 流浪乐章(int jl) {
        double[] d1 = new double[]{0.48, 0.60, 0.72, 0.84, 0.96};
        if (flag == 0) {
            if (!obj_calculator.addZy(new Zy(d1[jl], "流浪乐章_1", false, false, obj_calculator.ys_key, -1, -1)))
                accumulateValue(obj_calculator.ys_key,d1[jl]);
        }
    }

    public void 暗巷的诗与酒(int jl) {
        double[] d1 = new double[]{0.2, 0.25, 0.3, 0.35, 0.40};
        if (flag == 0) {
            if (!obj_calculator.addZy(new Zy(d1[jl], "暗巷的诗与酒", false, false, "6", -1, -1)))
                accumulateValue("6",d1[jl]);
        }
    }

    public void 嘟嘟可故事集(int jl) {
        double[] d1 = new double[]{0.16, 0.2, 0.24, 0.28, 0.32};
        double[] d2 = new double[]{0.08, 0.10, 0.12, 0.14, 0.16};
        if (flag == 0) {
            if (!obj_calculator.addZy(new Zy(d1[jl], "嘟嘟可故事集_1", false, false, "10015", -1, -1)))
                accumulateValue("10015",d1[jl]);
            if (!obj_calculator.addZy(new Zy(d2[jl], "嘟嘟可故事集_2", false, false, "6", -1, -1)))
                accumulateValue("6",d2[jl]);
        }
    }
    public void 决斗之枪(int jl) {
        double[] d1 = new double[]{0.24,0.3,0.36,0.42,0.48};
        if (flag == 0) {
            if (!obj_calculator.addZy(new Zy(d1[jl], "决斗之枪", false, false, "6", -1, -1)))
                accumulateValue("6",d1[jl]);
        }
    }
    public void 龙脊长枪(int jl) {

    }
    public void 风信之锋(int jl) {
        double[] d1 = new double[]{0.12, 0.15, 0.18, 0.21, 0.24};
        double[] d2 = new double[]{48,60,72,84,96};
        if (flag == 0) {
            if (!obj_calculator.addZy(new Zy(d2[jl], "风信之锋_1", false, false, "28", -1, -1)))
                accumulateValue("28",d2[jl]);
            if (!obj_calculator.addZy(new Zy(d1[jl], "风信之锋_2", false, false, "6", -1, -1)))
                accumulateValue("6",d1[jl]);
        }
    }
    public void 腐殖之剑(int jl) {
        double[] d1 = new double[]{0.16, 0.2, 0.24, 0.28, 0.32};
        double[] d2 = new double[]{0.06,0.075,0.09,0.105,0.12};
        if (flag == 0) {
            if (!obj_calculator.addZy(new Zy(d1[jl], "腐殖之剑_1", false, false, "10002", -1, -1)))
                accumulateValue("10002",d1[jl]);
            if (!obj_calculator.addZy(new Zy(d2[jl], "腐殖之剑_2", false, false, "10027", -1, -1)))
                accumulateValue("10027",d2[jl]);
        }
    }

    public void 忍冬之果(int jl) {

    }

    public void 风花之颂(int jl) {
        double[] d1 = new double[]{0.16,0.2,0.240,0.28,0.21};
        if (flag == 0) {
            if (!obj_calculator.addZy(new Zy(d1[jl], "风花之颂", false, false, "6", -1, -1)))
                accumulateValue("6",d1[jl]);
        }
    }

    public void 暗巷猎手(int jl) {
        double[] d1 = new double[]{0.2,0.25,0.3,0.35,0.4};
        if (flag == 0) {
            if (!obj_calculator.addZy(new Zy(d1[jl], "暗巷猎手", false, false, "10012", -1, -1)))
                accumulateValue("10012",d1[jl]);
        }
    }

    public void 玛海菈的水色(int jl) {
        double[] d1 = new double[]{0.24,0.3,0.36,0.42,0.48};
        if (flag == 0) {
            if (!obj_calculator.addZy(new Zy(d1[jl]* obj_calculator.getYsjt(1), "玛海菈的水色", false, false, "10021", -1, -1)))
                accumulateValue("10021",d1[jl]* obj_calculator.getYsjt(1));
        }
    }
    public void 竭泽(int jl) {

    }
    public void 王下近侍(int jl) {
        double[] d1 = new double[]{60,80,100,120,140};
        if (flag == 0) {
            if (!obj_calculator.addZy(new Zy(d1[jl], "王下近侍", false, false, "28", -1, -1)))
                accumulateValue("28",d1[jl]);
        }
    }

    public void 贯月矢(int jl) {
        double[] d1 = new double[]{0.16,0.2,0.24,0.28,0.32};
        if (flag == 0) {
            if (!obj_calculator.addZy(new Zy(d1[jl], "贯月矢", false, false, "6", -1, -1)))
                accumulateValue("6",d1[jl]);
        }
    }
    public void 盈满之实(int jl) {
        double[] d1 = new double[]{24,27,30,33,36};
        if (flag == 0) {
            if (!obj_calculator.addZy(new Zy(-0.25, "盈满之实_1", false, false, "6", -1, -1)))
                accumulateValue("6",-0.25);
            if (!obj_calculator.addZy(new Zy(d1[jl]*5, "盈满之实_2", false, false, "28", -1, -1)))
                accumulateValue("28",d1[jl]*5);
        }
    }

    public void 流浪的晚星(int jl) {
        double[] d1 = new double[]{0.24,0.3,0.36,0.42,0.48};
        if (flag == 0) {
            if (!obj_calculator.addZy(new Zy(obj_calculator.getYsfy(1)*d1[jl], "流浪的晚星", false, false, "10021", -1, -1)))
                accumulateValue("10021",obj_calculator.getYsfy(1)*d1[jl]);
        }
    }
    public void 西福斯的月光(int jl) {
        double[] d1 = new double[]{0.00036,0.00045,0.00054,0.00063,0.00072};
        if (flag == 0) {
            if (!obj_calculator.addZy(new Zy(obj_calculator.getYsfy(1)*d1[jl], "西福斯的月光", false, false, "10017", -1, -1)))
                accumulateValue("10017",obj_calculator.getYsfy(1)*d1[jl]);
        }
    }
    public void 森林王器(int jl) {
        double[] d1 = new double[]{60,75,90,105,120};
        if (flag == 0) {
            if (!obj_calculator.addZy(new Zy(d1[jl], "森林王器", false, false, "28", -1, -1)))
                accumulateValue("28",d1[jl]);
        }
    }
    public void 原木刀(int jl) {
        double[] d1 = new double[]{60,75,90,105,120};
        if (flag == 0) {
            if (!obj_calculator.addZy(new Zy(d1[jl], "原木刀", false, false, "28", -1, -1)))
                accumulateValue("28",d1[jl]);
        }
    }
    public void 断浪长鳍(int jl) {
        double[] d1 = new double[]{0.4,0.5,0.6,0.7,0.8};
        if (flag == 0) {
            if (!obj_calculator.addZy(new Zy(d1[jl], "断浪长鳍", false, false, "10003", -1, -1)))
                accumulateValue("10003",d1[jl]);
        }
    }
    public void 渔获 (int jl) {
        double[] d1 = new double[]{0.16,0.20,0.24,0.28,0.32};
        double[] d2 = new double[]{0.06,0.075,0.09,0.105,0.12};
        if (flag == 0) {
            if (!obj_calculator.addZy(new Zy(d1[jl], "渔获", false, false, "10003", -1, -1)))
                accumulateValue("10003",d1[jl]);
            if (!obj_calculator.addZy(new Zy(d2[jl], "渔获2", false, false, "10028", -1, -1)))
                accumulateValue("10028",d2[jl]);
        }
    }

    public void 喜多院十文字 (int jl) {
        double[] d2 = new double[]{0.06,0.075,0.09,0.105,0.12};
        if (flag == 0) {
            if (!obj_calculator.addZy(new Zy(d2[jl], "喜多院十文字", false, false, "10002", -1, -1)))
                accumulateValue("10002",d2[jl]);
        }
    }

    public void 笼钓瓶一心 (int jl) {
    }
    public void 曚云之月(int jl) {
        double[] d1 = new double[]{0.4,0.5,0.6,0.7,0.8};
        if (flag == 0) {
            if (!obj_calculator.addZy(new Zy(d1[jl], "曚云之月", false, false, "10003", -1, -1)))
                accumulateValue("10003",d1[jl]);
        }
    }

    public void 破魔之弓 (int jl) {
        double[] d1 = new double[]{0.16,0.2,0.24,0.28,0.32};
        double[] d2 = new double[]{0.12,0.15,0.18,0.21,0.24};
        if (flag == 0) {
            if (!obj_calculator.addZy(new Zy(d1[jl]*2, "破魔之弓_1", false, false, "10001", -1, -1)))
                accumulateValue("10001",d1[jl]*2);
            if (!obj_calculator.addZy(new Zy(d2[jl]*2, "破魔之弓_2", false, false, "10015", -1, -1)))
                accumulateValue("10015",d2[jl]*2);
        }
    }

    public void 桂木斩长正 (int jl) {
        double[] d2 = new double[]{0.06,0.075,0.09,0.105,0.12};
        if (flag == 0) {
            if (!obj_calculator.addZy(new Zy(d2[jl], "桂木斩长正", false, false, "10002", -1, -1)))
                accumulateValue("10002",d2[jl]);
        }
    }

    public void 白辰之环 (int jl) {
        double[] d2 = new double[]{0.1,0.125,0.15,0.175,0.2};
        if (flag == 0) {
            if (!obj_calculator.addZy(new Zy(d2[jl], "白辰之环", false, false, "10033", -1, -1)))
                accumulateValue("10033",d2[jl]);
        }
    }
    public void 匣里龙吟 (int jl) {
        double[] d2 = new double[]{0.20,0.24,0.28,0.32,0.36};
        if (flag == 0) {
            if (!obj_calculator.addZy(new Zy(d2[jl], "匣里龙吟", false, false, "10012", -1, -1)))
                accumulateValue("10012",d2[jl]);
        }
    }
    public void 白影剑 (int jl) {
        double[] d2 = new double[]{0.06,0.75,0.09,0.105,0.12};
        if (flag == 0) {
            if (!obj_calculator.addZy(new Zy(d2[jl]*4, "白影剑_1", false, false, "6", -1, -1)))
                accumulateValue("6",d2[jl]*4);
            if (!obj_calculator.addZy(new Zy(d2[jl]*4, "白影剑_2", false, false, "9", -1, -1)))
                accumulateValue("9",d2[jl]*4);
        }
    }
    public void 千岩古剑 (int jl) {
        double[] d1 = new double[]{0.03,0.04,0.05,0.06,0.07};
        double[] d2 = new double[]{0.07,0.08,0.09,0.1,0.11};
        if (flag == 0) {
            if (!obj_calculator.addZy(new Zy(d2[jl]*4, "千岩古剑_1", false, false, "6", -1, -1)))
                accumulateValue("6",d2[jl]*4);
            if (!obj_calculator.addZy(new Zy(d1[jl]*4, "千岩古剑_2", false, false, "20", -1, -1)))
                accumulateValue("20",d1[jl]*4);
        }
    }

    public void 千岩长枪 (int jl) {
        double[] d1 = new double[]{0.03,0.04,0.05,0.06,0.07};
        double[] d2 = new double[]{0.07,0.08,0.09,0.1,0.11};
        if (flag == 0) {
            if (!obj_calculator.addZy(new Zy(d2[jl]*4, "千岩长枪_1", false, false, "6", -1, -1)))
                accumulateValue("6",d2[jl]*4);
            if (!obj_calculator.addZy(new Zy(d1[jl]*4, "千岩长枪_2", false, false, "20", -1, -1)))
                accumulateValue("20",d1[jl]*4);
        }
    }

    public void 匣里日月 (int jl) {
        double[] d1 = new double[]{0.2,0.25,0.3,0.35,0.4};
        if (flag == 0) {
            if (!obj_calculator.addZy(new Zy(d1[jl], "匣里日月_1", false, false, "10001", -1, -1)))
                accumulateValue("10001",d1[jl]);
            if (!obj_calculator.addZy(new Zy(d1[jl], "匣里日月_2", false, false, "10002", -1, -1)))
                accumulateValue("10002",d1[jl]);
            if (!obj_calculator.addZy(new Zy(d1[jl], "匣里日月_2", false, false, "10003", -1, -1)))
                accumulateValue("10003",d1[jl]);
        }
    }

    public void 弓藏 (int jl) {
        double[] d1 = new double[]{0.4,0.5,0.6,0.7,0.8};
        if (flag == 0) {
            if (!obj_calculator.addZy(new Zy(d1[jl], "弓藏", false, false, "10001", -1, -1)))
                accumulateValue("10001",d1[jl]);

        }
    }

    public void 流月针 (int jl) {
        double[] d1 = new double[]{0.2,0.25,0.3,0.35,0.4};
        if (flag == 0) {
            if (!obj_calculator.addZy(new Zy(obj_calculator.getGj(1)* d1[jl], "流月针_1", false, false, "10022", -1, -1)))
                accumulateValue("10022",obj_calculator.getGj(1)* d1[jl]);
            if (!obj_calculator.addZy(new Zy(obj_calculator.getGj(1)* d1[jl], "流月针_2", false, false, "10025", -1, -1)))
                accumulateValue("10025",obj_calculator.getGj(1)* d1[jl]);
        }
    }

    public void 雨裁 (int jl) {
        double[] d2 = new double[]{0.20,0.24,0.28,0.32,0.36};
        if (flag == 0) {
            if (!obj_calculator.addZy(new Zy(d2[jl], "雨裁", false, false, "10012", -1, -1)))
                accumulateValue("10012",d2[jl]);
        }
    }


    public void 匣里灭辰 (int jl) {
        double[] d2 = new double[]{0.20,0.24,0.28,0.32,0.36};
        if (flag == 0) {
            if (!obj_calculator.addZy(new Zy(d2[jl], "匣里灭辰", false, false, "10012", -1, -1)))
                accumulateValue("10012",d2[jl]);
        }
    }
    public void 昭心 (int jl) {

    }

    public void 螭骨剑 (int jl) {
        double[] d2 = new double[]{0.06,0.07,0.08,0.09,0.1};
        if (flag == 0) {
            if (!obj_calculator.addZy(new Zy(d2[jl]*5, "螭骨剑", false, false, "10012", -1, -1)))
                accumulateValue("10012",d2[jl]*5);
        }
    }
    public void 衔珠海皇 (int jl) {
        double[] d2 = new double[]{0.12,0.15,0.18,0.21,0.24};
        if (flag == 0) {
            if (!obj_calculator.addZy(new Zy(d2[jl], "衔珠海皇", false, false, "10003", -1, -1)))
                accumulateValue("10003",d2[jl]);
        }
    }

    public void 万国诸海图谱 (int jl) {
        double[] d2 = new double[]{0.08,0.1,0.12,0.14,0.16};
        if (flag == 0) {
            if (!obj_calculator.addZy(new Zy(d2[jl]*2, "万国诸海图谱", false, false, "10033", -1, -1)))
                accumulateValue("10033",d2[jl]*2);
        }
    }
    public void 钢轮弓 (int jl) {
        double[] d2 = new double[]{0.04,0.05,0.06,0.07,0.08};
        if (flag == 0) {
            if (!obj_calculator.addZy(new Zy(d2[jl]*4, "钢轮弓", false, false, "6", -1, -1)))
                accumulateValue("6",d2[jl]*4);
        }
    }
    public void 落霞 (int jl) {
        double[] d2 = new double[]{0.14,0.175,0.21,0.245,0.28};
        if (flag == 0) {
            if (!obj_calculator.addZy(new Zy(d2[jl], "落霞", false, false, "10012", -1, -1)))
                accumulateValue("10012",d2[jl]);
        }
    }
    public void 天目影打刀 (int jl) {

    }
    public void 恶王丸(int jl) {
        double[] d1 = new double[]{0.4,0.5,0.6,0.7,0.8};
        if (flag == 0) {
            if (!obj_calculator.addZy(new Zy(d1[jl], "恶王丸", false, false, "10003", -1, -1)))
                accumulateValue("10003",d1[jl]);
        }
    }
    public void 证誓之明瞳(int jl) {
        double[] d1 = new double[]{0.24,0.3,0.36,0.42,0.48};
        if (flag == 0) {
            if (!obj_calculator.addZy(new Zy(d1[jl], "证誓之明瞳", false, false, "23", -1, -1)))
                accumulateValue("23",d1[jl]);
        }
    }


    public void 冷刃 (int jl) {
        double[] d2 = new double[]{0.12,0.15,0.18,0.21,0.24};
        if (flag == 0) {
            if (!obj_calculator.addZy(new Zy(d2[jl], "冷刃", false, false, "10012", -1, -1)))
                accumulateValue("10012",d2[jl]);
        }
    }
    public void 铁影阔剑 (int jl) {
        double[] d2 = new double[]{0.3,0.35,0.4,0.45,0.5};
        if (flag == 0) {
            if (!obj_calculator.addZy(new Zy(d2[jl], "铁影阔剑", false, false, "10015", -1, -1)))
                accumulateValue("10015",d2[jl]);
        }
    }

    public void 魔导绪论 (int jl) {
        double[] d2 = new double[]{0.12,0.15,0.18,0.21,0.24};
        if (flag == 0) {
            if (!obj_calculator.addZy(new Zy(d2[jl], "魔导绪论", false, false, "10012", -1, -1)))
                accumulateValue("10012",d2[jl]);
        }
    }
    public void 鸦羽弓 (int jl) {
        double[] d2 = new double[]{0.12,0.15,0.18,0.21,0.24};
        if (flag == 0) {
            if (!obj_calculator.addZy(new Zy(d2[jl], "鸦羽弓", false, false, "10012", -1, -1)))
                accumulateValue("10012",d2[jl]);
        }
    }

    public void 黎明神剑 (int jl) {
        double[] d2 = new double[]{0.14,0.175,0.21,0.245,0.28};
        if (flag == 0) {
            if (!obj_calculator.addZy(new Zy(d2[jl], "黎明神剑", false, false, "20", -1, -1)))
                accumulateValue("20",d2[jl]);
        }
    }
    public void 讨龙英杰谭 (int jl) {

    }

    public void 旅行剑 (int jl) {

    }

    public void 异世界旅行记 (int jl) {

    }

    public void 反曲弓 (int jl) {

    }

    public void 沐浴龙血的剑 (int jl) {
        double[] d2 = new double[]{0.12,0.15,0.18,0.21,0.24};
        if (flag == 0) {
            if (!obj_calculator.addZy(new Zy(d2[jl], "沐浴龙血的剑", false, false, "10012", -1, -1)))
                accumulateValue("10012",d2[jl]);
        }
    }
    public void 神射手之誓 (int jl) {

    }
    public void 黑缨枪 (int jl) {

    }

    public void 飞天大御剑 (int jl) {
        double[] d2 = new double[]{0.06,0.07,0.08,0.09,0.1};
        if (flag == 0) {
            if (!obj_calculator.addZy(new Zy(d2[jl]*4, "飞天大御剑", false, false, "6", -1, -1)))
                accumulateValue("6",d2[jl]*4);
        }
    }
    public void 飞天御剑 (int jl) {
        double[] d2 = new double[]{0.12,0.15,0.18,0.21,0.24};
        if (flag == 0) {
            if (!obj_calculator.addZy(new Zy(d2[jl]*4, "飞天御剑", false, false, "6", -1, -1)))
                accumulateValue("6",d2[jl]*4);
        }
    }
    public void 信使 (int jl) {

    }


    public void 暗铁剑 (int jl) {
        double[] d2 = new double[]{0.2,0.25,0.3,0.35,0.4};
        if (flag == 0) {
            if (!obj_calculator.addZy(new Zy(d2[jl], "暗铁剑", false, false, "6", -1, -1)))
                accumulateValue("6",d2[jl]);
        }
    }
    public void 翡玉法球 (int jl) {
        double[] d2 = new double[]{0.2,0.25,0.3,0.35,0.4};
        if (flag == 0) {
            if (!obj_calculator.addZy(new Zy(d2[jl], "翡玉法球", false, false, "6", -1, -1)))
                accumulateValue("6",d2[jl]);
        }
    }

    public void 弹弓 (int jl) {
        double[] d2 = new double[]{0.36,0.42,0.48,0.54,0.6};
        if (flag == 0) {
            if (!obj_calculator.addZy(new Zy(d2[jl], "弹弓", false, false, "10015", -1, -1)))
                accumulateValue("10015",d2[jl]);
        }
    }

    public void 白缨枪 (int jl) {
        double[] d2 = new double[]{0.24,0.3,0.36,0.42,0.48};
        if (flag == 0) {
            if (!obj_calculator.addZy(new Zy(d2[jl], "白缨枪", false, false, "10001", -1, -1)))
                accumulateValue("10001",d2[jl]);
        }
    }
    public void 吃虎鱼刀 (int jl) {

    }
    public void 以理服人 (int jl) {

    }

    public void 甲级宝珏 (int jl) {
        double[] d2 = new double[]{0.12,0.14,0.16,0.18,0.2};
        if (flag == 0) {
            if (!obj_calculator.addZy(new Zy(d2[jl], "甲级宝珏", false, false, "6", -1, -1)))
                accumulateValue("6",d2[jl]);
        }
    }


    public void 铁蜂刺 (int jl) {
        double[] d2 = new double[]{0.06,0.075,0.09,0.105,0.12};
        if (flag == 0) {
            if (!obj_calculator.addZy(new Zy(d2[jl]*2, "铁蜂刺", false, false, "10012", -1, -1)))
                accumulateValue("10012",d2[jl]*2);
        }
    }

}
