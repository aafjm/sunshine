package com.example.demo.bean.jo;

import com.example.demo.bean.po.TeamPO;

/**
 * Created by fengjiamin on 2018/3/18.
 */
public class TeamJo {

    private int id;
    private String name;
    private String pic;
    private int leaderId;
    private int leaderName;
    private String note;
    private long addtime;

    public TeamJo() {
    }

    public TeamJo(TeamPO po) {
        id = po.getId();
        name = po.getName();
        pic = po.getPic();
        leaderId = po.getLeaderId();
        note = po.getNote();
        addtime = po.getAddtime() * 1000;
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

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public int getLeaderId() {
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


    public long getAddtime() {
        return addtime;
    }

    public void setAddtime(long addtime) {
        this.addtime = addtime;
    }
}

