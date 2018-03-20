package com.example.demo.bean.model;

/**
 * Created by fengjiamin on 2018/3/18.
 */
public class ActivityVolunteerModel {
    private int activityId;
    private int status;
    private int page;
    private int num;



    public ActivityVolunteerModel() {
    }

    public int getActivityId() {
        return activityId;
    }

    public void setActivityId(int activityId) {
        this.activityId = activityId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
