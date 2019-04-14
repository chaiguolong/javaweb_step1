function Tune(song,artist){
	var title = song;
	var artist = artist;
	this.concat = function(){
		return title + " " + artist;
	}
}

window.onload=function(){
	var happySong = new Tune("Putting on the Ritz","Ella Fitzgerald");

	Tune.prototype.addCategory = function(categoryName){
		this.category = categoryName;
	}

	happySong.addCategory("Swing");

	var song = "Title and artist: " + happySong.concat() + " Category: " + happySong.category;

	var p = document.createElement("p");
	var txt = document.createTextNode(song);
	p.appendChild(txt);
	document.getElementById("song").appendChild(p);
}
