var mapControl;
var overviewControl;
var sliderBarControl;
var navigationControl;
var params = new Object();

var p_xgturlroot = "http://www.hzfc365.com/";									// 效果图url地址
var p_lpinfo = "http://www.hzfc365.com/house_view/lpxx.jsp?pid=";				// 楼盘详情地址
var p_lpinfo_er="http://www.hzfc365.com/second_hand/esf-fyxx.jsp?hid="			// 二手房详细地址
var p_zhuanginfo = "http://www.hzfc365.com/house_view/lpxx-xs-2.jsp?zh_nm=";	// 幢信息地址

var p_avr_data = null;
var p_avr_lablexs = null;
var p_avr_tips = null;				
var iffenxiang = false;				// 是否是分享连接
var ifaddQianyue = true;			// 是否加载签约数据
var addMapFlag = true;				// 第一次加载地图

var p_mapName = "hfmap";			// 当前地图名称
var p_houseType = "new";			// 记录当前查询的房源类型
var p_optionType = "";				// 当前操作类型，学区、框选、属性查询
var p_viewPts = new Array();		// 如果p_viewPts为空根据查询结果显示地图范围，否则显示p_viewPts的区域
var p_queryNullInfo = "";			// 查询为空提示信息
// 特色楼盘
var p_warn = "";					// 敬告信息

var p_ditie = 0;					// 判断查询是公交还是地铁
var p_lineid = 0;					// 记录选择的公交线（地铁线的id），为按照线查询提供id

// 公交、自驾查询
var p_json = null;					// 记录查询结果，鼠标移动查看线路使用,新、二、出mark点
var p_RouteType = 1;				// 记录当前选择的查询模式

// 右边列表中显示起、终
var p_start = 0;
var p_end = 10;
var p_rows = 10; 					// 每页记录条数
// 二手房、出租房
var p_count = 0;					// 小区个数	
var p_totalhouse = 0;				// 房源个数

var tuijian = "";					// 推荐房源的日期
var kscxjg ="";						// 快速查询房源的价格区间
var tsloupan = false;				// 判断是否为提示楼盘，详细框下拉框中不设置默认条件
var ifOneOnload = false;			// 是否第一次加载页面
var currentPt = "";					// 记录当前点击站点的信息，用于距离下拉框选择的查询

var page = null;					// 右边列表
var pageSMIDS = null;				// 右边列表显示的楼盘smids

//========================页面初始化========================
function onPageLoad2(){
    var address = "map.hzfc365.com";
    SuperMap.Committer.handler = "http://"+address+":80/commonhandler";
    params.contextPath = "http://"+address+":80/";
    params.mapHandler = params.contextPath + "maphandler";
    
    params.mapName = "myMap";

    // 指定基础地图服务IP地址    
    params.mapServicesAddress = address;
    
    // 指定基础地图服务端口号      
    params.mapServicesPort = 8600;
    
    // 设置返回图片的格式
    params.imageFormat = "png";

    // new一个MapControl对象
    mapControl = new SuperMap.UI.MapControl($get("myMap"));
    mapControl.set_params(params);
    //setMapParams();
    iffenxiang = true;
    // 初始化mapControl
    mapControl.initialize();
    // 初始文本框
   // CreatInputs();
    
};

function onPageLoaded2(){
	//mapControl.add_init(initOverview);
	mapLevelArray = [1/614400,1/307200,1/153600,1/76800,1/38400,1/19200,1/9600,1/4800,1/2400];
	mapControl._mapScales= mapLevelArray;
	mapControl._params.mapScales = mapLevelArray;
    //mapControl.add_init(initSliderBarControl);
    //mapControl.add_init(initNavigationControl);
    if(iffenxiang == false){
	   
	}else{
	   		// 显示滚动签约数
	   mapControl.add_init(queryFXHouse);
	}
    // 设置比例尺条
   	//controlScaleShow();
	mapControl.get_container().style.left = 0;
	mapControl.set_containerX(145);
	mapControl.get_container().style.top = 0;
	mapControl.set_containerY(145);
};
//>>>>>>>>>>>=====================
var pil = null;
var pil2 = null;
var pil3 = null;
function CreatInputs(){
	pil = new InputList();
	pil2 = new InputList();
	pil3 = new InputList();
	pil.create("seachtxtDiv","seachtxt","楼盘名关键字",queryFun);
	pil2.create("erseachtxtDiv","erseachtxt","小区名关键字",queryFun2);
	pil3.create("czseachtxtDiv","czseachtxt","小区名关键字",queryFun3);
}
// 新房
function queryFun () {
	var name = document.getElementById("seachtxt").value;
	var perName = document.getElementById("inputperNameseachtxtDiv").value;
	if (perName != name && name != "") {
		var ajax = new MyAjax();
		ajax.sendPost("hrqa?action=mqueryname", "params=" + name, queryFunComplete , "text");
	}
	document.getElementById("inputperNameseachtxtDiv").value = name;
}
function queryFunComplete (value) {
	pil._queryFunComplete(value);
}

