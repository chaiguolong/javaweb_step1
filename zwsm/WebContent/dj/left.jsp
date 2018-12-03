<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<div class="left" id="navleft">
	<s:if test="leftlist.size > 0">
	<h2><a href="#" ><s:property value="#request.title" /></a></h2>
	<div class="current">
		<s:iterator value="leftlist" var="menu">
			<h3><a href="/dj/newslist.jspx?tid=<s:property value="#menu.categoryid" />&cid=<s:property value="cid" />"><s:property value="#menu.name" /></a></h3>
			<s:iterator value="leftlist" var="son"><s:if test="#menu.categoryid == #son.pid">
			<h4><a href="/dj/newslist.jspx?tid=<s:property value="#son.categoryid" />&cid=<s:property value="cid" />"><s:property value="#son.name" /></a></h4>
			</s:if></s:iterator>
		</s:iterator>
	</div>
	</s:if>
	<s:else>
	<script type="text/javascript" >
	document.write('<object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,19,0" width="150" height="500"> <param name="movie" value="images/left2.swf"><param name="wmode" value="transparent"><param name="quality" value="high"> <embed src="images/left2.swf" quality="high" pluginspage="http://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash" width="150" height="500"></embed> </object>');
	</script>
	</s:else>
</div>