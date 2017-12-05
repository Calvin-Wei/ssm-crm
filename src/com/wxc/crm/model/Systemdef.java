package com.wxc.crm.model;

import java.util.List;

/**
 * 部门信息
 */
public class Systemdef {
    private Integer id;
    private String name;
    private String iconCls;
    private Integer countChildrens;
    /**
     * 父级菜单ID 0表示根节点
     */
    private Integer parentid;

    private Systemdef parentSystemdef;
    private List<Systemdef> subSystemdef;
    private boolean hasSystemdef=false;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public Integer getCountChildrens() {
        return countChildrens;
    }

    public void setCountChildrens(Integer countChildrens) {
        this.countChildrens = countChildrens;
    }

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    public Systemdef getParentSystemdef() {
        return parentSystemdef;
    }

    public void setParentSystemdef(Systemdef parentSystemdef) {
        this.parentSystemdef = parentSystemdef;
    }

    public List<Systemdef> getSubSystemdef() {
        return subSystemdef;
    }

    public void setSubSystemdef(List<Systemdef> subSystemdef) {
        this.subSystemdef = subSystemdef;
    }

    public boolean isHasSystemdef() {
        return hasSystemdef;
    }

    public void setHasSystemdef(boolean hasSystemdef) {
        this.hasSystemdef = hasSystemdef;
    }
}
