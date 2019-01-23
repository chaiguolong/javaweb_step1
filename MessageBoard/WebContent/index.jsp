<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width">
		<title>留言板</title>
		<link rel="stylesheet" href="css/index.css" type="text/css" media="screen" title="no title" charset="utf-8">
		<script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
		<script src="js/index.js" charset="utf-8"></script>
	</head>
	<body>
		<div class="wrapper">
		<h1>留言板</h1>
			<div class="left">
				<div class="leave_context">
					<ul>
						<c:forEach items="${messageList}" var="messageList" varStatus="">
							<li>${messageList.message}<span>${messageList.mtime}</span></li>
						</c:forEach>
					</ul>
				</div>
				<form action="${pageContext.request.contextPath}/addMessageServlet" method="post" accept-charset="utf-8">
					<div>
						<input type="text" name="text" placeholder="请输入您的留言" id="text" value="">
						<input id="submit" type="submit"  value="提交">
					</div>
				</form>
			</div>
		</div>
	</body>
</html>
