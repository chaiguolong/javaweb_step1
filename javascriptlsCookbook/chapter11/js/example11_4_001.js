window.onload=function(){
	var table = document.querySelector("table");
	table.onclick=sum;
}

function sum(){
	var rows = document.getElementById("sumtable").getElementsByTagName("tr");
	var sum = 0;

	for (var i = 1, len = rows.length; i < len; i++) {
		sum += parseFloat(rows[i].childNodes[2].firstChild.data);
	}

	alert(sum);
}
