package com.example.main.mvvm.calculator.tool;


import java.util.*;

public class Enemy {

    Map<String,Double> gw=new HashMap<>();

    String zt;
    // 定义各种元素类型的常量
    public static final int ELEMENT_FIRE = 0;//火
    public static final int ELEMENT_WATER = 1;//水
    public static final int ELEMENT_C = 2;//草
    public static final int ELEMENT_ICE = 3;//冰
    public static final int ELEMENT_L = 4;//雷
    public static final int ELEMENT_Y = 5;//岩
    public static final int ELEMENT_WIND = 6;//风

    public static final int ELEMENT_J = 7;//激


    // 定义各种元素反应的常量
    public static final int REACTION_NONE = -1;  // 无反应
    public static final int REACTION_OVERLOAD = 0;  // 超载
    public static final int REACTION_BURNING = 1;  // 燃烧
    public static final int REACTION_MELT = 2;  // 融化
    public static final int REACTION_VAPORIZE = 3;  // 蒸发
    public static final int REACTION_FREEZE = 4;  // 冻结
    public static final int REACTION_SUPERCONDUCT = 5;  // 超导
    public static final int REACTION_ELECTROCHARGED = 6;  // 感电
    public static final int REACTION_SWIRL = 7;  // 扩散
    public static final int REACTION_CRYSTALLIZE = 8;  // 结晶
    public static final int REACTION_ZF = 9;  // 绽放
    public static final int REACTION_MJH = 10;  // 蔓激化
    public static final int REACTION_CJH = 11;  // 超激化

    double lower=0;
    double time=0;
    // 存储元素附着状态
    private int element1;
    private int element2=-1;
    private int content1;
    private int content2=-1;
    private  int element3=-1;//冻元素

    public Enemy(int e1, int e2, int content1, int content2) {
        element1 = e1;
        element2 = e2;
        this.content1=content1;
        this.content2=content2;

    }

    public Enemy(int element1, int content1) {
        this.element1 = element1;
        this.content1 = content1;
        gw.put("等级",85.0);
        gw.put("29",0.1);
        gw.put("30",0.1);
        gw.put("40",0.1);
        gw.put("41",0.1);
        gw.put("42",0.1);
        gw.put("43",0.1);
        gw.put("44",0.1);
        gw.put("45",0.1);
        gw.put("46",0.1);
    }

    public Map<String, Double> getGw() {
        return gw;
    }

    public void setGw(Map<String, Double> gw) {
        this.gw = gw;
    }
    public int getReaction(int element) {
        switch (element) {
            case ELEMENT_FIRE:
                if (element1 == ELEMENT_L || element2 == ELEMENT_L) {
                    return REACTION_OVERLOAD;
                } else if (element1 == ELEMENT_C || element2 == ELEMENT_C) {
                    return REACTION_BURNING;
                } else if (element1 == ELEMENT_ICE || element2 == ELEMENT_ICE) {
                    return REACTION_MELT;
                }
                else if (element1 == ELEMENT_WATER || element2 == ELEMENT_WATER) {
                    return REACTION_VAPORIZE;
                }
                break;
            case ELEMENT_WATER:
                if (element1 == ELEMENT_FIRE || element2 == ELEMENT_FIRE) {
                    return REACTION_VAPORIZE;
                } else if (element1 == ELEMENT_L || element2 == ELEMENT_L) {
                    return REACTION_ELECTROCHARGED;
                } else if (element1 == ELEMENT_ICE || element2 == ELEMENT_ICE) {
                    return REACTION_FREEZE;
                } else if (element1 == ELEMENT_C|| element2 == ELEMENT_C) {
                    return REACTION_ZF;
                }
                break;
            case ELEMENT_C:
                if (element1 == ELEMENT_FIRE || element2 == ELEMENT_FIRE) {
                    return REACTION_BURNING;
                } else if (element1 == ELEMENT_WATER || element2 == ELEMENT_WATER) {
                    return REACTION_ZF;
                }else if (element1 == ELEMENT_J || element2 == ELEMENT_J) {
                    return REACTION_MJH;
                }else if (element1 == ELEMENT_L|| element2 == ELEMENT_L) {
                    element=ELEMENT_J;
                    return -1;
                }
                break;
            case ELEMENT_ICE:
                if (element1 == ELEMENT_FIRE || element2 == ELEMENT_FIRE) {
                    return REACTION_MELT;
                } else if (element1 == ELEMENT_WATER || element2 == ELEMENT_WATER) {
                    return REACTION_FREEZE;
                } else if (element1 == ELEMENT_L || element2 == ELEMENT_L) {
                    return REACTION_SUPERCONDUCT;
                }
                break;
            case ELEMENT_L:
                if (element1 == ELEMENT_FIRE || element2 == ELEMENT_FIRE) {
                    return REACTION_OVERLOAD;
                } else if (element1 == ELEMENT_ICE || element2 == ELEMENT_ICE) {
                    return REACTION_SUPERCONDUCT;
                } else if (element1 == ELEMENT_WATER || element2 == ELEMENT_WATER) {
                    return REACTION_ELECTROCHARGED;
                } else if (element1 == ELEMENT_C || element2 == ELEMENT_C) {
                    element=ELEMENT_J;
                    return -1;
                } else if (element1 == ELEMENT_J || element2 == ELEMENT_J) {
                    return REACTION_CJH;
                }

                break;
            case ELEMENT_Y:
                if (element1 == ELEMENT_FIRE || element2 == ELEMENT_FIRE) {
                    return REACTION_MELT;
                } else if (element1 == ELEMENT_WATER || element2 == ELEMENT_WATER) {
                    return REACTION_CRYSTALLIZE;
                } else if (element1 == ELEMENT_L || element2 == ELEMENT_L) {
                    return REACTION_SWIRL;
                }else if (element1 == ELEMENT_ICE || element2 == ELEMENT_ICE) {
                    return REACTION_SWIRL;
                }
                break;
            case ELEMENT_WIND:
                if (element1 == ELEMENT_FIRE || element2 == ELEMENT_FIRE) {
                    return REACTION_BURNING;
                } else if (element1 == ELEMENT_C || element2 == ELEMENT_C) {
                    return REACTION_SWIRL;
                } else if (element1 == ELEMENT_WATER || element2 == ELEMENT_WATER) {
                    return REACTION_VAPORIZE;
                } else if (element1 == ELEMENT_ICE || element2 == ELEMENT_ICE) {
                    return REACTION_SUPERCONDUCT;
                }
                break;
        }
        return REACTION_NONE;
    }

}