// 二手房
function queryFun2 () {
	var name = document.getElementById("erseachtxt").value;
	var perName = document.getElementById("inputperNameerseachtxtDiv").value;
	if (perName != name && name != "") {
		var ajax = new MyAjax();
		ajax.sendPost("phqa?action=mqueryname", "params=" + name, queryFunComplete2 , "text");
	}
	document.getElementById("inputperNameerseachtxtDiv").value = name;
}
function queryFunComplete2 (value) {
	pil2._queryFunComplete(value);
}
// 出租房
function queryFun3 () {
	var name = document.getElementById("czseachtxt").value;
	var perName = document.getElementById("inputperNameczseachtxtDiv").value;
	if (perName != name && name != "") {
		var ajax = new MyAjax();
		ajax.sendPost("phqa?action=mqueryname", "params=" + name, queryFunComplete3 , "text");
	}
	document.getElementById("inputperNameczseachtxtDiv").value = name;
}
function queryFunComplete3 (value) {
	pil3._queryFunComplete(value);
}
//<<<<<<<<<<<<<<<<==============================

function returnBegin(){
	newLouPan();
}

/// 新增加--分享房源
function queryFXHouse(){
	var loc = new  URLParam();
	var s = loc.getValue("s");
	var x = loc.getValue("x");
	var a = loc.getValue("a");
	var t = loc.getValue("t");
	var l = loc.getValue("l");
	/*
	if(s!="" && x!="" && a!=""){
   	 	//iffenxiang = true;
		mapControl.get_params().x = UrlDecode(x);
		mapControl.get_params().y = UrlDecode(a);
		mapControl.get_params().mapScale = 1/eval(UrlDecode(s));
	}*/
	
	if(t != "" && l !=""){
		if(t=="1"){				//	新房
		
			setTimeout("getinfoByName_view('"+l+"')",1000);
		}else if(t=="2"){		// 二手房
			setTimeout("getinfoByNameEr('"+l+"')",1000);
		}else if(t=="3"){		// 出租
			setTimeout("getinfoByNameCz('"+l+"')",1000);
		}
	}
	
}

// 设置标记点-空置
/*
var p_x=0;
var p_y=0;
function setMarkXY()
{
	var aHTML="<div id='jiucuomark'><img src='images/red.gif'></div>";
	var content=new SuperMap.MarkerContent();
	var point2D = new SuperMap.Point2D(p_x,p_y);
	content.innerHTML=aHTML;
	mapControl.customLayer.insertMarker(1,p_x,p_y,0,0,"","",101,content,1);
}*/

// 城区热点
function addCqMark()
{
	var xs = new Array(119.944598889718,120.092481539255,120.185455596847,120.310207019569,120.176472596113,120.159854044756,120.347486472613,120.185455596846);
	var ys = new Array(30.3293587210015,30.2141517366868,30.178219733753,30.178219733753,30.3057783441679,30.3430577972117,30.288935217701,30.2352617884103);
	var names = new Array("余杭区","西湖区","滨江区","萧山区","下城区","拱墅区","江干区","上城区");
	for(var i=0;i<xs.length;i++){
		var aHTML="<img src='images/null.gif' style='position: absolute;top:-10px;left:-16px;' title='"+names[i]+"' onclick='zoomCQ("+xs[i]+","+ys[i]+",1/76800)'>";
		var content=new SuperMap.MarkerContent();
		content.innerHTML=aHTML;
		mapControl.customLayer.insertMarker("cq"+i,xs[i],ys[i],0,0,"","",101,content,1);
	}
}

