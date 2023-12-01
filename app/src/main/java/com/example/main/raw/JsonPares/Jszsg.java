package com.example.main.raw.JsonPares;
import androidx.annotation.NonNull;



import java.util.List;
import java.util.Map;

public class Jszsg {
    public PlayerInfoDTO getPlayerInfo() {
        return playerInfo;
    }

    public List<AvatarInfoListDTO> getAvatarInfoList() {
        return avatarInfoList;
    }

    public int getTtl() {
        return ttl;
    }

    public String getUid() {
        return uid;
    }

    public PlayerInfoDTO playerInfo;//玩家资料信息
    public List<AvatarInfoListDTO> avatarInfoList;//正在展示的每个角色的详细信息列表
    public int ttl;
    public String uid;



    public static class PlayerInfoDTO {
        public String getNickname() {
            return nickname;
        }

        public int getLevel() {
            return level;
        }

        public String getSignature() {
            return signature;
        }

        public int getWorldLevel() {
            return worldLevel;
        }

        public int getNameCardId() {
            return nameCardId;
        }

        public int getFinishAchievementNum() {
            return finishAchievementNum;
        }

        public int getTowerFloorIndex() {
            return towerFloorIndex;
        }

        public int getTowerLevelIndex() {
            return towerLevelIndex;
        }

        public List<ShowAvatarInfoListDTO> getShowAvatarInfoList() {
            return showAvatarInfoList;
        }

        public List<Integer> getShowNameCardIdList() {
            return showNameCardIdList;
        }

        public ProfilePictureDTO getProfilePicture() {
            return profilePicture;
        }

        public String nickname;//名字
        public int level;//冒险等级
        public String signature;//签名
        public int worldLevel;//世界等级
        public int nameCardId;//资料名片
        public int finishAchievementNum;//成就数量
        public int towerFloorIndex;//本期层数
        public int towerLevelIndex;//本期间数
        public List<ShowAvatarInfoListDTO> showAvatarInfoList;//角色id与等级
        public List<Integer> showNameCardIdList;//名片
        public ProfilePictureDTO profilePicture;//头像id

        public static class ProfilePictureDTO {
            public int getAvatarId() {
                return avatarId;
            }

            public int avatarId;
        }

        public static class ShowAvatarInfoListDTO {
            public int getAvatarId() {
                return avatarId;
            }

            public int getLevel() {
                return level;
            }

            public int avatarId;//角色id
            public int level;//冒险等级
        }
    }

    public static class AvatarInfoListDTO implements Cloneable{

        public int avatarId;//角色id

        public int getAvatarId() {
            return avatarId;
        }

        public int getSkillDepotId() {
            return skillDepotId;
        }

        public List<Integer> getInherentProudSkillList() {
            return inherentProudSkillList;
        }

        public List<EquipListDTO> getEquipList() {
            return equipList;
        }

        public FetterInfoDTO getFetterInfo() {
            return fetterInfo;
        }

        public List<Integer> getTalentIdList() {
            return talentIdList;
        }

        public ProudSkillExtraLevelMapDTO getProudSkillExtraLevelMap() {
            return proudSkillExtraLevelMap;
        }

        //public PropMapDTO propMap;
        private Map<String, Prop> propMap;//属性列表

        public Map<String, Prop> getPropMap() {
            return propMap;
        }
        public void setPropMap(Map<String, Prop> propMap) {
            this.propMap = propMap;
        }

        @NonNull
        @Override
        public AvatarInfoListDTO clone() {
            try {
                AvatarInfoListDTO clone = (AvatarInfoListDTO) super.clone();
                // TODO: 复制此处的可变状态，这样此克隆就不能更改初始克隆的内部
                return clone;
            } catch (CloneNotSupportedException e) {
                throw new AssertionError();
            }
        }

        public static class Prop {
            private int type;
            private String ival;
            private String val;

