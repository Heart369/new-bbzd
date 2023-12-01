package com.example.main.raw.ys_bk;

public class js_data {
    String name,image1,icon,wq,element,region;
    int star;

    public js_data(String name, String image1, String icon, String wq, String element, String region, int star) {
        this.name = name;
        this.image1 = image1;
        this.icon = icon;
        this.wq = wq;
        this.element = element;
        this.region = region;
        this.star = star;
    }

    public String getName() {
        return name;
    }

    public String getImage1() {
        return image1;
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

    public String getElement() {
        return element;
    }

    public String getRegion() {
        return region;
    }
}
