window.onload=function(){
	var div = document.getElementById("target");

	var txt = prompt("Enter new paragraph text","");

	var oldPara = div.getElementsByTagName("p")[0];

	var txtNode = document.createTextNode(txt);

	var para = document.createElement("p");

	para.appendChild(txtNode);

	div.insertBefore(para,oldPara);
}
