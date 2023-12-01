package com.example.main.mvvm.calculator.tool;

import java.text.DecimalFormat;

public class Syw_data {
    double[] cts;//4个词条分别的词条数
    double[] max;//4个词条分别的单词条最大值
    int[] color;//4个词条数分别对应的优先级1金色，2白色，0默认色
    double zpf;//总评分
    double zct;//总词条不取整

    public int[] getColor() {
        return color;
    }

    public double getZpf() {
        return zpf;
    }
    public String getzpf(){

        DecimalFormat df = new DecimalFormat("#.#");
        return df.format(zpf);
    }
    public Syw_data(double[] cts, double[] max, double zpf, int[] colors) {
        this.cts = cts;
        this.max = max;
        this.zpf=zpf;
        this.color=colors;
    }

    public double[] getCts() {
        return cts;
    }

    public double[] getMax() {
        return max;
    }
}

