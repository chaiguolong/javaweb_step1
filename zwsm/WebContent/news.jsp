<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><s:property value="content.title"/>_<s:property value="#request.self.name"/>_台州市三门县房地产管理处</title>
<jsp:include page="/head_include.jsp" />
<script>
function fontZoom(s){
    var demo = document.getElementById("demo");
    demo.style.fontSize = s + "px";
}
</script>
</head>
<body>
<jsp:include page="/head.jsp" />
<jsp:include page="/topnav.jsp" />
<div class="hg"></div>
<div class="contentzs">
<div class="news_page">
<dl>
<dt><s:property value="content.title" /></dt>

<dd>
<ul class="tpld">
<span>　　　　【<a href="javascript:fontZoom(16)" class="linkfont">大</a> 
            <a href="javascript:fontZoom(14)" class="linkfont">中</a> <a href="javascript:fontZoom(12)" class="linkfont">小</a>】　【<a href="javascript:window.print()" class="linkfont">打印</a>】　【<a href="javascript:window.close()" class="linkfont">关闭</a>】</span> <s:property value="content.webshowdate.substring(0,10)" />
</ul>
<div id="demo">
<s:property value="content.content" escape="false" />
</div>
</dd>
</dl>
<div class="hg01"></div>
<ul class="lst">
<h3>相关<s:property value="#request.self.name"/>>></h3>
<s:iterator value="#request.contentlist" var="c" status="index">
	<s:if test="#index.index<5"><li><span>[<s:property value="#c.webshowdate.substring(0,10)" />]</span> <s:if test="#c.gotourl != '' && #c.gotourl != \"#\""><a href='<s:property value="#c.gotourl" /> '></s:if><s:else><a href='news.jspx?contentid=<s:property value="#c.contentid" />&categoryid=<s:property value="#request.self.categoryid"/>'></s:else><s:property value="#c.title" /> </a> </li> </s:if>
</s:iterator>
</ul>
</div>
</div>
<div class="hg01"></div>
<jsp:include page="/footer.jsp" />
</body>
</html>
