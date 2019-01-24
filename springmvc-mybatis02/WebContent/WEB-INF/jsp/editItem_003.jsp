<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" />
		<meta name="viewport" content="width=device-width" />
		<title>商品修改信息</title>
	</head>
	<body>
		<form action="${pageContext.request.contextPath}/updateitem_003.action" method="post" accept-charset="utf-8">
			<table width="100%" border=1>
				<tr>
					<td>商品名称</td>
					<td><input type="text" name="name" id="name" value="${items.name}"></td>
				</tr>
				<tr>
					<td>商品价格</td>
					<td><input type="text" name="price" id="price" value="${items.price}"></td>
				</tr>
				<tr>
					<td>商品简介</td>
					<td><textarea cols="50" rows="3" name="detail" id="">${items.detail}</textarea></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit" value="提交"></td>
				</tr>
			</table>
			<input type="hidden" name="id" id="id" value="${items.id}">
		</form>
	</body>
</html>
