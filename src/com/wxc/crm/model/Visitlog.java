package com.wxc.crm.model;

import java.util.Date;

/**
 * 拜访记录
 */
public class Visitlog {
    private int id;
    private int customerid;
    private String idcard;
    private Date vdate;
    private String vtype;
    private String vremark;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerid() {
        return customerid;
    }

    public void setCustomerid(int customerid) {
        this.customerid = customerid;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public Date getVdate() {
        return vdate;
    }

    public void setVdate(Date vdate) {
        this.vdate = vdate;
    }

    public String getVtype() {
        return vtype;
    }

    public void setVtype(String vtype) {
        this.vtype = vtype;
    }

    public String getVremark() {
        return vremark;
    }

    public void setVremark(String vremark) {
        this.vremark = vremark;
    }
}
