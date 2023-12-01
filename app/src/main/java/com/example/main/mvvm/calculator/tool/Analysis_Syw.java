package com.example.main.mvvm.calculator.tool;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.main.raw.JsonPares.Jszsg;
import com.example.main.raw.SQLite.Sywpf_SQLite;
import com.github.mikephil.charting.formatter.IFillFormatter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Analysis_Syw {
    Jszsg.AvatarInfoListDTO jszsg;
    public double zpf = 0;
    public Jszsg.AvatarInfoListDTO.EquipListDTO.FlatDTO head = null;
    Context context;

    public Analysis_Syw(Jszsg.AvatarInfoListDTO jszsg, Context context) {
        this.jszsg = jszsg;
        this.context = context;
    }

    public Map<String, Syw_data> analysis() {
        Map<String, Syw_data> data = new HashMap<>();

        List<Jszsg.AvatarInfoListDTO.EquipListDTO> zb = jszsg.equipList;
        if (zb.size() == 1)
            return data;
        for (int a = 0; a < zb.size() - 1; a++) {

            data.put(zb.get(a).flat.equipType, cts(zb.get(a)));
        }
        return data;
    }

    @SuppressLint("Range")
    private Syw_data cts(Jszsg.AvatarInfoListDTO.EquipListDTO equipListDTO) {
        Sywpf_SQLite sywxq = new Sywpf_SQLite(context, "js_pf.bd", null, 1);
        SQLiteDatabase database = sywxq.getWritableDatabase();
        double max = 2, grade = 0, zpf = 0;
        int color = 0;
        if (equipListDTO.flat.reliquarySubstats == null)
            return null;
        int size = equipListDTO.flat.reliquarySubstats.size();
        double[] cts = new double[size], ctmax = new double[size];
        int[] colors = new int[size];
        for (int a = 0; a < size; a++) {
            Jszsg.AvatarInfoListDTO.EquipListDTO.FlatDTO.ReliquarySubstatsDTO dto = equipListDTO.flat.reliquarySubstats.get(a);
            grade = 0;
            color = 0;
            switch (dto.appendPropId) {
                case "FIGHT_PROP_HP_PERCENT"://百分比生命值
                    max = 5.8;
                    color = getpf("FIGHT_PROP_HP_PERCENT", database);
                    if (color == 1) {
                        grade = 7.8;
                    } else if (color == 2) {
                        grade = 3.9;
                    }
                    break;
                case "FIGHT_PROP_DEFENSE"://防御力
                    max = 23;
                    color = getpf("FIGHT_PROP_DEFENSE", database);
                    if (color == 1)
                        grade = 3.9;
                    else if (color == 2)
                        grade = 1.95;
                    break;
                case "FIGHT_PROP_CRITICAL_HURT"://暴击伤害
                    max = 7.8;
                    color = getpf("FIGHT_PROP_CRITICAL_HURT", database);
                    if (color == 1)
                        grade = 7.8;
                    else if (color == 2)
                        grade = 3.9;
                    break;
                case "FIGHT_PROP_ELEMENT_MASTERY"://元素精通
                    color = getpf("FIGHT_PROP_ELEMENT_MASTERY", database);
                    if (color == 1)
                        grade = 7.8;
                    else if (color == 2)
                        grade = 3.9;
                    max = 23;
                    break;
                case "FIGHT_PROP_CRITICAL"://暴击率
                    max = 3.9;
                    color = getpf("FIGHT_PROP_CRITICAL", database);
                    if (color == 1)
                        grade = 7.8;
                    else if (color == 2)
                        grade = 3.9;
                    break;
                case "FIGHT_PROP_DEFENSE_PERCENT"://百分比防御力
                    max = 7.3;
                    color = getpf("FIGHT_PROP_DEFENSE_PERCENT", database);
                    if (color == 1)
                        grade = 7.8;
                    else if (color == 2)
                        grade = 3.9;
                    break;
                case "FIGHT_PROP_HP"://生命值
                    max = 299;
                    color = getpf("FIGHT_PROP_HP", database);
                    if (color == 1)
                        grade = 3.9;
                    else if (color == 2)
                        grade = 1.95;
                    break;
                case "FIGHT_PROP_ATTACK_PERCENT"://大公鸡
                    max = 5.8;
                    color = getpf("FIGHT_PROP_ATTACK_PERCENT", database);
                    if (color == 1)
                        grade = 7.8;
                    else if (color == 2)
                        grade = 3.9;
                    break;
                case "FIGHT_PROP_ATTACK"://小攻击
                    max = 19;
                    color = getpf("FIGHT_PROP_ATTACK", database);
                    if (color == 1)
                        grade = 3.9;
                    else if (color == 2)
                        grade = 1.95;
                    break;
                case "FIGHT_PROP_CHARGE_EFFICIENCY"://充能效率
                    max = 6.5;
                    color = getpf("FIGHT_PROP_CHARGE_EFFICIENCY", database);
                    if (color == 1)
                        grade = 7.8;
                    else if (color == 2)
                        grade = 3.9;
                    break;
            }
            cts[a] = dto.statValue / max;
            ctmax[a] = max;
            colors[a] = color;
            if (grade != 0)
                zpf += dto.statValue / max * grade;

        }
        if (equipListDTO.flat.reliquaryMainstat.mainPropId.equals("FIGHT_PROP_CRITICAL_HURT") || equipListDTO.flat.reliquaryMainstat.mainPropId.equals("FIGHT_PROP_CRITICAL")) {
            head = equipListDTO.flat;
            zpf += 20;
        }
        this.zpf += zpf;
        database.close();
        return new Syw_data(cts, ctmax, zpf, colors);
    }

    @SuppressLint("Range")
    private int getpf(String name, SQLiteDatabase database) {
        Cursor cursor = database.query("pf", new String[]{name}, "uid=?", new String[]{jszsg.avatarId + ""}, null, null, null);
        cursor.moveToFirst();

        return cursor.getInt(cursor.getColumnIndex(name));
    }
}
