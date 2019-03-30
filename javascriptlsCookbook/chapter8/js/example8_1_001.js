window.onload=function(){
	var items = location.pathname.substr(1).split("/");

	var mainpath = "<a href='"+location.protocol+"//"+location.hostname+"/";
	

	var breadcrumbTrail = "<p>";
	for (var i = 0, len = items.length; i < len; i++) {
		if(items[i].length == 0) break;

		mainpath += items[i];

		if(i < items.length -1) mainpath += "/";

		if(i > 0 && i < items.length) breadcrumbTrail += " -> ";

		breadcrumbTrail += mainpath + "'>" + items[i] + "</a>";
	}

	breadcrumbTrail += "</p>";
	document.getElementById("breadcrumb").innerHTML = breadcrumbTrail;
}
