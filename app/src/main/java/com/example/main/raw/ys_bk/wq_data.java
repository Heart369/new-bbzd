package com.example.main.raw.ys_bk;

public class wq_data {
    String name,icon,wq;
    int star;

    public wq_data(String name, String icon, String wq, int star) {
        this.name = name;
        this.icon = icon;
        this.wq = wq;
        this.star = star;
    }

    public String getName() {
        return name;
    }

    public String getIcon() {
        return icon;
    }

    public String getWq() {
        return wq;
    }

    public int getStar() {
        return star;
    }
}
