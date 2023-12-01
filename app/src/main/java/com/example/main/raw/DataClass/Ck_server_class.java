package com.example.main.raw.DataClass;

public class Ck_server_class {
    String name;
    int image,star,lx,back,dt;

    public Ck_server_class(String name, int image, int star, int lx, int back, int dt) {
        this.name = name;
        this.image = image;
        this.star = star;
        this.lx = lx;
        this.back = back;
        this.dt = dt;
    }

    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }

    public int getStar() {
        return star;
    }
    public int getlx(){
        return lx;
    }

    public int getBack() {
        return back;
    }

    public int getDt() {
        return dt;
    }
}
