package com.example.demo.bean.po;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ApplyActivityPO {
    @Id
    private int id;
    private int volunteerId;
    private int activityId;
    private Integer status;
    private long addtime;
    private long modtime;


    public ApplyActivityPO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVolunteerId() {
        return volunteerId;
    }

    public void setVolunteerId(int volunteerId) {
        this.volunteerId = volunteerId;
    }

    public int getActivityId() {
        return activityId;
    }

    public void setActivityId(int activityId) {
        this.activityId = activityId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public long getAddtime() {
        return addtime;
    }

    public void setAddtime(long addtime) {
        this.addtime = addtime;
    }

    public long getModtime() {
        return modtime;
    }

    public void setModtime(long modTime) {
        this.modtime = modtime;
    }
}
