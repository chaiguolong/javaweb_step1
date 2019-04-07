window.onload=function(){

	var containers = document.querySelectorAll(".tabcontainer");
	for (var j = 0, len = containers.length; j < len; j++) {
		var nav = containers[j].querySelector(".tabnavigation ul");
		nav.style.display="block";

		var navitem = containers[j].querySelector(".tabnavigation ul li");
		var ident = navitem.id.split("_")[1];
		navitem.parentNode.setAttribute("data-current",ident);
		navitem.setAttribute("style","background-color: #f00");

		var pages = containers[j].querySelectorAll(".tabpage");
		for (var i = 1, len = pages.length; i < len; i++) {
			pages[i].style.display = "none";
		}

		var tabs = containers[j].querySelectorAll(".tabnavigation ul li");
		for (var i = 0, len = tabs.length; i < len; i++) {
			tabs[i].onclick=displayPage;
		}
	}
}

function displayPage(){
	var current = this.parentNode.getAttribute("data-current");
	document.getElementById("tabnav_"+current).setAttribute("style","background-color:#fff");
	document.getElementById("tabpage_"+current).style.display="none";

	var ident = this.id.split("_")[1];
	this.setAttribute("style","background-color:#f00");
	document.getElementById("tabpage_" + ident).style.display = "block";
	this.parentNode.setAttribute("data-current",ident);
}
