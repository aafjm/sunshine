package com.example.demo.controller;

import com.example.demo.bean.jo.*;
import com.example.demo.bean.model.PageModel;
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

import java.util.ArrayList;
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

    @RequestMapping("/ajax-log-out-volunteer")
    @ResponseBody
    public Object logoutVol(int id) {
        iVolunteerDao.updateStatus(id, 1);
        return new ReturnJo(true, "注销成功", 200, "");
    }

    @RequestMapping("/ajax-sign-volunteer")
    @ResponseBody
    public Object sign(VolunteerSignInModel signInModel) {
        if (volunteerService.validateVolPwd(signInModel)) {
            VolunteerLoginJo jo = volunteerService.getLoginVolunteerJo(signInModel.getMobile());
            return new ReturnJo(true, "验证成功", 200, jo);
        }
        return new ReturnJo(false, "验证失败", 200, "");
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
    public Object getAllVols(int status, PageModel pageModel) {

        PageListJo<VolunteerJo> data;
        List<VolunteerPO> pos = iVolunteerDao.getAllVols(status);

        List<VolunteerJo> jos = new ArrayList<>();
        for (VolunteerPO po : pos) {
            jos.add(new VolunteerJo(po));
        }
        data = new PageListJo<>(pageModel.getPage(), pageModel.getNum(), jos);
        data.sortPage();
        return new ReturnJo(true, "查询成功", 200, data);
    }

    @RequestMapping("/ajax-get-volunteer-activity")
    @ResponseBody
    public Object getAllActs(PageModel pageModel) {

        PageListJo<VolunteerJo> data;
        List<VolunteerPO> pos = iVolunteerDao.getAllVols(0);

        List<VolunteerJo> jos = new ArrayList<>();
        for (VolunteerPO po : pos) {
            jos.add(new VolunteerJo(po));
        }
        data = new PageListJo<>(pageModel.getPage(), pageModel.getNum(), jos);
        data.sortPage();
        return new ReturnJo(true, "查询成功", 200, data);
    }

}
