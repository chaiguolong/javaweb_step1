window.onload=function(){
	var containers = document.querySelectorAll(".tabcontainer");
	for (var i = 0; i< containers.length; i++) {
		var nav = containers[i].querySelector(".tabnavigation ul");
		nav.style.display = "block";

		var navitem = containers[i].querySelector(".tabnavigation ul li");
		var ident = navitem.id.split("_")[1];
		navitem.parentNode.setAttribute("data-current",ident);
		navitem.setAttribute("style","background-color:#ccf");

		var pages = containers[i].querySelectorAll(".tabpage");
		for (var j = 1;j< pages.length; j++) {
			pages[j].style.display="none";
			pages[j].setAttribute("aria-hidden","true");
		}

		var tabs = containers[i].querySelectorAll(".tabnavigation ul li");
		for (var j = 0;j<tabs.length; j++) {
			tabs[j].onclick=displayPage;
		}
	}
}

function displayPage(){
	var current = this.parentNode.getAttribute("data-current");
	var oldpanel = document.getElementById("tabpage_" + current);

	document.getElementById("tabnav_" + current).setAttribute("style","background-color:#fff");
	oldpanel.style.display="none";
	oldpanel.setAttribute("aria-hidden","true");

	var ident = this.id.split("_")[1];
	this.setAttribute("style","background-color:#ccf");
	var newpanel = document.getElementById("tabpage_"+ident);

	newpanel.style.display="block";
	newpanel.setAttribute("aria-hidden","false");
	this.parentNode.setAttribute("data-current",ident);

	return false;
}
