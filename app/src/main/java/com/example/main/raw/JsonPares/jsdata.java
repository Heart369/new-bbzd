package com.example.main.raw.JsonPares;

import java.util.List;

public class jsdata {

    public String name;//角色名
    public String fullname;
    public String title;//标号
    public String description;//角色信息
    public String rarity;//星级
    public String element;//元素
    public String weapontype;//武器类型
    public String substat;//突破提升
    public String gender;//性别
    public String body;//英文性别
    public String association;//国家英文
    public String region;//国家
    public String affiliation;//所属国家具体机构
    public String birthdaymmdd;//生日
    public String birthday;//生日
    public String constellation;//命座
    public CvDTO cv;//cv
    public CostsDTO costs;//突破需要的材料数量
    public ImagesDTO images;//图片集合
    public String version;//版本

    public static class CvDTO {
        public String english;//对应国家cv
        public String chinese;
        public String japanese;
        public String korean;
    }

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
        public String cover1;//横向半身立绘
        public String cover2;//竖向半身立绘
        public String nameicon;//
        public String nameiconcard;
        public String namegachasplash;
        public String namegachaslice;
        public String icon;//图标
        public String namesideicon;
        public String sideicon;//深渊小图标

        public String getCover1() {
            return cover1;
        }

        public String getCover2() {
            return cover2;
        }

        public String getIcon() {
            return icon;
        }

        public String getSideicon() {
            return sideicon;
        }
    }

    public String getName() {
        return name;
    }

    public String getFullname() {
        return fullname;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getRarity() {
        return rarity;
    }

    public String getElement() {
        return element;
    }

    public String getWeapontype() {
        return weapontype;
    }

    public String getSubstat() {
        return substat;
    }

    public String getGender() {
        return gender;
    }

    public String getBody() {
        return body;
    }

    public String getAssociation() {
        return association;
    }

    public String getRegion() {
        return region;
    }

    public String getAffiliation() {
        return affiliation;
    }

    public String getBirthdaymmdd() {
        return birthdaymmdd;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getConstellation() {
        return constellation;
    }

    public CvDTO getCv() {
        return cv;
    }

    public CostsDTO getCosts() {
        return costs;
    }

    public ImagesDTO getImages() {
        return images;
    }

    public String getVersion() {
        return version;
    }
}
