package com.example.demo.bean.po;


import com.example.demo.bean.model.VolunteerModel;
import com.example.demo.helper.Encrypt;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class VolunteerPO {

    @Id
    private int id;
    private String name;
    private String mobile;
    private String email;
    private String pwd;
    private String idcode;
    private int sex;
    private int status;
    private long addtime;
    private long modtime;


    public VolunteerPO() {
    }

    public VolunteerPO(VolunteerModel model) {
        name = model.getName();
        mobile = model.getMobile();
        email = model.getEmail();
        pwd = Encrypt.getMd5Result(model.getPwd(), "bendan");
        idcode = model.getIdcode();
        sex = model.getSex();
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

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getIdcode() {
        return idcode;
    }

    public void setIdcode(String idcode) {
        this.idcode = idcode;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
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
        this.modtime = modTime;
    }
}
