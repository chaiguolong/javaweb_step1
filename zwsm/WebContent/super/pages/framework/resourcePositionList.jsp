<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8" /> 
    <title>职务列表</title>
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
		if($.cookie('positionListQuery')){
			var query = $.evalJSON($.cookie('positionListQuery'));
			for(var i in query){
				$('#' + query[i].name).val(query[i].value);
			}
		}
		loadFlexigrid();
	});
	//定义ztree样式
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
	//cookie
	function saveQueryCookie(){
		var query = [
		        { name : 'keywords', value : $('#keywords').val() }
					];
		$.cookie('positionListQuery', $.toJSON(query), {expires: 1});
	}
	//返回
	function doback(){
			window.location.href = "/esf/MenuResourceAction_toPositionList.jspx?page=" + $('#page').val();
	}
	//加载职务列表 
    function loadFlexigrid(){
    	$("#grid").flexigrid({
        	url : '/esf/MenuResourceAction_getPositionList.jspx',
        	params:[
				{ name : 'keywords', value : $('#keywords').val() }
			  	   ],
        	dataType : 'json',
           	colModel : [
				{display : '职务ID', name : 'positionid', width : 100, sortable : false, align : 'center', talign : 'left', hide : true},
				{display : '部门ID', name : 'departmentid', width : 200, sortable : false, align : 'center', talign : 'left', hide : true}, 
			    {display : '职务名称', name : 'positionname', width : 400, sortable : false, align : 'center', talign : 'left' },
			    {display : '操作', name : 'operate', width : 120, sortable : false, align : 'center', talign : 'left' }
			],
	       rp: 20,
	       newp: $('#page').val(),
	       width : 'auto',
		   height : document.documentElement.clientHeight - 128
		}); 
	}	
	//加载职务权限信息
	function eidtRealTree(id){
		$.ajax({
			url:'/esf/MenuResourceAction_loadTreeByPositionid.jspx?position.positionid=' + id,
			type: 'get', dataType:'html', cache: false, async:false,
			error: function(xhr){
				parent.exceptionAlert();
			},
			success: function(data){
				var r = eval('(' + data + ')');	
				var dr = r.positionResource;
				var d = r.position;
				menuTree(dr,d);
			}
		});
	}
	//加载职务信息
	function eidtRealPosition(id){
		$.ajax({
			url:'/esf/MenuResourceAction_loadPositionByPositionid.jspx?position.positionid=' + id,
			type: 'get', dataType:'html', cache: false, async:false,
			error: function(xhr){
				parent.exceptionAlert();
			},
			success: function(data){
				var r = eval('(' + data + ')');	
				var rdl = r.resourceDepartmentList;
				var p = r.position;
				createPosition(p,rdl,true);
			}
		});
	}
	//加载职务表单
	function createPosition(position,departmentList,flag){
		$('#positionDialog').remove();//删除存在的
		var str = "'";
		for(var i = 0;i< departmentList.length;i++){
			if(departmentList[i].departmentid == position.departmentid){
				str = str + "<option value='"+ departmentList[i].departmentid+"' selected>"+ departmentList[i].departmentname+"</option>" ;
			}
			else{
				str = str + "<option value='"+ departmentList[i].departmentid+"'>"+ departmentList[i].departmentname+"</option>" ;
			}
		}
		str = str + "'";
		$('body').append('<div id="positionDialog" title="职务编辑"><form id="positionform" name="positionform"><table border="0" cellpadding="3" cellspacing="0">' 
				+ '<tr><td with="150">所属部门：</td><td>'
						+ '<select name="position.departmentid">'
						+ str
						+ '</select>'	
				+ '</td></tr>' 
				+ '<tr><td with="150">职务名称：</td><td><input name="position.positionname" id="position_positionname" value="' + position.positionname + '" class="input_m"/></td></tr>' 
				+ '<input name="position.positionid" id="position_positionid" type="hidden" value="' + position.positionid + '"/> ' 
				+ '</table></form></div>');
		$("#positionDialog").dialog({
			bgiframe: true,
			height: 250,
			width:400,
			modal: true,
			resizable:false,
			draggable: false,
			buttons: {
				"取消": function(){
					$('#positionDialog').dialog('close');
				},
				'保存': function() {
					$('#positionDialog').dialog('close');
					if($("#position_positionname").val() == null || $("#position_positionname").val() == ""){
						parent.showAlert("操作失败，请输入正确职务名称！", "alert");
						createPosition(position,departmentList,flag);
					}
					else{
						if(flag){
							var saveOptions={
								target: '#positionform',
								url:"/esf/MenuResourceAction_savePosition.jspx", type: 'post', dataType: 'html', cache:false, async:false,
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
						$('#positionform').ajaxSubmit(saveOptions);
					}
				}
			}
		});
	}
	//加载职务权限表单
	function menuTree(dr,position){
		$('#treeDialog').remove();//删除存在的
		$('body').append('<div id="treeDialog" title="职务权限栏目"><div id="treeMenu" class="ztree"></div> '
			+ '<form id="menuTreeForm" name="menuTreeForm"><table border="0" cellpadding="3" cellspacing="0">' 
			+ '<input name="position.positionid" id="position_positionid" type="hidden" value="' + position.positionid + '"/> ' 
			+ '<input name="position.resourceids" id="position_resourceids" type="hidden" value="%{position.resourceids}" />'
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
						menuTree(dr,position);
					}
					else{
						$('#menuTreeForm #position_resourceids').val(resourceids);
						var saveOptions = {
							target: '#menuTreeForm',
							url:"/esf/MenuResourceAction_savePositionResource.jspx", type: 'post', dataType: 'html', cache:false, async:false,
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
	
    //新增、编辑
	function edit(positionid){
		window.location.href = "/esf/MenuResourceAction_toPositionInfo.jspx?position.positionid=" + positionid;
	}
	//删除
	function remove(id){
		parent.initConfirm('您确定要删除该职务吗？');
		parent.$("#confirmDialog").dialog({
			bgiframe: true,height: 150,modal: true,	resizable:false,draggable: false,
			buttons: {
				"取消": function(){
					parent.$('#confirmDialog').dialog('close');
				},
				'确定': function() {
					parent.$('#confirmDialog').dialog('close');
					$.ajax({
						url:'/esf/MenuResourceAction_deletePosition.jspx?position.positionid=' + id,
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
	<div class="txt_title">职务资源 &gt; 职务列表 </div>
	<!-- 工具栏 -->
	<div class="toolbg toolbgline toolheight nowrap">
		<!-- 按钮 -->
		<div id="toolbarbtn" class="right">
			<input type="button" class="wd1 btn" value="查询" onclick="javascript:searchFlex();" />
			<input type="button" class="wd1 btn" value="新增" onclick="javascript:eidtRealPosition('');" />
		</div>
		<!-- 查找 -->
		<div id="toolbarlist" class="nowrap left">
			关键字 <input type="text" id="keywords" name="keywords" onkeypress="if(event.keyCode==13) searchFlex();" class="input_s"/>
			<s:hidden name="page" value="%{page}"/>
		</div>
		<div class="clr">&nbsp;</div>
	</div> 
	<table id="grid" style="display: none;"></table>
  </body>
</html>