!function($){
    var REG_EMAIL = /^[\w!#$%&'*+/=?^_`{|}~-]+(?:\.[\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\w](?:[\w-]*[\w])?\.)+[\w](?:[\w-]*[\w])?$/,
        REG_PHONE = /^\d{3}-\d{8}|\d{4}-\d{7,8}$/,
        REG_MOBILE= /^(13[0-9]{9}$)|(14[579][0-9]{8}$)|(17[0-9][0-9]{8}$)|(18[0-9]{9}$)|(15[012356789][0-9]{8}$)/,
        REG_BULINO=/^\d{15}$/,
        REG_NUM=/^\d+$/,
        REG_POSTCODE=/^[0-9]\d{5}$/,  
        REG_PASSWORD=/^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,18}$/,
        REG_CARD_ID_18 = /^(\d{6})(\d{4})(\d{2})(\d{2})(\d{3})([0-9]|X)$/,
        REG_CARD_ID_15 = /^(\d{6})(\d{2})(\d{2})(\d{2})(\d{3})/; 	
/** 
 *  将form序列化Json对象 
 * {key1:"value1",key2:"value2"} 
 * @example 
 * <script> 
 * var formParams = $("#formId").serializeObject(); 
 * </script> 
 */  
$.prototype.serializeObject = function() {  
    var a, o, h, i, e;  
    a = this.serializeArray();  
    o = {};  
    h = o.hasOwnProperty;  
    for (i = 0; i < a.length; i++) {  
        e = a[i];  
        if (!h.call(o, e.name)) {  
            o[e.name] = e.value;  
        }  
    }  
    return o;  
};
/**
 * 检查字符串是否为email格式
 */
$.isEmail = function(str){
	return REG_EMAIL.test(str);
};
/**
 * 检查字符串是否为手机号格式
 */
$.isMobile = function(str){
	return REG_MOBILE.test(str);
};
/**
 * 检查字符串是否为固话格式
 */
$.isTelPhone = function(str){
	return REG_PHONE.test(str);
};
/**
 * 检查字符串是否为密码格式（8-18位数字和字母组合）
 */
$.isPassword8To18 = function(str){
	return REG_PASSWORD.test(str);
};

$.alert = function(msg){
	alert(msg);
	
};
}(jQuery);

