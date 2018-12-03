(function() {
	var a = {
		exec : function(editor) {
			editorCon = editor;
			initUpFile("file");
			// "editorCon.insertHtml('<a
			// href=\"'+UpFilesGetPicUrl()+'\">'+UpFilesGetName()+'</a>');"
		}
	},
	// Section 2 : 创建自定义按钮、绑定方法
	b = 'upfile';
	CKEDITOR.plugins.add(b, {
		init : function(editor) {
			editor.addCommand(b, a);
			editor.ui.addButton('upfile', {
				label : '\u4e0a\u4f20\u9644\u4ef6',
				icon : this.path + 'upfile.gif',
				command : b
			});
		}
	});
})();