function size(){
	var wdth = 0;
	var hth = 0;

	if(!window.innerWidth){
		wdth = (document.documentElement.clientWidth ? document.documentElement.clientWidth : document.body.clientWidth);
		hth = (document.documentElement.clientHeight ? document.documentElement.clientHeight : document.body.clientHeight);
	}else{
		wdth = window.innerWidth;
		hth = window.innerHeight;
	}

	return {width:wdth, height:hth};
}

window.onload=function(){
	var windowSize = size();
	alert("width is  " + windowSize.width + " height is " + windowSize.height);
}
