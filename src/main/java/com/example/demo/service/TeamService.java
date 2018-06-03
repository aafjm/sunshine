package com.example.demo.service;

import com.example.demo.bean.jo.TeamApplyJo;
import com.example.demo.bean.jo.TeamJo;
import com.example.demo.bean.jo.VolunteerJo;
import com.example.demo.bean.model.TeamModel;
import com.example.demo.bean.po.TeamMemberPO;
import com.example.demo.bean.po.TeamPO;
import com.example.demo.bean.po.VolunteerPO;
import com.example.demo.dao.ITeamDao;
import com.example.demo.dao.ITeamMemberDao;
import com.example.demo.dao.IVolunteerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fengjiamin on 2018/3/25.
 */
@Service
public class TeamService {

    @Autowired
    ITeamDao iTeamDao;

    @Autowired
    ITeamMemberDao iTeamMemberDao;

    @Autowired
    IVolunteerDao iVolunteerDao;

    public void updateTeam(TeamModel teamModel) {
        TeamPO po = new TeamPO(iTeamDao.getTeamById(teamModel.getId()), teamModel);
        iTeamDao.update(po);
    }


    public TeamJo getTeamById(int id) {
        TeamPO po = iTeamDao.getTeamById(id);
        TeamJo jo = new TeamJo(po);

        VolunteerPO volunteerPO = iVolunteerDao.findVolunteerById(po.getLeaderId());
        jo.setLeaderName(volunteerPO.getName());

        return jo;
    }

    /**
     * 获取团队的员工
     *
     * @param id
     * @param status
     * @return
     */
    public List<VolunteerJo> getTeamMembsByStatus(int id, int status) {
        List<TeamMemberPO> memberPOS = iTeamMemberDao.getTeamMembersByTeamId(id, status);

        List<VolunteerJo> data = new ArrayList<>();
        if (memberPOS == null || memberPOS.size() == 0)
            return data;

        for (TeamMemberPO memberPO : memberPOS) {
            VolunteerPO volunteerPO = iVolunteerDao.findVolunteerById(memberPO.getMemberId());
            data.add(new VolunteerJo(volunteerPO));
        }
        return data;
    }


    /**
     * 获取员工的团队
     *
     * @param id
     * @return
     */
    public List<TeamApplyJo> getVolTeamByVolId(int id) {
        List<TeamMemberPO> memberPOS = iTeamMemberDao.getTeamMembersByMemberId(id);

        List<TeamApplyJo> data = new ArrayList<>();
        if (memberPOS == null || memberPOS.size() == 0)
            return data;
        for (TeamMemberPO po : memberPOS) {
            TeamApplyJo jo = new TeamApplyJo();
            TeamPO teamPO = iTeamDao.getTeamById(po.getTeamId());

            jo.setTeamId(teamPO.getId());
            jo.setTeamName(teamPO.getName());
            jo.setStatus(po.getStatus());
            jo.setId(po.getId());
            data.add(jo);
        }
        return data;
    }


}
