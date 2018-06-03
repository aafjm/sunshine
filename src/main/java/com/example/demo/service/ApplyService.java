package com.example.demo.service;

import com.example.demo.bean.jo.ActivityApplyJo;
import com.example.demo.bean.jo.TeamApplyJo;
import com.example.demo.bean.jo.TeamJo;
import com.example.demo.bean.model.ApplyActivityModel;
import com.example.demo.bean.model.ApplyTeamModel;
import com.example.demo.bean.po.*;
import com.example.demo.dao.*;
import com.example.demo.enums.EApplyStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by fengjiamin on 2018/3/30.
 */
@Service
public class ApplyService {


    @Autowired
    private IApplyActivityDao iApplyActivityDao;

    @Autowired
    private IVolunteerDao iVolunteerDao;

    @Autowired
    private IActivityDao iActivityDao;

    @Autowired
    private ITeamDao iTeamDao;

    @Autowired
    private ITeamMemberDao iTeamMemberDao;


    /**
     * 申请加入活动
     *
     * @param model
     */
    public void addApplyActivity(ApplyActivityModel model) {
        ApplyActivityPO po = new ApplyActivityPO(model, EApplyStatus.WAIT.getValue());
        iApplyActivityDao.add(po);
    }

    /**
     * 申请加入活动
     *
     * @param model
     */
    public void addApplyTeam(ApplyTeamModel model) {
        TeamMemberPO po = new TeamMemberPO(model);
        iTeamMemberDao.addMember(po);
    }

    public void operateApplyTeam(int id, int status) {
        iTeamMemberDao.updateMember(id, status);
    }

    public void operateApplyActivity(int id, int status) {
        iApplyActivityDao.update(id, status);
    }

    /**
     * 获取活动申请列表
     *
     * @param status
     * @return
     */
    public List<ActivityApplyJo> getApplyActivity(int status) {
        List<ApplyActivityPO> pos = iApplyActivityDao.findAllVolsByStatus(status);

        List<ActivityApplyJo> jos = new LinkedList<>();

        if (pos != null && pos.size() > 0)
            for (ApplyActivityPO po : pos) {
                VolunteerPO volunteerPO = iVolunteerDao.findVolunteerById(po.getVolunteerId());
                ActivityPO activityPO = iActivityDao.findActivityById(po.getActivityId());

                ActivityApplyJo jo = new ActivityApplyJo(po.getId(),
                        volunteerPO.getName(), volunteerPO.getMobile(),
                        activityPO.getId(), activityPO.getName(), po.getStatus());

                jos.add(jo);
            }
        return jos;
    }


    /**
     * 获取团队申请列表
     *
     * @param status
     * @return
     */
    public List<TeamApplyJo> getApplyTeam(int status) {
        List<TeamMemberPO> teamMemberPOS = iTeamMemberDao.getTeamMembersByStatus(status);

        List<TeamApplyJo> jos = new LinkedList<>();
        if (teamMemberPOS != null && teamMemberPOS.size() > 0)
            for (TeamMemberPO po : teamMemberPOS) {
                VolunteerPO volunteerPO = iVolunteerDao.findVolunteerById(po.getMemberId());
                TeamPO teamPO = iTeamDao.getTeamById(po.getTeamId());

                TeamApplyJo jo = new TeamApplyJo(po.getId(), volunteerPO.getName(),
                        volunteerPO.getMobile(), teamPO.getId(), teamPO.getName(), po.getStatus());

                jos.add(jo);
            }
        return jos;
    }


    public List<ActivityApplyJo> getMyActivityApplyJos(int id) {
        List<ActivityApplyJo> jos = new LinkedList<>();
        List<ApplyActivityPO> activityPOS = iApplyActivityDao.findAllActsByVolId(id);
        if (activityPOS == null || activityPOS.size() == 0)
            return jos;
        for (ApplyActivityPO applyActivityPO : activityPOS) {
            ActivityApplyJo jo = new ActivityApplyJo();
            ActivityPO activityPO = iActivityDao.findActivityById(applyActivityPO.getActivityId());
            jo.setActivityId(activityPO.getId());
            jo.setActivityName(activityPO.getName());
            jo.setStatus(applyActivityPO.getStatus());
            jo.setId(applyActivityPO.getId());
            jos.add(jo);
        }
        return jos;
    }
}
