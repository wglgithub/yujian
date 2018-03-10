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
			<form name="ff_search">
			<div>
			<span>开始日期:</span>
			<input name="begin" class="easyui-datebox" data-options="editable:false" style="width: 100px"></input>
			<span>结束日期:</span>
			<input name="end" class="easyui-datebox" style="width: 100px"></input>
			<span>处理日期:</span>
			<input name="theday" class="easyui-datebox" data-options="editable:false" style="width: 100px"></input>
			</div>
			<div>
			<span>上 报 人 :</span>
			<input id="select-model" class="easyui-combobox" name="user" style="width:100px;" data-options="
	    					method:'get',
	    					url:'baodan/comn/api/user/select',
							valueField:'name',
							textField:'name',
							groupField:'letter',
							prompt:'请选择',
							onSelect:function(r){console.log(r)}
						"  >
				<span>抢购平台:</span>
				<select class="easyui-combobox"  data-options="
	    				url:'baodan/comn/api/malls/get',
	    				method:'get',
	    				valueField:'id',
						textField:'name',
	    				editable:false,
	    				onSelect:function(){},
	    				prompt:'请选择'
	    				
	    			" name="mall" missingMessage="请选择抢购平台" style="width: 100px;"></select>
	    		<span>处理方式:</span>	
	    		<select class="easyui-combobox"  data-options="editable:false" name="dealway">
	    			<option value="">全部</option>
	    			<option value="未确认">未确认</option>
	    			<option value="已支付">已支付</option>
	    			<option value="已签收">已签收</option>
	    			<option value="已回款">已回款</option>
	    			<option value="已发货">已发货</option>
	    		</select>
	    		<span>付款方式:</span>	
	    		<select class="easyui-combobox"  data-options="editable:false" name="payway">
	    			<option value="">全部</option>
	    			<option value="0">群主付款</option>
	    			<option value="1">货到付款</option>
	    			<option value="2">自己垫付</option>
	    		</select>
	    		<span>机 型 :</span>
				<input id="select-model" class="easyui-combobox" name="model" style="width:180px;" data-options="
	    					method:'get',
	    					url:'baodan/comn/api/model/list',
							valueField:'id',
							textField:'sets',
							groupField:'name',
							prompt:'请选择',
							onSelect:function(r){console.log(r)}
						" />
				<span>收 货 人 :</span><input name="recieve" class="easyui-textbox" style="width:100px;" >	
				<span>订单编号:</span><input name="orderno" class="easyui-textbox" style="width:100px;" >
				<a href="javascript:;" class="easyui-linkbutton" data-options="iconCls:'icon-search'"onclick="doSearch()">搜索</a>
				<a href="javascript:$('form[name=ff_search]').form('clear');" class="easyui-linkbutton">清空条件</a>
			</div>
			</form>
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
					<th data-options="field:'currentState',align:'center'" width="20">处理状态</th>
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
			
		</div>
		<div id="mm-selected" class="easyui-menu" data-options="onClick:menuHandler" style="width:120px;">
			<c:if test="${param.role eq 'admin' }">
			<div data-options="name:'sure',iconCls:'icon-ok'">确认</div>
			</c:if>
			<c:if test="${param.role eq 'admin' }">
			<div data-options="name:'sign',iconCls:'icon-ok'">签收</div>
			</c:if>
			<c:if test="${param.role ne 'worker' }">
			<div data-options="name:'returned',iconCls:'icon-ok'">回款</div>
			</c:if>
			<div data-options="name:'new',iconCls:'icon-add'">上报资格</div>
			<div data-options="name:'wuliu',iconCls:'icon-edit'">填写物流</div>
			<div class="required-select" disabled="true" data-options="name:'edit',iconCls:'icon-edit'">编辑</div>
			<div class="menu-sep required-select"></div>
			<c:if test="${param.role eq 'admin' }">
			<div class="required-select" data-options="name:'del',iconCls:'icon-remove'">取消</div>
			</c:if>
		</div>
		<div id="editwuliudlg"  title="填写物流单号" data-options="iconCls:'icon-add',buttons:'#editwuliudlg_buttons'" style="width:350px;height:180px;padding:10px;display:none;position: relative;">
			<form id="ff_wuliu" action="baodan/comn/api/order/fahuo" method="post">
				<input name="id" type="hidden" >
				<table>
					<tr>
						<td style="width: 30px;" >物流单号:</td>
						<td><input class="easyui-textbox easyui-validatebox" required="true" data-options="prompt:'请输入物流单号'" missingMessage="物流单号不能空" style="width:150px;height:26px" name="no" ></td>
					</tr>
				</table>
				<div id="editwuliudlg_buttons" style="text-align: center;">
					<a href="javascript:onWuliuFormSubmit(this);" class="easyui-linkbutton" data-options="iconCls:'icon-add'" >保存</a>
				</div>
			</form>
		</div>
		<div id="returneddlg"  title="填写回款信息" data-options="iconCls:'icon-edit',buttons:'#returneddlg_buttons'" style="width:450px;height:300px;padding:10px;display:none;position: relative;">
			<form id="ff_returneddlg" action="baodan/admin/api/zige/return" method="post">
				<input name="id" type="hidden" >
				<table>
					<tr>
						<td style="width: 60px;" >下单机型:</td>
						<td><span class="model"></span></td>
					</tr>
					<tr>
						<td style="width: 60px;" >下单数量:</td>
						<td><span class="amount"></span></td>
					</tr>
					<tr>
						<td style="width: 60px;" >下单金额:</td>
						<td><span class="orderpay"></span></td>
					</tr>
					<tr>
						<td style="width: 60px;" >出货单价:</td>
						<td><input id="sold" name="sold" class="easyui-numberbox" value="" data-options="min:0,precision:2,required:true,prompt:'出货单价',onChange:onReturnInputChange " missingMessage="请填写出货单价"  style="width:78px;"></input></td>
					</tr>
					<tr>
						<td style="width: 60px;" >回款金额:</td>
						<td><input id="returned" name="return" class="easyui-numberbox" value="" data-options="min:0,precision:2,required:true,prompt:'给下级的回款' ,onChange:onReturnInputChange " missingMessage="请填写回款金额"  style="width:78px;"></input></td>
					</tr>
					<tr>
						<td style="width: 60px;" >收益金额:</td>
						<td><span class="earnings">---</span></td>
						<input name="earnings" type="hidden">
					</tr>
				</table>
				<div id="returneddlg_buttons" style="text-align: center;">
					<a href="javascript:onReturnFormSubmit(this);" class="easyui-linkbutton" data-options="iconCls:'icon-add'" >保存</a>
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
	var select_data = getSelected();
	var role = "${param.role}";
	console.log('contextmenu',select_data);
	if(!select_data){
		$('#mm').menu('show', {left: e.pageX,top: e.pageY});
	}else{
		$('#mm-selected').menu('show', {left: e.pageX,top: e.pageY});
		var item = $('#mm-selected').menu('findItem', '确认');
		if(select_data.applystate!='未确认'){
			//禁用确认按钮
			$('#mm-selected').menu('disableItem', item.target);
		}else{
			$('#mm-selected').menu('enableItem', item.target);
		}
		item = $('#mm-selected').menu('findItem', '签收');
		if(select_data.fahuoState=='已签收'){
			$('#mm-selected').menu('disableItem', item.target);
		}else{
			$('#mm-selected').menu('enableItem', item.target);
		}
		item = $('#mm-selected').menu('findItem', '回款');
		if(select_data.paymentState2=='未回款'&& role=='agent' || select_data.paymentState1=='未回款'&& role=='admin' ){
			$('#mm-selected').menu('enableItem', item.target);
		}else{
			$('#mm-selected').menu('disableItem', item.target);
		}
	}
	
});
//获取选择的第一行数据，如果没有选中的则返回null
function getSelected(){
	return $("#table-list").datagrid('getSelected');
}

