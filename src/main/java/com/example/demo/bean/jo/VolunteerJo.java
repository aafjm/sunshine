package com.example.demo.bean.jo;

import com.example.demo.bean.po.VolunteerPO;

/**
 * Created by fengjiamin on 2018/3/18.
 */
public class VolunteerJo {
    private int id;
    private String name;
    private String mobile;
    private String email;
    private String idcode;
    private Integer sex;
    private Integer status;

    public VolunteerJo() {
    }

    public VolunteerJo(VolunteerPO po){
        this.name = po.getName();
        this.mobile = po.getMobile();
        this.email = po.getEmail();
        this.idcode = po.getIdcode();
        this.sex = po.getSex();
        this.status = po.getStatus();
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
}
