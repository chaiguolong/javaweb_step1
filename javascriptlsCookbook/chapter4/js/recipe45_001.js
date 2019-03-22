window.onload=function(){
	var rows = document.getElementById("table1").children[0].rows;
	var numArray = new Array();

	for (var i = 0, len = rows.length; i < len; i++) {
		numArray[numArray.length] = parseInt(rows[i].cells[1].firstChild.data);
	}

	alert(numArray.toString());
}
