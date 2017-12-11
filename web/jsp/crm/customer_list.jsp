<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/12/2
  Time: 21:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>客户信息管理</title>
    <%@include file="/WEB-INF/jsp/include/easyui_core.jsp" %>
    <link href="${path}/css/list.css" rel="stylesheet" type="text/css" />

    <script type="text/javascript">
        //请求地址
        var url;
        //提示消息
        var mesTitle;
        //添加用户信息
        function addObject() {
            $('#dlg').dialog('open').dialog('setTitle','新增用户');
            $('#fm').form('clear');
            url=path+"/customer/add";
            mesTitle='新增用户成功';
        }
        //编辑用户信息
        function editObject() {
            var row=$('#datagrid').datagrid('getSelected');
            if(row){
                var id=row.id;
                $('#dlg').dialog('open').dialog('setTitle','编辑用户');
                $('#fm').form('load',row);
                url=path+"/customer/edit?id="+id;
                mesTitle='编辑用户成功';
            }else{
                $.messager.alert('提示','请选择要删除的记录!','error');
            }
        }

        function saveObject(){
            $('#fm').form('submit',{
               url:url,
               onSubmit:function () {
                   return $(this).form('validate');
               } ,
                success:function (result) {
                    var result=eval('('+result+')');
                    if(result.success){
                        $('#dlg').dialog('close');
                        $('#datagrid').datagrid('reload');
                    }else{
                        mesTitle='新增用户失败';
                    }
                    $.messager.show({
                        title:mesTitle,
                        msg:result.msg
                    });
                }
            });
        }
        //提交删除内容
        function saveObject_del(){
            $('#fm').form('submit',{
               url:url,
               success:function(result){
                   var result=eval('('+result+')');
                   if(result.success){
                       $('#dlg_delete').dialog('close');
                       $('#datagrid').datagrid('reload');
                   }else{
                       mesTitle='删除用户失败';
                   }
                   $.messager.show({
                       title:mesTitle,
                       msg:result.msg
                   });
               }
            });
        }

        function reload(){
            $('#datagrid').datagrid('reload');
        }


    </script>

</head>
<body class="easyui-layout" fit="true" >
    <div region="center" border="false" style="overflow: hidden" >
        <table id="datagrid" class="easyui-datagrid" fit="true" url="${path}/customer/datagrid"
               toolbar="#toolbar" pagination="true" fitColumns="true" singleSelect="true"
               rownumbers="true" striped="true" border="false" nowrap="false"
        >
            <thead>
                <tr>
                    <th field="id" width="100">编号</th>
                    <th field="name" width="100">名称</th>
                    <th field="address" width="100">地址</th>
                    <th field="zipcode" width="100">邮编</th>
                    <th field="fax" width="100">传真</th>
                </tr>
            </thead>
        </table>
        <!-- 按钮 -->
        <div id="toolbar">
            <a href="javascript:void(0);" class="easyui-linkbutton"
               iconCls="icon-reload" plain="true" onclick="reload();">刷新</a>
            <a href="javascript:void(0);" class="easyui-linkbutton"
               iconCls="icon-add" plain="true" onclick="addObject();">新增客户</a>
            <a href="javascript:void(0);" class="easyui-linkbutton"
               iconCls="icon-edit" plain="true" onclick="editObject();">编辑客户</a>
            <a href="javascript:void(0);" class="easyui-linkbutton"
               iconCls="icon-remove" plain="true" onclick="deleteObject();">删除客户</a>
        </div>
        <!-- 添加/修改对话框 -->
        <div id="dlg" class="easyui-dialog" style="width: 400px;height: 280px;padding: 10px 20px"
             closed="true" buttons="#dlg-buttons">
            <div class="ftitle">新增客户</div>
            <form id="fm" method="post" novalidate>
                <div class="fitem">
                    <label>客户名称</label>
                    <input name="name" class="easyui-textbox" required="true">
                </div>
                <div class="fitem">
                    <label>联系地址：</label>
                    <input name="address" class="easyui-textbox" required="true">
                </div>
                <div class="fitem">
                    <label>邮编：</label>
                    <input name="zipcode" class="easyui-textbox" required="true">
                </div>
                <div class="fitem">
                    <label>传真：</label>
                    <input name="fax" class="easyui-textbox" required="true">
                </div>
            </form>

            <!-- 添加/修改对话框按钮 -->
            <div id="dlg-buttons">
                <a href="javascript:void(0)" class="easyui-linkbutton c6"
                   iconCls="icon-ok" onclick="saveObject()" style="width:90px">保存</a>
                <a href="javascript:void(0)" class="easyui-linkbutton"
                   iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')"
                   style="width:90px">取消</a>
            </div>
            <!-- 删除对话框 -->
            <div id="dlg_delete" class="easyui-dialog"
                 style="width: 300px;height: 200px;padding: 10px 20px"
                 closed="true" buttons="#dlg-del-buttons">

                <div class="ftitle">请谨慎操作</div>
                <form id="fm" method="post" novalidate>
                    <label>确定删除客户吗?</label>
                </form>
            </div>

            <!-- 删除对话框按钮 -->
            <div id="dlg-del-buttons">
                <a href="javascript:void(0)" class="easyui-linkbutton c6"
                   iconCls="icon-ok" onclick="saveObject_del()" style="width:90px">删除</a>
                <a href="javascript:void(0)" class="easyui-linkbutton"
                   iconCls="icon-cancel" onclick="javascript:$('#dlg_delete').dialog('close')"
                   style="width:90px">取消</a>
            </div>

        </div>

    </div>
</body>
</html>
