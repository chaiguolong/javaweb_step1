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

window.onload=function(){
	document.getElementById("input1").onchange=textChanged;
	document.getElementById("input2").onblur=checkValue;
	document.getElementById("check1").onclick=getCheck;
	listenEvent(document.getElementById("button1"),"click",handleClick);
}

function textChanged(){
	alert(this.value);
}

function checkValue(){
	var val = this.value;
	var t = this;
	val = val.replace(/^\s\s*/,'').replace(/\s\s*$/,'');
	if(val.length == 0){
		alert("need value!");
	}
}

function getCheck(){
	var checked = this.checked;
	if(checked){
		alert("checked!");
	}
}

function handleClick(evt){
	evt = evt || window.event;
	var elem;
	if(evt.srcElement){
		elem = evt.srcElement;
	}else{
		elem = this;
	}
	alert(elem.id);
}
