/*系统公共JS*/

function showimg(content){
	$('#alertDialog').remove();//删除存在的
	$('body').append('<div id="alertDialog" title="预览"><div style="text-align: center;">' + content + '</div></div>');
	$("#alertDialog").dialog({
		bgiframe: true,
		height: 550,
		width:850,
		modal: true,
		resizable:false,
		draggable: false
	});
}


//提示框组件
function showAlert(content, type){
	$('#alertDialog').remove();//删除存在的
	if(type == null){
		type = 'alert';
	}
	$('body').append('<div id="alertDialog" title="系统提示"><div style="padding-top:20px;float:left;"><img src="/super/css/images/alertIcons/' + type + '.png" /></div><div style="float:left;padding:40px 0 0 0;width:210px;text-align: center;">' + content + '</div><div style="clear:left;"></div></div>');
	$("#alertDialog").dialog({
		bgiframe: true,
		height: 140,
		modal: true,
		resizable:false,
		draggable: false
	});
	//设置提示框停留时间 2秒
	window.setTimeout("closedAlert()", 2000);
}

//关闭系统提示框
function closedAlert(){
	$("#alertDialog").dialog('close');
	$('#alertDialog').remove();
}

//初始化Confirm
function initConfirm(content){
	$('#confirmDialog').remove();//删除存在的
	$('body').append('<div id="confirmDialog" title="系统提示"><p style="padding-top:15px;text-align: center;">' + content + '</p></div>');
}

//系统异常提示框
function exceptionAlert(){
	$('#exceptionDialog').remove();//删除存在的
	$('body').append('<div id="exceptionDialog" title="系统提示"><div style="float:left;"><img src="/super/css/images/alertIcons/failure.png" /></div><div style="float:left;padding:20px 0 0 0;width:210px;text-align: center;">系统异常，请联系管理员！</div><div style="clear:left;"></div></div>');
	$("#exceptionDialog").dialog({
		bgiframe: true,
		height: 150,
		modal: true,
		resizable:false,
		draggable: false,
		buttons: {
			'确定': function() {
				$(this).dialog('close');
				$.ajax({
					url:'logon.action?method=doExit',
					type: 'post',dataType:'json',cache: false,
					error: function(xhr){
						window.location.reload();
					},
					success: function(obj){					
						window.location.reload();			
					}
				});
			}
		}
	});
}

//开启进度条
function showProgress(){
	$('#progressDialog').remove();//删除存在的
	$('body').append('<div id="progressDialog"><p style="padding-top:15px;text-align: center;">正在提交...<br /><br /><img src="/super/css/images/comm/loading.gif"/></p></div>');
	$("#progressDialog").dialog({
		bgiframe: true,
		height: 140,
		modal: true,
		resizable:false,
		draggable: false
	});
}

//关闭进度条
function closedProgress(){
	$('#progressDialog').dialog('close');
	$('#progressDialog').remove();//删除存在的
}
