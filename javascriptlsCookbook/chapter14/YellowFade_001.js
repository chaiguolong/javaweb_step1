var FadeInterval = 100;

var StartFadeAt = 7;

var FadeSteps = new Array();
FadeSteps[1] = "ff";
FadeSteps[2] = "ee";
FadeSteps[3] = "dd";
FadeSteps[4] = "cc";
FadeSteps[5] = "bb";
FadeSteps[6] = "aa";
FadeSteps[7] = "99";

var W3CDOM = (document.createElement && document.getElementsByTagName);
addEvent(window,'load',initFades);

function addEvent(obj,eventType,fn,useCapture){
	if(obj.addEventListener){
		obj.addEventListener(eventType,fn,useCapture);
		return;
	}else{
		if(obj.attachEvent){
			var r = obj.attachEvent("on" + eventType,fn);
			return r;
		}
	}
}

function initFades(){
	if(!W3CDOM){
		return;
	}

	var currentURL = unescape(window.location);

	if(currentURL.indexOf('#') > -1){
		DoFade(StartFadeAt,currentURL.substring(currentURL.indexOf('#')+1,currentURL.length));
	}

	var anchors = document.body.getElementsByTagName('a');

	for (var i = 0, len = anchors.length; i < len; i++) {
		if(anchors[i].href.indexOf('#') > -1){
			anchors[i].onclick = function(){
				Highlight(this.href);
				return true;
			}
		}
	}

	var fader = document.getElementById('fade');
	if(fader){
		DoFade(StartFadeAt,'fade');
		focuser = document.getElementById('error');
		focuser.tabIndex = -1;
		focuser.focus();
	}
}

function Highlight(target){
	var targetId = target.substring(target.indexOf('#')+1,target.length);
	DoFade(StartFadeAt,targetId);
}

function DoFade(colorId,targetId){
	if(colorId >= 1){
		document.getElementById(targetId).style.background = "#ffff" + FadeSteps[colorId];

		if(colorId == 1){
			document.getElementById(targetId).style.backgroundColor = "#fff";
		}
		colorId--;

		setTimeout("DoFade("+colorId+",'"+targetId+"')",FadeInterval);
	}

	if(document.getElementById(targetId).nodeName == "INPUT" || document.getElementById(targetId).nodeName == "SELECT"){
		document.getElementById(targetId).focus();
	}
}
