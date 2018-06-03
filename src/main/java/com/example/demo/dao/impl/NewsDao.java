package com.example.demo.dao.impl;

import com.example.demo.bean.model.NewsModel;
import com.example.demo.bean.po.NewsPO;
import com.example.demo.dao.INewsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by fengjiamin on 2018/4/27.
 */
@Repository
public class NewsDao implements INewsDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public int addNews(NewsPO po) {
        return jdbcTemplate.update("insert into news(title, author, content, addtime, modtime)" +
                        "values(?, ?, ?, unix_timestamp(), unix_timestamp())",
                po.getTitle(), po.getAuthor(), po.getContent());
    }

    @Override
    public void updateNewByStatus(int id, int status) {
        jdbcTemplate.update("update news set status=?, modtime = unix_timestamp() where id = ?",
                status, id);
    }

    @Override
    public void topNew(int id) {
        jdbcTemplate.update("update news set top= 1,top_time=unix_timestamp(), modtime = unix_timestamp() where id = ?",
                id);
    }

    @Override
    public void cancelTop(int id) {
        jdbcTemplate.update("update news set top= 0,modtime = unix_timestamp() where id = ?",
                id);
    }

    @Override
    public List<NewsPO> getNotTopNews(int status) {
        List<NewsPO> list = jdbcTemplate.query("select * from news where status = ? and top = 0", new Object[]{status}, new BeanPropertyRowMapper(NewsPO.class));
        if (list != null && list.size() > 0) {
            return list;
        } else {
            return null;
        }
    }

    @Override
    public List<NewsPO> getTopNews(int status) {
        List<NewsPO> list = jdbcTemplate.query("select * from news where status = ? and top = 1 order by top_time desc", new Object[]{status}, new BeanPropertyRowMapper(NewsPO.class));
        if (list != null && list.size() > 0) {
            return list;
        } else {
            return null;
        }
    }

    @Override
    public NewsPO getNewsById(int id) {
        List<NewsPO> list = jdbcTemplate.query("select * from news where id = ?", new Object[]{id}, new BeanPropertyRowMapper(NewsPO.class));
        if (list != null && list.size() > 0) {
            NewsPO po = list.get(0);
            return po;
        } else {
            return null;
        }
    }

    @Override
    public void updateNewsByModel(int id, NewsModel model) {
        jdbcTemplate.update("update news set title=?, content=?, author=?, modtime = unix_timestamp() where id = ?",
                model.getTitle(), model.getContent(), model.getAuthor(),id);
    }
}
