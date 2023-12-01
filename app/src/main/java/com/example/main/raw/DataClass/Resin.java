package com.example.main.raw.DataClass;

import java.util.List;

public class Resin {

    public int retcode;
    public String message;
    public DataDTO data;

    public static class DataDTO {
        public int current_resin;
        public int max_resin;
        public String resin_recovery_time;
        public int finished_task_num;
        public int total_task_num;
        public boolean is_extra_task_reward_received;
        public int current_expedition_num;
        public int max_expedition_num;
        public List<ExpeditionsDTO> expeditions;
        public int current_home_coin;
        public int max_home_coin;
        public boolean has_signed;
        public String sign_url;
        public Object daily_task;
        public String home_url;
        public String note_url;

        public static class ExpeditionsDTO {
            public String avatar_side_icon;
            public String status;
        }
    }
}
