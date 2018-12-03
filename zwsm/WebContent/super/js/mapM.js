var map;
var maptype;
var centerPoint;
var zoom;
var divtop = "-7";


//-----楼盘模块
function creatMap(id, name){
	//地图
	map = new BMap.Map("container");  
	map.addControl(new BMap.NavigationControl());   				//缩放条
	map.centerAndZoom(new BMap.Point(120.1052563, 30.28924911), 13);   //杭州中心点位置
	//var opts = {anchor: BMAP_ANCHOR_TOP_RIGHT, offset: new BMap.Size(40, 30)}; 
	//map.addControl(new BMap.MapTypeControl(opts));					//地图状态
	map.enableScrollWheelZoom();									//开启滚轮事件
	map.disableDoubleClickZoom();									//关闭双击事件
	map.enableAutoResize();
	
	map.addEventListener("click", function(e){
		clear();
		$('#prjx').val(e.point.lng);
		$('#prjy').val(e.point.lat);
		addNewPRJONGIS();
	});
	
	//判断是否是360浏览器,top值样式有区别
	if(window.external&&window.external.twGetRunPath){
		var r=external.twGetRunPath();
		if(r&&r.toLowerCase().indexOf("360")>-1){
			divtop = "3";
			
		}
	}
	
	QueryNewPRJ(id, name)
}


//加载新盘地图PRJID
function QueryNewPRJ(id, name){
	$('#prjid').val(id);
	$('#prjname').val(name);
	if(id != null && id != ''){
		$.ajax({
			url:'/esf/GisMapAction_queryNewPRJ.jspx?prjid=' + id,
			type: 'get', dataType:'html', cache: false, async:false,
			error: function(xhr){
				parent.exceptionAlert();
			},
			success: function(data){
				var json = eval('('+data+')');
				if(json.prjname != undefined && json.prjname != '' && json.prjname != null){
					$('#prjx').val(json.prjx);
					$('#prjy').val(json.prjy);
					var myCompOverlay = new ComplexCustomOverlay(new BMap.Point(json.prjx, json.prjy), json.prjname, json.prjname, json.prjid);
					map.addOverlay(myCompOverlay);
					setTimeout(movetooo,1000);
				}
			}
		});
	}
}

function addNewPRJONGIS(){
	var myCompOverlay = new ComplexCustomOverlay(new BMap.Point($('#prjx').val(),$('#prjy').val()), $('#prjname').val(), $('#prjname').val(), $('#prjid').val());
	map.addOverlay(myCompOverlay);
}

function movetooo(point){
	map.centerAndZoom(new BMap.Point($('#prjx').val(), $('#prjy').val()), 13);
}

//楼盘模块-----页面加载
function pageLoadProperty(){
	//setTimeout(hidden,2000);
	setTimeout(initProperty,1000);
}

//初始化楼盘
function initProperty(){
	//判断是否是360浏览器,top值样式有区别
	if(window.external&&window.external.twGetRunPath){
		var r=external.twGetRunPath();
		if(r&&r.toLowerCase().indexOf("360")>-1){
			divtop = "3";
		}
	}
	QueryProperty($('#propertyid').val());
}

//加载新盘地图PRJID
function QueryProperty(id){
	if(id != null && id != ''){
		$.ajax({
			url:'/esf/GisMapAction_queryNewPRJ.jspx?prjid=' + id,
			type: 'get', dataType:'html', cache: false, async:false,
			error: function(xhr){
				parent.exceptionAlert();
			},
			success: function(data){
				var json = eval('('+data+')');
				if(json.prjname != undefined && json.prjname != '' && json.prjname != null){
					$('#x').val(json.prjx);
					$('#y').val(json.prjy);
					$('#tempid').val(id);
				}
			}
		});
	}
}

function addPropertyGIS(){
	var PRJGISNAME = $('#cohProperty_propertyname').val();
	if(PRJGISNAME == ""){
		PRJGISNAME = "无名楼盘"
	}
	var PRJID = "";
	if($('#tempid').val() != ""){
		PRJID = $('#tempid').val();
	}
	else {
		PRJID = (new Date()).getTime() + parseInt(100*Math.random())
		$('#tempid').val(PRJID);
	}
	var PRJX = $('#x').val();
	var PRJY = $('#y').val();
	var myCompOverlay = new ComplexCustomOverlay(new BMap.Point(PRJX,PRJY), PRJGISNAME, PRJGISNAME, PRJID);
	map.addOverlay(myCompOverlay);
}

function removePropertyGIS(){
	var prjid = $('#tempid').val();
	var div = document.getElementById(prjid);
	if(div != '' && div != null){
		div.parentNode.removeChild(div);  
	}
}


