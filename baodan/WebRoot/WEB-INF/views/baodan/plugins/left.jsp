<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String role = (String)request.getParameter("role");
String curModel = (String)request.getParameter("menu");
System.out.println(curModel);
request.setAttribute("role", role);
%>
<div class="nav">
<ul>
    <li id="上报资格" class="nav-item">
        <a href="<%=basePath %>v/baodan/sub"><span>上报资格</span></a>
    </li>
    <li id="资格查询"  class="nav-item">
        <a href="<%=basePath %>v/baodan/query"><span>资格查询</span></a>
    </li>
    <li id="数据统计"  class="nav-item">
        <a href="<%=basePath %>v/baodan/worker/count"><span>数据统计</span></a>
    </li>
    <li id="排行榜"  class="nav-item">
        <a href="<%=basePath %>v/baodan/thelists"><span>排 行 榜</span></a>
    </li>
    
    <c:if test="${role eq 'admin' }">
    <li id="商城管理"  class="nav-item">
        <a href="<%=basePath %>v/baodan/admin/malls"><span>商城管理</span></a>
    </li>
    <li id="机型管理"  class="nav-item">
        <a href="<%=basePath %>v/baodan/admin/models"><span>机型管理</span></a>
    </li>
    </c:if>
    <li id="我的信息"  class="nav-item">
        <a href="<%=basePath %>v/baodan/info"><span>我的信息</span></a>
    </li>
    <li id="修改密码"  class="nav-item">
        <a href="<%=basePath %>v/baodan/info"><span>修改密码</span></a>
    </li>
</ul>
</div>
<!-- 
<ul id="left-tree">
	<li>
		<span>资格上报</span>
		<ul>
			<li class="li-link" data-link="<%=basePath %>v/baodan/sub" >
				<span id="sahngbao">上报资格</span>
			</li>
			<li class="li-link" data-link="<%=basePath %>v/baodan/worker/query">
				<span>资格查询</span>
			</li>
		</ul>
	</li>
	<li class="li-link" data-link="<%=basePath %>v/baodan/worker/count">
		<span>数据统计</span>
	</li>
	
	<li class="li-link" data-link="<%=basePath %>v/baodan/thelists">
		<span>排 行 榜</span>
	</li>
	<c:if test="${role eq 'admin' }">
			<li>
				<span>设置管理</span>
				<ul>
					
					<li class="li-link" data-link="<%=basePath %>v/baodan/admin/malls">
						<span>商城管理</span>
					</li>
					<li class="li-link" data-link="<%=basePath %>v/baodan/admin/models">
						<span>机型管理</span>
					</li>
				</ul>
			</li>
	</c:if>
	<li class="li-link" data-link="<%=basePath %>v/baodan/info">
		<span>我的信息</span>
	</li>
	<li class="li-link" data-link="<%=basePath %>v/baodan/pwdedit">
		<span>修改密码</span>
	</li>
</ul>
 -->
<script>
!function(){
	$("#${param.menu}").addClass('nav-show');
}();
/*
!function(){
	var data = [],
	getLink = function(key){
		for(var i=0,len=data.length;i<len;i++){
			if(data[i].key===key){
				return data[i].val;
			}
		}
		return null;
	};
	$('.li-link').each(function(i,el){
		//console.log($(this).find('span').text(),$(this).data());
		data.push({
			key:$(this).find('span').text(),
			val:$(this).data().link
		});
	});
	
	var menus = $('#left-tree').tree({
		onClick:function(node){
			console.log(node);
			console.log(getLink(node.text));
			var actionlink = getLink(node.text);
			if(!!actionlink){
				window.location.href=actionlink;
			}
		}
	});	
}();
*/

</script>