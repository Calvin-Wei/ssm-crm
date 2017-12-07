package com.wxc.crm.dao;

import com.wxc.crm.model.SysMenu;
import com.wxc.crm.model.com.wxc.crm.easyui.PageHelper;

import java.util.List;

public interface MenuMapper {
    //所有父级菜单
    public List<SysMenu> listAllParentMenu();

    public List<SysMenu> listSubMenuByParentid(Integer parentid);

    public List<SysMenu> getDatagrid();

    public List<SysMenu> getAll(PageHelper page);

    public Long getDatagridTotal(SysMenu menu);

    public List<SysMenu> datagridMenu(PageHelper page);

    public SysMenu getMenuById(Integer menuId);

    public void insertMenu(SysMenu menu);
    public void updateMenu(SysMenu menu);
    public void deleteMenuById(Integer menuId);

    public List<SysMenu> listAllSubMenu();
}
