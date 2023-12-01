package com.example.main.raw.Class_Custom;

import androidx.annotation.NonNull;

import java.util.List;

public class Bq_gson {

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
        public int remain_resin_discount_num;
        public int resin_discount_num_limit;
        public int current_expedition_num;
        public int max_expedition_num;
        public List<ExpeditionsDTO> expeditions;
        public int current_home_coin;
        public int max_home_coin;
        public String home_coin_recovery_time;
        public String calendar_url;
        public TransformerDTO transformer;

        public static class TransformerDTO {
            public boolean obtained;
            public RecoveryTimeDTO recovery_time;
            public String wiki;
            public boolean noticed;
            public String latest_job_id;

            public static class RecoveryTimeDTO {
                public int Day;
                public int Hour;
                public int Minute;
                public int Second;
                public boolean reached;


            }
        }

        public static class ExpeditionsDTO {
            public String avatar_side_icon;
            public String status;
            public String remained_time;
        }
    }

    @NonNull
    @Override
    public String toString() {
        return "Bq_gson{" +
                "retcode=" + retcode +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
