function greetingMaker(greeting){
	function addName(name){
		return greeting + " " + name;
	}
	return addName;
}

window.onload=function(){
	var daytimeGreeting = greetingMaker("Good Day to you");
	var nightGreeting = greetingMaker("Good Evening");

	var name = prompt("Please enter your name","");

	alert(daytimeGreeting(name));

	alert(nightGreeting(name));
}
