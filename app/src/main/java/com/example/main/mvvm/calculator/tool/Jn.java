package com.example.main.mvvm.calculator.tool;

public class Jn {
    String lx;
    Zy zy;
    boolean iszy=false;
    boolean js;
    double dex;
    int zs;

    public Jn(String lx, boolean js, double dex,int zs) {
        this.lx = lx;
        this.js = js;
        this.dex = dex;
        this.zs=zs;
    }

    public void setZy(Zy zy) {
        this.zy = zy;
        iszy=true;
    }

    public String getLx() {
        return lx;
    }

    public Zy getZy() {
        return zy;
    }

    public boolean isIszy() {
        return iszy;
    }

    public boolean isJs() {
        return js;
    }
}
