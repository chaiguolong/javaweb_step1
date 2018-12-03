//========================================================================== 
// SuperMap iServer 客户端程序，版权所有，北京超图软件股份有限公司，2000-2008。 
// 本程序只能在有效的授权许可下使用。未经许可，不得以任何手段擅自使用或传播。 
// 作者：			SuperMap iServer Team 
// 修改：	 
// 文件名：			SuperMap.Include.js  
// 功能：			引入客户端运行所需的脚本
// 最后修改时间：	2007-11-02
//========================================================================== 

function _IncludeScript(inc){
	var script='<'+'script type="text/javascript" src="http://map.hzfc365.com/scripts/'+inc+'"'+'><'+'/script>'; 
	//var script='<'+'script type="text/javascript" src="http://localhost:7080/hfgis/scripts/'+inc+'"'+'><'+'/script>'; 
	
	document.writeln(script); 
}


function _IncludeStyle(inc){
	var style='<'+'link type="text/css" rel="stylesheet" href="http://map.hzfc365.com/styles/'+inc+'"'+' />'; 
	
	//var style='<'+'link type="text/css" rel="stylesheet" href="http://localhost:7080/hfgis/styles/'+inc+'"'+' />'; 
	
	document.writeln(style); 
}

function _GetBrowser(){
	var ua=navigator.userAgent.toLowerCase();
	if(ua.indexOf('opera')!=-1)return'opera';
	else if(ua.indexOf('msie')!=-1)return'ie';
	else if(ua.indexOf('safari')!=-1)return'safari';
	else if(ua.indexOf('gecko')!=-1)return'gecko';
	else return false;
}

if(!Function.__typeName){
    _IncludeStyle('SuperMap.UI.MapControl.css');

    if(_GetBrowser()!="ie"){
	    _IncludeScript('wz_jsgraphics.js'); 
    }
    _IncludeScript('MicrosoftAjax.debug.js'); 
    _IncludeScript('MicrosoftAjaxTimer.debug.js'); 
    _IncludeScript('MicrosoftAjaxWebForms.debug.js'); 

    //_IncludeScript('SuperMap.Utility.js'); 
    _IncludeScript('SuperMap.CommonTypes.js'); 
    _IncludeScript('SuperMap.Decoder.js'); 
    _IncludeScript('SuperMap.Encoder.js'); 
    _IncludeScript('SuperMap.Committer.js'); 
	_IncludeScript('SuperMap.DataManager.js');
    _IncludeScript('SuperMap.NetworkAnalystManager.js');
    _IncludeScript('SuperMap.SpatialAnalystManager.js');
    
    _IncludeScript('SuperMap.Map.js'); 
    _IncludeScript('SuperMap.Layer.js'); 
    _IncludeScript('SuperMap.LayerParam.js'); 
    _IncludeScript('SuperMap.GlobalMapLayer.js');
    _IncludeScript('SuperMap.OverviewManager.js'); 
    _IncludeScript('SuperMap.UI.Action.js'); 
    _IncludeScript('SuperMap.UI.MapTile.js'); 
    _IncludeScript('SuperMap.UI.MapControl.js'); 
    _IncludeScript('SuperMap.UI.OverviewControl.js'); 
    _IncludeScript('SuperMap.UI.CustomLayer.js'); 
    _IncludeScript('SuperMap.UI.LayerControl.js'); 
    _IncludeScript('SuperMap.UI.NavigationControl.js'); 
    _IncludeScript('SuperMap.UI.MagnifierControl.js'); 
    _IncludeScript('SuperMap.UI.SliderBarControl.js'); 
	
	_IncludeScript('SuperMap.Resource.js'); 
	_IncludeScript('SuperMap.LanguageResource.js');
	
	
}