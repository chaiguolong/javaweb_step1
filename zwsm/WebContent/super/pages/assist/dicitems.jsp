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
		<script type="text/javascript" src="/super/common/datePicker/WdatePicker.js"></script>
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
			window.location.href = "/esf/DicAction_toItemsListBack.jspx?page=" + $('#page').val() + "&dicType.codeid="+$('#codeid').val();
		}

		function checkItemvalueIsOnly(){
			if($('#itemvalueold').val() != $('#dicItems_itemvalue').val()){
				$.ajax({
					url:'/esf/DicAction_checkItemvalueIsOnly.jspx?itemvalue='+$('#dicItems_itemvalue').val() + '&codetype='+$('#codetype').val(),
					type: 'get', dataType:'html', cache: false, async:false,
					error: function(xhr){
						parent.exceptionAlert();
					},
					success: function(data){	
						var r = eval('(' + data + ')');
						if(r.flag){
							$('#dicItems_itemvalue').val('');
							parent.showAlert(r.returnMsg);
						}
					}
				});
			}
		}
		
		//提交保存
		function doSubmit(){
			if($("#infoForm").validationEngine('validate')){
				var saveOptions={
					target: '#infoForm',
					url:"/esf/DicAction_saveItems.jspx", type: 'post', dataType: 'html', cache:false, async:false,
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
					字典管理 &gt; 字典表明细
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
						字典类型编码：
					</div>
					<div class="settingDiv_r">
						<div>						
							<s:hidden name="dicItems.itemid" id="itemid" value="%{dicItems.itemid}" />
							<s:hidden name="dicItems.codeid" id="codeid" value="%{dicType.codeid}" />
							<s:hidden name="dicItems.codetype" id="codetype" value="%{dicType.codetype}" />
							<s:hidden name="page" value="%{page}" />
							<s:property	value="%{dicType.codetype}"/>					
						</div>
					</div>
					
					
					<div class="settingDiv_l">
						名称：
					</div>
					<div class="settingDiv_r">
						<div>
							<s:textfield name="dicItems.itemname" value="%{dicItems.itemname}"
								cssClass="validate[required,maxSize[50]] input_s"  />	
						*						
						</div>					
					</div>
					
					<div class="settingDiv_l">
						值：
					</div>
					<div class="settingDiv_r">
						<div>
						<s:hidden name="itemvalueold" value="%{dicItems.itemvalue}"/>
							<s:textfield name="dicItems.itemvalue"
								value="%{dicItems.itemvalue}"
								cssClass="validate[required,maxSize[250]] input_s" onblur="checkItemvalueIsOnly()"/>
							*
						</div>
					</div>
					
					<div class="settingDiv_l">
						排序：
					</div>
					<div class="settingDiv_r">
						<div>
							<s:textfield name="dicItems.orderid" value="%{dicItems.orderid==null?1:dicItems.orderid}"
								maxLength="4"
								cssClass="validate[required,custom[onlyNumberSp]] input_ssss" />
							*							
						</div>
					</div>
					
					<div class="settingDiv_l">
						是否使用：
					</div>
					<div class="settingDiv_r">
						<div>
							<s:radio name="dicItems.isapply" list="#{'1':'使用','0':'不使用'}"
								listKey="key" listValue="value"
								value="%{dicItems == null || dicItems.isapply ==null ? '1' : dicItems.isapply}" />
						</div>
					</div>
					
					<div class="settingDiv_l">
						是否显示：
					</div>
					<div class="settingDiv_r">
						<div>
							<s:radio name="dicItems.isdisplay" list="#{'1':'显示','0':'不显示'}"
								listKey="key" listValue="value"
								value="%{dicItems == null || dicItems.isdisplay ==null ? '1' : dicItems.isdisplay}" />
						</div>
					</div>
					
					<div class="settingDiv_l">
						是否可以删除：
					</div>
					<div class="settingDiv_r">
						<div>
							<s:radio name="dicItems.isdelete" list="#{'1':'可删除','0':'不可删除'}"
								listKey="key" listValue="value"
								value="%{dicItems == null || dicItems.isdelete ==null ? '0' : dicItems.isdelete}" />
						</div>
					</div>
					 
					
					
					<div class="settingDiv_l">
						备注：
					</div>
					<div class="settingDiv_r">
						<div>
							<s:textarea name="dicItems.codermk" value="%{dicItems.codermk}"
								cssClass="validate[maxSize[250]] textarea_ms" />
						</div>
					</div>
					
				</div>
			</div>
		</form>
	</body>
</html>
