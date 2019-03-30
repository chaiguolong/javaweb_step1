function listenEvent(eventObj,event,eventHandler){
	if(eventObj.addEventListener){
		eventObj.addEventListener(event,eventHandler,false);
	}else if(eventObj.attachEvent){
		event = "on" + event;
		eventObj.attachEvent(event,eventHandler);
	}else{
		eventObj["on" + event] = eventHandler;
	}
}

function stopListening(eventObj,event,eventHandler){
	if(eventObj.removeEventListener){
		eventObj.removeEventListener(event,eventHandler,false);
	}else if(eventObj.detachEvent){
		event = "on" + event;
		eventObj.detachEvent(event,eventHandler);
	}else{
		eventObj["on" + event] = null;
	}
}

function cancelEvent(event){
	if(event.preventDefault){
		event.preventDefault();
	}else{
		event.returnValue = false;
	}
}

listenEvent(window,"load",function(){
	var theform = document.getElementById("theform");
	listenEvent(theform,"submit",validateForm);
});

function validateForm(evt){
	evt = evt || window.event;

	cancelEvent(evt);
}
