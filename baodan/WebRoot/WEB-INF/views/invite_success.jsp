<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!doctype html>
<html lang="zh">
<head>
	<base href="<%=basePath %>" >
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>用户邀请注册</title>
	<link rel="stylesheet" type="text/css" href="res/reg/css/default.css">
	<link rel="stylesheet" type="text/css" href="res/reg/css/materialize.min.css" />
	
	<!-- <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.1/css/materialize.min.css">
	 --><style type="text/css">
	html,
	body {
	    height: 100%;
	}
	html {
	    display: table;
	    margin: auto;
	}
	body {
	    display: table-cell;
	    vertical-align: middle;
	}
	.margin {
	  margin: 0 !important;
	}
	</style>
	<!--[if IE]>
		<script src="http://libs.useso.com/js/html5shiv/3.7/html5shiv.min.js"></script>
	<![endif]-->
</head>
<body class="blue">
	<div id="login-page" class="row">
	    <div class="col s12 z-depth-6 card-panel">
	      <form class="login-form">
	        <div class="row">
	          <div class="input-field col s12 center">
	            <img src="http://w3lessons.info/logo.png" alt="" class="responsive-img valign profile-image-login">
	            <p class="center login-form-text" style="min-width: 300px;">龙卷风用户注册成功,使用注册时的手机号登录!</p>
	          </div>
	        </div>
	       
	        <div class="row">
	          <div class="input-field col s12">
	            <a href="v/baodan/sign" class="btn waves-effect waves-light col s12 regist-btn">立刻登录</a>
	          </div>
	        </div>
	      </form>
	    </div>
	  </div>
		<script type="text/javascript" >
	window.REG_URL = 'api/comn/reg/invite/${param.inviter}';
	</script>
	<script type="text/javascript" src="https://cdn.bootcss.com/jquery/2.2.1/jquery.min.js"></script>
	<script>window.jQuery || document.write('<script src="js/jquery-2.2.1.min.js"><\/script>')</script>
  	<!--materialize js-->
<!--   	<script src="res/reg/js/materialize.min.js"></script> -->
	<script type="text/javascript" src="res/js/jquery-tools-extends.js"></script>
	<script type="text/javascript" src="res/js/invite.js" ></script>
	<script type="text/javascript" src="res/js/layer/layer.js"></script>
</body>
</html>