package com.example.main.mvvm.json;

import java.util.List;

public class Detail_role {

    public String name;//名
    public String fullname;//名
    public String title;//名号
    public String description;//
    public String rarity;//星级
    public String element;//元素
    public String weapontype;//武器类型
    public String substat;//突破增伤
    public String gender;//性别
    public String body;//英文性别
    public String association;//国家英文
    public String region;//国家
    public String affiliation;//具体所属组织
    public String birthdaymmdd;//生日/
    public String birthday;//生日日
    public String constellation;//命座
    public CvDTO cv;//cv
    public CostsDTO costs;//突破所需材料
    public ImagesDTO images;//图片
    public String version;

    public static class CvDTO {
        public String english;
        public String chinese;
        public String japanese;
        public String korean;
    }

    public static class CostsDTO {
        public List<Ascend1DTO> ascend1;
        public List<Ascend1DTO> ascend2;
        public List<Ascend1DTO> ascend3;
        public List<Ascend1DTO> ascend4;
        public List<Ascend1DTO> ascend5;
        public List<Ascend1DTO> ascend6;

        public static class Ascend1DTO {
            public Ascend1DTO(String name, int count) {
                this.name = name;
                this.count = count;
            }

            public String name;
            public int count;
        }
    }



    public static class ImagesDTO {
        public String cover1;//长立绘半身
        public String cover2;//竖立绘半身
        public String nameicon;//图标
        public String nameiconcard;//卡片样式
        public String namegachasplash;//抽拉立绘
        public String namegachaslice;//竖窄立绘
        public String icon;
        public String namesideicon;//派遣图标
        public String sideicon;//派遣图标https://enka.network/ui/UI_AvatarIcon_Side_Ambor.png

        public String getCover1() {
            return cover1;
        }

        public String getCover2() {
            return cover2;
        }

        public String getNameicon() {
            return nameicon;
        }

        public String getNameiconcard() {
            return nameiconcard;
        }

        public String getNamegachasplash() {
            return namegachasplash;
        }

        public String getNamegachaslice() {
            return namegachaslice;
        }

        public String getIcon() {
            return icon;
        }

        public String getNamesideicon() {
            return namesideicon;
        }

        public String getSideicon() {
            return sideicon;
        }

        @Override
        public String toString() {
            return "ImagesDTO{" +
                    "cover1='" + cover1 + '\'' +
                    ", cover2='" + cover2 + '\'' +
                    ", nameicon='" + nameicon + '\'' +
                    ", nameiconcard='" + nameiconcard + '\'' +
                    ", namegachasplash='" + namegachasplash + '\'' +
                    ", namegachaslice='" + namegachaslice + '\'' +
                    ", icon='" + icon + '\'' +
                    ", namesideicon='" + namesideicon + '\'' +
                    ", sideicon='" + sideicon + '\'' +
                    '}';
        }
    }

}
