var _UpFilesType = "pic";
var _UpFilesSize = 0;
var _UpFilesShowPic = "";
var _UpFilesPicUrl = "";
var _UpFilesName = "";

function initUpFile(FTYPE,Size,WH,ShowPic)//url,zip,0,100-100,
{
	_UpFilesType = FTYPE == null ? "file" : FTYPE;
	_UpFilesSize = Size == null ? 0 : parseInt(Size,10);
	_UpFilesWH = WH == null ? "" : WH;
	_UpFilesShowPic = ShowPic != null && FTYPE == 'pic' ? ShowPic : '';
	
	if (_UpFilesShowPic == "") {
		alertWin2('文件上传',ckUploadContent(),400,150);
	}
	else {
		alertWin2('文件上传',ckUploadContent(),400,400);
	}
}

function alertWin2(title, msg, w, h) {
	$('#ckeditorDialog').remove();//删除存在的
	$('body').append('<div id="ckeditorDialog" title="' + title + '">' + msg + '</div>');
	initDialog(w,h);
	uploadSucc();
	if(_UpFilesType == 'pic') {
		doImageYuan();
	}
	ckUploadify();
}

function initDialog(w,h) {
	$("#ckeditorDialog").dialog({
		bgiframe: true,
		height: h,
		width: w,
		modal: false,
		resizable:false,
		draggable: true
	});
}

function ckUploadContent() {
	var action = '/ckeditor/upload.jspx';
	var img = '';
	if(_UpFilesType == 'pic') {
		img = '启压:<input type="checkbox" name="isCompress" id="isCompress" value="yes" onclick="doImageYuan()"/>' +
		'<input type="text" id="ImageWidth" value="" style="width:25px;"/>' +
		'<span id="xx">x</span><input type="text" id="ImageHeight" value="" style="width:25px;"/>' +
		'水印:<input type="checkbox" name="addflag" id="addflag" value="yes" checked="true"/>';
	}
	var form = '<form id="ckUploadForm" name="ckUploadForm" action="' + action + '" method="POST" enctype="multipart/form-data">' +
			'<input type="hidden" name="UpFilesType" value="' + _UpFilesType + '" id="UpFilesType"/>' +
			'<input type="hidden" name="UpFilesSize" value="0" id="UpFilesSize"/>' +
			'<input type="hidden" name="UpFilesPicUrl" value="" id="UpFilesPicUrl"/>' +
			'<input type="hidden" name="type" value="" id="type"/>' +
			'<input type="file" name="ckUploadFile" value="" id="ckUploadFile"/>' +
			img +
			'<br/><input type="button" id="btnClose" value="关闭" onclick="uploadClose()"/>' +
			'<div style=" text-align:center; ">' +
			'</div>' +
		'</form>';
	return form;
}

function ckUploadify() {
	var add = "";
	if(_UpFilesType == 'pic') {
		add = "&addflag=" + document.getElementById("addflag").checked;
	}
	$('#ckUploadFile').uploadify({
		swf: '/super/common/uploadify/uploadify.swf',// [必须设置]swf的路径
		uploader: '/ckeditor/ckupload.jspx',// [必须设置]上传文件触发的url
		auto: true,// 文件选择完成后，是否自动上传
		buttonImage:'/super/common/uploadify/uploadimage.gif',
		height: 25,// 上传按钮的高和宽
		width: 92,
		cancelImage: '/super/common/uploadify/uploadify-cancel.png',// [必须设置]取消图片的路径
		checkExisting:'/uploader/uploadify-check-existing.php',// 检查上传文件是否存，触发的url，返回1/0
		fileObjName:'fileName',
		fileSizeLimit : 10000,// 文件的极限大小，以字节为单位，0为不限制。单位KB
		// 允许上传的文件类型，限制弹出文件选择框里能选择的文件
		method: 'get',// 和后台交互的方式：post/get
		multi: true,// 是否能选择多个文件
		queueSizeLimit : 5,// 队列中允许的最大文件数目
		progressData : 'all', // 'percentage''speed''all'//队列中显示文件上传进度的方式：all-上传速度+百分比，percentage-百分比，speed-上传速度
		removeCompleted : true,// 上传成功后的文件，是否在队列中自动删除
		removeTimeout: 2,	//完成后删除延迟时间
		postData: {},// 和后台交互时，附加的参数
		preventCaching : true,
		transparent: true,
		successTimeout : 30,// 上传时的
		timeoutuploadLimit : 5,// 能同时上传的文件数目
		onUploadSuccess:function(file, data, response){//当每个文件上传完成后的操作
			var r = eval('(' + data + ')');
			uploadSucc('/' + r.path, r.name);
			//var times = (new Date()).getTime() + parseInt(100*Math.random());
			//$('#onefileList').prepend('<li id="' + times + '"><img src="/' + r.path + '" title="' + r.path + '" style="max-height:150px; max-width:168px;"/><br><input type="text" class="input_ss" value=""/><a href="javascript:removeTempFile(\'' + times + '\',\'' + r.path + '\');"><img src="/super/common/uploadify/uploadify-cancel.png" title="删除" /></a></li>');
		},
		onDialogClose : function(swfuploadifyQueue) {//当文件选择对话框关闭时触发
			//var url = 'http://127.0.0.1:9080/ckeditor/nothing.jspx?upFilesType=' + _UpFilesType + '&addflag=' + document.getElementById("addflag").checked;
			//$('#ckUploadFile').uploadifySettings('uploader', url);
			var flag = "";
			var width = "";
			var height = "";
			if(_UpFilesType == 'pic') {
				flag = document.getElementById("addflag").checked;
			}
			if(document.getElementById("ImageWidth") != null) {
				width = document.getElementById("ImageWidth").value;
			}
			if(document.getElementById("ImageHeight") != null) {
				height = document.getElementById("ImageHeight").value;
			}
			$('#ckUploadFile').uploadify("settings", "formData", {'upFilesType': _UpFilesType, 'addflag' : flag, 'width' : width, 'height' : height});   
		}
	});
}

