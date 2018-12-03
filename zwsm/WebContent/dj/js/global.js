function _select(_2,_3) {
	for(i=0;i<document.getElementById(_2).length;i++){
		if (document.getElementById(_2).options[i].value == _3){
		 document.getElementById(_2).options[i].selected=true;
		}
	}
}

var ua = navigator.userAgent.toLowerCase();
	isIE = ((ua.indexOf("msie") != -1) && (ua.indexOf("opera") == -1) && (ua.indexOf("webtv") == -1));
function hideElms(elmTag) {
	for (i=0; i<document.all.tags(elmTag).length; i++){
		obj = document.all.tags(elmTag)[i];
		if (!obj || !obj.offsetParent) continue;
		obj.style.visibility = "hidden";
	}
}

function showElms(elmTag) {
	for (i=0; i<window.parent.document.all.tags(elmTag).length; i++){
		obj = window.parent.document.all.tags(elmTag)[i];
		if (!obj || !obj.offsetParent) continue;
		obj.style.visibility = "visible";
	}
}
function ltrim(s){
 return s.replace( /^\s*/, "");
}

function rtrim(s){
 return s.replace( /\s*$/, "");
}
function trim(s){
	return rtrim(ltrim(s));
}
function CreateFlash(idad, swfurl, wad, had, vs){
	var str = "<object classid=\"clsid:d27cdb6e-ae6d-11cf-96b8-444553540000\" codebase=\"http://fpdownload.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,0,0\" width=\"" + wad + "\" height=\"" + had + "\" id=\"" + idad + "\" align=\"middle\">";
	str += "<param name=\"allowScriptAccess\" value=\"always\">";
	str += "<param name=\"quality\" value=\"high\">";
	str += "<param name=\"movie\" value=\"" + swfurl + "\">";
	str += "<param name=\"flashvars\" value=\"" + vs + "\">";
	str += "<embed src=\"" + swfurl + "\" flashvars=\"" + vs + "\" quality=\"high\" width=\"" + wad + "\" height=\"" + had + "\" name=\"" + idad + "\" align=\"middle\" allowScriptAccess=\"always\" type=\"application/x-shockwave-flash\" pluginspage=\"http://www.macromedia.com/go/getflashplayer\">";
	str += "</object>";
	document.write(str);
}

function sAlert(txt,$uri){
	//var eSrc=(document.all)?window.event.srcElement:arguments[1];
	if(isIE)hideElms('select');
	var shield = document.createElement("DIV");
	shield.id = "shield";
	shield.style.position = "absolute";
	shield.style.left = "0px";
	shield.style.top = "0px";
	shield.style.width = "100%";
	shield.style.height = document.documentElement.clientHeight+"px";
	//((document.documentElement.clientHeight>document.documentElement.scrollHeight)?document.documentElement.clientHeight:document.documentElement.scrollHeight)+"px";
	shield.style.background = "#333";
	shield.style.textAlign = "center";
	shield.style.zIndex = "10000";
	shield.style.filter = "alpha(opacity=0)";
	shield.style.opacity = 0;
	var alertFram = document.createElement("DIV");
	alertFram.id="alertFram";
	alertFram.style.position = "absolute";
	alertFram.style.left = "50%";
	alertFram.style.top = "50%";
	alertFram.style.marginLeft = "-225px" ;
	alertFram.style.marginTop = -75+document.documentElement.scrollTop+"px";
	alertFram.style.width = "450px";
	alertFram.style.height = "150px";
	alertFram.style.background = "#ccc";
	alertFram.style.textAlign = "center";
	alertFram.style.lineHeight = "150px";
	alertFram.style.zIndex = "10001";

	strHtml  = "<div style=\"margin:0px;padding:0px;width:100%\">\n";
	strHtml += "	<div style=\"background:#FF6500;text-align:left;padding-left:20px;font-size:14px;font-weight:bold;height:25px;line-height:25px;border:1px solid #FF9E33;\">[系统提示]</div>\n";
	strHtml += "	<div style=\"background:#fff;text-align:center;font-size:12px;height:120px;line-height:120px;border-left:1px solid #FF9E33;border-right:1px solid #FF9E33;\">"+txt+"</div>\n";
	strHtml += "	<div style=\"background:#FFECDF;text-align:center;font-weight:bold;height:25px;line-height:25px; border:1px solid #FF9E33;\"><input type=\"button\" value=\"确 定\" id=\"do_OK\" onclick=\"doOk('"+$uri+"')\" /></div>\n";
	strHtml += "</div>\n";
	alertFram.innerHTML = strHtml;
	document.body.appendChild(alertFram);
	document.body.appendChild(shield);
	this.setOpacity = function(obj,opacity){
		if(opacity>=1)opacity=opacity/100;
		try{ obj.style.opacity=opacity; }catch(e){}
		try{
			if(obj.filters.length>0&&obj.filters("alpha")){
				obj.filters("alpha").opacity=opacity*100;
			}else{
				obj.style.filter="alpha(opacity=\""+(opacity*100)+"\")";
			}
		}catch(e){}
	}
	var c = 0;
	this.doAlpha = function(){
		if (++c > 20){clearInterval(ad);return 0;}
		setOpacity(shield,c);
	}
	var ad = setInterval("doAlpha()",1);
	this.doOk = function($u){
		document.body.removeChild(alertFram);
		document.body.removeChild(shield);
		//eSrc.focus();
		document.body.onselectstart = function(){return true;}
		document.body.oncontextmenu = function(){return true;}
		if(isIE)showElms_1('select');
		if ($u!='' && $u!='undefined' &&$u!='null')
		{
			document.location.href=$u;
		}
	}
	document.getElementById("do_OK").focus();
	//eSrc.blur();
	document.body.onselectstart = function(){return false;}
	document.body.oncontextmenu = function(){return false;}
}


function showModalWin(root,src,width,height,Arguments,Scroll)
{
   var result = window.showModalDialog(root+src ,Arguments,'scroll:'+ ((Scroll)?"no":"yes") +';status:no;help:no;dialogWidth:' + width + 'px;dialogHeight:' + height + 'px');
   return result;
}
