package com.example.demo.controller;

import com.example.demo.bean.jo.ReturnJo;
import com.example.demo.bean.model.VolunteerModel;
import com.example.demo.bean.po.VolunteerPO;
import com.example.demo.dao.IVolunteerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping(value = "/volunteer")
public class VolunteerController {

    @Autowired
    IVolunteerDao iVolunteerDao;

    @RequestMapping("/ajax-add-volunteer")
    @ResponseBody
    public Object addTeam(VolunteerModel volunteerModel) {
        VolunteerPO volunteerPO = new VolunteerPO(volunteerModel);
        iVolunteerDao.add(volunteerPO);
        return new ReturnJo(true, "添加成功", 200, "");
    }
}