function zoomCQ(x,y,s){
	var point2D = new SuperMap.Point2D(x,y);
	mapControl.setCenterAndZoom(point2D,s)
}


// 布置页面
function rerangePage(){
	/*
	// 获取客户端窗口的大小
	var clientWidth = document.body.clientWidth-rightListWidth -7;
	var clientHeight = document.body.clientHeight-150;
	*/
	// 获取右边列表的宽度
	var rightListWidth = document.getElementById("infoId").style.width;
	
	rightListWidth = rightListWidth.substr(0,rightListWidth.length-2);
	var mapWidth = 1000 - rightListWidth;
	var mapHeight = 510;
	var viewsright = rightListWidth-15;
	if(mapControl){
		mapControl.resize(mapWidth, mapHeight);
	}
	rerangeOverview(viewsright, mapHeight);
	// 切换地图按钮位置
	document.getElementById("shiliangdivid").style.right = viewsright + 55;
	document.getElementById("wxdivid").style.right = viewsright+5;
};



// 拉框放大
function setZoomIn(){
    var zoomInAction = new SuperMap.UI.ZoomInAction();
    mapControl.set_action(zoomInAction);
};

// 拉框缩小
function setZoomOut(){
    var zoomOutAction = new SuperMap.UI.ZoomOutAction();
    mapControl.set_action(zoomOutAction);
};

// 平移
function setPan(){
    var panAction = new SuperMap.UI.PanAction();
    mapControl.set_action(panAction);
};
function zoomIn(){
	mapControl.zoomIn();
}


// 用于获取并整理服务端返回结果的面积量算事件处理函数
function onMeasureAreaComplete(result){
    var unitValue = mapControl.getMap().get_coordsSys().units;
    var temp = result.area + "平方" + getUnits(unitValue);
    alert(temp);
};

// 用于获取错误信息的面积量算事件处理函数
function onError(responseText) {
    alert(responseText);
};

function getUnits(unitValue){
    var units = new SuperMap.Units();
    if(unitValue == units.meter) {
        return "米";
    } else if(unitValue == units.kilometer){
        return "千米";
    } else if(unitValue == units.mile){
        return "英里";
    } else if(unitValue == units.kilometer){
        return "公里";
    } else if(unitValue == units.yard){
        return "码";
    } else if(unitValue == units.degree){
        return "度";
    } else if(unitValue == units.millimeter){
        return "毫米";
    } else if(unitValue == units.centimeter){
        return "厘米";
    } else if(unitValue == units.inch){
        return "英寸";
    } else if(unitValue == units.decimeter){
        return "分米";
    } else if(unitValue == units.foot){
        return "英尺";
    }
    return "米";
};



// 清除高亮
function clearHighlight(){

    mapControl.clearHighlight();
    mapControl.customLayer.clearMarkers();
    mapControl.customLayer.clearLines();
    mapControl.customLayer.clearPolygons();
    mapControl.customLayer.clearCircles();
    document.getElementById("gjdivid").style.display = "none";
    document.getElementById("p_searchRestsID").innerHTML  ="";
    document.getElementById("shareID").style.display = "none";
    
    currentPt = "";			// 清空当前选择的站点
    tuijian = "";			// 推荐房源的
	kscxjg ="";				// 快速查询房源的价格区间
	tsloupan = false;		// 特色楼盘标志,false为非特色楼盘,true特色楼盘
	
	clearSelected();
	// clearTJDate();
};

