<%@page import="com.topmobile.util.SessionUserUtil"%>
<%@page import="com.topmobile.bean.SessionUser"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String role = request.getParameter("role");
SessionUser user = SessionUserUtil.getUserAttr(session);
%>
<header class="header">
	<div class="inner">
		<div class="logo">
			<h1>
				<a><img src=""></a>
			</h1>
			
		</div>
		<div class="navigation">
			<ul>
				<li class="account-wrap">
					<a><%=user.getName() %></a>
					<ol class="account-panel" style="display: none;">
						<li><a href="#" class="account-logout" target="_self">退出</a></li>
					</ol>
				</li>
			</ul>
		</div>
	</div>

</header>