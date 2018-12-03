<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBliC "-//W3C//dtD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/dtD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>公示公告_台州市三门县房地产管理处</title>
<jsp:include page="/head_include.jsp" />
<script type="text/javascript" >
function doPage(page) {
	var action = '<s:property value="#request.type" />';
	window.location.href= '/' + action + 'preselllist.jspx?<s:property value="#request.is_search" escape="false" />' + '&pageno=' + page;
}
</script>
</head>

<body>
<jsp:include page="/head.jsp" />
<jsp:include page="/topnav.jsp" />
<div class="hg"></div>
<div class="content">
	<div class="left1">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr class="lftip" height="25px">
				<td width="15%" id="zxgl" align="center">预售证公示</td>
				<td width="83%">&nbsp;</td>
			</tr>
			<tr>
				<td colspan="2">
					<div class="lbox" style="padding:0px">
						<table width="100%" border="0" cellspacing="1" cellpadding="1" class="cxdastyle2">
							<tr>
								<td width="46%" style="background:#d6d6d6">项目名称</td>
								<td width="36%" style="background:#d6d6d6">预售证号</td>
								<td width="15%" style="background:#d6d6d6">签发日期</td>
							</tr>
						<s:iterator value="#request.preselllist" var="presell" status="index" begin="page.start" end="page.end">
							<tr>
								<td height="25">
									<a href="/newhouse/property_331022_<s:property value="#presell.propertyid" />_price.htm" target="_blank"><s:property value="#presell.projname" /></a>
								</td>
								<td><div align="left"><s:property value="#presell.presellname" /></div></td>
								<td><div align="left"><s:property value="#presell.openingdate.substring(0,11)" /></div></td>
							</tr>
						</s:iterator>
						</table>
					</div>
				</td>
			</tr>
			<tr>
				<td colspan="2" class="yshu">
				<span><s:property value="page" escape="false" /></span>
				</td>
			</tr>
		</table>
	</div>
	<div class="right1">
		<div class="box">
			<dl>
				<dt>网上互动 </dt>
				<dd>
					<ul>
						<li>
							<a href="/editcomplaint.jspx">
							<font color=#3b4d7d>我要投诉咨询</font>
							</a>
						</li>
					</ul>
					</dd>
			</dl>
		</div>
		<div class="box1">
			<dt>通知公告</dt>
			<dd>
				<ul>
				<s:iterator value="#request.tongzhilist" var="t" status="index">
					<s:if test="#index.index < 10"><li><a href="/news.jspx?contentid=<s:property value="#t.contentid" />" target="_blank" title="<s:property value="#t.title" />"><s:if test="#t.title.length() > 16"><s:property value="#t.title.substring(0,16)" /></s:if><s:else><s:property value="#t.title" /></s:else></a></li></s:if>
				</s:iterator>
				</ul>
			</dd>
		</div>
	</div>
</div>
<div class="hg01"></div>
<jsp:include page="/footer.jsp" />
</body>
</html>
