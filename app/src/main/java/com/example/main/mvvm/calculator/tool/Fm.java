package com.example.main.mvvm.calculator.tool;

public class Fm {
    int time;
    int lx; //0-纯附魔,1-3改倍率
    String key; //改什么附魔

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getLx() {
        return lx;
    }

    public void setLx(int lx) {
        this.lx = lx;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Fm(int time, int lx, String key) {
        this.time = time;
        this.lx = lx;
        this.key = key;
    }
}
