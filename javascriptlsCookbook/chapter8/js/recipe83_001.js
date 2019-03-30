window.onload=function(){
	var browser = navigator.userAgent;
	var info ="<p>Browser: "+ browser +"</p>";

	var platform = navigator.platform;
	info += "<p>Platform: "+ platform +"</p>"

	document.getElementById("output").innerHTML=info;
}
