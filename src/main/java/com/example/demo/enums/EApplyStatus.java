package com.example.demo.enums;

/**
 * Created by fengjiamin on 2018/4/22.
 */
public enum EApplyStatus {
    WAIT(0, "申请中"),
    PASS(2, "通过"),
    REJECT(1, "拒绝");

    private int value;
    private String desc;

    EApplyStatus(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    EApplyStatus() {
    }

    public static EApplyStatus findByValue(Integer v) {
        if (v == null) return null;
        for (EApplyStatus item : allEnums) {
            if (item.getValue() == v) {
                return item;
            }
        }
        return null;
    }

    public static EApplyStatus findByDesc(String name) {
        if (name == null) return  null;
        for (EApplyStatus item: allEnums){
            if (item.getDesc().equals(name)){
                return  item;
            }
        }
        return null;
    }

    static {
        allEnums = EApplyStatus.class.getEnumConstants();
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

    private static EApplyStatus[] allEnums;


}
