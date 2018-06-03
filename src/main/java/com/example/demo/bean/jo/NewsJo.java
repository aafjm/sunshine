package com.example.demo.bean.jo;

import com.example.demo.bean.po.NewsPO;

/**
 * Created by fengjiamin on 2018/4/27.
 */
public class NewsJo {
    private int id;
    private String title;
    private String author;
    private String content;
    private int top;
    private long top_time;
    private int status;
    private long addtime;

    public NewsJo() {
    }

    public NewsJo(NewsPO po) {
        id = po.getId();
        title = po.getTitle();
        author = po.getAuthor();
        content = po.getContent();
        top = po.getTop();
        top_time = po.getTop_time() * 1000L;
        status = po.getStatus();
        addtime = po.getAddtime() * 1000L;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public long getTop_time() {
        return top_time;
    }

    public void setTop_time(long top_time) {
        this.top_time = top_time;
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
}
