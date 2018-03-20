package com.example.demo.controller;


import com.example.demo.bean.jo.PageListJo;
import com.example.demo.bean.jo.ReturnJo;
import com.example.demo.bean.jo.TeamJo;
import com.example.demo.bean.model.PageModel;
import com.example.demo.bean.model.TeamModel;
import com.example.demo.bean.po.ActivityPO;
import com.example.demo.bean.po.TeamPO;
import com.example.demo.bean.to.PageTo;
import com.example.demo.dao.ITeamDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/team")
public class TeamController {

    @Autowired
    private ITeamDao iTeamDao;

    @RequestMapping("/ajax-get-team-page-list")
    @ResponseBody
    public Object getTeamPageList(PageModel pageModel) {
        PageListJo<TeamJo> data;
        List<TeamPO> teamPOS = iTeamDao.getAllTeamPO(0);

        List<TeamJo> teamJos = new ArrayList<>();
        for (TeamPO po : teamPOS) {
            teamJos.add(new TeamJo(po));
        }
        data = new PageListJo<>(pageModel.getPage(), pageModel.getNum(), teamJos);
        data.sortPage();
        return new ReturnJo(true, "查询成功", 200, data);
    }


    @RequestMapping("/ajax-add-team")
    @ResponseBody
    public Object addTeam(TeamModel teamModel) {
        iTeamDao.add(new TeamPO(teamModel));
        return new ReturnJo(true, "添加成功", 200, "");
    }


}
