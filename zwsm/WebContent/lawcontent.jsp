<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><s:property value="selfLabel"/>_台州市三门县房地产管理处</title>
<jsp:include page="/head_include.jsp" />
</head>
<body>
	<jsp:include page="/head.jsp" />
	<div class="top">您现在的位置：<a href="/index.jsp">首页</a>><a href='<s:property value="parentLabelUrl"/>'><s:property value="parentLabel"/></a>><s:property value="selfLabel"/></div>
	<div class="hg"></div>
	<div class="xscontent">
		<div style="background:#eef1f2; width:100%; margin:5px auto 0px;">
			<div style="margin:4px; background:#ffffff; line-height:30px; font-size:14px;">
				<s:property value="content.content" escape="false" />
			</div>
		</div>
	</div>
	<div class="hg01"></div>
	<jsp:include page="/footer.jsp" />
</body>
</html>
