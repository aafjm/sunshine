package com.example.demo.bean.model;

/**
 * Created by fengjiamin on 2018/3/18.
 */
public class PageModel {

    private int page;
    private int num;

    public PageModel() {
    }

    public PageModel(int page, int num) {
        this.page = page;
        this.num = num;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
