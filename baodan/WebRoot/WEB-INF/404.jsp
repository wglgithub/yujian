<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>页面不存在-404</title>
    
	<meta http-equiv="keywords" content="404">
	<meta http-equiv="description" content="页面找不到了">

  </head>
  
  <body>
    页面找不到了
  </body>
</html>
