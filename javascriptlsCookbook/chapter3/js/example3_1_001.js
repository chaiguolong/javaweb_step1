window.onload=function(){
	document.getElementById("dateSubmit").onclick=convertDate;
}

function convertDate(){
	var dtstr = document.getElementById("datestring").value;
	var convdate = convertISO8601toDate(dtstr);
	document.getElementById("result").innerHTML=convdate;
}

function convertISO8601toDate(dtstr){
	dtstr = dtstr.replace(/\D/g," ");

	dtstr = dtstr.replace(/\s+$/,"");

	var dtcomps = dtstr.split(" ");

	if(dtcomps.length < 3){
		return "invalid date";
	}

	if(dtcomps.length <4){
		dtcomps[3] = 0;
		dtcomps[4] = 0;
		dtcomps[5] = 0;
	}

	dtcomps[1]--;

	var convdt = new Date(Date.UTC(dtcomps[0],dtcomps[1],dtcomps[2],dtcomps[3],dtcomps[4],dtcomps[5]));
	return convdt.toUTCString();
}
