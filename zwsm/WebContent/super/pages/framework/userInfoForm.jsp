<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
		<title>用户账号信息明细</title>
		<meta http-equiv="pragma" content="no-cache"> 
		<meta http-equiv="Cache-Control" content="no-cache, must-revalidate"> 
		<link rel="stylesheet" type="text/css" href="/super/css/style.css" />
		<link rel="stylesheet" type="text/css" href="/super/css/images/simple/getcss.css" />
		<link rel="stylesheet" type="text/css" href="/super/css/formInfo.css" />
		<link rel="stylesheet" type="text/css" href="/super/common/jqueryUi/css/ui.all.css" />
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
	    <script type="text/javascript" src="/super/common/jqueryUi/jquery-ui-1.7.2.min.js"></script>
		<script type="text/javascript" src="/super/common/flexigrid/flexigrid.js"></script>
		<script type="text/javascript" src="/super/js/jquery.form.js"></script>
		<script type="text/javascript" src="/super/js/commpage.js"></script>
		<script type="text/javascript" src="/super/common/formValidator/jquery.validationEngine-reg.js"></script>
		<script type="text/javascript" src="/super/common/formValidator/jquery.validationEngine.js"></script>
		<script type="text/javascript">

		$(document).ready(function(){
			$("#tabs").tabs();
			$("#infoForm").validationEngine();
			//加载已关联信息 
			if($('#userAccount_accountid').val() != ''){
				getLinkedRoleList($('#userAccount_accountid').val());
				getLinkedResourceList($('#userAccount_accountid').val());
			}
			getPosition($('#userDepartment_departmentid').val()); 
		});

		//查找
		function searchFlex(){
			$("#grid").flexReload();
		}

		//返回
		function doback(){
			window.location.href = "/esf/UserInfoAction_toList.jspx?page=" + $('#page').val();
		}
		
		//提交保存
		function doSubmit(){
			$("#tabs").tabs('select', 0);
			if($('#RoleList').html() != ''){
				var list = new Array();
				$('#RoleList option').each(function (){
					list.push($(this).val());
				});
				$('#userAccount_roseList').val(list);
			}
			
			if($('#ResourceList').html() != ''){
				var list = new Array();
				$('#ResourceList option').each(function (){
					list.push($(this).val());
				});
				$('#userAccount_resourceList').val(list);
			}
			
			if($("#infoForm").validationEngine('validate')){	
				var saveOptions={
					target: '#infoForm',
					url:"/esf/UserInfoAction_save.jspx", type: 'post', dataType: 'html', cache:false, async:false,
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
		
		//二级联动查找用户职务
		function getPosition(did){
			$.ajax({
				url:'/esf/UserInfoAction_getPosition.jspx?&departmentid=' + did,
				type: 'get',dataType:'html',cache: false,async: false,
				error: function(xhr){
					exceptionAlert();
				},
				success: function(data){
					var d = eval('(' + data + ')');
					var str = "";
					$('#positionSelect').empty();
					for(var i = 0;i < d.length; i++){
						if($('#userPosition_positionid').val() == d[i].positionid){
							str = str + "<option value ='"+ d[i].positionid + "' selected>" + d[i].positionname + "</option> ";
						}
						else{
							str = str + "<option value ='"+ d[i].positionid + "'>" + d[i].positionname + "</option> ";
						}
					}
					$('#positionSelect').append(str);
				}
			});
		}
		//检测密码_敏感字符（不区分大小写）_可以继续扩展
		function checkSensitive(){	
			var re = /delete|select|find|load|drop|insert|update|get/i;
			if(re.test($('#userAccount_loginpass').val())){
				$('#userAccount_loginpass').val('');
				parent.initConfirm('密码中存在敏感字符，请重新输入！');
				parent.$("#confirmDialog").dialog({
					bgiframe: true,height: 150,modal: true,	resizable:false,draggable: false,
					buttons: {
						'确定': function() {
							parent.$('#confirmDialog').dialog('close');
						}				
					}
				});
			}
		}

		//判断用户名是否唯一
		function checkUsernameIsOnly(){
			if($('#loginuser').val() != $('#userAccount_loginuser').val()){
				$.ajax({
					url:'/esf/UserInfoAction_checkUsername.jspx?loginuser='+$('#userAccount_loginuser').val(),
					type: 'get', dataType:'html', cache: false, async:false,
					error: function(xhr){
						parent.exceptionAlert();
					},
					success: function(data){	
						var r = eval('(' + data + ')');
						if(r.flag){
							$('#userAccount_loginuser').val('');
							parent.showAlert(r.returnMsg);
						}
					}
				});
			}	
		}
		
		//搜索角色信息
		function selectRoleList(){
			$('#searchRoleList').html('');
			var saveOptions={
				target: '#infoForm',
				url:"/esf/UserInfoAction_getRoseList.jspx", type: 'post', dataType: 'html', cache:false, async:false,
				beforeSubmit:function(formArray, jqForm){
				},
				error:function(xhr){
					parent.exceptionAlert();
				},
				success: function(data) {
					if(data != null){
						var d = eval('(' + data + ')');
						for(var i in d){
							var option = $('<option></option');
							$(option).attr('value', d[i].roleid);
							$(option).html(d[i].rolename);
							$('#searchRoleList').append(option);
						}
					}
				}
			};
			$('#infoForm').ajaxSubmit(saveOptions);
		}
		
		//加载已关联角色
		function getLinkedRoleList(id){
			$.ajax({
				url:'/esf/UserInfoAction_getLinkedRoleList.jspx?&accountid=' + id,
				type: 'get',dataType:'html',cache: false,async: false,
				error: function(xhr){
					exceptionAlert();
				},
				success: function(data){	
					if(data != null){
						var d = eval('(' + data + ')');
						for(var i in d){
							var option = $('<option></option');
							$(option).attr('value', d[i].roleid);
							$(option).html(d[i].rolename);
							$('#RoleList').append(option);
						}
					}
				}
			});
		}
		
		function addAllRoleList(){
			$('#searchRoleList option').attr('selected', true);
			addRoleList();
		}

		function addRoleList(){
			$('#searchRoleList option:selected').each(function (){
				var cellInfo = $(this).val();
				var flag = false;
				$('#RoleList option').each(function (){
					if($(this).val() == cellInfo){
						flag = true;
					}
				});
				if(!flag){
					var option = $('<option></option');
					$(option).attr('value', $(this).val());
					$(option).html($(this).html())
					$('#RoleList').append(option);
				}
			});
		}
		
		function removeRoleList(){
			$('#RoleList option:selected').each(function (){
				$(this).remove();
			});
		}

		function removeAllRoleList(){
			$('#RoleList option').each(function (){
				$(this).remove();
			});
		}
		
		//资源关联信息
		function selectResourceList(){
			$('#searchResourceList').html('');
			var saveOptions={
				target: '#infoForm',
				url:"/esf/UserInfoAction_getResourceList.jspx", type: 'post', dataType: 'html', cache:false, async:false,
				beforeSubmit:function(formArray, jqForm){
				},
				error:function(xhr){
					parent.exceptionAlert();
				},
				success: function(data) {
					if(data != null){
						var d = eval('(' + data + ')');
						for(var i in d){
							var option = $('<option></option');
							$(option).attr('value', d[i].resourceid);
							$(option).html(d[i].name);
							$('#searchResourceList').append(option);
						}
					}
				}
			};
			$('#infoForm').ajaxSubmit(saveOptions);
		}
		
		//加载已关联资源信息
		function getLinkedResourceList(id){
			$.ajax({
				url:'/esf/UserInfoAction_getLinkedResourceList.jspx?&accountid=' + id,
				type: 'get',dataType:'html',cache: false,async: false,
				error: function(xhr){
					exceptionAlert();
				},
				success: function(data){	
					if(data != null){
						var d = eval('(' + data + ')');
						for(var i in d){
							var option = $('<option></option');
							$(option).attr('value', d[i].resourceid);
							$(option).html(d[i].name);
							$('#ResourceList').append(option);
						}
					}
				}
			});
		}
		function addAllResourceList(){
			$('#searchResourceList option').attr('selected', true);
			addResourceList();
		}

		function addResourceList(){
			$('#searchResourceList option:selected').each(function (){
				var cellInfo = $(this).val();
				var flag = false;
				$('#ResourceList option').each(function (){
					if($(this).val() == cellInfo){
						flag = true;
					}
				});
				if(!flag){
					var option = $('<option></option');
					$(option).attr('value', $(this).val());
					$(option).html($(this).html())
					$('#ResourceList').append(option);
				}
			});
		}
		
		function removeResourceList(){
			$('#ResourceList option:selected').each(function (){
				$(this).remove();
			});
		}

		function removeAllResourceList(){
			$('#ResourceList option').each(function (){
				$(this).remove();
			});
		}
		
		//加载已关联资源
		
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
					onclick="javascript:doSubmit();"/>
			</div>
			<!-- 页面信息 -->
			<div class="nowrap left">
				<div class="txt_title_nosearch">
					 用户信息相关&gt; 用户账号信息明细
				</div>
			</div>
			<div class="clr">
				&nbsp;
			</div>
		</div>
		<form id="infoForm" name="infoForm">
			<div class="settingtable">
				<div class="settingtd settingDiv no_bt no_bb" style="margin: 0;">
					<div id="tabs">
						<ul>
							<li>
								<a href="#tabs-0">基本信息</a>
							</li>
							<li>
								<a href="#tabs-1">用户角色</a>
							</li>
							<!--
							<li>
								<a href="#tabs-2">用户资源直接关联</a>
							</li>
							-->
						</ul>
						<div id="tabs-0">
							<div class="vBorder addr_line">用户账号信息</div>
							<div id="username_div">
							<div class="settingDiv_l">
								用户名：
							</div>
							<div class="settingDiv_r">
								<div>
									<s:hidden name="userPosition.positionid" value="%{userAccount.positionid}" />
									<s:hidden name="userPosition.userpositionid" value="%{userAccount.userpositionid}" />
									<s:hidden name="userDepartment.userdepartmentid" value="%{userAccount.userdepartmentid}" />
									<s:hidden name="userInfo.userextid" value="%{userInfo.userextid}" />
									<s:hidden name="userAccount.accountid" value="%{userAccount.accountid}" />
									<s:hidden name="loginuser" value="%{userAccount.loginuser}" />
									<s:hidden name="page" value="%{page}" />
									<s:textfield name="userAccount.loginuser"
										value="%{userAccount.loginuser}"
										cssClass="validate[required,maxSize[25],minSize[3],custom[onlyLetterNumber]] input_s" onblur="checkUsernameIsOnly()"/>
									*
								</div>
							</div>
							</div>
					
							<div id="userpwd_div">
								<div class="settingDiv_l" display="none">
									密码：
								</div>
								<div class="settingDiv_r">
									<div>
									<s:if test="%{userAccount.accountid != ''}">
										<s:password name="userAccount.loginpass" value=""
										cssClass="validate[minSize[6],maxSize[25],custom[onlyLetterNumber]] input_s" onblur="checkSensitive($(this.value))"/>
										
									</s:if>
									<s:else>
										<s:password name="userAccount.loginpass"
										cssClass="validate[required,minSize[6],minSize[6],custom[onlyLetterNumber]] input_s" onblur="checkSensitive($(this.value))"/>
										*
									</s:else>
										
									</div>
								</div>
							</div>
							
							<div class="settingDiv_l">
								是否启用：
							</div>
							<div class="settingDiv_r">
								<div>
									<s:radio name="userAccount.isenable" list="#{'1':'启用','0':'屏蔽'}"
										listKey="key" listValue="value"
										value="%{userAccount == null || userAccount.isenable == null ? '1' : userAccount.isenable}" />
								</div>
							</div>
							
							<div class="settingDiv_l">
								部门：
							</div>
							<div class="settingDiv_r">
								<div>
									<s:select name="userDepartment.departmentid" cssClass="validate[required]" 
										list="#request.newsDepartmentList" headerKey="" headerValue="请选择..." 
										listKey="departmentid" listValue="departmentname" value="%{userAccount.departmentid}" onchange="getPosition(this.value);">
									</s:select>
									<select id="positionSelect" name="userDepartment.positionid" value="%{userAccount.positionid}" class="validate[required]" >
									</select>
									*
								</div>
							</div>
							
							<div class="settingDiv_l">
								真实姓名：
							</div>
							<div class="settingDiv_r">
								<div>
									<s:textfield name="userInfo.realname"
										value="%{userAccount.realname}"
										cssClass="validate[maxSize[20]] input_ss" />
								</div>
							</div>
							
							<div class="settingDiv_l">
								性别：
							</div>
							<div class="settingDiv_r">
								<div>
									<s:radio name="userInfo.sex" list="#{'1':'男','0':'女'}"
										listKey="key" listValue="value"
										value="%{userAccount == null || userAccount.sex == null ? '1' : userAccount.sex}" />
								</div>
							</div> 
							
							<div class="settingDiv_l">
								邮件地址：
							</div>
							<div class="settingDiv_r">
								<div>
									<s:textfield name="userInfo.email"
										value="%{userAccount.email}"
										cssClass="validate[maxSize[40],custom[email]] input_m" />
								</div>
							</div>
							
							<div class="settingDiv_l">
								手机号码：
							</div>
							<div class="settingDiv_r">
								<div>
									<s:textfield name="userInfo.mobile"
										value="%{userAccount.mobile}"
										cssClass="validate[custom[onlyNumberSp],maxSize[25],custom[phone]] input_s" />
								</div>
							</div>
							
							<div class="settingDiv_l">
								地址：
							</div>
							<div class="settingDiv_r">
								<div>
									<s:textfield name="userInfo.address"
										value="%{userAccount.address}"
										cssClass="validate[maxSize[70]] input_s" />
								</div>
							</div>
							
							<div class="settingDiv_l">
								邮编：
							</div>
							<div class="settingDiv_r">
								<div>
									<s:textfield name="userInfo.postcode"
										value="%{userAccount.postcode}"
										cssClass="validate[maxSize[15],custom[onlyNumberSp]] input_s" />
								</div>
							</div>
							
							<div class="settingDiv_l">
								备注：
							</div>
							<div class="settingDiv_r">
								<div>
									<s:textarea name="userInfo.remark"
										value="%{userAccount.remark}"
										cssClass="validate[maxSize[300]] textarea_ms" />
								</div>
							</div>
							
							<div class="settingDiv_l">
								&nbsp;
							</div>
							<div class="settingDiv_r">
								<table id="grid" style="display: none;"></table>
							</div>		
						</div>
					
						<div id="tabs-1">
							<div class="settingDiv_l">
								用户角色：
							</div>
							<div class="settingDiv_r">
								<div>
									<s:textfield id="keyword" name="keyword" cssClass="input_s"></s:textfield>
									<input type="button" value="查询角色" class="wd2 btn" onclick="javascript:selectRoleList();"/>
								</div>
								<div class="set_pos addrtitle">
									<table cellpadding="0" cellspacing="0" border="0">
										<tr>
											<td><select id="searchRoleList" name="searchRoleList" size="20" style="width: 250px; height:210px;" multiple="multiple"></select></td>
											<td width="50">
												<table cellpadding="5" cellspacing="0" border="0" width="100%">
													<tr>
														<td align="center"><span style="vertical-align: top;cursor: pointer;" onclick="addAllRoleList();">[全加]</span></td>
													</tr>
													<tr>
														<td align="center"><span style="vertical-align: top;cursor: pointer;" onclick="addRoleList();">[&gt;&gt;]</span></td>
													</tr>
													<tr>
														<td align="center"><span style="vertical-align: top;cursor: pointer;" onclick="removeRoleList();">[&lt;&lt;]</span></td>
													</tr>
													<tr>
														<td align="center"><span style="vertical-align: top;cursor: pointer;" onclick="removeAllRoleList();">[全删]</span></td>
													</tr>
												</table>
											</td>
											<td><select id="RoleList" name="RoleList" size="20" style="width: 250px; height:210px;" multiple="multiple"></select></td>
										</tr>
										<tr>
											<td align="center">角色搜索结果</td>
											<td>&nbsp;</td>
											<td align="center">已关联角色</td>
										</tr>
									</table>
									<s:hidden name="userAccount.roseList" value=""/>
								</div>
							</div>
						</div>
						
						<div id="tabs-2" style="display:none;">
							<div class="settingDiv_l">
								用户资源直接关联：
							</div>
							<div class="settingDiv_r">
								<div>
									<s:textfield id="keywords" name="keywords" cssClass="input_s"></s:textfield>
									<input type="button" value="查询资源" class="wd2 btn" onclick="javascript:selectResourceList();"/>
								</div>
								<div class="set_pos addrtitle">
									<table cellpadding="0" cellspacing="0" border="0">
										<tr>
											<td><select id="searchResourceList" name="searchResourceList" size="20" style="width: 250px; height:210px;" multiple="multiple"></select></td>
											<td width="50">
												<table cellpadding="5" cellspacing="0" border="0" width="100%">
													<tr>
														<td align="center"><span style="vertical-align: top;cursor: pointer;" onclick="addAllResourceList();">[全加]</span></td>
													</tr>
													<tr>
														<td align="center"><span style="vertical-align: top;cursor: pointer;" onclick="addResourceList();">[&gt;&gt;]</span></td>
													</tr>
													<tr>
														<td align="center"><span style="vertical-align: top;cursor: pointer;" onclick="removeResourceList();">[&lt;&lt;]</span></td>
													</tr>
													<tr>
														<td align="center"><span style="vertical-align: top;cursor: pointer;" onclick="removeAllResourceList();">[全删]</span></td>
													</tr>
												</table>
											</td>
											<td><select id="ResourceList" name="ResourceList" size="20" style="width: 250px; height:210px;" multiple="multiple"></select></td>
										</tr>
										<tr>
											<td align="center">资源搜索结果</td>
											<td>&nbsp;</td>
											<td align="center">已关联资源</td>
										</tr>
									</table>
									<s:hidden name="userAccount.resourceList" value=""/>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</form>
	</body>
</html>

