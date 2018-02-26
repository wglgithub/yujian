<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<div id="p" class="easyui-panel" title="资格查询" style="width:100%;height:100%;">
	<div class="easyui-layout" fit="true">
		<div id="tb"  region="north" border="false" style="padding:3px">
			<span>Item ID:</span>
			<input id="itemid" style="line-height:26px;border:1px solid #ccc">
			<span>Product ID:</span>
			<input id="productid" style="line-height:26px;border:1px solid #ccc">
			<a href="javascript:;" class="easyui-linkbutton" plain="true" onclick="doSearch()">搜索</a>
	
		</div>
		<div region="center" border="false">
		<table id="table-list">
		
			<thead>
				<tr>
					<c:if test="${param.role ne 'worker' }">
					<th data-options="field:'submitUser',align:'center'" width="30">抢购人</th>
					</c:if>
					<th data-options="field:'mall',align:'center'" width="30">抢购商城</th>
					<th data-options="field:'model',align:'center'" width="30">型号</th>
					<th data-options="field:'color',align:'center'" width="15">颜色</th>
					<th data-options="field:'amount',align:'center'" width="10">数量</th>
					<th data-options="field:'orderno',align:'center'" width="40">订单编号</th>
					<th data-options="field:'payway',align:'center'" width="30">支付方式</th>
					<th data-options="field:'realpay',align:'center'" width="15">实付金额</th>
					<th data-options="field:'state1',align:'center'" width="20">处理状态</th>
					<th data-options="field:'applystate',align:'center'" width="20">审核状态</th>
					<th data-options="field:'date',align:'center'" width="30">报单时间</th>
					<th data-options="field:'returnPay',align:'center'" width="20">回款金额</th>
					<th data-options="field:'wuliu',align:'center'" width="30">物流单号</th>
					<th data-options="field:'remark',align:'center'" width="30">备注</th>
				</tr>
			</thead>
		</table>
		</div>
		<div id="mm" class="easyui-menu" data-options="onClick:menuHandler" style="width:120px;">
			<div data-options="name:'new',iconCls:'icon-add'">上报资格</div>
			<div data-options="name:'wuliu',iconCls:'icon-edit'" disabled="true" >填写物流</div>
			<div class="required-select" disabled="true" data-options="name:'edit',iconCls:'icon-edit'">编辑</div>
			<div class="menu-sep required-select"></div>
			<div class="required-select" disabled="true" data-options="name:'del',iconCls:'icon-remove'">删除</div>
		</div>
		<div id="mm-selected" class="easyui-menu" data-options="onClick:menuHandler" style="width:120px;">
			<div data-options="name:'new',iconCls:'icon-add'">上报资格</div>
			<div data-options="name:'wuliu',iconCls:'icon-edit'">填写物流</div>
			<div class="required-select" disabled="true" data-options="name:'edit',iconCls:'icon-edit'">编辑</div>
			<div class="menu-sep required-select"></div>
			<div class="required-select" disabled="true" data-options="name:'del',iconCls:'icon-remove'">删除</div>
		</div>
		<div id="editwuliudlg"  title="填写物流单号" data-options="iconCls:'icon-add'" style="width:350px;height:180px;padding:10px;display:none;position: relative;">
			<form id="ff_wuliu" action="baodan/comn/api/order/fahuo" method="post">
				<input name="id" type="hidden" >
				<table>
					<tr>
						<td style="width: 30px;" >物流单号:</td>
						<td><input class="easyui-textbox easyui-validatebox" required="true" data-options="prompt:'请输入物流单号'" missingMessage="物流单号不能空" style="width:150px;height:26px" name="no" ></td>
					</tr>
				</table>
				<div style="text-align: center;">
					<a href="javascript:onWuliuFormSubmit(this);" class="easyui-linkbutton" data-options="iconCls:'icon-add'" >保存</a>
				</div>
			</form>
		</div>
	</div>
</div>
<script type="text/javascript">
$('#table-list').datagrid({
	url:'<%=basePath %>baodan/comn/api/zige/list',
	method:'get',border:false,singleSelect:true,fit:true,fitColumns:true,
	pageNumber:1,
	pageSize:20,
	pagination:true
});
function reloadData(){
	$('#table-list').datagrid('reload');
} 
//右键菜单
$("#p").bind('contextmenu',function(e){
	e.preventDefault();
	if(!getSelected()){
		$('#mm').menu('show', {left: e.pageX,top: e.pageY});
	}else{
		$('#mm-selected').menu('show', {left: e.pageX,top: e.pageY});
	}
	
});
//获取选择的第一行数据，如果没有选中的则返回null
function getSelected(){
	return $("#table-list").datagrid('getSelected');
}

function doSearch(){
	$('#table-list').datagrid('load',{
		itemid: $('#itemid').val(),
		productid: $('#productid').val()
	});
}
//右键菜单点击
function menuHandler(item){
	if(item.name=='new'){
		window.location.href=$('#上报资格 a').get(0).href;
	}else if(item.name=='wuliu'){
		var itemid = getSelected().id;
		openWuliuEditDialog(itemid);
	}
	else if(item.name=='edit'){
		var itemid = getSelected().id;
		openEditDialog(itemid);
	}else if(item.name=='del'){
		var itemid = getSelected().id;
		sendDeleteAction(itemid);
	}
}

function openWuliuEditDialog(dataId){
	$('#editwuliudlg').dialog({
		iconCls:'icon-edit',
		onBeforeOpen:function(){
			$('#editwuliudlg input[name]').val(dataId);
			return true;
		}});
}
function closeWuliuDialog(){
	$('#editwuliudlg').dialog('close');
}

function onWuliuFormSubmit(){
	$('#ff_wuliu').trigger('submit'); 
}

$('#ff_wuliu').form({
	success:function(data){
		var rep = eval('('+data+')');
		if(rep.status==200){
			closeWuliuDialog();
			reloadData();
		}else{
			$.messager.alert('error', rep.msg, 'error');
		}
		
	}
});
</script>
