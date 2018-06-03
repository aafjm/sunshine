package com.example.demo.dao;

import com.example.demo.bean.model.NewsModel;
import com.example.demo.bean.po.NewsPO;
import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.List;

/**
 * Created by fengjiamin on 2018/4/27.
 */
public interface INewsDao {

    int addNews(NewsPO po);

    void updateNewByStatus(int id, int status);

    void topNew(int id);

    void cancelTop(int id);

    List<NewsPO> getNotTopNews(int status);

    List<NewsPO> getTopNews(int status);

    NewsPO getNewsById(int id);

    void updateNewsByModel(int id, NewsModel model);
}
