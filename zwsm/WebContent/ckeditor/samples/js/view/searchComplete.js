var flag = 0;
// 在地图上显示查询结果
function queryBySQlGeometryComplete_view(json){

	clearLoadingBar();
	
	if(json == ""){
	
		p_json = json;
		mapControl.customLayer.removeMarkersByGroupID(0);
		mapControl.customLayer.removeMarkersByGroupID(1);
		mapControl.customLayer.removeMarkersByGroupID(2);
		//alert("无房源");
		p_queryNullInfo= "";
		// 新增清除列表导航20110221
		if(page!= null){				
			p_json.length = 0;
			refreshpagesBarID(0,0,0);
		}
		// 
		alert("无法定位");
		return;
	}
	//json = eval('['+json+']');
	p_json = json;
	
	showMakers_view();
}

function queryBySQlGeometryComplete_view2(json){
    flag = 1;
	clearLoadingBar();
	
	if(json == ""){
	
		p_json = json;
		mapControl.customLayer.removeMarkersByGroupID(0);
		mapControl.customLayer.removeMarkersByGroupID(1);
		mapControl.customLayer.removeMarkersByGroupID(2);
		//alert("无房源");
		p_queryNullInfo= "";
		// 新增清除列表导航20110221
		if(page!= null){				
			p_json.length = 0;
			refreshpagesBarID(0,0,0);
		}
		// 
		return;
	}
	json = eval('['+json+']');
	p_json = json;
	
	showMakers_view();
}

