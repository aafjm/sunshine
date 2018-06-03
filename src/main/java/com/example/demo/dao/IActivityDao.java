package com.example.demo.dao;

import com.example.demo.bean.po.ActivityPO;

import java.util.List;


public interface IActivityDao {

    int add(ActivityPO activity);

    int update(ActivityPO activity);

    ActivityPO findActivityById(int id);

    List<ActivityPO> getAllActivity();

    List<ActivityPO> getAllActivityByStatus(int status);

}
