package com.wxc.crm.controller;

import com.wxc.crm.model.SysMenu;
import com.wxc.crm.model.User;
import com.wxc.crm.model.com.wxc.crm.easyui.Tree;
import com.wxc.crm.service.UserService;
import com.wxc.crm.util.RequestUtil;
import com.wxc.crm.util.UserCookieUtil;
import com.wxc.crm.util.common.Const;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class SystemController extends BaseController {
    private final Logger logger = LoggerFactory.getLogger(SystemController.class);
    @Resource
    private UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        logger.info("返回首页!");
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpServletResponse response, HttpServletRequest request,
                        @RequestParam String loginname, @RequestParam String password,
                        @RequestParam String code, @RequestParam String autologinch) throws Exception {
        if (code.toLowerCase().equals(request.getSession().getAttribute("RANDOMCODE").toString().toLowerCase())) {
            User user = userService.findUserByName(loginname);
            if (user == null) {
                logger.info("登陆用户名不存在");
                request.getSession().setAttribute("message", "用户名不存在，请重新登录");
                return "login";
            } else {
                if (user.getPassword().equals(password)) {

                    if (autologinch != null && autologinch.equals("Y")) { // 判断是否要添加到cookie中
                        // 保存用户信息到cookie
                        UserCookieUtil.saveCookie(user, response);
                    }

                    // 保存用信息到session
                    request.getSession().setAttribute(Const.SESSION_USER, user);
                    return "redirect:" + RequestUtil.retrieveSavedRequest();//跳转至访问页面

                } else {
                    logger.info("登陆密码错误");
                    request.getSession().setAttribute("message", "用户名密码错误，请重新登录");
                    return "login";
                }
            }
        } else {
            request.getSession().setAttribute("message", "验证码错误，请重新输入");
            return "login";
        }
    }

    /**
     * 用户注销
     *
     * @param session
     * @param response
     * @return
     */
    @RequestMapping(value = "/logout")
    public String logout(HttpSession session, HttpServletResponse response) {
        session.removeAttribute(Const.SESSION_USER);
        UserCookieUtil.clearCookie(response);
        return "redirect:/";
    }

    /**
     * 测试缓存
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public String get(@PathVariable int id, Model model) {
        String username = userService.getUsernameById(id);
        model.addAttribute("username", username);
        return "getUsername";
    }

    /**
     * 获取菜单栏
     *
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getMenu", method = RequestMethod.POST)
    public List<Tree> getMenu(HttpSession session) {
        User user = (User) session.getAttribute(Const.SESSION_USER);
        List<SysMenu> menuList = userService.getMenu(user.getId());
        List<Tree> treeList = new ArrayList<>();
        for (SysMenu menu : menuList) {
            Tree node = new Tree();
            node.setId(menu.getId());
            node.setPid(menu.getParentid());
            node.setText(menu.getName());
            node.setIconCls(menu.getIconCls());
            if (menu.getParentid() != 0) {
                node.setPid(menu.getParentid());
            }
            if (menu.getCountChildrens() > 0) {
                node.setState("closed");
            }
            Map<String, Object> attr = new HashMap<>();
            attr.put("url", menu.getUrl());
            node.setAttributes(attr);
            treeList.add(node);
        }
        return treeList;
    }

}
