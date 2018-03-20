package com.example.demo.bean.jo;


import com.example.demo.bean.po.ActivityPO;

public class ActivityJo {
    private int id;
    private String name;
    private int teamId;
    private String teamName;
    private String startDate;
    private String endDate;
    private String note;
    private Integer maxNum;
    private Integer status;
    private long addtime;

    public ActivityJo(ActivityPO po) {
        this.id = po.getId();
        this.name = po.getName();
        this.teamId = po.getTeamId();
        this.startDate = po.getStartDate();
        this.endDate = po.getEndDate();
        this.note = po.getNote();
        this.maxNum = po.getMaxNum();
        this.status = po.getStatus();
        this.addtime = po.getAddtime() * 1000;
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

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getMaxNum() {
        return maxNum;
    }

    public void setMaxNum(Integer maxNum) {
        this.maxNum = maxNum;
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

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
}
