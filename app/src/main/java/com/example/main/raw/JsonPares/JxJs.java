package com.example.main.raw.JsonPares;

import java.util.List;

public class JxJs {
    public int retcode;
    public String message;
    public DataDTO data;

    public static class DataDTO {
        public RoleDTO role;
        public List<AvatarsDTO> avatars;
        public StatsDTO stats;
        public List<?> city_explorations;
        public List<WorldExplorationsDTO> world_explorations;
        public List<HomesDTO> homes;

        public List<AvatarsDTO> getAvatars() {
            return avatars;
        }

        public static class RoleDTO {
            public String avatarUrl;
            public String nickname;
            public String region;
            public int level;
        }

        public static class StatsDTO {
            public int active_day_number;
            public int achievement_number;
            public int anemoculus_number;
            public int geoculus_number;
            public int avatar_number;
            public int way_point_number;
            public int domain_number;
            public String spiral_abyss;
            public int precious_chest_number;
            public int luxurious_chest_number;
            public int exquisite_chest_number;
            public int common_chest_number;
            public int electroculus_number;
            public int magic_chest_number;
            public int dendroculus_number;
        }

        public static class AvatarsDTO {
            public int id;
            public String image;
            public String name;
            public String element;
            public int fetter;
            public int level;
            public int rarity;
            public int actived_constellation_num;
            public String card_image;
            public boolean is_chosen;

            public int getId() {
                return id;
            }

            public String getImage() {
                return image;
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
            public int getActived_constellation_num() {
                return actived_constellation_num;
            }

            public String getCard_image() {
                return card_image;
            }

            public boolean isIs_chosen() {
                return is_chosen;
            }
        }

        public static class WorldExplorationsDTO {
            public int level;
            public int exploration_percentage;
            public String icon;
            public String name;
            public String type;
            public List<OfferingsDTO> offerings;
            public int id;
            public int parent_id;
            public String map_url;
            public String strategy_url;
            public String background_image;
            public String inner_icon;
            public String cover;

            public static class OfferingsDTO {
                public String name;
                public int level;
                public String icon;
            }
        }

        public static class HomesDTO {
            public int level;
            public int visit_num;
            public int comfort_num;
            public int item_num;
            public String name;
            public String icon;
            public String comfort_level_name;
            public String comfort_level_icon;
        }
    }

    public int getRetcode() {
        return retcode;
    }

    public String getMessage() {
        return message;
    }

    public DataDTO getData() {
        return data;
    }
}
