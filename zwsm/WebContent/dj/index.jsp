<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0026)http://www.yhfc.gov.cn/dj/ -->
<html xmlns="http://www.w3.org/1999/xhtml"><head><meta http-equiv="Content-Type" content="text/html; charset=GBK">
	<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7">
	
	<title>德清房产信息网--杭州德清房产官方网 </title>
	<meta name="author" content="">
	<meta name="keywords" content="">
	<meta name="description" content="">
	<jsp:include page="head_include.jsp" />
</head>

<body>
<jsp:include page="head.jsp" />
<div id="focuspart" class="rap clearfix">
	<div id="focusleft">
		<a href="http://www.yhfc.gov.cn/dj/index.php?u=45&show=news&id=717"><img src="images/135774189050ed7f42515d1.jpg" alt=""></a>
	</div>
	<div id="focusmiddle"><s:set name="list_index" value="0" />
		<s:iterator value="contentlist" var="content" status="index">
		<s:if test="#list_index < 8"><s:set name="list_index" value="#list_index+1"/>
			<s:if test="index.index == 0">
			<h2><a href="/dj/news.jspx?tid=<s:property value="#content.contentid" />&cid=<s:property value="#content.categoryid" />"><s:property value="#content.title" /></a></h2>
			</s:if>
			<s:else>
			<s:if test="index.index == 1">
			<ul>
			</s:if>
				<li><span><s:property value="#content.webshowdate.substring(0,10)" /></span>&#8226; 
					<a href="/dj/news.jspx?tid=<s:property value="#content.contentid" />" title="<s:property value="#content.title" />">
					<s:if test="#content.title.length() > 19"><s:property value="#content.title.substring(0,19)" /></s:if>
					<s:else><s:property value="#content.title" /></s:else>
					</a>
				</li>
			</s:else>
		</s:if>
		</s:iterator>
		</ul>
	</div>
	<div id="focusright">
		<h2>通知公告</h2>
		<ul>
		<s:set name="list_index" value="0" />
		<s:iterator value="contentlist" var="content" status="index"><s:if test="#list_index < 8"><s:if test="#content.categoryid == 158">
		<li>&#8226; <s:set name="list_index" value="#list_index+1"/>
		<a href="/dj/news.jspx?tid=<s:property value="#content.contentid" />&cid=158" title="<s:property value="#content.title" />">
		<s:if test="#content.title.length() > 18"><s:property value="#content.title.substring(0,18)" /></s:if>
		<s:else><s:property value="#content.title" /></s:else>
		</a></li>
		</s:if></s:if></s:iterator>
		</ul><div class="sright"><a href="/dj/newslist.jspx?cid=158">更多&gt;&gt;</a></div>
	</div>
</div>
<div class="clearfix rap" style="padding-top:10px">
	<s:iterator value="menulist" var="menu" status="index" begin="1"><s:if test="#menu.pid == 101">
	<div class="homebox <s:if test="#index.even">x</s:if>" style="margin-bottom:10px">
		<h2>
			<a href="/dj/newslist.jspx?cid=<s:property value="#menu.categoryid" />" class="more">more</a>
			<a href="/dj/newslist.jspx?cid=<s:property value="#menu.categoryid" />"><s:property value="#menu.name" /></a>
		</h2>
		<div class="body">
			<s:set name="list_index" value="0" />
			<ul class="newslist">
				<s:iterator value="contentlist" var="content"><s:if test="#list_index < 5"><s:if test="#menu.categoryid == #content.categoryid">
				<li>
					<s:set name="list_index" value="#list_index + 1" />
					<span><s:property value="#content.webshowdate.substring(0,10)" /></span>&#8226; 
					<a href="/dj/news.jspx?tid=<s:property value="#content.contentid" />&cid=<s:property value="#menu.categoryid" />" target="_blank"><s:property value="#content.title" /></a>
				</li>
				</s:if></s:if></s:iterator>
			</ul>
		<div class="sright"><a href="/dj/newslist.jspx?cid=<s:property value="#menu.categoryid" />">更多&gt;&gt;</a></div>
		</div>
	</div>
	</s:if></s:iterator>
</div>
<jsp:include page="footer.jsp" />
</body></html>