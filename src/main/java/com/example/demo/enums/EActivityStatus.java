package com.example.demo.enums;

/**
 * Created by fengjiamin on 2018/3/17.
 */
public enum EActivityStatus {
    NORMOL(0, "正常"),
    DELETE(1, "删除");

    private int value;
    private String desc;

    EActivityStatus(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public static EActivityStatus findByValue(Integer v) {
        if (v == null) return null;
        for (EActivityStatus item : allEnums) {
            if (item.getValue() == v) {
                return item;
            }
        }
        return null;
    }

    public static EActivityStatus findByDesc(String name) {
        if (name == null) return  null;
        for (EActivityStatus item: allEnums){
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

    private static EActivityStatus[] allEnums;

    static {
        allEnums = EActivityStatus.class.getEnumConstants();
    }
}


