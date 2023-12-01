package com.example.main.raw.Class_Custom.wh;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.main.raw.JsonPares.wq;
import com.example.main.raw.SQLite.WqSQLite;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Ys_bk_wq extends Thread{
    Context context;

    public Ys_bk_wq(Context context) {
        this.context = context;
    }

    @Override
    public void run() {
        super.run();
        String[] wqname = new String[]{"风鹰剑", "松籁响起之时", "西风剑", "宗室长剑", "暗巷闪光", "辰砂之纺锤", "钟剑", "雪葬的星银", "西风秘典", "宗室秘法录", "绝弦", "苍翠猎弓", "幽夜华尔兹"
                , "冷刃", "铁影阔剑", "魔导绪论", "鸦羽弓", "银剑", "口袋魔导书", "无锋剑", "学徒笔记", "天空之刃", "天空之傲", "天空之卷", "天空之翼", "终末嗟叹之诗", "龙脊长枪", "黎明神剑"
                , "讨龙英杰谭", "佣兵重剑", "历练的猎弓", "苍古自由之誓", "狼的末路", "四风原典", "阿莫斯之弓", "天空之脊", "祭礼剑", "腐殖之剑", "西风大剑", "宗室大剑", "祭礼残章", "忍冬之果"
                , "西风猎弓", "宗室长弓", "风花之颂", "暗巷猎手", "西风长枪", "旅行剑", "白铁大剑", "异世界行记", "反曲弓", "铁尖枪", "训练大剑", "新手长枪", "笛剑", "黑剑", "降临之剑"
                , "祭礼大剑", "流浪乐章", "暗巷的酒与诗", "嘟嘟可故事集", "祭礼弓", "决斗之枪", "风信之锋", "沐浴龙血的剑", "神射手之誓", "斫峰之刃", "若水", "和璞鸢", "匣里龙吟", "白影剑"
                , "千岩古剑", "匣里日月", "黑岩绯玉", "弓藏", "黑岩战弓", "流月针", "暗铁剑", "翡玉法球", "弹弓", "白缨枪", "磐岩结绿", "无工之剑", "息灾", "雨裁", "试作斩岩", "黑岩斩刀"
                , "试作金珀", "昭心", "试作澹月", "匣里灭辰", "黑岩刺枪", "宗室猎枪", "吃虎鱼刀", "以理服人", "甲级宝珏", "信使", "钺矛", "尘世之锁", "贯虹之槊", "护摩之杖", "铁蜂刺", "试作古华"
                , "螭骨剑", "衔珠海皇", "万国诸海图谱", "钢轮弓", "落霞", "试作星镰", "千岩长枪", "飞天御剑", "飞天大御剑", "黑缨枪", "雾切之回光", "不灭月华", "天目影打刀", "恶王丸", "证誓之明瞳"
                , "白辰之环", "波乱月白经津", "赤角石溃杵", "飞雷之弦振", "桂木斩长正", "破魔之弓", "掠食者", "曚云之月", "神乐之真意", "冬极白星", "薙草之稻光", "笼钓瓶一心", "喜多院十文字", "「渔获」"
                , "断浪长鳍", "圣显之钥", "裁叶萃光", "原木刀", "森林王器", "西福斯的月光", "千夜浮梦", "赤沙之杖", "流浪的晚星", "盈满之实", "贯月矢", "猎人之径", "图莱杜拉的回忆", "王下近侍", "竭泽"
                , "玛海菈的水色","碧落之珑","鹮穿之喙","金流监督","万世流涌大典","最初的大魔术","船坞长剑","灰河渡手","海渊终曲","狼牙","便携动力锯","浪影阔剑","聊聊棒","饰铁之花","测距规","烈阳之嗣"
                ,"静谧之曲","无垠蔚蓝之歌","遗祀玉珑","纯水流华","勘探钻机","峡湾长歌","公义的酬报","静水流涌之辉"};
        String[] reversedArray = new String[wqname.length];
        for (int i = 0; i < wqname.length; i++) {
            reversedArray[i] = wqname[wqname.length - 1 - i];
        }
        wqname=reversedArray;
        WqSQLite sqLite1 = new WqSQLite(context, "wq.bd", null, 1);
        SQLiteDatabase database_wq = sqLite1.getWritableDatabase();
        Cursor cursor2 = database_wq.query("js", new String[]{"name"}, null, null, null, null, null, null);
        if (cursor2.getCount()!=wqname.length)
            for (String name:wqname){
                 cursor2 = database_wq.query("js", new String[]{"name"}, "name=?", new String[]{name}, null, null, null, null);
               if (cursor2.getCount()!=0)
                   continue;
                String url = "https://api.minigg.cn/weapons" + "?query=" + name;
                OkHttpClient httpClient = new OkHttpClient();
                Request getRequest = new Request.Builder()
                        .url(url)
                        .get()
                        .build();
                Call call = httpClient.newCall(getRequest);
                try {
                    Response response = null;
                    response = call.execute();
                    String data = response.body().string();
                    ContentValues values = new ContentValues();
                    Gson gson = new Gson();
                    wq date = gson.fromJson(data, wq.class);
                    values.put("name", date.getName());
                    values.put("rarity", date.rarity);
                    values.put("weapontype", date.weapontype);
                    values.put("icon", date.images.nameawakenicon);
                    values.put("fct", date.substat);
                    database_wq.insert("js", null, values);
                    Log.d("TAG", name + "," + date.rarity);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
    }
}
