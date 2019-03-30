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

function clickBoxOne(evt){
	alert("Hello from One");
}

function clickBoxTwo(evt){
	alert("Hi from Two");
	if(stopPropagation){
		cancelPropagation(evt);
	}
}

function cancelPropagation(event){
	if(event.stopPropagation){
		event.stopPropagation();
	}else{
		event.cancelBubble = true;
	}
}

function stopProp(){
	stopPropagation = true;
}

listenEvent(window,"load",function(){
	listenEvent(document.getElementById("one"),"click",clickBoxOne);
	listenEvent(document.getElementById("two"),"click",clickBoxTwo);
	listenEvent(document.getElementById("stop"),"click",stopProp);
});
