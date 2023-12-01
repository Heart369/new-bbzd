package com.example.main.raw.Class_Custom;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.main.raw.DataClass.SywData;
import com.example.main.raw.DataClass.SywSxData;
import com.example.main.raw.DataClass.SywSxData2;
import com.example.main.raw.SQLite.SywSQLite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Random {
    java.util.Random random = new java.util.Random();
    Context context;
    String C1, C2;
    String[] data1 = new String[5], data2 = new String[5];
    boolean flag = true;
    List<String> jz;

    public void setJz(List<String> jz) {
        this.jz = jz;
    }

    public void setC1(String c1) {
        C1 = c1;
        flag = true;
    }

    public void setC2(String c2) {
        C2 = c2;
    }

    public Random(Context context) {
        this.context = context;
    }

    public int getRandom() {
        int data = 0;
        data = random.nextInt() % 100;
        if (data < 0)
            data *= -1;
        return data;
    }

    public int getCont() {
        int size = 0;
        int b = getRandom();
        if (b >= 0 && b < 86)
            size = 2;
        else if (b >= 86 && b < 99)
            size = 3;
        else if (b == 99)
            size = 4;
        return size;

    }

    @SuppressLint("Range")
    public List<SywData> getsywdata(int size) {
        List<SywData> sywData = new ArrayList<>();
        if (flag) {
            csh();
            flag = false;
        }
        java.util.Random random = new java.util.Random();
        String[] data3;
        String C3;
        String c1,c2,name;
        while (size > 0) {
            double i = random.nextDouble();
            if (i < 0.5) {
                data3 = data1;
                C3 = C1;
                c1= jz.get(0);
                c2=jz.get(1);
                name=jz.get(2);
            } else {
                data3 = data2;
                C3 = C2;
                c1= jz.get(3);
                c2=jz.get(4);
                name=jz.get(5);
            }
            int randomNumber = random.nextInt(5) + 1;
            SywData data;
            switch (randomNumber) {
                case 1:
                    data = new SywData(data3[3], C3, 1,name,c1,c2,4);
                    sywData.add(data);
                    break;
                case 2:
                    data = new SywData(data3[1], C3, 2,name,c1,c2,2);
                    sywData.add(data);
                    break;
                case 3:
                    data = new SywData(data3[4], C3, 3,name,c1,c2,5);
                    sywData.add(data);
                    break;
                case 4:
                    data = new SywData(data3[0], C3, 4,name,c1,c2,1);
                    sywData.add(data);
                    break;
                case 5:
                    data = new SywData(data3[2], C3, 5,name,c1,c2,3);
                    sywData.add(data);
                    break;
            }
        size--;
        }
        return sywData;
    }

    @SuppressLint("Range")
    private void csh() {
        SywSQLite sqLite = new SywSQLite(context, "ck2.db", null, 1);
        SQLiteDatabase database = sqLite.getWritableDatabase();
        Cursor cursor = database.query("ck", new String[]{"id", "c1", "c2", "c3", "c4", "c5"}, "id=?", new String[]{C1}, null, null, null, null);
        cursor.moveToNext();
        data1[0] = cursor.getString(cursor.getColumnIndex("c1"));
        data1[1] = cursor.getString(cursor.getColumnIndex("c2"));
        data1[2] = cursor.getString(cursor.getColumnIndex("c3"));
        data1[3] = cursor.getString(cursor.getColumnIndex("c4"));
        data1[4] = cursor.getString(cursor.getColumnIndex("c5"));
        cursor = database.query("ck", new String[]{"id", "c1", "c2", "c3", "c4", "c5"}, "id=?", new String[]{C2}, null, null, null, null);
        cursor.moveToNext();
        data2[0] = cursor.getString(cursor.getColumnIndex("c1"));
        data2[1] = cursor.getString(cursor.getColumnIndex("c2"));
        data2[2] = cursor.getString(cursor.getColumnIndex("c3"));
        data2[3] = cursor.getString(cursor.getColumnIndex("c4"));
        data2[4] = cursor.getString(cursor.getColumnIndex("c5"));
        cursor.close();
        database.close();

    }

    public List<SywSxData> getSx(List<SywData> sywData) {
        List<SywSxData> syw = new ArrayList<>();
        String mainname;
        int bfb;
        double exp = 0;
        for (int a = 0; a < sywData.size(); a++) {
            int b = getRandom();

            if (sywData.get(a).getId() == 1) {
                mainname = "生命值";
                exp = 717;
                bfb = 1;

            } else if (sywData.get(a).getId() == 2) {
                mainname = "攻击力";
                exp = 47;
                bfb = 1;
            } else if (sywData.get(a).getId() == 3) {
                if (b >= 0 && b < 26) {
                    mainname = "生命值";
                    exp = 7.0;
                    bfb = 2;
                } else if (b >= 26 && b <= 52) {
                    mainname = "攻击力";
                    exp = 7.0;
                    bfb = 2;
                } else if (b >= 52 && b < 79) {
                    mainname = "防御力";
                    exp = 8.7;
                    bfb = 2;
                } else if (b >= 79 && b < 90) {
                    mainname = "元素充能效率";
                    exp = 8.7;
                    bfb = 2;
                } else {
                    mainname = "元素精通";
                    exp = 28;
                    bfb = 1;
                }
            } else if (sywData.get(a).getId() == 4) {
                if (b >= 0 && b < 20) {
                    mainname = "生命值";
                    exp = 7.0;
                    bfb = 2;
                } else if (b >= 20 && b < 39) {
                    mainname = "攻击力";
                    exp = 7.0;
                    bfb = 2;
                } else if (b >= 39 && b < 58) {
                    mainname = "防御力";
                    exp = 8.7;
                    bfb = 2;
                } else if (b >= 59 && b < 64) {
                    mainname = "火元素伤害";
                    exp = 7.0;
                    bfb = 2;
                } else if (b >= 64 && b < 69) {
                    mainname = "雷元素伤害";
                    exp = 7.0;
                    bfb = 2;
                } else if (b >= 69 && b < 74) {
                    mainname = "水元素伤害";
                    exp = 7.0;
                    bfb = 2;
                } else if (b >= 74 && b < 79) {
                    mainname = "冰元素伤害";
                    exp = 7.0;
                    bfb = 2;
                } else if (b >= 79 && b < 84) {
                    mainname = "风元素伤害";
                    exp = 7.0;
                    bfb = 2;
                } else if (b >= 84 && b < 89) {
                    mainname = "岩元素伤害";
                    exp = 7.0;
                    bfb = 2;
                } else if (b >= 89 && b < 94) {
                    mainname = "草元素伤害";
                    exp = 7.0;
                    bfb = 2;
                } else if (b >= 94 && b < 99) {
                    mainname = "物理伤害";
                    exp = 7.0;
                    bfb = 2;
                } else {
                    mainname = "元素精通";
                    exp = 28;
                    bfb = 1;
                }
            } else {
                if (b >= 0 && b < 22) {
                    mainname = "生命值";
                    exp = 7.0;
                    bfb = 2;
                } else if (b >= 22 & b < 44) {
                    mainname = "攻击力";
                    exp = 7.0;
                    bfb = 2;
                } else if (b >= 44 && b < 66) {
                    mainname = "防御力";
                    exp = 8.7;
                    bfb = 2;
                } else if (b >= 66 && b < 76) {
                    mainname = "暴击率";
                    exp = 4.7;
                    bfb = 2;
                } else if (b >= 76 && b < 86) {
                    mainname = "暴击伤害";
                    exp = 9.4;
                    bfb = 2;
                } else if (b >= 86 && b < 96) {
                    mainname = "治疗加成";
                    exp = 5.4;
                    bfb = 2;
                } else {
                    mainname = "元素精通";
                    exp = 28;
                    bfb = 1;
                }
            }
            SywSxData sywSxData = new SywSxData(exp, mainname, bfb);
            syw.add(sywSxData);
        }
        return syw;
    }

    public List<SywSxData2> getSx2(int i) {
        List<SywSxData2> sywSxData2s = new ArrayList<>();
        int b = 0;
        b = getRandom();
        int cts = 0;
        String name;
        Double exp;
        int flag = 0;
        if (b >= 0 && b < 80)
            cts = 3;
        else cts = 4;
        int s = 0;
        Log.d("TAG", "开始进入");
        for (s = 0; s < 4; s++) {
            Log.d("TAG", "进入" + s);
            b = getRandom();
            exp = 0.0;
            flag = 0;
            name = null;
            if (b >= 0 && b < 15) {
                switch (i) {
                    case 1:
                        exp = getxgj();
                        flag = 1;
                        name = "攻击力";
                        break;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        exp = getxsm();
                        flag = 1;
                        name = "生命值";
                        break;
                }
            } else if (b >= 15 && b < 30) {
                switch (i) {
                    case 1:
                    case 2:
                    case 3:
                        exp = getxfy();
                        flag = 1;
                        name = "防御力";
                        break;
                    case 4:
                    case 5:
                        exp = getxgj();
                        flag = 1;
                        name = "攻击力";
                        break;
                }
            } else if (b >= 30 && b < 40) {
                switch (i) {
                    case 1:
                    case 2:
                        exp = getdsm();
                        flag = 2;
                        name = "生命值";
                        break;
                    case 3:
                        exp = getxgj();
                        flag = 1;
                        name = "攻击力";
                        break;
                    case 4:
                    case 5:
                        exp = getxsm();
                        flag = 1;
                        name = "生命值";
                        break;
                }
            } else if (b >= 40 && b < 50) {
                exp = getdgj();
                flag = 2;
                name = "攻击力";
            } else if (b >= 50 && b < 60) {
                exp = getdfy();
                flag = 2;
                name = "防御力";
            } else if (b >= 60 && b < 70) {
                exp = getcnxl();
                flag = 2;
                name = "元素充能效率";
            } else if (b >= 70 && b < 80) {
                exp = getysjt();
                flag = 1;
                name = "元素精通";
            } else if (b >= 80 && b < 90) {
                exp = getbjl();
                flag = 2;
                name = "暴击率";
            } else {
                exp = getbj();
                flag = 2;
                name = "暴击伤害";
            }
            boolean fz = false;
            for (int l = 0; l < sywSxData2s.size(); l++) {
                if (sywSxData2s.get(l).getName().equals(name) && sywSxData2s.get(l).getB() == flag)
                    fz = true;
            }
            if (fz) {
                s--;
            } else {
                SywSxData2 sxData2 = new SywSxData2(name, exp, cts, flag);
                sywSxData2s.add(sxData2);
            }


        }
        return sywSxData2s;
    }

    public Double getxsm() {
        Double x;
        x = 209.0 + (int) (Math.random() * 90);
        return x;
    }

    public Double getxfy() {
        Double x;
        x = 16.0 + (int) (Math.random() * 7);
        return x;
    }

    public Double getxgj() {
        Double x;
        x = 14.0 + (int) (Math.random() * 5);
        return x;
    }

    public Double getysjt() {
        Double x;
        x = 16.0 + (int) (Math.random() * 7);
        return x;
    }

    public Double getdsm() {
        Double x;
        x = 4.1 + (Math.random() * 1.7);
        return x;
    }

    public Double getdfy() {
        Double x;
        x = 5.1 + (Math.random() * 2.2);
        return x;
    }

    public Double getdgj() {
        Double x;
        x = 4.1 + (Math.random() * 1.7);
        return x;
    }

    public Double getcnxl() {
        Double x;
        x = 4.5 + (Math.random() * 2.0);
        return x;
    }

    public Double getbjl() {
        Double x;
        x = 2.7 + (Math.random() * 1.2);
        return x;
    }

    public Double getbj() {
        Double x;
        x = 5.4 + (Math.random() * 2.4);
        return x;
    }


}
