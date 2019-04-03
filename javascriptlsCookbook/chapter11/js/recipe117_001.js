window.onload=function(){
	document.getElementById("pink").onclick=paintPink;
	document.getElementById("blue").onclick=paintBlue;
	document.getElementById("green").onclick=paintGreen;
}

function paintPink(){
	try {
		var lis = document.querySelectorAll("li:nth-child(2n+1)");
		for (var i = 0, len = lis.length; i < len; i++) {
			lis[i].setAttribute("style","background-color:#fee");
		}
	} catch (e) {
		alert("Doesn't work in this browser");
	}
}

function paintBlue(){
	try {
		var lis = document.querySelectorAll("li:nth-child(odd)");
		for (var i = 0, len = lis.length; i < len; i++) {
			lis[i].setAttribute("style","background-color:#eef");
		}
	} catch (e) {
		alert("Doesn't work in this browser");
	}
}


function paintGreen(){
	var parentElement = document.getElementById("thelist");
	var lis = parentElement.getElementsByTagName("li");
	for (var i = 0, len = lis.length; i < len; i++) {
		if(i % 2 == 0){
			lis[i].setAttribute("style","background-color:#eeffee");
		}
	}
}


