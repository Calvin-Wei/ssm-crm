package com.wxc.crm.controller;

import com.wxc.crm.model.Systemdef;
import com.wxc.crm.model.com.wxc.crm.easyui.Json;
import com.wxc.crm.model.com.wxc.crm.easyui.PageHelper;
import com.wxc.crm.model.com.wxc.crm.easyui.Tree;
import com.wxc.crm.service.SystemdefService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/systemdef")
public class SystemdefController extends BaseController {
    @Resource
    private SystemdefService systemdefService;

    /**
     * 跳转到资源管理页面
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/listtree", method = RequestMethod.GET)
    public String listTree(Model model) {
        return "systemdef/list_tree";
    }

    /**
     * 菜单列表-树
     *
     * @param response
     * @param pageHelper
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/treegrid", method = RequestMethod.POST)
    public List<Tree> treesgrid(HttpServletResponse response, PageHelper pageHelper) {
        List<Systemdef> systemdefList = systemdefService.getAll(pageHelper);
        List<Tree> treeList = new ArrayList<>();
        for (Systemdef systemdef : systemdefList) {
            Tree node = new Tree();
            node.setId(systemdef.getId());
            node.setPid(systemdef.getParentid());
            node.setText(systemdef.getName());
            node.setIconCls(systemdef.getIconCls());
            if (systemdef.getParentid() != 0) {//有父节点
                node.setPid(systemdef.getParentid());
            }
            if (systemdef.getCountChildrens() > 0) {
                node.setState("closed");
            }
            treeList.add(node);
        }
        return treeList;
    }

    /**
     * 保存(新增，修改)
     *
     * @param systemdef
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Json add(Systemdef systemdef) {
        Json j = new Json();
        try {
            systemdefService.saveSystemdef(systemdef);
            j.setSuccess(true);
            j.setMsg("保存成功!");
            j.setObj(systemdef);
        } catch (Exception e) {
            j.setMsg(e.getMessage());
        }
        return j;
    }

    /**
     * 删除
     *
     * @param systemdef
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    public Json deleteUser(Systemdef systemdef) {
        Json j = new Json();
        try {
            systemdefService.deleteSystemdefById(systemdef.getId());
            j.setSuccess(true);
            j.setMsg("保存成功!");
            j.setObj(systemdef);
        } catch (Exception e) {
            j.setMsg(e.getMessage());
        }
        return j;
    }

}
