package com.wxc.crm.model.com.wxc.crm.easyui;

import java.io.Serializable;

public class Json implements Serializable {
    private boolean success=false;
    private String msg="";
    private Object obj=null;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }
}
