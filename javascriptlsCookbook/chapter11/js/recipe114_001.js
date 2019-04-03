window.onload=function(){
	var imgString = "";

	var imgs = document.querySelectorAll("article img");

	for (var i = 0, len = imgs.length; i < len; i++) {
		var img = imgs[i];
		imgString + img.src + "<br />";
	}
	document.getElementById("result").innerHTML = imgString;
}
