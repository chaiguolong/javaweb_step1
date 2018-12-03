<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>信息查询_网上办事_台州市三门县房地产管理处</title>
<jsp:include page="/head_include.jsp" />
<script type="text/javascript" src="/js/jquery.form.js"></script>
<script type="text/javascript">
function doSubmit() {
	$('#response').html("");
	if($.trim($('#bzcx_name').val()) == '') {
		alert("请输入申请人姓名!");
		return false;
	}
	if($.trim($('#bzcx_slbh').val()) == '') {
		alert("请输入需要查询的证件号码!");
		return false;
	}
	var saveOptions = {
		target: '#bzcxform',
		url:"/planquery.jspx", type: 'post', dataType: 'json', cache:false, async:false,
		error: function(xhr) {
			/* alert(xhr); */
			window.location.href = "/404.html";
		},
		success: function(data) {
			if(data != null) {
				if(typeof(data.exception) == "undefined") {
					var str = "查询结果:<br/>";
					str += "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
					str += "办理人姓名:" + data.sfmc + "<br/>";
					str += "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
					str += "受理编号:" + data.slbh + "<br/>";
					str += "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
					str += "受理业务:" + data.ywlb + "<br/>";
					str += "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
					str += "房屋坐落:" + data.fwzl + "<br/>";
					str += "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
					str += "办理进度:" + (data.isblz ? "办理中" : "已办结") + "<br/>";
					str += "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
					str += "是否领证:" + (data.sfyl ? "已领证" : "未领证") + "<br/>";
					$('#response').html(str);
				}
				else {
					alert("抱歉,没有找到相对应的办证记录,请核对申请人姓名与号码后再次尝试!");
				}
			}
			else {
				alert("抱歉,系统出现异常,请稍后再试!");
			}
		}
	}
	$('#bzcxform').ajaxSubmit(saveOptions);
}
function reset() {
	$('#bzcx_name').val('');
	$('#bzcx_slbh').val('');

	$('#bzcx_name').focus();
}
</script>
</head>
<body>
<jsp:include page="/head.jsp" />
<div class="top">
	您现在的位置：<a href="/index.jsp">首页</a> > 办事进度查询
</div>
<div class="hg"></div>
<div class="content">
	<div class="left">
		<dl>
			<dt>网上办事</dt>
			<dd class="bartxt" id="menu">
				<ul>
					<s:iterator value="#request.categorylist" var="c">
					<li>
						<div class="e">
							<s:if test="#c.url != ''">
							<a href='<s:property value="#c.url"/>'>
							</s:if>
							<s:else>
							<a href='news.jspx?contentid=<s:property value="#c.contentid"/>&categoryid=<s:property value="#request.self.categoryid"/>'>
							</s:else>
							<s:property value="#c.name" /></a>
						</div>
					</li>
					</s:iterator>
				</ul>
			</dd>
		</dl>
	</div>

	<div class="right">
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr class="lftip" height="25px">
			<td width="15%" id="zxgl" align="center">办事进度查询</td>
			<td width="83%">&nbsp;</td>
		</tr>
		<tr>
			<td colspan="2">
				<table cellspacing="8" cellpadding="0" width="50%" style="margin: 10px auto;">
					<tr>
						<td align="left" valign="top">
							<p style="line-height: 25px; font-size: 18px; font-family: '黑体'; text-align: center; color: #002b6c;">办事进度查询</p>
							<table width="100%" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td valign="top">
										<div class="gkcx">
											<dl>
												<dd>
												<form name="bzcxform" id="bzcxform">
													<table width="100%" align="center" cellpadding="0" cellspacing="0" style="margin-top: 20px;">
														<tr>
															<td height="30" width="110" align="center">申请人姓名：</td>
															<td width="195">
																<input name="bzcx_name" id="bzcx_name" size="20" />
															</td>
														</tr>
														<tr>
															<td height="30" align="center">
																证件号码：
															</td>
															<td>
																<input name="bzcx_slbh" id="bzcx_slbh" size="30" />
															</td>
														</tr>
														<tr>
															<td height="30" valign="middle" colspan="2" align="left">
																<p>* 本平台提供昨日之前30天之内受理业务的查询。</p>
																<p>* 目前仅开通产权交易、市场管理类业务。</p>
																<p>* 注：如果是两个及以上申请人，姓名之间用英文逗号隔开，如果查询不到结果可再尝试用中文逗号。</p>
															</td>
														</tr>
														<tr>
															<td colspan="2" align="center">
																<input name="gm_submit" value="提 交" type="button" onclick="doSubmit();" />
																<input name="reset" value="重 置" type="button" onclick="window.location.reload();" />
															</td>
														</tr>
													</table>
												</form>
												</dd>
											</dl>
										</div>
									</td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
				<div id="response" style="width:80%"></div>
			</td>
		</tr>
	</table>
	</div>
</div>
<div class="hg01"></div>
<jsp:include page="/footer.jsp" />
</body>
</html>