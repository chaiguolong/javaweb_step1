<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="/WEB-INF/tmsf_tag.tld" prefix="tmsf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>德清县房地产协会_德清房地产信息网</title>
		<link href="/zjxh/images/css.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="/zjxh/js/jquery-1.7.2.min.js"></script>
		<script type="text/javascript" src="/zjxh/js/slide.js"></script>
		<script type="text/javascript" src="/zjxh/js/jquery.js"></script>
		<script type="text/javascript" src="/zjxh/js/jquery.lazyload.js"></script>
		<script type="text/javascript">
			var n=5;
			for(var i=1; i<=n; i++)
			{
				switchtag(i);
			}
			function switchtag(x)
			{
			   $(document).ready(function(){
			   $("#myCont" + x + " > div:not(:first)").hide();
			   var myLi = $("#myTop" + x + " > ul > li");
			   var myDiv =$("#myCont" + x + " > div");
			   myLi.each(function(i){
			      $(this).mousedown(function(){
			        myLi.removeClass("hover");
			         $(this).addClass("hover");
			          myDiv.hide();
			          myDiv.eq(i).show();
			      })
			   })
			   })
			}
	    </script>
		<script type="text/javascript">
			function setTab(name,cursel,n){
				for(i=1;i<=n;i++){
				    var nav=document.getElementById(name+i);
				    var conlist=document.getElementById("con_"+name+"_"+i);
				    nav.className=i==cursel?"hover":"";
				    conlist.style.display=i==cursel?"block":"none";
			    }
			}
			function hzfcgov(thisObj,Num){
				if(thisObj.className == "active")return;
				var tabObj = thisObj.parentNode.id;
				var tabList = document.getElementById(tabObj).getElementsByTagName("li");
				for(i=0; i <tabList.length; i++){
				    if (i == Num)
				    {
				     	thisObj.className = "active";
				        document.getElementById(tabObj+"_Content"+i).style.display = "block";
				    }else{
				   		tabList[i].className = "normal";
				   		document.getElementById(tabObj+"_Content"+i).style.display = "none";
				    }
				}
			}
			function fontZoom(s) {
				var demo = document.getElementById("demo");
				demo.style.fontSize = s + "px";
			}
		</script>
	</head>
	<body>
		<s:include value="/zjxh/xh_zjxh_top.html"></s:include>
		<s:include value="/include/zjxh_top_link.html"></s:include>
		<div class="topsearch">
			<table width="100%" height="30" border="0" cellspacing="0"
				cellpadding="0">
				<tr>
					<td width="8"></td>
					<td>
						您现在的位置：<a href="/zjxh">首页</a> ><s:property value="#request.category.name"/>
					</td>
				</tr>
			</table>
		</div>
		<div class="hg"></div>
		<div class="contentzs">
			<div class="news_page">
				<dl>
					<dt>
						<s:property value="%{content.title}" />
					</dt>
					<dd>
						<ul class="tpld">
							<span> 【<a href="javascript:fontZoom(16)" class="linkfont">大</a>
								<a href="javascript:fontZoom(14)" class="linkfont">中</a> <a
								href="javascript:fontZoom(12)" class="linkfont">小</a>】 【<a
								href="javascript:window.print()" class="linkfont">打印</a>】 【<a
								href="javascript:window.close()" class="linkfont">关闭</a>】
							</span>http://www.xsfc.gov.cn <s:property value="%{content.webshowdate}" />
						</ul>
						<div id="demo">
							<s:property value="%{content.content}" escape="false" />
						</div>
					</dd>
				</dl>
				<div class="hg01"></div>
				<ul class="lst">
					<h3>相关链接>></h3>
					<s:if test="%{#request.contentlist.size() != 0}">
						<s:iterator value="#request.contentlist" var="c">
							<li><a href='/zjxh/news.jspx?contentid=<s:property value="#c.contentid" />&categoryid=<s:property value="#request.category.categoryid"/>' target="_blank"><s:property value="#c.title" /></a></li> 
						</s:iterator>
					</s:if>
					<s:else>
						<li>没有相关新闻</li>
					</s:else>
				</ul>
			</div>
		</div>
		<div class="hg01"></div>
		<s:include value="/zjxh/xh_zjxh_bottom.html"></s:include>
	</body>
</html>

