package com.example.demo.controller;

import com.example.demo.bean.jo.ReturnJo;
import com.example.demo.bean.model.ApplyActivityModel;
import com.example.demo.bean.model.PageModel;
import com.example.demo.service.ApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by fengjiamin on 2018/3/20.
 */
@Controller
@RequestMapping(value = "/apply")
public class ApplyController {


    @Autowired
    private ApplyService applyService;

    @RequestMapping("/ajax-apply-join-activity")
    @ResponseBody
    public Object applyJoinActivity(ApplyActivityModel model) {

        applyService.addApplyActivity(model);
        return new ReturnJo(true, "查询成功", 200, "");
    }


    @RequestMapping("ajax-get-team-apply")
    @ResponseBody
    public Object getTeamApply(int status, PageModel pageModel) {



        return new ReturnJo(true, "查询成功", 200, "");
    }


}
