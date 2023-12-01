package com.example.main.mvvm.calculator.tool;

public class Sh_data {
    String name;
    double[] exp;

    public Sh_data(String name, double[] exp) {
        this.name = name;
        this.exp = exp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double[] getExp() {
        return exp;
    }

    public void setExp(double exp[]) {
        this.exp = exp;
    }
}
