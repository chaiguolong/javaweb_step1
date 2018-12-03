(function() {
	// Section 1 : 按下自定义按钮时执行的代码
	var a = {
		exec : function(editor) {
			editorCon = editor;
			initUpFile('pic');
			// InitUpFile(CallbackFun,FTYPE,Size,WH,ShowPic);
		}
	},
	// Section 2 : 创建自定义按钮、绑定方法
	b = 'uppic';
	CKEDITOR.plugins.add(b, {
		init : function(editor) {
			editor.addCommand(b, a);
			editor.ui.addButton('uppic', {
				label : '\u4e0a\u4f20\u56fe\u7247',
				icon : this.path + 'uppic.gif',
				command : b
			});
		}
	});
})();