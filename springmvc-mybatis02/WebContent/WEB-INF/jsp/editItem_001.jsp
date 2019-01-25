<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" />
		<meta name="viewport" content="width=device-width" />
		<title>商品修改信息</title>
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.4.min.js"></script>
		<script charset="utf-8">
			$(function(){
				var params = '{"id": 1,"name": "测试商品","price": 99.9,"detail": "测试商品描述","pic": "123456.jpg"}';
				$.ajax({
					url : "${pageContext.request.contextPath}/json_001.action",
					data : params,
					contentType : "application/json;charset=UTF-8",//发送数据的格式
					type : "post",
					dataType : "json",//回调
					success : function(data){
						alert(data.name);
					}
				});
			});
		</script>
	</head>
	<body>
		<%-- <form id="itemForm" action="" method="post" enctype="multipart/form-data"> --%>
			<form id="itemForm" action="${pageContext.request.contextPath}/updateitem_001.action" method="post">
			修改商品信息:
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
					<td> <textarea rows="3" cols="30" name="detail" >${items.detail}</textarea></td>
				</tr>
				<tr>
					<td colspan="2" align="center"> <input type="submit"  value="提交"></td>
				</tr>
				<input type="hidden" name="id" value="${items.id}">
			</table>
		</form>
	</body>
</html>
