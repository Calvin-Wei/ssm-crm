package com.wxc.crm.dao;

import com.wxc.crm.model.SysMenu;
import com.wxc.crm.model.User;
import com.wxc.crm.model.easyui.PageHelper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    public User findUserByName(@Param("username") String username);

    public String getUsernameById(@Param("id") int id);

    public List<SysMenu> getMenuByUserId(@Param("userId") int userId);

    public List<User> getDatagrid();

    public Long getDatagridTotal(@Param("user") User user,@Param("csysid") Integer sysid);

    public List<User> datagridUser(@Param("page") PageHelper pageHelper,@Param("csysid")Integer sysid);

    public void addUser(User user);

    public void editUser(User user);

    public void deleteUser(int id);
}
