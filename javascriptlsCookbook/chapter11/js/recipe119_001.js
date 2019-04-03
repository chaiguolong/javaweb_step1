window.onload=function(){
	try {
		var elems = document.querySelectorAll("*[class]");
		if(elems.length > 0){
			alert("found " + elems.length + " elements");
		}

		elems = document.querySelectorAll("*[class='red']");
		if(elems.length > 0){
			alert("found " + elems.length + " elements");
		}

		elems = document.querySelectorAll("*:not(.red)");
		if(elems.length > 0){
			alert("found " + elems.length + " elements");
		}
	} catch (e) {
		alert("example does not work in your browser");
	}
}
