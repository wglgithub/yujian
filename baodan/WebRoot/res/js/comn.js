/**
*依赖layer
*/
var LOAD_INDEX,
ALERT_INDEX ;

/**
 * alert提示
 */
function myalert(msg){
	ALERT_INDEX = layer.alert(msg);
}
/**
 * 
 * 显示加载框
 */
function showLoading(){
	LOAD_INDEX = layer.load(1, {
		  shade: [0.1,'#fff'] //0.1透明度的白色背景
		});
}
/**
 * 
 * 关闭加载框
 */
function closeLoading(){
	layer.close(LOAD_INDEX);
}