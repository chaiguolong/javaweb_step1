
var oScript = document.createElement("script");
function getinfoByName_view(LP_ID){

	var ajax = new MyAjax();
	var params = "p=,span,p=,span,p=,span,p=,span,p=,span,p=,span,p=,span,p=,span,p="+LP_ID+"";
	
	oScript.src = "http://map.hzfc365.com/hrqa?action=queryPos&params="+params;
	//oScript.src = "http://localhost:7080/hfgis/hrqa?action=queryPos&params="+params;
	oScript.type = "text/javascript";
    oScript.language = "javascript";
	document.getElementsByTagName("head")[0].appendChild(oScript);
	
    oScript.onreadystatechange = ReturnData;
	
	//ajax.sendPost("/hello?action=Newhouse&url=http://map.hzfc365.com/hrqa?action=queryPos&params="+params, "params="+params, queryBySQlGeometryComplete_view, "text");
}
function ReturnData(){

	if("complete" == oScript.readyState||"loaded" == oScript.readyState)
    {
   		queryBySQlGeometryComplete_view(json);
        
    }    

}

function getinfoByNameEr(SMID){
	var params = "p=,span,p=,span,p=,span,p=,span,p=,span,p=,span,p=,span,p=,span,p="+SMID+"";
	var ajax = new MyAjax();
	//ajax.sendPost("testClient?action=Secondhouse&url=http://map.hzfc365.com/test?action=Secondhouse", "params="+params,queryBySQlGeometryComplete_view2, "text");

}
function change(){
	document.getElementById('myiframe').src = 'http://localhost:8084/view.html?t=2&l=213';
	//document.getElementById('myiframe').src = 'http://map.hzfc365.com/test?t=2&l=212';
}