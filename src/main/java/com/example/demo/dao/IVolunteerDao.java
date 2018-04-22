package com.example.demo.dao;

import com.example.demo.bean.po.VolunteerPO;

import java.util.List;

/**
 * Created by fengjiamin on 2018/3/18.
 */
public interface IVolunteerDao {
    int add(VolunteerPO po);

    int update(VolunteerPO po);

    VolunteerPO findVolunteerById(int id);

    List<VolunteerPO> getAllVols();
}
