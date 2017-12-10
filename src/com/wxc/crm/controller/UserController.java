package com.wxc.crm.controller;

import com.wxc.crm.model.User;
import com.wxc.crm.model.com.wxc.crm.easyui.DataGrid;
import com.wxc.crm.model.com.wxc.crm.easyui.Json;
import com.wxc.crm.model.com.wxc.crm.easyui.PageHelper;
import com.wxc.crm.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Resource
    private UserService userService;

    /**
     * 跳转到用户表格页面
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/user/list", method = RequestMethod.GET)
    public String userList(Model model) {
        return "user/list";
    }

    /**
     * 跳转到用户表格页面
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/user/listtree", method = RequestMethod.GET)
    public String userListTree(Model model) {
        return "user/list_tree";
    }

    /**
     * 用户表格
     *
     * @param pageHelper
     * @param user
     * @param sysid
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/user/datagrid", method = RequestMethod.POST)
    public DataGrid datagrid(PageHelper pageHelper, User user, Integer sysid) {
        DataGrid dg = new DataGrid();
        dg.setTotal(userService.getDatagridTotal(user, sysid));
        List<User> userList = userService.datagridUser(pageHelper, sysid);
        dg.setRows(userList);
        return dg;
    }

    /**
     * 新增用户
     *
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/user/addUser", method = RequestMethod.POST)
    public Json addUser(User user) {
        Json j = new Json();
        try {
            userService.add(user);
            j.setSuccess(true);
            j.setMsg("用户新增成功！");
            j.setObj(user);
        } catch (Exception e) {
            j.setMsg(e.getMessage());
        }
        return j;
    }

    /**
     * 修改用户
     *
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/user/editUser", method = RequestMethod.POST)
    public Json editUser(User user) {
        Json j = new Json();
        logger.debug("穿过来的用户ID为：" + user.getId());
        try {
            userService.edit(user);
            j.setSuccess(true);
            j.setMsg("编辑成功！");
            j.setObj(user);
        } catch (Exception e) {
            j.setMsg(e.getMessage());
        }
        return j;
    }

    /**
     * 删除某个用户
     *
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/user/deleteUser", method = RequestMethod.POST)
    public Json deleteUser(User user) {
        Json j = new Json();
        logger.debug("传过来的用户ID为：" + user.getId());
        try {
            userService.deleteUser(user.getId());
            j.setSuccess(true);
            j.setMsg("删除成功");
        } catch (Exception e) {
            j.setMsg(e.getMessage());
        }
        return j;
    }

}
