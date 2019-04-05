window.onload=function(){
	document.getElementById("div1").onclick=addDiv;
}

function addDiv(){
	var parent = this.parentNode;

	var newDiv = document.createElement("div");

	newDiv.className = "divclass";
	newDiv.innerHTML = "<p>I'm here, I'm in the page</p>";

	parent.insertBefore(newDiv,this);
}
