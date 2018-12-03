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
		<title>投诉管理明细明细</title>
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
		<script type="text/javascript" src="/super/common/datePicker/WdatePicker.js"></script>
		<script type="text/javascript" src="/super/js/jquery-1.7.2.min.js"></script>
		<script type="text/javascript" src="/super/common/flexigrid/flexigrid.js"></script>
		<script type="text/javascript" src="/super/js/jquery.form.js"></script>
		<script type="text/javascript" src="/super/js/commpage.js"></script>
		<script type="text/javascript" src="/super/common/formValidator/jquery.validationEngine-reg.js"></script>
		<script type="text/javascript" src="/super/common/formValidator/jquery.validationEngine.js"></script>
		<script type="text/javascript">

		$(document).ready(function(){
			$("#infoForm").validationEngine();
			$("#complaint_addtime").bind("click",function(){
				WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd HH:mm:ss'});
			});
			$("#complaint_replytime").bind("click",function(){
				WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd HH:mm:ss'});
			});
		});
		
		//返回
		function doback(){
			window.location.href = "/esf/ComplaintAction_toCateList.jspx?page=" + $('#page').val();
		}
		
		//提交保存
		function doSubmit(){
			if($("#infoForm").validationEngine('validate')){
				if($("#complaint_replycontent").val() == null || $.trim($("#complaint_replycontent").val()) == ""){
					$("#complaint_state").val(0);
					$("#complaint_replyname").val("");
					$("#complaint_replytime").val("");
				}
				else{
					$("#complaint_state").val(1);
				}
				var saveOptions={
					target: '#infoForm',
					url:"/esf/ComplaintAction_saveType.jspx", type: 'post', dataType: 'html', cache:false, async:false,
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
					投诉管理 &gt; 投诉管理明细
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
						投诉人：
					</div>
					<div class="settingDiv_r">
						<div>
							<s:hidden name="page" value="%{page}" />
							<s:hidden name="complaint.complaintid" value="%{complaint.complaintid}" />
							<s:hidden name="complaint.state" value="%{complaint.state}" />
							<s:hidden name="complaint.replyname" value="%{complaint.replyname}" />
							<s:property value="%{complaint.complaintname}" />&nbsp;
						</div>
					</div>
					<div class="settingDiv_l">
						联系电话：
					</div>
					<div class="settingDiv_r">
						<div>
							<s:property value="%{complaint.telno}" />&nbsp;
						</div>					
					</div>
					<div class="settingDiv_l">
						被投诉开发商：
					</div>
					<div class="settingDiv_r">
						<div>
							<s:property value="%{complaint.developername}" />&nbsp;
						</div>					
					</div>
					<div class="settingDiv_l">
						被投诉楼盘：
					</div>
					<div class="settingDiv_r">
						<div>	
							<s:property value="%{complaint.propertyname}" />&nbsp;
						</div>					
					</div>
					<div class="settingDiv_l">
						投诉事宜：
					</div>
					<div class="settingDiv_r">
						<div>
							<s:property value="%{complaint.infotitle}" />&nbsp;
						</div>					
					</div>
					<div class="settingDiv_l">
						投诉内容：
					</div>
					<div class="settingDiv_r">
						<div>
							<s:textarea name="complaint.infocontent" value="%{complaint.infocontent}" 
								cssClass="validate[maxSize[2000]] textarea_ms"  readonly="true"/>
						</div>					
					</div>
					<div class="settingDiv_l">
						显示状态：
					</div>
					<div class="settingDiv_r">
						<div>
							<s:radio name="complaint.isdisplay" list="#{'1':'显示','0':'不显示'}" listKey="key" 
								listValue="value" value="%{complaint == null || complaint.isdisplay ==null ? '0' : complaint.isdisplay}" />
						</div>					
					</div>
					<div class="settingDiv_l">
						咨询时间：
					</div>
					<div class="settingDiv_r">
						<div>
							<s:textfield name="complaint.addtime" value="%{complaint.addtime}" 
								cssClass="validate[required,maxSize[25]] input_s"  /> *						
						</div>					
					</div>
					<div class="settingDiv_l">
						答复内容：
					</div>
					<div class="settingDiv_r">
						<div>
							<s:textarea name="complaint.replycontent" value="%{complaint.replycontent}" 
								cssClass="validate[maxSize[2000]] textarea_ms"  />
						</div>					
					</div>
					<div class="settingDiv_l">
						答复时间：
					</div>
					<div class="settingDiv_r">
						<div>
							<s:textfield name="complaint.replytime" value="%{complaint == null || 
								complaint.replytime == '' ? complaint.tstime : complaint.replytime}" 
								cssClass="validate[maxSize[25]] input_s"  />						
						</div>					
					</div>
				</div>
			</div>
		</form>
	</body>
</html>