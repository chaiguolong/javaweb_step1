<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>搜索结果_台州市三门县房地产管理处</title>
<jsp:include page="/head_include.jsp" />
<script type="text/javascript">
function doPage(pageno) {
	window.location.href="/search.jspx?pageno="+pageno;
}
</script>
<body>
<jsp:include page="/head.jsp" />
<div class="top">您现在的位置：<a href="/index.jsp">首页</a>>搜索结果</div>
<div class="hg"></div>
<div class="content">
	<div class="searchpage">
		<h4>搜索结果</h4>
		<div class="searchyes">
			<ul>
			<s:iterator value="#request.contentlist" var="content" begin="page.start" end="page.end">
				<li>
					<s:if test="#content.gotourl != ''">
					<a href='<s:property value="#content.gotourl"/>'>
					</s:if>
					<s:else>
					<a href='news.jspx?contentid=<s:property value="#content.contentid"/>'>
					</s:else>
					<s:property value="#content.title"/></a>
				</li>
			</s:iterator>
			</ul>
		</div>
	</div>
	<span>
		<s:property value="page" escape="false" />
	</span>
</div>
<div class="hg01"></div>
<jsp:include page="/footer.jsp" />
</body>
</html>
