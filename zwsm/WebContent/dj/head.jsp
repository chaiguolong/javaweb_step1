<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<script type="text/javascript">
<!--
document.body.oncopy = function (){
	if(!window.event.shiftKey){
		setTimeout( function () {
		//var text = clipboardData.getData("text");
		//if (text) {
		text = document.title + "\n 来自德清房产信息网"+this.location.href;
		clipboardData.setData("text", text);
		//}
		}, 100 )
	}

}
//-->
</script>
<div class="rap">
	<script type="text/javascript">
	document.write('<object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,19,0" width="912" height="168"> <param name="movie" value="images/top4.swf"><param name="wmode" value="transparent"><param name="quality" value="high"> <embed src="images/top4.swf" quality="high" pluginspage="http://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash" width="912" height="168"></embed> </object>');
</script>
</div>

<div id="nav" class="clearfix rap">
	<ul>
		<li class="fix" style="cursor: pointer"
			onclick="window.location='/dj/index.jspx'">
			首页
		</li>
		<s:iterator value="menulist" var="menu">
		<s:if test="#menu.pid == 101">
		<li onmouseover="hideElms('select');document.getElementById('sub<s:property value="#menu.categoryid" />').style.display='block'"
			onmouseout="showElms('select');document.getElementById('sub<s:property value="#menu.categoryid" />').style.display='none'"
			class="sub">
			<s:if test="#menu.url != '' && #menu.url != \"#\"">
			<a href="<s:property value="#menu.url" />" target="_blank"><s:property value="#menu.name" /></a>
			</s:if>
			<s:else>
			<a href="/dj/newslist.jspx?cid=<s:property value="#menu.categoryid" />" target="_blank"><s:property value="#menu.name" /></a>
			</s:else>
			<div id="sub<s:property value="#menu.categoryid" />" style="display: none;">
				<s:iterator value="menulist" var="son"><s:if test="#son.pid == #menu.categoryid">
				<a href="/dj/newslist.jspx?cid=<s:property value="#menu.categoryid" />&tid=<s:property value="#son.categoryid" />"><s:property value="#son.name" escape="false" /></a>
				</s:if></s:iterator>
			</div>
		</li>
		</s:if>
		</s:iterator>
	</ul>
</div>