            public int getType() {
                return this.type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public String getIval() {
                return this.ival;
            }

            public void setIval(String ival) {
                this.ival = ival;
            }

            public String getVal() {
                return this.val;
            }

            public void setVal(String val) {
                this.val = val;
            }
        }

        public void setAvatarId(int avatarId) {
            this.avatarId = avatarId;
        }

        private Map<String, Double> fightPropMap;//战斗属性
        public Map<String, Double> getFightPropMap() {
            return fightPropMap;
        }
        public void setFightPropMap(Map<String, Double> fightPropMap) {
            this.fightPropMap = fightPropMap;
        }
        public Map<String, Integer> skillLevelMap ;//获取天赋等级


        public Map<String, Integer> getSkillLevelMap() {
            return skillLevelMap;
        }

        public void setSkillLevelMap(Map<String, Integer> skillLevelMap) {
            this.skillLevelMap = skillLevelMap;
        }

        public int skillDepotId;//天赋id
        public List<Integer> inherentProudSkillList;//固定天赋列表id
        public List<EquipListDTO> equipList;//装备列表：武器，圣遗物
        public FetterInfoDTO fetterInfo;//好感
        public List<Integer> talentIdList;//命座情况
        public ProudSkillExtraLevelMapDTO proudSkillExtraLevelMap;//玩家头像的角色ID

        public static class PropMapDTO {
            public _$1001DTO get_$1001() {
                return _$1001;
            }

            public _$1002DTO get_$1002() {
                return _$1002;
            }

            public _$1003DTO get_$1003() {
                return _$1003;
            }

            public _$1004DTO get_$1004() {
                return _$1004;
            }

            public _$4001DTO get_$4001() {
                return _$4001;
            }

            public _$10010DTO get_$10010() {
                return _$10010;
            }

            public _$1001DTO _$1001;//当前雷元素能量
            public _$1002DTO _$1002;//当前水元素能量
            public _$1003DTO _$1003;//当前草元素能量
            public _$1004DTO _$1004;//当前风元素能量
            public _$4001DTO _$4001;//等级
            public _$10010DTO _$10010;

            public static class _$1001DTO {
                public int type;//属性类型
                public String ival;//忽略

                public int getType() {
                    return type;
                }

                public String getIval() {
                    return ival;
                }
            }

            public static class _$1002DTO {
                public int type;//属性类型
                public String ival;

                public int getType() {
                    return type;
                }

                public String getIval() {
                    return ival;
                }

                public String getVal() {
                    return val;
                }

                public String val;
            }

            public static class _$1003DTO {
                public int type;
                public String ival;

                public int getType() {
                    return type;
                }

                public String getIval() {
                    return ival;
                }
            }

            public static class _$1004DTO {
                public int type;

                public int getType() {
                    return type;
                }

                public String getIval() {
                    return ival;
                }

                public String ival;
            }

            public static class _$4001DTO {
                public int type;
                public String ival;
                public String val;

                public int getType() {
                    return type;
                }

                public String getIval() {
                    return ival;
                }

                public String getVal() {
                    return val;
                }
            }

            public static class _$10010DTO {
                public int type;
                public String ival;

                public int getType() {
                    return type;
                }

                public String getIval() {
                    return ival;
                }

                public String getVal() {
                    return val;
                }

                public String val;
            }
        }

        public static class FightPropMapDTO {
            public double get_$1() {
                return _$1;
            }

            public int get_$2() {
                return _$2;
            }

            public double get_$3() {
                return _$3;
            }

            public double get_$4() {
                return _$4;
            }

           public double get_$5() {
                return _$5;
            }

            public double get_$6() {
                return _$6;
            }

            public double get_$7() {
                return _$7;
            }
            public double get_$8() {
                return _$8;
            }

            public double get_$20() {
                return _$20;
            }

            public int get_$21() {
                return _$21;
            }

            public double get_$22() {
                return _$22;
            }

