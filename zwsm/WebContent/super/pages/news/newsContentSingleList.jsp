<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8" /> 
    <title>资讯单页列表</title>
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
	<script type="text/javascript" src="/super/js/jquery.cookie.js"></script>
	<script type="text/javascript" src="/super/js/jquery.extension.js"></script>
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
		//初始化当前页面cookie值
		if($.cookie('newContentListQuery')){
			var query = $.evalJSON($.cookie('newContentListQuery'));
			for(var i in query){
				$('#' + query[i].name).val(query[i].value);
			}
		}
		loadFlexigrid();
	});

	function saveQueryCookie(){
		var query = [
			{ name : 'starttime', value : $('#starttime').val() },
			{ name : 'endtime', value : $('#endtime').val() },  
			{ name : 'hotflag', value : $('#hotflag option:selected').val() }, 
			{ name : 'recommendflag', value : $('#recommendflag option:selected').val() }, 
			{ name : 'releasemark', value : $('#releasemark option:selected').val() }, 
			{ name : 'keywords', value : $('#keywords').val() }
		];
		$.cookie('newContentListQuery', $.toJSON(query), {expires: 1});
	}
	
	//加载区域区划列表
    function loadFlexigrid(){
    	$("#grid").flexigrid({
        	url : '/esf/NewsContent_getNewsContentSingleList.jspx?categoryid=${categoryid}',
        	params:[
				{ name : 'starttime', value : $('#starttime').val() },
				{ name : 'endtime', value : $('#endtime').val() },  
				{ name : 'hotflag', value : $('#hotflag option:selected').val() }, 
				{ name : 'recommendflag', value : $('#recommendflag option:selected').val() }, 
				{ name : 'releasemark', value : $('#releasemark option:selected').val() }, 
				{ name : 'keywords', value : $('#keywords').val() }
			],
        	dataType : 'json',
           	colModel : [
                {display : 'ID', name : 'contentid', width : 70, sortable : false, align : 'center', talign : 'center' },
			    {display : '资讯标题', name : 'title', width :330, sortable : false, align : 'center', talign : 'left' },  
			    {display : '是否推荐', name : 'recommendflag', width : 60, sortable : false, align : 'center', talign : 'center' },
			    {display : '是否热门', name : 'hotflag', width : 60, sortable : false, align : 'center', talign : 'center' },
			    {display : '状态', name : 'releasemarkvalue', width : 50, sortable : false, align : 'center', talign : 'center' },
			    {display : '起草时间', name : 'entrydate', width : 120, sortable : false, align : 'center', talign : 'center' }	,
			    {display : '显示时间', name : 'webshowdate', width : 120, sortable : false, align : 'center', talign : 'center' }	,
			    {display : '编辑人员', name : 'releasename', width : 60, sortable : false, align : 'center', talign : 'center' },
			    {display : '操作', name : 'operate', width : 80, sortable : false, align : 'center', talign : 'center' }	 			    
			],
	       rp: 20,
	       newp: $('#page').val(),
	       width : 'auto',
		   height : document.documentElement.clientHeight - 128
		}); 
	}	   
	
	//查询
	function searchFlex(){
		saveQueryCookie();
		$("#grid").flexReload();
	}	

	//编辑
	function edit(id){
		window.location.href = "/esf/NewsContent_toContentSingleInfo.jspx?page=" + $('.pcontrol input').val() + "&mode=0&categoryid=${categoryid}"  + "&newsContent.contentid=" + id;
	}

	//取消发布
	function cancel(id){
		parent.initConfirm('您确定要取消该资讯吗？');
		parent.$("#confirmDialog").dialog({
			bgiframe: true,height: 150,modal: true,	resizable:false,draggable: false,
			buttons: {
				"取消": function(){
					parent.$('#confirmDialog').dialog('close');
				},
				'确定': function() {
					parent.$('#confirmDialog').dialog('close');
					$.ajax({
						url:'/esf/NewsContent_updateNewsContent.jspx?newsContent.contentid=' + id + '&newsContent.releasemark=0',
						type: 'post', dataType:'html', cache: false, async:false,
						error: function(xhr){
							parent.exceptionAlert();
						},
						success: function(data){
							var r = eval('(' + data + ')');	
							if(r.flag){
								parent.showAlert(r.returnMsg, "success");
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
	
	//删除资讯
	function remove(id){
		parent.initConfirm('您确定要删除该资讯吗？');
		parent.$("#confirmDialog").dialog({
			bgiframe: true,height: 150,modal: true,	resizable:false,draggable: false,
			buttons: {
				"取消": function(){
					parent.$('#confirmDialog').dialog('close');
				},
				'确定': function() {
					parent.$('#confirmDialog').dialog('close');
					$.ajax({
						url:'/esf/NewsContent_deleteNewsContent.jspx?newsContent.contentid=' + id,
						type: 'post', dataType:'html', cache: false, async:false,
						error: function(xhr){
							parent.exceptionAlert();
						},
						success: function(data){
							var r = eval('(' + data + ')');	
							if(r.flag){
								parent.showAlert(r.returnMsg, "success");
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
	
	//删除
	function removeFile(path){
		$.ajax({
			url:'/esf/SuperUpload_removeDir.jspx?removePath=' + path,
			type: 'post', dataType:'html', cache: false, async:false,
			error: function(xhr){
				parent.exceptionAlert();
			},
			success: function(data){
				var r = eval('(' + data + ')');	
				if(r.flag){
					parent.showAlert("更新成功", "success");
				}
			}
		});
	}
	//预览
	function look(id){
		window.open('/info/news_newslook_' + id  + '_1.htm');
	}
	</script>
  </head>
  <body class="tbody">
	<!-- 日志列表 -->
	<div class="txt_title">资讯中心 &gt; 资讯单页列表   </div>
	<!-- 工具栏 -->
	<div class="toolbg toolbgline toolheight nowrap">
		<!-- 按钮 -->
		<div id="toolbarbtn" class="right">
			<input type="button" class="wd1 btn" value="查询" onclick="javascript:searchFlex();" />
			<input type="button" class="wd2 btn" value="起草资讯" onclick="javascript:edit('');" />
		</div>
		<!-- 查看 -->
		<div id="toolbarlist" class="nowrap left">
			<select id="hotflag" name="hotflag" onchange="searchFlex();">
				<option value="">热点资讯</option>
				<option value="1">热点</option>
				<option value="0">不热点</option>
			</select>
			<select id="recommendflag" name="recommendflag" onchange="searchFlex();">
				<option value="">推荐资讯</option>
				<option value="1">推荐</option>
				<option value="0">不推荐</option>
			</select>
			<select id="releasemark" name="releasemark" onchange="searchFlex();">
				<option value="">资讯状态</option>
				<option value="-2">待提交</option>
				<option value="-1">待审核</option>
				<option value="0">待发布</option>
				<option value="1">已发布</option>
				<option value="-3">退回</option>
			</select>
			起草从 <input type="text" id="starttime" name="starttime" onkeypress="if(event.keyCode==13) searchFlex();" class="input_sss"/>
			到 <input type="text" id="endtime" name="endtime" onkeypress="if(event.keyCode==13) searchFlex();" class="input_sss"/>
			关键字 <input type="text" id="keywords" name="keywords" onkeypress="if(event.keyCode==13) searchFlex();" class="input_sss"/>
			<s:hidden name="page" value="%{page}"/>
		</div>
		<div class="clr">&nbsp;</div>
	</div> 
	<table id="grid" style="display: none;"></table>
  </body>
</html>