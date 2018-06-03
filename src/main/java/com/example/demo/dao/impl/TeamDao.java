package com.example.demo.dao.impl;

import com.example.demo.bean.po.TeamPO;
import com.example.demo.dao.ITeamDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by fengjiamin on 2018/3/18.
 */
@Repository
public class TeamDao implements ITeamDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public TeamPO getTeamById(int id) {
        List<TeamPO> list = jdbcTemplate.query("select * from team where id = ?", new Object[]{id}, new BeanPropertyRowMapper(TeamPO.class));
        if (list != null && list.size() > 0) {
            TeamPO teamPO = list.get(0);
            return teamPO;
        } else {
            return null;
        }
    }

    @Override
    public List<TeamPO> getAllTeamPOByStatus(int status) {
        List<TeamPO> list = jdbcTemplate.query("select * from team where status = ?", new Object[]{status}, new BeanPropertyRowMapper(TeamPO.class));
        if (list != null && list.size() > 0) {
            return list;
        } else {
            return null;
        }
    }

    @Override
    public List<TeamPO> getAllTeamPO() {
        List<TeamPO> list = jdbcTemplate.query("select * from team", new BeanPropertyRowMapper(TeamPO.class));
        if (list != null && list.size() > 0) {
            return list;
        } else {
            return null;
        }
    }

    @Override
    public int add(TeamPO po) {
        return jdbcTemplate.update("insert into team(name, pic, leaderId, note, addtime, modtime) " +
                        "values(?, ?, ?, ?,unix_timestamp(), unix_timestamp())",
                po.getName(), po.getPic(), po.getLeaderId(), po.getNote());
    }

    @Override
    public int update(TeamPO po) {
        return jdbcTemplate.update("update team SET name=?, pic=?, leaderId=?, note=?, status = ?, modtime=unix_timestamp()" +
                        " where id = ?",
                po.getName(), po.getPic(), po.getLeaderId(), po.getNote(),po.getStatus(), po.getId());
    }

}
