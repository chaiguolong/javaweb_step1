window.onload=function(){
	var aimgs = document.getElementsByTagName("a");
	aimgs[0].focus();
	for (var i = 0, len = aimgs.length; i < len; i++) {
		aimgs[i].onclick=imgClick;
	}
}

function imgClick(){
	var img = this.firstChild;
	expandPhoto(img.getAttribute("data-larger"));
	return false;
}

function expandPhoto(src){
	var overlay = document.createElement("div");
	overlay.setAttribute("id","overlay");
	overlay.setAttribute("class","overlay");

	document.body.appendChild(overlay);

	var img = document.createElement("img");
	img.src = src;
	img.setAttribute("id","img");

	img.setAttribute("tabindex","-1");

	img.setAttribute("class","overlayimg");

	img.onclick=restore;
	img.onkeydown=imgKeyDown;

	document.body.appendChild(img);

	img.focus();
}

function restore(){
	document.body.removeChild(document.getElementById("overlay"));
	document.body.removeChild(document.getElementById("img"));
}

function imgKeyDown(evnt){
	evnt = (evnt) ? evnt : ((window.event) ? window.event : "");
	var keycode = (evnt.which) ? evnt.which : evnt.keyCode;
	if(document.getElementById("overlay")){
		if(keycode === 27){
			restore();
			return false;
		}
	}else{
		if(keycode == 13){
			var img = this.firstChild;
			var src = img.getAttribute("data-larger");
			expandPhoto(src);
			return false;
		}
	}
	return true;
}
