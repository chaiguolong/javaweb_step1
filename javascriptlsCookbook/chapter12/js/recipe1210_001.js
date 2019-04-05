window.onload=function(){
	var para = document.getElementsByTagName("p");
	var parent = para[0].parentNode;
	parent.insertBefore(para[para.length-1],para[0]);
}
