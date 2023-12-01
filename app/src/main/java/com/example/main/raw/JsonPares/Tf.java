package com.example.main.raw.JsonPares;

import java.util.List;

public class Tf {

    public String name;
    public Combat1DTO combat1;
    public Combat2DTO combat2;
    public Combat3DTO combat3;
    public Passive1DTO passive1;
    public Passive2DTO passive2;
    public Passive3DTO passive3;
    public CostsDTO costs;
    public ImagesDTO images;
    public String version;

    public static class Combat1DTO {
        public String name;
        public String info;
        public AttributesDTO attributes;

        public static class AttributesDTO {
            public List<String> labels;
            public ParametersDTO parameters;

            public static class ParametersDTO {
                public List<Double> param1;
                public List<Double> param2;
                public List<Double> param3;
                public List<Double> param4;
                public List<Double> param5;
                public List<Double> param6;
                public List<Double> param7;
                public List<Double> param8;
                public List<Integer> param9;
                public List<Double> param10;
                public List<Double> param11;
                public List<Double> param12;
            }
        }
    }

    public static class Combat2DTO {
        public String name;
        public String info;
        public String description;
        public AttributesDTO attributes;

        public static class AttributesDTO {
            public List<String> labels;
            public ParametersDTO parameters;

            public static class ParametersDTO {
                public List<Double> param1;
                public List<Double> param2;
                public List<Double> param3;
                public List<Double> param4;
                public List<Double> param5;
                public List<Double> param6;
                public List<Double> param7;
                public List<Double> param8;
                public List<Double> param9;
                public List<Integer> param10;
                public List<Integer> param11;
            }
        }
    }

    public static class Combat3DTO {
        public String name;
        public String info;
        public String description;
        public AttributesDTO attributes;

        public static class AttributesDTO {
            public List<String> labels;
            public ParametersDTO parameters;

            public static class ParametersDTO {
                public List<Double> param1;
                public List<Double> param2;
                public List<Integer> param3;
                public List<Integer> param4;
                public List<Integer> param5;
                public List<Integer> param6;
                public List<Integer> param7;
                public List<Integer> param8;
            }
        }
    }

    public static class Passive1DTO {
        public String name;
        public String info;
    }

    public static class Passive2DTO {
        public String name;
        public String info;
    }

    public static class Passive3DTO {
        public String name;
        public String info;
    }

    public static class CostsDTO {
        public List<Lvl2DTO> lvl2;
        public List<Lvl3DTO> lvl3;
        public List<Lvl4DTO> lvl4;
        public List<Lvl5DTO> lvl5;
        public List<Lvl6DTO> lvl6;
        public List<Lvl7DTO> lvl7;
        public List<Lvl8DTO> lvl8;
        public List<Lvl9DTO> lvl9;
        public List<Lvl10DTO> lvl10;

        public static class Lvl2DTO {
            public String name;
            public int count;
        }

        public static class Lvl3DTO {
            public String name;
            public int count;
        }

        public static class Lvl4DTO {
            public String name;
            public int count;
        }

        public static class Lvl5DTO {
            public String name;
            public int count;
        }

        public static class Lvl6DTO {
            public String name;
            public int count;
        }

        public static class Lvl7DTO {
            public String name;
            public int count;
        }

        public static class Lvl8DTO {
            public String name;
            public int count;
        }

        public static class Lvl9DTO {
            public String name;
            public int count;
        }

        public static class Lvl10DTO {
            public String name;
            public int count;
        }
    }

    public static class ImagesDTO {
        public String combat1;
        public String combat2;
        public String combat3;
        public String passive1;
        public String passive2;
        public String passive3;
    }
}
