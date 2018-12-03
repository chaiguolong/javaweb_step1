<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0057)http://www.yhfc.gov.cn/dj/index.php?u=34&show=news&id=290 -->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=GBK">
	<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7">
	
	<title> 2011年度房管处支部理论学习计划--杭州余杭房产官方网 </title>
	<meta name="author" content="">
	<meta name="keywords" content="">
	<meta name="description" content="">
	<jsp:include page="head_include.jsp" />
	</head>
<body>
<jsp:include page="head.jsp" />
<div class="rap">
<div style="margin-left:10px">当前位置：<a href="/dj/index.jspx">首页</a>-&gt;<s:property value="self.name" /></div>
<div class="rap clearfix" id="djwrap">
	<jsp:include page="left.jsp" />
	<div class="right">
		<div class="djbox" id="newsshow">
			<h2><s:property value="self.name" /></h2>
			<div class="body">
				<h3><s:property value="content.title" /></h3>
				<h5 class="tfix"><s:property value="content.webshowdate.substring(0,10)" /></h5>
				<div style="color:#333">
					<s:property value="content.content" escape="false" />
				</div>
			</div>
		</div>
	</div>
</div>

<jsp:include page="footer.jsp" />
</body></html>