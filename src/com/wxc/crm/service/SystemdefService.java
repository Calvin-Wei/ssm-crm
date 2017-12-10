package com.wxc.crm.service;

import com.wxc.crm.dao.SystemdefMapper;
import com.wxc.crm.model.Systemdef;
import com.wxc.crm.model.com.wxc.crm.easyui.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SystemdefService {
    @Resource
    private SystemdefMapper systemdefMapper;

    /**
     * 获取所有列表
     * @param pageHelper
     * @return
     */
    public List<Systemdef> getAll(PageHelper pageHelper){
        pageHelper.setStart((pageHelper.getPage()-1)*pageHelper.getRows());
        pageHelper.setEnd(pageHelper.getPage()*pageHelper.getRows());
        return systemdefMapper.getAll(pageHelper);
    }

    public void deleteSystemdefById(Integer systemdefId){
        systemdefMapper.deleteSystemdefById(systemdefId);
    }

    public Systemdef getSystemdefById(Integer systemdefId){
        return systemdefMapper.getSystemdefById(systemdefId);
    }

    /**
     * 保存、更新
     * @param systemdef
     */
    public void saveSystemdef(Systemdef systemdef){
        if (systemdef.getId()!=null&&systemdef.getId().intValue()>0){
            systemdefMapper.updateSystemdef(systemdef);
        }else {
            systemdefMapper.insertSystemdef(systemdef);
        }
    }

}
