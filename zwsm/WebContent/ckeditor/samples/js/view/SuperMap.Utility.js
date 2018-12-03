//========================================================================== 
// SuperMap iServer 客户端程序，版权所有，北京超图软件股份有限公司，2000-2008。 
// 本程序只能在有效的授权许可下使用。未经许可，不得以任何手段擅自使用或传播。 
// 作者：			SuperMap iServer Team 
// 修改：	 
// 文件名：			SuperMap.Utility.js  
// 功能：			辅助方法   
// 最后修改时间：	2008-1-8
//========================================================================== 
Type.registerNamespace("SuperMap");
SuperMap.Utility = function(){
	/// <summary>
	/// 公用函数集合。
	/// </summary>
	/// <returns type="object">返回一个 object 对象。</returns>
};
SuperMap.Utility.registerClass('SuperMap.Utility', null, Sys.IDisposable);

SuperMap.Utility.floor = function(d){
/// <summary>传回参数 d 所指定数字或运算式的最大整数。&lt;br&gt;
/// 最大整数是指小于或等于指定数字或运算式的最接近整数。&lt;br&gt;
/// 例如：SuperMap.Utility.floor(12.5)返回值为12; SuperMap.Utility.floor(-6.5)返回值为-7。
/// </summary>
/// <param name="d" type="Number">一个数字或表达式。</param>
/// <returns type="Number">最接近且小于或等于参数 d 的整数。</returns>
    return Math.floor(d);
};

SuperMap.Utility.ceil = function(d){
/// <summary>返回指定数字或表达式的上限值。&lt;br&gt;
/// 数字的上限值是大于等于该数字的最接近的整数。&lt;br&gt;
/// 例如：SuperMap.Utility.ceil(12.5)的返回值为13。 
/// </summary>
/// <param name="d" type="Number">一个数字或表达式。</param>
/// <returns type="Number">最接近且大于等于参数 d 的一个整数。</returns>
    return Math.ceil(d);
};

SuperMap.Utility.max = function(d,f){
/// <summary>计算 d 和 f，并返回两者中的较大值。</summary>
/// <param name="d" type="Number">一个数字或表达式。</param>
/// <param name="f" type="Number">一个数字或表达式。</param>
/// <returns type="Number">一个数字。</returns>
    return Math.max(d,f);
};

SuperMap.Utility.min = function(d,f){
/// <summary>计算 d 和 f，并返回两者中的较小值。</summary>
/// <param name="d" type="Number">一个数字或表达式。</param>
/// <param name="f" type="Number">一个数字或表达式。</param>
/// <returns type="Number">一个数字。</returns>
    return Math.min(d,f);
};

SuperMap.Utility.abs = function(d){
/// <summary>计算并返回由参数 d 指定的数字的绝对值。</summary>
/// <param name="d" type="Number">一个数字。</param>
/// <returns type="Number">一个数字。</returns>
    return Math.abs(d);
};

SuperMap.Utility.round = function(d){
/// <summary>将参数 d 的值向上或向下舍入为最接近的整数并返回该值。&lt;br&gt;
/// 如果参数 d 与两个最接近的两个整数等距离（即该数字以 .5 结尾），则该值向上舍入为相邻的较大整数。
/// </summary>
/// <param name="d" type="Number">一个数字。</param>
/// <returns type="Number">一个整数。</returns>
    return Math.round(d);
};

SuperMap.Utility.angleToRadian = function(angle){
/// <summary>将指定的一个角度转为弧度。</summary>
/// <param name="angle" type="Number">要转换的角度。</param>
/// <returns type="Number">返回弧度值。</returns>
    return angle*Math.PI/180.0;
};

SuperMap.Utility.radianToAngle = function(radian){
/// <summary>将指定的一个弧度转为角度。</summary>
/// <param name="radian" type="Number">要转换的弧度。</param>
/// <returns type="Number">返回一个角度值。</returns>
    return radian*180.0/Math.PI;
};

SuperMap.Utility.getElementX = function(el){
/// <summary>获取一个页面元素的最左边的像素位置。</summary>
/// <param name="el" type="Object" domElement="true">页面元素。</param>
/// <returns type="Number">返回页面元素的最左边的像素位置。</returns>
    var element = el;
    var x = 0;
    while(element){
        x += element.offsetLeft;
        element = element.offsetParent;
    }
    if(navigator.userAgent.indexOf("Mac") != -1 && typeof(document.body.leftMargin) != "undefined"){
        x += document.body.leftMargin;
    }
    return x;
};

