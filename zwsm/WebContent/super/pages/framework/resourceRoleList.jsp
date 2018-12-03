<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8" /> 
    <title>角色列表</title>
    <meta http-equiv="pragma" content="no-cache"> 
	<meta http-equiv="Cache-Control" content="no-cache, must-revalidate">
    <link rel="stylesheet" type="text/css" href="/super/css/style.css" />
    <link rel="stylesheet" type="text/css" href="/super/css/images/simple/getcss.css" />
    <link rel="stylesheet" type="text/css" href="/super/common/flexigrid/css/flexigrid.css" />
	<link rel="stylesheet" type="text/css" href="/super/css/formInfo.css" />
    <link rel="stylesheet" type="text/css" href="/super/common/jqueryUi/css/ui.all.css"  />
	<link rel="stylesheet" type="text/css" href="/super/common/ztree/css/zTreeStyle.css" />
    <style type="text/css"> 
    	html{ overflow-y: auto; }
		.tbody {overflow-x:hidden;}
	</style>
	<script type="text/javascript" src="/super/common/datePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="/super/js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="/super/common/jqueryUi/jquery-ui-1.7.2.min.js"></script>
	<script type="text/javascript" src="/super/js/commpage.js"></script>
    <script type="text/javascript" src="/super/common/ztree/js/jquery.ztree.all-3.0.min.js"></script>	
	<script type="text/javascript" src="/super/common/flexigrid/flexigrid.js"></script>
	<script type="text/javascript" src="/super/js/jquery.form.js"></script>
	<script type="text/javascript" src="/super/js/jquery.cookie.js"></script>
	<script type="text/javascript" src="/super/js/jquery.extension.js"></script>
	<script type="text/javascript">
	$(document).ready(function(){
		//初始化当前页面cookie值
		if($.cookie('resourceRoleListQuery')){
			var query = $.evalJSON($.cookie('resourceRoleListQuery'));
			for(var i in query){
				$('#' + query[i].name).val(query[i].value);
			}
		}
		loadFlexigrid();
	});
	//cookie
	function saveQueryCookie(){
		var query = [
		        { name : 'keywords', value : $('#keywords').val() }
					];
		$.cookie('resourceRoleListQuery', $.toJSON(query), {expires: 1});
	}
	//加载ztree样式
	var setting = {
		check: {
			enable: true
		},	
		data: {
			simpleData: {
				enable: true,
				pIdKey : "pid"
			}
		}
	};
	//返回
	function doback(){
			window.location.href = "/esf/MenuResourceAction_toRoleList.jspx?page=" + $('#page').val();
	}
	//加载角色列表 
    function loadFlexigrid(){
    	$("#grid").flexigrid({
        	url : '/esf/MenuResourceAction_getRoleList.jspx',
        	params:[
				{ name : 'keywords', value : $('#keywords').val() }
			],
        	dataType : 'json',
           	colModel : [
				{display : '角色主键', name : 'roleid', width : 100, sortable : false, align : 'center', talign : 'left', hide : true},
				{display : '角色名称', name : 'rolename', width : 300, sortable : false, align : 'center', talign : 'left'},
			    {display : '角色描述', name : 'roleremark', width : 300, sortable : false, align : 'center', talign : 'left' },
			    {display : '操作', name : 'operate', width : 120, sortable : false, align : 'center', talign : 'left' }
			],
	       rp: 20,
	       newp: $('#page').val(),
	       width : 'auto',
		   height : document.documentElement.clientHeight - 128
		}); 
	}	
	//加载角色权限信息
	function eidtRealTree(id){
		$.ajax({
			url:'/esf/MenuResourceAction_loadTreeByRoleid.jspx?role.roleid=' + id,
			type: 'get', dataType:'html', cache: false, async:false,
			error: function(xhr){
				parent.exceptionAlert();
			},
			success: function(data){
				var r = eval('(' + data + ')');	
				var dr = r.roleResource;
				var d = r.role;
				menuTree(dr,d);
			}
		});
	}
	//加载角色信息 
	function eidtRealRole(id){
		$.ajax({
			url:'/esf/MenuResourceAction_loadRoleByRoleid.jspx?role.roleid=' + id,
			type: 'get', dataType:'html', cache: false, async:false,
			error: function(xhr){
				parent.exceptionAlert();
			},
			success: function(data){
				var r = eval('(' + data + ')');	
				createRole(r, true);
			}
		});
	}
	//新增角色信息 
	function increaseRealRole(){
		$.ajax({
			url:'/esf/MenuResourceAction_increaseRole.jspx',
			type: 'get', dataType:'html', cache: false, async:false,
			error: function(xhr){
				parent.exceptionAlert();
			},
			success: function(data){
				var r = eval('(' + data + ')');	
				r.rolename = "";
				createRole(r, true);
			}
		});
	}
	//加载角色表单 
	function createRole(role, flag){
		$('#roleDialog').remove();//删除存在的
		$('body').append('<div id="roleDialog" title="角色编辑"><form id="roleform" name="roleform"><table border="0" cellpadding="3" cellspacing="0">' 
				+ '<tr><td with="150">角色名称：</td><td><input name="role.rolename" id="role_rolename" value="' + role.rolename + '" class="input_l"/></td></tr>' 
				+ '<tr><td with="150">角色描述：</td><td><textarea name="role.roleremark" id="role_roleremark" value="' + role.roleremark + '" class="validate[maxSize[250]] textarea_ms">'+ role.roleremark +'</textarea></td></tr>' 
				+ '<input name="role.roleid" id="role.roleid" type="hidden" value="' + role.roleid + '"/> ' 
				+ '</table></form></div>');
		$("#roleDialog").dialog({
			bgiframe: true,
			height: 300,
			width:500,
			modal: true,
			resizable:false,
			draggable: false,
			buttons: {
				"取消": function(){
					$('#roleDialog').dialog('close');
				},
				'保存': function() {
					$('#roleDialog').dialog('close');
					if($("#role_rolename").val() == null || $("#role_rolename").val() == ""){
						parent.showAlert("操作失败，请输入正确角色名称！", "alert");
						createRole(role, flag);
					}
					else{
						if(flag){
							var saveOptions={
								target: '#roleform',
								url:"/esf/MenuResourceAction_saveRole.jspx", type: 'post', dataType: 'html', cache:false, async:false,
								beforeSubmit:function(formArray, jqForm){
								},
								error:function(xhr){
									parent.exceptionAlert();
								},
								success: function(data) {
									var r = eval('(' + data + ')');	
									if(r.flag){
										parent.showAlert(r.returnMsg, "success");
										doback();
									}
									else {
										parent.showAlert(r.returnMsg, "failure");
									}
								}
							}
						}
						$('#roleform').ajaxSubmit(saveOptions);
					}
				}
			}
		});
	}
	//加载角色权限表单
	function menuTree(dr,role){
		$('#treeDialog').remove();//删除存在的
		$('body').append('<div id="treeDialog" title="角色权限栏目"><div id="treeMenu" class="ztree"></div> '
			+ '<form id="menuTreeForm" name="menuTreeForm"><table border="0" cellpadding="3" cellspacing="0">' 
			+ '<input name="role.roleid" id="role_roleid" type="hidden" value="' + role.roleid + '"/> ' 
			+ '<input name="role.resourceids" id="role_resourceids" type="hidden" value="%{role.resourceids}" />'
			+ '</table></form></div>');
		$("#treeDialog").dialog({
			bgiframe: true,
			height: 460,
			width:380,
			modal: true,
			resizable:false,
			draggable: false,
			buttons: {
				"取消": function(){
					$('#treeDialog').dialog('close');
				},
				'保存': function() {
					$('#treeDialog').dialog('close');
					var nodes = treeObj.getCheckedNodes();
					var resourceids = new Array();
					for(var i in nodes){
						resourceids.push(nodes[i].rid);
					}
					if(resourceids.length == 0){
						parent.showAlert("请选择有效的权限！", "alert");
						menuTree(dr,role);
					}
					else{
						$('#menuTreeForm #role_resourceids').val(resourceids);
						var saveOptions = {
							target: '#menuTreeForm',
							url:"/esf/MenuResourceAction_saveRoleResource.jspx", type: 'post', dataType: 'html', cache:false, async:false,
							beforeSubmit:function(formArray, jqForm){
							},
							error:function(xhr){
								parent.exceptionAlert();
							},
							success: function(data) {
								var r = eval('(' + data + ')');	
								if(r.flag){
									parent.showAlert(r.returnMsg, "success");
									doback();
								}
								else {
									parent.showAlert(r.returnMsg, "failure");
								}
							}
						}
						$('#menuTreeForm').ajaxSubmit(saveOptions);
					}
				}
			}
		});
		$.ajax({
			url:'/esf/MenuResourceAction_getZtreeMenu.jspx',
			type: 'get',dataType:'json',cache: false,async: false,
			error: function(xhr){
				exceptionAlert();
			},
			success: function(data){	
				treeObj = $.fn.zTree.init($("#treeMenu"), setting, data);
				if(dr!=null && dr.length>0){
					for(var i in dr){
						treeObj.checkNode(treeObj.getNodeByParam("rid", $.trim(dr[i].resourceid), null), true, false);
					}
				}
			}
		});
	}
  	//查找
	function searchFlex(){
		saveQueryCookie();
		$("#grid").flexReload();
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
						url:'/esf/MenuResourceAction_deleteRole.jspx?role.roleid=' + id,
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
	<div class="txt_title">角色资源 &gt; 角色列表 </div>
	<!-- 工具栏 -->
	<div class="toolbg toolbgline toolheight nowrap">
		<!-- 按钮 -->
		<div id="toolbarbtn" class="right">
			<input type="button" class="wd1 btn" value="查询" onclick="javascript:searchFlex();" />
			<input type="button" class="wd1 btn" value="新增" onclick="javascript:increaseRealRole('');" />
		</div>
		<!-- 查找 -->
		<div id="toolbarlist" class="nowrap left">
			关键字 <input type="text" id="keywords" name="keywords" onkeypress="if(event.keyCode==13) searchFlex();" class="input_s"/>
			<s:hidden name="page" value="%{page}"/>
			<s:hidden name="menu.menuid" value="%{menu.menuid}" />
		</div>
		<div class="clr">&nbsp;</div>
	</div> 
	<table id="grid" style="display: none;"></table>
  </body>
</html>