<!--
/*
var xPos = 20;
var yPos = 0; //document.body.clientHeight;
var step = 1;
var delay = 30; 
var height = 0;
var Hoffset = 0;
var Woffset = 0;
var yon = 0;
var xon = 0;
var pause = true;
var interval;
var img = document.all.clip;

img.style.top = yPos;
function changePos() {
width = document.body.clientWidth;
height = document.body.clientHeight;
Hoffset = img.offsetHeight;
Woffset = img.offsetWidth;
img.style.left = xPos + document.body.scrollLeft;
img.style.top = yPos + document.body.scrollTop;
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
function start() {
img.style.visibility = "visible";
interval = setInterval('changePos()', delay);
}
start();
*/

var xPos = 300;
var yPos = 200; 
var step = 1;
var delay = 30; 
var height = 0;
var Hoffset = 0;
var Woffset = 0;
var yon = 1;
var xon = 1;
var pause = true;
var interval;
var img = document.all.clip;
img.style.top = yPos;
function changePos() 
{
	width = document.documentElement.clientWidth;
	height = document.documentElement.clientHeight;
	Hoffset = img.offsetHeight;
	Woffset = img.offsetWidth;
	img.style.left = xPos + document.documentElement.scrollLeft;
	img.style.top = yPos + document.documentElement.scrollTop;
	if (yon) 
		{yPos = yPos + step;}
	else 
		{yPos = yPos - step;}
	if (yPos < 0) 
		{yon = 1;yPos = 0;}
	if (yPos >= (height - Hoffset)) 
		{yon = 0;yPos = (height - Hoffset);}
	if (xon) 
		{xPos = xPos + step;}
	else 
		{xPos = xPos - step;}
	if (xPos < 0) 
		{xon = 1;xPos = 0;}
	if (xPos >= (width - Woffset)) 
		{xon = 0;xPos = (width - Woffset);   }
	}
	
	function start()
	 {
	 	img.visibility = "visible";
		interval = setInterval('changePos()', delay);
	}
	function pause_resume() 
	{
		if(pause) 
		{
			clearInterval(interval);
			pause = false;}
		else 
		{
			interval = setInterval('changePos()',delay);
			pause = true; 
			}
		}
	start();
	
	function close_clip(){
    clip.style.visibility='hidden';
}
	function close_sus1(){
    sus1.style.visibility='hidden';
}
	function close_sus2(){
    sus2.style.visibility='hidden';
}


//-->
