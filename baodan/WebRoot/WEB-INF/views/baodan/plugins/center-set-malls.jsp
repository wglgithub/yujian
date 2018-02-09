<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<div id="p" class="easyui-panel" title="商城管理" style="width:100%;height:100%;">
<div>
<!-- 	<div id="tb" style="padding:5px;background:#fafafa;width:500px;border:1px solid #ccc"> -->
<!-- 	<a id="addmallbtn" href="javascript:;" class="easyui-linkbutton" iconCls="icon-add">添加</a> -->
<!-- 	</div> -->
	<div id="addmalldlg"  title="添加商城" data-options="iconCls:'icon-add'" style="width:400px;height:200px;padding:10px;display:none;">
		<form id="ff" action="baodan/admin/api/mall/add" method="post">
		<table>
			<tr>
				<td>名称:</td>
				<td><input class="easyui-textbox" style="width:150px;height:32px" name="name" type="text"></input></td>
			</tr>
			
			<tr>
				<td></td>
				<td>
				<a href="javascript:onFormSubmit();" class="easyui-linkbutton" data-options="iconCls:'icon-add'">添加</a>
				</td>
			</tr>
		</table>
	</form>
	</div>
</div>
<table id="table-list" >
	<thead>
		<tr>
			<th data-options="field:'name',align:'center'" width="30">商城名称</th>
			<th data-options="field:'dateStr',align:'center'" width="30">添加时间</th>
		</tr>
	</thead>
</table>

<script type="text/javascript">
function onFormSubmit(){
	$('#ff').trigger('submit'); 
}
$(function(){
// 	$('#addmallbtn').click(function(){
// 		$('#addmalldlg').dialog({
// 			iconCls:'icon-add'
// 		});
// 	});
	function showAddDialog(){
		$('#addmalldlg').dialog({
			iconCls:'icon-add'
		});
	}
	function closeAddDialog(){
		$('#addmalldlg').dialog('close');
	}
	$('#table-list').datagrid({
		url:'<%=basePath %>baodan/admin/api/mall/list',
		method:'get',border:false,singleSelect:true,fit:true,fitColumns:true,
		pageNumber:1,
		pageSize:10,
		pagination:true,
		toolbar: [{
			iconCls: 'icon-add',
			handler: function(){showAddDialog();}
		},'-',{
			iconCls: 'icon-help',
			handler: function(){alert('点击左侧加号按钮添加商城')}
		}]
	});
	function reloadmalls(){
		$('#table-list').datagrid('reload');
	} 
	$('#ff').form({
		success:function(data){
			var rep = eval('('+data+')');
			if(rep.status==200){
				closeAddDialog();
				reloadmalls();
			}else{
				$.messager.alert('error', rep.msg, 'error');
			}
			
		}
	});
});
</script>
</div>