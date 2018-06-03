package com.example.demo.dao;

import com.example.demo.bean.po.AdminPO;

/**
 * Created by fengjiamin on 2018/5/19.
 */
public interface IAdminDao {
    AdminPO getAdminByMobile(String mobile);
}
