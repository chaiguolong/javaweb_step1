window.onload=function(){
	var elem = document.getElementById("it");
	var rect = elem.getBoundingClientRect();
	var ht;
	if(rect.height){
		ht = rect.height;
	}else{
		ht = rect.bottom - rect.top;
	}

	alert(ht + "px");
}