            public double get_$23() {
                return _$23;
            }

            public int get_$26() {
                return _$26;
            }

            public int get_$27() {
                return _$27;
            }

            public double get_$28() {
                return _$28;
            }

            public int get_$29() {
                return _$29;
            }

            public int get_$30() {
                return _$30;
            }

            public double get_$40() {
                return _$40;
            }

            public int get_$41() {
                return _$41;
            }

            public int get_$42() {
                return _$42;
            }

            public int get_$43() {
                return _$43;
            }

            public int get_$44() {
                return _$44;
            }

            public int get_$45() {
                return _$45;
            }

            public int get_$46() {
                return _$46;
            }

            public int get_$50() {
                return _$50;
            }

            public int get_$51() {
                return _$51;
            }

            public int get_$52() {
                return _$52;
            }

            public int get_$53() {
                return _$53;
            }

            public int get_$54() {
                return _$54;
            }

            public int get_$55() {
                return _$55;
            }

            public int get_$56() {
                return _$56;
            }

            public int get_$70() {
                return _$70;
            }

            public int get_$1000() {
                return _$1000;
            }

            public double get_$1010() {
                return _$1010;
            }

            public double get_$2000() {
                return _$2000;
            }

            public double get_$2001() {
                return _$2001;
            }

            public double get_$2002() {
                return _$2002;
            }

            public int get_$2003() {
                return _$2003;
            }

            public int get_$3045() {
                return _$3045;
            }

            public int get_$3046() {
                return _$3046;
            }

            public double _$1;//基础生命值
            public int _$2;//生命值
            public double _$3;//生命值百分比
            public double _$4;//基础攻击力
            public double _$5;//攻击力
            public double _$6;//攻击力百分比
            public double _$7;//基础防御力
            public double _$8;//防御力
            public double _$20;//暴击率
            public int _$21;//??
            public double _$22;//暴击伤害
            public double _$23;//元素充能效率
            public int _$26;//治疗加成
            public int _$27;//受治疗加成
            public double _$28;//元素精通
            public int _$29;//物理抗性
            public int _$30;//物理伤害加成
            public double _$40;//火元素伤害加成
            public int _$41;//雷元素伤害加成
            public int _$42;//	水元素伤害加成
            public int _$43;//	草元素伤害加成
            public int _$44;//	风元素伤害加成
            public int _$45;//岩元素伤害加成
            public int _$46;//	冰元素伤害加成
            public int _$50;//	火元素抗性
            public int _$51;//	雷元素抗性
            public int _$52;//	水元素抗性
            public int _$53;//草元素抗性
            public int _$54;//风元素抗性
            public int _$55;//岩元素抗性
            public int _$56;//冰元素抗性
            public int _$70;//火元素能量需求（元素爆发
            public int _$1000;//当前火元素能量
            public double _$1010;//当前生命值
            public double _$2000;//生命值上限
            public double _$2001;//	攻击力
            public double _$2002;//防御力
            public int _$2003;//速度
            public int _$3045;//元素反应暴击率
            public int _$3046;//元素反应暴击伤害
        }

        public static class SkillLevelMapDTO {
            public int _$10491;
            public int _$10492;
            public int _$10495;

            public int get_$10491() {
                return _$10491;
            }

            public int get_$10492() {
                return _$10492;
            }

            public int get_$10495() {
                return _$10495;
            }
        }

        public static class FetterInfoDTO {
            public int expLevel;

            public int getExpLevel() {
                return expLevel;
            }
        }

        public static class ProudSkillExtraLevelMapDTO {
            public int _$4832;

            public int get_$4832() {
                return _$4832;
            }

            public int get_$4839() {
                return _$4839;
            }

            public int _$4839;
        }

        public static class EquipListDTO {
            public int getItemId() {
                return itemId;
            }

            public ReliquaryDTO getReliquary() {
                return reliquary;
            }

