package com.wxc.crm.model.com.wxc.crm.easyui;

import java.io.Serializable;
import java.util.List;

public class DataGrid implements Serializable{
    private Long total;//总记录数
    private List rows;//每行记录

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }
}
