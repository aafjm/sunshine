package com.example.demo.dao;


import com.example.demo.bean.po.ActivityPO;
import com.example.demo.bean.po.ApplyActivityPO;

import java.util.List;

public interface IApplyActivityDao {
    int add(ApplyActivityPO applyActivityPO);

    int update(int id, int status);

    List<ApplyActivityPO> findAllVolsByActId(int id, int status);

}
