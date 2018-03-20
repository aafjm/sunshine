package com.example.demo.bean.jo;


import com.example.demo.bean.po.ActivityPO;

public class ActivityIdJo {
    private int id;
    private String name;

    public ActivityIdJo(ActivityPO po) {
        this.id = po.getId();
        this.name = po.getName();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
