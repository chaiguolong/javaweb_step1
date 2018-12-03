<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0039)http://www.yhfc.gov.cn/dj/index.php?u=9 -->
<html xmlns="http://www.w3.org/1999/xhtml"><head><meta http-equiv="Content-Type" content="text/html; charset=GBK">
	<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7">
	<title>余杭房产信息网--杭州余杭房产官方网 </title>
	<meta name="author" content="">
	<meta name="keywords" content="支部台帐">
	<meta name="description" content="支部台帐">
	<jsp:include page="head_include.jsp" />
	<script type="text/javascript">
	function doPage(pageno) {
		if("<s:property value="#request.issearch" />" == "true") {
			window.location.href = "/dj/search.jspx?tid=<s:property value="self.categoryid" />&cid=<s:property value="self.pid" />&pageno=" + pageno;
		}
		else {
			window.location.href = "/dj/newslist.jspx?tid=<s:property value="self.categoryid" />&cid=<s:property value="self.pid" />&pageno=" + pageno;
		}
	}
	</script>
</head>

<body>
<jsp:include page="head.jsp" />
<div class="rap">
	<div style="margin-left:10px">当前位置：<a href="/dj/index.jspx">首页</a>-&gt;<s:property value="self.name" /></div>
</div>
<div class="rap clearfix" id="djwrap">
<jsp:include page="left.jsp" />
<div class="right">
<s:if test="#request.ismenu">
<s:iterator value="#request.categorylist" var="category">
	<div class="djbox" style="margin-bottom:10px">
		<h2><a href="/dj/newslist.jspx?tid=<s:property value="#category.categoryid" />&cid=<s:property value="cid" />"><s:property value="#category.name" /></a></h2>
		<div class="body">
			<ul class="newslist"><s:set name="list_index" value="0" />
			<s:iterator value="contentlist" var="content"><s:if test="#list_index < 6"><s:if test="#content.categoryid == #category.categoryid">
				<li><s:set name="list_index" value="#list_index + 1" />
					<span><s:property value="#content.webshowdate.substring(0,10)" /></span>&#8226; 
					<a href="/dj/news.jspx?tid=<s:property value="#content.contentid" />&cid=<s:property value="cid" />" target="_blank">
					<s:property value="#content.title" />
					</a>
				</li>
			</s:if></s:if></s:iterator>
			</ul>
			<div class="sright"><a href="/dj/newslist.jspx?tid=<s:property value="#category.categoryid" />&cid=<s:property value="cid" />">更多&gt;&gt;</a></div>
		</div>
	</div>
</s:iterator>
</s:if>
<s:else>
<div class="djbox" style="margin-bottom:10px">
	<h2><a href="/dj/newslist.jspx?tid=<s:property value="#category.categoryid" />&cid=<s:property value="cid" />"><s:property value="self.name" /></a></h2>
	<div class="body">
		<ul class="newslist">
			<s:iterator value="contentlist" var="content" begin="page.start" end="page.end">
			<li>
				<span><s:property value="#content.webshowdate.substring(0,10)" /></span>&#8226; 
				<a href="/dj/news.jspx?tid=<s:property value="#content.contentid" />&cid=<s:property value="self.categoryid" />" target="_blank">
				<s:property value="#content.title" />
				</a>
			</li>
			</s:iterator>
		</ul>
		<div class="pagelistfix"><s:property value="page" escape="false" /></div>
	</div>
</div>
</s:else>
</div>
</div>
<jsp:include page="footer.jsp" />
</body></html>