window.onload=function(){
	var func = prompt("Enter function body:","");
	var x = prompt("Enter value for x:","");
	var y = prompt("Enter value for y:","");

	var newFun = new Function("x","y",func);
	var result = newFun(x,y);
}
