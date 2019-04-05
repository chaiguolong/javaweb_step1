window.onload=function(){

	var targetNode = document.getElementById("target");
	if(targetNode.hasAttribute("class")){
		alert(targetNode.getAttribute("class"));
	}
}
