<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<div id="p" class="easyui-panel" title="机型管理" style="width:100%;height:100%;">
<div>
<!-- 	<div id="tb" style="padding:5px;background:#fafafa;width:500px;border:1px solid #ccc"> -->
<!-- 	<a id="addmallbtn" href="javascript:;" class="easyui-linkbutton" iconCls="icon-add">添加</a> -->
<!-- 	</div> -->
	<div id="addmalldlg"  title="添加机型" data-options="iconCls:'icon-add'" style="width:480px;height:320px;padding:10px;display:none;">
		<form id="ff" action="baodan/admin/api/model/add" method="post">
		<table>
			<tr>
				<td style="width: 30px;" >名称:</td>
				<td><input class="easyui-textbox easyui-validatebox" required="true" data-options="prompt:'请输入名称'" missingMessage="名称不能空" style="width:150px;height:26px" name="name"></td>
			</tr>
			<tr>
				<td>内存:</td>
				<td><input class="easyui-textbox" required="true" validType="number" data-options="prompt:'内存大小,例如6g填6'" missingMessage="内存不能空" style="width:150px;height:26px" name="ram" type="number" min="1" max="10"></input></td>
			</tr>
			<tr>
				<td>存储:</td>
				<td><input class="easyui-textbox" required="true" validType="number" data-options="prompt:'存储大小,例如32g填32'" missingMessage="存储不能空" style="width:150px;height:26px" name="rom" type="number" min="8" max="256" ></input></td>
			</tr>
			<tr>
				<td>颜色:</td>
				<td><input class="easyui-textbox easyui-validatebox" required="true" data-options="prompt:'请输入颜色'" missingMessage="颜色不能空" style="width:150px;height:26px" name="color" type="text"></input></td>
			</tr>
			<tr>
				<td>官价:</td>
				<td><input class="easyui-textbox" required="true" validType="number" data-options="prompt:'填写官方价格'" missingMessage="存储不能空" style="width:150px;height:26px" name="price" type="number" min="0" ></input></td>
			</tr>
			<tr>
				<td>商城:</td>
				<td>
<!-- 					<input id="cc" class="easyui-combobox" name="malls" style="width:250px;height:52px" -->
<!--     data-options="valueField:'id',textField:'name',url:'<%=basePath %>baodan/comn/api/malls/get',method:'get',multiple:true"> -->
    			
    			<div class="myEval-impress">
    				<ol class="clearfix" id="tags">
    					  
    					<li class="selected" onclick="">
    						<div class="impress">
    							<input type="checkbox" checked="true" name="diyTags" style="visibility: hidden; position: absolute;" value="发货慢" id="diyTags">
    							<a href="javascript:;">发货慢</a>
    							<s></s>
    						</div>
    					</li>
    					<li class="" onclick="">
    						<div class="impress">
    							<input type="checkbox" checked="true" name="diyTags" style="visibility: hidden; position: absolute;" value="服务不好" id="diyTags">
    								<a href="javascript:;">服务不好</a>
    								<s></s>
    						</div>
    					</li>
    					
    				</ol>
    			</div>
    				
				</td>
			</tr>
			<tr>
				<td></td>
				<td><a href="javascript:onFormSubmit(this);" class="easyui-linkbutton" data-options="iconCls:'icon-add'" style="margin-left: 120px;margin-right: 120px;">添加</a></td>
			</tr>
		</table>
	</form>
	</div>
	<div id="editmalldlg"  title="编辑机型" data-options="iconCls:'icon-add'" style="width:480px;height:320px;padding:10px;display:none;">
		<form id="ff_edit" action="baodan/admin/api/model/update" method="post">
			<input name="model" type="hidden">
		<table>
			<tr>
				<td style="width: 30px;" >名称:</td>
				<td><input id="name" class="easyui-textbox easyui-validatebox" required="true" data-options="prompt:'请输入名称'" missingMessage="名称不能空" style="width:150px;height:26px" name="name" disabled="disabled" ></td>
			</tr>
			<tr>
				<td>内存:</td>
				<td><input id="ram" class="easyui-textbox" required="true" validType="number" data-options="prompt:'内存大小,例如6g填6'" missingMessage="内存不能空" style="width:150px;height:26px" name="ram" type="number" min="1" max="10" disabled="disabled"></input></td>
			</tr>
			<tr>
				<td>存储:</td>
				<td><input id="rom" class="easyui-textbox" required="true" validType="number" data-options="prompt:'存储大小,例如32g填32'" missingMessage="存储不能空" style="width:150px;height:26px" name="rom" type="number" min="8" max="256" disabled="disabled" ></input></td>
			</tr>
			<tr>
				<td>颜色:</td>
				<td><input id="color" class="easyui-textbox easyui-validatebox" required="true" data-options="prompt:'请输入颜色'" missingMessage="颜色不能空" style="width:150px;height:26px" name="color" type="text" disabled="disabled"></input></td>
			</tr>
			<tr>
				<td>官价:</td>
				<td><input id="price" class="easyui-textbox" required="true" validType="number" data-options="prompt:'填写官方价格'" missingMessage="存储不能空" style="width:150px;height:26px" name="price" type="number" min="0" disabled="disabled" ></input></td>
			</tr>
			<tr>
				<td>商城:</td>
				<td>
