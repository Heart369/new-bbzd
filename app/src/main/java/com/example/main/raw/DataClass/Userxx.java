package com.example.main.raw.DataClass;

public class Userxx {
    int active_day_number, achievement_number, anemoculus_number, geoculus_number,
            avatar_number, way_point_number, domain_number,precious_chest_number, luxurious_chest_number, exquisite_chest_number, common_chest_number
            , electroculus_number
            , magic_chest_number
            , dendroculus_number;


   String spiral_abyss,message;

    public Userxx(int active_day_number, int achievement_number, int anemoculus_number, int geoculus_number, int avatar_number, int way_point_number, int domain_number, int precious_chest_number, int luxurious_chest_number, int exquisite_chest_number, int common_chest_number, int electroculus_number, int magic_chest_number, int dendroculus_number, String spiral_abyss) {
        this.active_day_number = active_day_number;
        this.achievement_number = achievement_number;
        this.anemoculus_number = anemoculus_number;
        this.geoculus_number = geoculus_number;
        this.avatar_number = avatar_number;
        this.way_point_number = way_point_number;
        this.domain_number = domain_number;
        this.precious_chest_number = precious_chest_number;
        this.luxurious_chest_number = luxurious_chest_number;
        this.exquisite_chest_number = exquisite_chest_number;
        this.common_chest_number = common_chest_number;
        this.electroculus_number = electroculus_number;
        this.magic_chest_number = magic_chest_number;
        this.dendroculus_number = dendroculus_number;
        this.spiral_abyss = spiral_abyss;
    }

    public Userxx() {

    }

    public int getActive_day_number() {
        return active_day_number;
    }

    public int getAchievement_number() {
        return achievement_number;
    }

    public int getAnemoculus_number() {
        return anemoculus_number;
    }

    public int getGeoculus_number() {
        return geoculus_number;
    }

    public int getAvatar_number() {
        return avatar_number;
    }

    public int getWay_point_number() {
        return way_point_number;
    }

    public int getDomain_number() {
        return domain_number;
    }

    public int getPrecious_chest_number() {
        return precious_chest_number;
    }

    public int getLuxurious_chest_number() {
        return luxurious_chest_number;
    }

    public int getExquisite_chest_number() {
        return exquisite_chest_number;
    }

    public int getCommon_chest_number() {
        return common_chest_number;
    }

    public int getElectroculus_number() {
        return electroculus_number;
    }

    public int getMagic_chest_number() {
        return magic_chest_number;
    }

    public int getDendroculus_number() {
        return dendroculus_number;
    }

    public String getSpiral_abyss() {
        return spiral_abyss;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
