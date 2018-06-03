package com.example.demo.dao;

import com.example.demo.bean.po.TeamMemberPO;

import java.util.List;

/**
 * Created by fengjiamin on 2018/3/18.
 */
public interface ITeamMemberDao {

    List<TeamMemberPO> getTeamMembersByStatus(int status);

    List<TeamMemberPO> getTeamMembersByMemberId(int id);

    List<TeamMemberPO> getTeamMembersByTeamId(int id, int status);

    int addMember(TeamMemberPO po);

    void updateMember(int id, int status);
}
