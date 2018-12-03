(function() {
	var a = {
		exec : function(editor) {
			editorCon = editor;
			initUpFile("swf");
			// "editorCon.insertHtml('<embed
			// pluginspage=\"http://www.macromedia.com/go/getflashplayer\"
			// quality=\"high\" src=\"'+UpFilesGetPicUrl()+'\"
			// type=\"application/x-shockwave-flash\"></embed>');"
		}
	},
	// Section 2 : 创建自定义按钮、绑定方法
	b = 'upswf';
	CKEDITOR.plugins.add(b, {
		init : function(editor) {
			editor.addCommand(b, a);
			editor.ui.addButton('upswf', {
				label : '\u4e0a\u4f20flash',
				icon : this.path + 'upswf.gif',
				command : b
			});
		}
	});
})();