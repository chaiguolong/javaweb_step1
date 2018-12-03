<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
		<title>资讯详情</title>
		<meta http-equiv="pragma" content="no-cache"> 
		<meta http-equiv="Cache-Control" content="no-cache, must-revalidate"> 
		<link rel="stylesheet" type="text/css" href="/super/css/style.css" />
		<link rel="stylesheet" type="text/css" href="/super/css/images/simple/getcss.css" />
		<link rel="stylesheet" type="text/css" href="/super/css/formInfo.css" />
		<link rel="stylesheet" type="text/css" href="/super/common/formValidator/validationEngine.jquery.css" />
	    <link rel="stylesheet" type="text/css" href="/super/common/jqueryUi/css/ui.all.css"  />
		<link rel="stylesheet" type="text/css" href="/super/common/uploadify/uploadify.css" />
		<link rel="stylesheet" type="text/css" href="/super/common/ztree/css/zTreeStyle.css" />
        <link rel="stylesheet" type="text/css" href="/super/common/flexigrid/css/flexigrid.css" />
		<style type="text/css">
		html {
			overflow-y: auto;
		}		
		.tbody {
			overflow-x: hidden;
		}
		#onefileList{display: block; overflow: hidden;}
		#onefileList li{
			float: left;  display: block; padding-right: 20px;
		}
		.settingDiv_r div.uploadify-button{padding: 0 0 0 0!important;}
		.ui-widget textarea{font-family:"lucida Grande",Verdana;}
		</style>
		<script type="text/javascript" src="/super/common/datePicker/WdatePicker.js"></script>
		<script type="text/javascript" src="/super/js/jquery-1.7.2.min.js"></script>
		<script type="text/javascript" src="/super/common/jqueryUi/jquery-ui-1.7.2.min.js"></script>
		<script type="text/javascript" src="/super/js/jquery.form.js"></script>
		<script type="text/javascript" src="/super/js/commpage.js"></script>
		<script type="text/javascript" src="/super/common/formValidator/jquery.validationEngine-reg.js"></script>
		<script type="text/javascript" src="/super/common/formValidator/jquery.validationEngine.js"></script>
        <script type="text/javascript" src="/ckeditor/ckeditor.js"></script> 
		<script type="text/javascript" src="/ckeditor/ckuploader.js"></script>
        <script language="javascript" src="/js/window.js" type="text/javascript"></script>
        <script language="javascript" src="/js/uploadfiles.js" type="text/javascript"></script>
		<script type="text/javascript" src="/super/common/uploadify/jquery.uploadify-3.1.min.js"></script>
		<script type="text/javascript" src="/super/common/flexigrid/flexigrid.js"></script>
		<script type="text/javascript">
		var editorCon;
		$(document).ready(function(){
			$("#infoForm").validationEngine();
			$("#newsContent_webshowdate").bind("click",function(){
				WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd HH:mm:ss'});
			});
			var str = "";
			if($('#newsContent_thumbnail').val() != ""){
				var path1 = $('#newsContent_thumbnail').val();
				var times = (new Date()).getTime() + parseInt(100*Math.random());
				str += '<li id="' + times + '"><img src="/' + path1 + '" style="max-height:550px; max-width:750px;"/>';
				str += '<a href="javascript:deleteFileOption(\'' + times + '\',\'' + path1 + '\',\'newsContent_thumbnail\');"><img src="/super/common/uploadify/uploadify-cancel.png" title="删除" /></a>';
				str += '</li>';
				$('#onefileList').append(str);
			}
			str = "";
			if($('#newsContent_uploadattachment').val() != ""){
				var path1 = $('#newsContent_uploadattachment').val();
				var times = (new Date()).getTime() + parseInt(100*Math.random());
				str += '<li id="' + times + '">' + path1.substring(path1.lastIndexOf('/')+1, path1.length);
				str += '<a href="javascript:removeTempFile(\'' + times + '\',\'' + path1 + '\',\'newsContent_thumbnail\');"><img src="/super/common/uploadify/uploadify-cancel.png" title="删除" /></a>';
				str += '</li>';
				$('#twofileList').append(str);
			}

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
				fileTypeExts: '*.jpg;*.jpeg;*.gif',// 允许上传的文件类型，限制弹出文件选择框里能选择的文件
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
					$('#onefileList').prepend('<li id="' + times + '"><img src="/' + r.path + '" title="' + r.path + '" style="max-height:80px; max-width:150px;"/><a href="javascript:removeTempFile(\'' + times + '\',\'' + r.path + '\',\'newsContent_thumbnail\');"><img src="/super/common/uploadify/uploadify-cancel.png" title="删除" /></a></li>');
					$('#newsContent_thumbnail').val(r.path);
				}
			});	
			
			$('#twofile').uploadify({
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
				fileTypeExts: '*.txt;*.doc;*.xls;*.xlsx;*.ppt;',// 允许上传的文件类型，限制弹出文件选择框里能选择的文件
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
					$('#twofileList').prepend('<li id="' + times + '">' + r.name + '<a href="javascript:removeTempFile(\'' + times + '\',\'' + r.path + '\',\'newsContent_uploadattachment\');"><img src="/super/common/uploadify/uploadify-cancel.png" title="删除" /></a></li>');
					$('#newsContent_uploadattachment').val(r.path);
				}
			});	
		});

		//将已上传的图片设为无效
		function deleteFileOption(id, path, en){
			$.ajax({
				url:'/esf/RessAction_deleteRssByPath.jspx?path=' + path,
				type: 'get', dataType:'html', cache: false, async:false,
				error: function(xhr){
					parent.exceptionAlert();
				},
				success: function(data){	
					var d = eval('(' + data + ')');
					if(d.flag){
						$('#' + id).remove();
						$('#'+en).val('');
					}
				}
			});
		}

		//删除文件
		function removeTempFile(id, path, en){
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
						$('#'+en).val('');
					}
				}
			});
		}

		//栏目列表
		var setting = {
			check: {
				enable: true
			},
			data: {
				simpleData: {
					enable: true,
					pIdKey : "pid"
				}
			}
		};
		
		//返回
		function doback(){
			window.location.href = "/esf/NewsContent_toSingleList.jspx?page=" + $('#page').val() +"&categoryid=${categoryid}";
		}
		
		//提交保存
		function doSubmit(state){
			$('#newsContent_releasemark').val(state);
			if($('#propertyList').html() != ''){
				var list = new Array();
				$('#propertyList option').each(function (){
					list.push($(this).val());
				});
				$('#newsContent_propertyList').val(list);
			}
			if($("#infoForm").validationEngine('validate')){
				$('#content').val(CKEDITOR.instances.content.getData());
				var saveOptions={
					target: '#infoForm',
					url:"/esf/NewsContent_saveContentSingleInfo.jspx", type: 'post', dataType: 'html', cache:false, async:false,
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

		//审核确认
		function doCheckSubmit(state){
			parent.initConfirm('您确定要提交该操作吗？');
			parent.$("#confirmDialog").dialog({
				bgiframe: true,height: 150,modal: true,	resizable:false,draggable: false,
				buttons: {
					"取消": function(){
						parent.$('#confirmDialog').dialog('close');
					},
					'确定': function() {
						parent.$('#confirmDialog').dialog('close');
						doSubmit(state);
					}				
				}
			});
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
				<input id="savebtn" type="button" class="wd1 btn" value="保存"
					onclick="javascript:doSubmit(1);"/>
			</div>
			<!-- 页面信息 -->
			<div class="nowrap left">
				<div class="txt_title_nosearch">
					资讯中心 &gt; 资讯详细
				</div>
			</div>
			<div class="clr">
				&nbsp;
			</div>
		</div>
		<form id="infoForm" name="infoForm">
			<div class="settingtable">
				<div class="settingtd settingDiv no_bt no_bb" style="margin: 0;">
					<div class="settingDiv_l">
						资讯标题：
					</div>
					<div class="settingDiv_r">
						<div>	
							<s:hidden name="newsContent.categoryid"/>
							<s:hidden name="newsContent.contentid"/>
							<s:hidden name="page"/>
							<input type="hidden" id="newsContent_categoryids" name="newsContent.categoryids" 
								value="<s:iterator value="#request.categoryidlist" status="s">
								<s:if test="#s.index == 0">
									<s:property value="%{categoryid}"/>
								</s:if>
								<s:else>
									,<s:property value="%{categoryid}"/>
								</s:else>
							</s:iterator>"/>
							<s:hidden name="newsContent.staticurl"/>
							<s:hidden name="newsContent.releasemark" value="%{newsContent == null || newsContent.releasemark == null ? '-2' : newsContent.releasemark}"/>
							<s:textfield name="newsContent.title" cssClass="validate[required,maxSize[100]] input_l"  />*					
						</div>
					</div>
					<div class="settingDiv_l">
						外部链接URL：
					</div>
					<div class="settingDiv_r">
						<div>	
							<s:textfield name="newsContent.gotourl" cssClass="validate[maxSize[100]] input_l"  /> 
						</div>
						<div class="set_pos addrtitle">
							前台点击标题直接转向
						</div>
					</div>
					<div class="settingDiv_l">
						Tag标签：
					</div>
					<div class="settingDiv_r">
						<div>	
							<s:textfield name="newsContent.tag" cssClass="validate[maxSize[100]] input_l"  /> 
						</div>
						<div class="set_pos addrtitle">
							多个标签用空格分开
						</div>
					</div>
					<div class="settingDiv_l">
						摘要：
					</div>
					<div class="settingDiv_r">
						<div>
							<s:textarea name="newsContent.descr" cssClass="validate[maxSize[1000]] textarea_ms" />
						</div>
					</div>
					<div class="settingDiv_l">
						来源：
					</div>
					<div class="settingDiv_r">
						<div>	
							<s:textfield name="newsContent.source" cssClass="validate[required,maxSize[100]] input_ss"  /> *	
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;热点资讯：
							<s:radio name="newsContent.hotflag" list="#{'1':'是','0':'否'}"
							listKey="key" listValue="value"
							value="%{newsContent == null || newsContent.hotflag ==null ? '0' : newsContent.hotflag}" />
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;推荐资讯：
							<s:radio name="newsContent.recommendflag" list="#{'1':'是','0':'否'}"
							listKey="key" listValue="value"
							value="%{newsContent == null || newsContent.recommendflag ==null ? '0' : newsContent.recommendflag}" />
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;法律法规级别：
							<s:radio name="newsContent.levelno" list="#{'1':'是','0':'否'}"
							listKey="key" listValue="value"
							value="%{newsContent == null || newsContent.levelno ==null ? '0' : newsContent.levelno}" />
						</div>
					</div>
					<div class="settingDiv_l">
						显示日期：
					</div>
					<div class="settingDiv_r">
						<div>	
							<s:textfield name="newsContent.webshowdate" cssClass="validate[required,maxSize[30]] input_s"  /> *
						</div>
					</div>
					<div class="settingDiv_l" >
						缩略图：
					</div>
					<div class="settingDiv_r"  >
						<div>
							<s:file name="onefile"  />
							<s:hidden name="newsContent.thumbnail" />
						</div>
						<div class="set_pos addrtitle">
							<ul id="onefileList"></ul>
						</div>
					</div>
					<div class="settingDiv_l" >
						上传附件：
					</div>
					<div class="settingDiv_r"  >
						<div>
							<s:file name="twofile"  />
							<s:hidden name="newsContent.uploadattachment" />
						</div>
						<div class="set_pos addrtitle">
							<ul id="twofileList"></ul>
						</div>
					</div>
					<div class="settingDiv_r"  >
					    <s:textarea name="newsContent.content" id="content"/>
					    <script type="text/javascript"> 
	                        CKEDITOR.replace( 'content',{		
		                        height:340, 
	                                  toolbar : 'iToolbar'
	                           });
					   </script>
				   </div>
				</div>
			</div>
		</form>
	</body>
</html>
