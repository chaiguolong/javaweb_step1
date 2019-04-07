window.onload=function(){
	var x = document.getElementById("x");
	x.setAttribute("style","display:block");

	x.onclick=expandOrShrink;
	x.onkeypress=expandOrShrink;
}

function expandOrShrink(){
	if(this.getAttribute("data-expand") == "true"){
		document.getElementById("sidebar").setAttribute("style","width: 50px");
		document.getElementById("main").setAttribute("style","width: 700px");

		this.setAttribute("data-expand","false");
	}else{
		document.getElementById("sidebar").setAttribute("style","width:240px");
		document.getElementById("main").setAttribute("style","width:500px");

		this.setAttribute("data-expand","true");
	}
}
