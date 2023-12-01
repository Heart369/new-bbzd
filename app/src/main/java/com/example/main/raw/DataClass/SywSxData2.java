package com.example.main.raw.DataClass;

import java.util.Locale;

public class SywSxData2 {
    String name;
    Double exp;
    int cts;
    int b;
    Double exp2;



    public double getExp2() {
        return exp2;
    }

    public void setExp2(double exp2) {
        this.exp2 = exp2;
    }

    public SywSxData2(String name, Double exp, int cts, int b) {
        this.name = name;
        this.exp = exp;
        this.cts = cts;
        this.b = b;
    }

    public String exp3() {
        if (exp2==null)
            return "无中生有";
        if (b == 1)
            return exp2.toString();
        else
            return String.format(Locale.US, "%.1f%%", exp2);
    }

    public String exp2() {
        if (b == 1)
            return exp.toString();
        else
            return String.format(Locale.US, "%.1f%%", exp);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getExp() {
        return exp;
    }

    public void setExp(Double exp) {
        this.exp = exp;
    }

    public int getCts() {
        return cts;
    }

    public void setCts(int cts) {
        this.cts = cts;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }
}
