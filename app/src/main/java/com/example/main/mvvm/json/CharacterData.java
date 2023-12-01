package com.example.main.mvvm.json;
import java.util.Map;
import java.util.List;

public class CharacterData {
    private String Element;
    private List<String> Consts;
    private List<Integer> SkillOrder;
    private Map<Integer, String> Skills;
    private Map<Integer, Integer> ProudMap;
    private String NameTextMapHash;
    private String SideIconName;
    private String QualityType;
    private Map<Integer, Costume> Costumes;

    public String getElement() {
        return Element;
    }

    public List<String> getConsts() {
        return Consts;
    }

    public List<Integer> getSkillOrder() {
        return SkillOrder;
    }

    public Map<Integer, String> getSkills() {
        return Skills;
    }

    public Map<Integer, Integer> getProudMap() {
        return ProudMap;
    }

    public String getNameTextMapHash() {
        return NameTextMapHash;
    }

    public String getSideIconName() {
        return SideIconName;
    }

    public String getQualityType() {
        return QualityType;
    }

    public Map<Integer, Costume> getCostumes() {
        return Costumes;
    }

    // getters and setters
    public static class Costume {
        private String sideIconName;
        private String icon;
        private String art;
        private int avatarId;

        // getters and setters
    }

}

