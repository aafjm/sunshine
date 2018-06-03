package com.example.demo.bean.po;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by fengjiamin on 2018/4/27.
 */
@Entity
public class NewsPO {
    @Id
    private int id;
    private String title;
    private String author;
    private String content;
    private int top;
    private int top_time;
    private int status;
    private int addtime;
    private int modtime;

    public NewsPO() {
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

    public int getTop_time() {
        return top_time;
    }

    public void setTop_time(int top_time) {
        this.top_time = top_time;
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
