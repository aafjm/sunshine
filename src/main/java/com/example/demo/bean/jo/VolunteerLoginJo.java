package com.example.demo.bean.jo;

import com.example.demo.bean.po.VolunteerPO;

/**
 * Created by fengjiamin on 2018/5/19.
 */
public class VolunteerLoginJo {

    private int id;
    private String name;
    private String mobile;
    private String email;
    private String idcode;
    private int sex;
    private int status;

    private int teamNum;
    private int activityNum;

    public VolunteerLoginJo(VolunteerPO po) {
        id = po.getId();
        name = po.getName();
        mobile = po.getMobile();
        email = po.getEmail();
        idcode = po.getIdcode();
        sex = po.getSex();
        status = po.getStatus();
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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdcode() {
        return idcode;
    }

    public void setIdcode(String idcode) {
        this.idcode = idcode;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getTeamNum() {
        return teamNum;
    }

    public void setTeamNum(int teamNum) {
        this.teamNum = teamNum;
    }

    public int getActivityNum() {
        return activityNum;
    }

    public void setActivityNum(int activityNum) {
        this.activityNum = activityNum;
    }
}
