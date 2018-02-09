!function(win){
	//解析search 
	var queryString =function (name, notDecoded) {
        name = name.replace(/[\[]/, "\\\[").replace(/[\]]/, "\\\]");
        var regex = new RegExp("[\\?&]" + name + "=([^&#]*)")
          , results = regex.exec(location.search)
          , encoded = null
          ;
        if (results === null) {
            regex = new RegExp("[\\?&]" + name + "(\\&([^&#]*)|$)");
            if (regex.test(location.search)) {
                return true;
            }
            return undefined;
        } else {
            encoded = results[1].replace(/\+/g, " ");
            if (notDecoded) {
                return encoded;
            }
            return decodeURIComponent(encoded);
        }
    };
    var REG_EMAIL = /^[\w!#$%&'*+/=?^_`{|}~-]+(?:\.[\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\w](?:[\w-]*[\w])?\.)+[\w](?:[\w-]*[\w])?$/,
        REG_PHONE = /^\d{3}-\d{8}|\d{4}-\d{7,8}$/,
        REG_MOBILE= /^(13[0-9]{9}$)|(14[579][0-9]{8}$)|(17[0-9][0-9]{8}$)|(18[0-9]{9}$)|(15[012356789][0-9]{8}$)/,
        REG_BULINO=/^\d{15}$/,
        REG_NUM=/^\d+$/,
        REG_POSTCODE=/^[0-9]\d{5}$/,  
        REG_PASSWORD=/^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,18}$/,
        REG_CARD_ID_18 = /^(\d{6})(\d{4})(\d{2})(\d{2})(\d{3})([0-9]|X)$/,
        REG_CARD_ID_15 = /^(\d{6})(\d{2})(\d{2})(\d{2})(\d{3})/;         
    var isEmail = function(str){
    	return REG_EMAIL.test(str);
    },
    isPhone = function(num){
    	return REG_PHONE.test(num);
    },
    isMobile = function(num){
    	return REG_MOBILE.test(num);
    },
    isBulino=function(num){
    	return REG_BULINO.test(num);
    },
    isPostcode=function(num){
    	return REG_POSTCODE.test(num);

    },
    isCardId = function(num){
    	if(num.length==15){
    		return REG_CARD_ID_15.test(num)
    	}
    	return REG_CARD_ID_18.test(num);
    },
    isFax =function(num){
    	return REG_PHONE.test(num);
    },
    isNum=function(num){
    	return REG_NUM.test(num);
    },
    getHost = function(){
    	if(!win.location.origin){
    		//win.location.origin = win.location.protocol +'//'+ win.location.host + win.location.port ;
    		win.location.origin = win.location.protocol +'//'+ win.location.host;
    	}
    	return win.location.origin ;
    },
    getServerBaseUrl = function(){
//    	return getHost()+"/entService";
    	return getHost();
    }, 
   cacheUtil ={
    		storage:sessionStorage,
    		getItem:function(key){
    			return this.storage.getItem(key);
    		},
    		setItem:function(key,val){
    			this.storage.setItem(key,val)
    		},
    		removeItem:function(key){
    			this.storage.removeItem(key);
    		},
    		toJsonString:function(obj){
    			return JSON.stringify(obj);
    		},
    		parseJSON:function(json){
    			return JSON.parse(json);
    		}	
    };	
    
	return win.util = {
			queryString:queryString,
			isEmail : isEmail,
			isPhone: isPhone,
			isMobile:isMobile,
			isBulino:isBulino,
			isPostcode:isPostcode,	
			isCardId:isCardId,
			isFax:isFax,
			isNum:isNum,
			getServerBaseUrl:getServerBaseUrl,
			toLoginPage:function(cur_url){
				if(window.jsBridge){
					var url = cur_url;
					jsBridge.redirectURL("[ReloginAndRequest]",'{"requestURL":"'+url+'"}',"");
				}else{
					window.location.href=getServerBaseUrl()+'/html/web/lr/login.html?tourl='+encodeURIComponent(cur_url) ;
				}
				
			},
			cacheUtil:cacheUtil,
			browser:{
				isIE:function(){
					if(!!window.ActiveXObject || "ActiveXObject" in window){
				        return true;
				    }else{
				        return false;
				    }

				},
				IEVersion:function(){
				  var rv = -1;
				  if (navigator.appName == 'Microsoft Internet Explorer'){
				    var ua = navigator.userAgent;
				    var re  = new RegExp("MSIE ([0-9]{1,}[\.0-9]{0,})");
				    if (re.exec(ua) != null)
				      rv = parseFloat( RegExp.$1 );
				  }else if (navigator.appName == 'Netscape'){
				    var ua = navigator.userAgent;
				    var re  = new RegExp("Trident/.*rv:([0-9]{1,}[\.0-9]{0,})");
				    if (re.exec(ua) != null)
				      rv = parseFloat( RegExp.$1 );
				  }
				  return rv;
				}

			}
	};
	
}(window);
//兼容String不支持trim
if(!String.prototype.trim){
	String.prototype.trim = function(){
		var rtrim = /^[\s\uFEFF\xA0]+|[\s\uFEFF\xA0]+$/g;
		return ( this + "" ).replace( rtrim, "" );
	}
}