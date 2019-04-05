function getStyle(elem,cssprop,cssprop2){
	if(elem.currentStyle){
		return elem.currentStyle[cssprop];
	}else if(document.defaultView && document.defaultView.getComputedStyle){
		return document.defaultView.getComputedStyle(elem,null).getPropertyValue(cssprop2);
	}else{
		return null;
	}
}

window.onload=function(){
	var elem = document.getElementById("elem");
	var color = getStyle(elem,"backgroundColor","background-color");
	alert(color);

	elem.style.width = "500px";
	elem.style.backgroundColor="yellow";

	alert(elem.style.width);
	alert(elem.style.backgroundColor);

	elem.style["fontFamily"] = "Courier";

	var style = elem.getAttribute("style");
	alert(style);

	elem.setAttribute("style","height: 100px");
	var style = elem.getAttribute("style");
	alert(style);

	var font = getStyle(elem,"fontFamily","font-family");
	alert(font);

}