function clearHighlight2(){
	p_json=null;
	clearHighlight();
	document.getElementById("p_searchRestsID").innerHTML  ="";
	document.getElementById("pagesBarID").innerHTML = "";
	document.getElementById("lishiID").innerHTML ="";
	addCqMark();
}
function cleatInsert(){
	mapControl.customLayer.clearLines();
	mapControl.customLayer.clearCircles();
	mapControl.customLayer.clearPolygons();
	mapControl.clearHighlight();
}
// 清除菜单选择状态
function clearSelected(){
	var houseNum = 3;
	var menus = 10;
	for(var i=0;i<houseNum;i++){
		for(var j=1;j<=menus;j++){
			var id = "line"+i+""+j+"check";
			document.getElementById(id).innerHTML = "";
		}
	}
}
// 清除推荐日期
function clearTJDate(){
	var ids = new Array("erkpsj1","erkpsj2","czkpsj1","czkpsj2");
	for(var i =0;i<ids.length;i++){
		document.getElementById(ids[i]).value = "";
	}
}
function getMapUrl(){
	var mapParam = mapControl.getMapParam();
    var scalenow=UrlEncode(1/mapControl.get_mapScale());
	//var center = new SuperMap.Point2D();
	var centerx = UrlEncode(mapParam.center.x);
	var centery = UrlEncode(mapParam.center.y);
	var addressmap= "";
	if(location.href.indexOf("index.html")>0){
		addressmap = location.href+"?s="+scalenow+"s"+centerx+"s"+centery;
	}else{
		addressmap = location.href+"index.html?s="+scalenow+"s"+centerx+"s"+centery;
	}
	return addressmap;
}

function UrlEncode(value){
	 value = value+"";
     var result = "";
     result = value.replace(".","c");
     result = result.replaceAll('1','T');
     result = result.replaceAll('2','o');
     result = result.replaceAll('3','r');
     result = result.replaceAll('4','P');
     result = result.replaceAll('5','e');
     result = result.replaceAll('6','K');
     result = result.replaceAll('7','Y');
     result = result.replaceAll('8','g');
     result = result.replaceAll('9','x');
     
     return result;
}
String.prototype.replaceAll  = function(s1,s2){   
    return this.replace(new RegExp(s1,"gm"),s2);   
  } 
function UrlDecode(value){
     var result = "";
     result = value.replace("c",".");
     result = result.replaceAll('T','1');
     result = result.replaceAll('o','2');
     result = result.replaceAll('r','3');
     result = result.replaceAll('P','4');
     result = result.replaceAll('e','5');
     result = result.replaceAll('K','6');
     result = result.replaceAll('Y','7');
     result = result.replaceAll('g','8');
     result = result.replaceAll('x','9');
     return result;
}

/**
 *  获取链接纠错
 */

function Correction(){
  	var div1= document.getElementById("div1");
   	div1.style.display='block';
}
//========================页面地图操作========================

//========================图查属性操作========================



//========================图查属性操作========================
function onKeyDown()
{
　　if (event.keyCode == 13)
　　{houseResourcesQuery();}
}
// 控制右边的列表显示和隐藏
function hideRightListDiv(){
	document.getElementById("rightIDs").style.display="none";//隐藏
	document.getElementById("rightIDs").style.width = 0;
	document.getElementById("rightID_show").style.display = "";
	document.getElementById("rightID_hide").style.display = "none";
	rerangePage();
}
function showRightListDiv(width){
	document.getElementById("rightIDs").style.display="";	// 显示
	document.getElementById("rightIDs").style.width = width;
	document.getElementById("rightID_show").style.display = "none";
	document.getElementById("rightID_hide").style.display = "";
	rerangePage();	
}


// 先在子页面中添加下面的div ,一般放在iframetop 的div里面
// <div id="loading" style=" position: absolute; top:3px; right: 3px;"></div>
// 加载等待条
function addLoadingBar(){
	document.getElementById('loading').style.display ='block';
	document.getElementById('loading2').style.display ='block';
	//document.body.style.cursor = "wait";
}
// 清除等待条
function clearLoadingBar(){
	document.getElementById('loading').style.display ='none';
	document.getElementById('loading2').style.display ='none';
	setPan();
	//document.body.style.cursor = "pointer";
}


function hideXuQuMenu(){
	//if(document.getElementById("xuequ0").style.visibility == "visible")MM_showHideLayers('xuequ0','','hide');
	//if(document.getElementById("xuequ1").style.visibility == "visible")MM_showHideLayers('xuequ1','','hide');

}
// 添加高亮点
function addhighPoint(x,y){
	var point2D = new SuperMap.Point2D(x,y);
	var mc = new SuperMap.MarkerContent();
	
	var inHTML = "";
    var mcHTML = "<img id='dingweiid'  onclick='' src='images/marker_red.gif' style='position:absolute;cursor:hand;left:-7px;top:-10px;width:15px;height:15px; ' >";
	
	mc.innerHTML = mcHTML;
    mapControl.customLayer.insertMarker(11124, point2D.x, point2D.y,-140,-130,inHTML, "", 100, mc,214);

}
// 清除高亮点
function clearHighPoint(){
	mapControl.customLayer.removeMarkersByGroupID(214);
}


