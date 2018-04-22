package com.example.demo.bean.po;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by fengjiamin on 2018/3/29.
 */
@Entity
public class TeamMemberPO {

    @Id
    private int id;
    private int teamId;
    private int memberId;
    private int status;
    private long addtime;
    private long modtime;

    public TeamMemberPO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
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

    public void setModtime(long modtime) {
        this.modtime = modtime;
    }
}
