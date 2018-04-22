package com.example.demo.dao.impl;

import com.example.demo.bean.po.TeamMemberPO;
import com.example.demo.bean.po.TeamPO;
import com.example.demo.dao.ITeamMemberDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by fengjiamin on 2018/3/29.
 */
@Repository
public class TeamMemberDao implements ITeamMemberDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<TeamMemberPO> getTeamMembersByStatus(int id, int status) {
        List<TeamMemberPO> list = jdbcTemplate.query("select * from teamMember where teamId = ? and status = ?", new Object[]{id, status}, new BeanPropertyRowMapper(TeamMemberPO.class));
        if (list != null && list.size() > 0) {
            return list;
        } else {
            return null;
        }
    }


}
