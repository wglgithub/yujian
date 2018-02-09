<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
  	<base href="<%=basePath%>">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>热门抢购管理系统登录</title>

    <!-- Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
	<link href="res/css/buttons.css" rel="stylesheet">
	<link href="res/css/admin_login.css" rel="stylesheet">
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    
  </head>
  <body>
    
   <div class="login_skin_container">
   </div>
	<div class="panel panel-default login_panel s-opacity-90">
		<div class="panel-heading">登录系统</div>
	  <div class="panel-body ">
	    <div class="input-group">
		  <span class="input-group-addon" id="basic-addon1"><span class="glyphicon glyphicon-user" aria-hidden="true"></span></span>
		  <input type="text" class="form-control" name="user" placeholder="输入账号" aria-describedby="basic-addon1">
		</div>
		<br>
		<div class="input-group">
		  <span class="input-group-addon" id="basic-addon1"><span class="glyphicon glyphicon-lock" aria-hidden="true"></span></span>
		  <input type="password" class="form-control" name="pwd" placeholder="输入密码" aria-describedby="basic-addon1">
		</div>
		<br>
		<div class="btn-group" role="group" aria-label="...">
		  <a href="javascript:;" class="button button-block button-rounded button-primary button-small" id="sign">登录</a>
		</div>
	  </div>
	</div>
   
	

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.js"></script>
    <script type="text/javascript">
    
    $(function(){
    	
    	var addEvent,
    	submitForm,onBtnClick,
    	$btn ,
    	checkForm,loadClass='loading';
    	$btn = $('#sign');
    	addEvent = function(){
    		$btn.click('click',onBtnClick);
    	};
    	onBtnClick = function(e){
    		var $this = $(this),d;
    		console.log(this);
    		if($this.hasClass(loadClass)){
    			return false;
    		}
    		$this.addClass(loadClass);
    		d = checkForm();
    		if(d.error==0){
    			submitForm(d.data,function(rep){
    				window.location.href="jsp/admin/index";
    			},function(error){
    				alert(error);
    				$this.removeClass(loadClass);
    			});
    		}else{
    			alert(d.msg);
    			$this.removeClass(loadClass);
    		}
    		
    	};
    	
    	checkForm = function(){
    		var _d ={error:0,msg:''},
    		user = $.trim($('input[name=user]').val()),
    		pwd = $.trim($('input[name=pwd]').val());
    		if(!user){
    			_d = {error:1,msg:'账号不能为空'};
    		}else if(!pwd){
    			_d = {error:1,msg:'密码不能为空'};
    		}
    		_d.data = {account:user,pwd:pwd};
    		return _d;
    	};
    	
    	submitForm = function(param,success,error){
    		$.ajax({
    			url:'api/admin/sign/login',
    			method:'get',
    			data:param,
    			cache:false,
    			success:function(rep){
    				if(rep.status==200){
    					success();
    				}else{
    					error(rep.msg);
    				}
    			},
    			error:function(){
    				error('登录失败');
    			}
    		});
    	};
    	
    	addEvent();
    });
    </script>
  </body>
</html>
