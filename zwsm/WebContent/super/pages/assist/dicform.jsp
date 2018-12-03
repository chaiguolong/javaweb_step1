<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
		<title>明细</title>
		<meta http-equiv="pragma" content="no-cache"> 
		<meta http-equiv="Cache-Control" content="no-cache, must-revalidate"> 
		<link rel="stylesheet" type="text/css" href="/super/css/style.css" />
		<link rel="stylesheet" type="text/css"
			href="/super/css/images/simple/getcss.css" />
		<link rel="stylesheet" type="text/css" href="/super/css/formInfo.css" />
		<link rel="stylesheet" type="text/css"
			href="/super/common/formValidator/validationEngine.jquery.css" />
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
		
		//返回
		function doback(){
			window.location.href = "/esf/DicAction_toList.jspx?page=" + $('#page').val();
		}
		
		//提交保存
		function doSubmit(){
			if($("#infoForm").validationEngine('validate')){
				var saveOptions={
						target: '#infoForm',
						url:"/esf/DicAction_save.jspx", type: 'post', dataType: 'html', cache:false, async:false,
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

		//判断dicType.codetype是否唯一
		function checkDicTypeIsOnly(){		
			if($('#codetypeold').val() != $('#codetype').val()){
				$.ajax({
					url:'/esf/DicAction_checkDicType.jspx?codetype='+$('#codetype').val(),
					type: 'get', dataType:'html', cache: false, async:false,
					error: function(xhr){
						parent.exceptionAlert();
					},
					success: function(data){	
						var r = eval('(' + data + ')');
						if(r.flag){
							$('#codetype').val('');
							parent.showAlert(r.returnMsg);
						}
					}
				});
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
					字典类型管理 &gt; 字典类型表明细
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
						类型编码：
					</div>
					<div class="settingDiv_r">
						<div>
							<s:hidden name="dicType.codeid" id="codeid" value="%{dicType.codeid}" />
							<s:hidden name="page" value="%{page}" />
							<s:hidden name="codetypeold" id="codetypeold" value="%{dicType.codetype}"/>
							<s:textfield name="dicType.codetype" id="codetype"
								value="%{dicType.codetype}"
								cssClass="validate[required,maxSize[50]] input_l" readonly="true"/>
							*
						</div>
					</div>
					
					<div class="settingDiv_l">
						类型名称：
					</div>
					<div class="settingDiv_r">
						<div>
							<s:textfield name="dicType.codename"
								value="%{dicType.codename}"
								cssClass="validate[required,maxSize[50]] input_m" />
							*
						</div>
					</div>
					
					<div class="settingDiv_l">
						排序：
					</div>
					<div class="settingDiv_r">
						<div>
							<s:textfield name="dicType.orderid" value="%{dicType.orderid==null?1:dicType.orderid}"
								maxLength="2"
								cssClass="validate[required,custom[onlyNumberSp]] input_ssss" />
							*
						</div>
					</div>
					
					<div class="settingDiv_l">
						备注：
					</div>
					<div class="settingDiv_r">
						<div>
							<s:textarea name="dicType.codermk" value="%{dicType.codermk}"
								cssClass="validate[maxSize[250]] textarea_ms" />
						</div>
					</div>
				</div>
			</div>
		</form>
	</body>
</html>
