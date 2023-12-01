package com.example.main.raw.DataClass;

public class Bqdata {
String sztime,pqtime,sz,wt,pq,bq,zb,zby;
String tfname,wqname,gjname;
int gjimg,wqimg,tfimg;

    public String getTfname() {
        return tfname;
    }

    public void setTfname(String tfname) {
        this.tfname = tfname;
    }

    public String getWqname() {
        return wqname;
    }

    public void setWqname(String wqname) {
        this.wqname = wqname;
    }

    public String getGjname() {
        return gjname;
    }

    public void setGjname(String gjname) {
        this.gjname = gjname;
    }

    public int getGjimg() {
        return gjimg;
    }

    public void setGjimg(int gjimg) {
        this.gjimg = gjimg;
    }

    public int getWqimg() {
        return wqimg;
    }

    public void setWqimg(int wqimg) {
        this.wqimg = wqimg;
    }

    public int getTfimg() {
        return tfimg;
    }

    public void setTfimg(int tfimg) {
        this.tfimg = tfimg;
    }

    public Bqdata(String tfname, String wqname, String gjname, int gjimg, int tfimg, int wqimg) {
        this.tfname = tfname;
        this.wqname = wqname;
        this.gjname = gjname;
        this.gjimg = gjimg;
        this.wqimg = wqimg;
        this.tfimg = tfimg;
    }

    public Bqdata(String sztime, String pqtime, String sz, String wt, String pq, String bq, String zb, String zby) {
        this.sztime = sztime;
        this.pqtime = pqtime;
        this.sz = sz;
        this.wt = wt;
        this.pq = pq;
        this.bq = bq;
        this.zb = zb;
        this.zby = zby;
    }

    public Bqdata() {
    }

    public String getSztime() {
        return sztime;
    }

    public void setSztime(String sztime) {
        this.sztime = sztime;
    }

    public String getPqtime() {
        return pqtime;
    }

    public void setPqtime(String pqtime) {
        this.pqtime = pqtime;
    }

    public String getSz() {
        return sz;
    }

    public void setSz(String sz) {
        this.sz = sz;
    }

    public String getWt() {
        return wt;
    }

    public void setWt(String wt) {
        this.wt = wt;
    }

    public String getPq() {
        return pq;
    }

    public void setPq(String pq) {
        this.pq = pq;
    }

    public String getBq() {
        return bq;
    }

    public void setBq(String bq) {
        this.bq = bq;
    }

    public String getZb() {
        return zb;
    }

    public void setZb(String zb) {
        this.zb = zb;
    }

    public String getZby() {
        return zby;
    }

    public void setZby(String zby) {
        this.zby = zby;
    }
}
