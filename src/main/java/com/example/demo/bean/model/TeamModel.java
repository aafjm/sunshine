package com.example.demo.bean.model;

/**
 * Created by fengjiamin on 2018/3/19.
 */
public class TeamModel {

    private String name;
    private String pic;
    private Integer leaderId;
    private String note;

    public TeamModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public Integer getLeaderId() {
        return leaderId;
    }

    public void setLeaderId(int leaderId) {
        this.leaderId = leaderId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
