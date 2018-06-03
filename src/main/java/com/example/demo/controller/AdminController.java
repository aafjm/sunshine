package com.example.demo.controller;


import com.example.demo.bean.jo.ReturnJo;
import com.example.demo.bean.model.VolunteerSignInModel;
import com.example.demo.bean.po.AdminPO;
import com.example.demo.dao.IAdminDao;
import com.example.demo.service.VolunteerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {


    @Autowired
    VolunteerService volunteerService;

    @Autowired
    IAdminDao iAdminDao;


    @RequestMapping("/ajax-login-admin")
    @ResponseBody
    public Object login(VolunteerSignInModel signInModel) {

        if (volunteerService.validateAdminPwd(signInModel)){
            AdminPO adminPO = iAdminDao.getAdminByMobile(signInModel.getMobile());
            return new ReturnJo(true, "验证成功", 200, adminPO);
        }

        return new ReturnJo(false, "验证失败", 200, "");
    }
}
