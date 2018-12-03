<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8" /> 
    <title>资讯栏目列表</title>
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
	
	//加载区域区划列表
    function loadFlexigrid(){
    	$("#grid").flexigrid({
        	url : '/esf/NewsCategory_getTypeList.jspx',
        	params:[],
        	dataType : 'json',
           	colModel : [
                {display : '栏目编码', name : 'categoryid', width : 40, sortable : false, align : 'center', hide:true },  
			    {display : '栏目名称', name : 'name', width :450, sortable : false, align : 'center', talign : 'left' },
			    {display : '排序', name : 'orderid', width : 60, sortable : false, align : 'center', talign : 'center' },
			    {display : '是否显示', name : 'isdisplay', width : 80, sortable : false, align : 'center', talign : 'center' },
			    {display : '备注', name : 'modtime', width : 140, sortable : false, align : 'center', talign : 'left' }	,
			    {display : '操作', name : 'operate', width : 80, sortable : false, align : 'center', talign : 'center' }		 			    
			],
	       rp: 500,
	       usepager: false, //是否分页
	       width : 'auto',
		   height : document.documentElement.clientHeight - 71
		}); 
	}	   
	
	//查询
	function searchFlex(){
		$("#grid").flexReload();
	}	

	//编辑
	function edit(id){
		window.location.href = "/esf/NewsCategory_toTypeInfo.jspx?newsCategory.categoryid=" + id;
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
						url:'/esf/NewsCategory_deleteType.jspx?categoryid=' + id,
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
	
	function checkDisplay(id, isdisplay){
		$.ajax({
			url:'/esf/NewsCategory_checkDisplay.jspx?newsCategory.isdisplay=' + isdisplay + '&newsCategory.categoryid=' + id,
			type: 'post', dataType:'html', cache: false, async:false,
			error: function(xhr){
				parent.exceptionAlert();
			},
			success: function(data){
				var r = eval('(' + data + ')');	
				if(r.flag){
					$("#grid").flexReload();
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
				<div class="txt_title">资讯中心 &gt; 资讯栏目   </div>	
			</div>
		<div class="clr">&nbsp;</div>
	</div> 
	<table id="grid" style="display: none;"></table>
  </body>
</html>