window.onload=function(){
	var body = document.getElementsByTagName("body")[0];
	var newDiv = document.createElement("div");

	body.appendChild(newDiv);

	newDiv.innerHTML = "<p>New element</p>";
}
