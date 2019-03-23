function otherFunction(x,y,z){
	x(y,z);
}
window.onload=function(){
	var param = function(arg1,arg2){
		alert(arg1 + " " + arg2);
	}

	otherFunction(param,"Hello","world");

	otherFunction(function(arg1,arg2){
		alert(arg1 + ' ' + arg2);
	},"Hello","world");
}
