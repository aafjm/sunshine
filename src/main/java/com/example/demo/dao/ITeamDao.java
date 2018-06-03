package com.example.demo.dao;

import com.example.demo.bean.po.TeamPO;

import java.util.List;

/**
 * Created by fengjiamin on 2018/3/18.
 */
public interface ITeamDao {

    List<TeamPO> getAllTeamPOByStatus(int status);

    List<TeamPO> getAllTeamPO();

    TeamPO getTeamById(int id);

    int add(TeamPO po);

    int update(TeamPO po);





}
