<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<div id="p" class="easyui-panel" title="上报资格" style="width:100%;height:100%;padding:10px;">
	
	<form id="ff" method="post" action="baodan/comn/api/model/post" >
	    	<table cellpadding="5">
	    		<tr><td>抢 购 人:</td><td>${param.name }</td></tr>
	    		<tr>
	    			<td>抢购平台:</td>
	    			<td>
	    			<select class="easyui-combobox"  data-options="required:true,
	    				url:'baodan/comn/api/malls/get',
	    				method:'get',
	    				valueField:'id',
						textField:'name',
	    				editable:false,
	    				onSelect:onMallSelect,
	    				prompt:'请选择'
	    				
	    			" name="mall" missingMessage="请选择抢购平台" style="width: 78px;"></select>
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>购买渠道:</td>
	    			<td>
	    			<select class="easyui-combobox"  data-options="editable:false" name="way"><option value="0">官方</option><option value="1">第三方</option></select>
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>手机型号:</td>
	    			<td>
	    				<input id="select-model" class="easyui-combobox" name="model" style="width:200px;" data-options="required:true,
	    					method:'get',
							valueField:'id',
							textField:'sets',
							groupField:'name',
							prompt:'请选择',
							onSelect:function(r){console.log(r)}
						" missingMessage="请选择手机型号" >
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>支付方式:</td>
	    			<td>
	    				<select class="easyui-combobox"  data-options="editable:false,required:true,
	    				prompt:'请选择',
	    				valueField: 'value',
						textField: 'label',
						data: [{
							label: '群主付款',
							value: '0'
						},{
							label: '货到付款',
							value: '1'
						},{
							label: '自己垫付',
							value: '2'
						}]" name="payway" missingMessage="请选择支付方式"  style="width: 78px;">
	    				</select>
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>上报数量:</td>
	    			<td>
	    				<input name="amount" class="easyui-numberspinner" value="1" data-options="increment:1,min:1,max:200,required:true,prompt:'请填上报数量' " missingMessage="请填写上报数量"  style="width:78px;"></input>
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>实付金额:</td>
	    			<td>
	    				<input name="pay" class="easyui-numberspinner" value="0" data-options="increment:1,min:1,max:20000,required:true,prompt:'请填实付金额' " missingMessage="请填写实付金额"  style="width:78px;"></input>
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>订单编号:</td>
	    			<td><input class="easyui-textbox" name="orderId" data-options="required:true,prompt:'请填写订单号'" missingMessage="请填写订单号" ></input></td>
	    		</tr>
	    		<tr>
	    			<td>收 获 人:</td>
	    			<td><input class="easyui-textbox" name="orderUser" data-options="required:true,prompt:'请填写收获人'"  missingMessage="请填写收获人"></input></td>
	    		</tr>
	    		<tr>
	    			<td>收获电话:</td>
	    			<td><input class="easyui-textbox" name="orderPhone" data-options="required:true,prompt:'请填写收获电话'" missingMessage="请填写收获电话" ></input></td>
	    		</tr>
	    		<tr>
	    			<td>收获地址:</td>
	    			<td><input class="easyui-textbox" name="orderAdress" data-options="required:true,multiline:true,prompt:'请填写收获地址'" missingMessage="请填写收获地址" style="height:48px"></input></td>
	    		</tr>
	    		<tr>
	    			<td>抢购账号:</td>
	    			<td><input class="easyui-textbox" name="orderAccount" data-options="prompt:'请填平台下单账号'" ></input></td>
	    		</tr>
	    		<tr>
	    			<td>抢购密码:</td>
	    			<td><input class="easyui-textbox" name="orderPwd" data-options="prompt:'请填平台下单账号的密码'" ></input></td>
	    		</tr>
	    		<tr>
	    			<td>备&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注:</td>
	    			<td><input class="easyui-textbox" name="remark" data-options="multiline:true" style="height:48px"></input></td>
	    		</tr>
	    	</table>
	    </form>
	    <div style="text-align:left;padding:15px">
	    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">提 交</a>
<!-- 	    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">Clear</a> -->
	    </div>
	
</div>
<script>
$(function(){
	$("#ff").on('change','input[name=model]',function(){
		console.log('change',$(this).val());
	});	
	
});

function submitForm(){
	$('#ff').form('submit',{
		onSubmit:function(){
			return $(this).form('enableValidation').form('validate');
		},
		success:function(d){
			if(d.status==200){
				clearForm();
				myalert("sucess","提交成功");
			}else{
				myalert("错误",d.msg,'error');
			}
		}
	});
}

function clearForm(){
	$('#ff').form('clear');
}

function myalert(title,msg,msgtype){
	if(!!msgtype){
		$.messager.alert(title,msg,msgtype);
	}else{
		$.messager.alert(title,msg);
	}
	
}
function onMallSelect(row){
	//console.log('onMallSelect',row);
	if(row.id){
		modelloadDataDefault();
		reloadModel(row.id);
	}else{
		modelloadDataDefault();
	}
}
function onMallDataLoad(param,success,error){
	console.log('onMallDataLoad',param);
}
function modelloadDataDefault(){
	$('#select-model').combobox('clear');
	
}
function reloadModel(mall){
	$('#select-model').combobox('reload', 'baodan/comn/api/model/list?mall='+mall);
}

</script>