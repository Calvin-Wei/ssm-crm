package com.wxc.crm.service;

import com.wxc.crm.dao.CustomerMapper;
import com.wxc.crm.model.Contact;
import com.wxc.crm.model.Customer;
import com.wxc.crm.model.Visitlog;
import com.wxc.crm.model.com.wxc.crm.easyui.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Cacheable注解 负责将方法的返回值加入到缓存中
 * CacheEvict注解
 * value------缓存位置的名称,不能为空若使用EhCache则其值ehcache.xml中的<cache name='myCache' />
 * key--------缓存的Key,默认为空(表示使用方法的参数类型及参数值作为key),支持SpEL
 * condition--只有满足条件的情况才会加入缓存,默认为空(表示全部都加入缓存),支持SpEL
 * 该注解的源码位于spring-context-*.RELEASE-sources.jar中
 * Spring针对Ehcache支持的Java源码位于spring-context-support-*.RELEASE-sources.jar中
 */
@Service
public class CustomerService {
    @Resource
    private CustomerMapper customerMapper;

    public Customer findByName(String name){
        return customerMapper.findByName(name);
    }

    public Customer getUsernameById(int id){
        return customerMapper.getCustomerById(id);
    }

    /**
     * 获取该客户的所有联系人
     * @param customerId
     * @return
     */
    public List<Contact> getContactById(int customerId){
        return customerMapper.getContactById(customerId);
    }

    /**
     * 获取该客户的所有拜访记录
     * @param customerId
     * @return
     */
    public List<Visitlog> getVisitlogById(int customerId){
        return customerMapper.getVisitlogById(customerId);
    }

    /**
     * 获取总数
     * @param customer
     * @return
     */
    public Long getDatagridTotal(Customer customer){
        return customerMapper.getDatagridTotal(customer);
    }

    /**
     * 获取列表分页
     * @param pageHelper
     * @return
     */
    public List<Customer> datagridCustomer(PageHelper pageHelper){
        pageHelper.setStart((pageHelper.getPage()-1)*pageHelper.getRows());
        pageHelper.setEnd(pageHelper.getPage()*pageHelper.getRows());
        return customerMapper.datagridCustomer(pageHelper);
    }
    //添加
    public void addCustomer(Customer customer){
        customerMapper.addCustomer(customer);
    }
    //修改
    public void editCustomer(Customer customer){
        customerMapper.editCustomer(customer);
    }
    //删除
    public void deleteCustomer(int id){
        customerMapper.deleteCustomer(id);
    }

}
