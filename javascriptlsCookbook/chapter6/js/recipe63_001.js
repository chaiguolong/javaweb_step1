function makeHello(name){
	name[name.length] = "Hello " + name[0] + " " + name[1];
}

window.onload = function(){
	var name = new Array('I ma','Reader');
	makeHello(name);
	alert(name[2]);
}
