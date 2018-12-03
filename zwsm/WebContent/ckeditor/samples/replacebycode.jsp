<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<!--
Copyright (c) 2003-2013, CKSource - Frederico Knabben. All rights reserved.
For licensing, see LICENSE.html or http://ckeditor.com/license
-->
<html>
<head>
	<title>Replace Textarea by Code &mdash; CKEditor Sample</title>
	<meta charset="utf-8">
	<script src="../ckeditor.js"></script>
	<script src="../ckuploader.js"></script>
	<link rel="stylesheet" type="text/css" href="super/css/style.css" />
	<link rel="stylesheet" type="text/css" href="super/css/images/simple/getcss.css" />
	<link rel="stylesheet" type="text/css" href="super/css/formInfo.css" />
	<link rel="stylesheet" type="text/css" href="super/common/formValidator/validationEngine.jquery.css" />
	<link rel="stylesheet" type="text/css" href="super/common/jqueryUi/css/ui.all.css"  />
	<link rel="stylesheet" type="text/css" href="super/common/uploadify/uploadify.css" />
	<link rel="stylesheet" type="text/css" href="super/common/ztree/css/zTreeStyle.css" />
	<link rel="stylesheet" type="text/css" href="super/common/flexigrid/css/flexigrid.css" />
	<script type="text/javascript" src="super/common/datePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="super/js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="super/common/jqueryUi/jquery-ui-1.7.2.min.js"></script>
	<script type="text/javascript" src="super/js/jquery.form.js"></script>
	<script type="text/javascript" src="super/js/commpage.js"></script>
	<script type="text/javascript" src="super/common/formValidator/jquery.validationEngine-reg.js"></script>
	<script type="text/javascript" src="super/common/formValidator/jquery.validationEngine.js"></script>
	<script type="text/javascript" src="super/common/uploadify/jquery.uploadify-3.1.min.js"></script>
	<script type="text/javascript" src="super/common/ztree/js/jquery.ztree.all-3.0.min.js"></script>
	<script type="text/javascript" src="super/common/flexigrid/flexigrid.js"></script>
	<link href="sample.css" rel="stylesheet">
</head>
<body>
	<h1 class="samples">
		<a href="index.html">CKEditor Samples</a> &raquo; Replace Textarea Elements Using JavaScript Code
	</h1>
	<form action="sample_posteddata.php" method="post">
		<div class="description">
			<p>
				This editor is using an <code>&lt;iframe&gt;</code> element-based editing area, provided by the <strong>Wysiwygarea</strong> plugin.
			</p>
<pre class="samples">
</pre>
		</div>
		<textarea cols="80" id="editor1" name="editor1" rows="10">
			
		</textarea>
		<script>

			// This call can be placed at any point after the
			// <textarea>, or inside a <head><script> in a
			// window.onload event handler.

			// Replace the <textarea id="editor"> with an CKEditor
			// instance, using default configurations.

			CKEDITOR.replace( 'editor1',{		
			                        height:340, 
                                    toolbar : 'iToolbar'
	                            });

		</script>
		<p>
			<input type="submit" value="Submit">
			<s:file name="shit">
			</s:file>
		</p>
	</form>
	<div id="footer">
		<hr>
		<p>
			CKEditor - The text editor for the Internet - <a class="samples" href="http://ckeditor.com/">http://ckeditor.com</a>
		</p>
		<p id="copy">
			Copyright &copy; 2003-2013, <a class="samples" href="http://cksource.com/">CKSource</a> - Frederico
			Knabben. All rights reserved.
		</p>
	</div>
</body>
</html>
