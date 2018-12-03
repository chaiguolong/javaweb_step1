<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
		<title>设置新密码</title>
		<meta http-equiv="pragma" content="no-cache"> 
		<meta http-equiv="Cache-Control" content="no-cache, must-revalidate"> 
		<link rel="stylesheet" type="text/css" href="/super/css/style.css" />
		<link rel="stylesheet" type="text/css" href="/super/css/images/simple/getcss.css" />
		<link rel="stylesheet" type="text/css" href="/super/css/formInfo.css" />
		<link rel="stylesheet" type="text/css" href="/super/common/formValidator/validationEngine.jquery.css" />
		<style type="text/css">
		html {
			overflow-y: auto;
		}		
		.tbody {
			overflow-x: hidden;
		}
		</style>
		<script type="text/javascript" src="/super/js/jquery-1.7.2.min.js"></script>
		<script type="text/javascript" src="/super/js/jquery.form.js"></script>
		<script type="text/javascript" src="/super/js/commpage.js"></script>
		<script type="text/javascript" src="/super/common/formValidator/jquery.validationEngine-reg.js"></script>
		<script type="text/javascript" src="/super/common/formValidator/jquery.validationEngine.js"></script>
		<script type="text/javascript">
		$(document).ready(function(){
			$("#infoForm").validationEngine();
		});

		//提交保存
		function doSubmit(){
			if($("#infoForm").validationEngine('validate')){
				var saveOptions={
					target: '#infoForm',
					url:"/super/Framework_savePassword.jspx", type: 'post', dataType: 'html', cache:false, async:false,
					beforeSubmit:function(formArray, jqForm){
					},
					error:function(xhr){
						parent.exceptionAlert();
					},
					success: function(data) {
						var r = eval('(' + data + ')');	
						if(r.flag){
							parent.showAlert(r.returnMsg, "success");
							$('#oldpwd, #loginpwd, #loginpwdcheck').val('');
						}
						else {
							parent.showAlert(r.returnMsg, "alert");
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
				<input type="button" class="wd1 btn" value="保存" onclick="javascript:doSubmit();" />
			</div>
			<!-- 页面信息 -->
			<div class="nowrap left">
				<div class="txt_title_nosearch">
					系统管理 &gt; 设置密码
				</div>
			</div>
			<div class="clr">
				&nbsp;
			</div>
		</div>
		<form id="infoForm" name="infoForm">
			<div class="settingtable">
				<div class="settingtd settingDiv no_bt no_bb">
					<div class="settingDiv_l">账&nbsp;&nbsp;号：</div> 
					<div class="settingDiv_r"> 
						<div>
							${sysAccount.loginuser}
						</div>
					</div> 
					<div class="settingDiv_l">旧密码：</div> 
					<div class="settingDiv_r"> 
						<div>
							<input type="password" name="oldpwd" id="oldpwd" class="validate[required,custom[onlyLetterNumber],minSize[6],maxSize[15]] input_s"/> *
						</div>
						<div class="set_pos addrtitle">(输入旧密码，确认你的身份。)</div>
					</div> 
					<div class="settingDiv_l">新密码：</div> 
					<div class="settingDiv_r"> 
						<div>
							<input type="password" name="loginpwd" id="loginpwd" class="validate[required,custom[onlyLetterNumber],minSize[6],maxSize[15]] input_s"/> *
						</div>
						<div class="set_pos addrtitle">(输入新密码。)</div>
					</div> 
					<div class="settingDiv_l">确认密码：</div> 
					<div class="settingDiv_r">
						<div>
							<input type="password" name="loginpwdcheck" id="loginpwdcheck" class="validate[required,custom[onlyLetterNumber],minSize[6],maxSize[15]] input_s"/> *
							<input type="hidden" name="loginuser" value="${sysAccount.loginuser}"/>
						</div>
						<div class="set_pos addrtitle">(再次确认你输入的新密码。)</div>
					</div> 
				</div>
			</div>
		</form>
	</body>
</html>
