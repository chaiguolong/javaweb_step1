var _UpFilesCallbackFun = "alert('upload succ');";
var _UpFilesType = "pic";
var _UpFilesSize = 0;
var _UpFilesWH = "100-100";
var _UpFilesShowPic = "";
var _UpFilesPicUrl = "";
var _UpFilesName = "";

function UpFilesSet(CallbackFun,FTYPE,Size,WH,ShowPic)//url,zip,0,100-100,
{
	_UpFilesCallbackFun = CallbackFun == null?"alert(_UpFilesPicUrl);":CallbackFun;
	_UpFilesType = FTYPE == null?"file":FTYPE;
	_UpFilesSize = Size == null?0:parseInt(Size,10);
    _UpFilesWH = WH==null?"":WH;
    _UpFilesShowPic = ShowPic!=null&&FTYPE=='pic'?ShowPic:'';
        
	var _ifm_url = "/common/CommonUploadFileAction.jspx?UpFilesType="+_UpFilesType+"&UpFilesSize="+_UpFilesSize+"&UpFilesWH="+_UpFilesWH+"&UpFilesShowPic="+_UpFilesShowPic;
    if (_UpFilesShowPic=="")
        alertWin('文件上传',_ifm_url,400,100,true);
    else
        alertWin('文件上传',_ifm_url,400,400,true);
}

function UpFilesSetType(CallbackFun,FTYPE,Size,WH,ShowPic,type)//url,zip,0,100-100,
{
	_UpFilesCallbackFun = CallbackFun == null?"alert(_UpFilesPicUrl);":CallbackFun;
	_UpFilesType = FTYPE == null?"file":FTYPE;
	_UpFilesSize = Size == null?0:parseInt(Size,10);
    _UpFilesWH = WH==null?"":WH;
    _UpFilesShowPic = ShowPic!=null&&FTYPE=='pic'?ShowPic:'';
        
	var _ifm_url = "/common/CommonUploadFileAction.jspx?UpFilesType="+_UpFilesType+"&UpFilesSize="+_UpFilesSize+"&UpFilesWH="+_UpFilesWH+"&UpFilesShowPic="+_UpFilesShowPic+"&type="+type;
    if (_UpFilesShowPic=="")
        alertWin('文件上传',_ifm_url,400,100,true);
    else
        alertWin('文件上传',_ifm_url,400,400,true);
}

function UpFilesGetPicUrl()
{
	return _UpFilesPicUrl;
}
function UpFilesGetName()
{
	return _UpFilesName;
}
function _UpFilesSucc(picurl,filename)
{
	_UpFilesPicUrl = picurl;
        _UpFilesName = filename;
	eval(_UpFilesCallbackFun);
	document.body.removeChild(bgObj);
        document.body.removeChild(msgObj);
}
function _UpFilesClose()
{
	document.body.removeChild(bgObj);
        document.body.removeChild(msgObj);
}