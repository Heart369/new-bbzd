package com.example.main.raw.DsAlgorithm;

import android.util.Log;

//米游社2.1.1DS算法
public class DS_main {
    String Uid;
    String server;
    int schedule_type;
    String CN_salt="xV8v4Qu54lUKrEYFZkJhB8cuOh9Asafs";

    public DS_main(String uid, String server) {
        Uid = uid;
        this.server = server;
    }

    public DS_main(String uid, String server, int schedule_type) {
        Uid = uid;
        this.server = server;
        this.schedule_type = schedule_type;
    }

    public String getDS(){
        String t = (System.currentTimeMillis() / 1000) + "";
        String b="";
        String q="role_id="+Uid+"&server="+server;
        Object a = (int)(Math.random()*200000+100000);
        String r= a.toString();
       // String h = DigestUtils.md5Hex("salt=" + CN_salt + "&t=" + t + "&r=" + r+"&b=&q="+q);
        String   h=Md5.INSTANCE.getMD5("salt=" + CN_salt + "&t=" + t + "&r=" + r+"&b=&q="+q);
        Log.d("md5",t+","+r+","+h);
        return t+","+r+","+h;
    }
    public String getDS2(){
        String t = (System.currentTimeMillis() / 1000) + "";
        String b="";
        String q="role_id="+Uid+"&schedule_type="+schedule_type+"&server="+server;
        Object a = (int)(Math.random()*200000+100000);
        String r= a.toString();
  //      String h = DigestUtils.md5Hex("salt=" + CN_salt + "&t=" + t + "&r=" + r+"&b=&q="+q);
        String h=Md5.INSTANCE.getMD5("salt=" + CN_salt + "&t=" + t + "&r=" + r+"&b=&q="+q);
        Log.d("md5",t+","+r+","+h);
        return t+","+r+","+h;
    }
}
