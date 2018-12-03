<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
		<title>三门房产政务网管理平台</title>
		<link rel="stylesheet" type="text/css" href="/super/common/formValidator/validationEngine.jquery.css" />
		<link rel="stylesheet" type="text/css" href="/super/common/jqueryUi/css/ui.all.css" />
		<script type="text/javascript" src="/super/js/jquery-1.7.2.min.js"></script>
		<script type="text/javascript" src="/super/js/jquery.form.js"></script>
		<script type="text/javascript" src="/super/js/comm.js"></script>
		<script type="text/javascript" src="/super/common/formValidator/jquery.validationEngine-reg.js"></script>
		<script type="text/javascript" src="/super/common/formValidator/jquery.validationEngine.js"></script>
		<script type="text/javascript" src="/super/common/jqueryUi/jquery-ui-1.7.2.min.js"></script>
		<script type="text/javascript" src="/super/js/jquery.cookie.js"></script>
		<script language="javascript" type="text/javascript">
			var COOKIE_SUPER_LOGIN_NAME = "super_login_name";
			$(document).ready(function() {
				if ($.cookie(COOKIE_SUPER_LOGIN_NAME)) {
					$('#loginFrom #loginname').val($.cookie(COOKIE_SUPER_LOGIN_NAME));
				}
				$("#loginFrom").validationEngine();
			});
		
			function doLogin() {
				if ($("#loginFrom").validationEngine('validate')) {
					var submitOptions = {
						target : '#loginFrom',
						url : "/super/Framework_doLogin.jspx",
						type : 'post',
						dataType : 'html',
						cache : false,
						async : false,
						error : function(xhr) {
							exceptionAlert();
						},
						success : function(data) {
							var r = eval('(' + data + ')');
							if (r.flag) {
								$.cookie(COOKIE_SUPER_LOGIN_NAME, $(
										'#loginFrom #loginname').val(), {
									expires : 3
								});
								window.location.href = "/super/Framework_checkLogin.jspx";
							} else {
								refleshcode();
								showAlert(r.returnMsg, 'failure');
							}
						}
					}
					$('#loginFrom').ajaxSubmit(submitOptions);
				}
			}

			function refleshcode(){
				$('#codeimg').attr('src', '/super/pages/login/image.jsp?_time=' + new Date());	
			}
		</script>
		<style type="text/css">
			body { margin:0 auto; padding:0; font-size:12px; color:#000;font:"宋体";}
			div,dt,dd,dl,li,ul,table,p { margin:0; padding:0;}
			li { list-style-type:none; margin:0; padding:0;}
			a:link {color: #666; text-decoration:none;}
			a:visited {color: #666;text-decoration:none;}
			a:hover {color: #f60; text-decoration:underline;}
			a:active {color: #666;}
			img{ border:0}
			.hg { width:950px; height:7px;}
			input {
				font-family: 'Verdana';
			}
			.text {
				padding: 3px;
				outline: none;
				line-height: 14px;
				font-size: 12px;
				color: #333;
				border: 1px solid #ccc;
				border-radius: 3px;
				overflow: hidden;
			}
			
			.text:hover,.text:focus {
				border-color: #7DBDE2;
				box-shadow: 0 0 5px #7dbde2;
			}
			.conted_cwy01{margin: 0 auto; width:920px; height:350px; overflow:hidden; padding:15px; line-height:22px; background: url(/super/css/images/comm/tp.jpg) no-repeat left;}
			.conted_cwy02{width:340px; height:250px; border:1px solid #ebebeb; margin:50px  auto  auto 450px; background:url(/super/css/images/comm/ldy_dl02.jpg) repeat ;}
			.wd00{ height:15px; padding-top:8px; font-size: 14px; color: #000; font-weight: bold; letter-spacing:3px; text-indent: 30px;}
			.wd01{ height:15px; padding-top:5px; color: #666666; }
			.wd02{ height:20px; padding-top:10px; }
			.k01 a   { width:86px; height:27px; background: url(/super/css/images/comm/ldy_dl04.jpg) no-repeat; float:left; border:0; font-size: 14px; font-weight: bold; color: #FFF; text-align: center; padding-top:2px; }
			.k01 a:link   { width:86px; height:27px; background: url(/super/css/images/comm/ldy_dl04.jpg) no-repeat; float:left; border:0; font-size: 14px; font-weight: bold; color: #FFF; }
			.k01 a:visited { width:86px; height:27px; background: url(/super/css/images/comm/ldy_dl03.jpg) no-repeat; float:left; border:0; font-size: 14px; font-weight: bold; color: #FFF; }
			.k01 a:hover{ width:86px; height:27px; background: url(/super/css/images/comm/ldy_dl03.jpg) no-repeat; float:left; border:0; font-size: 14px; font-weight: bold; color: #FFF; text-decoration:none;}
			.k01 a:active { width:86px; height:27px; background: url(/super/css/images/comm/ldy_dl04.jpg) no-repeat; float:left; border:0; font-size: 14px; font-weight: bold; color: #FFF; }
					
			#j_logo { width:950px; height:auto; overflow:hidden; margin: 0 auto;}
			#j_logo p{ width:438px; height:72px; overflow:hidden; margin-top:10px; margin-bottom:20px; float:left}
			#j_logo p a { width:438px; height:72px; background:url(/super/css/images/comm/logo2.jpg) no-repeat left center; float:left}
			#j_logo h1 { width:412px; height:72px;  display:none; } 
			
			.j_foot {margin: 0 auto; width:950px; height:auto; overflow:hidden; padding:10px 0px; background:#fff; text-align:center; line-height:25px; margin-top:10px; color:#666; border-top:1px solid #d7d7d7;}
		</style>
	</head>
	<div id="j_logo">
		<p><a target="_blank" href="/"><h1>透明售房网</h1></a></p>
	</div>
	<div class="conted_cwy01">
		<div class="conted_cwy02">
		<form id="loginFrom" name="loginFrom" onkeydown="javascript:if(event.keyCode==13) doLogin();">
			<table width="95%" border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td colspan="2" class="wd00">
						管理员登录
					</td>
					<td width="18%">
						&nbsp;
					</td>
				</tr>
				<tr>
					<td width="21%">
						&nbsp;
					</td>
					<td width="61%" class="wd01">
						账号：
					</td>
					<td>
						&nbsp;
					</td>
				</tr>
				<tr>
					<td>
						&nbsp;
					</td>
					<td>
						<input id="loginname" name="loginname" type="text" class="validate[required,custom[onlyLetterNumber]] text" maxlength="15"/>
					</td>
					<td>
						&nbsp;
					</td>
				</tr>
				<tr>
					<td>
						&nbsp;
					</td>
					<td class="wd01">
						密 码：
					</td>
					<td>
						&nbsp;
					</td>
				</tr>
				<tr>
					<td>
						&nbsp;
					</td>
					<td>
						<input id="loginpwd" name="loginpwd" type="password" class="validate[required,maxSize[15],custom[onlyLetterNumber]] text" maxlength="15"/>
					</td>
					<td>
						&nbsp;
					</td>
				</tr>
				<tr>
					<td>
						&nbsp;
					</td>
					<td class="wd01">
						验证码：
					</td>
					<td>
						&nbsp;
					</td>
				</tr>
				<tr>
					<td height="30">
						&nbsp;
					</td>
					<td valign="middle" colspan="2">
						<input id="checkCode" name="checkCode" type="text" size="4" maxlength="4" class="validate[required,custom[onlyNumberSp],maxSize[4],min[0]] text"/>
						<img id="codeimg" src="/super/pages/login/image.jsp" style="cursor:pointer;border:1px solid #e4eef9;" align="top"/>
						<a href="javascript:refleshcode();">看不清楚？换张图片</a>
					</td>
				</tr>
				<tr>
					<td height="42">
						&nbsp;
					</td>
					<td>
						<div class="k01">
							<a href="javascript:doLogin();">登录</a>
						</div>
					</td>
					<td>
						&nbsp;
					</td>
				</tr>
				<tr>
					<td>
						&nbsp;
					</td>
					<td>
						&nbsp;
					</td>
					<td>
						&nbsp;
					</td>
				</tr>
			</table>
			</form>
		</div>
	</div>
	<div class="hg"></div>
	<div class="j_foot">
		本网站房产市场信息数据来源于三门房产信息网 Copyright 2001-2013 杭州中房信息科技有限公司版权所有
	</div>