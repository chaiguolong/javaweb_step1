window.onload=function(){
	document.getElementById("next").onclick=nextPanel;

	var hash = window.location.hash.split("#")[1];
	switch (hash){
		case "one":
			functionOne();
			break;
		case "two":
			functionOne();
			functionTwo();
			break;
		case "three":
			functionOne();
			functionTwo();
			functionThree();
	}
}

function nextPanel(){
	var classNm = this.getAttribute("class");

	switch(classNm){
		case "zero":
			functionOne();
			break;
		case "one":
			functionTwo();
			break;
		case "two":
			functionThree();
	}
}

function setPage(page){
	document.getElementById("next").setAttribute("class",page);

	var link = document.getElementById("link");
	var path = location.protocol + "//" + location.hostname + "/" + location.pathname + "#" + page;
	link.innerHTML = "<p><a href='"+ path  +"'></a></p>";
}

function functionOne(){
	var square = document.getElementById("square");
	square.style.backgroundColor="#f00";
	square.style.width="200px";
	square.style.height="200px";
	square.style.padding="10px";
	square.style.margin="20px";
	setPage("one");
}

function functionTwo(){
	var square = document.getElementById("square");
	square.style.backgroundColor="#ff0";
	square.style.position="absolute";
	square.style.left="200px";
	setPage("two");
}

function functionThree(){
	var square = document.getElementById("square");
	square.style.width="400px";
	square.style.height="400px";
	square.style.backgroundColor="#0f0";
	square.style.left="400px";
	setPage("three");
}