function loadPointProperty(){
	if($('#x').val() != ''){
		map.clearOverlays();
		var prjid = (new Date()).getTime() + parseInt(100*Math.random())
		var myCompOverlay = new ComplexCustomOverlay(new BMap.Point($('#x').val(), $('#y').val()), $('#cohProperty_propertyname').val(), $('#cohProperty_propertyname').val() + " ", $('#propertyid').val());
		map.addOverlay(myCompOverlay);
		setTimeout(movetoo,1000);
	}
}

//小区模块-----页面加载
function pageLoad(){
	//setTimeout(hidden,2000);
	setTimeout(initPRJ,1000);
}

//初始化楼盘
function initPRJ(){
	//判断是否是360浏览器,top值样式有区别
	if(window.external&&window.external.twGetRunPath){
		var r=external.twGetRunPath();
		if(r&&r.toLowerCase().indexOf("360")>-1){
			divtop = "3";
			
		}
	}
	QueryPRJ($('#tempid').val());
}


//加载地图PRJID
function QueryPRJ(id){
	if(id != null && id != ''){
		$.ajax({
			url:'/esf/GisMapAction_queryPRJ.jspx?prjid=' + id,
			type: 'get', dataType:'html', cache: false, async:false,
			error: function(xhr){
				parent.exceptionAlert();
			},
			success: function(data){
				var json = eval('('+data+')');
				if(json.prjname != undefined && json.prjname != '' && json.prjname != null){
					$('#x').val(json.prjx);
					$('#y').val(json.prjy);
				}
			}
		});
	}
}

//点击触发加载定位坐标
function loadPoint(){
	if($('#x').val() != ''){
		map.clearOverlays();
		var prjid = (new Date()).getTime() + parseInt(100*Math.random())
		$('#tempid').val(prjid);
		var myCompOverlay = new ComplexCustomOverlay(new BMap.Point($('#x').val(), $('#y').val()), $('#esfCommunity_communityname').val(), $('#esfCommunity_communityname').val() + " ", prjid);
		map.addOverlay(myCompOverlay);
		setTimeout(movetoo,1000);
	}
}

function movetoo(point){
	map.centerAndZoom(new BMap.Point($('#x').val(), $('#y').val()), 13);
}


function addPRJONGIS(){
	var PRJGISNAME = $('#esfCommunity_communityname').val();
	if(PRJGISNAME == ""){
		PRJGISNAME = "无名小区"
	}
	var PRJID = "";
	if($('#tempid').val() != ""){
		PRJID = $('#tempid').val();
	}
	else {
		PRJID = (new Date()).getTime() + parseInt(100*Math.random())
		$('#tempid').val(PRJID);
	}
	var PRJX = $('#x').val();
	var PRJY = $('#y').val();
	var myCompOverlay = new ComplexCustomOverlay(new BMap.Point(PRJX,PRJY), PRJGISNAME, PRJGISNAME, PRJID);
	map.addOverlay(myCompOverlay);
}

function removePRJONGIS(){
	var prjid = document.getElementById("tempid").value;
	var div = document.getElementById(prjid);
	if(div != '' && div != null){
		div.parentNode.removeChild(div);  
	}
}


//隐藏右上角的三维标签 杭州暂无三维地图
function hidden(){
	$('.mapcc div[title=显示三维地图]').css('display', 'none');
}


//缩放到最大级别	
function zoom(x,y){
	if(map.getZoom()<16){
		map.setZoom(16);
	}
}

//清除图层
function clear(){
	map.clearOverlays();
}

