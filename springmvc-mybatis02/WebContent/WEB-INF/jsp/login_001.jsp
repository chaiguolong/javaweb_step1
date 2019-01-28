<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" />
		<meta name="viewport" content="width=device-width" />
		<title>登录信息</title>
	</head>
	<body>
		<form action="${pageContext.request.contextPath}/login_001.action" method="post" accept-charset="utf-8">
			用户名:<input type="text" name="username" id="username" value="张三">
			<input type="submit" value="提交">
		</form>
	</body>
</html>
