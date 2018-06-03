package com.example.demo.controller;

import com.example.demo.bean.jo.*;
import com.example.demo.bean.model.ActivityModel;
import com.example.demo.bean.model.ActivityVolunteerModel;
import com.example.demo.bean.model.PageModel;
import com.example.demo.bean.po.ActivityPO;
import com.example.demo.bean.po.ApplyActivityPO;
import com.example.demo.dao.IActivityDao;
import com.example.demo.dao.IApplyActivityDao;
import com.example.demo.dao.ITeamDao;
import com.example.demo.dao.IVolunteerDao;
import com.example.demo.enums.EApplyStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping(value = "/activity")
public class ActivityController {


    @Autowired
    IActivityDao iActivityDao;

    @Autowired
    IApplyActivityDao iApplyActivityDao;

    @Autowired
    IVolunteerDao iVolunteerDao;

    @Autowired
    ITeamDao iTeamDao;

    /**
     * @return
     */
    @RequestMapping("/ajax-get-activity")
    @ResponseBody
    public Object getActivityById(int id) {
        ActivityPO stu = iActivityDao.findActivityById(id);
        return new ReturnJo(true, "添加成功", 200, stu);
    }

    @RequestMapping("/ajax-add-activity")
    @ResponseBody
    public Object addActivity(ActivityModel activityModel) {
        iActivityDao.add(new ActivityPO(activityModel));
        return new ReturnJo(true, "添加成功", 200, "");
    }


    @RequestMapping("/ajax-get-activity-list")
    @ResponseBody
    public Object getAllActivityId() {
        List<ActivityIdJo> data = new ArrayList<>();
        List<ActivityPO> list = iActivityDao.getAllActivity();
        for (ActivityPO po : list) {
            data.add(new ActivityIdJo(po));
        }
        return new ReturnJo(true, "添加成功", 200, data);
    }

    @RequestMapping("/ajax-get-activity-list-by-type")
    @ResponseBody
    public Object getActivityList(PageModel pageModel, int status) {
        PageListJo<ActivityJo> data;
        List<ActivityPO> listPO = iActivityDao.getAllActivityByStatus(status);

        List<ActivityJo> listJo = new ArrayList<>();
        if (listPO != null && listPO.size() > 0)
            for (ActivityPO po : listPO) {
                ActivityJo jo = new ActivityJo(po);
                jo.setTeamName(iTeamDao.getTeamById(jo.getTeamId()).getName());
                listJo.add(jo);
            }
        data = new PageListJo<>(pageModel.getPage(), pageModel.getNum(), listJo);
        data.sortPage();

        return new ReturnJo(true, "查询成功", 200, data);
    }


    @RequestMapping("/ajax-edit-activity")
    @ResponseBody
    public Object editActivity(ActivityModel activityModel) {

        ActivityPO origin = iActivityDao.findActivityById(activityModel.getId());
        ActivityPO.getActivityPO(origin, activityModel);
        iActivityDao.update(origin);

        return new ReturnJo(true, "编辑成功", 200, "");
    }

    @RequestMapping("/ajax-get-activity-volunteers")
    @ResponseBody
    public Object getActivityVolunteers(int id, PageModel model) {
        PageListJo<VolunteerJo> data;

        List<ApplyActivityPO> applyActivityPOS = iApplyActivityDao.findAllVolsByActId(id, EApplyStatus.PASS.getValue());

        List<VolunteerJo> listJo = new ArrayList<>();
        if (applyActivityPOS != null && applyActivityPOS.size() != 0)
            for (ApplyActivityPO po : applyActivityPOS) {
                listJo.add(new VolunteerJo(iVolunteerDao.findVolunteerById(po.getVolunteerId())));
            }
        data = new PageListJo<>(model.getPage(), model.getNum(), listJo);
            data.sortPage();

        data.setNum(data.getList() != null ? data.getList().size() : 0);
        return new ReturnJo(true, "查询成功", 200, data);
    }

}
