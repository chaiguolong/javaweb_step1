<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>发布投诉_投诉咨询_台州市三门县房地产管理处</title>
<jsp:include page="/head_include.jsp" />
<script type="text/javascript" src="/js/jquery.form.js"></script>
<script type="text/javascript">
function check() {
	if(isNullDocument('infotitle')) {
		alert("投诉事宜不能为空!");
		return false;
	}
	if(isNullDocument('complaintname')) {
		alert("请留下您的真实姓名!");
		return false;
	}
	if(isNullDocument('telno')) {
		alert("请留下您的联系方式!");
		return false;
	}
	if(!isNumber(document.getElementById('telno').value)) {
		alert("请输入正确的联系方式!");
		return false;
	}
	if(isNullDocument('developername')) {
		alert("被投诉开发商不能为空!");
		return false;
	}
	if(isNullDocument('propertyname')) {
		alert("被投诉楼盘不能为空!");
		return false;
	}
	if(isNullDocument('infocontent')) {
		alert("投诉内容不能为空!");
		return false;
	}
	return true;
}

function isNullDocument(id) {
	return isNull(document.getElementById(id).value);
}
function isNull(str){ 
	if (str == "") return true; 
	var regu = "^[ ]+$"; 
	var re = new RegExp(regu); 
	return re.test(str); 
} 

function isNumber(s) { 
	var regu = "^[0-9]+$"; 
	var re = new RegExp(regu); 
	if (s.search(re) != -1) { 
		return true; 
	} else { 
		return false; 
	}
}
function doSubmit() {
	var saveOptions = {
		target: '#complaintForm',
		url:"/savecomplaint.jspx", type: 'post', dataType: 'html', cache:false, async:false,
		error: function(xhr) {
			alert(xhr);
		},
		success: function(data) {
			if(data == 'true') {
				alert("提交成功!");
				window.location.href="/complaintlist.jspx";
			}
			else {
				alert("抱歉,提交时出现异常.");
			}
		}
	}
	$('#complaintForm').ajaxSubmit(saveOptions);
}
</script>
</head>

<body>
<jsp:include page="/head.jsp" />
<div class="top">您现在的位置：<a href="/index.jsp">首页 </a>><a href="/credit.jspx">诚信档案</a></div>
<div class="hg"></div>
<div class="content">
	<div class="middle">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr class="lftip" height="25px">
				<td width="15%" id="zxgl" align="center">发布投诉咨询</td>
				<td width="83%">&nbsp;</td>
			</tr>
			<tr>
				<td colspan="2">
					<div class="box2">

<s:form id="complaintForm">
	<table width="100%" border="0" cellspacing="0" cellpadding="0" align="center" height="37" class="xf_06">
		<tr>
			<td colspan="4"><div class="box3">
			1、如果您对我们的网站及工作有任何不满或者疑问，请予在线投诉咨询；<br/>
			2、我们的办理期限一般为10-15天；<br/>
			3、这是一个全天候24小时开通的信箱，您可以不受时间和地点的限制上网给我们发邮件，我们将在规定工作日内给予回复。<br/><br/>
			</div>
			</td>
		</tr>
		<tr>
			<td height="37" width="120"  align="right" valign="middle">投诉事宜：</td>
			<td width="283" height="37" align="left" valign="middle">
				<s:textfield name="complaint.infotitle" id="infotitle" maxlength="50" /><font color="#FF0000">*</font>
			</td>
			<td height="37" colspan="2" align="right" valign="middle">&nbsp;</td>
		</tr>
		<tr>
			<td height="37" align="right" valign="middle">您的姓名：</td>
			<td width="283" height="37" align="left" valign="middle">
				<s:textfield name="complaint.complaintname" id="complaintname" maxlength="10" /><font color="#FF0000">*</font>
			</td>
			<td height="37" width="120" align="right" valign="middle">联系电话：</td>
			<td width="290" height="37" align="left" valign="middle">
				<s:textfield name="complaint.telno" id="telno" maxlength="15" /><font color="#FF0000">*</font>
			</td>
		</tr>
		<tr>
			<td height="37" align="right" valign="middle">被投诉开发商：</td>
			<td width="283" height="37" align="left" valign="middle">
				<s:textfield name="complaint.developername" id="developername" maxlength="25" /><font color="#FF0000">*</font>
			</td>
			<td height="37" align="right" valign="middle">被投诉楼盘：</td>
			<td width="290" height="37" align="left" valign="middle">
				<s:textfield name="complaint.propertyname" id="propertyname" maxlength="25" /><font color="#FF0000">*</font>
			</td>
		</tr>
		<tr>
			<td height="37" align="right" valign="middle">内　　容：</td>
			<td height="37" colspan="3" align="left" valign="middle">
				<s:textarea name="complaint.infocontent" id="infocontent" cols="69" rows="5" maxlength="1000" />
				<font color="#FF0000">*</font>
			</td>
		</tr>
		<tr>
			<td height="37" width="86"  align="left" valign="middle"></td>
			<td height="37" colspan="3" align="center" valign="middle">
				<input type="button" value=" 提 交 " onClick="if(check()) {doSubmit();}" name="B1"> 
				<input type="reset" value=" 重 置 " name="B2"> &nbsp;&nbsp;
			</td>
		</tr>
	</table>
</s:form>
</div>
    
    </td>
    </tr>
  <tr>
    <td colspan="2"></td>
    </tr>
</table>
	</div>
</div>
<div class="hg01"></div>
<jsp:include page="/footer.jsp" />
</body>
</html>
