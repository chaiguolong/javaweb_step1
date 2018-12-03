<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<div class="fg_left">
	<dl>
		<dt><s:property value="parentLabel" /></dt>
		<dd>
			<ul style="margin-top: 15px;">
				<s:iterator value="leftlist" var="c">
				<li>
				<s:if test="#c.categoryid == #request.categoryid">
					<div class="a">
						<s:if test="#c.url != ''">
						<a href='<s:property value="#c.url"/>'>
						</s:if>
						<s:else>
						<a href='news.jspx?contentid=<s:property value="#c.contentid"/>&categoryid=<s:property value="#request.self.categoryid"/>'>
						</s:else>
						<s:property value="#c.name" /></a>
					</div>
					<s:if test="#request.ismenu">
					<div class="tow">
						<ul>
							<s:if test="#request.sonlist != null">
							<s:iterator value="#request.sonlist" var="son">
								<li>
								<s:if test="#son.url != ''">
								·<a href='<s:property value="#son.url"/>'>
								</s:if>
								<s:else>
								·<a href='newslist.jspx?categoryid=<s:property value="#son.categoryid"/>'>
								</s:else>
								<s:property value="#son.name" /></a></li>
							</s:iterator>
							</s:if>
						</ul>
					</div>
					</s:if>
					<s:else>
					<div class="tow">
						<ul>
							<s:if test="#request.newslist.size() > 1">
							<s:iterator value="#request.newslist" var="son">
								<li>
								<s:if test="#son.gotourl != ''">·<a href='<s:property value="#son.gotourl"/>' title="<s:property value="#son.title" />"></s:if>
								<s:else>·<a href='news.jspx?contentid=<s:property value="#son.contentid"/>&categoryid=<s:property value="#request.self.categoryid"/>' title="<s:property value="#son.title" />"></s:else><s:if test="#son.title.length() > 12"><s:property value="#son.title.substring(0,12)" /></s:if><s:else><s:property value="#son.title" /></s:else></a></li>
							</s:iterator>
							</s:if>
						</ul>
					</div>
					</s:else>
				</s:if>
				<s:else>
					<div class="a">
						<a href='<s:property value="#c.url"/>'><s:property value="#c.name" /></a>
					</div>
				</s:else>
				</li>
				</s:iterator>
			</ul>
		</dd>
	</dl>
</div>