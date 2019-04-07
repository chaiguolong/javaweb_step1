var xmlhttp;

function manageEvent(eventObj,event,eventHandler){
	if(eventObj.addEventListener){
		eventObj.addEventListener(event,eventHandler,false);
	}else if(eventObj.attachEvent){
		event = "on" + event;
		eventObj.attachEvent(event, eventHandler);
	}
}

function getInfo(evt){
	evt = evt || window.event;

	if(!xmlhttp){
		xmlhttp = new XMLHttpRequest();
	}
	var value;
	if(this.id){
		value = this.id;
	}else{
		value = evt.srcElement.id;
	}

	var url = "photos.php?photo=" + value;
	xmlhttp.open('GET',url,true);
	xmlhttp.onreadystatechange = showWindow;
	xmlhttp.send(null);

	return false;
}

function compPos(obj){
	var rect = obj.getBoundingClientRect();
	var height;
	if(rect.height){
		height = rect.height;
	}else{
		height = rect.bottom - rect.top;
	}
	var top = rect.top + height + 10;
	return [rect.left,top];
}

function showWindow(){
	if(xmlhttp.readyState == 4 && xmlhttp.status == 200){
		var response = xmlhttp.responseText.split("#");
		var img = document.getElementById(response[0]);
		if(!img){
			return;
		}

		var loc = compPos(img);
		var left = loc[0] + "px";
		var top = loc[1] + "px";

		var div = document.createElement("popup");
		div.id = "popup";
		var txt = document.createTextNode(response[1]);
		div.appendChild(txt);

		div.setAttribute("class","popup");
		div.setAttribute("style","left: "+ left + "; top: " + top);
		document.body.appendChild(div);
	}
}

function removeWindow(){
	var popup = document.getElementById("popup");
	if(popup){
		popup.parentNode.removeChild(popup);
	}
	return false;
}

window.onload=function(){
	var imgs = document.getElementsByTagName("img");
	for (var i = 0, len = imgs.length; i < len; i++) {
		manageEvent(imgs[i],"mouseover",getInfo);
		manageEvent(imgs[i],"mouseout",removeWindow);
	}
}
