$(function(){

	//为输入框绑定事件
	$("#username").blur(function (e) {
		//1.失去焦点获得输入框的内容
		var usernameInput = $(this).val();
		//2.去服务端校验该用户名是否存在---ajax
		$.post(
			"${pageContext.request.contextPath}/checkUsername_002",
			{"username":usernameInput},
			function(data){
				var isExist = data.isExist;
				//3.根据返回的isExist动态显示信息
				var usernameInfo = "";
				if(isExist){
					//该用户存在
					usernameInfo = "该用户已经存在";
					$("#usernameInfo").css("color","red");
				}else{
					usernameInfo = "该用户可以使用";
					$("usernameInfo").css("color","green");
				}
				$("#usernameInfo").html(usernameInfo);
			},
			"json"

		);
	});
	
});
