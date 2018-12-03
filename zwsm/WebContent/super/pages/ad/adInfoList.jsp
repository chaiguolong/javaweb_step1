<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8" /> 
    <title>广告位信息</title>
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
	<script type="text/javascript" src="/super/common/datePicker/WdatePicker.js"></script>
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
		if($.cookie('adInfoListQuery')){
			var query = $.evalJSON($.cookie('adInfoListQuery'));
			for(var i in query){
				$('#' + query[i].name).val(query[i].value);
			}
		}

		//取最新的参数 adtypeid
		//alert(<s:property value="webAdType.adtypeid" /> );
		if('<s:property value="webAdType.adtypeid" />'==''){
			$('#btn').css('display','none');
		}
		else {
			if('<s:property value="webAdType.adtypeid" />' != $('#adtypeid').val()){
				 $('#adtypeid').val('<s:property value="webAdType.adtypeid" />');
			}
		}
		loadFlexigrid();
	});
	
	function saveQueryCookie(){
		var query = [
                { name : 'keywords', value : $('#keywords').val() },
                { name : 'rsstype', value : $('#rsstype option:selected').val() },
                { name : 'isdisplay', value : $('#isdisplay option:selected').val() },
                { name : 'starttime', value : $('#starttime').val() },
                { name : 'adtypeid', value : $('#adtypeid').val() }, 
                { name : 'endtime', value : $('#endtime').val() }
		];
		$.cookie('adInfoListQuery', $.toJSON(query), {expires: 1});
	}
	
	//加载区域区划列表
    function loadFlexigrid(){
    	$("#grid").flexigrid({
        	url : '/esf/WebAd_getInfoList.jspx',
        	params:[
        		{ name : 'keywords', value : $('#keywords').val() },
				{ name : 'rsstype', value : $('#rsstype option:selected').val() },
				{ name : 'isdisplay', value : $('#isdisplay option:selected').val() },
				{ name : 'starttime', value : $('#starttime').val() },
				{ name : 'adtypeid', value : $('#adtypeid').val() }, 
				{ name : 'endtime', value : $('#endtime').val() }
        	],
        	dataType : 'json',
           	colModel : [
           	    {display : '广告编码', name : 'Adid', width :40, sortable : false, align : 'center', hide:true },
                {display : '资源类型', name : 'rsstype', width : 60, sortable : false, align : 'center', hide:false },
                {display : '广告位置', name : 'Adtypeseatinfo', width : 360, sortable : false, align : 'center', talign : 'left' },
			  	{display : '描述', name : 'Descr', width : 360, sortable : false, align : 'center', talign : 'left', hide:true  },
			    {display : '排序', name : 'orderid', width : 40, sortable : false, align : 'center', talign : 'center' },
			    {display : '是否显示', name : 'isdisplay', width : 80, sortable : false, align : 'center', talign : 'center' },
			    {display : '开始时间', name : 'begintime', width : 140, sortable : false, align : 'center', talign : 'center' },
			    {display : '到期时间', name : 'endtime', width : 140, sortable : false, align : 'center', talign : 'center' },
			    {display : '操作', name : 'operate', width : 100, sortable : false, align : 'center', talign : 'center' }		 			    
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
		window.location.href = "/esf/WebAd_toAdInfo.jspx?page=" + $('.pcontrol input').val() + "&webAdInfo.adid=" + id + "&webAdType.adtypeid=" + $('#adtypeid').val();
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
						url:'/esf/WebAd_deleteAdInfo.jspx?adid=' + id,
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
			url:'/esf/WebAd_checkDisplay.jspx?webAdInfo.isdisplay=' + isdisplay + '&webAdInfo.adid=' + id,
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

	//返回
	function doback(){
		window.location.href = "/esf/WebAd_toTypeList.jspx?page=" + $('.pcontrol input').val() + "&webAdType.adtypeid=" + $('#adtypeid').val();
	}
	</script>
  </head>
  <body class="tbody">
  <div class="txt_title">广告管理 &gt; 广告位信息   </div>	
	<!-- 工具栏 -->
	<div class="toolbg toolbgline toolheight nowrap">
		<!-- 按钮 -->
		<div id="toolbarbtn" class="right">
			<input type="button" id="btn" class="wd1 btn" value="返回" onclick="javascript:doback();" />
			<input type="button" class="wd1 btn" value="查询" onclick="javascript:searchFlex();" />
			<input type="button" class="wd1 btn" value="新增" onclick="javascript:edit('');" />
		</div>
		<!-- 页面信息 -->
			<div id="toolbarlist"  class="nowrap left">
				到期时间从 <input type="text" id="starttime" name="starttime" onkeypress="if(event.keyCode==13) searchFlex();" class="input_sss"/>
		                     到 <input type="text" id="endtime" name="endtime" onkeypress="if(event.keyCode==13) searchFlex();" class="input_sss"/>
		        <select id="rsstype" name="rsstype" onchange="searchFlex();">
				<option value="">资源类型</option>
				<option value="2">Flash</option>
				<option value="1">图片</option>
		       </select>             
				<select id="isdisplay" name="isdisplay" onchange="searchFlex();">
				<option value="">是否显示</option>
				<option value="1">显示</option>
				<option value="0">未显示</option>
		       </select>
				关键字 <input type="text" id="keywords" name="keywords" onkeypress="if(event.keyCode==13) searchFlex();" class="input_sss"/>
				<s:hidden name="webAdType.adtypeid" id="adtypeid" value=""></s:hidden>
				<s:hidden name="page" value="%{page}"/>
			</div>
		<div class="clr">&nbsp;</div>
	</div> 
	<table id="grid" style="display: none;"></table>
  </body>
</html>