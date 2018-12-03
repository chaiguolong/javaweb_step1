<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8" /> 
    <title>投诉管理</title>
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
	<script type="text/javascript" src="/super/js/jquery.cookie.js"></script>
	<script type="text/javascript" src="/super/common/flexigrid/flexigrid.js"></script>
	<script type="text/javascript" src="/super/js/jquery.extension.js"></script>
	<script type="text/javascript">
	$(document).ready(function(){
		//初始化当前页面cookie值
		$("#starttime,#endtime").bind("click",function(){
			WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd'});
		});
		$('#starttime').focus(function(){
			WdatePicker({maxDate:'#F{$dp.$D(\'endtime\',{d:-1});}'});
		});
		$('#endtime').focus(function(){
			WdatePicker({minDate:'#F{$dp.$D(\'starttime\',{d:1});}'});
		});
		if($.cookie('complaintListQuery')){
			var query = $.evalJSON($.cookie('complaintListQuery'));
			for(var i in query){
				$('#' + query[i].name).val(query[i].value);
			}
		}
		loadFlexigrid();
	});
	
	//cookie
	function saveQueryCookie(){
		var query = [
			{ name : 'starttime', value : $('#starttime').val() },
			{ name : 'endtime', value : $('#endtime').val() },  
			{ name : 'isdisplay', value : $('#isdisplay option:selected').val() }, 
			{ name : 'state', value : $('#state option:selected').val() }, 
			{ name : 'keywords', value : $('#keywords').val() }
		];
		$.cookie('complaintListQuery', $.toJSON(query), {expires: 1});
	}
	//加载土地专列表
	function loadFlexigrid(){
    	$("#grid").flexigrid({
        	url : '/esf/ComplaintAction_getCateList.jspx',
        	params:[
        		{ name : 'starttime', value : $('#starttime').val() },
			{ name : 'endtime', value : $('#endtime').val() },  
			{ name : 'isdisplay', value : $('#isdisplay option:selected').val() }, 
			{ name : 'state', value : $('#state option:selected').val() }, 
			{ name : 'keywords', value : $('#keywords').val() }
			],
        	dataType : 'json',
           	colModel : [
                {display : '主键', name : 'complaintid', width : 50, sortable : false, align : 'center',talign : 'left', hide : true },
                {display : '投诉事宜', name : 'infotitle', width : 300, sortable : false, align : 'center',talign : 'left',isTitle : true } ,
                {display : '投诉时间', name : 'addtime', width : 140, sortable : false, align : 'center',talign : 'left'} ,
                {display : '投诉人', name : 'complaintname', width : 50, sortable : false, align : 'center',talign : 'left'} ,
                {display : '被投诉开发商', name : 'developername', width : 100, sortable : false, align : 'center',talign : 'left'} ,
                {display : '显示状态', name : 'isdisplay', width :50, sortable : false, align : 'center',talign : 'center' } ,
                {display : '答复状态', name : 'state', width : 50, sortable : false, align : 'center',talign : 'center' } ,
                {display : '答复人', name : 'replyname', width : 50, sortable : false, align : 'center',talign : 'left' } ,
                {display : '答复时间', name : 'replytime', width : 140, sortable : false, align : 'center',talign : 'center' } ,
                {display : '操作', name : 'operate', width : 70, sortable : false, align : 'center',talign : 'center' }
			],
	       rp: 20,
	       width : 'auto',
	       newp: $('#page').val(),
		   height : document.documentElement.clientHeight - 128
		}); 
	}
	
	//显示/不显示
	function isdisplay(id, isdisplay){
		$.ajax({
			url:'/esf/ComplaintAction_isdisplay.jspx?complaint.complaintid=' + id + '&complaint.isdisplay=' + isdisplay,
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
	//编辑
	function edit(id){
		window.location.href = "/esf/ComplaintAction_toCateInfo.jspx?page=" + $('.pcontrol input').val() + "&complaint.complaintid=" + id;
	}
	//查找
	function searchFlex(){
		saveQueryCookie();
		$("#grid").flexReload();
	}   
	//删除
	function remove(id){
		parent.initConfirm('您确定要删除该条投诉信息吗？');
		parent.$("#confirmDialog").dialog({
			bgiframe: true,height: 150,modal: true,	resizable:false,draggable: false,
			buttons: {
				"取消": function(){
					parent.$('#confirmDialog').dialog('close');
				},
				'确定': function() {
					parent.$('#confirmDialog').dialog('close');
					$.ajax({
						url:'/esf/ComplaintAction_deleteType.jspx?complaint.complaintid=' + id,
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
	<!-- 日志列表 -->
	<div class="txt_title">投诉管理  &gt; 投诉管理列表 </div>
	<!-- 工具栏 -->
	<div class="toolbg toolbgline toolheight nowrap">
		<!-- 按钮 -->
		<div id="toolbarbtn" class="right">
			<input type="button" class="wd1 btn" value="查询" onclick="javascript:searchFlex();" />
		</div>
		<!-- 查找 -->
		<div id="toolbarlist" class="nowrap left">
			<select id="isdisplay" name="isdisplay" onchange="searchFlex();">
				<option value="">显示状态</option>
				<option value="1">显示</option>
				<option value="0">不显示</option>
			</select>
			<select id="state" name="state" onchange="searchFlex();">
				<option value="">答复状态</option>
				<option value="1">已答复</option>
				<option value="0">未答复</option>
			</select>
			咨询时间从 <input type="text" id="starttime" name="starttime" onkeypress="if(event.keyCode==13) searchFlex();" class="input_sss"/>
			到 <input type="text" id="endtime" name="endtime" onkeypress="if(event.keyCode==13) searchFlex();" class="input_sss"/>
			关键字<input type="text" id="keywords" name="keywords" onkeypress="if(event.keyCode==13) searchFlex();" class="input_s"/>
			<s:hidden name="page" value="%{page}"/>
		</div>
		<div class="clr">&nbsp;</div>
	</div> 
	<table id="grid" style="display: none;"></table>
  </body>
</html>