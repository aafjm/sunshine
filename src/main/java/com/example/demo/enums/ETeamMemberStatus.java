package com.example.demo.enums;

/**
 * Created by fengjiamin on 2018/3/29.
 */
public enum ETeamMemberStatus {
    NORMOL(0, "正常"),
    DELETE(1, "删除");

    private int value;
    private String desc;

    ETeamMemberStatus(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public static ETeamMemberStatus findByValue(Integer v) {
        if (v == null) return null;
        for (ETeamMemberStatus item : allEnums) {
            if (item.getValue() == v) {
                return item;
            }
        }
        return null;
    }

    public static ETeamMemberStatus findByDesc(String name) {
        if (name == null) return  null;
        for (ETeamMemberStatus item: allEnums){
            if (item.getDesc().equals(name)){
                return  item;
            }
        }
        return null;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    private static ETeamMemberStatus[] allEnums;

    static {
        allEnums = ETeamMemberStatus.class.getEnumConstants();
    }
}
