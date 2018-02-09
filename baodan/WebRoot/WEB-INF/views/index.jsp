<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>手机抢购导航</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="热门抢购机型，小米，华为，苹果，小米6，苹果7，荣耀9，小米max2">
	<meta http-equiv="description" content="This is my page">
	<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
	<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	<script src="http://code.jquery.com/jquery-2.1.1.min.js" type="text/javascript"></script>
	<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
	<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
   </head>
  
  <body>
  	<!-- 头部导航 start -->
    <div>
	    <nav class="navbar navbar-default">
		  <div class="container-fluid">
		    <div class="navbar-header">
		      <a class="navbar-brand" href="#">
		        <img alt="Brand" src="...">
		      </a>
		    </div>
		  </div>
		</nav>
    </div>
    <!-- 头部导航 end-->
    <!-- 日期标签导航 start-->
    <div>
    	<ul id="mydatetabs" class="nav nav-tabs">
    	  <li role="presentation" class="first" ><a href="jsp/index#date=20170709">上周</a></li>
		  <li role="presentation" ><a href="jsp/index#date=20170716">7.16 周日</a></li>
		  <li role="presentation"><a href="jsp/index#date=20170717">7.17 周一</a></li>
		  <li role="presentation"><a href="jsp/index#date=20170718">7.18 周二</a></li>
		  <li role="presentation" class="active"><a href="jsp/index#date=20170719">7.19 周三</a></li>
		  <li role="presentation"><a href="jsp/index#date=20170720">7.20 周四</a></li>
		  <li role="presentation"><a href="jsp/index#date=20170721">7.21 周五</a></li>
		  <li role="presentation"><a href="jsp/index#date=20170722">7.22 周六</a></li>
		  <li role="presentation" class="last" ><a href="jsp/index#date=20170723">下周</a></li>
		</ul>
    </div>
    <!-- 日期标签导航 end -->
    
    
    <script type="text/javascript">
    //日期标签点击事件
    $('#mydatetabs a').click(function (e) {
   	  //e.preventDefault();
   	  if($(this).parent().hasClass('first')){
   		  console.log("点击上周");
   	  }else if($(this).parent().hasClass('last')){
   		console.log("点击下周");
   	  }else{
   		$(this).parent().addClass('active').siblings().removeClass('active');
   	  }
   	  
   	});
    
    
    </script>
  </body>
</html>
