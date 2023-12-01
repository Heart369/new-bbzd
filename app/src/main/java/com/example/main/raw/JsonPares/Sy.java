package com.example.main.raw.JsonPares;

import java.util.List;

public class Sy {

    public int retcode;
    public String message;
    public DataDTO data;

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
        public int schedule_id;
        public String start_time;//开始时间
        public String end_time;//结束时间
        public int total_battle_times;//战斗次数
        public int total_win_times;//胜利次数
        public String max_floor;//最深到达
        public List<RevealRankDTO> reveal_rank;//挑战次数
        public List<DefeatRankDTO> defeat_rank;//最高击破
        public List<DamageRankDTO> damage_rank;//最高伤害
        public List<TakeDamageRankDTO> take_damage_rank;//最高承受伤害
        public List<NormalSkillRankDTO> normal_skill_rank;//元素战绩次数
        public List<EnergySkillRankDTO> energy_skill_rank;//爆发
        public List<FloorsDTO> floors;//每层角色
        public int total_star;//总星级
        public boolean is_unlock;

        public int getSchedule_id() {
            return schedule_id;
        }

        public String getStart_time() {
            return start_time;
        }

        public String getEnd_time() {
            return end_time;
        }

        public int getTotal_battle_times() {
            return total_battle_times;
        }

        public int getTotal_win_times() {
            return total_win_times;
        }

        public String getMax_floor() {
            return max_floor;
        }

        public List<RevealRankDTO> getReveal_rank() {
            return reveal_rank;
        }

        public List<DefeatRankDTO> getDefeat_rank() {
            return defeat_rank;
        }

        public List<DamageRankDTO> getDamage_rank() {
            return damage_rank;
        }

        public List<TakeDamageRankDTO> getTake_damage_rank() {
            return take_damage_rank;
        }

        public List<NormalSkillRankDTO> getNormal_skill_rank() {
            return normal_skill_rank;
        }

        public List<EnergySkillRankDTO> getEnergy_skill_rank() {
            return energy_skill_rank;
        }

        public List<FloorsDTO> getFloors() {
            return floors;
        }

        public int getTotal_star() {
            return total_star;
        }

        public boolean isIs_unlock() {
            return is_unlock;
        }

        public static class RevealRankDTO {
            public int avatar_id;//角色编号
            public String avatar_icon;//图片地址
            public int value;//次数
            public int rarity;//星级

            public String getAvatar_icon() {
                return avatar_icon;
            }

            public int getValue() {
                return value;
            }

            public int getRarity() {
                return rarity;
            }
        }

        public static class DefeatRankDTO {
            public int avatar_id;
            public String avatar_icon;
            public int value;
            public int rarity;

            public int getAvatar_id() {
                return avatar_id;
            }

            public String getAvatar_icon() {
                return avatar_icon;
            }

            public int getValue() {
                return value;
            }

            public int getRarity() {
                return rarity;
            }
        }

        public static class DamageRankDTO {
            public int avatar_id;
            public String avatar_icon;
            public int value;
            public int rarity;

            public int getAvatar_id() {
                return avatar_id;
            }

            public String getAvatar_icon() {
                return avatar_icon;
            }

            public int getValue() {
                return value;
            }

            public int getRarity() {
                return rarity;
            }
        }

        public static class TakeDamageRankDTO {
            public int avatar_id;
            public String avatar_icon;
            public int value;
            public int rarity;

            public int getAvatar_id() {
                return avatar_id;
            }

            public String getAvatar_icon() {
                return avatar_icon;
            }

            public int getValue() {
                return value;
            }

            public int getRarity() {
                return rarity;
            }
        }

        public static class NormalSkillRankDTO {
            public int avatar_id;
            public String avatar_icon;
            public int value;
            public int rarity;

            public int getAvatar_id() {
                return avatar_id;
            }

            public String getAvatar_icon() {
                return avatar_icon;
            }

            public int getValue() {
                return value;
            }

            public int getRarity() {
                return rarity;
            }

            public NormalSkillRankDTO(int avatar_id, String avatar_icon, int value, int rarity) {
                this.avatar_id = avatar_id;
                this.avatar_icon = avatar_icon;
                this.value = value;
                this.rarity = rarity;
            }
        }

        public static class EnergySkillRankDTO {
            public int avatar_id;
            public String avatar_icon;
            public int value;
            public int rarity;

            public int getAvatar_id() {
                return avatar_id;
            }

            public String getAvatar_icon() {
                return avatar_icon;
            }

            public int getValue() {
                return value;
            }

            public int getRarity() {
                return rarity;
            }

            public EnergySkillRankDTO(int avatar_id, String avatar_icon, int value, int rarity) {
                this.avatar_id = avatar_id;
                this.avatar_icon = avatar_icon;
                this.value = value;
                this.rarity = rarity;
            }
        }

        public static class FloorsDTO {
            public int index;//层数
            public String icon;//
            public boolean is_unlock;//是否完成
            public String settle_time;//0
            public int star;//拿了多少
            public int max_star;//最多多少
            public List<LevelsDTO> levels;

            public int getIndex() {
                return index;
            }

            public String getIcon() {
                return icon;
            }

            public boolean isIs_unlock() {
                return is_unlock;
            }

            public String getSettle_time() {
                return settle_time;
            }

            public int getStar() {
                return star;
            }

            public int getMax_star() {
                return max_star;
            }

            public List<LevelsDTO> getLevels() {
                return levels;
            }

            public static class LevelsDTO {
                public int index;//第几间
                public int star;//拿了多少
                public int max_star;//一共多少
                public List<BattlesDTO> battles;

                public int getIndex() {
                    return index;
                }

                public int getStar() {
                    return star;
                }

                public int getMax_star() {
                    return max_star;
                }

                public List<BattlesDTO> getBattles() {
                    return battles;
                }

                public static class BattlesDTO {
                    public int index;
                    public String timestamp;//时间戳
                    public List<AvatarsDTO> avatars;

                    public int getIndex() {
                        return index;
                    }

                    public String getTimestamp() {
                        return timestamp;
                    }

                    public List<AvatarsDTO> getAvatars() {
                        return avatars;
                    }

                    public static class AvatarsDTO {
                        public int id;//角色id
                        public String icon;//图片
                        public int level;//等级
                        public int rarity;//星级

                        public int getId() {
                            return id;
                        }

                        public String getIcon() {
                            return icon;
                        }

                        public int getLevel() {
                            return level;
                        }

                        public int getRarity() {
                            return rarity;
                        }
                    }
                }
            }
        }
    }
}
