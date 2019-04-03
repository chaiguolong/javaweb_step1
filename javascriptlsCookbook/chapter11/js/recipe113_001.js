window.onload=function(){
	var imgString = "";

	var articles = document.getElementsByTagName("article");

	for (var i = 0, len = articles.length; i < len; i++) {
		var imgs = articles[i].getElementsByTagName('img');

		for (var i = 0, len = imgs[i]; i < len; i++) {
			var img = imgs[i];
			imgString += img.src + "<br />";
		}
	}

	document.getElementById("result").innerHTML = imgString;
}
