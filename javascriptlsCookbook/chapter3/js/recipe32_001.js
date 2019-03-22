window.onload=function(){

	var dateElement = document.getElementById("date");
	var today = new Date();
	var utcDate = today.toUTCString();
	dateElement.innerHTML = "<p>local datetime: "+today+" UTC datetime: "+ utcDate+"</p>";
}
