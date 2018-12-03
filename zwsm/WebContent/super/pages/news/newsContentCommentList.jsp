<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8" /> 
    <title>资讯评论</title>
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
		if($.cookie('newContentCommentListQuery')){
			var query = $.evalJSON($.cookie('newContentCommentListQuery'));
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
			{ name : 'keywords', value : $('#keywords').val() }
		];
		$.cookie('newContentCommentListQuery', $.toJSON(query), {expires: 1});
	}
	
	//加载区域区划列表
    function loadFlexigrid(){
    	saveQueryCookie();
    	$("#grid").flexigrid({
        	url : '/esf/NewsContent_getNewsContentCommentList.jspx',
        	params:[
				{ name : 'starttime', value : $('#starttime').val() },
				{ name : 'endtime', value : $('#endtime').val() },  
				{ name : 'keywords', value : $('#keywords').val() }
			],
        	dataType : 'json',
           	colModel : [
                {display : 'ID', name : 'contentcommentid', width : 70, sortable : false, align : 'center', talign : 'center',hide : true},
			    {display : '资讯标题', name : 'title', width :220, sortable : false, align : 'center', talign : 'left' },  
			    {display : '评论标题', name : 'commenttitle', width : 220, sortable : false, align : 'center', talign : 'left' },
			    {display : '日期', name : 'commentremark', width : 150, sortable : false, align : 'center', talign : 'center' },
			    {display : '支持数', name : 'agreecount', width : 40, sortable : false, align : 'center', talign : 'center' }	,
			    {display : '反对数', name : 'negativecount', width : 40, sortable : false, align : 'center', talign : 'center' }	,
			    {display : '评论内容', name : 'commentremark', width : 250, sortable : false, align : 'center', talign : 'left' },
			    {display : '操作', name : 'operate', width : 35, sortable : false, align : 'center', talign : 'left' }		 			    
			],
	       rp: 20,
	       nowrap: false, //是否不换行
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

	//删除资讯
	function deleteNewsContentComment(id){
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
						url:'/esf/NewsContent_deleteNewsContentComment.jspx?contentComment.contentcommentid=' + id,
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
	</script>
  </head>
  <body class="tbody">
	<!-- 日志列表 -->
	<div class="txt_title">资讯中心 &gt; 资讯评论   </div>
	<!-- 工具栏 -->
	<div class="toolbg toolbgline toolheight nowrap">
		<!-- 按钮 -->
		<div id="toolbarbtn" class="right">
			<input type="button" class="wd1 btn" value="查询" onclick="javascript:searchFlex();" />
		</div>
		<!-- 查看 -->
		<div id="toolbarlist" class="nowrap left">
			评论从 <input type="text" id="starttime" name="starttime" onkeypress="if(event.keyCode==13) searchFlex();" class="input_sss"/>
			到 <input type="text" id="endtime" name="endtime" onkeypress="if(event.keyCode==13) searchFlex();" class="input_sss"/>
			关键字 <input type="text" id="keywords" name="keywords" onkeypress="if(event.keyCode==13) searchFlex();" class="input_sss"/>
			<s:hidden name="page" value="%{page}"/>
		</div>
		<div class="clr">&nbsp;</div>
	</div> 
	<table id="grid" style="display: none;"></table>
  </body>
</html>