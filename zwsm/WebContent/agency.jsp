<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><s:property value="parentLabel"/>_<s:property value="selfLabel"/>_台州市三门县房地产管理处</title>
<jsp:include page="/head_include.jsp" />

<body>
<jsp:include page="/head.jsp" />
<jsp:include page="/topnav.jsp" />
<div class="hg"></div>
<div class="content">
	<div class="left">
		<dl>
			<dt><s:property value="parentLabel"/></dt>
			<dd class="bartxt" id="menu">
				<ul>
					<s:iterator value="#request.left" var="c" status="index">
					<li>
						<div class="a">
							<a href='<s:property value="#c.url"/>'><s:property value="#c.name" /></a>
						</div>
						<s:if test="#request.menu_index == #index.index">
						<div class="tow">
							<ul>
								<s:iterator value="#request.agency" var="son">
									<li>·<a href='agency.jspx?agencyid=<s:property value="#son.categoryid"/>'><s:property value="#son.name" /></a></li>
								</s:iterator>
							</ul>
						</div>
						</s:if>
					</li>
					</s:iterator>
				</ul>
			</dd>
		</dl>
	</div>
	<div class="fg_right">
		<div class="agency" id="Tab1">
			<h3>
				<span>
					<s:iterator value="#request.tags" var="tag" status="index">
					<s:if test="#index.index == 0">
					<a id="one1" onmouseover="setTab('one',1,7)" class="hover"><s:property value="#tag.title" /></a>
					</s:if>
					<s:else>
					<a id="one<s:property value="#index.index+1" />" onmouseover="setTab('one',<s:property value="#index.index+1" />,7)"><s:property value="#tag.title" /></a>
					</s:else>
					</s:iterator>
				</span>机构信息
			</h3>
			<s:iterator value="#request.tags" var="tag" status="index">
				<s:if test="#index.index == 0">
				<div id="con_one_1" class="jigoun1">
				<s:property value="#tag.content" escape="false" />
				</div>
				</s:if>
				<s:else>
				<div id="con_one_<s:property value="#index.index+1" />" class="jigoun1" style="display: none">
				<s:property value="#tag.content" escape="false" />
				</div>
				</s:else>
			</s:iterator>
		</div>
	</div>
</div>
<div class="hg01"></div>
<jsp:include page="/footer.jsp" />
</body>
</html>
