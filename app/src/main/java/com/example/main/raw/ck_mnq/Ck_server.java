package com.example.main.raw.ck_mnq;

import android.util.Log;

import com.example.main.raw.DataClass.Ck_server_class;
import com.example.main.R;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ck_server {
    String name;int lx;
    int num = 0,num2=0;
    int image,star,pool=1;
    double five=0.006,four=0.06;
    double five1=0.007,four1 = 0.06;
    double[] hlb=new double[]{0.066,0.126,0.186,0.246,0.306,0.366,0.426,0.486,0.546,0.606,0.666,0.726,0.786,0.846,0.906,0.966,1};
    double[] wqhlb = new double[]{0.070,0.147,0.217,0.287,0.357,0.427,0.497,0.567,0.637,0.707,0.777,0.812,0.847,0.882,0.917,0.952,0.987,1};
    int cs=0,zcs=0,ccs=0,zzcs=0;
    int n =0;
    int czcs=0,czzcs=0;
    List<Integer> xj;
    List<String> fivename=new ArrayList<>();
    List<Integer> fivecs=new ArrayList<>();
    List<String> czfivename=new ArrayList<>();
    List<Integer> czfivecs=new ArrayList<>();
    List<String> wqfivename=new ArrayList<>();
    List<Integer> wqfivecs=new ArrayList<>();
    List<Integer> xj2;
    int count;
    int chose = 0;

    public void setCount(int count) {
        this.count = count;
    }

    public int getChose() {
        return chose;
    }

    public int getCount() {
        return count;
    }

    public List<String> getCzfivename() {
        return czfivename;
    }

    public int getPool() {
        return pool;
    }

    public List<String> getWqfivename() {
        return wqfivename;
    }

    public List<Integer> getWqfivecs() {
        return wqfivecs;
    }

    public List<Integer> getCzfivecs() {
        return czfivecs;
    }

    public void setChose(int chose) {
        this.chose = chose;
    }

    public void setPool(int pool) {
        this.pool = pool;
    }

    public Ck_server(int pool) {
        this.pool = pool;
    }

    public List<String> getFivename() {
        return fivename;
    }

    public List<Integer> getFivecs() {
        return fivecs;
    }

    public List<Ck_server_class> getten() {
        List<Ck_server_class> data = new ArrayList<>();
        //遍历最高等级和单抽逻辑相同
        if (pool == 1 || pool == 4) {
            for (int i = 0; i < 10; i++) {
                data.add(getone());
            }
            return data;
        } else if (pool == 2) {
            for (int i = 0; i < 10; i++) {
                data.add(getone1());
            }
            return data;

        } else if (pool == 3) {
            for (int i = 0; i < 10; i++) {
                data.add(getone2());

            }
            return data;
        }
        return data;
    }

    public Ck_server_class getone1(){
        List<Integer> xj=getxj(1);
        Ck_server_class csc2 = null;
        int s = xj.get(0);
        if(s==5)
            csc2=  getczfive();
        else if (s==4)
            csc2=  getczfour();
        else
            csc2=  getczthree();
if (csc2.getStar()==5)
    czfivename.add(csc2.getName());
        return csc2;
    }

    public Ck_server_class getone2(){
        List<Integer> xj2=getxj2(1);
        Ck_server_class csc3 = null;
        int s = xj2.get(0);
        if (s==5)
            csc3=  getwqfive();
        else if(s==4)
            csc3=  getwqfour();
        else
            csc3= getwqthree();
        if (csc3.getStar()==5)
            wqfivename.add(csc3.getName());
        return  csc3;
    }
    public Ck_server_class getone(){
        List<Integer> xj=getxj(1);
        Ck_server_class csc = null;
        int s=xj.get(0);
        if (s==5)
            csc=  getfivejs();
        else if(s==4)
            csc=  getfour();
        else
            csc= getthere();

        if (csc.getStar()==5)
            if (pool==2){
              ;
            }else
            fivename.add(csc.getName());
        return  csc;
    }

    public Ck_server(String name, int image, int star ,int lx) {
        this.name = name;
        this.image = image;
        this.star = star;
        this.lx= lx;
    }

    private Ck_server_class getthere() {
        //随机三星
        Ck_server_class rating3 = null;
        int min = 1;
        int max = 13;
        int s = (int)min + (int)(Math.random() * (max - min));
        switch (s){
            case 1:
                rating3 = new Ck_server_class("弹弓",R.drawable.dg_qy,3,R.drawable.wq_gj,R.drawable.back_gj,0);
                break;
            case 2:
                rating3 = new Ck_server_class( "神射手之誓", R.drawable.syszs,3,R.drawable.wq_gj,R.drawable.back_gj,0);
                break;
            case 3:
                rating3 = new Ck_server_class( "鸦羽弓",R.drawable.yyg_qy,3,R.drawable.wq_gj,R.drawable.back_gj,0);
                break;
            case 4:
                rating3 = new Ck_server_class( "翡玉法球",R.drawable.fc,3,R.drawable.wq_fq,R.drawable.back_fq,R.drawable.fc_dt);
                break;
            case 5:
                rating3 = new Ck_server_class( "讨龙英杰谭",R.drawable.tlyjt,3,R.drawable.wq_fq,R.drawable.back_fq,R.drawable.tlyjt_dt);
                break;
            case 6:
                rating3 = new Ck_server_class( "魔导绪论",R.drawable.mdzl,3,R.drawable.wq_fq,R.drawable.back_fq,R.drawable.mdzl_dt);
                break;
            case 7:
                rating3 = new Ck_server_class( "黑缨枪",R.drawable.hyq_qy,3,R.drawable.wq_cb,R.drawable.back_cb,0);
                break;
            case 8:
                rating3 = new Ck_server_class( "以理服人",R.drawable.ylfr,3,R.drawable.wq_dj,R.drawable.back_ssj,0);
                break;
            case 9:
                rating3 = new Ck_server_class( "沐浴龙血的剑",R.drawable.mylxdj,3,R.drawable.wq_dj,R.drawable.back_ssj,0);
                break;
            case 10:
                rating3 = new Ck_server_class( "铁影阔剑",R.drawable.tykj,3,R.drawable.wq_dj,R.drawable.back_ssj,0);
                break;
            case 11:
                rating3 = new Ck_server_class( "飞天御剑",R.drawable.ftdyj,3,R.drawable.wq_dsj,R.drawable.back_dsj,0);
                break;
            case 12:
                rating3 = new Ck_server_class( "黎明神剑",R.drawable.lmsj,3,R.drawable.wq_dsj,R.drawable.back_dsj,0);
                break;
            case 13:
                rating3 = new Ck_server_class( "冷刃",R.drawable.lr,3,R.drawable.wq_dsj,R.drawable.back_dsj,0);
                break;
        }
        return rating3;
    }

    private Ck_server_class getfour() {
        //先随机是否当期角色再随机是谁或者常驻随机，方法自己写
        Ck_server_class rating4 = null;
        Random r = new Random();
        int ss = r.nextInt(2);
        int s1 = r.nextInt(3);
        switch (num){
            case 0:
                if(ss == 1){
                    num++;
                }
                break;
            case 1:
                ss = 0;
                num=0;
                break;
        }
        switch (ss){
            case 0:
                switch (s1){
                    case 0:
                        rating4 = new Ck_server_class("班尼特",R.drawable.bnt_qy,4, R.drawable.ys_h,0,R.drawable.bnt_dt);
                        break;
                    case 1:
                        rating4 = new Ck_server_class("芭芭拉",R.drawable.bbl_qy,4,R.drawable.ys_s,0,R.drawable.bbl_dt);
                        break;
                    case 2:
                        rating4 = new Ck_server_class("科莱",R.drawable.kl_qy,4,R.drawable.ys_c,0,R.drawable.kl_dt);
                        break;
                }
                break;
            case 1:
                rating4 = getczfour();
                do{
                    rating4 = getczfour();
                }while(rating4.getName().equals("班尼特") || rating4.getName().equals("芭芭拉") || rating4.getName().equals("科莱")  || rating4.getName().equals("丽莎")|| rating4.getName().equals("凯亚")
                        || rating4.getName().equals("安柏"));
        }

        return rating4;
    }

    private Ck_server_class getfivejs() {
        //在此实现是当期up还是常驻
        Ck_server_class rating5 = null;
        Random random = new Random();
        int sss = random.nextInt(2);
        Log.d("TAG",sss+","+num);
        switch (num2){
            case 0:
                if(sss == 1){
                    num2++;
                }
                break;
            case 1:
                sss = 0;
                num2 = 0;
        }
        Log.d("TAG",sss+","+num2);
        switch (sss){
            case 0:

                switch (pool) {
                    case 1: rating5 = new Ck_server_class("纳西妲", R.drawable.nxd_lh, 5, R.drawable.ys_c, 0, R.drawable.nxd_dt); break;
                    case 4:rating5 = new Ck_server_class("妮露", R.drawable.nl_lh, 5, R.drawable.ys_s, 0, R.drawable.nl_dt); break;
                }
               break;
            case 1:
                int s= random.nextInt(6);
                switch (s){
                    case 0:
                        rating5 = new Ck_server_class("琴",R.drawable.q_qy,5,R.drawable.ys_f,0,R.drawable.q_dt);break;
                    case 1:
                        rating5 = new Ck_server_class("迪卢克",R.drawable.dlz_qy,5,R.drawable.ys_h,0,R.drawable.dlk_dt);break;
                    case 2:
                        rating5 = new Ck_server_class("提纳里",R.drawable.tnl_qy,5,R.drawable.ys_c,0,R.drawable.tnl_dt);break;
                    case 3:
                        rating5 = new Ck_server_class("七七",R.drawable.qq_qy,5,R.drawable.ys_b,0,R.drawable.qq_dt);break;
                    case 4:
                        rating5 = new Ck_server_class("刻晴",R.drawable.kq_qy,5,R.drawable.ys_l,0,R.drawable.kq_dt);break;
                    case 5:
                        rating5 = new Ck_server_class("莫娜",R.drawable.mn_qy,5,R.drawable.ys_s,0,R.drawable.mn_dt);break;

                }
        }
        return rating5;
    }

    private Ck_server_class getczthree() {
        //常驻角色随机
        return getthere();
    }
    private Ck_server_class getczfour(){
        Ck_server_class rating4 = null;
        int min2= 1;
        int max2= 48;
        int s2  = (int)min2 + (int)(Math.random() * (max2 - min2));
        switch (s2){
            case 1:
                rating4 = new Ck_server_class("珐露珊",R.drawable.fls_qy,4,R.drawable.ys_f,0,R.drawable.fls_dt);
                break;
            case 2:
                rating4 = new Ck_server_class("莱依拉",R.drawable.lyl_qy,4,R.drawable.ys_b,0,R.drawable.lyl_dt);
                break;
            case 3:
                rating4 = new Ck_server_class("坎蒂丝",R.drawable.kds_qy,4,R.drawable.ys_s,0,R.drawable.kds_dt);
                break;
            case 4:
                rating4 = new Ck_server_class("多莉",R.drawable.dl_qy,4,R.drawable.ys_l,0,R.drawable.dl_dt);
                break;
            case 5:
                rating4 = new Ck_server_class("柯莱",R.drawable.kl_qy,4,R.drawable.ys_c,0,R.drawable.kl_dt);
                break;
            case 6:
                rating4 = new Ck_server_class("久岐忍",R.drawable.jqr_qy,4,R.drawable.ys_l,0,R.drawable.jqr_dt);
                break;
            case 7:
                rating4 = new Ck_server_class("云堇",R.drawable.yj_qy,4,R.drawable.ys_y,0,R.drawable.yj_dt);
                break;
            case 8:
                rating4 = new Ck_server_class("鹿野院平藏 ",R.drawable.lyypz_qy,4,R.drawable.ys_f,0,R.drawable.lyypz_dt);
                break;
            case 9:
                rating4 = new Ck_server_class("九条裟罗",R.drawable.jtsl_qy,4,R.drawable.ys_l,0,R.drawable.jt_dt);
                break;
            case 10:
                rating4 = new Ck_server_class("五郎",R.drawable.wl_qy,4,R.drawable.ys_y,0,R.drawable.wl_dt);
                break;
            case 11:
                rating4 = new Ck_server_class("早柚",R.drawable.zy_qy,4,R.drawable.ys_f,0,R.drawable.zy_dt);
                break;
            case 12:
                rating4 = new Ck_server_class("托马",R.drawable.tm_qy,4,R.drawable.ys_h,0,R.drawable.tm_dt);
                break;
            case 13:
                rating4 = new Ck_server_class("烟绯",R.drawable.yf_qy,4,R.drawable.ys_h,0,R.drawable.yf_dt);
                break;
            case 14:
                rating4 = new Ck_server_class("罗莎莉亚",R.drawable.lsly,4,R.drawable.ys_b,0,R.drawable.lsly_dt);
                break;
            case 15:
                rating4 = new Ck_server_class("辛焱",R.drawable.xy_qy,4,R.drawable.ys_h,0,R.drawable.xy_dt);
                break;
            case 16:
                rating4 = new Ck_server_class("砂糖",R.drawable.st_qy,4,R.drawable.ys_f,0,R.drawable.st_dt);
                break;
            case 17:
                rating4 = new Ck_server_class("迪奥娜",R.drawable.dan_qy,4,R.drawable.ys_b,0,R.drawable.dan_dt);
                break;
            case 18:
                rating4 = new Ck_server_class("重云",R.drawable.cy_qy,4,R.drawable.ys_b,0,R.drawable.cy_dt);
                break;
            case 19:
                rating4 = new Ck_server_class("诺艾尔",R.drawable.np_qy,4,R.drawable.ys_y,0,R.drawable.nae_dt);
                break;
            case 20:
                rating4 = new Ck_server_class("班尼特",R.drawable.bnt_qy,4,R.drawable.ys_h,0,R.drawable.bnt_dt);
                break;
            case 21:
                rating4 = new Ck_server_class("菲谢尔",R.drawable.hv_qy,4,R.drawable.ys_l,0,R.drawable.hv_dt);
                break;
            case 22:
                rating4 = new Ck_server_class("香菱",R.drawable.xl_qy,4,R.drawable.ys_h,0,R.drawable.xl_dt);
                break;
            case 23:
                rating4 = new Ck_server_class("雷泽",R.drawable.lz_qy,4,R.drawable.ys_l,0,R.drawable.lz_dt);
                break;
            case 24:
                rating4 = new Ck_server_class("芭芭拉",R.drawable.bbl_qy,4,R.drawable.ys_s,0,R.drawable.bbl_dt);
                break;
            case 25:
                rating4 = new Ck_server_class("弓藏",R.drawable.gz,4,R.drawable.wq_gj,R.drawable.back_gj,0);
                break;
            case 26:
                rating4 = new Ck_server_class("祭礼弓",R.drawable.jlg,4,R.drawable.wq_gj,R.drawable.back_gj,0);
                break;
            case 27:
                rating4 = new Ck_server_class("绝弦",R.drawable.jx,4,R.drawable.wq_gj,R.drawable.back_gj,0);
                break;
            case 28:
                rating4 = new Ck_server_class("西风猎弓 ",R.drawable.xflh,4,R.drawable.wq_gj,R.drawable.back_gj,0);
                break;
            case 29:
                rating4 = new Ck_server_class("昭心",R.drawable.zx,4,R.drawable.wq_fq,R.drawable.back_fq,R.drawable.zx_dt);
                break;
            case 30:
                rating4 = new Ck_server_class("祭礼残章",R.drawable.jlcz,4,R.drawable.wq_fq,R.drawable.back_fq,R.drawable.jlcz_dt);
                break;
            case 31:
                rating4 = new Ck_server_class("流浪乐章",R.drawable.lsyz,4,R.drawable.wq_fq,R.drawable.back_fq,R.drawable.lsyz_dt);
                break;
            case 32:
                rating4 = new Ck_server_class("西风秘典",R.drawable.xfmd,4,R.drawable.wq_fq,R.drawable.wq_fq,R.drawable.xfmd_dt);
                break;
            case 33:
                rating4 = new Ck_server_class("西风长枪",R.drawable.xfcq,4,R.drawable.wq_cb,R.drawable.back_cb,0);
                break;
            case 34:
                rating4 = new Ck_server_class("匣里灭辰",R.drawable.xlmc,4,R.drawable.wq_cb,R.drawable.back_cb,0);
                break;
            case 35:
                rating4 = new Ck_server_class("雨裁",R.drawable.yc,4,R.drawable.wq_dj,R.drawable.back_ssj,0);
                break;
            case 36:
                rating4 = new Ck_server_class("祭礼大剑",R.drawable.jldj,4,R.drawable.wq_dj,R.drawable.back_ssj,0);
                break;
            case 37:
                rating4 = new Ck_server_class("钟剑",R.drawable.zj,4,R.drawable.wq_dj,R.drawable.back_ssj,0);
                break;
            case 38:
                rating4 = new Ck_server_class("西风大剑",R.drawable.xfdj,4,R.drawable.wq_dj,R.drawable.back_ssj,0);
                break;
            case 39:
                rating4 = new Ck_server_class("匣里龙吟",R.drawable.xlly,4,R.drawable.wq_dsj,R.drawable.back_dsj,0);
                break;
            case 40:
                rating4 = new Ck_server_class("祭礼剑",R.drawable.jlj,4,R.drawable.wq_dsj,R.drawable.back_dsj,0);
                break;
            case 41:
                rating4 = new Ck_server_class("西风剑",R.drawable.xfj,4,R.drawable.wq_dsj,R.drawable.back_dsj,0);
                break;
            case 42:
                rating4 = new Ck_server_class("笛剑",R.drawable.dj,4,R.drawable.wq_dsj,R.drawable.back_dsj,0);
                break;
            case 43:
                rating4 = new Ck_server_class("行秋",R.drawable.xq_qy,4,R.drawable.ys_s,0,R.drawable.xq_dt);
                break;
            case 44:
                rating4=new Ck_server_class("凝光",R.drawable.ng_qy,4,R.drawable.ys_y,0,R.drawable.ng_dt);
                break;
            case 45:
                rating4=new Ck_server_class("北斗",R.drawable.bd_qy,4,R.drawable.ys_l,0,R.drawable.bd_dt);
                break;
            case 46:
                rating4=new Ck_server_class("丽莎",R.drawable.ls_qy,4,R.drawable.ys_l,0,R.drawable.ls_dt);
                break;
            case 47:
                rating4=new Ck_server_class("凯亚",R.drawable.ky_qy,4,R.drawable.ys_b,0,R.drawable.ky_dt);
                break;
            case 48:
                rating4=new Ck_server_class("安柏",R.drawable.ab_qy,4,R.drawable.ys_h,0,R.drawable.ab_dt);
                break;
        }
        return rating4;

    }
    private Ck_server_class getczfive(){
        Ck_server_class rating6 = null;
        int min = 1;
        int max = 16;
        int s = (int)min + (int)(Math.random() * (max-min));
        switch (s){
            case 1:
                rating6 = new Ck_server_class("琴",R.drawable.q_qy,5,R.drawable.ys_f,0,R.drawable.q_dt);break;
            case 2:
                rating6 = new Ck_server_class("迪卢克",R.drawable.dlz_qy,5,R.drawable.ys_h,0,R.drawable.dlk_dt);break;
            case 3:
                rating6 = new Ck_server_class("提纳里",R.drawable.tnl_qy,5,R.drawable.ys_c,0,R.drawable.tnl_dt);break;
            case 4:
                rating6 = new Ck_server_class("七七",R.drawable.qq_qy,5,R.drawable.ys_b,0,R.drawable.qq_dt);break;
            case 5:
                rating6 = new Ck_server_class("刻晴",R.drawable.kq_qy,5,R.drawable.ys_l,0,R.drawable.kq_dt);break;
            case 6:
                rating6 = new Ck_server_class("莫娜",R.drawable.mn_qy,5,R.drawable.ys_s,0,R.drawable.mn_dt);break;
            case 7:
                rating6 = new Ck_server_class("天空之卷",R.drawable.tkzj,5,R.drawable.wq_fq,R.drawable.back_fq,R.drawable.tkzj_dt);break;
            case 8:
                rating6 = new Ck_server_class("天空之翼",R.drawable.tkzy,5,R.drawable.wq_gj,R.drawable.back_gj,0);break;
            case 9:
                rating6 = new Ck_server_class("天空之脊",R.drawable.tkzjj,5,R.drawable.wq_cb,R.drawable.back_cb,0);break;
            case 10:
                rating6 = new Ck_server_class("天空之刃",R.drawable.tkzr,5,R.drawable.wq_dsj,R.drawable.back_dsj,0);break;
            case 11:
                rating6 = new Ck_server_class("四风原典",R.drawable.sfyd,5,R.drawable.wq_fq,R.drawable.back_fq,R.drawable.sfyd_dt);break;
            case 12:
                rating6 = new Ck_server_class("风鹰剑",R.drawable.tkzr,5,R.drawable.wq_dsj,R.drawable.back_dsj,0);break;
            case 13:
                rating6 = new Ck_server_class("阿莫斯之弓",R.drawable.ams,5,R.drawable.wq_gj,R.drawable.back_gj,0);break;
            case 14:
                rating6 = new Ck_server_class("和璞鸢",R.drawable.hpy,5,R.drawable.wq_cb,R.drawable.back_cb,0);break;
            case 15:
                rating6 = new Ck_server_class("狼的末路",R.drawable.ldml,5,R.drawable.wq_dj,R.drawable.back_ssj,0);break;
            case 16:
                rating6 = new Ck_server_class("天空之傲",R.drawable.tkza,5,R.drawable.wq_dj,R.drawable.back_ssj,0);break;
        }
        return rating6;
    }
    public Ck_server_class getwqthree(){
        return getthere();
    }
    public Ck_server_class getwqfour(){
        Ck_server_class rating7 = null;
        Random random = new Random();
        int s1 =random.nextInt(5);
        int s = random.nextInt(2);
        switch (n){
            case 0:
                if(s == 1){
                    n++;
                }
                break;
            case 1:
                s = 0;
                n=0;
                break;
        }
        switch (s){
            case 0:
                switch (s1){
                    case 0:
                        rating7 = new Ck_server_class("西福斯的月光",R.drawable.xfsdyg,4,R.drawable.wq_dsj,R.drawable.back_dsj,0);break;
                    case 1:
                        rating7 = new Ck_server_class("祭礼残章",R.drawable.jlcz,4,R.drawable.wq_fq,R.drawable.back_fq,R.drawable.jlcz_dt);break;
                    case 2:
                        rating7 = new Ck_server_class("西风大剑",R.drawable.xfdj,4,R.drawable.wq_dj,R.drawable.back_ssj,0);break;
                    case 3 :
                        rating7 = new Ck_server_class("绝弦",R.drawable.jx,4,R.drawable.wq_gj,R.drawable.back_gj,0);break;
                    case 4 :
                        rating7 = new Ck_server_class("匣里灭辰",R.drawable.xlmc,4,R.drawable.wq_cb,R.drawable.back_cb,0);break;

                }return rating7;
            case 1:
                rating7 =  getczfour();
                do{
                    rating7 =   getczfour();
                }while(rating7.getName().equals("西福斯的月光") || rating7.getName().equals("祭礼残章") || rating7.getName().equals("西风大剑") || rating7.getName().equals("绝弦") || rating7.getName().equals("匣里灭辰")
                        || rating7.getName().equals("凯亚") || rating7.getName().equals("丽莎") || rating7.getName().equals("安柏"));
        }return rating7;
    }
    public Ck_server_class getwqfive(){
        Ck_server_class rating8 = null;
        Random random = new Random();
        int s1 = random.nextInt(2);
        int s = random.nextInt(4);
        int s2=random.nextInt(10);
        switch (chose) {
            case 0:
                switch (count) {
                    case 0:
                        if (s == 3)
                            count++;
                        break;
                    case 1:
                        s = 0;
                        count = 0;
                        break;
                }
            case 1:
                switch (count) {
                    case 0:
                        if(s >= 3){
                            count++;
                        }if(s < 3 && s1==1){
                        count++;
                    }
                        break;
                    case 1:
                        s = 0;
                        if (s1 == 0) {
                            count = 0;
                        } else {
                            count++;
                        }
                        break;
                    case 2:
                        s = 0;
                        s1 = 0;
                        count = 0;
                        break;
                }
                break;
            case 2:
                switch (count) {
                    case 0:
                        if(s >= 3){
                            count++;
                        }if(s < 3 && s1==0){
                        count++;
                    }
                        break;
                    case 1:
                        s = 0;
                        if (s1 == 1) {
                            count = 0;
                        } else {
                            count++;
                        }
                        break;
                    case 2:
                        s = 0;
                        s1 = 1;
                        count = 0;
                        break;
                }
                break;
        }
        switch (s){
            case 0:
            case 1:
            case 2:
                switch (s1){
                    case 0:
                        rating8 = new Ck_server_class("千夜浮梦",R.drawable.qyfm,5,R.drawable.wq_fq,R.drawable.back_fq,0);break;
                    case 1:
                        rating8 = new Ck_server_class("圣显之钥",R.drawable.sxzy,5,R.drawable.wq_dsj,R.drawable.back_dsj,0);break;
                }
                break;
            case 3:
                switch (s2){
                    case 0:
                        rating8 = new Ck_server_class("天空之刃",R.drawable.tkzr,5,R.drawable.wq_dsj,R.drawable.back_ssj,0);break;
                    case 1:
                        rating8 = new Ck_server_class("天空之翼",R.drawable.tkzy,5,R.drawable.wq_gj,R.drawable.back_gj,0);break;
                    case 2:
                        rating8 = new Ck_server_class("天空之脊",R.drawable.tkzjj,5,R.drawable.wq_cb,R.drawable.back_cb,0);break;
                    case 3:
                        rating8 = new Ck_server_class("天空之卷",R.drawable.tkzj,5,R.drawable.wq_fq,R.drawable.back_fq,R.drawable.tkzj_dt);break;
                    case 4:
                        rating8 = new Ck_server_class("天空之傲",R.drawable.tkza,5,R.drawable.wq_dj,R.drawable.back_ssj,0);break;
                    case 5:
                        rating8 = new Ck_server_class("风鹰剑",R.drawable.fyj,5,R.drawable.wq_dsj,R.drawable.back_dsj,0);break;
                    case 6:
                        rating8 = new Ck_server_class("四风原典",R.drawable.sfyd,5,R.drawable.wq_fq,R.drawable.back_fq,R.drawable.sfyd_dt);break;
                    case 7:
                        rating8 = new Ck_server_class("和璞鸢",R.drawable.hpy,5,R.drawable.wq_cb,R.drawable.back_cb,0);break;
                    case 8:
                        rating8 = new Ck_server_class("狼的末路",R.drawable.ldml,5,R.drawable.wq_dj,R.drawable.back_ssj,0);break;
                    case 9:
                        rating8 = new Ck_server_class("阿莫斯之弓",R.drawable.ams,5,R.drawable.wq_gj,R.drawable.back_gj,0);break;
                }
                break;

        }return rating8;
    }

    public List<Integer> getxj2(int f){ //武器池概率统计
        Random random = new Random();
        xj2 = new ArrayList<>();
        int XJ2;
        for (int a = 0 ; a< f ; a++){
            czcs++;
            czzcs++;
            if (czcs >= 63 )
                five1 = wqhlb[czcs - 63];
            if(czzcs == 9)
                four1 = 0.54;
            else if(czzcs >=10)
                four1 =1;
            double randomNumber = random.nextDouble() * (1 - 0.01);
            DecimalFormat decimalFormat = new DecimalFormat( "#.###");
            String formattedRandomNumber = decimalFormat.format(randomNumber);
            double result =  Double.parseDouble(formattedRandomNumber);
            if(result > five1 && result <four1){
                czzcs=0;
                four1 = 0.054;
                XJ2=4;
                xj2.add(XJ2);
            }else if( result <=five1){
                // Log.d("TAG",czcs + "++++"+result);
                wqfivecs.add(czcs);
                czcs=0;
                five1 = 0.007;
                XJ2 = 5;
                xj2.add(XJ2);
            }else{
                XJ2=3;
                xj2.add(XJ2);
            }
        }
        return xj2;
    }
    public List<Integer> getxj(int f){// up/常驻池概率统计
        four=0.054;
        five=0.006;
        Random random = new Random();
        xj=new ArrayList<>();
        int XJ;
        for (int a=0;a<f;a++){

            if (pool==2){
                ccs++;
                zzcs++;
            }
            else{
                zcs++;
                cs++;
            }

            if (pool==2){
                if (ccs>=74)
                    five=hlb[ccs-74];
                if (zzcs==9)
                    four=0.54;
                else if (zzcs>=10)
                    four=1;
            }else {
                if (cs>=74)
                    five=hlb[cs-74];
                if (zcs==9)
                    four=0.54;
                else if (zcs>=10)
                    four=1;
            }
            double randomNumber = random.nextDouble() * (1 - 0.01);
            DecimalFormat decimalFormat = new DecimalFormat("#.###");
            String formattedRandomNumber = decimalFormat.format(randomNumber);
            double result = Double.parseDouble(formattedRandomNumber);
            if (result>five&&result<four){
                if (pool==2){
                    zzcs=0;
                    XJ=4;
                    xj.add(XJ);
                }else {
                    zcs=0;
                    XJ=4;
                    xj.add(XJ);
                }
            }else
            if (result<=five){
                //Log.d("TAG",cs+"++++"+result);
                if (pool==2){
                    czfivecs.add(ccs);
                    ccs=0;
                    XJ=5;
                    xj.add(XJ);
                }else {
                    fivecs.add(cs);
                    cs=0;
                    XJ=5;
                    xj.add(XJ);
                }

            }else {
                XJ=3;
                xj.add(XJ);
            }
        }
        return xj;
    }
}
