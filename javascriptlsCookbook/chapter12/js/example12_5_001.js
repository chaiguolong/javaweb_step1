window.onload=function(){
	var paras = document.getElementsByTagName("p");
	for (var i = 0, len = paras.length; i < len; i++) {
		paras[i].onclick=pruneparagraph;
	}
}

function pruneparagraph(){
	var parent = this.parentNode;
	parent.removeChild(this);

	alert("paras " + document.getElementsByTagName("p").length);
}
