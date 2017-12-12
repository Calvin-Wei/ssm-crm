package com.wxc.crm.model.easyui;

import java.util.List;

/**
 * EasyUI tree模型
 */
public class Tree {
    private int id;//节点的Id
    private String text;//节点显示的文字
    private String state="open";//默认open，当为'closed'时说明此节点下有子节点，否则此节点为叶子节点
    private boolean checked=false;//指示节点是否被选中
    private Object attributes;//给一个节点追加的自定义属性
    private List<Tree> children;//定义了一些子节点的节点数组
    private String iconCls;//定义了一些子节点的节点数组
    private Integer pid;//定义该节点的父节点

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public Object getAttributes() {
        return attributes;
    }

    public void setAttributes(Object attributes) {
        this.attributes = attributes;
    }

    public List<Tree> getChildren() {
        return children;
    }

    public void setChildren(List<Tree> children) {
        this.children = children;
    }

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }
}