//  显示签约数
function showQianyue(){
	var ajax = new MyAjax();
	// ajax.sendPost("ca?action=QianYueShu", "params=", showQianyueComplete, "text");
}

function showQianyueComplete(json){
	var jsons = eval('['+json+']');
	if(jsons.length>1){
		var qyts = jsons[1].qyts;
		var qymj = jsons[1].qymj;
		var qyjj = jsons[1].qyjj;
		var erqyts = jsons[1].erqyts;
		var erqymj = jsons[1].erqymj;
		var erqyjj = jsons[1].erqyjj;
		document.getElementById("qyts").innerHTML = "楼市信息：今日杭州市区商品房共签约"+qyts+"套，签约面积"+qymj+"平方米,签约均价"+qyjj+"元。"
													+"二手房共签约"+erqyts+"套，签约面积"+erqymj+"平方米,签约均价"+erqyjj+"元。";
	}
	
}

function switchMap(mapName){
	if(p_mapName == mapName){
		return;
	}else{
		p_mapName = mapName;
	}
	
	if(mapName == "hfmap"){
		document.getElementById("shiliangdivid").innerHTML = "&nbsp;<b>地 图</b>&nbsp;";
		document.getElementById("wxdivid").innerHTML = "&nbsp;卫 星&nbsp;";
	}else{
		document.getElementById("shiliangdivid").innerHTML = "&nbsp;地 图&nbsp;";
		document.getElementById("wxdivid").innerHTML = "&nbsp;<b>卫 星</b>&nbsp;";
	}
	
	try{
        if(navigationControl){
            navigationControl.dispose();
            navigationControl = null;
        }
        if(sliderBarControl){
            sliderBarControl.dispose();
            sliderBarControl = null;
        }
        if(overviewControl){
            overviewControl.dispose();
            overviewControl = null;
        }
    }catch(e){
         alert(e);
    }
    /*
    if(mapName == "hfmap"){
	    mapLevelArray = [1/614400,1/307200,1/153600,1/76800,1/38400,1/19200,1/9600,1/4800,1/2400];
		mapControl._mapScales= mapLevelArray;
		mapControl._params.mapScales = mapLevelArray;
	}else{
		mapLevelArray = [1/614400,1/307200,1/153600,1/76800,1/38400,1/19200];
		mapControl._mapScales= mapLevelArray;
		mapControl._params.mapScales = mapLevelArray;
	}*/
	
    mapControl.get_params().mapScale = null;
	mapControl.switchMap(mapName);
}


function windowOpen(url){
	window.open(url,'_blank');
}

//判断是否是正整数
function IsZZNum(s)
{
    if(s!=null){
        var r,re;
        re = /\d*/i; //\d表示数字,*表示匹配多个数字
        r = s.match(re);
        return (r==s)?true:false;
    }
    return false;
}

function changequeryfeature(){
	var changeType = document.getElementById("queryfeaturelayer").value;
	var inner = "<input id='queryfeatureinput' type='text' value='请输入道路名称' onkeydown='queryFeaturInputKeyDown();' >"
	if(changeType=="xzqh@hfgisdata"){
		inner = "<select id='queryfeatureinput'>";
		inner += "<option value='上城'>上城区</option>";
		inner += "<option value='下城'>下城区</option>";
		inner += "<option value='江干'>江干区</option>";
		inner += "<option value='拱墅'>拱墅区</option>";
		inner += "<option value='西湖'>西湖区</option>";
		inner += "<option value='滨江'>滨江区</option>";
		inner += "<option value='萧山'>萧山区</option>";
		inner += "<option value='余杭'>余杭区</option>";
		inner += "</select>";
	}
	document.getElementById("queryfeatDiv").innerHTML = inner;
}


