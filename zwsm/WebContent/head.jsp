<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<div class="header">
	<img src="images/zxtop.jpg" width="950" height="102" />
</div>
<div class="nav">
	<ul id="menu">
		<s:iterator value="#request.menulist" var="c">
			<s:if test="#c.pid == 1">
				<li class="mainlevel">
					<div class="title"><s:if test="#c.url.length() > 1"><a href='<s:property value="#c.url" />' target="_blank"><s:property value="#c.name" /></a></s:if>
					<s:else><s:property value="#c.name" /></s:else></div>
					<ul id="sub_02">
						<s:iterator value="#request.menulist" var="son"><s:if test="#son.pid == #c.categoryid">
								<li>
									<s:if test="#son.url.length() > 1"><a href='<s:property value="#son.url" />' target="_blank"><s:property value="#son.name" /></a></s:if>
									<s:else><s:property value="#son.name" /></s:else>
								</li>
							</s:if></s:iterator>
					</ul>
				</li>
			</s:if>
		</s:iterator>
		<li class="mainlevel">
			<a href="/bzcx.jspx" target="_blank">信息查询</a>
			<ul id="sub_02"></ul>
		</li>
		<div class="clear"></div>
	</ul>
</div>