package com.example.main.mvvm.calculator.tool;

public class Zy {
    double dex;//数值
    String name;//增益名称
    boolean qj;//是否为全局增益
    boolean kx;//如果是全局增益是否包含自己
    String key;//给到的具体key
    double time,time_end;


    public void setDex(double dex) {
        this.dex = dex;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public double getTime_end() {
        return time_end;
    }

    public void setTime_end(double time_end) {
        this.time_end = time_end;
    }

    public Zy(double dex, String name, boolean qj, boolean kx, String key, double time, double time_end) {
        this.dex = dex;
        this.name = name;
        this.qj = qj;
        this.kx = kx;
        this.key = key;
        this.time = time;
        this.time_end = time_end;
    }

    public String getKey() {
        return key;
    }

    public boolean isKx() {
        return kx;
    }

    public void setKx(boolean kx) {
        this.kx = kx;
    }

    public double getDex() {
        return dex;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isQj() {
        return qj;
    }

    public void setQj(boolean qj) {
        this.qj = qj;
    }
}
