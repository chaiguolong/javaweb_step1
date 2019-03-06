function showTips(id,info){
	document.getElementById(id+"span").innerHTML='<font style="color:gray">'+info+'</font>';
}

function check(id,info){
	var uValue = document.getElementById(id).value;
	if(uValue == ""){
		document.getElementById(id+"span").innerHTML='<font style="color:red">'+info+'</font>';
	}else{
		document.getElementById(id+"span").innerHTML="";
	}
}
