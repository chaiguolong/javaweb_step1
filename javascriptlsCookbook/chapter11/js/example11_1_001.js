window.onload=function(){
	var imgs = document.getElementsByTagName('img');
	alert(imgs.length);
	var p = document.createElement("p");
	var img = document.createElement("img");
	img.src="orchids4.preview.jpg";
	p.appendChild(img);

	var paras = document.getElementsByTagName("p");
	paras[0].parentNode.appendChild(p);

	alert(imgs.length);
}
