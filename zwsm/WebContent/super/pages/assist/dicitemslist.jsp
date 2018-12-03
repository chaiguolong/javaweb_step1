<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8" /> 
    <title>字典列表</title>
    <meta http-equiv="pragma" content="no-cache"> 
	<meta http-equiv="Cache-Control" content="no-cache, must-revalidate">
    <link rel="stylesheet" type="text/css" href="/super/css/style.css" />
    <link rel="stylesheet" type="text/css" href="/super/css/images/simple/getcss.css" />
    <link rel="stylesheet" type="text/css" href="/super/common/flexigrid/css/flexigrid.css" />
    <style type="text/css"> 
    	html{ overflow-y: auto; }
		.tbody {overflow-x:hidden;}
	</style>
  	<script type="text/javascript" src="/super/common/datePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="/super/js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="/super/common/flexigrid/flexigrid.js"></script>
	<script type="text/javascript">
	$(document).ready(function(){
		loadFlexigrid();
	});
	
	//加载字典列表
    function loadFlexigrid(){
    	$("#grid").flexigrid({
        	url : '/esf/DicAction_checkInfo.jspx',
        	params:[				   
    				{ name : 'codeid', value : $('#codeid').val() }
    			],
        	dataType : 'json',
           	colModel : [
			    {display : '字典类型编码', name : 'codetype', width : 240, sortable : false, align : 'center', talign : 'left'},	
			    {display : '名称', name : 'codename', width : 240, sortable : false, align : 'center', talign : 'left' },
			    {display : '值', name : 'codename', width : 60, sortable : false, align : 'center', talign : 'center' },
			    {display : '排序', name : 'orderid', width : 60, sortable : false, align : 'center', talign : 'center' },
			    {display : '是否使用', name : 'modtime', width : 80, sortable : false, align : 'center', talign : 'center' },
			    {display : '是否显示', name : 'modtime', width : 80, sortable : false, align : 'center', talign : 'center' },
			    {display : '更新时间', name : 'modtime', width : 100, sortable : false, align : 'center', talign : 'center' },
			    {display : '操作', name : 'operate', width : 100, sortable : false, align : 'center', talign : 'left' }			    
			],
	       rp: 20,
	       newp: $('#page').val(),
	       width : 'auto',
		   height : document.documentElement.clientHeight - 102
		}); 
	}	   
	
    //返回
	function doback(){
		window.location.href = "/esf/DicAction_toList.jspx?page=" + $('#page').val();
	}	

	//编辑
	function edit(id){
		window.location.href = "/esf/DicAction_toItemsInfo.jspx?dicType.codeid="+$('#codeid').val()+"&page=" + $('.pcontrol input').val() + "&dicItems.itemid=" + id;
	}
	
	//删除
	function remove(id){
		parent.initConfirm('您确定要删除该记录吗？');
		parent.$("#confirmDialog").dialog({
			bgiframe: true,height: 150,modal: true,	resizable:false,draggable: false,
			buttons: {
				"取消": function(){
					parent.$('#confirmDialog').dialog('close');
				},
				'确定': function() {
					parent.$('#confirmDialog').dialog('close');
					$.ajax({
						url:'/esf/DicAction_deleteItem.jspx?dicItems.itemid=' + id,
						type: 'post', dataType:'html', cache: false, async:false,
						error: function(xhr){
							parent.exceptionAlert();
						},
						success: function(data){
							var r = eval('(' + data + ')');	
							if(r.flag){
								parent.showAlert(r.returnMsg, "delete");
								$("#grid").flexReload();
							}
						}
					});
				}				
			}
		});
	}
	
	</script>
  </head>
  <body class="tbody">
	
	<!-- 工具栏 -->
	<div class="toolbg toolbgline toolheight nowrap">
		<!-- 按钮 -->
		<div id="toolbarbtn" class="right">
			<input type="button" class="wd1 btn" value="返回" onclick="javascript:doback();" />
			<input type="button" class="wd1 btn" value="新增" onclick="javascript:edit('');" />
		</div>
		<!-- 页面信息 -->
		<div class="nowrap left">
			<div class="txt_title_nosearch">
					字典管理 &gt; 字典列表
			</div>
		</div>

		<s:hidden name="codeid" id="codeid" value="%{dicType.codeid}"/>
		<s:hidden name="page" value="%{page}"/>
		
		<div class="clr">&nbsp;</div>
	</div> 
	<table id="grid" style="display: none;"></table>
  </body>
</html>