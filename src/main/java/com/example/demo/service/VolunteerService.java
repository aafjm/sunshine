package com.example.demo.service;

import com.example.demo.bean.jo.IdNameJo;
import com.example.demo.bean.model.PwdModel;
import com.example.demo.bean.model.VolunteerModel;
import com.example.demo.bean.model.VolunteerSignInModel;
import com.example.demo.bean.po.VolunteerPO;
import com.example.demo.constant.AdminConstant;
import com.example.demo.dao.IVolunteerDao;
import com.example.demo.helper.Encrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by fengjiamin on 2018/3/20.
 */
@Service
public class VolunteerService {

    @Autowired
    IVolunteerDao iVolunteerDao;


    /**
     * 验证密码
     * @param signInModel
     * @return
     */
    public boolean validateVolPwd(VolunteerSignInModel signInModel) {
        VolunteerPO volunteerPO = iVolunteerDao.findVolunteerById(signInModel.getId());
        String encryptPwd = Encrypt.getMd5Result(signInModel.getPwd(), AdminConstant.VOL_SALT);
        return volunteerPO.getPwd().equals(encryptPwd);
    }

    /**
     * 重置密码
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
     * @return
     */
    public List<IdNameJo> getAllVolIds(){
        List<VolunteerPO> poList = iVolunteerDao.getAllVols();
        List<IdNameJo> data = new LinkedList<>();
        for (VolunteerPO po : poList){
            IdNameJo jo = new IdNameJo();
            jo.setId(po.getId());
            jo.setName(po.getName());

            data.add(jo);
        }
        return data;
    }



}
