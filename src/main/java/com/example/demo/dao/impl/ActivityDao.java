package com.example.demo.dao.impl;

import com.example.demo.bean.jo.ActivityIdJo;
import com.example.demo.bean.po.ActivityPO;
import com.example.demo.bean.to.PageTo;
import com.example.demo.dao.IActivityDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class ActivityDao implements IActivityDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int add(ActivityPO Activity) {
        return jdbcTemplate.update("insert into activity(name, teamId, startDate, endDate, note, maxNum, " +
                        "type, status, addtime, modtime) values(?, ?, ?, ?, ?, ?, ?, ?, unix_timestamp(), unix_timestamp())",
                Activity.getName(), Activity.getTeamId(), Activity.getStartDate(),
                Activity.getEndDate(), Activity.getNote(), Activity.getMaxNum(), Activity.getType(),
                Activity.getStatus());
    }

    @Override
    public int update(ActivityPO Activity) {
        return jdbcTemplate.update("update activity set name=?, teamId=?, startDate=?, endDate=?, note=?, maxNum=?, " +
                        "type=?, status=?, modtime=unix_timestamp() where id = ?",
                Activity.getName(), Activity.getTeamId(), Activity.getStartDate(),
                Activity.getEndDate(), Activity.getNote(), Activity.getMaxNum(), Activity.getType(),
                Activity.getStatus(), Activity.getId());
    }

    @Override
    public ActivityPO findActivityById(int id) {
        List<ActivityPO> list = jdbcTemplate.query("select * from activity where id = ?", new Object[]{id}, new BeanPropertyRowMapper(ActivityPO.class));
        if (list != null && list.size() > 0) {
            ActivityPO activity = list.get(0);
            return activity;
        } else {
            return null;
        }
    }

    @Override
    public List<ActivityPO> getAllActivity() {
        List<ActivityPO> list = jdbcTemplate.query("select * from activity", new BeanPropertyRowMapper(ActivityPO.class));
        if (list != null && list.size() > 0) {
            return list;
        } else {
            return null;
        }
    }
}