function doSearch(){
	$('#table-list').datagrid('load',$('form[name=ff_search]').serializeObject());
}
//右键菜单点击
function menuHandler(item){
	var bindData = getSelected();
	if(item.name=='new'){
		window.location.href=$('#上报资格 a').get(0).href;
	}else if(item.name=='wuliu'){
		openWuliuEditDialog(bindData.id);
	}
	else if(item.name=='edit'){
		openEditDialog(bindData.id);
	}else if(item.name=='del'){
		sendDeleteAction(bindData.id);
	}else if(item.name=='sure'){
		$.messager.confirm('确认资格', '确认资格信息吗?', function(r){
			if (r){
				$.ajax({
					url:'baodan/admin/api/zige/sure',
					data:{id:bindData.id},
					success:function(rep){
						console.log(rep);
						reloadData();
					}
				});
			}
		});
	}else if(item.name=='sign'){
		$.messager.confirm('签收', '确认签收吗?', function(r){
			if (r){
				$.ajax({
					url:'baodan/admin/api/zige/sign',
					data:{id:bindData.id},
					success:function(rep){
						console.log(rep);
						reloadData();
					}
				});
			}
		});
	}else if(item.name=='returned'){
		showReturneddlg(bindData);
	}
}

function showReturneddlg(data){
	$('#returneddlg').dialog({
		iconCls:'icon-edit',
		onBeforeOpen:function(){
			$('#returneddlg').data(data);
			$('#returneddlg input[name=id]').val(data.id);
			$('#returneddlg .model').html(data.model);
			$('#returneddlg .amount').html(data.amount);
			$('#returneddlg .orderpay').html(data.realpay);
			return true;
		},
		onClose:function(){
			$('#returneddlg input').unbind('keydown');
		},
		onChange:function(newValue,oldValue){
			console.log(newValue,oldValue);
		}
	});
}
function closeReturneddlg(){
	$('#returneddlg').dialog('close');
	$('#returneddlg .earnings').html('---');
	$('#ff_returneddlg').form('clear');
}

function onReturnInputChange(newValue,oldValue){
	var d = $('#returneddlg').data();
	var xiadan = d.realpay,
	chu = $('#sold').numberbox('getValue') ,
	hui = $('#returned').numberbox('getValue'),
	shouyi =  parseFloat(chu*d.amount) -parseFloat(xiadan) -parseFloat( hui||0);
	console.log(chu,hui);
	$('#returneddlg .earnings').html(shouyi.toFixed(2));
}

function sendDeleteAction(dataid){
	$.messager.confirm('删除资格', '确认删除资格记录吗?', function(r){
		if (r){
			$.ajax({
				url:'baodan/admin/api/zige/rm',
				data:{id:dataid},
				success:function(rep){
					console.log(rep);
					reloadData();
				}
			});
		}
	});
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
function onReturnFormSubmit(){
	$('#ff_returneddlg').trigger('submit'); 
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

$('#ff_returneddlg').form({
	onSubmit:function(param){
		var fd = $('#ff_returneddlg').serializeObject();
		param.shippingPrice = fd.sold*100;
		param.returned = fd['return']*100;
		console.log(param);
	},
	success:function(data){
		var rep = eval('('+data+')');
		if(rep.status==200){
			closeReturneddlg();
			reloadData();
		}else{
			$.messager.alert('error', rep.msg, 'error');
		}
	}
});
</script>
