package com.example.demo.dao.impl;

import com.example.demo.bean.po.ApplyActivityPO;
import com.example.demo.dao.IApplyActivityDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class ApplyActivityDao implements IApplyActivityDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public int add(ApplyActivityPO po) {

        return jdbcTemplate.update("insert into applyActivity(volunteerId, activityId, status, addtime, modtime) values(?, ?, ?, unix_timestamp(), unix_timestamp())",
                po.getVolunteerId(), po.getActivityId(), po.getStatus());
    }


    @Override
    public int update(int id, int status) {
        return jdbcTemplate.update("update applyActivity set status=?, modtime = unix_timestamp() where id = ?",
                status, id);
    }

    @Override
    public List<ApplyActivityPO> findAllVolsByActId(int id, int status) {
        List<ApplyActivityPO> list = jdbcTemplate.query("select * from applyActivity where id = ? and status = ?", new Object[]{id, status}, new BeanPropertyRowMapper(ApplyActivityPO.class));
        if (list != null && list.size() > 0) {
            return list;
        } else {
            return null;
        }
    }

    @Override
    public List<ApplyActivityPO> findAllVolsByStatus(int status) {
        List<ApplyActivityPO> list = jdbcTemplate.query("select * from applyActivity where status = ?", new Object[]{status}, new BeanPropertyRowMapper(ApplyActivityPO.class));
        if (list != null && list.size() > 0) {
            return list;
        } else {
            return null;
        }
    }
}
