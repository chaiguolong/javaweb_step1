<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8" /> 
    <title> 用户信息</title>
    <meta http-equiv="pragma" content="no-cache"> 
	<meta http-equiv="Cache-Control" content="no-cache, must-revalidate"> 
    <link rel="stylesheet" type="text/css" href="/super/css/style.css" />
    <link rel="stylesheet" type="text/css" href="/super/css/images/simple/getcss.css" />
    <link rel="stylesheet" type="text/css" href="/super/css/formInfo.css" />
    <link rel="stylesheet" type="text/css" href="/super/common/jqueryUi/css/ui.all.css" />
	<link rel="stylesheet" type="text/css" href="/super/common/formValidator/validationEngine.jquery.css" />
    <link rel="stylesheet" type="text/css" href="/super/common/flexigrid/css/flexigrid.css" />
    <style type="text/css"> 
    	html{ overflow-y: auto; }
		.tbody {overflow-x:hidden;}
	</style>
	<script type="text/javascript" src="/super/js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="/super/common/jqueryUi/jquery-ui-1.7.2.min.js"></script>
	<script type="text/javascript" src="/super/common/formValidator/jquery.validationEngine-reg.js"></script>
	<script type="text/javascript" src="/super/common/formValidator/jquery.validationEngine.js"></script>
	<script type="text/javascript" src="/super/js/jquery.form.js"></script>
	<script type="text/javascript" src="/super/js/commpage.js"></script>
	<script type="text/javascript" src="/super/common/flexigrid/flexigrid.js"></script>
	<script type="text/javascript" src="/super/js/jquery.cookie.js"></script>
	<script type="text/javascript" src="/super/js/jquery.extension.js"></script>
	<script type="text/javascript">
	var _m = new Array();//全局参数
	$(document).ready(function(){	
		//初始化当前页面cookie值
		if($.cookie('UserInfoListQuery')){
			var query = $.evalJSON($.cookie('UserInfoListQuery'));
			for(var i in query){
				$('#' + query[i].name).val(query[i].value);
			}
		}	
		loadFlexigrid();
	});
	
	//放入COOKie缓存数据
	function saveQueryCookie(){
		var query = [
				  {	name : 'isenable', value : $('#isenable option:selected').val() },
                  { name : 'keywords', value : $('#keywords').val() }
		];
		$.cookie('UserInfoListQuery', $.toJSON(query), {expires: 1});
	}
	
	//用户信息列表
    function loadFlexigrid(){
    	$("#grid").flexigrid({
        	url : '/esf/UserInfoAction_getList.jspx',
        	params:[  
        		{ name : 'isenable', value : $('#isenable option:selected').val() },
				{ name : 'keywords', value : $('#keywords').val() }
			],
        	dataType : 'json',
           	colModel : [
                {display : '用户信息编码', name : 'userextid', width : 40, sortable : false, align : 'center', hide:true }, 
				{display : '用户账号编码', name : 'accountid', width : 40, sortable : false, align : 'center', hide:true },
				{display : '用户名', name : 'loginuser', width : 150, sortable : false, align : 'center', talign : 'left'},
				{display : '性别', name : 'sex', width : 35, sortable : false, align : 'center', talign : 'center'},
				{display : '真实姓名', name : 'sex', width : 80, sortable : false, align : 'center', talign : 'left'},
				{display : '邮件地址', name : 'email', width : 200, sortable : false, align : 'center', talign : 'left'},
				{display : '手机号码', name : 'mobile', width : 140, sortable : false, align : 'center', talign : 'left'},
			    {display : '账号状态', name : 'isenable', width : 50, sortable : false, align : 'center', talign : 'center'},
			    {display : '操作', name : 'operate', width : 130, sortable : false, align : 'center', talign : 'center' }					    		   				    
			],
	       rp: 20,
	       newp: $('#page').val(),
	       width : 'auto',
		   height : document.documentElement.clientHeight - 128
		}); 
	}	
	//获取静态化任务列表
	function loadStaticTask(id){
		_m.length = 0;
		$.ajax({
			url:'/esf/UserInfoAction_loadStaticList.jspx?accountid='+ id,
			type: 'post', dataType:'html', cache: false, async:false,
			error: function(xhr){
				parent.exceptionAlert();
			},
			success: function(data){
				var r = eval('(' + data + ')');	
				var s = r.staticlist;
				if(s.length != 0){
					for(var i in s){
						_m.push(s[i].statictaskid);
					}
				}
				addStaticTask(id);
			}
		});
	}
	//获取静态化列表框
	function addStaticTask(id){
		$('#staticDialog').remove();//删除存在的
		$('body').append('<div id="staticDialog" title="静态化任务列表"><form id="staticform" name="staticform"><table id="gridstatic" style="display: none;">'
		+'</table></form></div>');
		$("#staticDialog").dialog({
				bgiframe: true,
				height: 490,
				width: 680,
				modal: true,
				resizable:false,
				draggable: false,
				buttons: {
					"取消": function(){
						$('#staticDialog').dialog('close');
					},
					'保存': function() {
						$('#staticDialog').dialog('close');
						var saveOptions={
							target: '#staticform',
							url:'/esf/UserInfoAction_saveStatic.jspx?id=' + id + '&staticids=' + _m , 
							type: 'post', dataType: 'html', cache:false, async:false,
							beforeSubmit:function(formArray, jqForm){
							},
							error:function(xhr){
								parent.exceptionAlert();
							},
							success: function(data) {
								var r = eval('(' + data + ')');	
								if(r.flag){
									parent.showAlert(r.returnMsg, "success");
								}
								else {
									parent.showAlert(r.returnMsg, "failure");
								}
							}
						}
						$('#staticform').ajaxSubmit(saveOptions);
					}
				}
			});
		loadReadadtypeListFlex();
	}
	//获取静态化列表
	function loadReadadtypeListFlex(){
		$("#gridstatic").flexigrid({
			 url : '/esf/UserInfoAction_getStaticList.jspx',
	        	dataType : 'json',
	          	colModel : [
		          	{display : 'id', name : 'statictaskid', width :40, sortable : false, align : 'center', hide:true },
		          	{display : '<input type=checkbox  onclick="checkAll(this);" id="allcheck" />', name : 'checkboxs', width : 50, sortable : false, align : 'center', talign : 'center'},  
				  	{display : '静态化模板名称', name : 'staticurl', width : 200, sortable : false, align : 'center', talign : 'left', isTitle:true },
				    {display : '站点名称', name : 'sitename', width :80, sortable : false, align : 'center', talign : 'center' },
				    {display : '模板地址', name : 'dynamicurl', width : 270, sortable : false, align : 'center', talign : 'left', isTitle:true }
				],
				rp: 10,
	       searchitems : [
			    {display: '关键字', name : 'keywords',isdefault: true }
		   ],
		   showFindDiv: true,//是否自动显示查询条件框
	       width : 650,
	       height : 530,
	       height : 'auto',
	       onSuccess : function(){
	       		for(var i in _m){
		   			$('#gridstatic #boxs_' + _m[i]).attr('checked', true);
			   	}
			   	$('.hDivBox #allcheck').attr('checked', false);
	       }
		});
	}
	//全选
	function checkAll(event){
		if($(event).attr('checked')){
			$('#gridstatic [type=checkbox]').attr('checked', true);
		}
		else {
			$('#gridstatic [type=checkbox]').attr('checked', false);
		}
		$('#gridstatic [type=checkbox]').each(function(){
			checkPushGroups($(this).val());
		});
	}
	//点击checkbox改变暂存数组
	function checkPushGroups(id){
		if($('#gridstatic #boxs_' + id).attr('checked')){
			var flag = false;
			for(var i in _m){
				if(id == _m[i]){
					flag = true;
					break;
				}
			}
			if(!flag) _m.push(id);
		}
		else {
			for(var i in _m){
				if(id == _m[i]){
					_m.splice(i, 1); 
					break;
				}
			}
		}
	}
	//屏蔽或者解除屏蔽用户
    function checkIsenable(id, isenable){
    	if(isenable == 1){parent.initConfirm('您确定要启用该用户吗？');
    	}else{parent.initConfirm('您确定要屏蔽该用户吗？');
         }
		parent.$("#confirmDialog").dialog({
			bgiframe: true,height: 150,modal: true,	resizable:false,draggable: false,
			buttons: {
				"取消": function(){
					parent.$('#confirmDialog').dialog('close');
				},
				'确定': function() {
					parent.$('#confirmDialog').dialog('close');
					$.ajax({
						url:'/esf/UserInfoAction_check.jspx?userAccount.isenable=' + isenable + '&userAccount.accountid=' + id,
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
			}
		});
	}   
	
	//查找
	function searchFlex(){
		saveQueryCookie();
		$("#grid").flexReload();
	}	
	
	//编辑
	function edit(id,aid){
		window.location.href = "/esf/UserInfoAction_toInfo.jspx?page=" + $('.pcontrol input').val() + "&userInfo.userextid=" + id +"&userInfo.accountid=" + aid;
	}
	
	//删除用户相关信息
	function remove(id){
		parent.initConfirm('您确定要删除该选项吗？');
		parent.$("#confirmDialog").dialog({
			bgiframe: true,height: 150,modal: true,	resizable:false,draggable: false,
			buttons: {
				"取消": function(){
					parent.$('#confirmDialog').dialog('close');
				},
				'确定': function() {
					parent.$('#confirmDialog').dialog('close');
					$.ajax({
						url:'/esf/UserInfoAction_delete.jspx?userInfo.accountid=' + id,
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
	<div class="txt_title">用户信息 </div>
	<!-- 工具栏 -->
	<div class="toolbg toolbgline toolheight nowrap">
		<!-- 按钮 -->
		<div id="toolbarbtn" class="right">
			<input type="button" class="wd1 btn" value="查询" onclick="javascript:searchFlex();" />
			<input type="button" class="wd1 btn" value="新增" onclick="javascript:edit('','');" />
		</div>
		<!-- 查看 -->
		<div id="toolbarlist" class="nowrap left">
			<select id="isenable" name="isenable" onchange="searchFlex();">
				<option value="">账号状态</option>
				<option value="1">启用</option>
				<option value="0">屏蔽</option>
			</select>
			关键字 <input type="text" id="keywords" name="keywords" onkeypress="if(event.keyCode==13) searchFlex();" class="input_s"/>
			<s:hidden name="page" value="%{page}"/>
		</div>
		<div class="clr">&nbsp;</div>
	</div> 
	<table id="grid" style="display: none;"></table>
  </body>
</html>