<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
		<title>广告位置分类</title>
		<meta http-equiv="pragma" content="no-cache"> 
		<meta http-equiv="Cache-Control" content="no-cache, must-revalidate"> 
		<link rel="stylesheet" type="text/css" href="/super/css/style.css" />
		<link rel="stylesheet" type="text/css" href="/super/css/images/simple/getcss.css" />
		<link rel="stylesheet" type="text/css" href="/super/css/formInfo.css" />
        <link rel="stylesheet" type="text/css" href="/super/common/jqueryUi/css/ui.all.css" />
        <link rel="stylesheet" type="text/css" href="/super/common/flexigrid/css/flexigrid.css" />
		<link rel="stylesheet" type="text/css" href="/super/common/formValidator/validationEngine.jquery.css" />
		<link rel="stylesheet" type="text/css" href="/super/common/uploadify/uploadify.css" />
		
		<style type="text/css">
		html {
			overflow-y: auto;
		}		
		.tbody {
			overflow-x: hidden;
		}
		.settingDiv_r div.uploadify-button{padding: 0 0 0 0!important;}
		</style>
		<script type="text/javascript" src="/super/js/jquery-1.7.2.min.js"></script>
	    <script type="text/javascript" src="/super/common/jqueryUi/jquery-ui-1.7.2.min.js"></script>
	    <script type="text/javascript" src="/super/common/flexigrid/flexigrid.js"></script>
		<script type="text/javascript" src="/super/common/formValidator/jquery.validationEngine-reg.js"></script>
		<script type="text/javascript" src="/super/common/formValidator/jquery.validationEngine.js"></script>
		<script type="text/javascript" src="/super/common/uploadify/jquery.uploadify-3.1.min.js"></script>
		<script type="text/javascript" src="/super/js/jquery.form.js"></script>
		<script type="text/javascript" src="/super/js/commpage.js"></script>
		<script type="text/javascript" src="/super/common/datePicker/WdatePicker.js"></script>
		<script type="text/javascript">
		$(document).ready(function(){
		
			$("#infoForm").validationEngine();
			
			$('#onefile').uploadify({
				swf: '/super/common/uploadify/uploadify.swf',// [必须设置]swf的路径
				uploader: '/esf/SuperUpload_upload.jspx',// [必须设置]上传文件触发的url
				auto: true,// 文件选择完成后，是否自动上传
				buttonImage:'/super/common/uploadify/uploadimage.gif',
				height: 25,// 上传按钮的高和宽
				width: 92,
				cancelImage: '/super/common/uploadify/uploadify-cancel.png',// [必须设置]取消图片的路径
				checkExisting:'/uploader/uploadify-check-existing.php',// 检查上传文件是否存，触发的url，返回1/0
				fileObjName:'fileName',
				fileSizeLimit : 1000,// 文件的极限大小，以字节为单位，0为不限制。单位KB
				fileTypeExts: '*.jpg;*.png;*.jpeg;*.gif;*.swf',// 允许上传的文件类型，限制弹出文件选择框里能选择的文件
				method: 'post',// 和后台交互的方式：post/get
				multi: true,// 是否能选择多个文件
				queueSizeLimit : 1,// 队列中允许的最大文件数目
				progressData : 'all', // 'percentage''speed''all'//队列中显示文件上传进度的方式：all-上传速度+百分比，percentage-百分比，speed-上传速度
				removeCompleted : true,// 上传成功后的文件，是否在队列中自动删除
				removeTimeout: 2,	//完成后删除延迟时间
				postData: {},// 和后台交互时，附加的参数
				preventCaching : true,
				transparent: true,
				successTimeout : 30,// 上传时的
				timeoutuploadLimit : 1,// 能同时上传的文件数目
				onUploadSuccess:function(file, data, response){//当每个文件上传完成后的操作
					var r = eval('(' + data + ')');	
					var times = (new Date()).getTime() + parseInt(100*Math.random());
					$('#onefileList').empty();
					if(r.ext == "swf"){
						$('#onefileList').prepend('<li id="' + times + '"><embed  pluginspage="http://www.macromedia.com/go/getflashplayer" src="/' + r.path + '" type="application/x-shockwave-flash" style="height:250px; width:750px;" quality="high" wmode="transparent"/><a href="javascript:removeTempFile(\'' + times + '\',\'' + r.path + '\');"><img src="/super/common/uploadify/uploadify-cancel.png" title="删除" /></a></li>');
						$('#webAdInfo_rsstype').val(2);
					}else{
						$('#onefileList').prepend('<li id="' + times + '"><img src="/' + r.path + '" title="' + r.path + '" style="max-height:550px; max-width:750px;"/><a href="javascript:removeTempFile(\'' + times + '\',\'' + r.path + '\');"><img src="/super/common/uploadify/uploadify-cancel.png" title="删除" /></a></li>');
						$('#webAdInfo_rsstype').val(1);
					}
					$('#webAdInfo_newpath').val(r.path);
				}	
		});
		
		$("#webAdInfo_begintime,#webAdInfo_endtime").bind("click",function(){
			WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd HH:mm:ss'});
		});
		
		
		var path = $('#webAdInfo_adpath').val();
		if(path != ""){
			var times = (new Date()).getTime() + parseInt(100*Math.random());
			if(path.indexOf("swf")>0){
				$('#onefileList').prepend('<li id="' + times + '"><embed  pluginspage="http://www.macromedia.com/go/getflashplayer" src="/' + path + '" type="application/x-shockwave-flash" style="height:250px; width:750px;" quality="high" wmode="transparent"/><a href="javascript:removeTempFile(\'' + times + '\',\'' + path + '\');"><img src="/super/common/uploadify/uploadify-cancel.png" title="删除" /></a></li>');
			}else{
				$('#onefileList').prepend('<li id="' + times + '"><img src="/' + path + '" title="' +path + '" style="max-height:550px; max-width:750px;"/><a href="javascript:removeTempFile(\'' + times + '\',\'' + path + '\');"><img src="/super/common/uploadify/uploadify-cancel.png" title="删除" /></a></li>');		
			}			
		}
	});
		//删除临时文件
		function removeTempFile(id, path){
			$.ajax({
				url:'/esf/SuperUpload_remove.jspx?removePath=' + path,
				type: 'get', dataType:'html', cache: false, async:false,
				error: function(xhr){
					parent.exceptionAlert();
				},
				success: function(data){	
					var d = eval('(' + data + ')');
					if(d.flag){
						$('#' + id).remove();
						$('#webAdInfo_newpath').val('');
					}
				}
			});
		}
		
		//返回
		function doback(){
			window.location.href = "/esf/WebAd_toInfoList.jspx?page=" + $('#page').val() + "&webAdType.adtypeid=" + $('#webAdType_adtypeid').val();
		}
		
		//提交保存
		function doSubmit(){
			if($('#webAdInfo_begintime').val()==""||$('#webAdInfo_endtime').val()==""){
					alert("请选择时间");
					return;
			}
			
			if($("#infoForm").validationEngine('validate')){
				var saveOptions={
					target: '#infoForm',
					url:"/esf/WebAd_saveAdInfo.jspx", type: 'post', dataType: 'html', cache:false, async:false,
					beforeSubmit:function(formArray, jqForm){
					},
					error:function(xhr){
						parent.exceptionAlert();
					},
					success: function(data) {
						var r = eval('(' + data + ')');	
						if(r.flag){
							parent.showAlert(r.returnMsg, "success");
							doback();
						}
						else {
							parent.showAlert(r.returnMsg, "failure");
						}
					}
				}
				$('#infoForm').ajaxSubmit(saveOptions);
			}
		}
		
		function setAdTypeID(){
			$('#webAdInfo_adtypeid').val($('#adtype').val());
		}

		  //取出广告位位置
		function bangAd(){
			$('#adDialog').remove();//删除存在的
			$('body').append('<div id="adDialog" title="广告位列表"><table id="grid" style="display: none;"></table></div>');
			$("#adDialog").dialog({
				bgiframe: true,
				height: 425,
				width:615,
				modal: true,
				resizable:false,
				draggable: false
			});
			loadAdListFlex();
		 }

		//获取广告位位置
		 function loadAdListFlex(){
			 $("#grid").flexigrid({
				 url : '/esf/WebAd_getTypeOtherList.jspx',
		        	dataType : 'json',
		          	colModel : [
						{display : '广告位编码', name : 'adtypeid', width : 250, sortable : false, align : 'center', talign : 'left', hide : true},
						{display : '位置说明', name : 'seatinfo', width : 400, sortable : false, align : 'center', talign : 'left'}	,
					    {display : '操作', name : 'operate', width : 70, sortable : false, align : 'center', talign : 'center' }	   		   				    
					],
					rp: 10,
		       searchitems : [
				{display: '关键字', name : 'keywords',isdefault: true }
				],
			   showFindDiv: true,//是否自动显示查询条件框
		       width : 590,
		       height : 270
			});
		}

	   //选择
       function select(id,info){
		   $("#adDialog").dialog('close');
		   $("#webAdInfo_adtypeid").val(id);
		   $("#seatinfoDiv").html(info);
		}   	
		
		//设置页面toolbar长度
		window.onload = window.onresize = GetForContentWidth;
	</script>
	</head>
	<body class="tbody">
		<!-- 工具栏 -->
		<div class="toolbg toolbgline toolheight nowrap" id="forContentWidth"
			style="position: fixed; z-index:99999;">
			<!-- 按钮 -->
			<div class="right">
				<input type="button" class="wd1 btn" value="返回"
					onclick="javascript:doback();" />
				<input type="button" class="wd1 btn" value="保存"
					onclick="javascript:doSubmit();" />
			</div>
			<!-- 页面信息 -->
			<div class="nowrap left">
				<div class="txt_title_nosearch">
					广告管理 &gt; 广告位置分类
				</div>
			</div>
			<div class="clr">
				&nbsp;
			</div>
		</div>
		<form id="infoForm" name="infoForm">
			<div class="settingtable">
				<div class="settingtd settingDiv no_bt no_bb">
					
					<div class="settingDiv_l">
						位置选择：
					</div>
					<div class="settingDiv_r">
						<div>
							<s:hidden name="page" value="%{page}" />
							<s:hidden name="webAdInfo.adid" value="%{webAdInfo.adid}" />
							<s:hidden name="webAdInfo.adtypeid" value="%{webAdInfo.adtypeid}" />
							<s:hidden name="webAdType.adtypeid" value="%{webAdType.adtypeid}" />
							<span id="seatinfoDiv"> <s:property  value="%{webAdInfo.seatinfo}"/> </span>
							<font  color='green' onclick="javascript:bangAd();" >【请选择】</font>
						</div>					
					</div>
					
					
					<div class="settingDiv_l" >
						广告资源：
					</div>
					<div class="settingDiv_r"  >
						<div>
							<s:file name="onefile"  />
							<s:hidden name="webAdInfo.adpath"/>
							<s:hidden name="webAdInfo.newpath" />
							<s:hidden name="webAdInfo.rsstype"/>
							
						</div>
						<div class="set_pos addrtitle">
							<ul id="onefileList"></ul>
						</div>
					</div>
					
					<div class="settingDiv_l">
						连接地址：
					</div>
					<div class="settingDiv_r">
						<div>
							<s:textfield name="webAdInfo.linkurl" value="%{webAdInfo.linkurl}" 
								cssClass="validate[required,maxSize[500]] input_l"  />	
						*								
						</div>					
					</div>
					
					<div class="settingDiv_l">
						开始时间：
					</div>
					<div class="settingDiv_r">
						<div>
							<s:textfield name="webAdInfo.begintime" value="%{webAdInfo.begintime}" cssClass="validate[required,maxSize[20]] input_s" />
							*
						</div>
					</div>
					
					<div class="settingDiv_l">
						结束时间：
					</div>
					<div class="settingDiv_r">
						<div>
						   <s:textfield name="webAdInfo.endtime" value="%{webAdInfo.endtime}" cssClass="validate[required,maxSize[20]] input_s" />
						   *
						</div>
					</div>
					
					<div class="settingDiv_l">
						排序：
					</div>
					<div class="settingDiv_r">
						<div>
							<s:textfield name="webAdInfo.orderid" value="%{webAdInfo.orderid==null?1:webAdInfo.orderid}"
								maxLength="2"
								cssClass="validate[required,custom[onlyNumberSp],maxSize[5]] input_ssss" />
							*							
						</div>
					</div>
					
					<div class="settingDiv_l">
						是否显示：
					</div>
					<div class="settingDiv_r">
						<div>
							<s:radio name="webAdInfo.isdisplay" list="#{'1':'显示','0':'不显示'}"
								listKey="key" listValue="value"
								value="%{webAdInfo == null || webAdInfo.isdisplay ==null ? '0' : webAdInfo.isdisplay}" />
						</div>
					</div>
					
					<div class="settingDiv_l">
						广告描述：
					</div>
					<div class="settingDiv_r">
						<div>
							<s:textarea name="webAdInfo.descr" value="%{webAdInfo.descr}" 
								cssClass="validate[maxSize[1000]] textarea_ms"  />
						</div>					
					</div>
					
				</div>
			</div>
		</form>
	</body>
</html>
