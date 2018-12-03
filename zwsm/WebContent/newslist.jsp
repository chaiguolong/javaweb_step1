<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><s:property value="#request.parent.name"/>_<s:property value="#request.self.name"/>_台州市三门县房地产管理处</title>
<jsp:include page="/head_include.jsp" />
<script type="text/javascript">
function doPage(pageno) {
	window.location.href="/newslist.jspx?categoryid=<s:property value="#request.self.categoryid"/>&pageno=" + pageno
}

</script>
<body>
<jsp:include page="/head.jsp" />
<jsp:include page="/topnav.jsp" />
<div class="hg"></div>
<div class="content">
	<div class="left">
		<dl>
			<dt><s:property value="#request.parent.name"/></dt>
			<dd class="bartxt" id="menu">
				<ul>
					<s:iterator value="#request.categorylist" var="c">
					<li>
					<s:if test="#c.categoryid == #request.categoryid">
						<div class="a">
							<s:if test="#c.url != ''">&nbsp;
							<a href='<s:property value="#c.url"/>'>
							</s:if>
							<s:else>
							<a href='news.jspx?contentid=<s:property value="#c.contentid"/>&categoryid=<s:property value="#request.self.categoryid"/>'>
							</s:else>
							<s:property value="#c.name" /></a>
						</div>
						<s:if test="#request.ismenu">
						<div class="tow">
							<ul>
								<s:if test="#request.sonlist != null">
								<s:iterator value="#request.sonlist" var="son">
									<li>
									<s:if test="#son.url != ''">
									·<a href='<s:property value="#son.url"/>'>
									</s:if>
									<s:else>
									·<a href='newslist.jspx?categoryid=<s:property value="#son.categoryid"/>'>
									</s:else>
									<s:property value="#son.name" /></a></li>
								</s:iterator>
								</s:if>
							</ul>
						</div>
						</s:if>
						<s:else>
						<div class="tow">
							<ul>
								<s:iterator value="#request.newslist" var="son">
									<li>
									<s:if test="#son.gotourl != ''">·<a href='<s:property value="#son.gotourl"/>' title="<s:property value="#son.title" />"></s:if>
									<s:else>·<a href='news.jspx?contentid=<s:property value="#son.contentid"/>&categoryid=<s:property value="#request.self.categoryid"/>' title="<s:property value="#son.title" />"></s:else><s:if test="#son.title.length() > 12"><s:property value="#son.title.substring(0,12)" /></s:if><s:else><s:property value="#son.title" /></s:else></a></li>
								</s:iterator>
							</ul>
						</div>
						</s:else>
					</s:if>
					<s:else>
						<div class="e">
							<a href='<s:property value="#c.url"/>'>&nbsp;&nbsp;<s:property value="#c.name" /></a>
						</div>
					</s:else>
					</li>
					</s:iterator>
				</ul>
			</dd>
		</dl>
	</div>
	<div class="right">
		<s:if test="#request.ismenu" >
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr class="lftip" height="25px">
				<td width="15%" id="zxgl" align="center"><s:property value="#request.self.name"/></td>
				<td width="83%">&nbsp;</td>
			</tr>
			<tr>
				<td colspan="2">
					<div class="lbox"> 
						<s:iterator value="#request.newslist" var="son" begin="page.start" end="page.end">
						<li>
							<span>[<s:property value="#son.webshowdate.substring(0,10)"/>]</span>
							<s:if test="#son.gotourl != ''">
							·<a href='<s:property value="#son.gotourl"/>'>
							</s:if>
							<s:else>
							·<a href='news.jspx?contentid=<s:property value="#son.contentid"/>&categoryid=<s:property value="#request.self.categoryid"/>'>
							</s:else>
							<s:property value="#son.title"/></a>
						</li>
						</s:iterator>
					</div>
				</td>
			</tr>
			<tr>
				<td colspan="2" class="yshu">
					<span>
						<s:property value="page" escape="false" />
					</span>
				</td>
			</tr>
		</table>
		</s:if>
		<s:else>
		<s:property value="#request.content.content" escape="false" />
		</s:else>
	</div>
</div>
<div class="hg01"></div>
<jsp:include page="/footer.jsp" />
</body>
</html>
