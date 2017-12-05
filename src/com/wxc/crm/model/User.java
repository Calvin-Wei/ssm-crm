package com.wxc.crm.model;

/**
 * 用户信息
 */
public class User {
    private int id;
    private String username;
    private String password;
    private String email;

    private String idcard;
    private String gender;
    private String qq;
    private String weixin;
    private String regtime;

    private String sysname;
    private String psysname;

    public String getSysname() {
        return sysname;
    }
    public void setSysname(String sysname) {
        this.sysname = sysname;
    }
    public String getPsysname() {
        return psysname;
    }
    public void setPsysname(String psysname) {
        this.psysname = psysname;
    }
    public String getIdcard() {
        return idcard;
    }
    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getQq() {
        return qq;
    }
    public void setQq(String qq) {
        this.qq = qq;
    }
    public String getWeixin() {
        return weixin;
    }
    public void setWeixin(String weixin) {
        this.weixin = weixin;
    }
    public String getRegtime() {
        return regtime;
    }
    public void setRegtime(String regtime) {
        this.regtime = regtime;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
