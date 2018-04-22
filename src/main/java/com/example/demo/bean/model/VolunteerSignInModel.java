package com.example.demo.bean.model;

/**
 * Created by fengjiamin on 2018/3/20.
 */
public class VolunteerSignInModel {
    private int id;
    private String pwd;

    public VolunteerSignInModel() {
    }

    public VolunteerSignInModel(int id, String pwd) {
        this.id = id;
        this.pwd = pwd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
