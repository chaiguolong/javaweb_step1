window.onload=function(){
	if(document.getElementsByClassName){
		var elems = document.getElementsByClassName("red");
		alert("found " + elems.length + " elements");
	}

	elems = document.querySelectorAll(".red");
	alert("found " + elems.length + " elements");
}
