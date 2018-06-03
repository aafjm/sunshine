package com.example.demo.service;

import com.example.demo.bean.jo.ActivityJo;
import com.example.demo.bean.jo.IdNameJo;
import com.example.demo.bean.jo.VolunteerLoginJo;
import com.example.demo.bean.model.PwdModel;
import com.example.demo.bean.model.VolunteerModel;
import com.example.demo.bean.model.VolunteerSignInModel;
import com.example.demo.bean.po.*;
import com.example.demo.constant.AdminConstant;
import com.example.demo.dao.*;
import com.example.demo.enums.EApplyStatus;
import com.example.demo.helper.Encrypt;
import com.example.demo.helper.StrUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by fengjiamin on 2018/3/20.
 */
@Service
public class VolunteerService {

    @Autowired
    IVolunteerDao iVolunteerDao;

    @Autowired
    IApplyActivityDao iApplyActivityDao;

    @Autowired
    IActivityDao iActivityDao;

    @Autowired
    IAdminDao iAdminDao;

    @Autowired
    ITeamMemberDao iTeamMemberDao;

    /**
     * 验证密码
     *
     * @param signInModel
     * @return
     */
    public boolean validateVolPwd(VolunteerSignInModel signInModel) {
        VolunteerPO volunteerPO = new VolunteerPO();
        if (signInModel.getId() != 0)
            volunteerPO = iVolunteerDao.findVolunteerById(signInModel.getId());
        if (!StrUtil.isEmpty(signInModel.getMobile()))
            volunteerPO = iVolunteerDao.findVolunteerByMobile(signInModel.getMobile());
        String encryptPwd = Encrypt.getMd5Result(signInModel.getPwd(), AdminConstant.VOL_SALT);
        return volunteerPO.getPwd().equals(encryptPwd);
    }

    public boolean validateAdminPwd(VolunteerSignInModel signInModel) {
        AdminPO adminPO = iAdminDao.getAdminByMobile(signInModel.getMobile());
        String encryptPwd = Encrypt.getMd5Result(signInModel.getPwd(), AdminConstant.VOL_SALT);
        return adminPO.getPwd().equals(encryptPwd);
    }

    public VolunteerLoginJo getLoginVolunteerJo(String mobile) {
        VolunteerPO volunteerPO = iVolunteerDao.findVolunteerByMobile(mobile);

        VolunteerLoginJo jo = new VolunteerLoginJo(volunteerPO);

        List<ApplyActivityPO> applyActivityPOS = iApplyActivityDao.findAllActsByVolId(jo.getId());
        jo.setActivityNum(applyActivityPOS == null ? 0 : applyActivityPOS.size());

        List<TeamMemberPO> teamMemberPOS = iTeamMemberDao.getTeamMembersByMemberId(jo.getId());
        jo.setTeamNum(teamMemberPOS == null ? 0 : teamMemberPOS.size());

        return jo;
    }

    /**
     * 重置密码
     *
     * @param pwdModel
     */
    public void resetPwdByVolId(PwdModel pwdModel) {
        VolunteerPO volunteerPO = iVolunteerDao.findVolunteerById(pwdModel.getId());
        String encryptPwd = Encrypt.getMd5Result(pwdModel.getPwd(), AdminConstant.VOL_SALT);
        volunteerPO.setPwd(encryptPwd);

        iVolunteerDao.update(volunteerPO);
    }

    /**
     * 获取志愿者idname list
     *
     * @return
     */
    public List<IdNameJo> getAllVolIds() {
        List<VolunteerPO> poList = iVolunteerDao.getAllVols(0);
        List<IdNameJo> data = new LinkedList<>();
        for (VolunteerPO po : poList) {
            IdNameJo jo = new IdNameJo();
            jo.setId(po.getId());
            jo.setName(po.getName());

            data.add(jo);
        }
        return data;
    }

    public List<ActivityJo> getActivityJosByVolId(int id) {
        List<ApplyActivityPO> pos = iApplyActivityDao.findAllVolsByActId(id, EApplyStatus.PASS.getValue());

        List<ActivityJo> activityJos = new ArrayList<>();

        for (ApplyActivityPO po : pos) {
            ActivityPO activityPO = iActivityDao.findActivityById(po.getId());

            activityJos.add(new ActivityJo(activityPO));
        }

        return activityJos;
    }


}