///纠错
function jiucuofun(){
	document.getElementById('mymap').style.cursor='crosshair';
 	var div=document.getElementById('mymap');
	div.onmouseup=function(e){
	if(!e)e=window.event;
	if(e.button==1){
		e = SuperMap.Utility.getEvent(e);
		try{
			if(document.getElementById('jiucuomark')){
				document.getElementById('jiucuomark').style.display='none';
				document.getElementById('Submit_jiucuo').disabled = true;
			 }
			 
			var pixelX = SuperMap.Utility.getMouseX(e);
			var pixelY = SuperMap.Utility.getMouseY(e);
			
			var offsetX = mapControl.get_containerX();
			var offsetY = mapControl.get_containerY();
		
			var pixelPoint = new SuperMap.Point(pixelX-offsetX , pixelY-offsetY); 
			var scalenow = mapControl.getMap().get_mapParam().mapScale;
			var mapPoint = mapControl.pixelToMapCoord(pixelPoint);
			var mapX=mapPoint.x;
			var mapY=mapPoint.y;
		  	var i=1;
		    var aHTML="<div id='jiucuomark'  style='position: absolute;left:-14px;top:-40px;' value='"+i+"'><img src='images/red.gif'></div>";
			
			var content=new SuperMap.MarkerContent();
		    content.innerHTML=aHTML;
			mapControl.customLayer.insertMarker(i,mapX,mapY,0,0,"","",101,content,1);
			document.getElementById('Submit_jiucuo').disabled = false;
			
			var addressmap= "";
			var oldhref = location.href;
			if(oldhref.indexOf("?s=")){
				oldhref = oldhref.split("?s=")[0];
			}
			if(oldhref.indexOf("index.html")>0){
				addressmap = oldhref + "?s=";
			}else{
				addressmap = oldhref + "index.html?s=";
			}
			
			document.getElementById('jc_url').value= addressmap +UrlEncode(1/scalenow)+"s"+UrlEncode(mapX)+"s"+UrlEncode(mapY);
			//div.onmouseup=function(){}
			//document.getElementById('mymap').style.cursor='auto';
			}catch(e){
				alert(page_res["mouseMoveException"] + e);
			}
    }
    /*if(e.button==2){
	    document.getElementById('mymap').style.cursor='auto';
	    div.onmouseup=function(){}
    }*/
	}	
}

// 二手房、出租房

// 控制mark的覆盖顺序
function onMarkMouserOver(head,smid,len,src1,src2,src3){
	var aHTML = "<table cellpadding='0' cellspacing='0'><tr valign='top'><td><div  style='width:39px;height:38px;background:url("+src1+")'/></td>"
 	aHTML += "<td><div style='height:25px; width:"+len+"px;background:url("+src2+");'/></td>" 
  	aHTML += "<td><div style='width:4px;height:25px;background:url("+src3+")'/></td></tr></table>"  	
	document.getElementById(head+"bg"+smid).innerHTML = aHTML;
	document.getElementById(head+smid).parentNode.style.zIndex = 99;
}
// 控制mark的覆盖顺序
function onMarkMouserOut(head,smid,len,src1,src2,src3){
	var aHTML = "<table cellpadding='0' cellspacing='0'><tr valign='top'><td><div style='width:39px;height:38px;background:url("+src1+")'/></td>"
 	aHTML += "<td><div style='height:25px; width:"+len+"px;background:url("+src2+");'/></td>" 
  	aHTML += "<td><div style='width:4px;height:25px;background:url("+src3+")'/></td></tr></table>"
	document.getElementById(head+"bg"+smid).innerHTML = aHTML;
	document.getElementById(head+smid).parentNode.style.zIndex = 90;
}
// 回到初始状态
function returnStart(){
	var showTypeID1 = document.getElementById("housetype_searchbar1").style.display;
	var showTypeID2 = document.getElementById("housetype_searchbar2").style.display;
	var showTypeID3 = document.getElementById("housetype_searchbar3").style.display;
	
	if(showTypeID1 == "block" || showTypeID1 == ""){
		startNewHouse();
	}else if(showTypeID2 == "block" || showTypeID2 == ""){
		erTJQueryByPrice(1);
	}else if(showTypeID3 == "block" || showTypeID3 == ""){
		cznewLouPan(1);
	}
}