<!-- 					<input id="cc" class="easyui-combobox" name="malls" style="width:250px;height:52px" -->
<!--     data-options="valueField:'id',textField:'name',url:'<%=basePath %>baodan/comn/api/malls/get',method:'get',multiple:true"> -->
    			
    			<div class="myEval-impress">
    				<ol class="clearfix" id="tags">
    					  
    					<li class="selected" onclick="">
    						<div class="impress">
    							<input type="checkbox" checked="true" name="diyTags" style="visibility: hidden; position: absolute;" value="发货慢" id="diyTags">
    							<a href="javascript:;">发货慢</a>
    							<s></s>
    						</div>
    					</li>
    					<li class="" onclick="">
    						<div class="impress">
    							<input type="checkbox" checked="true" name="diyTags" style="visibility: hidden; position: absolute;" value="服务不好" id="diyTags">
    								<a href="javascript:;">服务不好</a>
    								<s></s>
    						</div>
    					</li>
    					
    				</ol>
    			</div>
    				
				</td>
			</tr>
			<tr>
				<td></td>
				<td><a href="javascript:onEditFormSubmit(this);" class="easyui-linkbutton" data-options="iconCls:'icon-add'" style="margin-left: 120px;margin-right: 120px;">修改</a></td>
			</tr>
		</table>
	</form>
	</div>
</div>
<table id="table-list" >
	<thead>
		<tr>
			<th data-options="field:'name',align:'center'" width="30">机型名称</th>
			<th data-options="field:'ram',align:'center'" width="5">内存(g)</th>
			<th data-options="field:'rom',align:'center'" width="5">存储(g)</th>
			<th data-options="field:'color',align:'center'" width="5">颜色</th>
			<th data-options="field:'price',align:'center'" width="10">官方价格</th>
			<th data-options="field:'dateStr',align:'center'" width="30">更新时间</th>
			<th data-options="field:'malls',align:'center'" width="50">上架商城</th>
		</tr>
	</thead>
</table>
<div id="mm" class="easyui-menu" data-options="onClick:menuHandler" style="width:120px;">
	<div data-options="name:'new',iconCls:'icon-add'">添加</div>
	<div class="required-select" disabled="true" data-options="name:'edit',iconCls:'icon-edit'">编辑</div>
	<div class="menu-sep required-select"></div>
	<div class="required-select" disabled="true" data-options="name:'del',iconCls:'icon-remove'">删除</div>
</div>
<div id="mm-selected" class="easyui-menu" data-options="onClick:menuHandler" style="width:120px;">
	<div data-options="name:'new',iconCls:'icon-add'">添加</div>
	<div class="required-select" data-options="name:'edit',iconCls:'icon-edit'">编辑</div>
	<div class="menu-sep required-select"></div>
	<div class="required-select" data-options="name:'del',iconCls:'icon-remove'">删除</div>
