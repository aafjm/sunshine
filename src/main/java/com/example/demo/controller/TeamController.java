package com.example.demo.controller;


import com.example.demo.bean.jo.*;
import com.example.demo.bean.model.PageModel;
import com.example.demo.bean.model.TeamModel;
import com.example.demo.bean.po.ActivityPO;
import com.example.demo.bean.po.TeamPO;
import com.example.demo.bean.po.VolunteerPO;
import com.example.demo.bean.to.PageTo;
import com.example.demo.dao.ITeamDao;
import com.example.demo.dao.IVolunteerDao;
import com.example.demo.enums.ETeamMemberStatus;
import com.example.demo.service.TeamService;
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

    @Autowired
    private IVolunteerDao iVolunteerDao;

    @Autowired
    private TeamService teamService;

    @RequestMapping("/ajax-get-team-page-list")
    @ResponseBody
    public Object getTeamPageList(int status, PageModel pageModel) {
        PageListJo<TeamJo> data;
        List<TeamPO> teamPOS = iTeamDao.getAllTeamPOByStatus(status);

        List<TeamJo> teamJos = new ArrayList<>();
        for (TeamPO po : teamPOS) {
            TeamJo jo = new TeamJo(po);
            VolunteerPO volunteerPO = iVolunteerDao.findVolunteerById(po.getLeaderId());
            jo.setLeaderName(volunteerPO.getName());
            teamJos.add(jo);
        }
        data = new PageListJo<>(pageModel.getPage(), pageModel.getNum(), teamJos);
        data.sortPage();
        return new ReturnJo(true, "查询成功", 200, data);
    }


    @RequestMapping("/ajax-get-team-id-name-list")
    @ResponseBody
    public Object getAllActivityId() {
        List<IdNameJo> data = new ArrayList<>();
        List<TeamPO> list = iTeamDao.getAllTeamPO();
        for (TeamPO po : list) {
            IdNameJo jo = new IdNameJo();
            jo.setId(po.getId());
            jo.setName(po.getName());
            data.add(jo);
        }
        return new ReturnJo(true, "添加成功", 200, data);
    }

    @RequestMapping("/ajax-add-team")
    @ResponseBody
    public Object addTeam(TeamModel teamModel) {
        iTeamDao.add(new TeamPO(teamModel));
        return new ReturnJo(true, "添加成功", 200, "");
    }

    @RequestMapping("/ajax-update-team")
    @ResponseBody
    public Object updateTeam(TeamModel teamModel) {
        teamService.updateTeam(teamModel);
        return new ReturnJo(true, "添加成功", 200, "");
    }

    @RequestMapping("/ajax-get-team")
    @ResponseBody
    public Object getTeam(int id) {
        TeamJo jo = teamService.getTeamById(id);
        return new ReturnJo(true, "获取成功", 200, jo);
    }

    @RequestMapping("/ajax-get-team-volunteers")
    @ResponseBody
    public Object getTeamVolunteers(int id, PageModel pageModel) {
        List<VolunteerJo> volunteerJos = teamService.getTeamMembsByStatus(id, ETeamMemberStatus.NORMOL.getValue());
        PageListJo<VolunteerJo> data = new PageListJo<>(pageModel.getPage(), pageModel.getNum(), volunteerJos);
        data.sortPage();

        return new ReturnJo(true, "添加成功", 200, data);
    }

    @RequestMapping("/ajax-get-my-team")
    @ResponseBody
    public Object getMyTeam(int id, PageModel pageModel) {
        List<TeamApplyJo> teamApplyJos = teamService.getVolTeamByVolId(id);
        PageListJo<TeamApplyJo> data = new PageListJo<>(pageModel.getPage(), pageModel.getNum(), teamApplyJos);
        data.sortPage();

        return new ReturnJo(true, "添加成功", 200, data);
    }



}
