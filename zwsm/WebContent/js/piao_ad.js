//图片地址
var hbcms_img_src = '/images/psd.jpg';

//连接的网址
var hbcms_img_url = 'http://www.zgzbh.com/';

//图片宽度
var hbcms_img_w = '100';

//图片高度
var hbcms_img_h = '100';

//鼠标移动到图片上显示的文字
var hbcms_img_alt = '透明售房网';

document.write('<div id="piao_dd" style="Z-INDEX: 99999; WIDTH: '+hbcms_img_w+'px; POSITION: absolute; HEIGHT: '+hbcms_img_h+'px"> <a href="'+hbcms_img_url+'" target="_blank"><img src="'+hbcms_img_src+'" width="'+hbcms_img_w+'" height="'+hbcms_img_h+'" border="0" alt="'+hbcms_img_alt+'" title="' + hbcms_img_alt + '" onMouseOver="pause_resume();" onMouseOut="pause_resume();"></a>' +
		'<div style="position:absolute; right:0; top:0;"><a href="javascript:close_piao_dd();" title="关闭" onmouseover="pause_resume();" onmouseout="pause_resume();" style="color:#000; font-weight:bold;"><b>×</b></a></div>'
		+ '</div> ');

var xPos = 100; // 起始横向位置(从左算起，单位象素) 
var yPos = $('body').height();//attr('clientHeight'); // 页面本身高度 
var step = 1; 
var delay = 30; // 速度，值越大速度越慢 
var height = 0; 
var Hoffset = 0; 
var Woffset = 0; 
var yon = 0; 
var xon = 0; 
var pause = true; 
var interval; 
piao_dd.style.top = yPos; 

function hbcms_changePos() { 
	width = $(window).width();// 判断浏览器窗口的宽度
	height = $(window).height();// 判断浏览器窗口的高度 
	Hoffset = $('#piao_dd').get(0).offsetHeight;
	Woffset = $('#piao_dd').get(0).offsetWidth;
	
	$('#piao_dd').css('left', xPos + $('body').scrollLeft());
	$('#piao_dd').css('top', yPos + $('body').scrollTop());
	
	if (yon) { 
		yPos = yPos + step; 
	} 
	else { 
		yPos = yPos - step; 
	} 
	if (yPos < 0) { 
		yon = 1; 
		yPos = 0; 
	} 
	if (yPos >= (height - Hoffset)) { 
		yon = 0; 
		yPos = (height - Hoffset); 
	} 
	if (xon) { 
		xPos = xPos + step; 
	} 
	else { 
		xPos = xPos - step; 
	} 
	if (xPos < 0) { 
		xon = 1; 
		xPos = 0; 
	} 
	if (xPos >= (width - Woffset)) { 
		xon = 0; 
		xPos = (width - Woffset); 
	} 
} 

function hbcms_start_pp() { 
	piao_dd.visibility = "visible"; 
	interval = setInterval('hbcms_changePos()', delay); 
} 
function pause_resume() { 
	if(pause) {clearInterval(interval);pause = false;} 
	else {interval = setInterval('hbcms_changePos()',delay);pause = true;} 
} 
function close_piao_dd(){
	clearInterval(interval);
	pause = false;
	$('#piao_dd').remove();
}
hbcms_start_pp();