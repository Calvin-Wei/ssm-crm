/**
 *格式化资源显示名称，easyui在显示节点字段时，如果记录中有iconCls值，easyui会根据该值来相应的图标，
 *如果没有则应默认图标代替。这里在传递过来的json字符串中未含有iconCls字段，但包含icon字段，这里只需
 *将icon字段值赋给iconCls，即可显示图标。
 *数据库中字段已命名位iconCls,故此方法可以省略
 **/
function formatName(value, row, index) {
	//在名称前面显示图标就是靠iconCls属性，iconCls属性为一个css类，easyui拿到这个属性值就能显示相应的图标了
	//由于传递过来的json字符串中未包含iconCls属性，只有icon属性，所以要想easyui显示图标只需将icon的值赋给iconCls
	row.iconCls = row.icon;
	return value;
}

/**
 *格式化父资源的显示，为0时不显示父资源
 **/
function formatParentId(value, row, index) {
	if (row.parentid == 0) {
		return null;
	} 
	return value;
}

/**
 *格式化状态，如果为1，显示正常，为0显示禁用
 */
function formatState(value,row,index) {
	if (row.parentid == 0) {
		return null;
	} 
	return  value==1 ? '<img src="../js/easyui/themes/icons/ok.png" alt="正常" title="正常" />' : '<img src="../js/easyui/themes/icons/stop.png" alt="禁用" title="禁用" />'; 
}

/**
 *格式化操作，在每行的操作栏显示编辑和删除操作
 */
function formatAction(value, row, index) {
	if (row.parentid == 0) {
		return null;
	} 
	var str = '';
	if (true) {
		//str += '<a href="javascript:onEdit()"><img src="../js/easyui/themes/icons/pencil.png" alt="编辑" title="编辑" /></a>';
		str += '<a href="javascript:onEdit()">编辑</a>';
	}
	str += '&nbsp;&nbsp;|&nbsp;&nbsp;';
	if (true) {
		str += '<a href="javascript:onDelete()">删除</a>';
	}
	return str;
}

////////////////////////////////////////////////////////////////
//请求地址
var url;
//提示消息
var mesTitle;

//添加信息
function onAdd(){
	$('#dlg').dialog('open').dialog('setTitle','新增菜单');
	$('#fm').form('clear');
	url = path+"/menu/save?parentid=0";
	mesTitle = '新增菜单成功';
}

//编辑信息
function onEdit(){
 	var row = $('#treegrid').treegrid('getSelected');
 	if (row){
 		var id = row.id;
	 	$('#dlg').dialog('open').dialog('setTitle','编辑菜单');
	 	$('#fm').form('load',row);//这句话有问题，第一次加载时正确的，第二次就出错了，还保持第一次的数据
	 	url = path+"/menu/save?parentid=0&id="+id;
	 	mesTitle = '编辑菜单成功';
 	}else{
 		$.messager.alert('提示', '请选择要编辑的记录！', 'error');
 	}
}
	
//删除信息
function onDelete(){
 	var row = $('#treegrid').treegrid('getSelected');
 	if (row){
 		var id = row.id;
	 	$('#dlg_delete').dialog('open').dialog('setTitle','删除菜单');
	 	$('#fm').form('load',row);//这句话有问题，第一次加载时正确的，第二次就出错了，还保持第一次的数据
	 	url = path+"/menu/del?id="+id;
	 	mesTitle = '删除菜单成功';
 	}else{
 		$.messager.alert('提示', '请选择要删除的记录！', 'error');
 	}
}
	
//保存添加、修改内容
function onSave(){
 	$('#fm').form('submit',{
	 	url: url,
	 	onSubmit: function(){
	 		return $(this).form('validate');
	 	},
		success: function(result){
			var result = eval('('+result+')');
			if (result.success){
			 	$('#dlg').dialog('close'); 
			 	reload();
			} else {
				 mesTitle = '新增菜单失败';
			}
			$.messager.show({ 
				 title: mesTitle,
				 msg: result.msg
			});
		}
 	});
}	

//提交删除内容
function on_save_del(){
 	$('#fm').form('submit',{
	 	url: url,
		success: function(result){
			var result = eval('('+result+')');
			if (result.success){
			 	$('#dlg_delete').dialog('close'); 
			 	reload();
			} else {
				 mesTitle = '删除菜单失败';
			}
			$.messager.show({ 
				 title: mesTitle,
				 msg: result.msg
			});
		}
 	});
}

///////////////////////////////////////////////////////////////////
//刷新
function reload() {
    $('#treegrid').treegrid('reload');
}