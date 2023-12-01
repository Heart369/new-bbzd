package com.example.main.raw.DataClass;

public class WordData {
    String name;
    int tsd,img_bd,img_tb;

    public WordData(String name, int tsd) {
        this.name = name;
        this.tsd = tsd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTsd() {
        return tsd;
    }

    public void setTsd(int tsd) {
        this.tsd = tsd;
    }

    public int getImg_bd() {
        return img_bd;
    }

    public void setImg_bd(int img_bd) {
        this.img_bd = img_bd;
    }

    public int getImg_tb() {
        return img_tb;
    }

    public void setImg_tb(int img_tb) {
        this.img_tb = img_tb;
    }
}
