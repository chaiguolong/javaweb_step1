window.onload=function(){
	if(window.screen.availWidth >= 800){
		var imgs = document.getElementsByTagName("img");
		for (var i = 0, len = imgs.length; i < len; i++) {
			var name = imgs[i].src.split("-");
			var newname = name[0] + "-big.jpg";
			imgs[i].src = newname;
		}
	}
}
