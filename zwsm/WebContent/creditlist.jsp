<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBliC "-//W3C//dtD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/dtD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>诚信档案_台州市三门县房地产管理处</title>
<jsp:include page="/head_include.jsp" />
<script type="text/javascript" >
function doPage(page) {
	var action = '<s:property value="#request.type" />';
	window.location.href= '/' + action + 'list.jspx?<s:property value="#request.is_search" escape="false" />' + '&pageno=' + page;
}
</script>
</head>

<body>
<jsp:include page="/head.jsp" />
<div class="top">您现在的位置：<a href="/index.jsp">首页 </a>><a href="/credit.jspx">诚信档案</a></div>
<div class="hg"></div>
<div class="content">
	<div class="left1">
	<s:if test="#request.type == 'revoke'">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr class="lftip" height="25px">
				<td width="15%" id="zxgl" align="center">解除合同列表</td>
				<td width="83%">&nbsp;</td>
			</tr>
			<tr>
				<td colspan="2">
					<div class="lbox" style="padding:0px;">
						<table width="100%" border="0" cellspacing="1" cellpadding="3">
							<tr>
								<td width="30%" style="background:#d6d6d6">开发商名称</td>
								<td width="40%" style="background:#d6d6d6">解除合同房屋坐落</td>
								<td width="15%" style="background:#d6d6d6">原购买人</td>
								<td width="12%" style="background:#d6d6d6">解除时间</td>
							</tr>
						<s:iterator value="#request.revokelist" var="revoke" status="index" begin="page.start" end="page.end">
							<tr>
								<td><div align="left"><a href="revokelist.jspx?devname=<s:property value="#revoke.htid" />" class="cxdastyle2"><s:property value="#revoke.devname" /></a></div></td>
								<td><div align="left"><a href="revokelist.jspx?fw_zl=<s:property value="#revoke.htid" />" class="cxdastyle2" title="<s:property value="#revoke.fw_zl" />"><s:property value="#revoke.fw_zl" /></a></div></td>
								<td><div align="center"><a href="revokelist.jspx?gfr=<s:property value="#revoke.htid" />" class="cxdastyle2"><s:property value="#revoke.gfr" /></a></div></td>
								<td><div align="center"><s:property value="#revoke.tfdate" /></div></td>
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
	</s:if>
	<s:elseif test="#request.type == 'continuous'">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr class="lftip" height="25px">
				<td width="15%" id="zxgl" align="center">连续预定列表</td>
				<td width="83%">&nbsp;</td>
			</tr>
			<tr>
				<td colspan="2">
					<div class="lbox" style="padding:0px">
						<table width="100%" border="0" cellspacing="1" cellpadding="1" class="cxdastyle2">
							<tr>
								<td width="46%" style="background:#d6d6d6">连续预订房屋坐落</td>
								<td width="36%" style="background:#d6d6d6">开发商名称</td>
								<td width="15%" style="background:#d6d6d6">最新预订时间</td>
							</tr>
						<s:iterator value="#request.continuouslist" var="continuous" status="index" begin="page.start" end="page.end">
							<tr>
								<td height="25"><a href="/continuouslist.jspx?fw_zl=<s:property value="#continuous.fh_nm" />" title="<s:property value="#continuous.fw_zl" />" class="cxdastyle2" style="margin-left:5px"><s:property value="#continuous.fw_zl" /></a></td>
								<td><div align="left"><s:property value="#continuous.devname" /></div></td>
								<td><div align="center"><s:property value="#continuous.ld" /></div></td>
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
	</s:elseif>
	<s:else>
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr class="lftip" height="25px">
				<td width="15%" id="zxgl" align="center">投诉咨询列表</td>
				<td width="83%">&nbsp;</td>
			</tr>
			<tr>
				<td colspan="2">
					<div class="lbox">
						<s:iterator value="#request.complaintlist" var="complaint" begin="page.start" end="page.end">
						<li>
							<span>
							[<s:if test="#complaint.state == 1">已解答</s:if><s:else>未解答</s:else>]
							[<s:property value="#complaint.addtime" />]
							</span>
							<a href="/complaint.jspx?complaintid=<s:property value="#complaint.complaintid" />">
							<s:property value="#complaint.infotitle" />							
							</a>
						</li>
						</s:iterator>
					</div>
				</td>
			</tr>
			<tr>
				<td colspan="2" class="yshu">
				<span><s:property value="page" escape="false" /></span>
				</td>
			</tr>
		</table>
	</s:else>
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
   
	<div class="box1">
		<dt>房管快讯</dt>
		<dd>
			<ul>
			<s:iterator value="#request.kuaixunlist" var="t" status="index">
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
