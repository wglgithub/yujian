<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>龙卷风-登录</title>
	<base href="<%=basePath%>">
	<link rel="stylesheet" type="text/css" href="res/jquery-easyui-1.5.3/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="res/jquery-easyui-1.5.3/themes/icon.css">
	<script type="text/javascript" src="res/jquery-easyui-1.5.3/jquery.min.js"></script>
	<script type="text/javascript" src="res/jquery-easyui-1.5.3/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="res/js/util.js"></script>
	<style type="text/css">
	#sign>div{
		margin: 10px;
	}
	.submit-btn{height: 30px;width: 65px;}
	</style>
  </head>
<body>
	<div class="easyui-layout" style="width:700px;height:350px;margin: auto;">
		<div data-options="region:'north'" style="border:none;">
			<h2>龙卷风资格上报系统</h2>
			<p>欢迎大家使用龙卷风资格上报系统，请认真报单，谢谢合作! 组合订单及套餐类，再报单时候写备注就行</p>
			<div style="margin:20px 0;"></div>
		</div>
		<div data-options="region:'center',title:'登录',iconCls:'icon-man'">
			<form id="sign" method="post">
				<div>
					<label for="name">用户名:</label>
					<input class="easyui-validatebox" type="text" name="account" required="true" validType="mobile" data-options="prompt:'请输入用户名'" missingMessage="请输入用户名" ></input>
				</div>
				<div>
					<label for="email">密&nbsp;&nbsp;&nbsp;码:</label>
					<input class="easyui-validatebox" type="password" name="pwd" required="true" missingMessage="请输入密码" ></input>  &nbsp;&nbsp; <a href="jsp/baodan/forget">忘记密码?</a>
				</div>
				<div>
					<input class="submit-btn easyui-linkbutton" data-options="iconCls:'icon-search'" type="submit" value="登录">
				</div>
			</form>
			<div>
				
			</div>
		</div>
	</div>
 <script type="text/javascript">
 
$('#sign').form({
	url:'baodan/api/login/sign',
	
	onSubmit:function(){
		return $(this).form('validate');
	},
	dataType:'json',
	success:function(data){
		console.log(data);
		//var obj = JSON.parse(data);
		var obj = eval('(' + data + ')');
		if(obj.status==200){
			//console.log("登录成功");
			window.location.href="v/baodan/home";
		}else{
			$.messager.alert('登录失败', obj.msg, 'error');
		}
		
	}
});
 </script>
</body>
</html>