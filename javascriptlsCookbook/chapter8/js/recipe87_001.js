window.onload=function(){
	var items = location.pathname.substr(1).split("/");
	var breadcrumbTrail = "<p>";
	for (var i = 0, len = items.length; i < len; i++) {
		breadcrumbTrail += " -> " + items[i];
	}
	breadcrumbTrail += "</p>";

	document.getElementById("output").innerHTML = breadcrumbTrail;

}
