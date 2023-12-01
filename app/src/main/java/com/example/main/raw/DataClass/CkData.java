package com.example.main.raw.DataClass;

public class CkData {
   String name,rank_type,item_type,id;

    public CkData(String name, String rank_type, String item_type, String id) {
        this.name = name;
        this.rank_type = rank_type;
        this.item_type = item_type;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getRank_type() {
        return rank_type;
    }

    public String getItem_type() {
        return item_type;
    }

    public String getId() {
        return id;
    }
}
