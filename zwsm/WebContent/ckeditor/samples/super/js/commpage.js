function GetForContentWidth() {
	if (navigator.userAgent.match(/MSIE ([\d.]+)/)) {
		if (navigator.appVersion.split(";")[1].replace(/[ ]/g, "") == "MSIE8.0") {
			$("#forContentWidth").width('100%');
			$("#forContentWidth").width($("#forContentWidth").width() - 13);
		}
		else if(navigator.appVersion.split(";")[1].replace(/[ ]/g, "") == "MSIE7.0"){
			$("#forContentWidth").width('100%');
			$("#forContentWidth").width($("#forContentWidth").width() - 13);
		}
		else if(navigator.appVersion.split(";")[1].replace(/[ ]/g, "") == "MSIE9.0"){
			$("#forContentWidth").width('100%');
			$("#forContentWidth").width($("#forContentWidth").width() - 25);
		}
		else {
			$("#forContentWidth").width('100%');
			$("#forContentWidth").width($("#forContentWidth").width() - 6);
		}
	} else {
		$("#forContentWidth").width('100%');
		$("#forContentWidth").width($("#forContentWidth").width() - 25);
	}
}

