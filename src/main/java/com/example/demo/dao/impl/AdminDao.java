package com.example.demo.dao.impl;

import com.example.demo.bean.po.AdminPO;
import com.example.demo.dao.IAdminDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by fengjiamin on 2018/5/19.
 */
@Repository
public class AdminDao implements IAdminDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public AdminPO getAdminByMobile(String mobile) {
        List<AdminPO> list = jdbcTemplate.query("select * from admin where mobile = ?", new Object[]{mobile}, new BeanPropertyRowMapper(AdminPO.class));
        if (list != null && list.size() > 0) {
            AdminPO adminPO = list.get(0);
            return adminPO;
        } else {
            return null;
        }
    }
}
