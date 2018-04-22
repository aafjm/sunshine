package com.example.demo.bean.jo;

/**
 * Created by fengjiamin on 2018/4/5.
 */
public class ActivityApplyJo {

    private int id;
    private String volName;
    private String mobile;
    private int activityId;
    private String activityName;
    private int status;


    public ActivityApplyJo() {
    }

    public ActivityApplyJo(int id, String volName, String mobile, int activityId, String activityName, int status) {
        this.id = id;
        this.volName = volName;
        this.mobile = mobile;
        this.activityId = activityId;
        this.activityName = activityName;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVolName() {
        return volName;
    }

    public void setVolName(String volName) {
        this.volName = volName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getActivityId() {
        return activityId;
    }

    public void setActivityId(int activityId) {
        this.activityId = activityId;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
