<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8" /> 
    <title>广告位位置分类 列表</title>
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
	<script type="text/javascript" src="/super/js/jquery.cookie.js"></script>
	<script type="text/javascript" src="/super/js/jquery.extension.js"></script>
	
	<script type="text/javascript">
	$(document).ready(function(){
		//初始化当前页面cookie值
		if($.cookie('adTypeListQuery')){
			var query = $.evalJSON($.cookie('adTypeListQuery'));
			for(var i in query){
				$('#' + query[i].name).val(query[i].value);
			}
		}
		loadFlexigrid();
	});

	function saveQueryCookie(){
		var query = [
		             { name : 'seatinfo', value : $('#seatinfo option:selected').val() },
					 { name : 'keywords', value : $('#keywords').val() }
		];
		$.cookie('adTypeListQuery', $.toJSON(query), {expires: 1});
	}
	
	//加载区域区划列表
    function loadFlexigrid(){
    	$("#grid").flexigrid({
        	url : '/esf/WebAd_getTypeList.jspx',
        	params:[
				 { name : 'seatinfo', value : $('#seatinfo option:selected').val() },
				 { name : 'keywords', value : $('#keywords').val() }
			],
        	dataType : 'json',
           	colModel : [
                {display : '分类编码', name : 'adtypeid', width : 40, sortable : false, align : 'center', hide:true },    
			    {display : '位置说明', name : 'seatinfo', width : 360, sortable : false, align : 'center', talign : 'left' },
			    {display : '排序', name : 'orderid', width : 40, sortable : false, align : 'center', talign : 'center' },
			    {display : '更新时间', name : 'updatetime', width : 140, sortable : false, align : 'center', talign : 'center' },
			    {display : '操作', name : 'operate', width : 100, sortable : false, align : 'center', talign : 'center' }		 			    
				],
	       rp: 20,
	       newp: $('#page').val(),
	       width : 'auto',
		   height : document.documentElement.clientHeight- 128
		}); 
	}	   
	
	//查询
	function searchFlex(){
		saveQueryCookie();
		$("#grid").flexReload();
	}	
	//查看广告
	function check(id){
		window.location.href = "/esf/WebAd_toInfoList.jspx?page="+ $('.pcontrol input').val() + "&webAdType.adtypeid=" + id;
	}
	//编辑
	function edit(id){
		window.location.href = "/esf/WebAd_toTypeInfo.jspx?webAdType.adtypeid=" + id;
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
						url:'/esf/WebAd_deleteType.jspx?adtypeid=' + id,
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
	<div class="txt_title">广告管理 &gt; 广告位位置分类   </div>	
	<!-- 工具栏 -->
	<div class="toolbg toolbgline toolheight nowrap">
		<!-- 按钮 -->
		<div id="toolbarbtn" class="right">
			<input type="button" class="wd1 btn" value="查询" onclick="javascript:searchFlex();" />
			<input type="button" class="wd1 btn" value="新增" onclick="javascript:edit('');" />
		</div>
		<!-- 页面信息 -->
			<div id="toolbarlist" class="nowrap left">
			<!-- 
			<s:select name="webAdType.webseatid" id="siteid"
				list="#request.websiteList" headerKey="" headerValue="请选择..." 
				listKey="siteid" listValue="sitename" value="%{webAdType.webseatid}" onchange="searchFlex();"> 
		    </s:select>
		     -->
		    <!-- 
		    <s:select id="seatinfo" name="webAdType.seatinfo" 
		   	 	list="#request.seatlist" listKey="itemname" listValue="itemname" 
		    	headerKey="" headerValue="页面索引" onchange="searchFlex();">
		    </s:select>
			 -->
			 
			 <s:select name="webAdType.seatinfo" id="seatinfo"
		    	list="#{'首页':'首页','新房':'新房','资讯':'资讯'}" 
		    	headerKey="" headerValue="页面索引" onchange="searchFlex();">
			</s:select>
		    
			关键字 <input type="text" id="keywords" name="keywords" onkeypress="if(event.keyCode==13) searchFlex();" class="input_sss"/>
			</div>
		<div class="clr">&nbsp;</div>
	</div> 
	<s:hidden name="page" value="%{page}"/>
	<table id="grid" style="display: none;"></table>
  </body>
</html>