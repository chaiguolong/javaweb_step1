window.onload=function(){



	var dt = new Date();

	var mnth = dt.getUTCMonth();

	mnth++;

	var day = dt.getUTCDate();

	if(day < 10){
		day = "0" + day;
	}

	var yr = dt.getUTCFullYear();

	var hrs = dt.getUTCHours();
	if (hrs < 10){
		hrs = "0"+hrs;
	}

	var min = dt.getUTCMinutes();

	if(min < 10){
		min = "0" + min;
	}

	var secs = dt.getUTCSeconds();

	if(secs < 10){
		secs = "0" + secs;
	}

	var newdate = yr + "-" + mnth + "-" + day + "T" + hrs + ":" + min + ":" + secs + "Z";
	alert(newdate);



}
