<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE html>
<html lang="en">
  <head>
  	<base href="<%=basePath %>">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
    <title>热门机型发布系统主页</title>

    <!--[if lte IE 8]><link rel="stylesheet" href="res/js/responsive-nav/responsive-nav.css"><![endif]-->
    <!--[if gt IE 8]><!--><link rel="stylesheet" href="res/js/responsive-nav/advanced-left-navigation.css"><!--<![endif]-->
    
        <!-- Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
	<link href="res/css/buttons.css" rel="stylesheet" >
	<link href="http://cdn.bootcss.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <link href="res/js/bootstrap-table/bootstrap-table.css">
    <link rel="stylesheet" type="text/css" href="res/css/mytable.css" />
    <link rel="stylesheet" type="text/css" href="res/basictable/css/basictable.css" />
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.js"></script>
    <style type="text/css">
		.rignt-switch-div .page-header{margin: 0 0 15px 0;}
		.page-header .breadcrumb{background-color: #fff;margin-bottom: 0;}
		.add-button{ float: right;margin-top: -30px;}
	</style>
  </head>
  <body>

    <div role="navigation" id="foo" class="nav-collapse">
      <ul>
        <li class="active"><a href="#welcome">欢 迎</a></li>
        <li><a href="#model">发布管理</a></li>
        <li><a href="#malls">商城管理</a></li>
        <li><a href="#mobile">机型管理</a></li>
        <li><a href="#sms">短信管理</a></li>
        <li><a href="#mydiv">我的账号</a></li>
      </ul>
      
    </div>

    <div role="main" class="main">
      <a href="#nav" class="nav-toggle">菜单</a>
	    <div id="welcome" class="jumbotron rignt-switch-div">
			 <h1>Hello, 欢迎登录热门机型发布系统!</h1>
			 <p>发布热门抢购机型请点解下面发布链接!!!</p>
			 <p><a class="btn btn-primary btn-lg tofabu" href="#model" role="button">去发布</a></p>
		</div>
		<div class="rignt-switch-div" id="model" style="display: none;">
			<div class="page-header">
	  			<ol class="breadcrumb">
				  <li><a href="#">机型管理</a></li>
				  <li class="active">列表</li>
				</ol>
				<button class="button button-primary button-square button-small add-button" data-toggle="modal" data-target="#fabumodal" whatever="@fat" ><i class="fa fa-plus"></i></button>
			</div>
			
			<table classs="" id="table-malls">
			  <thead>
			    <tr>
			      <th>商城</th>
			      <th>手机型号</th>
			      <th>颜色</th>
			      <th>内存</th>
			      <th>存储</th>
			      <th>抢购地址</th>
			    </tr>
			  </thead>
			  <tbody>
			    <tr>
			      <td>京东商城</td>
			      <td>小米6</td> 
			      <td>低配蓝</td> 
			      <td>4G</td> 
			      <td>64G</td> 
			      <td><a href="http://www.jd.com/" target="_blank" >http://www.jd.com/</a></td>
			    </tr>
			    <tr>
			      <td>京东商城</td>
			      <td>小米6</td> 
			      <td>高配陶瓷黑</td> 
			      <td>6G</td> 
			      <td>256G</td> 
			      <td><a href="http://www.jd.com/" target="_blank" >http://www.jd.com/</a></td>
			    </tr>
			
			  </tbody>
			</table>
			
			<nav aria-label="Page navigation">
			  <ul class="pagination">
			    <li>
			      <a href="#" aria-label="Previous">
			        <span aria-hidden="true">&laquo;</span>
			      </a>
			    </li>
			    <li><a href="#">1</a></li>
			    <li><a href="#">2</a></li>
			    <li><a href="#">3</a></li>
			    <li><a href="#">4</a></li>
			    <li><a href="#">5</a></li>
			    <li>
			      <a href="#" aria-label="Next">
			        <span aria-hidden="true">&raquo;</span>
			      </a>
			    </li>
			  </ul>
			</nav>
			
		</div>
		<div class="rignt-switch-div" id="malls" style="display: none;">
			<div class="page-header">
	  			<ol class="breadcrumb">
				  <li><a href="#malls">商城管理</a></li>
				  <li class="active">列表</li>
				</ol>
				<button class="button button-primary button-square button-small add-button" data-toggle="modal" data-target="#addmall" whatever="@fat" ><i class="fa fa-plus"></i></button>
			</div>
			<table classs="" id="table-malls">
			  <thead>
			    <tr>
			      <th>名称</th>
			      <th>code</th>
			      <th>链接</th>
			    </tr>
			  </thead>
			  <tbody>
			  <!-- 
			    <tr>
			      <td>京东商城</td>
			      <td>jd</td> 
			      <td><a href="http://www.jd.com/" target="_blank" >http://www.jd.com/</a></td>
			    </tr>
			 -->
			  </tbody>
			</table>
		</div> 
		<div class="rignt-switch-div" id="mobile" style="display: none;">
			<div class="page-header">
	  			<ol class="breadcrumb">
				  <li><a class="modellink" href="#mobile">机型管理</a></li>
				  <li class="active">列表</li>
				</ol>
				<button class="button button-primary button-square button-small add-button" data-toggle="modal" data-target="#addmobile" whatever="@fat" ><i class="fa fa-plus"></i></button>
			</div>
			<table classs="" id="table-mobile">
			  <thead>
			    <tr>
			      <th>手机名称</th>
			      <th>操作</th>
			      <th>备注</th>
			    </tr>
			  </thead>
			  <tbody>
			    
			  </tbody>
			</table>
		</div> 
		<div class="rignt-switch-div" id="mobile-set" style="display: none;">
			<div class="page-header">
	  			<ol class="breadcrumb">
				  <li><a class="modellink" href="#mobile">机型管理</a></li>
				  <li><a href="#mobile-set">机型管理</a></li>
				  <li class="active">配置列表</li>
				</ol>
				<button class="button button-primary button-square button-small add-button" data-toggle="modal" data-target="#addmobile" whatever="@fat" ><i class="fa fa-plus"></i></button>
			</div>
			<table classs="" id="table-mobile">
			  <thead>
			    <tr>
			      <th>手机名称</th>
			      <th>操作</th>
			      <th>备注</th>
			    </tr>
			  </thead>
			  <tbody>
			    
			  </tbody>
			</table>
		</div>
		<!-- 短信管理模块 -->
		<div class="rignt-switch-div" id="sms" style="display: none;">
			<jsp:include page="index_model_sms.jsp"></jsp:include>
		</div>  
		<div class="rignt-switch-div" id="mydiv" style="display: none;">
			敬请期待！
		</div>  
    </div>
    
    
	<!-- 发布弹窗 -->
	<div class="modal fade" id="fabumodal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="exampleModalLabel">发布抢购信息</h4>
	      </div>
	      <div class="modal-body">
	        <form class="form-horizontal" role="form" name="from-model">
	         <div class="form-group">
	            <label for="mallCode" class="col-sm-2 control-label">商城:</label>
	            <div class="col-sm-10">
	            <select class="form-control" name="mallCode" >
	            	<option value="jd">京东商城</option>
	            	<option value="tmall">天猫商城</option>
	            	<option value="suning">苏宁易购</option>
	            	<option value="vmall">华为商城</option>
	            	<option value="mi">小米商城</option>
	            </select>
	            </div>
<!-- 	            <input type="text" class="form-control" id="mallCode" name="mallCode" maxlength="25" > -->
	          </div>
	          <div class="form-group">
	            <label for="model" class="col-sm-2 control-label">手机型号:</label>
	            <div class="col-sm-10">
	            <input type="text" class="form-control" id="model" name="model" maxlength="25" >
	          	</div>
	          </div>
	          <div class="form-group">
	            <label for="describe" class="col-sm-2 control-label">内存描述:</label>
	            <div class="col-sm-10">
	            <input type="text" class="form-control" id="describe" name="describe" maxlength="25" >
				</div>	          
	          </div>
	          <div class="form-group">
	            <label for="panicBuyDate" class="col-sm-2 control-label">抢购时间:</label>
	            <div class="col-sm-10">
	            <input type="text" class="form-control" name="panicBuyDate" onclick="laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss'})" readonly>
	          	</div>
	          </div>
	          <div class="form-group">
	            <label for="buyLink" class="col-sm-2 control-label">链接:</label>
	            <div class="col-sm-10">
	            <textarea type="text" class="form-control" id="buyLink" name="buyLink" maxlength="1000" ></textarea>
	          	</div>
	          	
	          </div>
	        </form>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
	        <button type="button" class="btn btn-primary action_fabu">发布</button>
	      </div>
	    </div>
	  </div>
	</div>
	<!-- 发布弹窗 end -->
	
	
	<!-- 新加商城弹窗 -->
	<div class="modal fade" id="addmall" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="exampleModalLabel">添加商城</h4>
	      </div>
	      <div class="modal-body">
	        <form class="form-horizontal" role="form" name="from-mall">
	          <div class="form-group">
	            <label for="model" class="col-sm-2 control-label">名称:</label>
	            <div class="col-sm-10">
	            <input type="text" class="form-control" id="name" name="name" maxlength="25" >
	          	</div>
	          </div>
	          <div class="form-group">
	            <label for="describe" class="col-sm-2 control-label">代码:</label>
	            <div class="col-sm-10">
	            <input type="text" class="form-control" id="code" name="code" maxlength="25" >
				</div>	          
	          </div>
	          <div class="form-group">
	            <label for="buyLink" class="col-sm-2 control-label">链接:</label>
	            <div class="col-sm-10">
	            <textarea type="text" class="form-control" id="link" name="link" maxlength="1000" ></textarea>
	          	</div>
	          	
	          </div>
	        </form>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
	        <button type="button" class="btn btn-primary action_addmall">添加</button>
	      </div>
	    </div>
	  </div>
	</div>
	<!-- 新加商城弹窗 end -->
	
	
	<!-- 新加手机弹窗 -->
	<div class="modal fade" id="addmobile" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="exampleModalLabel">添加机型</h4>
	      </div>
	      <div class="modal-body">
	        <form class="form-horizontal" role="form" name="from-mobile">
	          <div class="form-group">
	            <label for="model" class="col-sm-2 control-label">名称:</label>
	            <div class="col-sm-10">
	            <input type="text" class="form-control" id="name" name="name" maxlength="25" >
	          	</div>
	          </div>
	          <!-- 
	          <div class="form-group">
	            <label for="describe" class="col-sm-2 control-label">所属商城:</label>
	            <div class="col-sm-10">
	            <select class="form-control" name="mallCode" >
	            
	            	<option value="jd">京东商城</option>
	            	<option value="tmall">天猫商城</option>
	            	<option value="suning">苏宁易购</option>
	            	<option value="vmall">华为商城</option>
	            	<option value="mi">小米商城</option> 
	            </select>
	            </div>	          
	          </div>--> 
	        </form>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
	        <button type="button" class="btn btn-primary action_addmobile">添加</button>
	      </div>
	    </div>
	  </div>
	</div>
	<!-- 新加手机弹窗 end -->	
	
	<!-- 
	 -->
    
    <script id="table_mall_item" type="text/html">
	{{# var i=0,it;
		for (i=0;i<d.length;i++){ 
			it = d[i];
	}}
	  <tr>
		<td>{{it.name}}</td>
		<td>{{it.code||''}}</td> 
		<td><a href="{{it.link}}" target="_blank" >{{it.link}}</a></td>
	  </tr>	
	{{# } }}	    	

	</script>
	
	<script id="select_malltmpl" type="text/html">
	{{# var i=0,it;
		for(i=0;i<d.length;i++){
			it=d[i];
	}}
	<option value="{{it.code}}">{{it.name}}</option>
	{{# } }}
	</script>
	<!-- 手机机型列表模版 -->
	<script id="mobile_list_tmpl" type="text/html">
	{{# var i=0,it;
		for(i=0;i<d.content.length;i++){
			it=d.content[i];
	}}
	<tr><td>{{it.name}}</td><td>配置查询</td><td></td></tr>
	{{# } }}
	</script>
    
	    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="res/js/responsive-nav/responsive-nav.js"></script>
    <script src="res/js/bootstrap-table/bootstrap-table.js" ></script>
	<script src="res/js/laydate/laydate.js"></script>
	<script src="res/js/layer/layer.js"></script>
	<script src="res/basictable/js/jquery.basictable.min.js"></script>
	<script src="res/js/laytpl.js"></script>
	<script src="res/js/comn.js"></script>
    <script src="res/js/admin-index.js"></script>
  </body>
</html>