/**
 * @license Copyright (c) 2003-2013, CKSource - Frederico Knabben. All rights reserved.
 * For licensing, see LICENSE.html or http://ckeditor.com/license
 */

CKEDITOR.editorConfig = function( config ) {
	// Define changes to default configuration here. For example:
	// config.language = 'fr';
	// config.uiColor = '#AADC6E';
	config.width = 680; //设置编辑器的宽度
	config.height = 500;//设置编辑器的高度
	config.extraPlugins = 'uppic,upswf,upfile,upaudio';
	config.toolbar_iToolbar = [
			['Source','-','NewPage', 'Preview', 'Print','-','Templates'],  
		    ['Cut','Copy','Paste','PasteText','PasteFromWord','-','Undo','Redo'],   
		    ['Find','Replace','-','SelectAll','SpellChecker','Scayt'],
		    '/',
		    [ 'Form', 'Checkbox', 'Radio', 'TextField', 'Textarea', 'Select', 'Button', 'ImageButton', 'HiddenField' ],
		    ['uppic','upswf','upfile','upaudio'], 
		    '/',
		    ['Bold','Italic','Underline','Strike','-','Subscript','Superscript','-','RemoveFormat'],   
		    [ 'NumberedList', 'BulletedList', '-', 'Outdent', 'Indent', '-', 'Blockquote', 'CreateDiv', '-', 'JustifyLeft', 'JustifyCenter', 'JustifyRight', 'JustifyBlock', '-', 'BidiLtr', 'BidiRtl' ],   
		    ['Link','Unlink','Anchor'], ['Table','HorizontalRule','Smiley','SpecialChar', 'PageBreak'],
		    ['TextColor','BGColor'],
		    '/',   
		    ['Styles','Format','Font','FontSize'],
		    [ 'Maximize', 'ShowBlocks' ]
	]
};