// 自定义楼盘标签
function ComplexCustomOverlay(point, text, mouseoverText, prjid){
    	
      this._point = point;
      this._text = text;
      this._overText = mouseoverText;
      this._textLength = this._text.length*13;
      this._overTextLength = this._overText.length*13;
      this._prjid = prjid;
      this._imgstr = "";
    }
    
    ComplexCustomOverlay.prototype = new BMap.Overlay();
    ComplexCustomOverlay.prototype.initialize = function(map){
      this._map = map;
      var div = this._div = document.createElement("div");
      div.id = this._prjid;
      div.style.position = "absolute";
      div.style.zIndex = BMap.Overlay.getZIndex(this._point.lat);
      
      var divhidden = this._divhidden = document.createElement("div");
      divhidden.innerHTML = this._point.lng+","+this._point.lat;
      divhidden.style.display = "none";
      div.appendChild(divhidden);
      this._imgstr = "l";
     
      var textlength = this._textLength;
      var overtextLength = this._overTextLength;
      
      var divleft= this._divleft = document.createElement("div");
      divleft.style.background = "url(/super/css/images/mapimage/"+ this._imgstr+"_left.png)";
      divleft.style.position = "absolute";
      divleft.style.width = "5px";
      divleft.style.height = "28px";
      divleft.style.left = "0px";
      divleft.onmouseover = null;
      divleft.onmouseout = null;
      div.appendChild(divleft);
      
      var divmiddle= this._divmiddle = document.createElement("div");
      divmiddle.style.background = "url(/super/css/images/mapimage/"+ this._imgstr+"_middle.png)";
      divmiddle.style.position = "absolute";
      divmiddle.style.width = textlength+"px";
      divmiddle.style.height = "28px";
      divmiddle.style.left = "5px";
      divmiddle.onmouseover = null;
      divmiddle.onmouseout = null;
      div.appendChild(divmiddle);
      
      var divmiddletext = this._divmiddletext = document.createElement("div");
      
      divmiddletext.style.position = "absolute";
      divmiddletext.style.width = textlength+"px";
      divmiddletext.style.height = "28px";
      divmiddletext.style.left = "7px";
      //divmiddletext.style.top = "3px";
      divmiddletext.style.top =  divtop + "px";
      divmiddletext.innerHTML ="<p id='p"+this._prjid+"' style='font-size:12px;font-family:微软雅黑;color:#ffffff'>"+this._text+"</p>";
      divmiddletext.onmouseover = null;
      divmiddletext.onmouseout = null;
      div.appendChild(divmiddletext);
      
      var divright = this._divright = document.createElement("div");
      divright.style.background = "url(/super/css/images/mapimage/"+ this._imgstr+"_right.png)";
      divright.style.position = "absolute";
      divright.style.width = "5px";
      divright.style.height = "28px";
      divright.style.left = textlength+5+"px";
      divright.onmouseover = null;
      divright.onmouseout = null;
      div.appendChild(divright);
      
      var divjt  = this._divjt = document.createElement("div");
      divjt.style.background = "url(/super/css/images/mapimage/"+ this._imgstr+"_jt.png)";
      divjt.style.position = "absolute";
      divjt.style.width = "25px";
      divjt.style.height = "17px";
      divjt.style.left = "0px";
      divjt.style.top = "23px";
      divjt.onmouseover = null;
      divjt.onmouseout = null;
      div.appendChild(divjt);
      
      var that = this;
      
      div.onmouseover = function(){
       
      	div.style.cursor="pointer";
      	
      	that._divleft.style.background = "url(/super/css/images/mapimage/z_left.png)";
      	
        that._divmiddle.style.background = "url(/super/css/images/mapimage/z_middle.png)";
        that._divright.style.background = "url(/super/css/images/mapimage/z_right.png)";
        that._divjt.style.background = "url(/super/css/images/mapimage/z_jt.png)";
        that._divmiddle.style.width = that._overTextLength+"px";
        that._divright.style.left = that._overTextLength+5+"px";
        that._divmiddletext.style.width = that._overTextLength+"px";
   		
        var p = document.getElementById("p"+that._prjid);
       
        p.innerText = that._overText;
        
      }

      div.onmouseout = function(){
     	
       	that._divleft.style.background = "url(/super/css/images/mapimage/"+that._imgstr+"_left.png)";
        that._divmiddle.style.background = "url(/super/css/images/mapimage/"+that._imgstr+"_middle.png)";
        that._divright.style.background = "url(/super/css/images/mapimage/"+that._imgstr+"_right.png)";
        that._divjt.style.background = "url(/super/css/images/mapimage/"+that._imgstr+"_jt.png)";
        that._divmiddle.style.width = that._textLength+"px";
        that._divright.style.left = that._textLength+5+"px";
        that._divmiddletext.style.width = that._textLength+"px";
       
       	var p = document.getElementById("p"+that._prjid);
        p.innerText = that._text;
        
      }
	  div.onclick = function(){
	 	map.panTo(that._point);
	  	setTimeout("zoom("+that._point.lng+","+that._point.lat+")",1000);
	  	document.getElementById("prjid").value = that._prjid;
	  	document.getElementById("x").value = that._point.lng;
	  	document.getElementById("y").value = that._point.lat;
	  }
	  
      map.getPanes().labelPane.appendChild(div);
      return div;
    }
    ComplexCustomOverlay.prototype.draw = function(){
      var map = this._map;
      var pixel = map.pointToOverlayPixel(this._point);
      this._div.style.left = pixel.x - parseInt(this._divleft.style.left) + "px";
      this._div.style.top  = pixel.y - 30 + "px";
      
}
    

