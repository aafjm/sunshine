package com.example.demo.bean.to;


public class PageTo {
    private int limit;
    private int offset;

    public PageTo(int page, int num) {
        this.limit = num;
        this.offset = page * num - num;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }
}
