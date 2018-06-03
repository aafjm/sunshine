package com.example.demo.controller;

import com.example.demo.bean.jo.ActivityApplyJo;
import com.example.demo.bean.jo.PageListJo;
import com.example.demo.bean.jo.ReturnJo;
import com.example.demo.bean.jo.TeamApplyJo;
import com.example.demo.bean.model.ApplyActivityModel;
import com.example.demo.bean.model.ApplyTeamModel;
import com.example.demo.bean.model.PageModel;
import com.example.demo.service.ApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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
        return new ReturnJo(true, "添加成功", 200, "");
    }

    @RequestMapping("/ajax-apply-join-team")
    @ResponseBody
    public Object applyJoinTeam(ApplyTeamModel model) {

        applyService.addApplyTeam(model);
        return new ReturnJo(true, "添加成功", 200, "");
    }


    @RequestMapping("/ajax-get-team-apply")
    @ResponseBody
    public Object getTeamApply(int status, PageModel pageModel) {
        List<TeamApplyJo> applyJos = applyService.getApplyTeam(status);
        PageListJo<TeamApplyJo> data = new PageListJo<>(pageModel.getPage(), pageModel.getNum(), applyJos);
        data.sortPage();
        return new ReturnJo(true, "查询成功", 200, data);

    }

    @RequestMapping("/ajax-get-activity-apply")
    @ResponseBody
    public Object getActivityApply(int status, PageModel pageModel) {
        List<ActivityApplyJo> applyJos = applyService.getApplyActivity(status);
        PageListJo<ActivityApplyJo> data = new PageListJo<>(pageModel.getPage(), pageModel.getNum(), applyJos);
        data.sortPage();
        return new ReturnJo(true, "查询成功", 200, data);
    }


    @RequestMapping("/ajax-operate-team-apply")
    @ResponseBody
    public Object getOperateTeamApply(int id, int status) {

        applyService.operateApplyTeam(id, status);
        return new ReturnJo(true, "查询成功", 200, "");
    }

    @RequestMapping("/ajax-operate-activity-apply")
    @ResponseBody
    public Object getOperateActivityApply(int id, int status) {

        applyService.operateApplyActivity(id, status);
        return new ReturnJo(true, "查询成功", 200, "");
    }

    @RequestMapping("/ajax-get-my-activity-apply")
    @ResponseBody
    public Object getOperateActivityApply(int id, PageModel pageModel) {
        List<ActivityApplyJo> applyJos = applyService.getMyActivityApplyJos(id);
        PageListJo<ActivityApplyJo> data = new PageListJo<>(pageModel.getPage(), pageModel.getNum(), applyJos);
        data.sortPage();

        return new ReturnJo(true, "添加成功", 200, data);
    }




}
