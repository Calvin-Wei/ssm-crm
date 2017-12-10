package com.wxc.crm.controller;

import com.wxc.crm.model.Customer;
import com.wxc.crm.model.com.wxc.crm.easyui.DataGrid;
import com.wxc.crm.model.com.wxc.crm.easyui.Json;
import com.wxc.crm.model.com.wxc.crm.easyui.PageHelper;
import com.wxc.crm.service.CustomerService;
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
public class CustomerController {
    private final Logger logger= LoggerFactory.getLogger(CustomerController.class);
    @Resource
    private CustomerService customerService;

    /**
     * 跳转到客户表格页面
     * @param model
     * @return
     */
    @RequestMapping(value = "/customer/list",method = RequestMethod.GET)
    public String customerList(Model model){
        return "crm/customer_list";
    }

    /**
     * 表格
     * @param pageHelper
     * @param customer
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/customer/datagrid",method = RequestMethod.POST)
    public DataGrid dataGrid(PageHelper pageHelper, Customer customer){
        DataGrid dg=new DataGrid();
        dg.setTotal(customerService.getDatagridTotal(customer));
        List<Customer> list=customerService.datagridCustomer(pageHelper);
        dg.setRows(list);
        return dg;
    }
    @ResponseBody
    @RequestMapping(value = "/customer/add",method = RequestMethod.POST)
    public Json add(Customer customer){
        Json j=new Json();
        try {
            customerService.addCustomer(customer);
            j.setSuccess(true);
            j.setMsg("用户新增成功!");
            j.setObj(customer);
        }catch (Exception e){
            j.setMsg(e.getMessage());
        }
        return j;
    }

    /**
     * 修改
     * @param customer
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/customer/edit",method = RequestMethod.POST)
    public Json editUser(Customer customer){
        Json json=new Json();
        logger.debug("穿过来的用户ID为："+customer.getId());
        try {
            customerService.editCustomer(customer);
            json.setSuccess(true);
            json.setMsg("编辑成功！");
            json.setObj(customer);
        }catch (Exception e){
            json.setMsg(e.getMessage());
        }
        return json;
    }

    /**
     * 删除某个
     * @param customer
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/customer/delete",method = RequestMethod.POST)
    public Json delete(Customer customer){
        Json json=new Json();
        logger.debug("穿过来的用户ID为："+customer.getId());
        try{
            customerService.deleteCustomer(customer.getId());
            json.setSuccess(true);
            json.setMsg("删除成功!");
        }catch (Exception e){
            json.setMsg(e.getMessage());
        }
        return json;
    }

}
