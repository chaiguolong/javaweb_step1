<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8" /> 
    <title>静态化任务信息</title>
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
        	url : '/esf/WebStatic_getList.jspx',
        	params:[
        		{ name : 'keywords', value : $('#keywords').val() },
				{ name : 'stattype', value : $('#stattype option:selected').val() }
        	],
        	dataType : 'json',
           	colModel : [
           	    {display : 'id', name : 'statictaskid', width :40, sortable : false, align : 'center', hide:true },
			  	{display : '静态化模板名称', name : 'staticurl', width : 220, sortable : false, align : 'center', talign : 'left', isTitle:true },
			    {display : '静态化类型', name : 'stattype', width :80, sortable : false, align : 'center', talign : 'center' },
                {display : '模板地址', name : 'dynamicurl', width : 350, sortable : false, align : 'center', talign : 'left' },
			    {display : '静态化时间', name : 'actualdate', width : 140, sortable : false, align : 'center', talign : 'center' },
			    {display : '操作', name : 'operate', width : 70, sortable : false, align : 'center', talign : 'center' }	
				],
	       rp: 20,
	       newp: $('#page').val(),
	       width : 'auto',
		   height : document.documentElement.clientHeight - 128
		}); 
	}	   
	
	//查询
	function searchFlex(){
		$("#grid").flexReload();
	}	
	
	//手动静态化
	function onChange(statictaskid){
		parent.initConfirm('您确定要静态化页面吗？');
		parent.$("#confirmDialog").dialog({
			bgiframe: true,height: 150,modal: true,	resizable:false,draggable: false,
			buttons: {
				"取消": function(){
					parent.$('#confirmDialog').dialog('close');
				},
				'确定': function() {
					parent.$('#confirmDialog').dialog('close');
					$.ajax({
						url:'/esf/WebStatic_toCreate.jspx?webStatictask.statictaskid=' + statictaskid,
						type: 'post', dataType:'html', cache: false, async:false,
						error: function(xhr){
							parent.exceptionAlert();
						},
						success: function(data){
							var r = eval('(' + data + ')');	
							if(r.flag){
								parent.showAlert(r.returnMsg, "success");
							}
							else {
								parent.showAlert(r.returnMsg, "failure");
							}
							$("#grid").flexReload();
						}
					});
				}				
		      }
	    });
	}	


	//编辑
	function edit(id){
		window.location.href = "/esf/WebStatic_toEdit.jspx?page=" + $('.pcontrol input').val() + "&webStatictask.statictaskid=" + id;
	}			
	


	
	</script>
  </head>
  <body class="tbody">
  <div class="txt_title">静态化任务 &gt; 手动静态化页面  </div>	
	<!-- 工具栏 -->
	<div class="toolbg toolbgline toolheight nowrap">
		<!-- 按钮 -->
		<div id="toolbarbtn" class="right">
			<input type="button" class="wd1 btn" value="查询" onclick="javascript:searchFlex();" />
		</div>
		<!-- 页面信息 -->
			<div id="toolbarlist"  class="nowrap left">
		        <s:select id="stattype" name="stattype" list="#request.stattypelist" listKey="itemvalue" listValue="itemname" 
		        headerKey="" headerValue="静态化类型" onchange="searchFlex();">
		        </s:select>
			
				关键字 <input type="text" id="keywords" name="keywords" onkeypress="if(event.keyCode==13) searchFlex();" class="input_ss"/>
				<s:hidden name="page" value="%{page}"/>
			</div>
		<div class="clr">&nbsp;</div>
	</div> 
	<table id="grid" style="display: none;"></table>
  </body>
</html>