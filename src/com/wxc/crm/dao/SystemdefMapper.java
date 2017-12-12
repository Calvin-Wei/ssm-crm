package com.wxc.crm.dao;

import com.wxc.crm.model.Systemdef;
import com.wxc.crm.model.easyui.PageHelper;

import java.util.List;

public interface SystemdefMapper {
    public List<Systemdef> getAll(PageHelper page);

    public Systemdef getSystemdefById(Integer id);

    public void insertSystemdef(Systemdef systemdef);

    public void updateSystemdef(Systemdef systemdef);

    public void deleteSystemdefById(Integer id);
}
