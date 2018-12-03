(function() {
	var a = {
		exec : function(editor) {
			editorCon = editor;
			initUpFile("audio");
			// "editorCon.insertHtml('<object
			// classid=\"clsid:6BF52A52-394A-11d3-B153-00C04F79FAA6\"
			// height=\"44\" width=\"100%\"><param name=\"AutoStart\"
			// value=\"1\"><param name=\"PlayCount\" value=\"1\"><param
			// name=\"EnableContextMenu\" value=\"1\"><param name=\"Volume\"
			// value=\"100\"><param name=\"url\"
			// value=\"'+UpFilesGetPicUrl()+'\"><embed allowscan=\"1\"
			// autostart=\"1\" enablecontextmenu=\"0\" height=\"44\"
			// name=\"MediaPlayer\" playcount=\"1\" showcontrols=\"1\"
			// src=\"'+UpFilesGetPicUrl()+'\" type=\"video/x-ms-wmv\"
			// width=\"100%\"></object>');"
		}
	},
	// Section 2 : 创建自定义按钮、绑定方法
	b = 'upaudio';
	CKEDITOR.plugins.add(b, {
		init : function(editor) {
			editor.addCommand(b, a);
			editor.ui.addButton('upaudio', {
				label : '\u4e0a\u4f20\u9644\u4ef6',
				icon : this.path + 'upaudio.gif',
				command : b
			});
		}
	});
})();