function _showMakers_view(groupID){
	// mapControl.customLayer.removeMarkersByGroupID(groupID);
	showMakers();
}
function showMakers_view(){
	p_start = 0;
	p_end = p_start + p_rows;
	/////showMakersP();
	
	//addRightDiv(p_json);
	showMakersBySmIDs_view();
}
function showMakersBySmIDs_view(){
	
	mapControl.customLayer.removeMarkersByGroupID(0);
	mapControl.customLayer.removeMarkersByGroupID(1);
	mapControl.customLayer.removeMarkersByGroupID(2);
	mapControl.customLayer.removeMarkersByGroupID(214);		// 定位圈
	
	
	if(p_json == null || p_json == ""){
		if(p_viewPts.length != 0){
			mapControl.viewByPoints(p_viewPts);
			p_viewPts = new Array();
		}
		
		return;
	}
	
	var ps = getSMIDs();
	var pint2Ds = new Array();
	var index = 0;		// 设置序列
	
	//for(var i = 0;i< p_json.length ;i++){
	    if (flag == 0){ 
		var smid = p_json.project[0].SMID;
		var x = p_json.project[0].X;
		var y = p_json.project[0].Y;
		var name = p_json.project[0].PRJNAME;
		var ave = p_json.project[0].AVERAGEPRICE;
		var stat = p_json.project[0].STAT;
		var ksts = p_json.project[0].KSTS;
		var ksxf = p_json.project[0].KSXF;
		}else{
		var smid = p_json.project[0].SMID;
		var x = p_json.project[0].X;
		var y = p_json.project[0].Y;
		var name = p_json.project[0].HSECTION;
		var ave = p_json.project[0].AVERAGEPRICE;
		var stat = 1;
		var ksts = p_json.project[0].COUNT;
		}
		
		var src1 = "http://map.hzfc365.com/images/t0/t01.gif";
		var src2 = "http://map.hzfc365.com/images/t0/t02.gif";
		var src3 = "http://map.hzfc365.com/images/t0/t03.gif";
		
		var src11 = "http://map.hzfc365.com/images/t0/t011.gif";
		var src21 = "http://map.hzfc365.com/images/t0/t021.gif";
		var src31 = "http://map.hzfc365.com/images/t0/t031.gif";
		if(stat == 0){
			src1 = "http://map.hzfc365.com/images/t0/t01.gif";
			src2 = "http://map.hzfc365.com/images/t0/t02.gif";
			src3 = "http://map.hzfc365.com/images/t0/t03.gif";
			src11 = "http://map.hzfc365.com/images/t0/t011.gif";
			src21 = "http://map.hzfc365.com/images/t0/t021.gif";
			src31 = "http://map.hzfc365.com/images/t0/t031.gif";
		}else if(stat == 1){
			src1 = "http://map.hzfc365.com/images/t1/t11.gif";
			src2 = "http://map.hzfc365.com/images/t1/t12.gif";
			src3 = "http://map.hzfc365.com/images/t1/t13.gif";
			src11 = "http://map.hzfc365.com/images/t1/t111.gif";
			src21 = "http://map.hzfc365.com/images/t1/t121.gif";
			src31 = "http://map.hzfc365.com/images/t1/t131.gif";
		}else if(stat == 2){
			src1 = "http://map.hzfc365.com/images/t2/t21.gif";
			src2 = "http://map.hzfc365.com/images/t2/t22.gif";
			src3 = "http://map.hzfc365.com/images/t2/t23.gif";
			src11 = "http://map.hzfc365.com/images/t2/t211.gif";
			src21 = "http://map.hzfc365.com/images/t2/t221.gif";
			src31 = "http://map.hzfc365.com/images/t2/t231.gif";
		}
		// var divlength=(name.length+ksts.length)*13-25;
		// // 一个中文字转换成2我英文字
		
		if(divlength<2){
			divlength=2;
		}
		if(index != 10){
			index++;
		}
		
		var point2D = new SuperMap.Point2D(x,y);
		pint2Ds.push(point2D);
		var ksTitle = name+" "+ksts+"套";
		var xfTitle = ksTitle;
		var divlength=eval(ksTitle.replace(/[^\x00-\xff]/g,"rr").length)*7-40;
		var divOnMouseOverFun = " onmouseover='onMarkMouserOver(\"mark\",\""+smid+"\",\""+divlength+"\",\""+src11+"\",\""+src21+"\",\""+src31+"\");'";
		var divOnMouseOutFun = " onmouseout='onMarkMouserOut(\"mark\",\""+smid+"\",\""+divlength+"\",\""+src1+"\",\""+src2+"\",\""+src3+"\");'";
		
		if(stat == 0){			// 先房中有期房的显示
			if(eval(ksxf)>0){
				xfTitle = name+" "+ksts+"套(含期房"+ksxf+"套)";
				divOnMouseOverFun = " onmouseover='onMarkMouserOverNew(\"mark\",\""+smid+"\",\""+xfTitle+"\",\""+src11+"\",\""+src21+"\",\""+src31+"\");'";
				divOnMouseOutFun = " onmouseout='onMarkMouserOutNew(\"mark\",\""+smid+"\",\""+ksTitle+"\",\""+src1+"\",\""+src2+"\",\""+src3+"\");'";
			}
		}
		
		// 标记点 
        var aHTML="";
	    aHTML += "<div id='mark"+smid+"' style='position: absolute;top:-35px; left:-25px;'>"
	     
	    
	    	aHTML += "<div id='markbg"+smid+"'>"
	    	aHTML += "<table cellpadding='0' cellspacing='0'><tr valign='top'><td><div style='width:39px;height:38px;background:url("+src1+")' ></div></td>"
   			aHTML += "<td><div style='width:"+divlength+"px;height: 25px;background:url("+src2+")'></div></td>"
    		aHTML += "<td><div style='width:4px;height:25px;background:url("+src3+")'></div></td></tr></table>"
    		aHTML += "</div>"
	    	aHTML += "<div id='marktitle"+smid+"'"
	    	aHTML += divOnMouseOverFun
	     	aHTML += divOnMouseOutFun 
	      aHTML += "style='position:absolute;left:2px;top:5px;width:100%;font-size:13px;color:#ffffff;' >"+ksTitle+"</div>"
	    	
	    aHTML += "</div>";
	    
	    var content=new SuperMap.MarkerContent();
	    content.innerHTML=aHTML;
	    mapControl.customLayer.insertMarker(i,point2D.x,point2D.y,-150,-440,"","",100,content,stat);
	    
	//}
	if(ifOneOnload == true){
		var point2D = new SuperMap.Point2D(120.2322233445,30.2670672254);
		mapControl.setCenterAndZoom(point2D,1/153600);
		ifOneOnload = false;
	}else{
		if(p_viewPts.length != 0){
			mapControl.viewByPoints(p_viewPts);
			p_viewPts = new Array();
		}else if(pint2Ds.length>0){
			mapControl.viewByPoints(pint2Ds);
			pint2Ds = null;
		}
	}
}
// 获取选中的项
function getSMIDs(){
	var contrastid= new Array();
	var obj = document.getElementsByTagName("input");
	for(var i = 0;i<obj.length;i++){
		if(obj[i].name == "selects"){
			contrastid.push(obj[i].value);
		}
	}
	/*
	$("[name:selects]:checkbox").each(function(){
		if($(this).attr("name")=="selects"){
			smid=$(this).attr("value");
			contrastid.push(smid);
		}
	})*/
	return contrastid;
}