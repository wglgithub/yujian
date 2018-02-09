<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<table class="easyui-datagrid"
		data-options="url:'datagrid_data1.json',method:'get',border:false,singleSelect:true,fit:true,fitColumns:true">
	<thead>
		<tr>
			<th data-options="field:'date',align:'center'" width="30">报单时间</th>
			<th data-options="field:'mall',align:'center'" width="30">抢购商城</th>
			<th data-options="field:'model',align:'center'" width="30">型号</th>
			<th data-options="field:'color',align:'center'" width="15">颜色</th>
			<th data-options="field:'amount',align:'center'" width="10">数量</th>
			<th data-options="field:'orderno',align:'center'" width="40">订单编号</th>
			<th data-options="field:'payway',align:'center'" width="30">支付方式</th>
			<th data-options="field:'realpay',align:'center'" width="15">实付金额</th>
			<th data-options="field:'state1',align:'center'" width="20">处理状态</th>
			<th data-options="field:'applystate',align:'center'" width="20">审核状态</th>
			<th data-options="field:'returnPay',align:'center'" width="20">回款金额</th>
			<th data-options="field:'wuliu',align:'center'" width="30">物流单号</th>
			<th data-options="field:'remark',align:'center'" width="30">备注</th>
		</tr>
	</thead>
</table>
