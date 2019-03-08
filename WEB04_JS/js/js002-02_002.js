window.onload = function(){
	document.getElementById("btn").onclick = function(){
		//1.获取ul元素节点
		var ulEle = document.getElementById("ul1");
		//2.创建城市文本节点
		var textNode = document.createTextNode("深圳");
		//3.创建li元素节点
		var liEle = document.createElement("li");
		//4.将城市文本节点添加到li元素节点中去
		liEle.appendChild(textNode);
		//5.将li添加到ul中去
		ulEle.appendChild(liEle);
	}
}
