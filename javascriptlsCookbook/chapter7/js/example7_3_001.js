var badChar;

function listenEvent(eventTarget,eventType,eventHandler){
	if(eventTarget.addEventListener){
		eventTarget.addEventListener(eventType,eventHandler,false);
	}else if(eventTarget.attachEvent){
		eventType = "on" + eventType;
		eventTarget.attachEvent(eventType,eventHandler);
	}else{
		eventTarget["on" + eventType] = eventHandler;
	}
}

function cancelEvent(event){
	if(event.preventDefault){
		event.preventDefault();
	}else{
		event.returnValue = false;
	}
}

window.onload=function(){
	badChar = prompt("Enter the ASCII value of the keyboard key you want to filter","");
	var inputTA = document.getElementById("source");
	listenEvent(inputTA,"keypress",processClick);
}

function processClick(evt){
	evt = evt || window.event;
	var key = evt.charCode ? evt.charCode : evt.keyCode;

	if (key == badChar) cancelEvent(evt);
}
