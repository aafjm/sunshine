package com.example.demo.bean.po;

import com.example.demo.bean.model.ActivityModel;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class ActivityPO {

    @Id
    private int id;
    private String name;
    private int teamId;
    private long startDate;
    private long endDate;
    private String note;
    private Integer maxNum;
    private Integer type;
    private Integer status;
    private long addtime = 0;
    private long modtime = 0;

    public ActivityPO() {
    }

    public ActivityPO(ActivityModel activityModel) {
        this.name = activityModel.getName();
        this.teamId = activityModel.getTeamId();
        this.startDate = activityModel.getStartDate();
        this.endDate = activityModel.getEndDate();
        this.note = activityModel.getNote();
        this.maxNum = activityModel.getMaxNum();
        this.type = activityModel.getType();
        this.status = 0;
    }

    public static void getActivityPO(ActivityPO po, ActivityModel model) {

        if (model.getName() != null && !model.getName().equals("")) {
            po.setName(model.getName());
        }
        if (model.getTeamId()!= null && model.getTeamId() != 0) {
            po.setTeamId(model.getTeamId());
        }
        if (model.getStartDate() != 0L) {
            po.setStartDate(model.getStartDate());
        }
        if (model.getEndDate() != 0L) {
            po.setEndDate(model.getEndDate());
        }
        if (model.getNote() != null && !model.getNote().equals("")) {
            po.setNote(model.getNote());
        }
        if (model.getMaxNum() != null) {
            po.setMaxNum(model.getMaxNum());
        }
        if (model.getType() != null) {
            po.setType(model.getType());
        }
        if (model.getStatus() != null) {
            po.setStatus(model.getStatus());
        }
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

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public long getStartDate() {
        return startDate;
    }

    public void setStartDate(long startDate) {
        this.startDate = startDate;
    }

    public long getEndDate() {
        return endDate;
    }

    public void setEndDate(long endDate) {
        this.endDate = endDate;
    }

    public void setMaxNum(Integer maxNum) {
        this.maxNum = maxNum;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getMaxNum() {
        return maxNum;
    }

    public void setMaxNum(int maxNum) {
        this.maxNum = maxNum;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
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
        this.modtime = modTime;
    }
}
