package com.example.main.mvvm.json;

import java.util.List;

public class Detail_Wq {

    public String name;
    public String description;
    public String weapontype;
    public String rarity;
    public String story;
    public int baseatk;
    public String substat;
    public String subvalue;
    public String effectname;
    public String effect;
    public List<String> r1;
    public List<String> r2;
    public List<String> r3;
    public List<String> r4;
    public List<String> r5;
    public String weaponmaterialtype;
    public CostsDTO costs;
    public ImagesDTO images;
    public UrlDTO url;
    public String version;
    public int level;
    public int ascension;
    public double attack;
    public double specialized;

    public static class CostsDTO {
        public List<Ascend1DTO> ascend1;
        public List<Ascend1DTO> ascend2;
        public List<Ascend1DTO> ascend3;
        public List<Ascend1DTO> ascend4;
        public List<Ascend1DTO> ascend5;
        public List<Ascend1DTO> ascend6;

        public static class Ascend1DTO {
            public String name;
            public int count;

            public Ascend1DTO(String key, Integer value) {
                name=key;
                count=value;
            }
        }

    }

    public static class ImagesDTO {
        public String nameicon;
        public String namegacha;
        public String icon;
        public String nameawakenicon;
        public String awakenicon;
    }

    public static class UrlDTO {
        public String fandom;
    }
}
