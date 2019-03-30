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

function startListening(){
	var box = document.getElementById("box");
	listenEvent(box,"click",clickBox);
}

function clickBox(){
	alert("click!");
}

function stopClick(){
	var box = document.getElementById("box");
	stopListening(box,"click",clickBox);
}

listenEvent(window,"load",function(){
	var bttn1 = document.getElementById("start");
	listenEvent(bttn1,"click",startListening);

	var bttn2 = document.getElementById("stop");
	listenEvent(bttn2,"click",stopClick);
});
