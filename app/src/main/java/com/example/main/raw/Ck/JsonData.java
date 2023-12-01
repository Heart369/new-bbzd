package com.example.main.raw.Ck;

public class JsonData {
   String  auth_appid;
    String   game_biz;
    String  game_uid;
    String  region;

    public JsonData(String auth_appid, String game_biz, String game_uid, String region) {
        this.auth_appid = auth_appid;
        this.game_biz = game_biz;
        this.game_uid = game_uid;
        this.region = region;
    }
}
