package com.example.main.mvvm.json;

public class Detail_mz {

    public String name;
    public C1DTO c1;
    public C1DTO c2;
    public C1DTO c3;
    public C1DTO c4;
    public C1DTO c5;
    public C1DTO c6;
    public ImagesDTO images;
    public String version;

    public static class C1DTO {
        public String name;
        public String effect;
    }

    public static class ImagesDTO {
        public String c1;
        public String c2;
        public String c3;
        public String c4;
        public String c5;
        public String c6;
        public String constellation;
    }
}
