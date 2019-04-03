window.onload=function(){
	var outputString="";

	var div = document.getElementById("demodiv");
	var classnm = div.getAttribute("class");

	outputString += "demodiv has class " + classnm + "<br />";

	var parent = div.parentNode;
	outputString += " parent node is " + parent.nodeName + "<br />";

	if(div.hasChildNodes()){
		var children = div.childNodes;
		for (var i = 0, len = children.length; i < len; i++) {
			outputString += " has child " + children[i].nodeName +" <br /> ";
		}
	}

	document.getElementById("result").innerHTML = outputString;
}
