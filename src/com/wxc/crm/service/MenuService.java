package com.wxc.crm.service;

import com.wxc.crm.dao.MenuMapper;
import com.wxc.crm.model.SysMenu;
import com.wxc.crm.model.com.wxc.crm.easyui.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MenuService {
    @Resource
    private MenuMapper menuMapper;

    /**
     * 获取综述
     * @param menu
     * @return
     */
    public Long getDatagridTotal(SysMenu menu){
        return menuMapper.getDatagridTotal(menu);
    }

    /**
     * 获取一级列表
     * @param pageHelper
     * @return
     */
    public List<SysMenu> datagridMenu(PageHelper pageHelper){
        pageHelper.setStart((pageHelper.getPage()-1)*pageHelper.getRows());
        pageHelper.setEnd(pageHelper.getPage()*pageHelper.getRows());
        return menuMapper.datagridMenu(pageHelper);
    }

    /**
     * 获取所有列表
     * @param pageHelper
     * @return
     */
    public List<SysMenu> getAll(PageHelper pageHelper){
        pageHelper.setStart((pageHelper.getPage()-1)*pageHelper.getRows());
        pageHelper.setEnd(pageHelper.getPage()*pageHelper.getRows());
        return menuMapper.getAll(pageHelper);
    }

    public void deleteMenuById(Integer menuId) {
        menuMapper.deleteMenuById(menuId);
    }

    public SysMenu getMenuById(Integer menuId) {
        return menuMapper.getMenuById(menuId);
    }

    public List<SysMenu> listAllParentMenu() {
        return menuMapper.listAllParentMenu();
    }

    public void saveMenu(SysMenu menu) {
        if(menu.getId()!=null && menu.getId().intValue()>0){
            menuMapper.updateMenu(menu);
        }else{
            menuMapper.insertMenu(menu);
        }
    }

    public List<SysMenu> listSubMenuByParentid(Integer parentid) {
        return menuMapper.listSubMenuByParentid(parentid);
    }

    public List<SysMenu> listAllMenu() {
        List<SysMenu> rl = this.listAllParentMenu();
        for(SysMenu menu : rl){
            List<SysMenu> subList = this.listSubMenuByParentid(menu.getId());
            menu.setSubMenu(subList);
        }
        return rl;
    }

    public List<SysMenu> listAllSubMenu(){
        return menuMapper.listAllSubMenu();
    }
}
