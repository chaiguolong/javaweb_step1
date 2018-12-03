<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><s:property value="parentLabel"/>_<s:property value="selfLabel"/>_台州市三门县房地产管理处</title>
<jsp:include page="/head_include.jsp" />
<script type="text/javascript">
function doPage(pageno) {
	window.location.href="/law.jspx?pageno="+pageno;
}
</script>
<body>
<jsp:include page="/head.jsp" />
<div class="top">您现在的位置：<a href="/index.jsp">首页</a>><a href='<s:property value="parentLabelUrl"/>'><s:property value="parentLabel"/></a>><s:property value="selfLabel"/></div>
<div class="hg"></div>
<div class="content">
	<div class="left">
		<dl>
			<dt><s:property value="parentLabel"/></dt>
			<dd class="bartxt" id="menu">
				<ul>
					<s:iterator value="#request.left" var="c" status="index">
					<li>
						<div class="a">
							<a href='<s:property value="#c.url"/>'><s:property value="#c.name" /></a>
						</div>
						<s:if test="#request.menu_index == #index.index">
						<div class="tow">
							<ul>
								<s:iterator value="#request.lawtype" var="son">
									<li>·<a href='law.jspx?lawid=<s:property value="#son.categoryid"/>'><s:property value="#son.name" /></a></li>
								</s:iterator>
							</ul>
						</div>
						</s:if>
					</li>
					</s:iterator>
				</ul>
			</dd>
		</dl>
	</div>
	<div class="right">
		<div>
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr class="lftip" height="25px">
					<td width="10%" id="zxgl" align="center">
						政策法规
					</td>
					<td width="83%">
						&nbsp;
					</td>
				</tr>
			</table>
			<div class="leibie">
				<ul>
					<s:iterator value="#request.lawtype" var="son">
						<li><a href='law.jspx?lawid=<s:property value="#son.categoryid"/>'><s:property value="#son.name" /></a></li>
					</s:iterator>
				</ul>
			</div>
	        <div class="list">
				<ul>
					<s:iterator value="#request.laws" var="son"  begin="page.start" end="page.end">
						<li>
							<a href='lawcontent.jspx?contentid=<s:property value="#son.contentid"/>' target="_blank">
								<s:if test="#son.title.length() > 40"><s:property value="#son.title.substring(0,40)" /></s:if>
								<s:else><s:property value="#son.title" /></s:else>
								<font color="red">[<s:property value="#son.webshowdate.substring(0,10)" />]</font>
							</a>
						</li>
					</s:iterator>
				</ul>
				<div style="text-align:right; height:25px; margin:5px auto">
					<table cellSpacing="0" cellPadding="0" width="96%" height="25"
						border="0" style="border-collapse: collapse">
						<tr>
							<td noWrap>
							</td>
							<td align="right" width="75%">
								<s:property value="page" escape="false" />
							</td>
							<td noWrap align="right">
							</td>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</div>
</div>
<div class="hg01"></div>
<jsp:include page="/footer.jsp" />
</body>
</html>
