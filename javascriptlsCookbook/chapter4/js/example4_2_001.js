function compStyle(elemId,property){
	var elem = document.getElementById(elemId);
	var style;
	if(window.getComputedStyle){
		style=window.getComputedStyle(elem,null).getPropertyValue(property);
	}else if(elem.currentStyle){
		style=elem.currentStyle[property];
	}
		return style;
}

window.onload = function(){
	var height = parseInt(compStyle("elem","height"));
	var width = parseInt(compStyle("elem","width"));

	var x = width / 2;
	var y = height / 2;

	var circleRadius = Math.min(width,height) / 2;

	var circ = document.getElementById("circ");

	circ.setAttribute("r",circleRadius);
	circ.setAttribute("cx",x);
	circ.setAttribute("cy",y);
}
