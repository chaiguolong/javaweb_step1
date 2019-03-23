function makeHello(strName){
	return ("Hello" + strName);
}

window.onload=function(){
	var name = prompt("what's your name ?","");
	var greeting = makeHello(name);
	alert(greeting);
}