function uploadSucc(url,filename) {
	if(typeof(url) != 'undefined') {
		if (url=="没有要上传的文件") {
			alert(url);
		} else if (url == "上传的文件过大") {
			alert(url);
		} else if (url == "上传的文件类型不正确") {
			alert(url);
		} else if (url != "") {
			_UpFilesSucc(url, filename);
			uploadClose();
		}
	}
}

function _UpFilesSucc(picurl,filename) {
	_UpFilesPicUrl = picurl;
    _UpFilesName = filename;
	CKEDITOR.instances.content.insertElement(createElement());
}

function createElement() {
	var element;
	if(_UpFilesType == 'pic') {
	    var name = ' ';
	    if(typeof(filename) != "undefined") {
	    	name = ' title="' + filename + '" ';
	    }
	    alert(2);
	    element = CKEDITOR.dom.element.createFromHtml('<img src="' + UpFilesGetPicUrl() + '" ' + name + '/>');
	    alert(1);
	}
	else if(_UpFilesType == 'file') {
		element = CKEDITOR.dom.element.createFromHtml('<a href="'+ UpFilesGetPicUrl() + '">' + UpFilesGetName() + '</a>');
		
	}
	else if(_UpFilesType == 'swf') {
		element = CKEDITOR.dom.element.createFromHtml('<embed pluginspage="http://www.macromedia.com/go/getflashplayer" quality="high" src="'+UpFilesGetPicUrl()+'" type="application/x-shockwave-flash"></embed>');
	}
	else if(_UpFilesType == 'audio') {
		element = CKEDITOR.dom.element.createFromHtml('<object' +
				'classid="clsid:6BF52A52-394A-11d3-B153-00C04F79FAA6"' +
				'height="44" width="100%"><param name="AutoStart"' +
				'value="1"><param name="PlayCount" value="1"><param' +
				'name="EnableContextMenu" value="1"><param name="Volume"' +
				'value="100"><param name="url"' +
				'value="' + UpFilesGetPicUrl() + '"><embed allowscan="1"' +
				'autostart="1" enablecontextmenu="0" height="44"' +
				'name="MediaPlayer" playcount="1" showcontrols="1"' +
				'src="' + UpFilesGetPicUrl() + '" type="video/x-ms-wmv"' +
				'width="100%"></object>');
	}
	return element;
}

function UpFilesGetPicUrl() {
	return _UpFilesPicUrl;
}

function UpFilesGetName() {
	return _UpFilesName;
}

function doImageSuo() {
	document.getElementById("ImageSuo").style.display='none';
}

function doImageYuan() {
	if(document.getElementById('isCompress').checked == true) {
		document.getElementById("ImageWidth").style.display='';
		document.getElementById("ImageHeight").style.display='';
		document.getElementById("xx").style.display='';
	}
	else {
		document.getElementById("ImageWidth").style.display='none';
		document.getElementById("ImageHeight").style.display='none';
		document.getElementById("xx").style.display='none';
	}
}

function uploadClose() {
	$('#ckeditorDialog').remove();
}
