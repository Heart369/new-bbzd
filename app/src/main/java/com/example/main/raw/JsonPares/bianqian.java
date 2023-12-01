package com.example.main.raw.JsonPares;

public class bianqian {
    int retcode,current_resin,finished_task_num,remain_resin_discount_num,current_expedition_num,max_expedition_num,current_home_coin,max_home_coin,Day;
    String message,resin_recovery_time,home_coin_recovery_time;
    Boolean obtained;

    public bianqian(String message,int retcode) {
        this.message = message;
        this.retcode=retcode;
    }

    public bianqian(int retcode, int current_resin, int finished_task_num, int remain_resin_discount_num, int current_expedition_num, int max_expedition_num, int current_home_coin, int max_home_coin, int day, String message, String resin_recovery_time, String home_coin_recovery_time, Boolean obtained) {
        this.retcode = retcode;
        this.current_resin = current_resin;
        this.finished_task_num = finished_task_num;
        this.remain_resin_discount_num = remain_resin_discount_num;
        this.current_expedition_num = current_expedition_num;
        this.max_expedition_num = max_expedition_num;
        this.current_home_coin = current_home_coin;
        this.max_home_coin = max_home_coin;
        Day = day;
        this.message = message;
        this.resin_recovery_time = resin_recovery_time;
        this.home_coin_recovery_time = home_coin_recovery_time;
        this.obtained = obtained;
    }

    public int getRetcode() {
        return retcode;
    }

    public void setRetcode(int retcode) {
        this.retcode = retcode;
    }

    public int getCurrent_resin() {
        return current_resin;
    }

    public void setCurrent_resin(int current_resin) {
        this.current_resin = current_resin;
    }

    public int getFinished_task_num() {
        return finished_task_num;
    }

    public void setFinished_task_num(int finished_task_num) {
        this.finished_task_num = finished_task_num;
    }

    public int getRemain_resin_discount_num() {
        return remain_resin_discount_num;
    }

    public void setRemain_resin_discount_num(int remain_resin_discount_num) {
        this.remain_resin_discount_num = remain_resin_discount_num;
    }

    public int getCurrent_expedition_num() {
        return current_expedition_num;
    }

    public void setCurrent_expedition_num(int current_expedition_num) {
        this.current_expedition_num = current_expedition_num;
    }

    public int getMax_expedition_num() {
        return max_expedition_num;
    }

    public void setMax_expedition_num(int max_expedition_num) {
        this.max_expedition_num = max_expedition_num;
    }

    public int getCurrent_home_coin() {
        return current_home_coin;
    }

    public void setCurrent_home_coin(int current_home_coin) {
        this.current_home_coin = current_home_coin;
    }

    public int getMax_home_coin() {
        return max_home_coin;
    }

    public void setMax_home_coin(int max_home_coin) {
        this.max_home_coin = max_home_coin;
    }

    public int getDay() {
        return Day;
    }

    public void setDay(int day) {
        Day = day;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getResin_recovery_time() {
        return resin_recovery_time;
    }

    public void setResin_recovery_time(String resin_recovery_time) {
        this.resin_recovery_time = resin_recovery_time;
    }

    public String getHome_coin_recovery_time() {
        return home_coin_recovery_time;
    }

    public void setHome_coin_recovery_time(String home_coin_recovery_time) {
        this.home_coin_recovery_time = home_coin_recovery_time;
    }

    public Boolean getObtained() {
        return obtained;
    }

    public void setObtained(Boolean obtained) {
        this.obtained = obtained;
    }
}
