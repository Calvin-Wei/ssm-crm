<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/12/3
  Time: 17:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>菜单管理</title>
    <%@include file="/WEB-INF/jsp/include/easyui_core.jsp" %>
    <script src="${path}/js/assets/menu_list_treegrid.js" type="text/javascript"></script>
</head>
<body class="easyui-layout" fit="true">
<div region="center" border="false" style="overflow: hidden;">
    <!-- 信息列表title='菜单管理' -->
    <table id="treegrid" class="easyui-treegrid"
           fit="true" nowrap="false"
           fitColumns="true" singleSelect="true" rownumbers="true"
           data-options="url:'${path}/menu/treegrid',
			idField:'id',
			treeField:'name',
			toolbar:'#toolbar',
			border:false">

        <thead>
            <tr>
                <th data-options="field:'id',width:40">编号</th>
                <th data-options="field:'name',width:150">资源名称</th>
                <th data-options="field:'url',width:200,formatter:formatParentId">资源路径</th>
                <th data-options="field:'sequence',width:50,formatter:formatParentId">排序</th>
                <th data-options="field:'iconCls',width:80,formatter:formatParentId">图标</th>
                <th data-options="field:'parentid',width:80,formatter:formatParentId">上级资源ID</th>
                <th data-options="field:'enable',width:40,align:'center',formatter:formatState">状态</th>
                <th data-options="field:'action',width:120,formatter:formatAction">操作</th>
            </tr>
        </thead>
    </table>
    <!-- 按钮 -->
    <div id="toolbar">
        <a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-reload" plain="true" onclick="reload();">刷新</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="onAdd()">增加</a>
    </div>

    <!-- 添加/修改对话框 -->
    <div id="dlg" class="easyui-dialog" style="width: 400px;height: 200px;padding: 10px 20px"
         closed="true" buttons="#dlg-buttons" >
        <form id="fm" method="post" novalidate>
            <div class="fitem">
                <label>菜单名称：</label>
                <input name="text" class="easyui-textbox" required="true"  >
            </div>
            <div class="fitem">
                <label>资源地址：</label>
                <input name="url" class="easyui-textbox" required="true">
            </div>
        </form>
    </div>

    <!-- 添加/修改对话框-按钮 -->
    <div id="dlg-buttons">
        <a href="javascript:void(0)" class="easyui-linkbutton c6"
           iconCls="icon-ok" onclick="onSave()" style="width: 90px">保存</a>
        <a href="javascript:void(0)" class="easyui-linkbutton"
           iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')"
           style="width: 90px">取消</a>
    </div>

    <!-- 删除对话框 -->
    <div id="dlg_delete" class="easyui-dialog" style="width: 300px;height: 200px;padding: 10px 20px"
         closed="true" buttons="#dlg-del-buttons">
        <div class="ftitle">请谨慎操作</div>
        <form id="fm" method="post" novalidate >
            <label>确定删除菜单吗？</label>
        </form>
    </div>

    <!-- 删除对话框-按钮 -->
    <div id="dlg-del-buttons">
        <a href="javascript:void(0)" class="easyui-linkbutton c6"
           iconCls="icon-ok" onclick="on_save_del()" style="width:90px">删除</a>
        <a href="javascript:void(0)" class="easyui-linkbutton"
           iconCls="icon-cancel" onclick="javascript:$('#dlg_delete').dialog('close')"
           style="width:90px">取消</a>
    </div>
</div>
</body>
</html>
