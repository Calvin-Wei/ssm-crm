<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/12/3
  Time: 21:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>菜单管理</title>
    <%@include file="/WEB-INF/jsp/include/easyui_core.jsp"%>
    <script type="text/javascript">
        //请求地址
        var url;
        //提示信息
        var mesTitle;
        //添加信息
        function add() {
            $('#dlg').dialog('open').dialog('setTitle','新增菜单');
            $('#fm').form('clear');
            url=path+"/menu/save?parentid=0";
            mesTitle='新菜单成功';
        }
        //编辑信息
        function edit(){
            var row=$('#datagrid').datagrid('getSelected');
            if(row){
                var id=row.id;
                $('#dlg').dialog('open').dialog('setTitle','编辑菜单');
                $('#fm').form('load',row);
                url=path+"/menu/save?parentid=0&id="+id;
                mesTitle='编辑菜单成功';
            }else{
                $.messager.alert('提示','请选择要编辑的记录！','error');
            }
        }
        //删除信息
        function dtl(){
            var row=$('#datagrid').datagrid('getSelected');
            if(row){
                var id=row.id;
                $('#dlg_delete').dialog('open').dialog('setTitle','删除菜单');
                $('#fm').form('load',row);
                url=path+"/menu/del?id="+id;
                mesTitle='删除菜单成功';
            }else{
                $.messager.alert('提示','请选择要删除的记录！','error');
            }
        }
        //保存添加、修改内容
        function save() {
            $('#fm').form('submit',{
                url:url,
                onSubmit:function(){
                  return $(this).form('validate');
                },
                success:function(result){
                    var result=eval('('+result+')');
                    if(result.success){
                        $('#dlg').dialog('close');
                        $('#datagrid').datagrid('reload');
                    }else{
                        mesTitle='新增菜单失败';
                    }
                    $.messager.show({
                        title:mesTitle,
                        msg:result.msg
                    });
                }
            });
        }
        //提交删除内容
        function save_del(){
            $('#fm').form('submit',{
               url:url,
               success:function (result) {
                   var result=eval('('+result+')');
                   if(result.success){
                       $('#dlg_delete').dialog('close');
                       $('#datagrid').datagrid('reload');
                   }else{
                       mesTitle='删除菜单失败';
                   }
                   $.messager.show({
                       title:mesTitle,
                       msg:result.msg
                   });
               }
            });
        }
        //刷新
        function reload() {
            $('#datagrid').datagrid('reload');
        }

    </script>
</head>
<body class="easyui-layout" fit="true">
    <div region="center" border="false" style="overflow: hidden;" >
        <!-- 信息列表title="菜单管理" -->
        <table id="datagrid" class="easyui-datagrid" fit="true"
               url="${path}/menu/datagrid"
               toolbar="#toolbar"
               pagination="true"
               fitColumns="true"
               singleSelect="true"
               rownumbers="true"
               striped="true"
               border="false"
               nowrap="false">
            <thead>
            <tr>
                <th field="id" width="100">序号</th>
                <th field="name" width="100">名称</th>
                <th field="url" width="100">资源路径</th>
            </tr>
            </thead>
        </table>

        <!-- 按钮 -->
        <div id="toolbar">
            <a href="javascript:void(0);" class="easyui-linkbutton"
               iconCls="icon-reload" plain="true" onclick="reload();">刷新</a>
            <a href="javascript:void(0);" class="easyui-linkbutton"
               iconCls="icon-add" plain="true" onclick="add();">新增菜单</a>
            <a href="javascript:void(0);" class="easyui-linkbutton"
               iconCls="icon-edit" plain="true" onclick="edit();">编辑菜单</a>
            <a href="javascript:void(0);" class="easyui-linkbutton"
               iconCls="icon-remove" plain="true" onclick="dtl();">删除菜单</a>
        </div>

        <!-- 添加/修改对话框 -->
        <div id="dlg" class="easyui-dialog" style="width:400px;height:200px;padding:10px 20px" closed="true"
             buttons="#dlg-buttons">
            <form id="fm" method="post" novalidate>
                <div class="fitem">
                    <label>菜单名称:</label>
                    <input name="text" class="easyui-dialog">
                </div>
            </form>
        </div>

        <!-- 删除对话框 -->
        <div id="dlg_delete" class="easyui-dialog"
             style="width:300px;height:200px;padding:10px 20px" closed="true"
             buttons="#dlg-del-buttons">
            <div class="ftitle">请谨慎操作</div>
            <form id="fm" method="post" novalidate>
                <label>确定删除菜单</label>
            </form>
        </div>

        <!-- 删除对话框按钮 -->
        <div id="dlg-del-buttons">
            <a href="javascript:void(0)" class="easyui-linkbutton c6"
               iconCls="icon-ok" onclick="save_del()" style="width:90px">删除</a>
            <a href="javascript:void(0)" class="easyui-linkbutton"
               iconCls="icon-cancel" onclick="javascript:$('#dlg_delete').dialog('close')"
               style="width:90px">取消</a>
        </div>

    </div>
</body>
</html>