SuperMap.Utility.getElementY = function(el){
/// <summary>获取一个页面元素的最上边的像素位置。</summary>
/// <param name="el" type="Object" domElement="true">页面元素。</param>
/// <returns type="Number">页面元素的最上边的像素位置。</returns>
    var element = el;
    var y = 0;
    while(element){
        y += element.offsetTop;
        element = element.offsetParent;
    }
    if(navigator.userAgent.indexOf("Mac") != -1 && typeof(document.body.topMargin) != "undefined"){
        y += document.body.topMargin;
    }
    return y;
};

SuperMap.Utility.getEvent = function(e){
/// <summary>获取页面事件。</summary>
/// <param name="e" type="Object">事件参数对象。</param>
/// <returns type="Object">如果e存在，则返回e；如果e不存在，则返回window.event。</returns>
    return e ? e : window.event;
};

SuperMap.Utility.getMouseX = function(e){
/// <summary>获取鼠标事件发生的X坐标。</summary>
/// <param name="e" type="Object">事件参数对象。</param>
/// <returns type="Number">返回鼠标事件发生的X坐标。</returns>
    var posX = 0;
    if(e.pageX){
        posX = e.pageX;
    }else if(e.clientX){
        if(document.documentElement && document.documentElement.scrollLeft){
            posX = e.clientX + document.documentElement.scrollLeft;
        }else if(document.body){
            posX = e.clientX + document.body.scrollLeft;
        }
    }
    return posX;
};

SuperMap.Utility.getMouseY = function(e){
/// <summary>获取鼠标事件发生的Y坐标。</summary>
/// <param name="e" type="Object">事件参数对象。</param>
/// <returns type="Number">返回鼠标事件发生的Y坐标。</returns>
    var posY = 0;
    if(e.pageY){
        posY = e.pageY;
    }else if(e.clientY){
        if(document.documentElement && document.documentElement.scrollTop){
            posY = e.clientY + document.documentElement.scrollTop;
        }else if(document.body){
            posY = e.clientY + document.body.scrollTop;
        }
    }
    return posY;
};

SuperMap.Utility.getMouseScrollDelta = function(e){
/// <summary>获取鼠标滚动事件的滚动量。</summary>
/// <param name="e" type="Object">事件参数对象。></param>
/// <returns type="Number">返回鼠标滚动事件的滚动量。</returns>
    if(e.rawEvent.wheelDelta){
        return e.rawEvent.wheelDelta;
    }else if(e.rawEvent.detail){
        return -e.rawEvent.detail;
    }
    return 0;
};

SuperMap.Utility.getTarget = function(e){
/// <summary>获取触发鼠标事件的DOM对象。</summary>
/// <param name="e" type="Object">事件参数对象。></param>
/// <returns type="Number">返回触发鼠标事件的DOM对象。</returns>
    if(!e){
        e = window.event;
    }
    var t = null;
    if(e.srcElement){
        t = e.srcElement;
    }else if(e.target){
        t = e.target;
    }
    if(t && t.nodeType){
        if(t.nodeType == 3){
            t = targ.parentNode;
        }
    }
    return t;
};

SuperMap.Utility.cancelBubble = function(e){
/// <summary>取消页面的DOM事件上面的DOM元素传递。</summary>
/// <param name="e" type="Object">事件参数对象。></param>

    e.cancelBubble=true;
};

SuperMap.Utility.enableVML = function(){
/// <summary>支持VML。</summary>

    if(_GetBrowser() != "ie"){return;}
	// todo: support ie5.0, ie5.5
	if(document.namespaces){
		document.namespaces.add("v", "urn:schemas-microsoft-com:vml")
	}
	if(document.styleSheets.length < 1){
		var _oStyle = document.createElement("style");
		document.body.appendChild(_oStyle);
	}
	if(document.styleSheets.item(0).addRule){
		document.styleSheets.item(0).addRule("v\\:shape", "behavior:url(#default#VML)");
	}
};


SuperMap.Utility.getXmlHttpRequest = function(){
/// <summary>获取HTTPRequest对象。</summary>
/// <returns type="Object">返回一个HTTPRequest对象。</returns>
	var xh = null;
	try{
	    xh = new ActiveXObject("Msxml2.XMLHTTP");
	}catch(ex){
		try{
		    xh = new ActiveXObject("Microsoft.XMLHTTP");
		}catch(ex){
		    xh=null;
		}
    }
	if(!xh && typeof XMLHttpRequest != "undefined"){
	    xh = new XMLHttpRequest();
	}
	
	return xh;
};

