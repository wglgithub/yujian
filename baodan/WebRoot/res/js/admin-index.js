 var navigation = responsiveNav("foo", {customToggle: ".nav-toggle"});
 var initHash = window.location.hash;
 $(function(){
	  var switchTo = function(hash){
		  var hashindex= hashstore.indexOf(hash);
    	  if(hashindex<0){
    		  hashindex = 0;
    	  }
    	  $('.nav-collapse ul li').eq(hashindex).addClass('active').siblings().removeClass('active');
  $(hash).show().siblings('.rignt-switch-div').hide();
	  fireEvent(hash.substring(1),$(hash).get(0));
  },hashstore = ['#welcome','#model','#malls','#mobile','#sms','#mydiv']
  ,emtyFn = function(){}
  ,fireEvent = function(type,target){
	  var _fn = listeners[type];
	  if(typeof _fn==='function'){
		  _fn.call(target,{type:type,target:target});
	  }
  },listeners = {
		'welcome':emtyFn,
	'model':emtyFn,
	'malls':emtyFn,
	'mobile':emtyFn,
	'sms':emtyFn,
	'mydiv':emtyFn
  },
  setListener = function(type,fn){
	  if(typeof fn==='function'){
		  listeners[type]=fn;
	  }
  };
  
  //左侧导航点击事件绑定
  $('.nav-collapse ul li a,a.tofabu,a.modellink').click(function(e){
  e.preventDefault();
  var href,hashid;
  href =  this.href ;
  hashid = href.substring(href.indexOf('#'));
  window.location.hash = hashid;
 // console.log(hashid);
	  switchTo(hashid);
	  
  });
  
  $('.bs-example-modal-lg').on('shown.bs.modal', function () {
  console.log("myModal");
	});
  
  $('.action_fabu').click(onPublishClick);
  $('.action_addmall').click(onAddMallClick);
  $('.action_addmobile').click(onAddMobileClick);
  
  $('#table-malls').basictable();
  
  function onPublishClick(e){
	  var $this = $(this);
	  if($this.hasClass('loading')){
		  return ;
	  }
	  $(this).addClass('loading');
	  //获取表单数据
	  var params = $('form[name=from-model]').serialize();
	  showLoading();
	  sendPublishData(params,function(){
		  myalert("发布成功");
		  window.location.reload();
	  },function(error){
		  myalert(error);
		  closeLoading();
		  $this.removeClass('loading')
	  });
	  //sendPublishData();
  }
  
  function sendPublishData(data,success,error){
	  $.ajax({
		  url:'api/admin/mobile/save',
	  method:'post',
		  data:data,
		  cache:false,
		  success:function(rep){
			  if(rep.status==200){
				  success();
			  }else{
				  error(rep.msg);
			  }
		  },
		  error:function(msg){
			  error(msg);
		  }
	  });
  }
  
  function onAddMallClick(e){
	  var $this = $(this);
	  if($this.hasClass('loading')){
		  return ;
	  }
	  $(this).addClass('loading');
	  //获取表单数据
	  var params = $('form[name=from-mall]').serialize();
	  showLoading();
	  sendAddMallData(params,function(){
		  myalert("添加成功");
		  window.location.reload();
	  },function(error){
		  myalert(error);
		  closeLoading();
		  $this.removeClass('loading')
	  });
  }
  //添加手機点击事件
  function onAddMobileClick(e){
	  //分别获取手机名称和商城信息
	  var $this = $(this);
	  if($this.hasClass('loading')){
		  return ;
	  }
	  $this.addClass('loading');
	//获取表单数据
	var data = $('#addmobile form[name=from-mobile]').serialize();
	$.ajax({
		url:'api/admin/mobile/model/add',
		method:'post',
		data:data,
		cache:false,
		success:function(data){
			if(data.status==200){
				  myalert("添加成功");
				  setTimeout('window.location.reload();',2000);
			  }else{
				  myalert(data.msg);
				  $this.removeClass('loading');
			  }
		},error:function(){ myalert("添加失败");}
	});
  }
  
  function sendAddMallData(data,success,error){
	  $.ajax({
		  url:'api/admin/mall/add',
		  method:'post',
		  data:data,
		  cache:false,
		  success:function(rep){
			  if(rep.status==200){
				  success();
			  }else{
				  error(rep.msg);
			  }
		  },
		  error:function(msg){
			  error(msg);
		  }
	  });
  }
  function onMallShow(e){
	  //console.log(e);
  //查询所有的商城信息
	  $.ajax({
		  url:'api/admin/mall/listall',
		  cache:false,
		  success:function(data){
			  if(data.status==200){
				  reviewMallList(data.data);
			  }else{
				  myalert(data.msg); 
			  }
		  },
		  error:function(){
			  myalert("查询失败");
			  }
	  });
  }
  
  function reviewMallList(list){
	  var _tmpl = document.getElementById("table_mall_item").innerHTML;
	  laytpl(_tmpl).render(list,function(_html){
		  $('#table-malls tbody').html(_html);
	  });
	  _tmpl = null;
  }
  //渲染手机列表
  function reviewMobileList(page){
	  var _tmpl = document.getElementById("mobile_list_tmpl").innerHTML;
	  laytpl(_tmpl).render(page,function(_html){
		  $('#table-mobile tbody').html(_html);
	  });
	  _tmpl = null;
  }
  //渲染商城列表
  function reviewMallSelect(list){
	  var _tmpl = document.getElementById("select_malltmpl").innerHTML;
	  laytpl(_tmpl).render(list,function(_html){
		  $('#addmobile select[name=mallCode]').html(_html);
	  });
	  _tmpl = null;
  }
  
  function onModelShow(e){
	  console.log(e);
  }
  function onMobileShow(e){
	  //console.log(e);
	  var $panel = $(e.target);
	  //加载手机列表
	  mobile_model.getList();
  }
  //各个模块显示事件
  setListener('model',onModelShow);
  setListener('malls',onMallShow);
  setListener('mobile',onMobileShow);
  $('#addmall').on('show.bs.modal', function () {
	  // 执行一些动作...
	  console.log("addmall show");
  });
  $('#addmobile').on('show.bs.modal', function () {
	  /*加载商城数据
	  $.ajax({
		  url:'api/admin/mall/listall',
		  cache:false,
		  success:function(data){
			  if(data.status==200){
				  reviewMallSelect(data.data);
			  }else{
				  myalert(data.msg); 
			  }
		  },
		  error:function(){myalert("查询失败");}
	  });*/
	  
  });
  //手机管理模块
  var mobile_model ={
		 targetSelector:'#mobile',
		 size:10,
		 page:1,
		 getList:function(page){
			 if(page>1){this.page=page}
			 this.loadData();
		 },
		 loadData:function(){
			 $.ajax({
				 url:'api/admin/mobile/model/list',
				 cache:false,
				 data:{page:this.page,size:this.size},
				 success:function(d){
					 console.log(d);
					 //渲染视图 mobile_list_tmpl
					 reviewMobileList(d.data);
				 }
			 });
		 }
  };
  
  switchTo(initHash);
 });
  