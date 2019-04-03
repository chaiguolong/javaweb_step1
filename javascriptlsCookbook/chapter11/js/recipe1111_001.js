window.onload=function(){
	try {
		var cells = document.querySelectorAll("tr:nth-child(3) td");
	} catch (e) {
		var tableElement = document.getElementById("thetable");
		var trs = tableElement.getElementsByTagName("tr");
		var cells = trs[2].getElementsByTagName("td");
	}

	var sum = 0;
	for (var i = 0, len = cells.length; i < len; i++) {
		var val = parseFloat(cells[i].firstChild.data);
		if(!isNaN(val)){
			sum += val;
		}
	}

	alert("sum " + sum);

}
