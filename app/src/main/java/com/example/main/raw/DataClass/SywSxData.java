package com.example.main.raw.DataClass;

public class SywSxData {
    double exp;
    String mainname;
    int b;


    public SywSxData(double exp, String mainname,int b) {
        this.exp = exp;
        this.mainname = mainname;
        this.b=b;
    }

    public double getExp() {
        return exp;
    }

    public String getMainname() {
        return mainname;
    }

    public int getB() {
        return b;
    }

    public void setExp(Double exp) {
        this.exp = exp;
    }

    public void setMainname(String mainname) {
        this.mainname = mainname;
    }

    public void setB(int b) {
        this.b = b;
    }
}
