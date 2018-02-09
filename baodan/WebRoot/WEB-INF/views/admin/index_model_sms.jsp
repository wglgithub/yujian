<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<div class="page-header">
	<ol class="breadcrumb">
	  <li><a class="modellink" href="#sms">短信管理</a></li>
	  <li class="active">抢购通知</li>
	</ol>
</div>
<div class="panel panel-default">
  <div class="panel-body">
	<div class="jumbotron">
		<div class="container" >
		 	<h1>抢购短信发送!</h1>
	  		<p><a class="btn btn-primary btn-lg" href="javascript:;" role="button" id="sms_sendsms">发送短信</a></p>
		</div>
	</div>
  </div>
</div>
<script type="text/javascript">
$(function(){
	var url = "api/admin/sms/sendtip";
	$("#sms_sendsms").click(function(){
		var _this = $(this),
		busyClass='loading';
		if(_this.hasClass(busyClass)){
			return;
		}
		_this.addClass(busyClass);
		showLoading();
		$.ajax({
			url:url,
			cache:false,
			success:function(rep){
				if(rep.status==200){
					myalert("发送成功");
				}else{
					myalert(rep.msg);
				}
			},
			error:function(){
				myalert("发送失败");
			},
			complete:function(){
				_this.removeClass(busyClass);
				closeLoading();
			}
		});
	});
});
</script>