SuperMap.Utility.convertHTMLToESC = function(html){
/// <summary>将HTML字符串转换成ESC字符串，即将HTML字符串中的特殊字符转义。</summary>
/// <param name="html" type="String">要转换的HTML字符串。</param>
/// <returns type="String">返回一个ESC字符串。</returns>
	html =html.replace(/&/g, "&amp;");    
	html = html.replace(/\"/g, "&quot;");
	html =html.replace(/</g, "&lt;");    
	html =html.replace(/>/g, "&gt;");    
	html =html.replace(/\'/g, "&apos;");
	return html;
};

SuperMap.Utility.convertESCToHTML = function(esc){
/// <summary>将ESC字符串转换成HTML字符串，即将ESC字符串中的特殊字符转义。</summary>
/// <param name="esc" type="String">要转换的ESC字符串。</param>
/// <returns type="String">返回一个HTML字符串。</returns>
	esc = esc.replace(/&amp;/g,"&");
	esc = esc.replace(/&quot;/g,"\"");
	esc = esc.replace(/&lt;/g,"<");
	esc = esc.replace(/&gt;/g,">");
	esc = esc.replace(/&apos;/g,"\'");
	return esc;
};

SuperMap.Utility.getFunctionName = function(fun){
/// <summary>获取函数名称，不要内容。</summary>
/// <param name="fun" type="Function">函数。</param>
/// <returns type="String">返回fun的函数名称。</returns>
    var funContent = fun.toString();
    var startIndex = funContent.indexOf(" ");
    var endIndex = funContent.indexOf("(");
    return funContent.substring(startIndex + 1, endIndex); 
};

SuperMap.Utility.showProperties = function (obj, objName) {
/// <summary>显示obj对象的属性，将obj对象的多有属性组织成一个字符串返回。</summary>
/// <param name="obj" type="object">object对象。</param>
/// <param name="objName" type="String">Obj对象的名称。</param>
/// <returns type="String">返回一个字符串，该字符串表达了obj对象的所有属性。
/// 其组织形式为 objName.i=obj[i]\n
/// </returns>
   var result = "";
   for (var i in obj) {
      result += objName + "." + i + " = " + obj[i] + "\n";
   }
   return result;
}; 

SuperMap.Utility.splitX = function(points, offsetX){
/// <summary>将points数组中每一个point对象的X值提取出来组成一个数组。</summary>
/// <param name="points" type="Array" elementType="SuperMap.Point">SuperMap.Point对象数组。</param>
/// <param name="offsetX" type="Number">X方向的偏移量。</param>
/// <returns type="Array" elementType="Number">返回一个数组，该数组表达Points数组中每一个Point对象的X值。</returns>
	if(typeof(offsetX) == "undefined"){
	    offsetX = 0;
	}
	var pxs = new Array();
	for(var i = 0; i < points.length / 2; i++){
	    pxs.push(parseInt(points[2 * i]) + parseInt(offsetX));
	}
	
	return pxs;
};

SuperMap.Utility.splitY = function(points, offsetY){
/// <summary>将points数组中每一个point对象的Y值提取出来组成一个数组。</summary>
/// <param name="points" type="Array" elementType="SuperMap.Point">SuperMap.Point对象数组。</param>
/// <param name="offsetY" type="Number">Y方向的偏移量。</param>
/// <returns type="Array" elementType="Number">返回一个数组，该数组表达Points数组中每一个Point对象的Y值。</returns>
	if(typeof(offsetY) == "undefined"){
	    offsetY = 0;
	}
	var pys = new Array();
	for(var i = 0; i < points.length / 2; i++){
	    pys.push(parseInt(points[2 * i + 1]) + parseInt(offsetY));
	}
	
	return pys;
};

SuperMap.Utility.toJSON = function(o){
/// <summary>将对象转换成JSON字符串</summary>
/// <param name="o" type="Object">要转换成JSON的Object对象。</param>
/// <returns type="Object">返回转换后的JSON对象。</returns>
	if(o == null)
		return "null";

	switch(o.constructor) {
		case String:
			var s = o; // .encodeURI();
			s = '"' + s.replace(/(["\\])/g, '\\$1') + '"';
			s = s.replace(/\n/g,"\\n");
			s = s.replace(/\r/g,"\\r");
			s = s.replace(/</g, "&lt;");
			s = s.replace(/>/g, "&gt;");
			s = s.replace(/%/g, "%25");
			s = s.replace(/&/g, "%26");
			return s;
		case Array:
			var v = [];
			for(var i=0; i<o.length; i++)
				v.push(SuperMap.Utility.toJSON(o[i])) ;
			return "[" + v.join(", ") + "]";
		case Number:
			return isFinite(o) ? o.toString() : SuperMap.Utility.toJSON(null);
		case Boolean:
			return o.toString();
		case Date:
			var d = new Object();
			d.__type = "System.DateTime";
			d.Year = o.getUTCFullYear();
			d.Month = o.getUTCMonth() +1;
			d.Day = o.getUTCDate();
			d.Hour = o.getUTCHours();
			d.Minute = o.getUTCMinutes();
			d.Second = o.getUTCSeconds();
			d.Millisecond = o.getUTCMilliseconds();
			d.TimezoneOffset = o.getTimezoneOffset();
			return SuperMap.Utility.toJSON(d);
		default:
			if(o["toJSON"] != null && typeof o["toJSON"] == "function")
				return o.toJSON();
			if(typeof o == "object") {
				if(o.length) {
					var v = [];
					for(var i=0; i<o.length; i++)
						v.push(SuperMap.Utility.toJSON(o[i]));
					return "[" + v.join(", ") + "]";
				}
				var v=[];
				for(attr in o) {
					if(typeof o[attr] != "function")
						v.push('"' + attr + '":' + SuperMap.Utility.toJSON(o[attr]));
				}

				if(v.length>0)
					return "{" + v.join(", ") + "}";
				else
					return "{}";		
			}
			return o.toString();
	}
};

SuperMap.Utility.fromJSON = function(o, j){
/// <summary>将JSON字符串转换成对象。</summary>
/// <param name="o" type="Object">要从JSON对象中转成对象的Object对象。</param>
/// <param name="j" type="Object">要转换的JSON对象。</param>
    if(!j){return;}
    for(var m in j){
        if(typeof(o[m]) == "object"){
            SuperMap.Utility.fromJSON(o[m], j[m]);
        }
        else if(typeof(o[m]) != "function" && typeof(o[m]) != "undefined"){
            o[m] = j[m];
        }
    }
};

SuperMap.Utility.actionToJSON = function(type, params){
/// <summary>将一个Action对象转换成JSON字符串。</summary>
/// <param name="type" type="String">Action对象的type属性值。</param>
/// <param name="params" type="Array" elementType="Object">Action对象的属性或者函数的数组。</param>
/// <returns type="String">返回一个JSON字符串。</returns>
    var json = "";
    if(!type){return;}
    var o = new Object();   
    o.type = type;
    
    if(params){
        o.params = params;
        if(o.params.length>0){
            for(var i=0;i<o.params.length;i++){
                if(typeof(o.params[i])=="function"){
                    //并加一个标识
                    o.params[i] = "*function*:"+SuperMap.Utility.getFunctionName(o.params[i]);
                }
            }
        }
    }
    return json;

};

SuperMap.Utility.jSONToAction = function(json){
/// <summary>将一个JSON字符串转换成Action对象。</summary>
/// <param name="json" type="String">要转换的JSON字符串。</param>
/// <returns type="Object">返回一个Action对象。</returns>
    var o=eval('('+json+')');
    var strParams="";
    if(o.params)
    {
        for(var i=0;i<o.params.length;i++){
            strParams +="o.params["+i+"],"; 
        }
    }
    var str = "new "+o.type+"("+strParams+o.onComplete+","+o.onError+","+o.onStart+")";
    return eval(str);
    
};

SuperMap.Utility.findDifference = function(_layersBackup, layers){
/// <summary>比较_layersBackup和layers的不同，返回JSON字符串，该JSON字符串表达它们的不同处。</summary>
/// <param name="_layersBackup" type="object">Layer数组的备份对象。</param>
/// <param name="layers" type="Array" elementType="SuperMap.Layer">Layer数组。</param>
/// <returns type="String">返回一个JSON字符串，该JSON字符串表达它们的不同处。</returns>
    var changedLayersJSON = "";
    var changedLayers = new Array();
    var index;
    //就取_layers的
    index = layers.length;
    for(var i = 0; i < index; i++){
        if(layers[i] && _layersBackup){
            if(!_layersBackup[i]){
                if(changedLayers.length > 0){
                    changedLayersJSON = changedLayersJSON + ",";
                }
                //changedLayers.push(_layers[i]);
                changedLayers[i]=layers[i];
                changedLayersJSON+=i.toString();
                continue;
            }
            var o = _layersBackup[i].compare(layers[i]);
           
            if(o){
                /*
                if(changedLayers.length>0){changedLayersJSON =changedLayersJSON+",";}
                changedLayersJSON+=i.toString();
                changedLayersJSON+="|";
                if(o.themeRange&&o.themeRange.breakValueIndex)
                {
                    changedLayersJSON+=o.themeRange.breakValueIndex;  
                }
                changedLayersJSON+="|";
                if(o.themeRange&&o.themeRange.displaysIndex)
                {
                    changedLayersJSON+=o.themeRange.displaysIndex;
                }
                changedLayersJSON+="|";
                if(o.themeGraph&&o.themeGraph.graphStyleIndex)
                {
                    changedLayersJSON+=o.themeGraph.graphStyleIndex;
                }
                */
                changedLayers[i] = o;
            }else{
                changedLayers[i] = "nochanged";
            }
        }else{
            //layer已被修改为null
            changedLayers[i] = null;
            if(i != 0){
                changedLayersJSON = changedLayersJSON + ",";
            }
            changedLayersJSON += i.toString();
        }
    }
    changedLayersJSON = SuperMap.Utility.toJSON(changedLayers);
    
    return changedLayersJSON;
};

SuperMap.Utility.backupLayers = function(_layersBackup, layers ,_layersBackupForHistroy){
/// <summary>备份layer数组。将原有_layersBackup清空，将layers备份到_layersBackup中。</summary>
/// <param name="_layersBackup" type="object">layer数组的备份对象。</param>
/// <param name="layers" type="Array" elementType="SuperMap.Layer">layer数组。</param>
/// <param name="_layersBackupForHistroy" type="object">_layersBackupForHistroy对象。</param>
/// <returns type="Object">返回一个_layersBackup对象。</returns>
    if(_layersBackup){
        while(_layersBackup.length > 0){
           _layersBackup.pop();
        }
    }
    if(_layersBackupForHistroy){
        while(_layersBackupForHistroy.length > 0){
           _layersBackupForHistroy.pop();
        }
    }
    if(layers){
        var count = layers.length;
        for(var i = 0; i < count; i++){
            if(layers[i]){
                _layersBackup[i] = new SuperMap.Layer();
                _layersBackup[i].FromJSON(layers[i]);
                _layersBackupForHistroy[i] = new SuperMap.Layer();
                _layersBackupForHistroy[i].FromJSON(layers[i]);
            }else{
                _layersBackup[i] = null;
                _layersBackupForHistroy[i] = null;
            }
        }
    }
};

SuperMap.Utility.jSONToContextMenu = function(json){
/// <summary>将一个JSON字符串转换成ContextMenu。</summary>
/// <param name="json" type="String">要转换的JSON字符串。</param>
/// <returns type="Object">返回一个ContextMenu对象。</returns>
    var o = eval('(' + json + ')');
    var strParams = "";
    if(o.params){
        for(var i = 0; i < o.params.length; i++){
            strParams +="o.params[" + i + "],"; 
        }
    }
    var str = "new " + o.type + "(" + strParams + o.onComplete + "," + o.onError + "," + o.onStart + ")";

    return eval(str);
};

SuperMap.Utility.contextMenuToJSON = function(type,params){
/// <summary>将一个ContextMenu转换成JSON字符串</summary>
/// <param name="type" type="String">ContextMenu对象的type属性值。</param>
/// <param name="params" type="Array" elementType="Object">ContextMenu对象的属性或者函数的数组。</param>
/// <returns type="String">返回一个JSON字符串。</returns>
    var json = "";
    if(!type){return;}
    var o = new Object();   
    o.type = type;
    if(params){o.params = params;}
    if(o){
        json = SuperMap.Utility.toJSON(o);
            
    }
    return json;
};

SuperMap.Utility.isInTheSameDomain = function(url) {
/// <summary>判断一个url请求是否在当前域中</summary>
/// <param name="url" type="String">url请求字符串。</param>
/// <returns type="Boolean">url请求是否在当前域中。</returns>
    if (!url) {
        return true;
    }
    var index = url.indexOf("//");
    if (index == -1) {
        //相对路径
        return true;
    } else {
        //url
        var substring = url.substring(0, index);
        var documentprotocol = document.location.protocol;
        if (documentprotocol.toLowerCase() != substring.toLowerCase()) {
            return false;
        }
        substring = url.substring(index + 2);
        var portIndex = substring.indexOf(":");
        index = substring.indexOf("/");
        var domain = substring.substring(0, portIndex);
        var domainWithPort = substring.substring(0, index);
        var documentDomain = document.domain;
        if (domain == documentDomain || domainWithPort == documentDomain) {
            return true;
        }
    }
    return false;
};
