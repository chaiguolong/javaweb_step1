window.onload=function(){
	var refElement = document.getElementById("sister");

	var parent = refElement.parentNode;

	var newDiv = document.createElement("div");

	parent.insertBefore(newDiv,refElement);

	newDiv.innerHTML = "<p>This is the new div element</p>";
}