</div>
<form id="del-form"></form>
<script type="text/javascript">
function onFormSubmit(){
	$('#ff').trigger('submit'); 
}
function onEditFormSubmit(){
	$('#ff_edit').trigger('submit'); 
}
function showAddDialog(){
	$('#addmalldlg').dialog({
		iconCls:'icon-add'
	});
}
function showEditDialog(data){
	$('#editmalldlg').dialog({
		iconCls:'icon-edit',
		onBeforeOpen:function(){
			$('#ff_edit input[name=model]').val(data.model.id);
			$('#ff_edit input#name').textbox('setValue',data.model.name);
			$('#ff_edit input#ram').textbox('setValue',data.model.ram);
			$('#ff_edit input#rom').textbox('setValue',data.model.rom);
			$('#ff_edit input#color').textbox('setValue',data.model.color);
			$('#ff_edit input#price').textbox('setValue',data.model.price);
			var inviewTags = function(data){
				var _html='',tag_sel='#ff_edit #tags',m;
				for(var i=0,len=data.length;i<len;i++){
					m = data[i];
					if(m.selected){
						_html +='<li class="selected" data-id="'+m.c_id+'">'
							  +'	<input name="malls" value="'+m.c_id+'" style="visibility: hidden; position: absolute;"  >';
					}else{
						_html +='<li data-id="'+m.c_id+'">' ;
					}
					
					_html += 	'<div class="impress"><a href="javascript:;">'+m.name+'</a><s></s></div>'		
						  + '</li>';
				}
				$(tag_sel).html(_html);
				//商城选择事件
				$("#ff_edit .myEval-impress ol li").click(function(){
					var $li = $(this);
					if($li.hasClass('selected')){
						$li.removeClass('selected');
						$li.find('input[name=malls]').remove();
					}else{
						$li.addClass('selected');
						$li.append('<input name="malls" value="'+$li.data().id+'" style="visibility: hidden; position: absolute;"  >');
					}
				});
			};
			inviewTags(data.malls);
			return true;
		}
	});
	
}
function closeAddDialog(){
	$('#addmalldlg').dialog('close');
}
function closeEditDialog(){
	$('#editmalldlg').dialog('close');;
}
$(function(){
// 	$('#addmallbtn').click(function(){
// 		$('#addmalldlg').dialog({
// 			iconCls:'icon-add'
// 		});
// 	});

	$('#table-list').datagrid({
		url:'<%=basePath %>baodan/admin/api/model/list',
		method:'get',border:false,singleSelect:true,fit:true,fitColumns:true,
		pageNumber:1,
		pageSize:10,
		pagination:true,
		toolbar: [{
			iconCls: 'icon-add',
			handler: function(){showAddDialog();}
		},'-',{
			iconCls: 'icon-help',
			handler: function(){alert('点击左侧加号按钮添加商城')}
		}]
	});
	
	function reloadmalls(){
		$('#table-list').datagrid('reload');
	} 
	$('#ff').form({
		success:function(data){
			var rep = eval('('+data+')');
			if(rep.status==200){
				closeAddDialog();
				reloadmalls();
			}else{
				$.messager.alert('error', rep.msg, 'error');
			}
			
		}
	});
	$('#ff_edit').form({
		success:function(data){
			var rep = eval('('+data+')');
			if(rep.status==200){
				closeEditDialog();
				reloadmalls();
			}else{
				$.messager.alert('error', rep.msg, 'error');
			}
			
		}
	});
	
	
	
	//商城选项标签生成
	(function(){
		var url  = '<%=basePath %>baodan/comn/api/malls/get',
		inviewTags = function(data){
			var _html='',tag_sel='#tags',m;
			for(var i=0,len=data.length;i<len;i++){
				m = data[i];
				_html +='<li data-id="'+m.id+'">'
					  + 	'<div class="impress"><a href="javascript:;">'+m.name+'</a><s></s></div>'		
					  + '</li>';
			}
			$(tag_sel).html(_html);
			//商城选择事件
			$(".myEval-impress ol li").click(function(){
				var $li = $(this);
				if($li.hasClass('selected')){
					$li.removeClass('selected');
					$li.find('input[name=malls]').remove();
				}else{
					$li.addClass('selected');
					$li.append('<input name="malls" value="'+$li.data().id+'" style="visibility: hidden; position: absolute;" value="发货慢" >')
				}
			});
		};
		$.ajax({
			url:url,
 			success:function(d){
				inviewTags(d);
			}
		});
		
		
	})();
	
	//右键菜单
	$("#p").bind('contextmenu',function(e){
		e.preventDefault();
		if(!getSelected()){
			$('#mm').menu('show', {left: e.pageX,top: e.pageY});
		}else{
			$('#mm-selected').menu('show', {left: e.pageX,top: e.pageY});
		}
		
	});
	
	
});
//获取选择的第一行数据，如果没有选中的则返回null
function getSelected(){
	return $("#table-list").datagrid('getSelected');
}

function reload(){
	return $("#table-list").datagrid('reload');
}
//右键菜单点击
function menuHandler(item){
	if(item.name=='new'){
		showAddDialog();
	}else if(item.name=='edit'){
		var itemid = getSelected().id;
		openEditDialog(itemid);
	}else if(item.name=='del'){
		var itemid = getSelected().id;
		sendDeleteAction(itemid);
	}
}
//执行删除操作
function sendDeleteAction(itemid){
	console.log(itemid);
	$.ajax({
		url:'<%=basePath %>baodan/admin/api/model/rm?id='+itemid,
		method:'get',
		success:function(data){
			if(data.status=='200'){
				reload();
			}else{
				alert("删除失败，请稍后重试");
				console.log(data);
			}
		}
	});
}

function openEditDialog(itemid){
	$.ajax({
		url:'<%=basePath %>baodan/admin/api/model/edit_info?id='+itemid,
		method:'get',
		cache:false,
		success:function(data){
			if(data.status=='200'){
				showEditDialog(data.data);
			}else{
				alert("操作失败，请稍后重试");
				console.log(data);
			}
		}
	});
	
}
</script>
</div>