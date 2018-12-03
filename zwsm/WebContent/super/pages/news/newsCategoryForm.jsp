<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
		<title>资讯栏目明细</title>
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
		
		//返回
		function doback(){
			window.location.href = "/esf/NewsCategory_toTypeList.jspx?page=" + $('#page').val();
		}
		
		//提交保存
		function doSubmit(){
			if($("#infoForm").validationEngine('validate')){
				var saveOptions={
					target: '#infoForm',
					url:"/esf/NewsCategory_saveType.jspx", type: 'post', dataType: 'html', cache:false, async:false,
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
					资讯中心 &gt; 资讯栏目详情
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
						上级栏目：
					</div>
					<div class="settingDiv_r">
						<div>						
							<s:hidden name="newsCategory.categoryid" value="%{newsCategory.categoryid}" />
							<s:hidden name="page" value="%{page}" />
							<s:select name="newsCategory.pid" cssClass="validate[required]" 
							list="#request.newsCategoryList" headerKey="" headerValue="请选择..." 
							listKey="categoryid" listValue="typenamelevel+name" value="%{newsCategory.pid}">
							</s:select>
							*					
						</div>
					</div>
					<div class="settingDiv_l">
						栏目名称：
					</div>
					<div class="settingDiv_r">
						<div>
							<s:textfield name="newsCategory.name" value="%{newsCategory.name}" 
								cssClass="validate[required,maxSize[25]] input_l"  />	
						*						
						</div>					
					</div>
					
					<div class="settingDiv_l">
						排序：
					</div>
					<div class="settingDiv_r">
						<div>
							<s:textfield name="newsCategory.sortnumber" value="%{newsCategory.sortnumber==null?1:newsCategory.sortnumber}"
								maxLength="2"
								cssClass="validate[required,custom[onlyNumberSp],maxSize[2]] input_ssss" />
							*							
						</div>
					</div>
					
					<div class="settingDiv_l">
						是否显示：
					</div>
					<div class="settingDiv_r">
						<div>
							<s:radio name="newsCategory.isdisplay" list="#{'1':'显示','0':'不显示'}"
								listKey="key" listValue="value"
								value="%{newsCategory == null || newsCategory.isdisplay ==null ? '1' : newsCategory.isdisplay}" />
						</div>
					</div>
					
					<div class="settingDiv_l">
						是否单页：
					</div>
					<div class="settingDiv_r">
						<div>
							<s:radio name="newsCategory.issingle" list="#{'1':'单页','0':'非单页'}"
								listKey="key" listValue="value"
								value="%{newsCategory == null || newsCategory.issingle ==null ? '0' : newsCategory.issingle}" />
						</div>
					</div>
					
					<div class="settingDiv_l">
						跳转链接：
					</div>
					<div class="settingDiv_r">
						<div>
							<s:textfield name="newsCategory.url" value="%{newsCategory.url}" 
								cssClass="validate[maxSize[100]] input_l"  />	
						</div>					
					</div>
					
					<div class="settingDiv_l">
						备注：
					</div>
					<div class="settingDiv_r">
						<div>
							<s:textarea name="newsCategory.reamrk" value="%{newsCategory.reamrk}"
								cssClass="validate[maxSize[250]] textarea_ms" />
						</div>
					</div>
				</div>
			</div>
		</form>
	</body>
</html>
