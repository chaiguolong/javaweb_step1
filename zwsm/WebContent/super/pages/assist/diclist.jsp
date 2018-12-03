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
		$("#starttime,#endtime").bind("click",function(){
			WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd'});
		});
		$('#starttime').focus(function(){
			WdatePicker({maxDate:'#F{$dp.$D(\'endtime\',{d:-1});}'});
		});
		$('#endtime').focus(function(){
			WdatePicker({minDate:'#F{$dp.$D(\'starttime\',{d:1});}'});
		});
		loadFlexigrid();
	});
	
	//加载字典列表
    function loadFlexigrid(){
    	$("#grid").flexigrid({
        	url : '/esf/DicAction_getList.jspx',
        	params:[
				{ name : 'starttime', value : $('#starttime').val() },
				{ name : 'endtime', value : $('#endtime').val() },    
				{ name : 'keywords', value : $('#keywords').val() }
			],
        	dataType : 'json',
           	colModel : [
			    {display : '类型编码', name : 'codetype', width : 350, sortable : false, align : 'center', talign : 'left'},	
			    {display : '类型名称', name : 'codename', width : 350, sortable : false, align : 'center', talign : 'left' },
			    {display : '排序', name : 'orderid', width : 80, sortable : false, align : 'center', talign : 'center' },
			    {display : '更新时间', name : 'modtime', width : 90, sortable : false, align : 'center', talign : 'center' },
			    {display : '操作', name : 'operate', width : 120, sortable : false, align : 'center', talign : 'left' }			    
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

	//编辑
	function edit(id){
		window.location.href = "/esf/DicAction_toInfo.jspx?dicType.codeid=" + id;
	}

	//查看
	function check(id){
		window.location.href = "/esf/DicAction_toItemsList.jspx?page=" + $('.pcontrol input').val() + "&dicType.codeid=" + id;
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
						url:'/esf/DicAction_delete.jspx?dicType.codeid=' + id,
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
	<!-- 日志列表 -->
	<div class="txt_title">字典类型管理 &gt; 字典类型列表 </div>
	<!-- 工具栏 -->
	<div class="toolbg toolbgline toolheight nowrap">
		<!-- 按钮 -->
		<div id="toolbarbtn" class="right">
			<input type="button" class="wd1 btn" value="查询" onclick="javascript:searchFlex();" />
			<input type="button" class="wd1 btn" value="新增" onclick="javascript:edit('');" />
		</div>
		<!-- 查看 -->
		<div id="toolbarlist" class="nowrap left">
			时间从 <input type="text" id="starttime" name="starttime" onkeypress="if(event.keyCode==13) searchFlex();" class="input_sss"/>
			到 <input type="text" id="endtime" name="endtime" onkeypress="if(event.keyCode==13) searchFlex();" class="input_sss"/>		
			关键字 <input type="text" id="keywords" name="keywords" onkeypress="if(event.keyCode==13) searchFlex();" class="input_s"/>
			<s:hidden name="page" value="%{page}"/>
		</div>
		<div class="clr">&nbsp;</div>
	</div> 
	<table id="grid" style="display: none;"></table>
  </body>
</html>