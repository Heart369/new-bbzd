package com.example.main.raw.Class_Custom;


import com.example.main.raw.JsonPares.Json_Jstf;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Bl_cl {
    Json_Jstf data;
    public int id;


    public Bl_cl(Json_Jstf data) {
        this.data = data;
    }

    public List<name_bl> getc1() {
        List<name_bl> c1 = new ArrayList<>();
        Json_Jstf.Combat1DTO c1b = data.combat1;
        for (String str : c1b.attributes.labels) {
            c1.add(C1_cl(Re_cs(str, c1)));
        }
        return c1;
    }

    public List<name_bl> getc2() {
        List<name_bl> c1 = new ArrayList<>();
        Json_Jstf.Combat2DTO c1b = data.combat2;
        for (String str : c1b.attributes.labels) {
            c1.add(C2_cl(Re_cs(str, c1)));
        }
        return c1;
    }

    ;

    public List<name_bl> getc3() {
        List<name_bl> c1 = new ArrayList<>();
        Json_Jstf.Combat3DTO c1b = data.combat3;
        for (String str : c1b.attributes.labels) {
            c1.add(C3_cl(Re_cs(str, c1)));
        }
        return c1;
    }

    ;

    private name_bl C1_cl(Retq re) {
        List<Double> bl = new ArrayList<>(), bl_kx = new ArrayList<>();
        for (int a = 0; a < re.par.size(); a++) {
            String cx = "get" + re.par.get(a);
            try {
                Method method = data.combat1.attributes.parameters.getClass().getMethod(cx);
                try {
                    if (a == 0)
                        bl = (List<Double>) method.invoke(data.combat1.attributes.parameters);
                    else
                        bl_kx = (List<Double>) method.invoke(data.combat1.attributes.parameters);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }


        }

        return new name_bl(re.name, bl, bl_kx, re.isand, re.bllx, re.bl_lx2);
    }

    private name_bl C2_cl(Retq re) {
        List<Double> bl = new ArrayList<>(), bl_kx = new ArrayList<>();
        for (int a = 0; a < re.par.size(); a++) {
            String cx = "get" + re.par.get(a);
            try {
                Method method = data.combat2.attributes.parameters.getClass().getMethod(cx);
                try {
                    if (a == 0)
                        bl = (List<Double>) method.invoke(data.combat2.attributes.parameters);
                    else
                        bl_kx = (List<Double>) method.invoke(data.combat2.attributes.parameters);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }

        }
        return new name_bl(re.name, bl, bl_kx, re.isand, re.bllx, re.bl_lx2);
    }


    private name_bl C3_cl(Retq re) {
        List<Double> bl = new ArrayList<>(), bl_kx = new ArrayList<>();
        for (int a = 0; a < re.par.size(); a++) {
            String cx = "get" + re.par.get(a);
            try {
                Method method = data.combat3.attributes.parameters.getClass().getMethod(cx);
                try {
                    if (a == 0)
                        bl = (List<Double>) method.invoke(data.combat3.attributes.parameters);
                    else
                        bl_kx = (List<Double>) method.invoke(data.combat3.attributes.parameters);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }


        }

        return new name_bl(re.name, bl, bl_kx, re.isand, re.bllx, re.bl_lx2);
    }

    public Retq Re_cs(String str, List<name_bl> c1) {
        int[] s = getkxblsx(str);
        String name = null;
        List<String> par = new ArrayList<>();
        String regex = "\\{([^:]+):(.*?)\\}";
// 创建Pattern对象
        Pattern pattern = Pattern.compile(regex);
// 创建Matcher对象
        Matcher matcher = pattern.matcher(str);
// 循环匹配
        while (matcher.find()) {
            String paramName = matcher.group(1);
            par.add(paramName);
        }
        name = str.substring(0, str.indexOf("|"));
        if (str.contains("/"))
            return new Retq(name, par, 1, s[0], s[1]);
        else if (str.contains("+"))
            return new Retq(name, par, 2, s[0], s[1]);
        return new Retq(name, par, 0, s[0], s[1]);

    }

    private int[] getkxblsx(String str) {
        String part2 = str.split("\\|")[1];
        str = part2;
        String[] params;
        int a = -5, b = -5;
        if (str.contains("到")) {
            params = str.split("到");
            params[0] += "秒";
            a = getsx(params[0]);
            b = getsx(params[1]);
            return new int[]{a, b};
        }

        if (str.contains("+") || str.contains("/")) {
            params = str.split("\\+");
            if (params.length == 1)
                params = str.split("/");
            a = getsx(params[0]);
            b = getsx(params[1]);
        } else a = getsx(str);

        return new int[]{a, b};
    }

    private int getsx(String param) {
        if (param.contains("元素精通")) {
            return 0;
        } else if (param.contains("防御力"))
            return 1;
        else if (param.contains("生命值上限"))
            return 2;
        else if (param.contains("秒"))
            return 3;
        else if (param.contains("次"))
            return 4;
        else if (param.contains("I"))
            return 5;
        else if (param.contains("点"))
            return 6;
        else if (param.contains("攻击力"))
            return -1;
        return -2;
    }

    class Retq {
        String name;
        List<String> par;
        int isand;
        int bllx;
        int bl_lx2;

        public Retq(String name, List<String> par, int isand, int bllx, int bl_lx2) {
            this.name = name;
            this.par = par;
            this.isand = isand;
            this.bllx = bllx;
            this.bl_lx2 = bl_lx2;
        }

        public String getName() {
            return name;
        }

        public List<String> getPar() {
            return par;
        }

        public int isIsand() {
            return isand;
        }
    }

    public class name_bl {
        public String name;
        public List<Double> bl, bl_kx;
        public int isand;
        public int bllx;
        public int bl_lx2;

        public String getName() {
            return name;
        }

        public List<Double> getBl() {
            return bl;
        }

        public List<Double> getBl_kx() {
            return bl_kx;
        }

        public int getIsand() {
            return isand;
        }

        public int getBllx() {
            return bllx;
        }

        public int getBl_lx2() {
            return bl_lx2;
        }

        public name_bl(String name, List<Double> bl) {
            this.name = name;
            this.bl = bl;
        }

        public name_bl(String name, List<Double> bl, List<Double> bl_kx, int isand, int bllx, int bl_lx2) {
            this.name = name;
            this.bl = bl;
            this.bl_kx = bl_kx;
            this.isand = isand;
            this.bllx = bllx;
            this.bl_lx2 = bl_lx2;
        }

        public boolean is_bl_kx() {
            return bl_kx != null;
        }

    }
}
