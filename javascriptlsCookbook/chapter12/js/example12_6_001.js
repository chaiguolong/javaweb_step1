window.onload=function(){
	var values = new Array(3);
	values[0] = [123.45, "apple", true];
	values[1] = [65, "banana", false];
	values[2] = [1034.99, "cherry", false];

	var mixed = document.getElementById("mixed");

	var tbody = document.createElement("tbody");

	for (var i = 0, len = values.length; i < len; i++) {
		var tr = document.createElement("tr");

		for (var j = 0, len = values[i].length; j < len; j++) {
			var td = document.createElement("td");
			var txt = document.createTextNode(values[i][j]);
			td.appendChild(txt);
			tr.appendChild(td);
		}

		tr.onclick=prunerow;

		tbody.appendChild(tr);
		mixed.appendChild(tbody);
	}
}

function prunerow(){
	var parent = this.parentNode;
	var oldrow = parent.removeChild(this);

	var dataString = "";
	for (var i = 0, len = oldrow.childNodes.length; i < len; i++) {
		var cell = oldrow.childNodes[i];
		dataString += cell.firstChild.data + " ";
	}
	alert("remvoed " + datastring);
}
