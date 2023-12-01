package com.example.main.mvvm.calculator.role;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.main.mvvm.calculator.tool.Analysis_Syw;
import com.example.main.mvvm.calculator.tool.Enemy;
import com.example.main.mvvm.calculator.tool.Fm;
import com.example.main.mvvm.calculator.tool.Sh_data;
import com.example.main.mvvm.calculator.tool.Syw_Class;
import com.example.main.mvvm.calculator.tool.Syw_data;
import com.example.main.mvvm.calculator.tool.Wq_class;
import com.example.main.mvvm.calculator.tool.Zy;
import com.example.main.mvvm.json.CharacterData;
import com.example.main.mvvm.json.Detail_Wq;
import com.example.main.raw.Class_Custom.Bl_cl;
import com.example.main.raw.JsonPares.Jszsg;
import com.example.main.raw.SQLite.CalSQLite;
import com.example.main.raw.SQLite.WqSQLite;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Obj_calculator {
    Jszsg.AvatarInfoListDTO jszsg;
    Bl_cl bl;
    Map<String, Double> myZy = new HashMap<String, Double>();
    CharacterData du;
    Fm fm = null;
    Syw_Class syw_class;
    public Integer jl = 1;//武器精炼
    int a_level, q_level, e_level;
    public Double ysbf = 0.0;
    public String wq_lx;//武器类型
    public String ys_key;
    public String bjkey2 = "-1";
    String tszs = null;
    public String WqName;
    public int syw_j = 0, syw_fj = 0;
    double weaponMain = 100, weaponFct = 100;
    String weaponKey = "-1";
    private int wq_flag = 1;
    Jszsg.AvatarInfoListDTO.EquipListDTO.FlatDTO head=null;

    public List<Zy> getZyList() {
        return zyList;
    }

    public Enemy getEnemy() {
        return enemy;
    }

    public Map<String, Double> getMyZy() {
        return myZy;
    }

    public double hzpf = 0;
    List<Zy> zyList = new ArrayList<>();
    boolean[] tf = new boolean[2];
    double time = -1;
    Jszsg.AvatarInfoListDTO jszsg_fb;
    List<String> key = new ArrayList<>();
    int dj = 0, mz = 0;
    public Map<String, Syw_data> data = null;

    public int getMz() {
        return mz;
    }

    public void setMz(int mz) {
        this.mz = mz;
    }

    public Jszsg.AvatarInfoListDTO getJszsg_fb() {
        return jszsg_fb;
    }

    Wq_class wq_class;
    public String Wq_name;
    Map<String, Integer> syw;
    List<String> syw_hz = new ArrayList<>();

    public List<String> getSyw_hz() {
        return syw_hz;
    }

    public void setSyw_hz(List<String> syw_hz) {
        this.syw_hz = syw_hz;
    }

    public CharacterData getDu() {
        return du;
    }

    Context context;
    Enemy enemy;

    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }

    public double getTime() {
        return time;
    }

    int j_a = 0, j_e = 0, j_q = 0;
    double jsq_a = 0, jsq_e = 0, jsq_q = 0;

    @SuppressLint("Range")
    public Obj_calculator(Jszsg.AvatarInfoListDTO jszsg, List<Bl_cl> bl_cl, CharacterData du, Context context) {
        this.jszsg = jszsg;
        this.du = du;
        this.context = context;
        for (Bl_cl bl : bl_cl) {
            if (bl.id == jszsg.avatarId) {
                this.bl = bl;
                break;
            }
        }
        cz();
        Analysis_Syw analysis_syw = new Analysis_Syw(jszsg,context);
        data = analysis_syw.analysis();
        cshsz();
        hzpf = analysis_syw.zpf;
        head=analysis_syw.head;
        dj = Integer.parseInt(jszsg.getPropMap().get("4001").getVal());
        if (jszsg.talentIdList != null)
            mz = jszsg.talentIdList.size();


    }

    @SuppressLint("Range")
    public void wq_syw_csh(Jszsg.AvatarInfoListDTO jszsg, Context context, String key) {
        wq_class = new Wq_class(zyList, myZy, 0, this);
        syw_class = new Syw_Class(this, 0);
        wq_class.setFlag2(wq_flag);
        CalSQLite sqLite = new CalSQLite(context, "cal.bd", null, 1);
        SQLiteDatabase db = sqLite.getWritableDatabase();
        if (Wq_name == null) {
            int s = jszsg.equipList.size() - 1;
            Cursor cursor = db.query("cal", new String[]{"name"}, "id=?", new String[]{jszsg.equipList.get(s).flat.nameTextMapHash}, null, null, null);
            cursor.moveToFirst();
            Wq_name = cursor.getString(cursor.getColumnIndex("name"));
            WqName = Wq_name;
            //初始化武器
            weaponMain = jszsg.equipList.get(s).flat.weaponStats.get(0).statValue;
            if (jszsg.equipList.get(s).flat.weaponStats.size() == 2) {
                weaponFct = jszsg.equipList.get(s).flat.weaponStats.get(1).statValue;
                weaponKey = jszsg.equipList.get(s).flat.weaponStats.get(1).appendPropId;
            } else {
                weaponFct = 0;
                weaponKey = "-1";
                SywZy(jszsg, db);
                return;
            }

            cursor = db.query("cal", new String[]{"name"}, "id=?", new String[]{weaponKey}, null, null, null);
            cursor.moveToLast();
            cursor = db.query("cal", new String[]{"id"}, "name=?", new String[]{cursor.getString(cursor.getColumnIndex("name"))}, null, null, null);
            cursor.moveToLast();
            weaponKey = cursor.getString(cursor.getColumnIndex("id"));

            cursor.close();
            WqSQLite sqLite1 = new WqSQLite(context, "wq.bd", null, 1);
            SQLiteDatabase database_wq = sqLite1.getWritableDatabase();
            cursor = database_wq.query("js", new String[]{"weapontype"}, "name=?", new String[]{Wq_name}, null, null, null, null);
            cursor.moveToFirst();
            if (cursor.getCount()!=0)
            wq_lx = cursor.getString(cursor.getColumnIndex("weapontype"));
            cursor.close();
            database_wq.close();
            sqLite1.close();

            for (String key2 : jszsg.equipList.get(jszsg.equipList.size() - 1).weapon.affixMap.keySet())
                jl = jszsg.equipList.get(jszsg.equipList.size() - 1).weapon.affixMap.get(key2) + 1;

        }

        SywZy(jszsg, db);
        syw_j = 1;
        SywZy(jszsg, db);
        if (WqName.contains("「")) {
            WqName = WqName.replace("「", "");
            WqName = WqName.replace("」", "");
        }
        try {
            // 1. 获取 Cs_claass 类对象
            Class<?> cls = wq_class.getClass();

            // 2. 获取苍古自由之誓() 方法对象
            Method method = cls.getMethod(WqName, int.class);

            // 3. 调用苍古自由之誓() 方法

            method.invoke(wq_class, jl - 1); // 这里传递了一个 int 类型的参数

        } catch (Exception e) {
            e.printStackTrace();
        }

        SywZy(jszsg, db);

        sqLite.close();
        db.close();

    }

    @SuppressLint("Range")
    private void SywZy(Jszsg.AvatarInfoListDTO jszsg, SQLiteDatabase db) {
        Cursor cursor;
        syw_class.setJ(syw_j);
        if (syw_hz.size() == 0)
            cshsyw(jszsg);
        if (syw_hz.size() == 1) {
            if (syw_fj == 0) {
                cursor = db.query("cal", new String[]{"name"}, "id=?", new String[]{syw_hz.get(0)}, null, null, null);
                cursor.moveToFirst();
                Wq_name = cursor.getString(cursor.getColumnIndex("name"));
                cursor.close();
            } else Wq_name = syw_hz.get(0);
            //在此反射


            Log.d("TAGSYW", Wq_name + "," + syw_j);

            Class<?> cls = syw_class.getClass();
            // 3. 调用苍古自由之誓() 方法
            try {
                Method method = cls.getMethod(Wq_name, int.class);
                // 3. 调用苍古自由之誓() 方法
                method.invoke(syw_class, 4); // 这里传递了一个 int 类型的参数
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (syw_hz.size() == 2) {
            String syw_1 = syw_hz.get(0), syw_2 = syw_hz.get(1);
            if (syw_fj == 0) {
                cursor = db.query("cal", new String[]{"name"}, "id=?", new String[]{syw_hz.get(0)}, null, null, null);
                cursor.moveToFirst();
                syw_1 = cursor.getString(cursor.getColumnIndex("name"));
                cursor = db.query("cal", new String[]{"name"}, "id=?", new String[]{syw_hz.get(1)}, null, null, null);
                cursor.moveToFirst();
                syw_2 = cursor.getString(cursor.getColumnIndex("name"));
                Log.d("TAG2", syw_1 + "," + syw_2);

            }
            Class<?> cls = syw_class.getClass();
            try {
                Method method = cls.getMethod(syw_1, int.class);
                // 3. 调用苍古自由之誓() 方法
                method.invoke(syw_class, 2); // 这里传递了一个 int 类型的参数
                method = cls.getMethod(syw_2, int.class);
                method.invoke(syw_class, 2); // 这里传递了一个 int 类型的参数
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        wq_flag = 0;
    }

    abstract void cshsz();

    private void cshsyw(Jszsg.AvatarInfoListDTO jszsg) {
        syw = new HashMap<>();
        for (Jszsg.AvatarInfoListDTO.EquipListDTO equip : jszsg.equipList) {
            String setNameTextMapHash = equip.getFlat().getSetNameTextMapHash();
            if (setNameTextMapHash == null)
                continue;
            if (!syw.containsKey(setNameTextMapHash)) {
                syw.put(setNameTextMapHash, 1);
            } else {
                syw.put(setNameTextMapHash, syw.get(setNameTextMapHash) + 1);
            }
        }
        syw_hz = new ArrayList<>();
//        Log.d("MAP",syw.toString());
        int i = 0;
        for (String key : syw.keySet()) {
            i++;
            Integer value = syw.get(key);
            if (value == null)
                continue;
            if (value >= 2)
                syw_hz.add(key);
        }
        if (i > 2 && syw_hz.size() == 1) {
            syw_hz.add(syw_hz.get(0));
        }
    }


    public abstract List<Sh_data> csh();

    private void cz() {
        jszsg_fb = this.jszsg.clone();
    }

    public abstract double[] user_a(int a);

    public abstract double[] user_q();

    public abstract double[] user_e();

    public abstract void user_mz(int mz);

    public abstract void g1();

    public abstract void g2();

    public abstract void g3();

    public void c1(int d) {

    }

    public void c2(int d) {

    }

    public void c3(int d) {

    }

    public double getGj(int i) {
        double jc = jszsg_fb.getFightPropMap().get("4"), gd = 0, bfb = 0;

        if (jszsg.getFightPropMap().containsKey("5"))
            gd = jszsg_fb.getFightPropMap().get("5");
        if (jszsg.getFightPropMap().containsKey("6"))
            bfb = jszsg_fb.getFightPropMap().get("6");
        if (myZy.get("5") != null) {
            gd += myZy.get("5");
        }
        if (myZy.get("6") != null) {
            bfb += myZy.get("6");
        }
        if (i == 0 && myZy.get("10021") != null)
            gd += myZy.get("10021");
        return jc * bfb + jc + gd;
    }

    public double getFyl(int i) {
        double jc = jszsg_fb.getFightPropMap().get("7"), gd = 0, bfb = 0;
        if (jszsg.getFightPropMap().containsKey("8"))
            gd = jszsg_fb.getFightPropMap().get("8");
        if (jszsg.getFightPropMap().containsKey("9"))
            bfb = jszsg_fb.getFightPropMap().get("9");
        if (myZy.get("8") != null) {
            gd += myZy.get("8");
        }
        if (myZy.get("9") != null) {
            bfb += myZy.get("9");
        }
        if (i == 1 && myZy.get("10019") != null) {
            gd += myZy.get("10019");
        }
        return jc * bfb + jc + gd;
    }


    public double getBjl(String key, int i) {
        double jc = jszsg_fb.getFightPropMap().get("20");
        if (myZy.get("20") != null) {
            jc += myZy.get("20");
        }
        if (i==2)
        if (myZy.get("10028") != null) {
            jc += myZy.get("10028");
        }
        if (i==1)
            if (myZy.get("10027") != null) {
                jc += myZy.get("10027");
            }
        if (myZy.get(bjkey2) != null) {
            jc += myZy.get(bjkey2);
        }
        if (jc > 1)
            return 1;

        return jc;
    }

    public double getYscn(int a) {
        double jc = jszsg_fb.getFightPropMap().get("23");
        if (myZy.get("23") != null) {
            jc += myZy.get("23");
        }
        if (a == 0 && myZy.get("10017") != null)
            jc += myZy.get("10017");
        return jc;
    }


    public double getSmz(int i) {

        double jc = jszsg_fb.getFightPropMap().get("1"), gd = 0, bfb = 0;
        if (jszsg.getFightPropMap().containsKey("2"))
            gd = jszsg_fb.getFightPropMap().get("2");
        if (jszsg.getFightPropMap().containsKey("3"))
            bfb = jszsg_fb.getFightPropMap().get("3");
        if (myZy.get("2") != null) {
            gd += myZy.get("2");
        }
        if (myZy.get("3") != null) {
            bfb += myZy.get("3");
        }
        if (i == 0)
            if (myZy.get("10018") != null) {
                bfb += myZy.get("10018");
            }
        return jc * bfb + jc + gd;
    }

    public double getYsjt(int a) {
        double jc = jszsg_fb.getFightPropMap().get("28");
        if (myZy.get("28") != null) {
            jc += myZy.get("28");
        }
        if (a == 0)
            if (myZy.get("10016") != null) {
                jc += myZy.get("10016");
            }

        return jc;
    }


    public Double getbl(int a, int b, int c, int d) {
        //a=等级,b=c几，c 单双,d 段数
        a--;
        if (myZy.get("10005") != null) {
            a += myZy.get("10005").intValue();
        }
        List<Bl_cl.name_bl> bl_ls = null;
        switch (b) {
            case 0:
                bl_ls = bl.getc1();
                break;
            case 1:
                bl_ls = bl.getc2();
                break;
            case 2:
                bl_ls = bl.getc3();
                break;
        }
        if (c == 1)
            return bl_ls.get(d).getBl().get(a);
        else if (c == 2)
            return bl_ls.get(d).getBl().get(a) + bl_ls.get(d).getBl_kx().get(a);
        else if (c == 3)
            return bl_ls.get(d).getBl_kx().get(a);
        else return bl_ls.get(d).getBl().get(a);

    }

    public double getZs(String lx, String c) {
        double zs = jszsg_fb.getFightPropMap().get(lx);
        if (myZy.get(lx) != null)
            zs += myZy.get(lx);
        if (myZy.get(c) != null) {
            zs += myZy.get(c);
        }
        if (myZy.get("10012") != null) {
            zs += myZy.get("10012");
        }
        if (myZy.get("10033") != null) {
            zs += myZy.get("10033");
        }
        if (tszs != null)
            zs += myZy.get(tszs);

        return zs + 1;
    }

    public double getSx() {
        switch (du.getElement()) {
            case "Ice":
                return jszsg.getFightPropMap().get("46");

            case "Grass":
                return jszsg.getFightPropMap().get("43");

            case "Wind":
                return jszsg.getFightPropMap().get("44");

            case "Electric":
                return jszsg.getFightPropMap().get("41");

            case "Rock":
                return jszsg.getFightPropMap().get("45");

            case "Water":
                return jszsg.getFightPropMap().get("42");

            case "Fire":
                return jszsg.getFightPropMap().get("40");
        }
        return 1;
    }

    public double getBj(String key) {
        double bj = jszsg_fb.getFightPropMap().get("22");
        if (myZy.get("22") != null)
            bj += myZy.get("22");
        if (myZy.get(key) != null)
            bj += myZy.get(key);
        return 1 + bj;

    }

    public double getFy() {
        double jf = 1, cf = 1;
        if (myZy.get("10006") != null)
            cf -= myZy.get("10006");
        if (myZy.get("10007") != null) {
            jf -= myZy.get("10007");
        }
        if (myZy.get("10052") != null)
            jf -= myZy.get("10052");
        return (dj + 100) / ((dj + 100.0) + jf * cf * (enemy.getGw().get("等级") + 100));
    }

    public double getYsKx(String key) {
        double kx = enemy.getGw().get(key);
        if (myZy.get("10032") != null)
            kx -= myZy.get("10032");
        if (myZy.get("200" + key) != null)
            kx -= myZy.get("200" + key);
        if (kx > 0.75)
            return 1 / (1 + kx * 4);
        else if (kx < 0)
            return 1 - (kx / 2);
        else return 1 - kx;

    }

    public void accumulateValue(String key, Double valueToAdd) {
        if (myZy.containsKey(key)) {
            myZy.put(key, myZy.get(key) + valueToAdd);
        } else {
            myZy.put(key, valueToAdd);
        }
    }
    public void accumulateValue_JC(String key, Double valueToAdd) {
        if (jszsg_fb.getFightPropMap().containsKey(key)) {
            jszsg_fb.getFightPropMap().put(key,jszsg_fb.getFightPropMap().get(key) + valueToAdd);
        } else {
            jszsg_fb.getFightPropMap().put(key, valueToAdd);
        }
    }
    public boolean addZy(Zy zy) {
        for (Zy z : zyList) {
            if (z.getName().equals(zy.getName())) {
                if (zy.getKey().equals("10014"))
                    return true;
                z.setTime(getTime());
                double cz = zy.getDex() - z.getDex();
                accumulateValue(z.getKey(), cz);
                z.setDex(zy.getDex());
                Log.d("TAG", "重复增益" + zy.getName() + "," + cz);
                return true;
            }
        }
        zyList.add(zy);
        return false;
    }

    public double[] getqw(String key, double sh_ysh, int i) {
        if (getBjl(key, i) <= 0)
            return new double[]{sh_ysh, sh_ysh};
        double[] d = new double[2];
        double sh = sh_ysh * getBj(key);
        double syl = sh / sh_ysh;
        sh_ysh = getBjl(key,i) * syl * sh_ysh + (1 - getBjl(key, i)) * sh_ysh;
        d[0] = sh;
        d[1] = sh_ysh;
        return d;
    }

    boolean getFz(int lx) {
        switch (lx) {
            case 0:
                if (getTime() - jsq_a >= 2.5) {
                    jsq_a = getTime();
                    j_a = 0;
                }
                j_a++;
                if (j_a == 8)
                    j_a = 1;
                return j_a == 1 || j_a == 4 || j_a == 7;
            case 1:
                if (getTime() - jsq_e >= 2.5) {
                    jsq_e = getTime();
                    j_e = 0;
                }
                j_e++;
                if (j_e == 8)
                    j_e = 1;
                return j_e == 1 || j_e == 4 || j_e == 7;
            case 2:
                if (getTime() - jsq_q >= 2.5) {
                    jsq_q = getTime();
                    j_q = 0;
                }
                j_q++;
                if (j_q == 8)
                    j_q = 1;
                return j_q == 1 || j_q == 4 || j_q == 7;

        }
        return false;
    }

    public double getZf(double sh, int lx) {
        if (lx == 0)
            sh *= 1.5;
        else sh *= 2;
        double xs = (1 + (2.78 * getYsjt(0)) / (getYsjt(0) + 1400));
        if (myZy.get("10031") != null)
            xs += myZy.get("10031");
        sh = sh * xs;
        return sh;
    }

    public double getJc(String key, String b) {
        double jh = 0;
        if (myZy.get("10014") != null) {
            jh += myZy.get("10014");
            myZy.remove("10014");

        }
        if (myZy.get(key) != null)
            jh += myZy.get(key);
        if (myZy.get(b) != null)
            jh += myZy.get(b);

        return jh;

    }

    public int getYsfy(int i) {

        switch (enemy.getReaction(i)) {
            case 0:
                System.out.println("超载");
                break;
            case 1:
                System.out.println("燃烧");
                break;
            case 2:
                System.out.println("融化");
                break;
            case 3:
                System.out.println("蒸发");
                break;
            case 4:
                System.out.println("冻结");
                break;
            case 5:
                System.out.println("超导");
                break;
            case 6:
                System.out.println("感电");
                break;
            case 7:
                System.out.println("扩散");
                break;
            case 8:
                System.out.println("结晶");
                break;
            case 9:
                System.out.println("绽放");
                break;
            case 10:
                System.out.println("蔓激化");
                Mjh();
                break;
            case 11:

                System.out.println("超激化");
                Cjh();
                break;

        }

        return -1;
    }

    protected void Mjh() {
        double jc = 1446.88;
        addZy(new Zy(1.25 * 1446.88 * (1 + (5 * getYsjt(0)) / (getYsjt(0) + 1200.0)), "蔓激化增伤", false, false, "10014", getTime(), 10));
        accumulateValue("10014", 1.25 * 1446.88 * (1 + (5 * getYsjt(0)) / (getYsjt(0) + 1200.0)));

    }

    protected void Cjh() {
        double jc = 1446.88;
        addZy(new Zy(1.15 * 1446.88 * (1 + (5 * getYsjt(0)) / (getYsjt(0) + 1200.0)), "超激化增伤", false, false, "10014", getTime(), 10));
        accumulateValue("10014", 1.15 * 1446.88 * (1 + (5 * getYsjt(0)) / (getYsjt(0) + 1200.0)));
    }

    @SuppressLint("Range")
    public boolean CutWeapon(String name, int jl, Detail_Wq body) {
        Wq_name = name;
        Log.d("TAG", "已经进入" + weaponKey + "," + weaponFct);
        jszsg_fb.getFightPropMap().put("4", jszsg_fb.getFightPropMap().get("4") - weaponMain);
        Log.d("TAGFCT", weaponFct + "," + weaponKey + "," + weaponMain + "," + getJszsg_fb().getFightPropMap().get("28"));
        if (weaponKey.equals("28"))
            jszsg_fb.getFightPropMap().put(weaponKey, jszsg.getFightPropMap().get(weaponKey) - weaponFct);
        else if (weaponFct > 5)
            jszsg_fb.getFightPropMap().put(weaponKey, jszsg.getFightPropMap().get(weaponKey) - weaponFct * 0.01);
        else
            jszsg_fb.getFightPropMap().put(weaponKey, jszsg.getFightPropMap().get(weaponKey) - weaponFct);
        Log.d("TAGFCT", weaponFct + "," + weaponKey + "," + weaponMain + ",," + getJszsg_fb().getFightPropMap().get("28"));
        weaponMain = body.attack;
        jszsg_fb.getFightPropMap().put("4", jszsg_fb.getFightPropMap().get("4") + weaponMain);
        WqSQLite sqLite1 = new WqSQLite(context, "wq.bd", null, 1);
        SQLiteDatabase database_wq = sqLite1.getWritableDatabase();
        Cursor cursor_wq = database_wq.query("js", new String[]{"fct"}, "name=?", new String[]{name}, null, null, null, null);
        cursor_wq.moveToFirst();
        String fct = cursor_wq.getString(cursor_wq.getColumnIndex("fct"));
        cursor_wq.close();
        weaponKey = ClFct(fct);
        weaponFct = body.specialized;
        Log.d("TAGBZ",weaponKey);
        if ( jszsg.getFightPropMap().get(weaponKey)!=null)
        jszsg_fb.getFightPropMap().put(weaponKey, jszsg.getFightPropMap().get(weaponKey) + weaponFct);
        else   jszsg_fb.getFightPropMap().put(weaponKey,  weaponFct);
        Wq_name = name;
        this.jl = jl + 1;
        WqName = name;
        sqLite1.close();

        return true;

    }

    public String ClFct(String Fct) {
        switch (Fct) {
            case "物理伤害加成":
                return "30";
            case "元素充能效率":
                return "23";
            case "攻击力":
                return "6";
            case "元素精通":
                return "28";
            case "防御力":
                return "9";
            case "生命值":
                return "3";
            case "暴击率":
                return "20";
            case "暴击伤害":
                return "22";
        }
        return "27";
    }

    public double getCure() {
        double cure = 0;
        if (getJszsg_fb().getFightPropMap().get("26") != null)
            cure += getJszsg_fb().getFightPropMap().get("26");
        if (myZy.get("26") != null)
            cure += myZy.get("26");
        return 1 + cure;
    }

    public double getHD() {
        double cure = 0;
        if (getJszsg_fb().getFightPropMap().get("81") != null)
            cure += getJszsg_fb().getFightPropMap().get("81");
        if (myZy.get("81") != null)
            cure += myZy.get("81");
        return 1 + cure;
    }

    public double getJcCure() {
        if (myZy.get("10051") != null)
            return myZy.get("10051");
        else return 0;
    }
    double rever_bjl=0,rever_bj=0;
    public boolean  reversal(){
        if (head==null)
            return false;
        if (rever_bj!=0||rever_bjl!=0){
            accumulateValue_JC("22",rever_bj);
            accumulateValue_JC("20",rever_bjl);
            rever_bjl=0;
            rever_bj=0;
            return true;
        }
        if (head.reliquaryMainstat.mainPropId.equals("FIGHT_PROP_CRITICAL_HURT")){
            accumulateValue_JC("22",-0.622);
            accumulateValue_JC("20",0.311);
            rever_bj+=0.622;
            rever_bjl-=0.311;
        }else {
            accumulateValue_JC("22",0.622);
            accumulateValue_JC("20",-0.311);
            rever_bj-=0.622;
            rever_bjl+=0.311;
        }
        for (int a=0;a<head.reliquarySubstats.size();a++){
            switch (head.reliquarySubstats.get(a).appendPropId){
                case "FIGHT_PROP_CRITICAL_HURT"://暴击伤害
                    accumulateValue_JC("22",-head.reliquarySubstats.get(a).statValue*0.01);
                    accumulateValue_JC("20",head.reliquarySubstats.get(a).statValue/2*0.01);
                    rever_bj+=head.reliquarySubstats.get(a).statValue*0.01;
                    rever_bjl-=head.reliquarySubstats.get(a).statValue/2*0.01;
                    break;
                case "FIGHT_PROP_CRITICAL":
                    accumulateValue_JC("22",head.reliquarySubstats.get(a).statValue*2*0.01);
                    accumulateValue_JC("20",-head.reliquarySubstats.get(a).statValue*0.01);
                    rever_bj-=head.reliquarySubstats.get(a).statValue*2*0.01;
                    rever_bjl+=head.reliquarySubstats.get(a).statValue*0.01;
                    break;
            }
        }

        return true;
    }
}
