<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="/WEB-INF/tmsf_tag.tld" prefix="tmsf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>德清县房地产协会_德清房地产信息网</title>
		<link href="/fdcxh/images/css.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="/fdcxh/js/jquery-1.7.2.min.js"></script>
		<script type="text/javascript" src="/fdcxh/js/slide.js"></script>
		<script type="text/javascript" src="/fdcxh/js/jquery.js"></script>
		<script type="text/javascript" src="/fdcxh/js/jquery.lazyload.js"></script>
		<script type="text/javascript">
			var n = 5;
			for ( var i = 1; i <= n; i++)
			{
				switchtag(i);
			}
			function switchtag(x){
				$(document).ready(function() {
					$("#myCont" + x + " > div:not(:first)").hide();
					var myLi = $("#myTop" + x + " > ul > li");
					var myDiv = $("#myCont" + x + " > div");
					myLi.each(function(i) {
						$(this).mousedown(function() {
							myLi.removeClass("hover");
							$(this).addClass("hover");
							myDiv.hide();
							myDiv.eq(i).show();
						})
					})
				})
			}

			function setTab(name, cursel, n) {
				for (i = 1; i <= n; i++) {
					var nav = document.getElementById(name + i);
					var conlist = document.getElementById("con_" + name + "_" + i);
					nav.className = i == cursel ? "hover" : "";
					conlist.style.display = i == cursel ? "block" : "none";
				}
			}

			function hzfcgov(thisObj, Num) {
				if (thisObj.className == "active")
					return;
				var tabObj = thisObj.parentNode.id;
				var tabList = document.getElementById(tabObj).getElementsByTagName("li");
				for (i = 0; i < tabList.length; i++){
					if (i == Num)
					{
						thisObj.className = "active";
						document.getElementById(tabObj + "_Content" + i).style.display = "block";
		
					} else {
						tabList[i].className = "normal";
						document.getElementById(tabObj + "_Content" + i).style.display = "none";
					}
				}
			}
			
			function doPage(a) {
				$('#page').val(a);
				$('#search').submit();
			}
			
		</script>
	</head>
	<body>
		<s:include value="/fdcxh/xh_fdcxh_top.html"></s:include>
		<s:include value="/include/fdcxh_top_link.html"></s:include>
		<div class="topsearch">
			<table width="100%" height="30" border="0" cellspacing="0" cellpadding="0">
				<tr><td width="8"></td>
					<td>
						您现在的位置：<a href="/fdcxh">首页</a> > <s:property value="#request.parent.name"/>  > <s:property value="#request.self.name"/>
					</td>
				</tr>
			</table>
		</div>
		<div class="hg"></div>
		<div class="content">
		<form id="search" name="search">
			<s:hidden name="page"></s:hidden>
			<s:hidden name="categoryid"></s:hidden>
		</form>
			<div class="left">
				<dl>
					<dt><s:property value="#request.parent.name"/></dt>
					<dd>
						<s:iterator value="#request.categorylist" var="c">
							<li class="a">
								<a href='/xh/WebFdcxhAction_newslist.jspx?categoryid=<s:property value="#c.categoryid" />'><s:property value="#c.name" /></a>
							</li>
						</s:iterator>
					</dd>
				</dl>
			</div>
			<div class="right">
				<dl>
					<dt>
						<s:property value="#request.self.name"/>
					</dt>
					<dd>
						<div class="lbox">
							<s:if test="%{#request.contentlist.size() != 0}">
								<s:iterator value="#request.contentlist" status="s">
									<li>
										<span>[<s:property value="webshowdate" />]</span> 
										<s:if test="%{gotourl != ''}">
											 <a href="<s:property value="%{gotourl}"/>" class="main" title="<s:property value="title" />">
												<s:property value="title" escape="false"/>
											 </a>
										</s:if>
										<s:else>
											<a href="/xh/WebFdcxhAction_news.jspx?contentid=<s:property value="%{contentid}"/>&categoryid=<s:property value="#request.categoryid"/>" class="main" title="<s:property value="title" />" target="_blank">
												<s:property value="title" escape="false"/>
											 </a>
										</s:else>
									</li>
								</s:iterator>
							</s:if>
						</div>
						<div class="pagesinfo">
							<div class="pagesinfo_l">
								找到相关资讯<span class="cc"><s:property value="%{allcounts}"/></span>条
							</div>
							<div class="pagesinfo_r">
								<s:property value="%{pageinfo}" escape="false"/>
							</div>
						</div>
					</dd>
				</dl>
			</div>
		</div>
		<div class="hg01"></div>
		<script language="javascript">
			function geturl()
			{
				var url = "./../correct/correct.php?locationhref=" + top.window.location.href;
				window.open( url, "_blank", "resizable=1,scrollbars=1,status=yes,toolbar=yes,location=yes,menu=yes,left=100,top=100,width=800,height=510");
			}
		</script>
		<s:include value="/fdcxh/xh_fdcxh_bottom.html"></s:include>
		<!--<div class="ht8"></div>
		<div class="bottomline"></div>
		<div class="bottom"><a href="./..">返回首页</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;<a href="./../ditu01.php">网站地图</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;<a href="./../ysbh.php">隐私声明</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;<a href="javascript:" onclick="geturl()">网站错误报告</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;<a href="/telephon/telephon.php">联系我们</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="./../feed.php">信息订阅</a></div>
		<div class="copy">当前累计访问量: <script src="/counter.php?COUNTERTYPE=2"></script> 人　<a href="mailto:fgj@hz.gov.cn">杭州市住房保障和房产管理局版权所有</a>◎   隐私保护     ICP备案证编号:<a href="http://www.miibeian.gov.cn/" target="_blank">
		浙ICP备05052140号</a><br />  
		杭州市房产信息中心建设管理　联系电话：967111　本站中文域名：杭州房产信息网</div>
		-->
	</body>
</html>

