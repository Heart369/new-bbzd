package com.example.main.raw.ys_bk;

public class syw_data {
    String id,name,TAG;
    int start;

    public syw_data(String id, String name, String TAG, int start) {
        this.id = id;
        this.name = name;
        this.TAG = TAG;
        this.start = start;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTAG() {
        return TAG;
    }

    public int getStart() {
        return start;
    }
}
