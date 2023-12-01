package com.example.main.raw.SQLite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class WqSQLite extends SQLiteOpenHelper {
    public WqSQLite(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase Mid) {
//        String sql="create table user(id integer primary key autoincrement,username varchar(20),password varchar(20),age integer)";
        String sql ="create table js(name varchar,rarity varchar,weapontype varchar,icon varchar,fct varchar)";
        Mid.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
