package com.wxc.crm.controller;

import com.wxc.crm.model.SysMenu;
import com.wxc.crm.model.com.wxc.crm.easyui.DataGrid;
import com.wxc.crm.model.com.wxc.crm.easyui.PageHelper;
import com.wxc.crm.service.MenuService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping(value = "/menu")
public class MenuController extends BaseController {
    @Resource
    private MenuService menuService;

    /**
     * 跳转到菜单表格页面
     * @param model
     * @return
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String list(Model model){
        return "menu/list";
    }

    /**
     * 跳转到资源管理页面
     * @param model
     * @return
     */
    @RequestMapping(value = "listtree",method = RequestMethod.GET)
    public String listTree(Model model){
        return "menu/list_tree";
    }
    @ResponseBody
    @RequestMapping(value = "/datagrid",method = RequestMethod.POST)
    public DataGrid dataGrid(PageHelper pageHelper, SysMenu menu){
        DataGrid dg=new DataGrid();
        dg.setTotal(menuService.getDatagridTotal(menu));
        List<SysMenu> menuList=menuService.datagridMenu(pageHelper);
        dg.setRows(menuList);
        return dg;
    }

}
