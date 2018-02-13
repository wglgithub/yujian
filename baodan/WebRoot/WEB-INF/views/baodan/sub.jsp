<%@page import="com.topmobile.bean.SessionUser"%>
<%@page import="com.topmobile.util.SessionUserUtil"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

SessionUser currentUser = SessionUserUtil.getUserAttr(session);

%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<base href="<%=basePath %>">
	<title>龙卷风-上报资格</title>
	<jsp:include page="plugins/easyui-com-res.jsp"></jsp:include>
	<script type="text/javascript" src="res/js/util.js"></script>
</head>
<body class="easyui-layout" >
	<div data-options="region:'north'" style="height:50px">
		<jsp:include page="plugins/head.jsp">
			<jsp:param value="<%=currentUser.getRole() %>" name="role"/>
		</jsp:include>
	</div>
<!-- 	<div data-options="region:'south',split:true" style="height:50px;"></div> -->
<!-- 	<div data-options="region:'east',split:true" title="East" style="width:100px;"></div> -->
	<div data-options="region:'west',split:false" title="导航菜单" style="width:120px;">
		<jsp:include page="plugins/left.jsp">
			<jsp:param value="<%=currentUser.getRole() %>" name="role"/>
			<jsp:param value="上报资格" name="menu"/>
		</jsp:include>
	</div>
	<div data-options="region:'center'">
		<jsp:include page="plugins/center-zige-sub.jsp">
			<jsp:param value="<%=currentUser.getRole() %>" name="role"/>
			<jsp:param value="<%=currentUser.getName() %>" name="name"/>
		</jsp:include>
	</div>
</body>
</html>