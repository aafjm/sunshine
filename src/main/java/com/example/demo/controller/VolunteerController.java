package com.example.demo.controller;

import com.example.demo.bean.jo.IdNameJo;
import com.example.demo.bean.jo.ReturnJo;
import com.example.demo.bean.model.PwdModel;
import com.example.demo.bean.model.VolunteerModel;
import com.example.demo.bean.model.VolunteerSignInModel;
import com.example.demo.bean.po.VolunteerPO;
import com.example.demo.dao.IVolunteerDao;
import com.example.demo.service.VolunteerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@RequestMapping(value = "/volunteer")
public class VolunteerController {

    @Autowired
    IVolunteerDao iVolunteerDao;

    @Autowired
    VolunteerService volunteerService;

    @RequestMapping("/ajax-add-volunteer")
    @ResponseBody
    public Object addVol(VolunteerModel volunteerModel) {
        VolunteerPO volunteerPO = new VolunteerPO(volunteerModel);
        iVolunteerDao.add(volunteerPO);
        return new ReturnJo(true, "添加成功", 200, "");
    }

    @RequestMapping("/ajax-sign-volunteer")
    @ResponseBody
    public Object sign(VolunteerSignInModel signInModel) {
        if (volunteerService.validateVolPwd(signInModel))
            return new ReturnJo(true, "验证成功", 200, "");
        return new ReturnJo(false, "验证失败", 200, "用户不存在或密码错误");
    }

    @RequestMapping("/ajax-reset-pwd")
    @ResponseBody
    public Object resetPwd(PwdModel pwdModel) {
        volunteerService.resetPwdByVolId(pwdModel);
        return new ReturnJo(false, "修改成功", 200, "");
    }


    @RequestMapping("/ajax-get-all-volunteer-ids")
    @ResponseBody
    public Object getAllVolIds() {
        List<IdNameJo> data = volunteerService.getAllVolIds();
        return new ReturnJo(false, "修改成功", 200, data);
    }

    @RequestMapping("/ajax-get-all-volunteers")
    @ResponseBody
    public Object getAllVols() {

        return new ReturnJo(false, "修改成功", 200,"");
    }



}
