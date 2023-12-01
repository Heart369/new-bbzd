package com.example.main.raw.JsonPares;

public class grxx {
    String message,region,game_uid,nickname,region_name;
    int level;

    public grxx(String message, String region, String game_uid, String nickname, String region_name, int level) {
        this.message = message;
        this.region = region;
        this.game_uid = game_uid;
        this.nickname = nickname;
        this.region_name = region_name;
        this.level = level;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getGame_uid() {
        return game_uid;
    }

    public void setGame_uid(String game_uid) {
        this.game_uid = game_uid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getRegion_name() {
        return region_name;
    }

    public void setRegion_name(String region_name) {
        this.region_name = region_name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
