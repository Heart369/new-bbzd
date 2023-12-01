package com.example.main.raw.DataClass;

public class CghData {
    int level,l2,l3,l4;
    String l5;

    public CghData(int level, int l2, int l3, int l4,String l5) {
        this.level = level;
        this.l2 = l2;
        this.l3 = l3;
        this.l4 = l4;
        this.l5=l5;
    }

    public String getL5() {
        return l5;
    }

    public int getLevel() {
        return level;
    }

    public int getL2() {
        return l2;
    }

    public int getL3() {
        return l3;
    }

    public int getL4() {
        return l4;
    }
}
