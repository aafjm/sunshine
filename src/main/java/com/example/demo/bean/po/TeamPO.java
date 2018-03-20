package com.example.demo.bean.po;

import com.example.demo.bean.model.TeamModel;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by fengjiamin on 2018/3/18.
 */
@Entity
public class TeamPO {
    @Id
    private int id;
    private String name;
    private String pic = "";
    private int leaderId;
    private String note = "";
    private int status;
    private int addtime;
    private int modtime;

    public TeamPO() {
    }

    public TeamPO(TeamModel teamModel) {
        name = teamModel.getName();
        if (teamModel.getPic() != null)
            pic = teamModel.getPic();
        if (teamModel.getNote() != null)
            note = teamModel.getNote();
        if (teamModel.getLeaderId() != null)
            leaderId = teamModel.getLeaderId();
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getAddtime() {
        return addtime;
    }

    public void setAddtime(int addtime) {
        this.addtime = addtime;
    }

    public int getModtime() {
        return modtime;
    }

    public void setModtime(int modtime) {
        this.modtime = modtime;
    }
}
