window.onload=function(){
	var sum = 0;

	var dataTable = document.getElementById("table1");

	var cells = document.querySelectorAll("td + td");

	for (var i = 0, len = cells.length; i < len; i++) {
		sum += parseFloat(cells[i].firstChild.data);
	}

	var newRow = document.createElement("tr");

	var firstCell = document.createElement("td");

	var firstCellText = document.createTextNode("Sum:");

	firstCell.appendChild(firstCellText);

	newRow.appendChild(firstCell);

	var secondCell = document.createElement("td");
	var secondCellText = document.createTextNode(sum);
	secondCell.appendChild(secondCellText);
	newRow.appendChild(secondCell);

	dataTable.appendChild(newRow);


	

}
