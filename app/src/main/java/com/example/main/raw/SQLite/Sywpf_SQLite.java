package com.example.main.raw.SQLite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Sywpf_SQLite extends SQLiteOpenHelper {
    public Sywpf_SQLite(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql ="create table pf(uid integer ,FIGHT_PROP_CRITICAL varchar,FIGHT_PROP_CRITICAL_HURT varchar,FIGHT_PROP_ATTACK_PERCENT varchar,FIGHT_PROP_ATTACK varchar,FIGHT_PROP_DEFENSE_PERCENT varchar,FIGHT_PROP_DEFENSE varchar,FIGHT_PROP_HP_PERCENT varchar,FIGHT_PROP_HP varchar,FIGHT_PROP_ELEMENT_MASTERY varchar,FIGHT_PROP_CHARGE_EFFICIENCY varchar)";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
