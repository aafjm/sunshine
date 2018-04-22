package com.example.demo.dao;

import com.example.demo.bean.po.TeamMemberPO;

import java.util.List;

/**
 * Created by fengjiamin on 2018/3/18.
 */
public interface ITeamMemberDao {

    List<TeamMemberPO> getTeamMembersByStatus(int id, int status);
}
