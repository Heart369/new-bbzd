package com.example.main.raw.JsonPares;

import java.util.List;

public class Js_Wq {

    public int retcode;
    public String message;
    public DataDTO data;//数据

    public int getRetcode() {
        return retcode;
    }

    public String getMessage() {
        return message;
    }

    public DataDTO getData() {
        return data;
    }

    public static class DataDTO {
        public List<AvatarsDTO> avatars;//全角色武器
        public RoleDTO role;

        public List<AvatarsDTO> getAvatars() {
            return avatars;
        }

        public static class RoleDTO {
            public String avatarUrl;//无东西
            public String nickname;//用户名
            public String region;//服务器
            public int level;//冒险等级

            public String getAvatarUrl() {
                return avatarUrl;
            }

            public String getNickname() {
                return nickname;
            }

            public String getRegion() {
                return region;
            }

            public int getLevel() {
                return level;
            }
        }

        public static class AvatarsDTO {
            public int id;//角色在内部的编号
            public String image;//立绘
            public String icon;//头像
            public String name;//名字
            public String element;//系别
            public int fetter;//好感等级
            public int level;//等级
            public int rarity;//星级
            public WeaponDTO weapon;//角色拿的武器
            public List<ReliquariesDTO> reliquaries;//圣遗物
            public int actived_constellation_num;//命座等级
            public List<?> costumes;//没东西
            public Object external;//空
            public List<ConstellationsDTO> constellations;

            public int getId() {
                return id;
            }

            public String getImage() {
                return image;
            }

            public String getIcon() {
                return icon;
            }

            public String getName() {
                return name;
            }

            public String getElement() {
                return element;
            }

            public int getFetter() {
                return fetter;
            }

            public int getLevel() {
                return level;
            }

            public int getRarity() {
                return rarity;
            }

            public WeaponDTO getWeapon() {
                return weapon;
            }

            public List<ReliquariesDTO> getReliquaries() {
                return reliquaries;
            }

            public int getActived_constellation_num() {
                return actived_constellation_num;
            }

            public List<?> getCostumes() {
                return costumes;
            }

            public Object getExternal() {
                return external;
            }

            public List<ConstellationsDTO> getConstellations() {
                return constellations;
            }

            public static class WeaponDTO {
                public int id;//武器id
                public String name;//武器名
                public String icon;//武器图标
                public int type;//
                public int rarity;//星级
                public int level;//等级
                public int promote_level;//星级_突破阶
                public String type_name;//武器系别
                public String desc;//武器介绍
                public int affix_level;//精炼等级

                public int getId() {
                    return id;
                }

                public String getName() {
                    return name;
                }

                public String getIcon() {
                    return icon;
                }

                public int getType() {
                    return type;
                }

                public int getRarity() {
                    return rarity;
                }

                public int getLevel() {
                    return level;
                }

                public int getPromote_level() {
                    return promote_level;
                }

                public String getType_name() {
                    return type_name;
                }

                public String getDesc() {
                    return desc;
                }

                public int getAffix_level() {
                    return affix_level;
                }
            }

            public static class ReliquariesDTO {
                public int id;//圣遗物id
                public String name;//圣遗物名字
                public String icon;//圣遗物图标
                public int pos;//位置
                public int rarity;//阶级
                public int level;//等级
                public SetDTO set;//圣遗物所属套装属性
                public String pos_name;//位置名

                public int getId() {
                    return id;
                }

                public String getName() {
                    return name;
                }

                public String getIcon() {
                    return icon;
                }

                public int getPos() {
                    return pos;
                }

                public int getRarity() {
                    return rarity;
                }

                public int getLevel() {
                    return level;
                }

                public SetDTO getSet() {
                    return set;
                }

                public String getPos_name() {
                    return pos_name;
                }

                public static class SetDTO {
                    public int id;//套装id
                    public String name;//套装名
                    public List<AffixesDTO> affixes;//2词条和4词条

                    public int getId() {
                        return id;
                    }

                    public String getName() {
                        return name;
                    }

                    public List<AffixesDTO> getAffixes() {
                        return affixes;
                    }

                    public static class AffixesDTO {
                        public int activation_number;//2还是4
                        public String effect;//作用

                        public int getActivation_number() {
                            return activation_number;
                        }

                        public String getEffect() {
                            return effect;
                        }
                    }
                }
            }

            public static class ConstellationsDTO {
                public int id;//id
                public String name;//命座名
                public String icon;//图标
                public String effect;//作用
                public boolean is_actived;//是否解锁
                public int pos;//第几个

                public int getId() {
                    return id;
                }

                public String getName() {
                    return name;
                }

                public String getIcon() {
                    return icon;
                }

                public String getEffect() {
                    return effect;
                }

                public boolean isIs_actived() {
                    return is_actived;
                }

                public int getPos() {
                    return pos;
                }
            }
        }
    }
}
