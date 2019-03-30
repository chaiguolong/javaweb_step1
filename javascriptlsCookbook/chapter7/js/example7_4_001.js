function listenEvent(eventTarget,eventType,eventHandler){
	if(eventTarget.addEventListener){
		eventTarget.addEventListener(eventType,eventHandler,false);
	}else if(eventTarget.attachEvent){
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

function cancelPropagation(event){
	if(event.stopPropagation){
		event.stopPropagation();
	}else{
		event.cancelBubble = true;
	}
}

window.onload=function(){
	var target = document.getElementById("drop");
	listenEvent(target,"dragenter",cancelEvent);
	listenEvent(target,"dragover",dragOver);
	listenEvent(target,"drop",function(evt){
		cancelPropagation(evt);
		evt = evt || window.event;
		evt.dataTransfer.dropEffect = "copy";
		var id = evt.dataTransfer.getData("Text");
		target.appendChild(document.getElementById(id));
	});

	var item = document.getElementById("item");
	item.setAttribute("draggable","true");
	listenEvent(item,"dragstart",function(evt){
		evt = evt || window.event;
		evt.dataTransfer.effectAllowed = "copy";
		evt.dataTransfer.setData("Text",item.id);
	});
};

function dragOver(evt){
	if(evt.preventDefault){
		evt.preventDefault();
	}
	evt = evt || window.event;
	evt.dataTransfer.dropEffect = 'copy';
	return false;
}
