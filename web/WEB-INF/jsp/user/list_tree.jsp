<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/12/4
  Time: 10:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>用户管理</title>
    <%@include file="/WEB-INF/jsp/include/easyui.jsp" %>
    <script src="${path}/js/assets/user_list_tree.js" type="text/javascript"></script>
</head>
<body class="easyui-layout" fit="true">
<!-- 左半部-组织机构 -->
<div id="div_organizeTree" region="west" iconCls="icon-chart_organisation" split="true" title="组织机构"
     style="width:200px;padding: 2px" collapsible="false">
    <ul id="organizeTree"></ul>
</div>
staffTab
<!-- 右半部-员工列表 -->
<div id="div_staffGird" region="center" iconCls="icon-users" style="overflow: hidden">
    <!-- 按钮 -->
    <div id="toolbar">
        <a href="javascript:void(0);" class="easyui-linkbutton"
           iconCls="icon-reload" plain="true" onclick="reload();">刷新</a>
        <a href="javascript:void(0);" class="easyui-linkbutton"
           iconCls="icon-add" plain="true" onclick="addUser();">新增</a>
        <a href="javascript:void(0);" class="easyui-linkbutton"
           iconCls="icon-edit" plain="true" onclick="editUser();">编辑</a>
        <a href="javascript:void(0);" class="easyui-linkbutton"
           iconCls="icon-remove" plain="true" onclick="deleteUser();">删除</a>
        <span>用户名：</span>
        <input name="search_username" id="search_username" value="" size="10"/>
        <a href="javascript:FindData()" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a>
        <a href="javascript:void(0);" class="easyui-linkbutton"
           iconCls="icon-jright" plain="true" onclick="searchUser();">更多查询</a>
    </div>
    <!-- 员工列表 -->
    <table id="staffGird" toolbar="#toolbar"></table>
</div>
</body>
<script type="text/javascript">
    $(function () {
        //1.1 加载组织结构树列表
        $('#organizeTree').tree({
            lines: true,
            url: '${path}/systemdef/treegrid',
            parentField: 'pid',
            onClick: function (node) {
                $('#staffGird').datagrid('reload', '${path}/user/datagrid?sysid=' + node.id);
            }
        });
        //1.2 加载所选组织结构下的员工列表
        $('#staffGird').datagrid({
            fit: true,
            url:'${path}/user/datagrid',
            title:'员工(职员)列表',
            loadMsg:'正在加载员工(职员)数据，请稍等...',
            idField:'id',
            pagination:true,
            border:false,
            nowrap:false,
            fitColumns:true,
            singleSelect:true,
            striped:true,
            rownumbers:true,
            columns:[[
                { title: '编号', field: 'username', width: 100 },
                { title: '姓名', field: 'name', width: 100 },
                { title: '性别', field: 'gender', width: 35, align: 'center' },
                { title: '所在部门', field: 'sysname', width: 100 },
                { title: '一级部门', field: 'psysname', width: 100 },
                { title: '入职时间', field: 'regtime', align: "center", width: 90 },
                { title: 'QQ号码', field: 'qq', width: 120 },
                { title: '微信', field: 'weixin', width: 120 },
                { title: '邮箱地址', field: 'email', width: 150 }
            ]],
            onLoadSuccess:function(data){
                if(data.rows.length>0){
                    $('#staffGird').datagrid('selectRow',0);
                }
            }
        });
    });
</script>
</html>
