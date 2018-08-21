<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.reqest.contextPath}/transfer" method="post">
	转出账户:<input type="text" name="out" id="out" value="" />	
	转入账户:<input type="text" name="in" id="in" value="" />
	转账金额:<input type="text" name="money" id="money" value="" />
	<input type="submit" name="" id="" value="确认转账" />
	</form>
</body>
</html>
