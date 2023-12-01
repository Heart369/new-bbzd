package com.example.main.raw.DataClass;

public class SywData {
    String image;
    String name;
    int id,id2;
    String tzname,tz1,tz2;


    public SywData(String image, String name, int id, String tzname, String tz1, String tz2,int id2) {
        this.image = image;
        this.name = name;
        this.id = id;
        this.tzname = tzname;
        this.tz1 = tz1;
        this.tz2 = tz2;
        this.id2=id2;
    }

    public String getTzname() {
        return tzname;
    }

    public String getTz1() {
        return tz1;
    }

    public String getTz2() {
        return tz2;
    }

    public String getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getId2() {
        return id2;
    }
}
