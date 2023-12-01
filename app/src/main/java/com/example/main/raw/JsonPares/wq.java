package com.example.main.raw.JsonPares;

import java.util.List;

public class wq {

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

    public static class CostsDTO {
        public List<Ascend1DTO> ascend1;
        public List<Ascend2DTO> ascend2;
        public List<Ascend3DTO> ascend3;
        public List<Ascend4DTO> ascend4;
        public List<Ascend5DTO> ascend5;
        public List<Ascend6DTO> ascend6;

        public static class Ascend1DTO {
            public String name;
            public int count;
        }

        public static class Ascend2DTO {
            public String name;
            public int count;
        }

        public static class Ascend3DTO {
            public String name;
            public int count;
        }

        public static class Ascend4DTO {
            public String name;
            public int count;
        }

        public static class Ascend5DTO {
            public String name;
            public int count;
        }

        public static class Ascend6DTO {
            public String name;
            public int count;
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

    public String getName() {
        return name;
    }
}
