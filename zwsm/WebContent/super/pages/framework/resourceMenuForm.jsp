<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
		<title>资源菜单明细</title>
		<meta http-equiv="pragma" content="no-cache"> 
		<meta http-equiv="Cache-Control" content="no-cache, must-revalidate"> 
		<link rel="stylesheet" type="text/css" href="/super/css/style.css" />
		<link rel="stylesheet" type="text/css" href="/super/css/images/simple/getcss.css" />
		<link rel="stylesheet" type="text/css" href="/super/css/formInfo.css" />
		<link rel="stylesheet" type="text/css" href="/super/common/formValidator/validationEngine.jquery.css" />
		<link rel="stylesheet" type="text/css" href="/super/common/flexigrid/css/flexigrid.css" />
		<style type="text/css">
		html {
			overflow-y: auto;
		}		
		.tbody {
			overflow-x: hidden;
		}
		</style>
		<script type="text/javascript" src="/super/js/jquery-1.7.2.min.js"></script>
		<script type="text/javascript" src="/super/common/flexigrid/flexigrid.js"></script>
		<script type="text/javascript" src="/super/js/jquery.form.js"></script>
		<script type="text/javascript" src="/super/js/commpage.js"></script>
		<script type="text/javascript" src="/super/common/formValidator/jquery.validationEngine-reg.js"></script>
		<script type="text/javascript" src="/super/common/formValidator/jquery.validationEngine.js"></script>
		<script type="text/javascript">

		$(document).ready(function(){
			$("#infoForm").validationEngine();
		});
		
		//返回
		function doback(){
			window.location.href = "/esf/MenuResourceAction_toTypeList.jspx?page=" + $('#page').val();
		}
		
		//提交保存
		function doSubmit(){
			if($("#infoForm").validationEngine('validate')){
				var saveOptions={
					target: '#infoForm',
					url:"/esf/MenuResourceAction_saveType.jspx", type: 'post', dataType: 'html', cache:false, async:false,
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
				$('#infoForm').ajaxSubmit(saveOptions);
			}
		}
		
		//设置页面toolbar长度
		window.onload = window.onresize = GetForContentWidth;
		</script>
	</head>
	<body class="tbody">
		<!-- 工具栏 -->
		<div class="toolbg toolbgline toolheight nowrap" id="forContentWidth"
			style="position: fixed;">
			<!-- 按钮 -->
			<div class="right">
				<input type="button" class="wd1 btn" value="返回"
					onclick="javascript:doback();" />
				<input type="button" class="wd1 btn" value="保存"
					onclick="javascript:doSubmit();" />
			</div>
			<!-- 页面信息 -->
			<div class="nowrap left">
				<div class="txt_title_nosearch">
					资源中心 &gt; 菜单栏目详情
				</div>
			</div>
			<div class="clr">
				&nbsp;
			</div>
		</div>
		<form id="infoForm" name="infoForm">
			<div class="settingtable">
				<div class="settingtd settingDiv no_bt no_bb">
					<div class="settingDiv_l">
						上级菜单：
					</div>
					<div class="settingDiv_r">
						<div>						
							<s:hidden name="resource.ismenu" value="%{1}" />
							<s:hidden name="menu.menuid" value="%{menu.menuid}" />
							<s:hidden name="resource.resourceid" value="%{menu.resourceid}" />
							<s:hidden name="resource.type" value="功能菜单" />
							<s:hidden name="page" value="%{page}" />
							<s:select name="menu.pid" 
							list="#request.resourceMenuList" headerKey="" headerValue="请选择..." cssClass="validate[required]"
							listKey="menuid" listValue="typenamelevel+menuname" value="%{menu.pid}">
							</s:select>				
						</div>
					</div>
					
					<div class="settingDiv_l">
						菜单名称：
					</div>
					<div class="settingDiv_r">
						<div>
							<s:textfield name="menu.menuname" value="%{menu.menuname}" 
								cssClass="validate[required,maxSize[100]] input_l"  />						
						</div>					
					</div>
					
					<div class="settingDiv_l">
						资源地址：
					</div>
					<div class="settingDiv_r">
						<div>
							<s:textfield name="resource.definestring" value="%{resource.definestring}" 
								cssClass="validate[required,maxSize[250]] input_l"  />						
						</div>					
					</div>
					
					<div class="settingDiv_l">
						资源描述：
					</div>
					<div class="settingDiv_r">
						<div>
							<s:textfield name="resource.remark" value="%{resource.remark}" 
								cssClass="validate[maxSize[250]] input_l"  />						
						</div>					
					</div>
					
					<div class="settingDiv_l">
						是否启用：
					</div>
					<div class="settingDiv_r">
						<div>
							<s:radio name="resource.isuse" list="#{'1':'启用','0':'不启用'}"
								listKey="key" listValue="value"
								value="%{menu == null || menu.isuse ==null ? '1' : resource.isuse}" />
						</div>
					</div>
					
					<div class="settingDiv_l">
						排序：
					</div>
					<div class="settingDiv_r">
						<div>
							<s:textfield name="menu.sortnumber" value="%{menu.sortnumber==null?1:menu.sortnumber}"
								maxLength="2"
								cssClass="validate[required,custom[onlyNumberSp],maxSize[7]] input_ssss" />	
							说明：按从大到小排序					
						</div>
					</div>
				</div>
			</div>
		</form>
	</body>
</html>