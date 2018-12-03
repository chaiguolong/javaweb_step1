<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
		<title>静态化html预览及编辑</title>
		<meta http-equiv="pragma" content="no-cache"> 
		<meta http-equiv="Cache-Control" content="no-cache, must-revalidate"> 
		<link rel="stylesheet" type="text/css" href="/super/css/style.css" />
		<link rel="stylesheet" type="text/css" href="/super/css/images/simple/getcss.css" />
		<link rel="stylesheet" type="text/css" href="/super/css/formInfo.css" />
		<link rel="stylesheet" type="text/css" href="/super/common/formValidator/validationEngine.jquery.css" />
		<style type="text/css">
		html {
			overflow-y: auto;
		}		
		.tbody {
			overflow-x: hidden;
		}
		</style>
		<script type="text/javascript" src="/super/js/jquery-1.7.2.min.js"></script>
		<script type="text/javascript" src="/super/js/jquery.form.js"></script>
		<script type="text/javascript" src="/super/js/commpage.js"></script>
		<script type="text/javascript" src="/super/common/formValidator/jquery.validationEngine-reg.js"></script>
		<script type="text/javascript" src="/super/common/formValidator/jquery.validationEngine.js"></script>
        <script type="text/javascript" src="/ckeditor/ckeditor.js"></script> 
        <script language="javascript" src="/js/window.js" type="text/javascript"></script>
        <script language="javascript" src="/js/uploadfiles.js" type="text/javascript"></script>
		<script type="text/javascript">
		var editorCon;
		$(document).ready(function(){
			$("#infoForm").validationEngine();
		});
		
		//返回
		function doback(){
			window.location.href = "/esf/WebStatic_toList.jspx?page=" + $('#page').val();
		}
		
		//提交保存
		function doSubmit(){
			if($("#infoForm").validationEngine('validate')){
				$('#contentHtml').val(CKEDITOR.instances.contentHtml.getData());
				var saveOptions={
					target: '#infoForm',
					url:"/esf/WebStatic_save.jspx", type: 'post', dataType: 'html', cache:false, async:false,
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
		
		//设置页面toolbar长度
		window.onload = window.onresize = GetForContentWidth;
	</script>
	</head>
	<body class="tbody">
		<!-- 工具栏 -->
		<div class="toolbg toolbgline toolheight nowrap" id="forContentWidth"
			style="position: fixed;">
			<!-- 按钮 -->
			<div class="right">
				<input type="button" class="wd1 btn" value="返回"
					onclick="javascript:doback();" />
				<input type="button" class="wd2 btn" value="保存修改"
					onclick="javascript:doSubmit();" />
			</div>
			<!-- 页面信息 -->
			<div class="nowrap left">
				<div class="txt_title_nosearch">
					手动静态化 &gt; 静态化html预览及编辑
				</div>
			</div>
			<div class="clr">
				&nbsp;
			</div>
		</div>
		<form id="infoForm" name="infoForm">
			<div class="settingtable">
				<div class="settingtd settingDiv no_bt no_bb">
				<s:hidden name="page" value="%{page}" />
				<s:hidden name="webStatictask.statictaskid" value="%{webStatictask.statictaskid}"/>
				<s:textarea name="contentHtml" id="contentHtml" cols="80" rows="10" />
			       <script type="text/javascript"> 
						                        CKEDITOR.replace( 'contentHtml',
						                                {       height:340,
						                                        skin : 'office2003',
						                                       toolbar : [   
						    ['Source','-','Preview','-','Templates'],  
						    ['Cut','Copy','Paste','PasteText','PasteFromWord','-','Undo','Redo'],   
						    ['Find','Replace','-','SelectAll','SpellChecker','Scayt'],  ['uppic','upswf','upfile'], 
						    '/',   
						    ['Bold','Italic','Underline','Strike','-','Subscript','Superscript','-','RemoveFormat'],   
						    ['NumberedList','BulletedList','-','Outdent','Indent','Blockquote'],   
						    ['JustifyLeft','JustifyCenter','JustifyRight','JustifyBlock'],   
						    ['Link','Unlink','Anchor'],   
						    ['Image','Flash','Table','HorizontalRule','Smiley','SpecialChar', 'PageBreak'],   
						    ['TextColor','BGColor'],
						    '/',   
						    ['Styles','Format','Font','FontSize']
						  ]  
						                                });
				  </script>
				</div>
			</div>
		</form>
	</body>
</html>
