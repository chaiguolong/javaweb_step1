<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" />
		<meta name="viewport" content="width=device-width" />
		<title>查询商品列表</title>
	</head>
	<body>
		<form action="itemList_001_submit" method="post" accept-charset="utf-8">
			查询条件:
			<table width="100%" border=1>
				<tr>
					<td> <input type="submit" value="查询"></td>
				</tr>
			</table>
		</form>
		商品列表:
		<form action="${pageContext.request.contextPath }/updateitem_001.action" method="post" accept-charset="utf-8">
			<table width="100%" border=1>
				<tr>
					<td><input type="checkbox" name="" id=""></td>
					<td>商品名称</td>
					<td>商品价格</td>
					<td>生产日期</td>
					<td>商品描述</td>
					<td>操作</td>
				</tr>
				<c:forEach items="${itemList}" var="item" varStatus="index">
				<tr>
					<td><input type="checkbox" name="ids" id="" value="${item.id}"></td>
					<td><input type="text" value="${item.name}" name="name" id="name"/></td>
					<td><input type="text" value="${item.price}" name="price" id="name"/></td>
					<td><input type="text" value="${item.createtime}" name="createtime" id="name"/></td>
					<td><input type="text" value="${item.detail}" name="detail" id="detail"/></td>
					<td><a href="${pageContext.request.contextPath}/itemEdit_001.action?id=${item.id}">修改</a></td>
				</tr>
				</c:forEach>
			</table>
			<input type="submit" name="" id="" value="删除">
			<input type="submit" name="" id="" value="修改">
		</form>
	</body>
</html>
