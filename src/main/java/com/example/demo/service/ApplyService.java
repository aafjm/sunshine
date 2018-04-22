package com.example.demo.service;

import com.example.demo.bean.jo.ActivityApplyJo;
import com.example.demo.bean.jo.TeamApplyJo;
import com.example.demo.bean.model.ApplyActivityModel;
import com.example.demo.bean.po.ActivityPO;
import com.example.demo.bean.po.ApplyActivityPO;
import com.example.demo.bean.po.TeamMemberPO;
import com.example.demo.bean.po.VolunteerPO;
import com.example.demo.dao.IActivityDao;
import com.example.demo.dao.IApplyActivityDao;
import com.example.demo.dao.ITeamMemberDao;
import com.example.demo.dao.IVolunteerDao;
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
    private ITeamMemberDao iTeamMemberDao;


    /**
     * 申请加入活动
     * @param model
     */
    public void addApplyActivity(ApplyActivityModel model){
        ApplyActivityPO po = new ApplyActivityPO(model, 0);
        iApplyActivityDao.add(po);
    }


    /**
     * 获取活动申请列表
     * @param status
     * @return
     */
    public List<ActivityApplyJo> getApplyActivity(int status){
        List<ApplyActivityPO> pos = iApplyActivityDao.findAllVolsByStatus(status);

        List<ActivityApplyJo> jos = new LinkedList<>();
        for(ApplyActivityPO po : pos){
            VolunteerPO volunteerPO = iVolunteerDao.findVolunteerById(po.getVolunteerId());
            ActivityPO activityPO = iActivityDao.findActivityById(po.getActivityId());

            ActivityApplyJo jo = new ActivityApplyJo(po.getId(),
                    volunteerPO.getName(), volunteerPO.getMobile(),
                    activityPO.getId(), activityPO.getName(), po.getStatus());

            jos.add(jo);
        }
        return jos;
    }


//    /**
//     * 获取团队申请列表
//     * @param status
//     * @return
//     */
//    public List<TeamApplyJo> getApplyTeam(int status){
//        List<TeamMemberPO> pos = iApplyActivityDao.findAllVolsByStatus(status);
//
//        List<ActivityApplyJo> jos = new LinkedList<>();
//        for(ApplyActivityPO po : pos){
//            VolunteerPO volunteerPO = iVolunteerDao.findVolunteerById(po.getVolunteerId());
//            ActivityPO activityPO = iActivityDao.findActivityById(po.getActivityId());
//
//            ActivityApplyJo jo = new ActivityApplyJo(po.getId(),
//                    volunteerPO.getName(), volunteerPO.getMobile(),
//                    activityPO.getId(), activityPO.getName(), po.getStatus());
//
//            jos.add(jo);
//        }
//        return jos;
//    }
}
