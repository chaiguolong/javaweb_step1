window.onload=function(){
	var targetNode = document.getElementById("target");
	var newAttr = document.createAttribute("newattr");
	newAttr.nodeValue = "red";
	targetNode.setAttributeNode(newAttr);
	alert(targetNode.getAttribute("newattr"));

	targetNode.setAttribute("newattr2","blue");
	alert(targetNode.getAttribute("newattr2"));
}
