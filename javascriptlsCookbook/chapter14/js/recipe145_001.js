var elements = document.querySelectorAll(".elements");
for (var i = 0, len = elements.length; i < len; i++) {
	elements[i].style.display="none";
	elements[i].setAttribute("aria-hidden","true");
}

var labels = document.querySelectorAll(".label");
for (var i = 0, len = labels.length; i < len; i++) {
	labels[i].onclick=switchDisplay;
	labels[i].style.display="block";
	labels[i].setAttribute("aria-expanded","false");
}

function switchDisplay(){
	var parent = this.parentNode;
	var targetid = "panel_" + this.id.split("_")[1];
	var target = document.getElementById(targetid);

	if(this.getAttribute("aria-expanded") == "true"){
		this.setAttribute("aria-expanded","false");
		target.style.display="none";
		target.setAttribute("aria-hidden","true");
	}else{
		this.setAttribute("aria-expanded","true");
		target.style.display="block";
		target.setAttribute("aria-hidden","false");
	}
	return false;
}
