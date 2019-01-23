window.onload=function(){
	$.ajax({
		url: '${pageContext.request.contextPath}/messageBoardServlet',
		type: 'POST',
		dataType: 'json',
		success: function (data, textStatus, jqXHR) {
			alert(data);
		}
	});
}
