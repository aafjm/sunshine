package com.example.demo.dao.impl;

import com.example.demo.bean.po.ActivityPO;
import com.example.demo.bean.po.VolunteerPO;
import com.example.demo.dao.IVolunteerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class VolunteerDao implements IVolunteerDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int add(VolunteerPO po) {
        return jdbcTemplate.update("insert into volunteer(name, mobile, email, pwd, idcode, sex, " +
                        "status, addtime, modtime) values(?, ?, ?, ?, ?, ?, ?, unix_timestamp(), unix_timestamp())",
                po.getName(), po.getMobile(), po.getEmail(),
                po.getPwd(), po.getIdcode(), po.getSex(), po.getStatus());
    }

    public int update(VolunteerPO po) {
        return jdbcTemplate.update("update volunteer set name=?, mobile=?, email=?, pwd=?, idcode=?, sex=?, " +
                        "status=?, addtime=?, modtime=? where id = ?",
                po.getName(), po.getMobile(), po.getEmail(),
                po.getPwd(), po.getIdcode(), po.getSex(), po.getStatus(),
                po.getAddtime(), po.getModtime());
    }

    public VolunteerPO findVolunteerById(int id) {
        List<VolunteerPO> list = jdbcTemplate.query("select * from volunteer where id = ?", new Object[]{id}, new BeanPropertyRowMapper(VolunteerPO.class));
        if (list != null && list.size() > 0) {
            VolunteerPO po = list.get(0);
            return po;
        } else {
            return null;
        }
    }
}