            public FlatDTO getFlat() {
                return flat;
            }

            public WeaponDTO getWeapon() {
                return weapon;
            }

            public int itemId;//装备id
            public ReliquaryDTO reliquary;//圣遗物基本信息
            public FlatDTO flat;//装备详细信息
            public WeaponDTO weapon;//武器基本信息

            public static class ReliquaryDTO {
                public int getLevel() {
                    return level;
                }

                public int getMainPropId() {
                    return mainPropId;
                }

                public List<Integer> getAppendPropIdList() {
                    return appendPropIdList;
                }

                public int level;//圣遗物等级
                public int mainPropId;//圣遗物主属性ID
                public List<Integer> appendPropIdList;//圣遗物副属性ID
            }

            public static class FlatDTO {

                public static class WeaponStatsDTO {
                    public String appendPropId;
                    public double statValue;
                }
                public String getNameTextMapHash() {
                    return nameTextMapHash;
                }

                public String getSetNameTextMapHash() {
                    return setNameTextMapHash;
                }

                public int getRankLevel() {
                    return rankLevel;
                }

                public ReliquaryMainstatDTO getReliquaryMainstat() {
                    return reliquaryMainstat;
                }

                public List<ReliquarySubstatsDTO> getReliquarySubstats() {
                    return reliquarySubstats;
                }

                public String getItemType() {
                    return itemType;
                }

                public String getIcon() {
                    return icon;
                }

                public String getEquipType() {
                    return equipType;
                }

                public String nameTextMapHash;//装备名的哈希值
                public String setNameTextMapHash;//圣遗物套装的名称的哈希值
                public int rankLevel;//装备稀有度
                public List<WeaponStatsDTO> weaponStats;
                public void setNameTextMapHash(String nameTextMapHash) {
                    this.nameTextMapHash = nameTextMapHash;
                }

                public void setSetNameTextMapHash(String setNameTextMapHash) {
                    this.setNameTextMapHash = setNameTextMapHash;
                }

                public void setRankLevel(int rankLevel) {
                    this.rankLevel = rankLevel;
                }

                public void setReliquaryMainstat(ReliquaryMainstatDTO reliquaryMainstat) {
                    this.reliquaryMainstat = reliquaryMainstat;
                }

                public void setReliquarySubstats(List<ReliquarySubstatsDTO> reliquarySubstats) {
                    this.reliquarySubstats = reliquarySubstats;
                }

                public void setItemType(String itemType) {
                    this.itemType = itemType;
                }

                public void setIcon(String icon) {
                    this.icon = icon;
                }

                public void setEquipType(String equipType) {
                    this.equipType = equipType;
                }

                public ReliquaryMainstatDTO reliquaryMainstat;//圣遗物主属性
                public List<ReliquarySubstatsDTO> reliquarySubstats;//圣遗物副属性列表
                public String itemType;//装备类别：武器、圣遗物
                public String icon;//装备图标名称
                public String equipType;//圣遗物类型

                public static class ReliquaryMainstatDTO {
                    public String getMainPropId() {
                        return mainPropId;
                    }

                    public float getStatValue() {
                        return statValue;
                    }

                    public String mainPropId;

                    public void setMainPropId(String mainPropId) {
                        this.mainPropId = mainPropId;
                    }

                    public void setStatValue(float statValue) {
                        this.statValue = statValue;
                    }

                    public float statValue;
                }

                public static class ReliquarySubstatsDTO {
                    public String getAppendPropId() {
                        return appendPropId;
                    }

                    public double getStatValue() {
                        return statValue;
                    }

                    public String appendPropId;//装备属性名称
                    public double statValue;
                }
            }








            public static class WeaponDTO {
                public int getLevel() {
                    return level;
                }

                public int getPromoteLevel() {
                    return promoteLevel;
                }



                public int level;
                public int promoteLevel;
                public Map<String,Integer> affixMap;


            }
        }
    }

}
