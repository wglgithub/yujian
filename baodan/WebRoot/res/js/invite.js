
!function(){

var inputValid = function(input){
	var name = $(input).attr('data-validtype'),
	fn = validater[name];
	if(fn){
		if(fn.call(input)){
			$(input).addClass('valid').removeClass('invalid');
		}else{
			$(input).addClass('invalid').removeClass('valid');
		}
	}
	
},
validater = {
	username:function(){
		if($.trim($(this).val())){
			return true;
		}
		return false;
	},
	mobile:function(){
		console.log('mobile');
		return $.isMobile( $.trim($(this).val()) );
	},
	password:function(){
		return $.isPassword8To18($.trim($(this).val()));
	}
};
	
	
$('.input-field').on('click','label',function(){
	if(!$(this).hasClass('active')){
		$(this).siblings('input').trigger('focus');
	}
	
});	
$('.input-field input').focus(function(){
	$(this).siblings().addClass('active');
});
$('.input-field input').blur(function(){
	if( !$.trim( $(this).val() ) ){
		$(this).siblings().removeClass('active');
	}
	inputValid(this);
});
	
$('.regist-btn').click(function(){
	$('.login-form .input-field input').each(function(){
		inputValid(this);
	});
	if($('.login-form .invalid').length){
		return;
	}
	var data= $('.login-form').serializeObject();
	//console.log(data);
	$.ajax({
		url:window.REG_URL,
		data:data,
		method:'post',
		success:function(rep){
			if(rep.status==200){
				//myalert("注册成功\n现在可以使用注册的手机号登录");
				window.location.href="v/invite_success";
			}else{
				myalert(rep.msg);
			}
			
		}
	});
});

$(document).ajaxStart(function(){
	window.loading_index = layer.load(1, {
	  shade: [0.1,'#fff'] //0.1透明度的白色背景
	});
});
$(document).ajaxComplete(function(){
	layer.close(window.loading_index);
});

function myalert(msg){
	layer.alert(msg);
}

}();