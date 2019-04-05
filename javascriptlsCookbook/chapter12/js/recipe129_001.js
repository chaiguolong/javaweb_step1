window.onload=function(){

	var targetNode = document.getElementById("target");
	if(targetNode.hasAttribute("class")){
		targetNode.removeAttribute("class");
		alert(targetNode.getAttribute("class"));
	}
}
