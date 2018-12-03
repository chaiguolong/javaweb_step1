<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8" /> 
    <title>资源菜单</title>
    <meta http-equiv="pragma" content="no-cache"> 
	<meta http-equiv="Cache-Control" content="no-cache, must-revalidate">
    <link rel="stylesheet" type="text/css" href="/super/css/style.css" />
    <link rel="stylesheet" type="text/css" href="/super/css/images/simple/getcss.css" />
    <link rel="stylesheet" type="text/css" href="/super/common/flexigrid/css/flexigrid.css" />
    <style type="text/css"> 
    	html{ overflow-y: auto; }
		.tbody {overflow-x:hidden;}
	</style>
	<script type="text/javascript" src="/super/js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="/super/common/flexigrid/flexigrid.js"></script>
	<script type="text/javascript">
	$(document).ready(function(){
		loadFlexigrid();
	});
	
	//加载菜单列表
	function loadFlexigrid(){
    	$("#grid").flexigrid({
        	url : '/esf/MenuResourceAction_getTypeList.jspx',
        	params:[  
				{ name : 'keywords', value : $('#keywords').val() }
			],
        	dataType : 'json',
           	colModel : [
                {display : '菜单编码', name : 'menuid', width : 200, sortable : false, align : 'center', hide : true }, 
				{display : 'PID', name : 'pid', width : 200, sortable : false, align : 'center', hide : true}, 
			    {display : '菜单名称', name : 'menuname', width : 300, sortable : false, align : 'center', talign : 'left' }, 
				{display : '排序', name : 'sortnumber', width : 60, sortable : false, align : 'center', talign : 'center'},
				{display : '资源地址', name : 'difinestring', width : 360, sortable : false, align : 'center', talign : 'left'},
				{display : '操作', name : 'operate', width : 70, sortable : false, align : 'center', talign : 'left'}		    		   				    
			],
	       rp: 20,
	       usepager: false,
	       width : 'auto',
		   height : document.documentElement.clientHeight - 71
		}); 
	}
	//编辑
	function edit(id){
		window.location.href = "/esf/MenuResourceAction_toTypeInfo.jspx?menu.menuid=" + id;
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
						url:'/esf/MenuResourceAction_deleteType.jspx?menu.menuid=' + id,
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
							else {
								parent.showAlert(r.returnMsg, "failure");
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
			<input type="button" class="wd1 btn" value="新增" onclick="javascript:edit('');" />
		</div>
		<!-- 页面信息 -->
			<div class="nowrap left">
				<div class="txt_title">资源中心 &gt; 菜单栏目   </div>	
			</div>
			<s:hidden name="page" value="%{page}"/>
		<div class="clr">&nbsp;</div>
	</div> 
	<table id="grid" style="display: none;"></table>
  </body>
</html>