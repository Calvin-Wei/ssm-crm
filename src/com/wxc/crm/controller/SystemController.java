/**
 * 
 */
package com.wxc.crm.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wxc.crm.model.SysMenu;
import com.wxc.crm.model.User;
import com.wxc.crm.model.easyui.Tree;
import com.wxc.crm.service.UserService;
import com.wxc.crm.util.RequestUtil;
import com.wxc.crm.util.UserCookieUtil;
import com.wxc.crm.util.common.Const;

/**
 * @author zh
 * 2014-7-26
 */
@Controller
public class SystemController extends BaseController {
	private final Logger log = LoggerFactory.getLogger(SystemController.class);
	@Resource
	private UserService userService;
	
	@RequestMapping(value = "/",method = RequestMethod.GET)
	public String home() {
		log.info("返回首页！");
		return "index";
	}
	
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(HttpServletRequest request,HttpServletResponse response,
    		@RequestParam String loginname, @RequestParam String password, 
    		@RequestParam String code,@RequestParam String autologinch) throws Exception{
    	
		if (code.toLowerCase().equals(request.getSession().getAttribute("RANDOMCODE").toString().toLowerCase())){
			User user = userService.findUserByName(loginname);
			if (user == null) {
				log.info("登陆用户名不存在");  
	    		request.getSession().setAttribute("message", "用户名不存在，请重新登录");
	    		return "login"; 
			}else {
				if (user.getPassword().equals(password)) {
					
					if(autologinch!=null && autologinch.equals("Y")){ // 判断是否要添加到cookie中
						// 保存用户信息到cookie
						UserCookieUtil.saveCookie(user, response);
					}
					
					// 保存用信息到session
					request.getSession().setAttribute(Const.SESSION_USER, user);  
	        		return "redirect:" + RequestUtil.retrieveSavedRequest();//跳转至访问页面
					
				}else {
					log.info("登陆密码错误");  
	        		request.getSession().setAttribute("message", "用户名密码错误，请重新登录");
	        		return "login"; 
				}
			}
		}else {
			request.getSession().setAttribute("message", "验证码错误，请重新输入");
    		return "login"; 
		}
    }
    
	/**
	 * 用户注销
	 * @return
	 */
	@RequestMapping(value="/logout")
	public String logout(HttpSession session,HttpServletResponse response){
		session.removeAttribute(Const.SESSION_USER);
		UserCookieUtil.clearCookie(response);
		return "redirect:/";
	}
	
    /**
     * 测试缓存
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value="/get/{id}", method = RequestMethod.GET)  
    public String get(@PathVariable int id, Model model){  
        String username = userService.getUsernameById(id);  
        model.addAttribute("username", username);  
        return "getUsername";  
    } 
    
    /**
     * 获取菜单栏(easyUI Tree)
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/getMenu", method = RequestMethod.POST)  
    public List<Tree> getMenu(HttpSession session){  
    	User user =  (User)session.getAttribute(Const.SESSION_USER); 
    	List<SysMenu> menuList = userService.getMenu(user.getId());
    	List<Tree> treeList = new ArrayList<Tree>();

        for (SysMenu menu : menuList) {
        	
			Tree node = new Tree();
			
			node.setId(menu.getId());
			node.setPid(menu.getParentid());
			node.setText(menu.getName());
			node.setIconCls(menu.getIconCls());
			
			if(menu.getParentid()!=0){	// 有父节点
				node.setPid(menu.getParentid());
			}
			if(menu.getCountChildrens() > 0){	//有子节点
				node.setState("closed");
			}
			Map<String, Object> attr = new HashMap<String, Object>();
			attr.put("url", menu.getUrl());
			node.setAttributes(attr);
			treeList.add(node);
        }
    	return treeList;
    }
    
}
